/**
 * 商品收藏分类 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:26
 */
layui.use(['layer', 'admin', 'form', 'formSelects','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/crm-favorite-folder/";
     
    form.render('radio');
    
     var formData = admin.getTempData('crm-favorite-folder-form-data');
     $('#favorite_folder-form').attr('method', 'POST');
     if (formData) {
     	form.val('favorite_folder-form', formData);
     	$('#favorite_folder-form').attr('method', 'POST');
     }
 
 
    // 表单提交事件
    form.on('submit(favorite_folder-form-submit)', function (data) {
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