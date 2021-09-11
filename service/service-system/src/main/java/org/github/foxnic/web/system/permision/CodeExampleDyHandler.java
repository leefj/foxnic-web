package org.github.foxnic.web.system.permision;

import org.github.foxnic.web.constants.enums.SystemConfigEnum;
import org.github.foxnic.web.constants.enums.VersionType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.proxy.utils.SystemConfigProxyUtil;
import org.github.foxnic.web.session.DynamicHandler;

public class CodeExampleDyHandler extends DynamicHandler {

    @Override
    public boolean hasPermission(Menu menu, User user) {
        VersionType versionType=SystemConfigProxyUtil.getEnum(SystemConfigEnum.SYSTEM_VERSION_TYPE, VersionType.class);
        //生产环境下，不显示当前菜单
        if(versionType==VersionType.PROD) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getLabel(Menu menu, User user) {
        //根据不同的情况显示不同的菜单标题，如待数量等
        return "代码生成示例("+(System.currentTimeMillis()%10)+")";
    }
}
