/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-dataperm/dp-rule-condition";

	var menuTree;
	var rangeId;

	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload ,dropdown=layui.dropdown;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		rangeId=admin.getTempData("rule-range-id");

     	var cfgs = {
     		edit: {
				enable: true,
				showRenameBtn: false
			},
			async: {
				enable: true,
				contentType:"application/json",
				url:moduleURL+"/query-nodes",
				autoParam:["id=parentId"],
				otherParam:{isLoadAllDescendants:0,rangeId:rangeId},
				dataFilter: nodeDatafilter
			},
			callback: {
				beforeRemove : beforeNodeRemove,
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
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			var treeHeight=fullHeight;
			$("#tree-container").height(treeHeight-1);
			$("#form-view").height(fullHeight);

		},10);

		//
		bindSearchEvent();



     }

	function renderMenu(node) {
		//debugger
		dropdown.render({
			elem: '#' + node.tId + "_a",
			trigger: 'contextmenu',
			data: [{
				title: '添加逻辑组',
				id: "add-group"
			}, {
				title: '添加表达式',
				id: 'add-expr'
			}
			],click: function(obj, othis){
				if(obj.id === 'add-group') {
					addNode("group");
				} else if(obj.id === 'add-expr') {
					addNode("expr");
				}
			}
		});
	}

    var editingNode=null;
    function onNodeClick(event, treeId, treeNode) {
    	//debugger;
		if(treeNode==null) return;
		editingNode=treeNode;
		renderMenu(treeNode);
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
			} else {
				admin.toast().error("调整失败",{time:1000,position:"right-bottom"});
			}
		});
    }

    function beforeNodeRemove(treeId, treeNode) {
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
					admin.toast().error("删除失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
				}
			});
		});
    	return false;
    }

	function nodeDatafilter(treeId, parentNode, childNodes) {
     	//debugger;
     	childNodes=childNodes.data;
		if (!childNodes) return null;
		for (var i=0, l=childNodes.length; i<l; i++) {
		}
		setTimeout(function (){
			var node = menuTree.getNodesByFilter(function (n){
				return n.parentId=="0";
			},true);
			if(node) {
				menuTree.expandNode(node, true, false, true, false);
			}
		},100);
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


	// 添加节点
    function addNode(type) {
        var nodes=menuTree.getSelectedNodes();

        //默认根节点
        var treeNode=null;
        if(nodes && nodes.length>0) {
         	treeNode=nodes[0];
        }

        admin.request(moduleURL+"/insert",{parentId:treeNode?treeNode.id:null,type:type,rangeId: rangeId},function(r) {
			if(r.success) {
				admin.toast().success("节点已创建",{time:1000,position:"right-bottom"});

				var isLeaf=!treeNode.isParent;
				treeNode.isParent=true;
				menuTree.updateNode(treeNode)
				if(isLeaf) {
					menuTree.reAsyncChildNodes(treeNode,"refresh",false);
				} else {
					if(!treeNode.open) {
						//展开节点
						menuTree.expandNode(treeNode,true,false,true,false);
					} else {
						if(treeNode.children && treeNode.children.length>0) {
							var na="";
							if(type=="group") {
								na="逻辑组"
							} else if(type=="expr") {
								na="表达式";
							}
							menuTree.addNodes(treeNode,{id:r.data.id,name:na,parentId:r.data.parentId,data:r.data});
						} else {
							menuTree.reAsyncChildNodes(treeNode,"refresh",true);
						}

					}
				}
			} else {
				admin.toast().error("新建节点失败",{time:1000,position:"right-bottom"});
			}
		},"POST",true);
    }


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
}).use(['form', 'table', 'util', 'settings',  'upload','foxnic','xmSelect',"dropdown"],function() {
	(new ListPage()).init(layui);
});
