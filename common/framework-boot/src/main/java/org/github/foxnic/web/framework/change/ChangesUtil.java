package org.github.foxnic.web.framework.change;

import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.ReflectUtil;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.changes.ChangeRequest;

import java.lang.reflect.Method;

public class ChangesUtil {

    private static final String PROXY_NAME="org.github.foxnic.web.proxy.changes.ChangeInstanceServiceProxy";

    private DAO dao;
    private String table;
    private  Object proxy;

    /**
     * 从变更主表对用的 Service 创建变更工具
     * */
    public ChangesUtil(SuperService service) {
        this.dao=service.dao();
        this.table=service.table();
        validateTable();
        Class proxyType= ReflectUtil.forName(PROXY_NAME);
        try {
            Method api=proxyType.getDeclaredMethod("api");
            proxy= api.invoke(null);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void validateTable() {
        DBTableMeta tm=dao.getTableMeta(table);
        validateColumn(tm,"chs_type");
        validateColumn(tm,"chs_status");
        validateColumn(tm,"chs_version");
        validateColumn(tm,"chs_source");
    }

    private void validateColumn(DBTableMeta tm, String column) {
        DBColumnMeta cm=tm.getColumn(column);
        if(cm==null) {
            throw new IllegalArgumentException("变更表 "+table+" 缺少 "+column+" 字段");
        }
    }

    /**
     * 启动变更
     * */
    public Result requestChange(ChangeRequest request) {
        if(StringUtil.isBlank(request.getTargetTable())) {
            request.setTargetTable(table);
        } else {
            if(!table.equalsIgnoreCase(request.getTargetTable())) {
                throw new IllegalArgumentException("表名不一致");
            }
        }

        return ErrorDesc.success();
    }


}
