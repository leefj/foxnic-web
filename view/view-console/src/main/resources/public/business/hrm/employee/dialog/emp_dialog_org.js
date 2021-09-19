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
		menuTree=$.fn.zTree.init($("#menu-tree"), cfgs);


		setTimeout(function(){
			var toolbarHeight=$("#toolbar")[0].clientHeight;
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			var treeHeight=fullHeight-toolbarHeight-1;
			$("#tree-container").height(treeHeight);
			// // $("#form-view").height(fullHeight-6);
			//
			// // $("#org-basic-info-ifr").height(fullHeight-70);
			// // $("#org-basic-info-ifr").show();
			//
			// $("#employee-list-ifr").height(fullHeight-0);
			// $("#employee-selected-list-ifr").show();
			//
			// $("#employee-list-ifr").height(fullHeight-0);
			// $("#employee-list-ifr").show();
			// //
			// $(".layui-col-md4").width("200px");
			// $(".layui-col-md8").width((fullWidth-200)+"px");

		},128);

		//
		bindSearchEvent();



		// element.on('tab(rightTab)', function(data) {
		// 	var el=$(data.elem).find(".layui-show");
		// 	activedTab=el.attr("type");
		// });

     }



    var editingNode=null;
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
		$("#employee-list-ifr")[0].contentWindow.module.lockRange(editingNode.type,treeNode.id);
		// $("#employee-selected-list-ifr")[0].contentWindow.module.lockRange(editingNode.type,treeNode.id);


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

};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util','upload','foxnic','xmSelect',"dropdown","element",'settings'],function() {
	(new ListPage()).init(layui);
});