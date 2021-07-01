package org.github.foxnic.web.generator.data;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.MenuType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuResource;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;
import org.github.foxnic.web.oauth.page.ResourzePageController;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuGenerator {

	/**
	 * 超级管理员角色ID
	 * */
	public static final String superAdminRoleId="110352963290923110";
	
	public static void main(String[] args) {

		MenuGenerator mg=null;

		mg=new MenuGenerator(FoxnicWeb.SYS_RESOURZE.$TABLE,ResourzeServiceProxy.class, ResourzePageController.class);
		mg.removeByBatchId("462947155678593024");
		mg.generate("oauth");






	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected static final String CATALOG=
			"新建:create:/insert,/save,_form.html;" +
			"删除:delete:/delete;" +
			"批量删除:batch-delete:/delete-by-ids;" +
			"更新:update:/update;" +
			"保存:save:/update,/save;" +
			"查询列表:query:/get-by-ids,/query-list,/query-paged-list;" +
			"查看表单:view-form:/get-by-id,/get-by-ids,_form.html;" +
			"导出:export:/export-excel;" +
			"导入:import:/export-excel-template,/import-excel";

	private FoxnicWebConfigs configs;
	private DAO dao;
	private DBTable table;
	private Class proxyType;
	private Class pageType;
	//
	private String batchId;
	private Menu topMenu=null;
	private List<Resourze> resourzes=new ArrayList<>();
	private Map<String,Resourze> resourceMap=new HashMap<>();
	private String authorityPrefix;
	private MenuGenerator(DBTable table,Class proxyType,Class pageType) {
		this("service-system",table,proxyType,pageType);
	}
	
	public MenuGenerator(String appId,DBTable table,Class proxyType,Class pageType) {
		this.configs=new FoxnicWebConfigs(appId);
		this.dao=this.configs.getDAO();
		this.table=table;
		this.proxyType =proxyType;
		this.pageType =pageType;
		this.batchId=IDGenerator.getSnowflakeIdString();
		this.authorityPrefix=table.name()+"::";
	}

	public void generate(String parentId) {
		try {
			dao.beginTransaction();
			createPageResources();
			createTopMenu(parentId);
			createApiResource();
			createSubMenus();
			dao.commit();
		} catch (Exception e){
			dao.rollback();
			e.printStackTrace();
		}
	}

	protected  String getFunctionString() {
		return CATALOG;
	}


	private void createSubMenus() {
		String[] tmp=getFunctionString().split(";");
		int idx=0;
		for (String s : tmp) {
			String[] line=s.split(":");
			String name=line[0];
			String auth=line[1];
			String[] suffixes=line[2].split(",");
			for (int i = 0; i < suffixes.length; i++) {
				suffixes[i]=suffixes[i].trim();
			}
			Menu menu=new Menu();
			menu.setId(IDGenerator.getSnowflakeIdString());
			menu.setAuthority(authorityPrefix+auth);
			menu.setBatchId(batchId);
			menu.setType(MenuType.function.name());
			menu.setSort(idx);
			menu.setLabel(name);
			menu.setParentId(topMenu.getId());
			menu.setHidden(0);
			idx++;
			//
			dao.insertEntity(menu);

			for (int i = 0; i < suffixes.length; i++) {
				Resourze resourze=resourceMap.get(suffixes[i]);
				if(resourze==null) {
					System.out.println("");
				}
				MenuResource mr=new MenuResource();
				mr.setId(IDGenerator.getSnowflakeIdString());
				mr.setMenuId(menu.getId());
				mr.setResourceId(resourze.getId());
				this.dao.insertEntity(mr);
			}

		}

	}

	private void createTopMenu(String parentId) throws Exception {

		for (Resourze resourze : resourzes) {
			if(resourze.getUrl().endsWith("_list.html")) {
				topMenu=new Menu();
				topMenu.setBatchId(batchId);
				topMenu.setId(IDGenerator.getSnowflakeIdString());
				topMenu.setType(MenuType.page.name());
				topMenu.setSort(0);
				topMenu.setUrl("#!"+table.name().toLowerCase()+"_list");
				topMenu.setLabel(getTopic()+"管理");
				topMenu.setHidden(0);
				topMenu.setAuthority(authorityPrefix+"mngr");
				topMenu.setPathResourceId(resourze.getId());
				topMenu.setParentId(parentId);
				dao.insertEntity(topMenu);
				break;
			}
		}

	}



	/**
	 * 从页面控制器提取页面资源
	 * */
	private void createPageResources() throws Exception {
		String prefix=(String)pageType.getDeclaredField("prefix").get(null);
		prefix=StringUtil.removeFirst(prefix, "/");

		File file=(new MavenProject(pageType)).getSourceFile(pageType);
		String source= FileUtil.readText(file);
		String[] lines=source.split("\n");

		Method[] ms=pageType.getDeclaredMethods();

		for (Method m : ms) {
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(rm==null) continue;
			String path="/"+StringUtil.joinUrl(prefix,rm.value()[0]);
			System.out.println(path);
			String doc=this.findDoc(m.getName(),source,lines);
			String[] parts=doc.split(" ");
			String name=parts[parts.length-1];
			if(path.endsWith("_list.html")) {
				name="查询页面";
			} else if(path.endsWith("_form.html")) {
				name="表单页面";
			}


			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setName(name);
			resourze.setUrl(path);
			resourze.setType("page");
			resourze.setMethod("GET");
			resourze.setTableName(table.name());
			resourze.setModule(this.getTopic());
			resourze.setBatchId(batchId);

			resourzes.add(resourze);
			if(path.endsWith("_list.html")) {
				resourceMap.put("_list.html",resourze);
			} else if(path.endsWith("_form.html")) {
				resourceMap.put("_form.html",resourze);
			}

			dao.insertEntity(resourze);
		}

	}

	private void createApiResource() throws Exception {

		File file=this.configs.getProxyProject().getSourceFile(proxyType);
		String source= FileUtil.readText(file);
		String[] lines=source.split("\n");


		Field[] fs=proxyType.getDeclaredFields();


		for (Field f : fs) {
			String name=f.getName();
			//排除一些无效的静态属性
			if(name.equals("CONTROLLER_CLASS_NAME") || name.startsWith("API_") ) continue;
			String value=(String)f.get(null);
			String doc=this.findDoc(f.getName(),source,lines);

			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setName(doc);
			resourze.setUrl(value);
			resourze.setType("api");
			resourze.setMethod("POST");
			resourze.setTableName(table.name());
			resourze.setModule(this.getTopic());
			resourze.setBatchId(batchId);

			dao.insertEntity(resourze);

			resourzes.add(resourze);

			value=value.substring(value.lastIndexOf("/"));

			resourceMap.put(value,resourze);

		}
	}


	public String getTopic() {
		DBTableMeta tm=dao.getTableMeta(table.name());
		String topic=tm.getTopic();
		topic=StringUtil.removeLast(topic, "数据表");
		topic=StringUtil.removeLast(topic, "表");
		return  topic;
	}



//	private void grant(String batchId) {
//
//
//		RcdSet menus=dao.query("select id from "+SYS_MENU.$NAME+" where batch_id=?",batchId);
//		for (Rcd r : menus) {
//			dao.insert(SYS_ROLE_MENU.$NAME)
//			.set(SYS_ROLE_MENU.ID, IDGenerator.getSnowflakeId())
//			.set(SYS_ROLE_MENU.ROLE_ID, superAdminRoleId)
//			.set(SYS_ROLE_MENU.MENU_ID, r.getString(SYS_MENU.ID))
//			.set(SYS_ROLE_MENU.CREATE_BY,"auto")
//			.execute();
//		}
//	}
//
//
//
//	private String generateMenus(DBTable table, Class proxy, Class page, String parentId) throws Exception {
//
//		String authorityPrefix=table.name()+"::";
//		//批次号
//		String batchId=IDGenerator.getSnowflakeIdString();
//
//		DBTableMeta tm=dao.getTableMeta(table.name());
//
//		String topic=tm.getTopic();
//		topic=StringUtil.removeLast(topic, "数据表");
//		topic=StringUtil.removeLast(topic, "表");
//
//
//		//插入模块目录
//		Menu indexMenu=null;
//		Menu formMenu=null;
//
//		String prefix=(String)page.getDeclaredField("prefix").get(null);
//		prefix=StringUtil.removeFirst(prefix, "/");
//		Method[] ms=page.getDeclaredMethods();
//		for (Method m : ms) {
//			RequestMapping rm=m.getAnnotation(RequestMapping.class);
//			if(rm==null) continue;
//			String path="/"+StringUtil.joinUrl(prefix,rm.value()[0]);
//			System.out.println(path);
//
//
//
//			Menu menu=new Menu();
//			menu.setId(IDGenerator.getSnowflakeIdString());
//			menu.setPath(path);
//			menu.setType(MenuType.page.name());
//
//			if(path.endsWith("_form.html")) {
//				menu.setUrl("#!"+table.name().toLowerCase()+"_edit");
//
//				menu.setLabel("编辑"+topic);
//				menu.setHidden(1);
//
//				formMenu=menu;
//			}
//
//			if(path.endsWith("_list.html")) {
//				menu.setUrl("#!"+table.name().toLowerCase()+"_mngr");
//				menu.setLabel(topic+"管理");
//				menu.setHidden(0);
//				indexMenu=menu;
//			}
//
//			menu.setSort(0);
//
//		}
//
//		if(formMenu==null || indexMenu==null) return null;
//
//		indexMenu.setAuthority(authorityPrefix+"list::view");
//		indexMenu.setBatchId(batchId);
//		formMenu.setBatchId(batchId);
//		indexMenu.setParentId(parentId);
//		formMenu.setParentId(indexMenu.getId());
//		formMenu.setAuthority(authorityPrefix+"form::view");
//		dao.insertEntity(formMenu);
//		dao.insertEntity(indexMenu);
//
//
//
//		Menu api=new Menu();
//		api.setId(IDGenerator.getSnowflakeIdString());
//		api.setLabel("api");
//		api.setHidden(1);
//		api.setType(MenuType.folder.name());
//		api.setParentId(indexMenu.getId());
//		api.setAuthority(authorityPrefix+"apiset");
//		api.setBatchId(batchId);
//		api.setSort(3);
//		dao.insertEntity(api);
//
//		File file=this.configs.getProxyProject().getSourceFile(UserServiceProxy.class);
//		String source=FileUtil.readText(file);
//		String[] lines=source.split("\n");
//
//
//		Field[] fs=proxy.getDeclaredFields();
//
//		int sort=0;
//		for (Field f : fs) {
//			String name=f.getName();
//			//排除一些无效的静态属性
//			if(name.equals("CONTROLLER_CLASS_NAME") || name.startsWith("API_") ) continue;
//			String value=(String)f.get(null);
//			String doc=this.findDoc(f.getName(),source,lines);
//			System.out.println(name + " = "+value+" , "+doc);
//
//			Menu rest=new Menu();
//			rest.setId(IDGenerator.getSnowflakeIdString());
//			rest.setType(MenuType.api.name());
//			rest.setHidden(1);
//			rest.setAuthority(authorityPrefix+"api::"+name.toLowerCase());
//			rest.setParentId(api.getId());
//			rest.setPath(value);
//			rest.setLabel(doc);
//			rest.setBatchId(batchId);
//			rest.setSort(sort);
//			dao.insertEntity(rest);
//			sort++;
//
//		}
//
//		return batchId;
//	}
//
	private String findDoc(String name, String source, String[] lines) {
		String line=null;
		int index=-1;
		for (int i = 0; i < lines.length; i++) {
			line=lines[i];
			if(line.contains(" "+name+" ") || line.contains(" "+name+"=")) {
				index=i;
				break;
			}
		}
		if(index==-1) return name;

		String doc=lines[index-2];
		doc=doc.trim();
		doc=StringUtil.removeFirst(doc,"*").trim();
		return doc;
	}

	public void removeByBatchId(String batchId)  {

		try {
			this.dao.beginTransaction();
			this.dao.execute("delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id=?)",batchId);
			this.dao.execute("delete from sys_resourze where batch_id=?",batchId);
			this.dao.execute("delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id=?)",batchId);
			this.dao.execute("delete from sys_menu where batch_id=?",batchId);
			this.dao.commit();
		} catch (Exception e) {
			this.dao.rollback();
			e.printStackTrace();;
		}


	}
	
	

}
