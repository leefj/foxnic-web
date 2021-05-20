/**
 * 商品图片 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 08:44:51
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
        var moduleURL="/service-tailoring/prd-product-image/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#product_image-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'productId', sort: true, title: fox.translate('商品ID') } ,
                { field: 'fileId', sort: true, title: fox.translate('图片地址') } ,
                { field: 'isChief', sort: true, title: fox.translate('是否主图') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#product_image-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#product_image-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(product_image-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('商品图片')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('product_image-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('prd-product-image-form-data', data);
            var title = (data && data.id) ? (fox.translate('修改')+fox.translate('商品图片')) : (fox.translate('添加')+fox.translate('商品图片'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/product_image/product_image_form.html',
                finish: function () {
                    table.reload('product_image-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#product_image-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#product_image-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#product_image-btn-search').click(function () {
            var field = $('#product_image-search-field').val();
            var value = $('#product_image-search-value').val();
            table.reload('product_image-table', {where: {searchField: field, searchValue: value}});
        });
 
    });