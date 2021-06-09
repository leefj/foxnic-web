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
				otherParam:{},
				dataFilter: nodeDatafilter
			},
			callback: {
				onRename : onNodeRename,
				beforeRemove : beforeNodeRemove,
				onDrop : onNodeDrop
			},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			}
		};
		menuTree=$.fn.zTree.init($("#menu-tree"), cfgs);
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
		layer.confirm('确定要删除['+treeNode.name+']菜单吗?', function(index,a,c,d) {
			layer.close(index);
			admin.request(moduleURL+"/delete",{id:treeNode.id},function(r) {
				if(r.success) {
					admin.toast().success("菜单已删除",{time:1000,position:"right-bottom"});
					menuTree.removeNode(treeNode,false);
				} else {
					admin.toast().error("删除失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
				}
			});
		});
    	return false;
    }
     
	function onNodeRename (event, treeId, treeNode, isCancel) {
		admin.request(moduleURL+"/update",{id:treeNode.id,label:treeNode.name},function(r){
			if(r.success) {
				admin.toast().success("名称已更改",{time:1000,position:"right-bottom"});
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
        $("#search-input").keydown(function(event) {
			if(event.keyCode !=13) return;
		  	refreshTableData();
        });

	}
	
	// 添加按钮点击事件
    $('#btn-add').click(function () {
        var nodes=menuTree.getSelectedNodes();
 
        //默认根节点
        var treeNode=null;
        if(nodes && nodes.length>0) {
         	treeNode=nodes[0];
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
		});
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
				refreshTableData();
			}
		});
	};
};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect'],function() {
	(new ListPage()).init(layui);
});