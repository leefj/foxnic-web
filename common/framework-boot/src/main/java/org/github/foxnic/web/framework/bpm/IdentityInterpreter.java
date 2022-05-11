package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Assignee;

import java.util.*;
import java.util.function.Function;

public class IdentityInterpreter<T> {

    public static interface Setter<T> {
        void set(T item, Assignee assignee);
    }

    private static class Group<T> {
        private Function<? super T, String> approverType;
        private Function<? super T, String> approverId;
        private Setter<T> setter;
    }

    private List<T> list;
    private List<Group> groups = new ArrayList<>();

    private IdentityInterpreter(List<T> list) {
        this.list = list;
    }

    /**
     * 准备一个将要填充的集合
     */
    public static <K> IdentityInterpreter<K> fill(K item) {
        List<K> list=null;
        if(item==null) {
            list=new ArrayList<>();
        } else {
            list=Arrays.asList(item);
        }
        return new IdentityInterpreter<K>(list);
    }

    /**
     * 准备一个将要填充的集合
     */
    public static <K> IdentityInterpreter<K> fill(List<K> list) {
        if(list==null) list = new ArrayList<>();
        return new IdentityInterpreter<K>(list);
    }

    /**
     * 准备一个将要填充的集合
     */
    public static <K> IdentityInterpreter<K> fill(PagedList<K> list) {
        if(list==null) list =new PagedList<>(new ArrayList<>(),0,0,0,0);
        return new IdentityInterpreter<K>(list.getList());
    }

    /**
     * 添加审批人字段配置
     *
     * @param approverType 获得审批人类型的函数
     * @param approverId   获得审批人ID的函数
     * @param setter       设置审批人对象的函数
     */
    public IdentityInterpreter<T> approver(Function<? super T, String> approverType, Function<? super T, String> approverId, Setter<T> setter) {
        Group<T> group = new Group<>();
        group.approverType = approverType;
        group.approverId = approverId;
        group.setter = setter;
        groups.add(group);
        return this;
    }

    /**
     * 执行关联并填充
     */
    public IdentityInterpreter execute() {
        Map<String, Set<String>> approverIdMap = new HashMap<>();
        String id = null, type = null;
        // 按审批人类型对ID进行分类
        for (T t : list) {
            for (Group<T> group : groups) {
                type = group.approverType.apply(t);
                id = group.approverId.apply(t);
                Set<String> ids = approverIdMap.get(type);
                if (ids == null) {
                    ids = new HashSet<>();
                    approverIdMap.put(type, ids);
                }
                ids.add(id);
            }
        }

        HashMap<String, Assignee> appoverMap = new HashMap<>();
        // 按组获得审批人
        for (Map.Entry<String, Set<String>> entry : approverIdMap.entrySet()) {
            UnifiedUserType uuType = UnifiedUserType.parseByCode(entry.getKey());
            IdentityService identityService = IdentityService.getImpl(uuType);
            List<Assignee> assignees = identityService.getAppoversById(new ArrayList<>(entry.getValue()));
            for (Assignee assignee : assignees) {
                appoverMap.put(uuType.code() + "::" + assignee.getId(), assignee);
            }
        }

        // 设置值
        Assignee assignee = null;
        for (T t : list) {
            for (Group<T> group : groups) {
                type = group.approverType.apply(t);
                id = group.approverId.apply(t);
                assignee = appoverMap.get(type + "::" + id);
                group.setter.set(t, assignee);
            }
        }

        return this;
    }


}
