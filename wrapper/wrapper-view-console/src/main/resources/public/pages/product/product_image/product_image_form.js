/**
 * 商品图片 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 08:44:51
 */
layui.use(['layer', 'admin', 'form', 'formSelects','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/prd-product-image/";
     
    form.render('radio');
    
     var formData = admin.getTempData('prd-product-image-form-data');
     $('#product_image-form').attr('method', 'POST');
     if (formData) {
     	form.val('product_image-form', formData);
     	$('#product_image-form').attr('method', 'POST');
     }
 
 
    // 表单提交事件
    form.on('submit(product_image-form-submit)', function (data) {
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