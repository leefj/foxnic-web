/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,dropdown,element;
	//模块基础路径
	const moduleURL="/service-hrm/hrm-organization";

	var menuTree;
	var activedTab;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
 		dropdown=layui.dropdown,element=layui.element;



		setTimeout(function(){
			// var toolbarHeight=$("#toolbar")[0].clientHeight;
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			// var treeHeight=fullHeight-toolbarHeight-1;
			// $("#tree-container").height(treeHeight);
			// // $("#form-view").height(fullHeight-6);
			//
			// // $("#org-basic-info-ifr").height(fullHeight-70);
			// // $("#org-basic-info-ifr").show();
			//
			// debugger
			$("#result-list-ifr").height(fullHeight-0);
			$("#org-view-ifr").height(fullHeight-48);
			// $("#employee-selected-list-ifr").show();
			//
			// $("#employee-list-ifr").height(fullHeight-0);
			// $("#employee-list-ifr").show();
			// //
			// $(".layui-col-md4").width("200px");
			// $(".layui-col-md8").width((fullWidth-200)+"px");

		},128);



     }












};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util','upload','foxnic','xmSelect',"dropdown","element",'settings'],function() {
	(new ListPage()).init(layui);
});