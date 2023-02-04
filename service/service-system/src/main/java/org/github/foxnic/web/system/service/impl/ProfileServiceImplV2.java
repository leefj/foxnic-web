package org.github.foxnic.web.system.service.impl;


import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.system.Profile;
import org.github.foxnic.web.domain.system.ProfileVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.system.service.IConfigService;
import org.github.foxnic.web.system.service.IProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-03 13:54:38
 * @version
*/


@Service("ProfileServiceImplV2")
public class ProfileServiceImplV2 extends ProfileServiceImpl {

	@Override
	public List<Profile> queryList(ProfileVO sample) {
		List<Profile> list=super.queryList(sample);
		for (Profile profile : list) {
			profile.setName(profile.getName());
		}
		return list;
	}


}
