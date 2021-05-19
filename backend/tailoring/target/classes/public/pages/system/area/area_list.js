/**
 * 区域 列表页 JS 脚本
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
        var moduleURL="/service-tailoring/sys-area/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#area-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('区域ID') } ,
                { field: 'parentId', sort: true, title: fox.translate('父级ID') } ,
                { field: 'name', sort: true, title: fox.translate('区域名称') } ,
                { field: 'depth', sort: true, title: fox.translate('等级（深度）') } ,
                { field: 'createdBy', sort: true, title: fox.translate('创建人id') } ,
                { field: 'updatedBy', sort: true, title: fox.translate('修改人id') } ,
                { field: 'createDate', sort: true, title: fox.translate('创建时间') } ,
                { field: 'updateDate', sort: true, title: fox.translate('修改时间') } ,
                { field: 'valid', sort: true, title: fox.translate('数据是否有效') } ,
                {fixed: 'right', align: 'center', toolbar: '#area-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#area-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(area-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('区域')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('area-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('sys-area-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('区域')) : (fox.translate('添加')+fox.translate('区域'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/area/area_form.html',
                finish: function () {
                    table.reload('area-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#area-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#area-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#area-btn-search').click(function () {
            var field = $('#area-search-field').val();
            var value = $('#area-search-value').val();
            table.reload('area-table', {where: {searchField: field, searchValue: value}});
        });
 
    });