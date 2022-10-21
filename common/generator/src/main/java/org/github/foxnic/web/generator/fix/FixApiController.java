package org.github.foxnic.web.generator.fix;

import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.commons.compiler.source.ControllerCompilationUnit;
import com.github.foxnic.commons.io.FileNavigator;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.generator.builder.business.ControllerProxyFile;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class FixApiController {


    public static void main(String[] args) {

        (new FixApiController()).fixAll();

    }

    private void fixAll() {

        FileNavigator fileNavigator=new FileNavigator("D:\\leefj\\workspace\\git-base\\foxnic-web\\service\\service-hrm");

        fileNavigator.scan((file,isFile,ext)->{
            if(!isFile) return;
            if(ext.equals(".java")) return;
            if(!file.getName().endsWith("Controller.java")) return;
            try {
                fix(file);
            } catch (Throwable e) {
                System.err.println(file.getAbsolutePath());
                Logger.exception(e);
            }
        });

    }

    private void fix(File javaFile) {
        boolean modified=false;
        //
        ControllerCompilationUnit controller=new ControllerCompilationUnit(javaFile,true);
        List<NormalAnnotationExpr> notNulls = controller.find(NormalAnnotationExpr.class);
        for (NormalAnnotationExpr ann : notNulls) {
            if(ann.getName().getIdentifier().equals("NotNull")) {
                ann.getParentNode().get().remove(ann);
                modified=true;
            }
        }
        List<ImportDeclaration> imports = controller.find(ImportDeclaration.class);
        boolean  hasApiParamSupport = false;
        for (ImportDeclaration imp : imports) {
            if(imp.getName().getIdentifier().equals("NotNull")) {
                imp.getParentNode().get().remove(imp);
                modified=true;
            }
            if(imp.getName().getIdentifier().equals("ApiParamSupport")) {
                hasApiParamSupport=true;
            }
        }


        //
        List<MethodDeclaration> methods = controller.find(MethodDeclaration.class);
        for (MethodDeclaration method : methods) {
            if(method.getName().getIdentifier().equals("insert") || method.getName().getIdentifier().equals("update")  || method.getName().getIdentifier().equals("save")) {

                Optional<AnnotationExpr> ann= method.getAnnotationByClass(ApiParamSupport.class);
                if(ann==null || !ann.isPresent()) {
                    NormalAnnotationExpr  apiImplicitParam=new NormalAnnotationExpr();
                    apiImplicitParam.setName("ApiParamSupport");
                    apiImplicitParam.getPairs().add(new MemberValuePair("ignoreDBTreatyProperties", new BooleanLiteralExpr(true)));
                    apiImplicitParam.getPairs().add(new MemberValuePair("ignoreDefaultVoProperties", new BooleanLiteralExpr(true)));
                    if(method.getName().getIdentifier().equals("insert")) {
                        apiImplicitParam.getPairs().add(new MemberValuePair("ignorePrimaryKey", new BooleanLiteralExpr(true)));
                    }
                    method.addAnnotation(apiImplicitParam);

                    if(!hasApiParamSupport) {
                        ImportDeclaration importDeclaration=new ImportDeclaration(ApiParamSupport.class.getName(),false,false);
                        controller.getCompilationUnit().addImport(importDeclaration);
                        hasApiParamSupport=true;
                    }

                    modified=true;

                }
            }
        }


        if(modified) {
            controller.save();
        }
    }


}
