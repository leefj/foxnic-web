 layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic'], function () {
        var form = layui.form;
        var table = layui.table;
        var settings = layui.settings;
        var layer = layui.layer;
        var util = layui.util;
        var admin = layui.admin;
        var fox = layui.foxnic;
        //上传
        var upload = layui.upload;
 
        //模块基础路径
        var moduleURL="/service-tailoring/sys-user";
        
        function ts(t) {
        	return fox.translate(t);
        }

        // 渲染表格
        fox.renderTable({
        	elem: '#user-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                {field: 'id', sort: true, title: fox.translate('编号')},
                {field: 'account', sort: true, title: fox.translate('账号')},
                {field: 'name', sort: true, title: fox.translate('用户名')},
                {field: 'mobile', sort: true, title: fox.translate('手机号')},
//                {sort: true, title: '性别',templet:function (d) {
//                        return fox.transDict("sex",d.sex);
//                }},
                {
                    sort: true, templet: function (d) {
                        return util.toDateString(d.createTime).substring(0,16);
                    }, title: fox.translate('创建时间')
                },
                {field: 'enabled', sort: true, templet: '#user-tpl-state', title: fox.translate('状态')},
                {fixed: 'right', align: 'center', toolbar: '#user-table-bar', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#user-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(user-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'edit') { // 修改
            	admin.req(moduleURL+"/get-by-id", {id:data.id}, function (data) {
            		if(data.success) {
            			 showEditModel(data.data);
            		} else {
            			 layer.msg(data.message, {icon: 1, time: 500});
            		}
            	});
            	
            } else if (layEvent === 'reset') { // 重置密码
                layer.confirm(fox.translate('确定重置此用户的密码吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/reset-passwd", {id:obj.data.id}, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            } else if (layEvent === 'del') { // 删除
                layer.confirm(fox.translate('确定删除此用户吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", {id:obj.data.id}, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('user-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
            //修改sex值
            if (data){
                data.sex = data.sex+'';
            }
            admin.putTempData('t_user', data);
            var title = (data&&data.id) ? ts('修改用户') : ts('添加用户');
            admin.popupCenter({
                title: title,
                path: 'pages/system/user/user_form.html',
                finish: function () {
                    table.reload('user-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#user-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#user-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#user-btn-search').click(function () {
            var field = $('#user-search-field').val();
            var value = $('#user-search-value').val();
            table.reload('user-table', {where: {searchField: field, searchValue: value}});
        });
 
        
        function bindSwitchEvent(layFilter) {
        	// 修改user状态
	        form.on('switch('+layFilter+')', function (obj) {
	            layer.load(2);
	            admin.req(moduleURL +'/update', {
	                id: obj.elem.value,
	                valid: obj.elem.checked ? 1 : 0
	            }, function (data) {
	                layer.closeAll('loading');
	                if (data.success) {
	                    layer.msg(data.message, {icon: 1, time: 500});
	                    //table.reload('table-user', {});
	                } else {
	                    layer.msg(data.resp_msg, {icon: 2, time: 500});
	                    $(obj.elem).prop('checked', !obj.elem.checked);
	                    form.render('checkbox');
	                }
	            }, 'POST');
	        });
        };
        
        //绑定切换时间
        bindSwitchEvent("user-tpl-state");
        
        
        	
        


 
    });