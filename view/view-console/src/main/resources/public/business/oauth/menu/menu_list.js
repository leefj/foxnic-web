/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-oauth/sys-menu";

	var menuTree;

	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

     	var cfgs = {
     		edit: {
				enable: true
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
				onDrop : onNodeDrop,
				onClick: onNodeClick,
				onAsyncSuccess: function (event, treeId, treeNode, msg) {
					var data=JSON.parse(msg).data;
					var top0=menuTree.getNodeByParam("id",data[0].id);
					if(top0.parentId=='0') {
						menuTree.selectNode({tId: top0.tId}, false, true)
						onNodeClick(event, treeId, top0);
					}
				}
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
			var treeHeight=fullHeight-toolbarHeight;
			$("#tree-container").height(treeHeight-1);
			$("#form-view").height(fullHeight);
			//
			// $(".layui-col-md4").width("200px");
			// $(".layui-col-md8").width((fullWidth-200)+"px");

		},10);

		//
		bindSearchEvent();
     }

    var editingNode=null;
    function onNodeClick(event, treeId, treeNode) {
    	if(treeNode==null) return;
    	editingNode=treeNode;
    	$("#form-view")[0].contentWindow.loadFormData(treeNode.id);
    }


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
				ids.push(siblings[i].id);
			}
    		saveHierarchy(ids,parentId);
    	}  else {
    		debugger;
    	}
    }

    function saveHierarchy(ids,parentId) {
    	admin.request(moduleURL+"/save-hierarchy",{"ids":ids,parentId:parentId},function(r) {
			if(r.success) {
				admin.toast().success("已调整",{time:1000,position:"right-bottom"});
				$("#form-view")[0].contentWindow.loadFormData(editingNode.id);
			} else {
				admin.toast().error("调整失败",{time:1000,position:"right-bottom"});
			}
		});
    }

    function beforeNodeRemove(treeId, treeNode) {
		if(!treeNode.id) {
			return false;
		}
    	//debugger;
		layer.confirm('确定要删除['+treeNode.name+']菜单吗?', function(index,a,c,d) {
			layer.close(index);
			admin.request(moduleURL+"/delete",{id:treeNode.id},function(r) {
				if(r.success) {
					admin.toast().success("菜单已删除",{time:1000,position:"right-bottom"});
					menuTree.removeNode(treeNode,false);
					if(treeNode.parentTId) {
						menuTree.selectNode({tId:treeNode.parentTId},false,true)
						onNodeClick(null,treeId,menuTree.getNodeByTId(treeNode.parentTId));
					}
				} else {
					// admin.toast().error("删除失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
					fox.showMessage(r);
				}
			});
		});
    	return false;
    }

	function onNodeRename (event, treeId, treeNode, isCancel) {
		admin.request(moduleURL+"/update",{id:treeNode.id,label:treeNode.name},function(r){
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
			if(childNodes[i].type=="folder") {
				childNodes[i].iconSkin="icon_menu_folder";
			}
			if(childNodes[i].type=="page") {
				childNodes[i].iconSkin="icon_menu_page";
			}
			if(childNodes[i].type=="function") {
				childNodes[i].iconSkin="icon_menu_function";
			}
			if(childNodes[i].type=="api") {
				childNodes[i].iconSkin="icon_menu_api";
			}

		}
		return childNodes;
	}

	function addHoverDom(treeId, treeNode) {
		// debugger
		if(!treeNode.id) {
			return false;
		}
		// if(!treeNode.isParent) return;

		if(treeNode.type=="api" || treeNode.type=="function") return;
		// var aObj = $("#" + treeNode.tId + "_a");
		//setTimeout(function (){
		var aObj = $("#" + treeNode.tId + "_span").parent();

		if ($("#diyBtn_"+treeNode.id+"_add").length==0) {
			var editStr = "<span tid='" + treeNode.tId + "' class='button add' id='diyBtn_" + treeNode.id + "_add' onfocus='this.blur();'/>"
			aObj.append(editStr);
			var btn = $("#diyBtn_" + treeNode.id + "_add");
			if (btn) {
				btn.bind("click", function () {
					addChild(treeNode);
				});
			}
		}


		if ($("#diyBtn_"+treeNode.id+"_refresh").length==0) {
			var editStr = "<span tid='" + treeNode.tId + "' class='button refresh' id='diyBtn_" + treeNode.id + "_refresh' onfocus='this.blur();'/>"
			aObj.append(editStr);
			var btn = $("#diyBtn_" + treeNode.id + "_refresh");
			if (btn) {
				btn.bind("click", function () {
					var it = $(this);
					var tid = it.attr("tid");
					var node = menuTree.getNodeByTId(tid);
					menuTree.reAsyncChildNodes(node, 'refresh');
				});
			}
		}



		//},0);


	}

	function chaneNodeName(id,name,type) {
		if(editingNode==null) return;
		if(editingNode.id!=id) return;
		editingNode.name=name;
		editingNode.type=type;
		editingNode.iconSkin="icon_menu_"+type;
		menuTree.updateNode(editingNode);
	}
	window.chaneNodeName=chaneNodeName;

	function removeHoverDom(treeId, treeNode) {
		if(!treeNode.id) {
			return false;
		}
		$("#diyBtn_"+treeNode.id+"_refresh").unbind().remove();
		$("#diyBtn_"+treeNode.id+"_add").unbind().remove();
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


	function addChild(treeNode) {

		if(treeNode==null) {
			var nodes = menuTree.getSelectedNodes();
			if (nodes && nodes.length > 0) {
				treeNode = nodes[0];
			}
		}

		admin.request(moduleURL+"/insert",{parentId:treeNode?treeNode.id:null,label:"新菜单"},function(r) {
			if(r.success) {
				admin.toast().success("菜单已创建",{time:1000,position:"right-bottom"});
				//debugger
				if(treeNode==null) {
					//debugger;
					menuTree.addNodes(null,{id:r.data.id,name:r.data.label});
					return;
				}

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
							menuTree.addNodes(treeNode,{id:r.data.id,name:r.data.label,parentId:r.data.parentId});
							//menuTree.selectNode(newNode,false);
						} else {
							menuTree.reAsyncChildNodes(treeNode,"refresh",true);
						}

					}
				}
			} else {
				admin.toast().error("新建菜单失败",{time:1000,position:"right-bottom"});
			}
		},"POST",true);
	}

	// 添加按钮点击事件
    $('#btn-add').click(addChild);


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
		var title = (data && data.id) ? (fox.translate('修改菜单')) : (fox.translate('添加菜单'));
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
}).use(['form', 'table', 'util', 'settings',  'upload','foxnic','xmSelect'],function() {
	(new ListPage()).init(layui);
});
