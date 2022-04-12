package org.github.foxnic.web.generator.fix;

import com.github.foxnic.api.proxy.ParameterNames;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.io.FileNavigator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.generator.util.JavaCPUnit;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FixProxy {

    public static void main(String[] args) {
        FileNavigator fileNavigator=new FileNavigator("/Users/LeeFJ/git/foxnic-web/common/proxy");
        fileNavigator.scan((file,isFile,ext)->{
            if(!isFile) return;
            if(ext.equals(".java")) return;
            if(!file.getName().endsWith("ServiceProxy.java")) return;
            System.out.println(file.getAbsolutePath());
            fix(file);
        });
    }

    public static void fix(File javaFile) {

        JavaCPUnit cpUnit = new JavaCPUnit(javaFile);
        CompilationUnit compilationUnit=cpUnit.getCompilationUnit();
        List<ClassOrInterfaceDeclaration> classes = cpUnit.find(ClassOrInterfaceDeclaration.class);
        ClassOrInterfaceDeclaration clz=classes.get(0);
        Optional<AnnotationExpr> feignClient =clz.getAnnotationByClass(FeignClient.class);
        if(!feignClient.isPresent()) return;
        NodeList<ImportDeclaration> imports = compilationUnit.getImports();
        boolean flag=false;
        for (ImportDeclaration imp : imports) {
            if(imp.getNameAsString().equals(ParameterNames.class.getName())) {
                flag=true;
                break;
            }
        }
        if(!flag) {
            compilationUnit.addImport(ParameterNames.class);
        }
        List<MethodDeclaration> list=cpUnit.find(MethodDeclaration.class);
        boolean isModified=false;
        for (MethodDeclaration m : list) {
            Optional<AnnotationExpr> requestMapping =m.getAnnotationByClass(RequestMapping.class);
            Optional<AnnotationExpr> parameterNames =m.getAnnotationByClass(ParameterNames.class);
            if(requestMapping.isPresent() && !parameterNames.isPresent()) {
                NodeList<Parameter> ps=m.getParameters();
                List<String> names= CollectorUtil.collectList(ps,(e)->{return "\""+e.getNameAsString()+"\"";});
                NormalAnnotationExpr expr=m.addAndGetAnnotation("ParameterNames");
                expr.addPair("value","{"+ StringUtil.join(names,",") +"}");
                isModified = true;
            }
        }

        if(isModified) {
            cpUnit.save();
        }

    }

}
