/**
 * 订单测量信息 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-16 09:44:30
 */
layui.use(['layer', 'admin', 'form', 'formSelects','upload','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/odr-measure/";
     
    form.render('radio');
    //渲染图片字段
    
    
     var formData = admin.getTempData('odr-measure-form-data');
     $('#measure-form').attr('method', 'POST');
     if (formData) {
     	form.val('measure-form', formData);
     	//设置并显示图片
     	$('#measure-form').attr('method', 'POST');
     }
     
     
 
 
    // 表单提交事件
    form.on('submit(measure-form-submit)', function (data) {
    	//debugger;
    	
    	//处理逻辑值
    	
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