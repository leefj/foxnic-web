/**
 * 数据字典条目 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:22
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
        var moduleURL="/service-tailoring/sys-dict-item/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#dict_item-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'dictId', sort: true, title: fox.translate('字典ID') } ,
                { field: 'dictCode', sort: true, title: fox.translate('字典代码') } ,
                { field: 'code', sort: true, title: fox.translate('代码') } ,
                { field: 'label', sort: true, title: fox.translate('标签') } ,
                { field: 'sort', sort: true, title: fox.translate('排序') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#dict_item-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#dict_item-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(dict_item-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('数据字典条目')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('dict_item-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('sys-dict-item-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('数据字典条目')) : (fox.translate('添加')+fox.translate('数据字典条目'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/dict_item/dict_item_form.html',
                finish: function () {
                    table.reload('dict_item-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#dict_item-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#dict_item-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#dict_item-btn-search').click(function () {
            var field = $('#dict_item-search-field').val();
            var value = $('#dict_item-search-value').val();
            table.reload('dict_item-table', {where: {searchField: field, searchValue: value}});
        });
 
    });