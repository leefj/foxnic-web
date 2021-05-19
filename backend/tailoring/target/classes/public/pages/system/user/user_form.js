layui.use(['layer', 'admin', 'form', 'formSelects','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
     var fox = layui.foxnic;

    form.render('radio');

    // 获取所有角色
    layer.load(2);
    admin.req("/service-tailoring/sys-role/query-list", {}, function (data) {
        layer.closeAll('loading');
        if (data.success) {
            // 渲染多选下拉框
            var roleSelectData = new Array();
            for (var i = 0; i < data.data.length; i++) {
                roleSelectData.push({name: data.data[i].name, value: data.data[i].id});
            }
            formSelects.data('roleId', 'local', {arr: roleSelectData});
			//debugger;
            // 回显user数据
            var user = admin.getTempData('t_user');
            //debugger;
            console.log(user);
            $('#user-form').attr('method', 'POST');
            if (user) {
                form.val('user-form', user);
                $('#user-form').attr('method', 'POST');
                var rds = new Array();
                for (var i = 0; i < user.roleIds.length; i++) {
                    rds.push(user.roleIds[i]);
                }
                formSelects.value('roleId', rds);
            }
        } else {
            layer.msg('获取角色失败', {icon: 2, time: 500});
        }
    }, 'POST');

    
    // 表单提交事件
    form.on('submit(user-form-submit)', function (data) {
    	//debugger;
    	var api="service-tailoring/sys-user/"+(data.field.id?"update":"insert");
        layer.load(2);
        data.field.roleIds=data.field.roleId;
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