package org.github.foxnic.web.relation.modules;

import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.Position;
import org.github.foxnic.web.domain.hrm.meta.EmployeeMeta;

import java.util.ArrayList;
import java.util.List;

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
						Person person=personList.get(0);
						String str=person.getName();
						employee.setName(str);
						employee.setSex(person.getSex());
						employee.setIdentity(person.getIdentity());
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
					List<String> vicePosIds=new ArrayList<>();
					for (Position position : positions) {
						//如果是主岗，设置员工主岗
						Boolean pri=m.get(position).getBoolean("pri");
						if(pri==null) pri=false;
						if(pri) {
							employee.setPrimaryPosition(position);
							employee.setPrimaryPositionId(position.getId());
						} else {
							vicePosIds.add(position.getId());
						}
					}
					employee.setVicePositionIds(vicePosIds);
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
						Boolean pri=m.get(org).getBoolean("pri");
						if(pri==null) pri=false;
						if(pri) {
							employee.setPrimaryOrganization(org);
						}
					}
					return orgs;
				})
		;

		//员工 - 业务角色关联关系
		this.property(EmployeeMeta.BUSI_ROLES_PROP)
				.using(FoxnicWeb.HRM_EMPLOYEE.ID).join(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.MEMBER_ID).conditionEquals(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.MEMBER_TYPE, UnifiedUserType.employee.code())
				.using(FoxnicWeb.SYS_BUSI_ROLE_MEMBER.ROLE_ID).join(FoxnicWeb.SYS_BUSI_ROLE.ID).condition("valid=1")
		;

	}


}
