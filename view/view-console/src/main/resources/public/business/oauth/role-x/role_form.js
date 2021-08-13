/**
 * 角色 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-09 14:46:41
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-oauth/sys-role";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();
	}
	
	function adjustPopup() {
		setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var area=admin.changePopupArea(null,bodyHeight);
			admin.putTempData('sys-role-form-area', area);
			window.adjustPopup=adjustPopup;
		},50);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
	}


	var roleId="";
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('sys-role-form-data');
		roleId=formData.id;
		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);



	     	fm.attr('method', 'POST');
	     	renderFormFields();
		}
		
		//渐显效果
		fm.css("opacity","0.0");
        fm.css("display","");
        setTimeout(function (){
            fm.animate({
                opacity:'1.0'
            },100);
        },1);
        
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			var menuIds=admin.getTempData("selected-role-menu-ids");
			$("#menuIds").val(menuIds.join(","));
			data.field.menuIds=menuIds.join(",");
			console.log(data.field.menuIds);

	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
	                admin.finishPopupCenter();
	            } else {
	                layer.msg(data.message, {icon: 2, time: 1000});
	            }
	        }, "POST");
	        
	        return false;
	    });
	    
	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});

	    //
		$("#menu-button").click(function(){
			openMenuDialog(function (css){});
		});
	    
    }

    var menuDialogIndex;
	function openMenuDialog(callback) {
		//debugger;
		admin.putTempData("selected-role-menu-ids",null);
		menuDialogIndex=admin.popupCenter({
			type:2,
			id:"menuDialog",
			title: "请选择菜单",
			content: '/business/oauth/menu/menu_dialog.html'+(roleId?('?roleId='+roleId):""),
			area:["300px","80%"]
		});


	}






}



layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select',
	foxnicUpload: 'upload/foxnic-upload'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload'],function() {
	(new FormPage()).init(layui);
});