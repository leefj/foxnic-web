/**
 * 虚拟效果视频展示 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:44:17
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
        var moduleURL="/service-tailoring/odr-virtual-effect/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#virtual_effect-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'orderId', sort: true, title: fox.translate('订单ID') } ,
                { field: 'measureId', sort: true, title: fox.translate('测量ID') } ,
                { field: 'productId', sort: true, title: fox.translate('商品ID') } ,
                { field: 'videoLocation', sort: true, title: fox.translate('视频地址') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#virtual_effect-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#virtual_effect-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(virtual_effect-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('虚拟效果视频展示')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('virtual_effect-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('odr-virtual-effect-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('虚拟效果视频展示')) : (fox.translate('添加')+fox.translate('虚拟效果视频展示'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/virtual_effect/virtual_effect_form.html',
                finish: function () {
                    table.reload('virtual_effect-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#virtual_effect-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#virtual_effect-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#virtual_effect-btn-search').click(function () {
            var field = $('#virtual_effect-search-field').val();
            var value = $('#virtual_effect-search-value').val();
            table.reload('virtual_effect-table', {where: {searchField: field, searchValue: value}});
        });
 
    });