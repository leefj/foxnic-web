/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */
 
function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	const moduleURL="/service-oauth/sys-menu";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();

		//绑定提交事件
		bindSubmitEvent();
 
	}
	
	function loadFormData(id) {
		admin.request(moduleURL+"/get-by-id",{id:id},function(r) {
			if(r.success) {
				 fillFormData(r.data)
			} else {
				admin.toast().error("获取数据失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
			}
		});
	};
	
	window.loadFormData=loadFormData;
 
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
//		form.render('radio');
 
//		formSelects.data('type', 'server', {
// 		url: '/service-tailoring/crm-company/query-list-for-select',
//		success: function(id, url, searchVal, result){
//        	if(formData) {
//        		layui.formSelects.value('companyId', [formData.companyId]);
//        	}
//        }
//	});
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		//var formData = admin.getTempData('sys-menu-form-data');
		$('#data-form')[0].reset();
		if (formData) {
			form.val('data-form', formData);
		}
		form.render();
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindSubmitEvent() {
    
	    form.on('submit(submit-button)', function (data) {
 
	    	//处理逻辑值
	    	var values=data.field;
	    	var api=moduleURL+"/"+(values.id?"update":"insert");
	        layer.load(2);
	        admin.request(api, data.field, function (data) {
	            layer.closeAll('loading');
	            if (data.success) {
	            	if(parent) {
	            		parent.chaneNodeName(values.id,values.label);
	            	}
	                layer.msg(data.message, {icon: 1, time: 500});
	            } else {
	                layer.msg(data.message, {icon: 2, time: 500});
	            }
	        }, "POST");
	        
	        return false;
	    });
	    
    }

}

layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect'],function() {
	(new FormPage()).init(layui);
});