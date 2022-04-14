package org.github.foxnic.web.generator.fix;

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
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FixProxy {


    public static void main(String[] args) {

        fix(new File("/Users/LeeFJ/git/foxnic-web/common/proxy/src/main/java/org/github/foxnic/web/proxy/job/JobLogServiceProxy.java"));

    }


    public static void mainX(String[] args) {
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
            if(imp.getNameAsString().equals(RequestParam.class.getName())) {
                flag=true;
                break;
            }
        }
        if(!flag) {
            compilationUnit.addImport(RequestParam.class);
        }
        List<MethodDeclaration> list=cpUnit.find(MethodDeclaration.class);
        boolean isModified=false;
        for (MethodDeclaration m : list) {

            Optional<AnnotationExpr> requestMapping =m.getAnnotationByClass(RequestMapping.class);
            if(requestMapping==null || !requestMapping.isPresent()) continue;

            //移除
            NodeList<AnnotationExpr> anns= m.getAnnotations();
            for (AnnotationExpr ann : anns) {
               if(ann.getName().asString().equals("ParameterNames")) {
                   anns.remove(ann);
                   break;
               }
            }




            NodeList<Parameter> ps=m.getParameters();
            List<String> names= CollectorUtil.collectList(ps,(e)->{return "\""+e.getNameAsString()+"\"";});
            NormalAnnotationExpr expr=m.addAndGetAnnotation("ParameterNames");
            expr.addPair("value","{"+ StringUtil.join(names,",") +"}");
            isModified = true;

        }

        if(isModified) {
            cpUnit.save();
        }

    }

}
