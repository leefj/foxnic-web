package org.github.foxnic.web.relation.modules;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;

public class HrmRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupEmployeeProperties();
	}
 
	public void setupEmployeeProperties() {

		//员工 - 人员关联关系
		this.property(EmployeeMeta.PERSON_PROP)
				.using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID).after((employee, personList) -> {
					//设置属性
					if(personList!=null && personList.size()>0){
						String str=personList.get(0).getName();
						if(!StringUtil.isBlank(employee.getBadge())) {
							str=str+"("+employee.getBadge()+")";
						}
						employee.setNameAndBadge(str);
					}
					return personList;
		});

		//员工 - 公司关联关系
		this.property(EmployeeMeta.COMPANY_PROP)
				.using(FoxnicWeb.HRM_EMPLOYEE.COMPANY_ID).join(FoxnicWeb.HRM_COMPANY.ID);

	}


}
