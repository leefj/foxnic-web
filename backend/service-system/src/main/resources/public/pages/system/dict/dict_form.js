/**
 * 数据字典 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:22
 */
layui.use(['layer', 'admin', 'form', 'formSelects','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/sys-dict/";
     
    form.render('radio');
    
     var formData = admin.getTempData('sys-dict-form-data');
     $('#dict-form').attr('method', 'POST');
     if (formData) {
     	form.val('dict-form', formData);
     	$('#dict-form').attr('method', 'POST');
     }
 
 
    // 表单提交事件
    form.on('submit(dict-form-submit)', function (data) {
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