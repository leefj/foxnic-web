/**
 * 订单商品关系 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-15 05:32:20
 */
 layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','formSelects'], function () {
        const form = layui.form;
        const table = layui.table;
        const settings = layui.settings;
        const formSelects = layui.formSelects;
        const layer = layui.layer;
        const util = layui.util;
        const admin = layui.admin;
        const fox = layui.foxnic;
        //上传
        const upload = layui.upload;
 
        
        //模块基础路径
        var moduleURL="/service-tailoring/odr-product/";

        function refreshProductInput() {
            formSelects.data('product-input', 'server', {
                type:"post",
                url: '/service-tailoring/odr-product/query-unused-list?orderId='+orderId
            });
        }
        refreshProductInput();

 
        // 渲染表格
        fox.renderTable({
        	elem: '#odr-product-table',
            url: moduleURL +'/query-paged-list?orderId='+orderId,
			cols: [[
			 	{ type:'checkbox' },
                { type: 'numbers' },
                { field: 'imageId', sort: true, title: fox.translate('商品图'),templet: function (d) { return '<img width="50px" height="50px" onclick="window.previewImage(this)"  src="/service-tailoring/sys-file/download?id='+ d.imageId+'" />'; } } ,
                { field: 'name', sort: true, title: fox.translate('商品') } ,
               // { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                { fixed: 'right', align: 'center', toolbar: '#odr-product-table-operation', title: fox.translate('操作'), width: 100 }
            ]]
        });
        
        //绑定 Switch 切换事件
        
       
       //重置搜索框
       function resetSearchFields() {
        	$('#label-search-field').val("");
			$('#label-search-value').val("");
			layui.form.render();
        }
 
        function refreshTableData() {
        	var field = $('#product-search-field').val();
            var value = $('#product-search-value').val();
            var ps={searchField: field, searchValue: value};
            table.reload('odr-product-table', { where : ps });
        }
        
        //添加按钮点击事件
        $('#odr-product-btn-add').click(function () {
        	///设置新增是初始化数据
            //debugger
            var products=formSelects.value('product-input', 'val');
            if(!products || products.length==0) {
                layer.msg(fox.translate('请选择一个商品'));
                return;
            }
            var data={
                orderId:orderId,
                productId:products[0]
            };
            admin.req(moduleURL+"insert", JSON.stringify(data), function (data) {
                layer.closeAll('loading');
                if (data.success) {
                    layer.msg(data.message, {icon: 1, time: 500});
                    //admin.finishPopupCenter();
                    refreshTableData();
                    refreshProductInput();
                    formSelects.value("product-input",[]);
                } else {
                    layer.msg(data.message, {icon: 2, time: 500});
                }
            }, "POST");
        });

        // 工具条点击事件
        table.on('tool(odr-product-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('订单商品关系')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.orderProductRelId }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            refreshTableData();
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }  
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('odr-product-form-data', data);
            var title = (data && data.id) ? (fox.translate('修改')+fox.translate('订单商品关系')) : (fox.translate('添加')+fox.translate('订单商品关系'));
            admin.popupCenter({
                title: title,
                path: '/pages/order/product/product_form.html',
                finish: function () {
                    refreshTableData();
                }
            });
        };
        
        
        //回车键查询
        $("#product-search-value").keydown(function(event) {
        	if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#product-btn-search').click(function () {
           refreshTableData();
        });
        
        
        //批量删除按钮点击事件
        $('#odr-product-btn-delete').click(function () {
          
            var ids=getCheckedList("orderProductRelId");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('商品')+"!");
            	return;
            }
 
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('订单商品关系')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/batch-delete", JSON.stringify({ id: JSON.stringify(ids) }), function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            refreshTableData();
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
			});
 
        });
  
        //获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
		function getCheckedList(field) {
			var checkStatus = table.checkStatus('odr-product-table');
			var data = checkStatus.data;
			if(!field) return data;
			for(var i=0;i<data.length;i++) data[i]=data[i][field];
			return data;
		}
 
        
       

    });