package org.github.foxnic.web.generator.fix;

import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.io.FileNavigator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.generator.builder.business.ControllerProxyFile;
import com.github.foxnic.generator.util.JavaCPUnit;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import org.github.foxnic.web.proxy.job.JobLogServiceProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FixProxy {


//    public static void main(String[] args) {
//        ControllerProxyFile.insertParameterNames(new File("D:\\leefj\\workspace\\git-base\\foxnic-web\\common\\proxy\\src\\main\\java\\org\\github\\foxnic\\web\\proxy\\bpm\\ProcessDefinitionFileServiceProxy.java"));
//    }


    public static void main(String[] args) {
        //FileNavigator fileNavigator=new FileNavigator("D:\\leefj\\workspace\\git-base\\foxnic-web\\common\\proxy");
        FileNavigator fileNavigator=new FileNavigator("D:\\leefj\\workspace\\git-base\\eam\\eam\\common\\proxy");

        fileNavigator.scan((file,isFile,ext)->{
            if(!isFile) return;
            if(ext.equals(".java")) return;
            if(!file.getName().endsWith("ServiceProxy.java")) return;
            System.out.println(file.getAbsolutePath());
            ControllerProxyFile.insertParameterNames(file);
        });
    }



}
