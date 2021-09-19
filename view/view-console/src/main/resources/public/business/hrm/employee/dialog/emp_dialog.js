/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,dropdown,element;
	//模块基础路径
	const moduleURL="/service-hrm/hrm-organization";

	var orgTree;
	var editingNode=null;
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
			// $("#result-list-ifr").height(fullHeight-0);
			// $("#org-view-ifr").height(fullHeight-48);
			// $("#employee-selected-list-ifr").show();
			//
			// $("#employee-list-ifr").height(fullHeight-0);
			// $("#employee-list-ifr").show();
			// //
			// $(".layui-col-md4").width("200px");
			// $(".layui-col-md8").width((fullWidth-200)+"px");
			$("#tree-container").height(fullHeight-51-34-8-56);
			$(".layui-tab-content").height(fullHeight-51);

		},128);

		renderEmployeeTable();

		renderSelectedTable();

		renderOrgTree();

		bindOrgTreeSearchEvent();

     }

     function renderOrgTree() {
		 var cfgs = {
			 edit: {
				 enable: false,
				 showRenameBtn:false
			 },
			 async: {
				 enable: true,
				 contentType:"application/json",
				 url:moduleURL+"/query-nodes",
				 autoParam:["id=parentId"],
				 otherParam:{isLoadAllDescendants:1},
				 dataFilter: nodeDatafilter
			 },
			 callback: {
				 onClick: onNodeClick
			 },
			 view: {

			 }
		 };
		 orgTree=$.fn.zTree.init($("#menu-tree"), cfgs);


		 function onNodeClick(event, treeId, treeNode) {
			 if(treeNode==null) return;
			 editingNode=treeNode;
			 // if(editingNode.type=="pos") {
			 // $("#org-li").hide();
			 // $("#pos-li").show();
			 // // if(activedTab!="emp") {
			 // 	element.tabChange("rightTab", "pos-li");
			 // }
			 // $("#pos-basic-info-ifr")[0].contentWindow.module.loadFormData(treeNode.id);
			 // } else {
			 // $("#org-li").show();
			 // $("#pos-li").hide();
			 // if(activedTab!="emp") {
			 // 	element.tabChange("rightTab", "org-li");
			 // }
			 // if(editingNode.type=="com") {
			 // 	$("#org-li").text("公司信息");
			 // }
			 // if(editingNode.type=="dept") {
			 // 	$("#org-li").text("部门信息");
			 // }
			 // $("#org-basic-info-ifr")[0].contentWindow.module.loadFormData(treeNode.id);
			 // }
			 //
			 // debugger;
			 //$("#employee-list-ifr")[0].contentWindow.module.lockRange(editingNode.type,treeNode.id);
			 // $("#employee-selected-list-ifr")[0].contentWindow.module.lockRange(editingNode.type,treeNode.id);
			 refreshEmployeeTableData();

		 }



		 function nodeDatafilter(treeId, parentNode, childNodes) {

			 if(!Array.isArray(childNodes)) {
				 childNodes = childNodes.data;
			 }
			 if (!childNodes) return null;
			 for (var i=0, l=childNodes.length; i<l; i++) {
				 //debugger;
				 if(childNodes[i].type=="com") {
					 childNodes[i].iconSkin="icon_com";
				 }
				 if(childNodes[i].type=="dept") {
					 childNodes[i].iconSkin="icon_dept";
				 }
				 if(childNodes[i].type=="pos") {
					 childNodes[i].iconSkin="icon_pos";
				 }
				 if(childNodes[i].children) {
					 nodeDatafilter(treeId,childNodes[i],childNodes[i].children);
				 }


			 }
			 return childNodes;
		 }

	 }

	/**
	 * 绑定搜索框事件
	 */
	function bindOrgTreeSearchEvent() {
		//回车键查询
		var ids=[];
		var handled={};
		$("#org-search-input").keydown(function(event) {
			if(event.keyCode !=13) return;

			admin.request(moduleURL+"/search",{"keyword":$("#org-search-input").val()},function(r) {
				if(r.success) {
					collectExpandNodeIds(r.data);
					if(ids.length>0) {
						startExpandNode();
					} else {
						layer.msg("为找到匹配的节点", {icon: 1, time: 1000});
					}
				} else {
					admin.toast().error("搜索错误",{time:1000,position:"right-bottom"});
				}
			});


		});

		var ids=[];
		var handled={};
		function startExpandNode() {
			if(ids.length==0) {
				highLightMatchedNodes();
				return;
			}
			var id=ids.shift();
			if(handled[id])  {
				startExpandNode();
				return;
			}
			var node=orgTree.getNodeByParam("id",id);
			if(!node || node.open) {
				startExpandNode();
				return;
			}
			console.log("expand : "+ id);
			orgTree.expandNode(node,true,false,true,false);
			handled[id]=true;
			var task=setInterval(function (){
				node=orgTree.getNodeByParam("id",id);
				if(node.open) {
					clearInterval(task);
					startExpandNode();
				}
			},4);
		}

		function  collectExpandNodeIds(hierarchys) {
			var ex={};
			for (var i = 0; i < hierarchys.length; i++) {
				var pIds=hierarchys[i].split("/");
				for (var j = 0; j < pIds.length; j++) {
					if(ex[pIds[j]]) continue;
					ids.push(pIds[j]);
					ex[pIds[j]]=true;
				}
			}
		}

		function highLightMatchedNodes() {
			var nodeList=orgTree.getNodesByParamFuzzy("name",$("#org-search-input").val());
			var sns=orgTree.getSelectedNodes();
			for( var i=0;i<sns.length;  i++) {
				orgTree.cancelSelectedNode(sns[i]);
			}
			for( var i=0;i<nodeList.length;  i++) {
				orgTree.selectNode(nodeList[i],true,true);
			}
		}
	}



	/**
	 * 渲染表格
	 */
	function renderEmployeeTable() {
		// debugger;
		// $(window).resize(function() {
		// 	fox.adjustSearchElement();
		// });
		// fox.adjustSearchElement();
		//
		function renderTableInternal() {
			// debugger
			const moduleURL="/service-hrm/hrm-employee";
			var ps={};
			var contitions={};
			// if(window.pageExt.list.beforeQuery){
			// 	window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			// }
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}
			// var templet=window.pageExt.list.templet;
			// if(templet==null) {
			var templet=function(field,value,row) {
				if(value==null) return "";
				return value;
			}
			// }
			var h=$(".search-bar").height();
			dataTable=fox.renderTable({
				elem: '#emp-table',
				//toolbar: '#employeeToolbarTemplate',
				defaultToolbar: [{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-146',
				limit: 50,
				where: ps,
				cols: [[
					{type:'numbers'},
					{type:'checkbox'}
					,{ field: '人员', align:"left",unresize:true, fixed:false,hide:false, sort: false, title: fox.translate('人员') , templet: function (d) { return templet('name',fox.getProperty(d,["person","name"]),d);} }
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
				]],
				page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
					layout: ['page','count'] //自定义分页布局
					//,curr: 5 //设定初始在第 5 页
					,groups: 3 //只显示 1 个连续页码
					,first: "1" //不显示首页
					,last: "末页" //不显示尾页

				},
				done: function (data) {
					// window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data);
				},
				footer : {
					exportExcel : false,
					importExcel : false
				}
			});
			//绑定排序事件
			table.on('sort(emp-table)', function(obj){
				refreshEmployeeTableData(obj.field,obj.type);
			});
		}
		setTimeout(renderTableInternal,1);
	};

	/**
	 * 刷新表格数据
	 */
	function refreshEmployeeTableData(sortField,sortType) {
		var value = {};
		value.name={ value: $("#emp-search-input").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" ",fillBy:["person","name"]};
		var ps={searchField:"$composite"};
		ps.searchValue=JSON.stringify(value);
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
		}
		if(editingNode!=null) {
			if(editingNode.type=="dept"|| editingNode.type=="com"){
				ps.orgId=editingNode.id;
			}
			if(editingNode.type=="pos"){
				ps.positionId=editingNode.id;
			}
		}
		table.reload('emp-table', { where : ps });
	}

	$("#emp-search-input").keydown(function(event) {
		if(event.keyCode !=13) return;
		refreshEmployeeTableData();
	});



	/**
	 * 渲染表格
	 */
	function renderSelectedTable() {
		// debugger;
		// $(window).resize(function() {
		// 	fox.adjustSearchElement();
		// });
		// fox.adjustSearchElement();
		//
		function renderTableInternal() {
			// debugger
			const moduleURL="/service-hrm/hrm-employee";
			var ps={};
			var contitions={};
			// if(window.pageExt.list.beforeQuery){
			// 	window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			// }
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}
			// var templet=window.pageExt.list.templet;
			// if(templet==null) {
			var templet=function(field,value,row) {
				if(value==null) return "";
				return value;
			}
			// }
			var h=$(".search-bar").height();
			dataTable=fox.renderTable({
				elem: '#selected-data-table',
				// toolbar: '#selectedToolbarTemplate',
				defaultToolbar: [{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-95',
				limit: 50,
				where: ps,
				cols: [[
					{type:'numbers'},
					{type:'checkbox'}
					,{ field: '已选人员',unresize:true, align:"",fixed:false,  hide:false, sort: false, title: fox.translate('已选人员') , templet: function (d) { return templet('name',fox.getProperty(d,["person","name"]),d);} }
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
				]],
				page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
					layout: ['page','count'] //自定义分页布局
					//,curr: 5 //设定初始在第 5 页
					,groups: 3 //只显示 1 个连续页码
					,first: "1" //不显示首页
					,last: "末页" //不显示尾页

				},
				done: function (data) {
					// window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data);
				},
				footer : {
					exportExcel : false,
					importExcel : false
				}
			});
			//绑定排序事件
			table.on('sort(selected-data-table)', function(obj){
				refreshTableData(obj.field,obj.type);
			});
		}
		setTimeout(renderTableInternal,1);
	};









};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util','upload','foxnic','xmSelect',"dropdown","element",'settings'],function() {
	(new ListPage()).init(layui);
});