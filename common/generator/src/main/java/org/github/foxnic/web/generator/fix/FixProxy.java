package org.github.foxnic.web.generator.fix;

import com.github.foxnic.api.proxy.ParameterNames;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.generator.util.JavaCPUnit;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.AnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

public class FixProxy {

    public static void main(String[] args) {

        JavaCPUnit cpUnit= JavaCPUnit.get(FileServiceProxy.class);
        CompilationUnit compilationUnit=cpUnit.getCompilationUnit();
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
