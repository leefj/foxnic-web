/**
 * 账户 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-23 17:18:09
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	const moduleURL="/service-oauth/sys-user";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
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
		var delta=58;//此参数请按实际情况自行调整
		var height=document.body.clientHeight+delta;
		admin.changePopupArea(null,height);
		admin.putTempData('sys-user-form-area', {height:height});
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
		//渲染下拉字段
		fox.renderSelectBox({
			el: "#roleIds",
			radio: false,
			filterable: true,
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					//请自行调整此处字段的对应关系
					opts.push({name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('sys-user-form-data');
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
	    	
	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
	                admin.finishPopupCenter();
	            } else {
	                layer.msg(data.message, {icon: 2, time: 500});
	            }
	        }, "POST");
	        
	        return false;
	    });
	    
	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});
	    
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