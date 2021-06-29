package org.github.foxnic.web.generator.data;

import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.MenuType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.generator.config.FoxnicWebConfigs;
import org.github.foxnic.web.oauth.page.ResourzePageController;
import org.github.foxnic.web.proxy.oauth.ResourzeServiceProxy;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MenuGenerator {
	
	public static final String superAdminRoleId="110352963290923110";
	
	public static void main(String[] args) throws Exception {
		
		MenuGenerator generator=new MenuGenerator();
		//
//		generator.generate(SYS_USER.$TABLE,UserServiceProxy.class,UserPageController.class,"oauth");

		//generator.generate(FoxnicWeb.SYS_INVOKE_LOG.$TABLE, InvokeLogServiceProxy.class, InvokeLogPageController.class,"system");

		generator.generate(FoxnicWeb.SYS_RESOURZE.$TABLE, ResourzeServiceProxy.class, ResourzePageController.class,"oauth");

//		generator.removeByBatchId("454325348381753344");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final String CATALOG=
			"新建:insert,save;" +
			"删除:delete;" +
			"批量删除:delete-by-ids;" +
			"更新:update;" +
			"保存:update,save;" +
			"查询列表:get-by-ids,query-list,query-paged-list;" +
			"查看表单:get-by-id,get-by-ids;" +
			"导出:export-excel;" +
			"导入:export-excel-template,import-excel";

	private FoxnicWebConfigs configs;
	private DAO dao;

	
	public MenuGenerator() {
		this.configs=new FoxnicWebConfigs("service-system");
		this.dao=this.configs.getDAO();
	}
	

	
	public void generate(DBTable table, Class proxy,Class page,String parentId) throws Exception {

		String batchId=IDGenerator.getSnowflakeIdString();

		Menu indexMenu=createFromPage(page,table,parentId,batchId);



	}

	private Menu createFromPage(Class page,DBTable table,String parentId,String batchId) throws Exception {
		String prefix=(String)page.getDeclaredField("prefix").get(null);
		prefix=StringUtil.removeFirst(prefix, "/");
		List<Menu> pages=new ArrayList<>();
		Method[] ms=page.getDeclaredMethods();
		Menu listMenu=null;
		Menu formMenu=null;

		List<Resourze> resourzes=this.getPageResources(page,table,batchId);
		for (Resourze resourze : resourzes) {

			Menu menu=new Menu();
			menu.setId(IDGenerator.getSnowflakeIdString());
			menu.setType(MenuType.page.name());
			menu.setSort(0);

			if(resourze.getUrl().endsWith("_list.html")) {
				menu.setUrl("#!"+table.name().toLowerCase()+"_list");
				menu.setLabel(getTopic(table)+"管理");
				menu.setHidden(0);
				listMenu=menu;
			}

			if(resourze.getUrl().endsWith("_form.html")) {
				menu.setUrl("#!"+table.name().toLowerCase()+"_edit");
				menu.setLabel("查看"+getTopic(table));
				menu.setHidden(1);
				formMenu=menu;
			}
		}

		listMenu.setParentId(parentId);


		Menu formFolder=new Menu();
		formFolder.setId(IDGenerator.getSnowflakeIdString());
		formFolder.setType(MenuType.folder.name());
		formFolder.setSort(0);
		formFolder.setLabel("表单");
		formFolder.setParentId(listMenu.getId());

		formMenu.setParentId(formFolder.getId());

		Menu formSaveButton=new Menu();
		formSaveButton.setId(IDGenerator.getSnowflakeIdString());
		formSaveButton.setType(MenuType.folder.name());
		formSaveButton.setSort(0);
		formSaveButton.setLabel("保存");
		formSaveButton.setParentId(listMenu.getId());


		return  listMenu;
	}



	/**
	 * 从页面控制器提取页面资源
	 * */
	private List<Resourze> getPageResources(Class page,DBTable table,String batchId) throws Exception {
		String prefix=(String)page.getDeclaredField("prefix").get(null);
		prefix=StringUtil.removeFirst(prefix, "/");
		List<Resourze> resources=new ArrayList<>();
		Method[] ms=page.getDeclaredMethods();

		for (Method m : ms) {
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(rm==null) continue;
			String path="/"+StringUtil.joinUrl(prefix,rm.value()[0]);
			System.out.println(path);

			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setUrl(path);
			resourze.setType("page");
			resourze.setMethod("GET");
			resourze.setTableName(table.name());
			resourze.setModule(this.getTopic(table));
			resourze.setBatchId(batchId);

			resources.add(resourze);
		}

		return  resources;
	}


	public String getTopic(DBTable table) {
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
//	private String findDoc(String name, String source, String[] lines) {
//		String line=null;
//		int index=-1;
//		for (int i = 0; i < lines.length; i++) {
//			line=lines[i];
//			if(line.contains(" "+name+" ") || line.contains(" "+name+"=")) {
//				index=i;
//				break;
//			}
//		}
//		if(index==-1) return name;
//
//		String doc=lines[index-2];
//		doc=doc.trim();
//		doc=StringUtil.removeFirst(doc,"*").trim();
//		return doc;
//	}
//
//



	public void removeByBatchId(String batchId) throws Exception {

		this.dao.beginTransaction();
		this.dao.execute("delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id=?)",batchId);
		this.dao.execute("delete from sys_menu where batch_id=?",batchId);
		this.dao.commit();

	}
	
	

}
