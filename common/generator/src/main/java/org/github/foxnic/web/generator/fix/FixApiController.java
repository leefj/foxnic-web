package org.github.foxnic.web.generator.fix;

import com.github.foxnic.commons.compiler.source.ControllerCompilationUnit;
import com.github.foxnic.commons.io.FileNavigator;
import com.github.foxnic.generator.builder.business.ControllerProxyFile;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;

import java.io.File;
import java.util.List;

public class FixApiController {


    public static void main(String[] args) {

        (new FixApiController()).fixAll();

    }

    private void fixAll() {

        FileNavigator fileNavigator=new FileNavigator("D:\\leefj\\workspace\\git-base\\foxnic-web\\service\\service-job");

        fileNavigator.scan((file,isFile,ext)->{
            if(!isFile) return;
            if(ext.equals(".java")) return;
            if(!file.getName().endsWith("Controller.java")) return;
            fix(file);
        });

    }

    private void fix(File javaFile) {

        ControllerCompilationUnit controller=new ControllerCompilationUnit(javaFile,true);
        List<NormalAnnotationExpr> notNulls = controller.find(NormalAnnotationExpr.class);
        for (NormalAnnotationExpr ann : notNulls) {
            if(ann.getName().getIdentifier().equals("NotNull")) {
                ann.getParentNode().get().remove(ann);
            }
        }
        List<ImportDeclaration> imports = controller.find(ImportDeclaration.class);
        for (ImportDeclaration imp : imports) {
            if(imp.getName().getIdentifier().equals("NotNull")) {
                imp.getParentNode().get().remove(imp);
            }
        }
        System.out.println(controller.getSource());
    }


}
