package org.github.foxnic.web.relation.modules;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;

public class HrmRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupEmployeeProperties();
	}
 
	public void setupEmployeeProperties() {

		//员工 - 人员关联关系
		this.property(EmployeeMeta.PERSON_PROP)
				.using(FoxnicWeb.HRM_EMPLOYEE.PERSON_ID).join(FoxnicWeb.HRM_PERSON.ID).after((employee, personList,m) -> {
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


		//员工 - 岗位关联关系
		this.property(EmployeeMeta.POSITIONS_PROP)
				.using(FoxnicWeb.HRM_EMPLOYEE.ID).join(FoxnicWeb.HRM_EMPLOYEE_POSITION.EMPLOYEE_ID).select(FoxnicWeb.HRM_EMPLOYEE_POSITION.IS_PRIMARY,"pri")
				.using(FoxnicWeb.HRM_EMPLOYEE_POSITION.POSITION_ID).join(FoxnicWeb.HRM_POSITION.ID).condition("valid=1")
				.after((employee,positions,m)->{
					for (Position position : positions) {
						//如果是主岗，设置员工主岗
						if(m.get(position).getBoolean("pri")) {
							employee.setPrimaryPosition(position);
							}
					}
					return positions;
				});

		//员工 - 岗位关联关系
		this.property(EmployeeMeta.ORGANIZATIONS_PROP)
				.using(FoxnicWeb.HRM_EMPLOYEE.ID).join(FoxnicWeb.HRM_EMPLOYEE_POSITION.EMPLOYEE_ID).select(FoxnicWeb.HRM_EMPLOYEE_POSITION.IS_PRIMARY,"pri")
				.using(FoxnicWeb.HRM_EMPLOYEE_POSITION.POSITION_ID).join(FoxnicWeb.HRM_POSITION.ID).condition("valid=1")
				.using(FoxnicWeb.HRM_POSITION.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID)
				.after((employee,orgs,m)->{
					for (Organization org : orgs) {
						//如果是主岗，设置员工主岗
						if(m.get(org).getBoolean("pri")) {
							employee.setPrimaryOrganization(org);
						}
					}
					return orgs;
				})
		;

	}


}
