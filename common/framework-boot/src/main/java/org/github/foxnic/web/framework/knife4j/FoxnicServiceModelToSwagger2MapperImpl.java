package org.github.foxnic.web.framework.knife4j;

import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.environment.BrowserType;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import springfox.documentation.service.*;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl;

import java.util.*;

import static java.util.Optional.ofNullable;

public class FoxnicServiceModelToSwagger2MapperImpl  extends ServiceModelToSwagger2MapperImpl {


    public Swagger mapDocumentation(Documentation from) {
        return super.mapDocumentation(from);
    }

    protected Map<String, Path> mapApiListings(Map<String, List<ApiListing>> apiListings) {
        return super.mapApiListings(apiListings);
    }

    /**
     * 逐个处理 API 接口
     * */
    protected io.swagger.models.Operation mapOperation(springfox.documentation.service.Operation from, ModelNamesRegistry modelNames) {

        for (RequestParameter parameter : from.getRequestParameters()) {
            // 若未设置，设置一个默认值
            if(parameter.getIn()==null) {
                BeanUtil.setFieldValue(parameter,"in",ParameterType.BODY);
            }
        }


        return super.mapOperation(from,modelNames);
    }

    /**
     * 处理 tag
     * */
    protected List<io.swagger.models.Tag> tagSetToTagList(Set<Tag> set) {

        com.github.foxnic.springboot.mvc.RequestParameter parameter=com.github.foxnic.springboot.mvc.RequestParameter.get();

        BrowserType browserType=parameter.getBrowserType();
        UserAgent userAgent=parameter.getUserAgent();

        // 提取 tag 名称的各个组成部分，独立目录
        if(browserType==BrowserType.API_FOX || browserType==BrowserType.HTTP_CLIENT) {
            Set<String> existsNames = new HashSet<>();
            Set<String> splitNames = new HashSet<>();
            for (Tag tag : set) {
                existsNames.add(tag.getName());
                String[] ns = tag.getName().split("/");
                for (String n : ns) {
                    splitNames.add(n);
                }
            }

            for (String splitName : splitNames) {
                if (existsNames.contains(splitName)) continue;
                Tag newTag = new Tag(splitName, "");
                set.add(newTag);
                existsNames.add(splitName);
            }
        }


        return super.tagSetToTagList(set);
    }



}
