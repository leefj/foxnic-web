package org.github.foxnic.web.dataperm.service.impl;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.dataperm.DataPermContext;
import com.github.foxnic.dao.entity.Entity;
import org.github.foxnic.web.domain.dataperm.MemberItem;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;

public class ContextBrowser {

    private static final ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    private DataPermContext context;

    private  List<ZTreeNode> roots;

    public ContextBrowser(DataPermContext context) {
        this.context=context;
    }

    public void init() {
        initMembers();
    }

    private void initMembers() {

        List<MemberItem> list=new ArrayList<>();
        Class topType=context.getClass();

        MemberItem top=new MemberItem();
        top.setName("context");
        top.setFullName("context");
        top.setValue(context);


        this.collectMembers(top,topType,list);

        Map<String, ZTreeNode> map=new HashMap<>();
        List<ZTreeNode> nodes=new ArrayList<>();
        for (MemberItem p : list) {
            ZTreeNode node=new ZTreeNode();
            node.setId(p.getFullName());
            node.setName(p.getName());
            if(p.getParent()!=null) {
                node.setParentId(p.getParent().getFullName());
            }
            map.put(node.getId(),node);
            nodes.add(node);
        }

        roots=new ArrayList<>();

        ZTreeNode root=new ZTreeNode();
        root.setId(topType.getName());
        root.setName(topType.getName());
        root.setOpen(true);

        Set<List<ZTreeNode>> childrens=new HashSet<>();
        for (ZTreeNode node : nodes) {
            ZTreeNode parent=map.get(node.getParentId());
            if(parent==null) {
                root.addChild(node);
                childrens.add(root.getChildren());
                continue;
            }
            parent.addChild(node);
            childrens.add(parent.getChildren());
            parent.setIsParent(true);
        }
        roots.add(root);

        for (List<ZTreeNode> children : childrens) {
            children.sort(new Comparator<ZTreeNode>() {
                @Override
                public int compare(ZTreeNode o1, ZTreeNode o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
        }

    }


    private boolean excludeMethod(MemberItem parent, Class type,Method method) {
        if("finalize".equals(method.getName())) return true;
        return false;
    }

    private boolean excludeProperty(MemberItem parent, Class type, Field method) {
        return false;
    }


    private void collectMembers(MemberItem parent, Class type, List<MemberItem> list) {
        if(Object.class.equals(type)) return;
        //处理属性
        for (Field field : type.getDeclaredFields()) {

            if(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) continue;
            if(excludeProperty(parent,type,field)) continue;
            //
            MemberItem item=new MemberItem();
            item.setParent(parent);
            item.setName(field.getName());

            if(parent!=null) {
                item.setFullName(parent.getFullName()+"."+item.getName());
            } else {
                item.setFullName(item.getName());
            }

            Object value= BeanUtil.getFieldValue(parent.getValue(),item.getName());
            item.setValue(value);

            if(DataParser.isSimpleType(field.getType())) {
                item.setName(field.getName()+"="+value);
            } else {
                if(value!=null) {
                    item.setName(field.getName() + "@" + value.hashCode());
                } else {
                    item.setName(field.getName()+"=null");
                }
            }


            if(field.getType().equals(List.class)) {

            }

            else if(value instanceof SessionUser) {
                collectMembers(item,field.getType(),list);
            }
            else if(ReflectUtil.isSubType(Entity.class,field.getType())) {
                collectMembers(item,field.getType(),list);
            }


            list.add(item);



        }



        for (Method method : type.getDeclaredMethods()) {
            if(Modifier.isStatic(method.getModifiers()) || Modifier.isFinal(method.getModifiers())) continue;
            if(excludeMethod(parent,type,method)) continue;

            //
            Parameter[] params = method.getParameters();
            String[] paramNames = parameterNameDiscoverer.getParameterNames(method);

            if(paramNames==null) {
                System.out.println();
            }
            List<String> paramList=new ArrayList<>();
            for (int i = 0; i < params.length; i++) {
                paramList.add(params[i].getType().getSimpleName()+" "+paramNames[i]);
            }

            MemberItem item=new MemberItem();
            item.setParent(parent);
            item.setMethodName(method.getName());
            item.setName(method.getName()+"("+ StringUtil.join(paramList,", ") +")");

            if(parent!=null) {
                item.setFullName(parent.getFullName()+"."+item.getMethodName());
            } else {
                item.setFullName(item.getMethodName());
            }

            list.add(item);

        }



        // 搜集父类成员
        type=type.getSuperclass();
        if(type!=null && !type.equals(Object.class)) {
            collectMembers(parent,type,list);
        }


    }

    public List<ZTreeNode> getRoots() {
        return roots;
    }


}
