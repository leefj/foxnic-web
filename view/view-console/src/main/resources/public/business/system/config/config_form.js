/**
 * 系统配置 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-15 16:43:25
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,layedit,laydate;
	const moduleURL="/service-system/sys-config";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		layedit = layui.layedit , laydate = layui.laydate;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定按钮事件
		bindButtonEvent();
		
		//调整窗口的高度与位置
		adjustPopup();
		
		//绑定表单字段事件
		bindFieldEvents();
		
	}
	
	function bindFieldEvents() {
		form.on('radio(type)', function(data) {
			var fmdata = form.val("data-form");
			if(fmdata.code==null || fmdata.code=="") return ;
			 save(fmdata,function(){
			 	admin.putTempData('sys-config-form-data',fmdata);
			 	location.reload();
			 });
		});
	}
	
	function adjustPopup() {
		var delta=68;//此参数请按实际情况自行调整
		var height=document.body.clientHeight+delta;
		admin.changePopupArea(null,height);
		admin.putTempData('sys-config-form-area', {height:height});
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
		if($("#value").attr("tag")=="date") {
			laydate.render({
			    elem: '#value',
			    trigger: 'click'
			});
		}
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('sys-config-form-data');
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);
	     	//设置并显示图片
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
	    	
	    	//处理逻辑值
		    if(!data.field.valid) data.field.valid=0;
	    	
	    	save(data.field);
	        
	        return false;
	    });
	    
	    $("#cancel-button").click(function(){admin.closePopupCenter();});
	    
    }
    
    function save(data,success) {
    	var api=moduleURL+"/"+(data.code?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                
	                if(!success){
	                	layer.msg(data.message, {icon: 1, time: 500});
	                	admin.finishPopupCenter();
	                }
	                else success();
	            } else {
	                layer.msg(data.message, {icon: 2, time: 500});
	            }
	        }, "POST");
    }

}

layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select',
	numberInput:'numberInput/numberInput'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','layedit', 'laydate'],function() {
	(new FormPage()).init(layui);
});