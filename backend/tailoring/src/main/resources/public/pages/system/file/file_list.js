/**
 * 系统文件 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:24
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
        var moduleURL="/service-tailoring/sys-file/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#file-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'fileName', sort: true, title: fox.translate('文件名') } ,
                { field: 'location', sort: true, title: fox.translate('存储位置') } ,
                { field: 'size', sort: true, title: fox.translate('文件大小') } ,
                { field: 'fileType', sort: true, title: fox.translate('文件类型') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#file-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#file-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(file-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('系统文件')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('file-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('sys-file-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('系统文件')) : (fox.translate('添加')+fox.translate('系统文件'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/file/file_form.html',
                finish: function () {
                    table.reload('file-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#file-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#file-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#file-btn-search').click(function () {
            var field = $('#file-search-field').val();
            var value = $('#file-search-value').val();
            table.reload('file-table', {where: {searchField: field, searchValue: value}});
        });
 
    });