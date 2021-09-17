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
	var inputValue;
	var options;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
 		dropdown=layui.dropdown,element=layui.element;

		options=admin.getTempData("org-dialog-options");

 		var checkOptions={enable: true,autoCheckTrigger: true,chkboxType : { "Y" : "", "N" : "" }};
 		if(options.single) {
			checkOptions.chkStyle="radio";
			checkOptions.radioType="all";
		}

     	var cfgs = {
     		edit: {
				enable: false,
				showRenameBtn:false
			},
			check: checkOptions,
			async: {
				enable: true,
				contentType:"application/json",
				url:moduleURL+"/query-nodes",
				autoParam:["id=parentId"],
				otherParam:{isLoadAllDescendants:1,targetType:options.targetType,root:options.root},
				dataFilter: nodeDatafilter
			},
			callback: {
				onAsyncSuccess:onAsyncSuccess
			},
			view: {

			}
		};

		inputValue=admin.getTempData("org-dialog-value");
		try {
			if(inputValue.indexOf("[")>-1 && inputValue.indexOf("]")>-1 ) {
				inputValue = JSON.parse(inputValue);
			} else {
				inputValue=inputValue.split(",");
			}
			if(!Array.isArray(inputValue)) {
				inputValue=[inputValue+""];
			}
		} catch (e) {
			inputValue=inputValue.split(",");
		}

		menuTree=$.fn.zTree.init($("#menu-tree"), cfgs);

		setTimeout(function(){
			var toolbarHeight=$("#toolbar")[0].clientHeight;
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			var treeHeight=fullHeight-toolbarHeight-1;
			$("#tree-container").height(treeHeight);
			// $("#form-view").height(fullHeight-6);

			$("#org-basic-info-ifr").height(fullHeight-70);
			$("#org-basic-info-ifr").show();

			$("#pos-basic-info-ifr").height(fullHeight-70);
			$("#pos-basic-info-ifr").show();

			$("#employee-list-ifr").height(fullHeight-70);
			$("#employee-list-ifr").show();
			//
			// $(".layui-col-md4").width("200px");
			// $(".layui-col-md8").width((fullWidth-200)+"px");

		},10);

		//
		bindSearchEvent();



     }

     var selectNodes={};
     function onAsyncSuccess() {
		//debugger
		 var task=setTimeout(function (){
			 var nodes = menuTree.getNodes();
			 console.log("nodes = "+nodes.length);
			 if(nodes.length>0) {
				 clearTimeout(task);
				 for (var i = 0; i < inputValue.length; i++) {
					 var n=menuTree.getNodeByParam("id",inputValue[i]);
					 if(n==null) continue;
					 var p=menuTree.getNodeByParam("id",n.parentId);
					 if(p==null) continue;
					 expandNode(p);
				 }
			 }
		 },100);
	 }

     function  expandNode(n) {
     	// debugger
		 if(n==null) return;
		 var p=menuTree.getNodeByParam("id",n.parentId);
		 if(p) {
			expandNode(p);
		 }
		 menuTree.expandNode(n,true,false,true);



	 }


	function nodeDatafilter(treeId, parentNode, childNodes) {
     	//debugger;
		//第一次数据到达时，否则即递归调用
		if(!Array.isArray(childNodes)) {
			childNodes = childNodes.data;
		}
		if (!childNodes) return null;
		for (var i=0, l=childNodes.length; i<l; i++) {
			// if("490260566036717569"==childNodes[i].id) {
			// 	debugger;
			// }
		 	if(inputValue.indexOf(childNodes[i].id)!=-1) {
				childNodes[i].checked=true;
				selectNodes[childNodes[i].id]=childNodes[i];
			}
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
			if(options.targetType=="pos") {
				if(childNodes[i].type=="dept" || childNodes[i].type=="com") {
					childNodes[i].chkDisabled=true;
				}
			}
			if(options.targetType=="dept") {
				if(childNodes[i].type=="com") {
					childNodes[i].chkDisabled=true;
				}
			}

		}
		return childNodes;
	}
	

	

     
      

	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {
		$('#search-field').val("");
		$('#search-input').val("");
		layui.form.render();
	}

	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {
		//回车键查询
		var ids=[];
		var handled={};
		$("#search-input").keydown(function(event) {
			if(event.keyCode !=13) return;

			admin.request(moduleURL+"/search",{"keyword":$("#search-input").val()},function(r) {
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
			var node=menuTree.getNodeByParam("id",id);
			if(!node || node.open) {
				startExpandNode();
				return;
			}
			console.log("expand : "+ id);
			menuTree.expandNode(node,true,false,true,false);
			handled[id]=true;
			var task=setInterval(function (){
				node=menuTree.getNodeByParam("id",id);
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
			var nodeList=menuTree.getNodesByParamFuzzy("name",$("#search-input").val());
			var sns=menuTree.getSelectedNodes();
			for( var i=0;i<sns.length;  i++) {
				menuTree.cancelSelectedNode(sns[i]);
			}
			for( var i=0;i<nodeList.length;  i++) {
				menuTree.selectNode(nodeList[i],true,true);
			}
		}

	}



	$("#sure-button").click(function () {
		var nodes=menuTree.getCheckedNodes(true);
		console.log(nodes);
		var orgIds=[];
		var orgNodes=[];
		for (let i = 0; i <nodes.length ; i++) {
			orgIds.push(nodes[i].id);
			orgNodes.push(nodes[i]);
		}
		var par=parent;
		if(par[0]) par=par[0];
		if(par.chooseOrgNodeCallbackEvent) {
			par.chooseOrgNodeCallbackEvent(orgIds,orgNodes);
		}
		var menuDialogIndex=admin.getTempData("org-dialog-index");
		admin.closePopupCenter(menuDialogIndex);
	});
 
    
    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {
		var queryString="";
		if(data) queryString="?" + 'id=' + data.id;
		admin.putTempData('sys-menu-form-data', data);
		var area=admin.getTempData('sys-menu-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= ($(window).height()-height)/2;
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('菜单')) : (fox.translate('添加')+fox.translate('菜单'));
		admin.popupCenter({
			title: title,
			resize:true,
			offset:[top,null],
			area:["500px",height+"px"],
			type: 2,
			content: '/business/oauth/menu/menu_form.html' + queryString,
			finish: function () {

			}
		});
	};
};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings',  'upload','foxnic','xmSelect',"dropdown","element"],function() {
	(new ListPage()).init(layui);
});