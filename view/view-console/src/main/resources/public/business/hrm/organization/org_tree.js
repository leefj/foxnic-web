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
				enable: true,
				showRenameBtn:false
			},
			async: {
				enable: true,
				contentType:"application/json",
				url:moduleURL+"/query-nodes",
				autoParam:["id=parentId"],
				otherParam:{isLoadAllDescendants:0},
				dataFilter: nodeDatafilter
			},
			callback: {
				onRename : onNodeRename,
				beforeRemove : beforeNodeRemove,
				beforeDrop: beforeNodeDrop,
				beforeDrag: beforeNodeDrag,
				onDrop : onNodeDrop,
				onClick: onNodeClick
			},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			}
		};
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

		renderMenu();

		element.on('tab(rightTab)', function(data) {
			var el=$(data.elem).find(".layui-show");
			activedTab=el.attr("type");
		});

     }

     function renderMenu() {
		 //初演示
		 dropdown.render({
			 elem: '#btn-add'
			 ,data: [{
				 title: '添加组织'
				 ,id: "org"
			 },{
				 title: '添加岗位'
				 ,id: "pos"
			 }]
			 ,click: function(obj){
				 if(obj.id=="org"){
					 createOrg();
				 } else if(obj.id=="pos") {
					 createPos();
				 }
			 }
		 });
	 }

    var editingNode=null;
    function onNodeClick(event, treeId, treeNode) {
    	if(treeNode==null) return;
    	editingNode=treeNode;
    	// 置空
    	admin.putVar("selectedPosition",null);
    	if(editingNode.type=="pos") {
			$("#org-li").hide();
			$("#pos-li").show();
			if(activedTab!="emp") {
				element.tabChange("rightTab", "pos-li");
			}
			admin.putVar("selectedPosition",editingNode);
			$("#pos-basic-info-ifr")[0].contentWindow.module.loadFormData(treeNode.id);
		} else {
			$("#org-li").show();
			$("#pos-li").hide();
			if(activedTab!="emp") {
				element.tabChange("rightTab", "org-li");
			}
			if(editingNode.type=="com") {
				$("#org-li").text("公司信息");
			}
			if(editingNode.type=="dept") {
				$("#org-li").text("部门信息");
			}
			$("#org-basic-info-ifr")[0].contentWindow.module.loadFormData(treeNode.id);
		}
    	//
		$("#employee-list-ifr")[0].contentWindow.module.lockRange(editingNode.type,treeNode.id);


    }

	function beforeNodeDrag(treeId, treeNodes) {
		if(treeNodes.length!=1) return false;
		else return true;
	};

	function beforeNodeDrop(treeId, treeNodes, targetNode, moveType) {
		//不能将节点拖放至岗位节点内
		if (moveType == "inner" && targetNode.type == "pos") return false;
		//如果拖放的节点是岗位节点，那么不能将这个节点拖放至任意公司或部门节点前
		if(treeNodes[0].type=="pos") {
			if (moveType == "prev" && (targetNode.type == "dept" || targetNode.type == "com")) return false;
		}
		return true;
	};

    function onNodeDrop(event, treeId, treeNodes, targetNode, moveType) {

		var ids=[];
		//移动节点
    	if(moveType=="inner" || moveType=="prev" || moveType=="next") { // 调整节点顺序
    		var parentNode=treeNodes[0].getParentNode();

	    	var siblings=null;
	    	var parentId=null;
	    	//非根节点
	    	if(parentNode!=null) {
	    		siblings=parentNode.children;
	    		parentId=parentNode.id;
	    	} else {
	    		//根节点
	    		siblings=[];
	    		var prev=null;
	    		var curr=treeNodes[0];
	    		while(true) {
	    			prev=curr.getPreNode();
	    			if(prev==null) break;
	    			curr=prev;
	    		}
	    		var next=null;
	    		while(true) {
	    			siblings.push(curr);
	    			next=curr.getNextNode();
	    			if(next==null) break;
	    			curr=next;
	    		}
	    	}
	    	for (var i = 0; i < siblings.length; i++) {
				ids.push(siblings[i].id+","+siblings[i].type);
			}
    		saveHierarchy(ids,parentId,parentNode);
    	}  else {
    		debugger;
    	}
    }

    function saveHierarchy(ids,parentId,parentNode) {
    	admin.request(moduleURL+"/save-hierarchy",{"ids":ids,parentId:parentId},function(r) {
			if(r.success) {
				admin.toast().success("已调整",{time:1000,position:"right-bottom"});
			} else {
				admin.toast().error("调整失败",{time:1000,position:"right-bottom"});
			}
			//menuTree.reAsyncChildNodes(parentNode,"refresh",true);
		});
    }

    function beforeNodeRemove(treeId, treeNode) {
    	//debugger;
		var prefix=moduleURL;
		if(treeNode.type=="pos") {
			prefix="/service-hrm/hrm-position";
		}
		layer.confirm('确定要删除['+treeNode.name+']吗?', function(index,a,c,d) {
			layer.close(index);
			admin.request(prefix+"/delete",{id:treeNode.id},function(r) {
				if(r.success) {
					admin.toast().success(treeNode.name+"已删除",{time:1000,position:"right-bottom"});
					menuTree.removeNode(treeNode,false);
					if(treeNode.parentTId) {
						menuTree.selectNode({tId:treeNode.parentTId},false,true)
						onNodeClick(null,treeId,menuTree.getNodeByTId(treeNode.parentTId));
					}
				} else {
					admin.toast().error("删除失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
				}
			});
		});
    	return false;
    }

	function onNodeRename (event, treeId, treeNode, isCancel) {

    	var ps={id:treeNode.id};
    	if(treeNode.extra.originalName==treeNode.extra.fullName) {
			ps.fullName=treeNode.name;
			treeNode.extra.fullName=treeNode.name;
		}
		if(treeNode.extra.originalName==treeNode.extra.shortName) {
			ps.shortName=treeNode.name;
			treeNode.extra.shortName=treeNode.name;
		}
		treeNode.extra.originalName=treeNode.name;
    	//
    	admin.request(moduleURL+"/update",ps,function(r){
			if(r.success) {
				admin.toast().success("名称已更改",{time:1000,position:"right-bottom"});
				$("#form-view")[0].contentWindow.loadFormData(treeNode.id);
			} else {
				admin.toast().error("名称更改失败",{time:1000,position:"right-bottom"});
			}
		});
	}

	function nodeDatafilter(treeId, parentNode, childNodes) {
     	//debugger;
     	childNodes=childNodes.data;
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

		}
		return childNodes;
	}

	function addHoverDom(treeId, treeNode) {
		if(!treeNode.isParent) return;
		var aObj = $("#" + treeNode.tId + "_a");
		if ($("#diyBtn_"+treeNode.id).length>0) return;
		//var editStr = "<span class='button icon01' id='diyBtn_" +treeNode.id+ "' title='"+treeNode.name+"' onfocus='this.blur();'></span>";
		var editStr = "<image tid='"+treeNode.tId+"' style='margin-top:2px' id='diyBtn_" +treeNode.id+ "' src='/assets/libs/zTree/images/refresh-16.png'  onfocus='this.blur();'/>"
		aObj.after(editStr);
		var btn = $("#diyBtn_"+treeNode.id);
		if (btn) btn.bind("click", function() {
			var it=$(this);
			var tid=it.attr("tid");
			var node=menuTree.getNodeByTId(tid);
			menuTree.reAsyncChildNodes(node,'refresh');
		});

	}

	function changeNodeInfo(param) {
		var id = param.id;
		var name=param.fullName;
		if(param.shortName) {
			name=param.shortName;
		}
		if(editingNode==null) return;
		if(editingNode.id!=id) return;
		editingNode.name=name;
		// debugger
		editingNode.iconSkin="icon_"+param.type;
		editingNode.type=param.type;
		// iconSkin:"icon_dept",type:"dept"
		menuTree.updateNode(editingNode);
	}
	window.changeNodeInfo=changeNodeInfo;

	function removeHoverDom(treeId, treeNode) {
			//if (treeNode.parentTId && treeNode.getParentNode().id!=1) return;
//			if (treeNode.id == 15) {
//				$("#diyBtn1_"+treeNode.id).unbind().remove();
//				$("#diyBtn2_"+treeNode.id).unbind().remove();
//			} else {
				$("#diyBtn_"+treeNode.id).unbind().remove();
//				$("#diyBtn_space_" +treeNode.id).unbind().remove();
//			}
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
						layer.msg("未找到匹配的节点", {icon: 1, time: 1000});
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



	// 添加组织
    function createOrg () {
        var nodes=menuTree.getSelectedNodes();

        //默认根节点
        var treeNode=null;
        if(nodes && nodes.length>0) {
         	treeNode=nodes[0];
        }

		if(treeNode && treeNode.type=="pos") {
			admin.toast().error("创建组织节点错误，请指定上级部门或公司",{time:1000,position:"right-bottom"});
			return;
		}


        admin.request(moduleURL+"/insert",{parentId:treeNode?treeNode.id:null,name:"新组织节点"},function(r) {
			if(r.success) {
				admin.toast().success("组织节点已创建",{time:1000,position:"right-bottom"});
				// debugger
				if(treeNode==null) {
					// debugger;
					menuTree.addNodes(null,{id:r.data.id,name:r.data.fullName,iconSkin:"icon_dept",type:"dept"});
					return;
				}
				// debugger
				var isLeaf=!treeNode.isParent;
				treeNode.isParent=true;
				menuTree.updateNode(treeNode)
				if(isLeaf) {
					menuTree.reAsyncChildNodes(treeNode,"refresh",false);
				} else {
					if(!treeNode.open ) {
						//展开节点
						menuTree.expandNode(treeNode,true,false,true,false);
					} else {
						if(treeNode.children && treeNode.children.length>0) {
							menuTree.addNodes(treeNode,{id:r.data.id,name:r.data.fullName,parentId:r.data.parentId,iconSkin:"icon_dept",type:"dept"});
							//menuTree.selectNode(newNode,false);
						} else {
							menuTree.reAsyncChildNodes(treeNode,"refresh",true);
						}

					}
				}
			} else {
				admin.toast().error("新建组织节点失败",{time:1000,position:"right-bottom"});
			}
		},"POST",true);
    };

	// 添加组织
	function createPos () {
		var nodes=menuTree.getSelectedNodes();

		//默认根节点
		var treeNode=null;
		if(nodes && nodes.length>0) {
			treeNode=nodes[0];
		}

		if(treeNode.type=="pos") {
			admin.toast().error("创建岗位错误，请指定上级部门或公司",{time:1000,position:"right-bottom"});
			return;
		}

		admin.request("/service-hrm/hrm-position/insert",{orgId:treeNode?treeNode.id:null,name:"新岗位"},function(r) {
			if(r.success) {
				admin.toast().success("岗位已创建",{time:1000,position:"right-bottom"});
				// debugger
				if(treeNode==null) {
					//debugger;
					menuTree.addNodes(null,{id:r.data.id,name:r.data.fullName,iconSkin:"icon_pos",type:"pos"});
					return;
				}
				// debugger
				var isLeaf=!treeNode.isParent;
				treeNode.isParent=true;
				menuTree.updateNode(treeNode)
				if(isLeaf) {
					menuTree.reAsyncChildNodes(treeNode,"refresh",false);
				} else {
					if(!treeNode.open ) {
						//展开节点
						menuTree.expandNode(treeNode,true,false,true,false);
					} else {
						if(treeNode.children && treeNode.children.length>0) {
							menuTree.addNodes(treeNode,{id:r.data.id,name:r.data.fullName,parentId:r.data.orgId,iconSkin:"icon_pos",type:"pos"});
						} else {
							menuTree.reAsyncChildNodes(treeNode,"refresh",true);
						}

					}
				}
			} else {
				admin.toast().error("新建岗位失败",{time:1000,position:"right-bottom"});
			}
		},"POST",true);
	};


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
