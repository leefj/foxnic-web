/**
 * 公司员工关系 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:25
 */
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
        var moduleURL="/service-tailoring/crm-employee/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#employee-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'departmentId', sort: true, title: fox.translate('所属部门ID') } ,
                { field: 'companyId', sort: true, title: fox.translate('公司ID') } ,
                { field: 'userId', sort: true, title: fox.translate('用户ID') } ,
                { field: 'name', sort: true, title: fox.translate('员工姓名') } ,
                { field: 'sex', sort: true, title: fox.translate('员工性别') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#employee-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#employee-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(employee-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'edit') { // 修改
            	admin.req(moduleURL+"/get-by-id", { id : data.id }, function (data) {
            		if(data.success) {
            			 showEditModel(data.data);
            		} else {
            			 layer.msg(data.message, {icon: 1, time: 500});
            		}
            	});
            	
            } else if (layEvent === 'del') { // 删除
                layer.confirm(fox.translate('确定删除此')+fox.translate('公司员工关系')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('employee-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('crm-employee-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('公司员工关系')) : (fox.translate('添加')+fox.translate('公司员工关系'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/employee/employee_form.html',
                finish: function () {
                    table.reload('employee-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#employee-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#employee-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#employee-btn-search').click(function () {
            var field = $('#employee-search-field').val();
            var value = $('#employee-search-value').val();
            table.reload('employee-table', {where: {searchField: field, searchValue: value}});
        });
 
    });