package org.github.foxnic.web.framework.busi.menu;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.api.ApiSource;
import org.github.foxnic.web.domain.api.ApiSourceVO;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.proxy.docs.ApiSourceServiceProxy;
import org.github.foxnic.web.session.DynamicMenuHandler;

import java.util.ArrayList;
import java.util.List;

public class DocketDyHandler extends DynamicMenuHandler {

    @Override
    public boolean hasPermission(Menu menu, User user) {
        return true;
    }

    @Override
    public String getLabel(Menu menu, User user) {
        return menu.getLabel();
    }

    @Override
    public List<Menu> generateExtraChildNodes(Menu menu, User user) {
        ApiSourceVO sample=new ApiSourceVO();
        sample.setValid(1);
        Result<List<ApiSource>> result = ApiSourceServiceProxy.api().queryList(sample);
        if(result.failure()) return null;
        List<Menu> list=new ArrayList<>();
        for (ApiSource source : result.data()) {
            Menu m=new Menu();
            m.setLabel(source.getName());
            m.setCss("mdi mdi-gamepad-circle-up");
            m.setPath("/business/api/navigator/index.html?id="+source.getId());
            m.setParentId(menu.getId());
            m.setHidden(0);
            m.setId(source.getId());
            m.setType("page");
            list.add(m);
        }
        return list;
    }


}
