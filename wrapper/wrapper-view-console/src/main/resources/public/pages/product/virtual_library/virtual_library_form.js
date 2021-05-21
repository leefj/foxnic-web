/**
 * 虚拟试衣 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-09 01:57:23
 */
layui.use(['layer', 'admin', 'form', 'formSelects','upload','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/prd-virtual-library/";
     
    form.render('radio');
    //渲染图片字段
    fox.renderSimpleUpload("#effectFileId","#effectFileId-button","#effectFileId-image");
    
    
     var formData = admin.getTempData('prd-virtual-library-form-data');
     $('#virtual_library-form').attr('method', 'POST');
     if (formData) {
     	//debugger
     	form.val('virtual_library-form', formData);
     	$("#productName").val(formData.product.name);
     	$("#fabricName").val(formData.fabric.shortName);
     	//设置并显示图片
	    if($("#effectFileId").val()) {
	    	$("#effectFileId-image").attr("src","/service-tailoring/sys-file/download?id="+$("#effectFileId").val());
	    }
     	$('#virtual_library-form').attr('method', 'POST');
     }
 
    // 表单提交事件
    form.on('submit(virtual_library-form-submit)', function (data) {
    	//debugger;
    	
    	//处理逻辑值
	    if(!data.field.valid) data.field.valid=0;
    	
    	var api=moduleURL+(data.field.id?"update":"insert");
        layer.load(2);
        admin.req(api, JSON.stringify(data.field), function (data) {
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
});