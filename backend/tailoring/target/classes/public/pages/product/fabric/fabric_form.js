/**
 * 面料 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-08 03:23:08
 */
layui.use(['layer', 'admin', 'form', 'formSelects','upload','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/prd-fabric/";
     
    form.render('radio');
    //渲染图片字段
    fox.renderSimpleUpload("#fileId","#fileId-button","#fileId-image");
    
    
     var formData = admin.getTempData('prd-fabric-form-data');
     $('#fabric-form').attr('method', 'POST');
     if (formData) {
     	form.val('fabric-form', formData);
     	//设置并显示图片
	    if($("#fileId").val()) {
	    	$("#fileId-image").attr("src","/service-tailoring/sys-file/download?id="+$("#fileId").val());
	    }
     	$('#fabric-form').attr('method', 'POST');
     }
     
     
 
 
    // 表单提交事件
    form.on('submit(fabric-form-submit)', function (data) {
    	//debugger;
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