/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	var menuTree;

	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {

		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		var data=admin.getTempData("contextDialogData");

		var cfgs = {
			edit: {
				enable: false
			},
			check: {
				enable: false,
				autoCheckTrigger: true,
				chkStyle: "radio",
				radioType: "all"
			},
			async: {
				enable: true,
				contentType:"application/json",
				url: "/service-dataperm/dp-rule-condition/query-context",
				autoParam:["id=parentId"],
				otherParam: data,
				dataFilter: nodeDatafilter
			},
			callback: {
				// onRename : onNodeRename,
				// beforeRemove : beforeNodeRemove,
				// onDrop : onNodeDrop,
				onClick: onNodeClick,
				onCheck: onNodeCheck
			},
			view: {
				selectedMulti: false
				// addHoverDom: addHoverDom,
				// removeHoverDom: removeHoverDom
			}
		};
		menuTree=$.fn.zTree.init($("#menu-tree"), cfgs);

		//树的关联选择控制
		form.on('checkbox(check-mode)', function (data) {
			if( data.elem.checked) {
				menuTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
			} else {
				menuTree.setting.check.chkboxType = { "Y" : "", "N" : "" };
			}
		});




		setTimeout(function(){
			// debugger
			var toolbarHeight=$(".model-form-footer")[0].clientHeight;
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			var treeHeight=fullHeight-1-toolbarHeight;
			$("#tree-container").height(treeHeight);
		},10);
	}

	function onNodeClick() {
		var nodes=menuTree.getSelectedNodes();
		for (var i=0, l=nodes.length; i<l; i++) {
			menuTree.checkNode(nodes[i], true, false, true);
		}
	}

	function onNodeCheck() {
		var nodes=menuTree.getCheckedNodes(true);
		if(nodes.length==0)  {
			$("#property").text("属性 : 未选择");
		}
		else {
			$("#property").text("属性 : " + nodes[0].id);
		}
	}

	var selectValueTask;

	function nodeDatafilter(treeId, parentNode, childNodes) {
		//debugger;
		childNodes=childNodes.data;
		if (!childNodes) return null;
		for (var i=0, l=childNodes.length; i<l; i++) {

		}

		return childNodes;
	}

	$("#sure-button").click(function () {
		var nodes=menuTree.getCheckedNodes(true);
		if(nodes.length==0) {
			top.layer.msg("请选择属性",{time:1000});
			return;
		}
		if(nodes[0].children.length>0) {
			top.layer.msg("不是一个可用于查询的属性",{time:1000});
			return;
		}
		// admin.putTempData("selected-po-property",nodes[0].id,true);
		admin.getTempData("updateButton")(nodes[0].id);
		var poPropertyDialogIndex=admin.getTempData("poPropertyDialogIndex");
		admin.closePopupCenter(poPropertyDialogIndex);
	});

};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings',  'upload','foxnic','xmSelect'],function() {
	(new ListPage()).init(layui);
});
