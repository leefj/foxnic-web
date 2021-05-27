/**
 * 用户角色关系 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:23
 */
layui.use(['layer', 'admin', 'form', 'formSelects','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/sys-user-role/";
     
    form.render('radio');
    
     var formData = admin.getTempData('sys-user-role-form-data');
     $('#user_role-form').attr('method', 'POST');
     if (formData) {
     	form.val('user_role-form', formData);
     	$('#user_role-form').attr('method', 'POST');
     }
 
 
    // 表单提交事件
    form.on('submit(user_role-form-submit)', function (data) {
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