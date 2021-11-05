package org.github.foxnic.web.dataperm.service.impl;

import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.dataperm.DataPermContext;
import org.github.foxnic.web.domain.dataperm.MemberItem;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
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
        top.setExpr("context");
        top.setValue(context);

        this.methodKeys.clear();
        this.collectMembers(top,topType,list);

        Map<String, ZTreeNode> map=new HashMap<>();
        List<ZTreeNode> nodes=new ArrayList<>();
        for (MemberItem p : list) {
            ZTreeNode node=new ZTreeNode();
            node.setId(p.getFullName());
            node.setName(p.getName());
            node.setData(p.getExpr());
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
        String methodName=method.getName();
        if("testExpr".equals(methodName)) return true;
        if(methodName.startsWith("set")) {
            Character c4=methodName.charAt(3);
            if(Character.isUpperCase(c4)) {
                return true;
            }
        }
        if(methodName.startsWith("add")) {
            Character c4=methodName.charAt(3);
            if(Character.isUpperCase(c4)) {
                return true;
            }
        }
        if(methodName.startsWith("init") && methodName.length()>4) {
            Character c4=methodName.charAt(4);
            if(Character.isUpperCase(c4)) {
                return true;
            }
        }

        if("getEnv".equals(parent.getMethodName())) {
            if (methodName.equals("init") || methodName.equals("ready")) {
                return true;
            }
        }

        if("getSession".equals(parent.getMethodName())) {
            if (methodName.equals("eraseCredentials")) {
                return true;
            }
        }

        if("getCompositeParameter".equals(parent.getMethodName())) {
            if (methodName.equals("spliterator") || methodName.equals("iterator") || methodName.equals("forEach")) {
                return true;
            }
        }

        if("permission".equals(parent.getMethodName())) {
            if (methodName.equals("getSessionUser") || methodName.equals("check") || methodName.equals("getConfigAttributesByMatcher")  || methodName.equals("getRoleByMatcher")) {
                return true;
            }
        }


        if("toPO".equals(methodName) || "toPojo".equals(methodName)) {
            return true;
        }
        return false;
    }

    private boolean excludeProperty(MemberItem parent, Class type, Field method) {
        return false;
    }


    private Set<String> methodKeys=new HashSet<>();

    private void collectMembers(MemberItem parent, Class type, List<MemberItem> list) {
        if(type.getName().startsWith("java.")) return;
//        //处理属性
//        for (Field field : type.getDeclaredFields()) {
//
//            if(Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) continue;
//            if(excludeProperty(parent,type,field)) continue;
//            //
//            MemberItem item=new MemberItem();
//            item.setParent(parent);
//            item.setName(field.getName());
//
//            if(parent!=null) {
//                item.setFullName(parent.getFullName()+"."+item.getName());
//            } else {
//                item.setFullName(item.getName());
//            }
//            //获得值
//            Object value= BeanUtil.getFieldValue(parent.getValue(),item.getName());
//            item.setValue(value);
//
//            //处理值
//            if(DataParser.isSimpleType(field.getType())) {
//                item.setName(field.getName()+"="+value);
//            } else {
//                if(value!=null) {
//                    item.setName(field.getName() + "@" + value.hashCode());
//                } else {
//                    item.setName(field.getName()+"=null");
//                }
//            }
//
//            list.add(item);
//
//            if(value==null) continue;
//
//
//            if(value instanceof List) {
//
//            }
//            else if(value instanceof SessionUser) {
//                collectMembers(item,SessionUser.class,list);
//            }
//            else if(value instanceof Entity) {
//                collectMembers(item,value.getClass(),list);
//            }
//        }


        boolean isGetter=false;
        Object value=null;
        for (Method method : type.getDeclaredMethods()) {
            if(method.getName().equals("checkAnyRole")) {
                System.out.println();
            }
            if(Modifier.isStatic(method.getModifiers()) || Modifier.isFinal(method.getModifiers())) continue;
            if(excludeMethod(parent,type,method)) continue;
            int loc=method.toGenericString().lastIndexOf('(');

            String p=method.toGenericString().substring(0,loc);
            String sign=method.toGenericString().substring(loc);
            loc=p.lastIndexOf('.');
            if(loc==-1) {
                System.out.println();
            }
            p=p.substring(loc);

            sign=parent.getFullName()+p+sign;
            if(methodKeys.contains(sign)) continue;
            isGetter=false;
            if(method.getParameterCount()==0) {
                if (method.getName().startsWith("get")) {
                    Character c4 = method.getName().charAt(3);
                    if (Character.isUpperCase(c4)) {
                        isGetter = true;
                    }
                }
                if (method.getName().startsWith("is")) {
                    Character c4 = method.getName().charAt(2);
                    if (Character.isUpperCase(c4)) {
                        isGetter = true;
                    }
                }
            }

            if(isGetter) {
                try {
                    value=method.invoke(parent.getValue());
                } catch (Exception e) {
                    throw new RuntimeException("get value error");
                }
            }

            if("getSession".equals(parent.getMethodName())) {
                if (method.getName().equals("permission")) {
                    isGetter=true;
                    try {
                        value=method.invoke(parent.getValue());
                    } catch (Exception e) {
                        throw new RuntimeException("get value error");
                    }
                }
            }


            if(isGetter && value!=null && (value instanceof List || value instanceof Map || value instanceof Set)) {
                continue;
            }


            //
            Parameter[] params = method.getParameters();
            String[] paramNames = parameterNameDiscoverer.getParameterNames(method);

            if(params!=null && params.length>0 && paramNames==null) {
                System.out.println();
            }

            List<String> paramList=new ArrayList<>();
            for (int i = 0; i < params.length; i++) {
                paramList.add(params[i].getType().getSimpleName()+" "+paramNames[i]);
            }

            MemberItem item=new MemberItem();
            item.setParent(parent);
            item.setValue(value);
            item.setMethodName(method.getName());
            item.setName(method.getName()+"("+ StringUtil.join(paramList,", ") +")");

            if(parent!=null) {
                item.setFullName(parent.getFullName()+"."+item.getMethodName());
                item.setExpr(parent.getExpr()+"."+item.getName());
            } else {
                item.setFullName(item.getMethodName());
                item.setExpr(item.getName());
            }




            if(isGetter) {
                if (value == null) {
                    item.setName(item.getName() + " = null");
                } else {
                    if (DataParser.isSimpleType(value.getClass())) {

                        if(value instanceof CharSequence) {
                            item.setName(item.getName() + " = '" + value+"'");
                        } else {
                            item.setName(item.getName() + " = " + value);
                        }

                    } else {
                        collectMembers(item, value.getClass(), list);
                    }
                }
            }


            methodKeys.add(sign);
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
