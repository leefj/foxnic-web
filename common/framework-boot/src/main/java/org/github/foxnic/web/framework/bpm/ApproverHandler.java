package org.github.foxnic.web.framework.bpm;

import com.github.foxnic.dao.data.PagedList;
import org.checkerframework.checker.units.qual.K;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.Appover;

import java.util.*;
import java.util.function.Function;

public class ApproverHandler<T> {

    public static interface Setter<T> {
        void set(T item, Appover appover);
    }

    private static class Group<T> {
        private Function<? super T, String> approverType;
        private Function<? super T, String> approverId;
        private Setter<T> setter;
    }

    private List<T> list;
    private List<Group> groups = new ArrayList<>();

    private ApproverHandler(List<T> list) {
        this.list = list;
    }

    /**
     * 准备一个将要填充的集合
     */
    public static <K> ApproverHandler<K> fill(K item) {
        return new ApproverHandler<K>(Arrays.asList(item));
    }

    /**
     * 准备一个将要填充的集合
     */
    public static <K> ApproverHandler<K> fill(List<K> list) {
        return new ApproverHandler<K>(list);
    }

    /**
     * 准备一个将要填充的集合
     */
    public static <K> ApproverHandler<K> fill(PagedList<K> list) {
        return new ApproverHandler<K>(list.getList());
    }

    /**
     * 添加审批人字段配置
     *
     * @param approverType 获得审批人类型的函数
     * @param approverId   获得审批人ID的函数
     * @param setter       设置审批人对象的函数
     */
    public ApproverHandler<T> approver(Function<? super T, String> approverType, Function<? super T, String> approverId, Setter<T> setter) {
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
    public ApproverHandler execute() {
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

        HashMap<String, Appover> appoverMap = new HashMap<>();
        // 按组获得审批人
        for (Map.Entry<String, Set<String>> entry : approverIdMap.entrySet()) {
            UnifiedUserType uuType = UnifiedUserType.parseByCode(entry.getKey());
            IdentityService identityService = IdentityService.getImpl(uuType);
            List<Appover> approvers = identityService.getAppoversById(new ArrayList<>(entry.getValue()));
            for (Appover approver : approvers) {
                appoverMap.put(uuType.code() + "::" + approver.getId(), approver);
            }
        }

        // 设置值
        Appover appover = null;
        for (T t : list) {
            for (Group<T> group : groups) {
                type = group.approverType.apply(t);
                id = group.approverId.apply(t);
                appover = appoverMap.get(type + "::" + id);
                group.setter.set(t, appover);
            }
        }

        return this;
    }


}
