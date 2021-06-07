/**
 * 虚拟试衣 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-09 01:57:23
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
        var moduleURL="/service-tailoring/prd-virtual-library/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#virtual_library-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
			 	{ type:'checkbox' },
                { type: 'numbers' },
                { field: 'productId', sort: true, title: fox.translate('商品') , templet: function(d){return d.productName} } ,
                { field: 'fabricId', sort: true, title: fox.translate('面料') , templet: function(d){return d.fabricName} } ,
                { field: 'effectFileId', sort: true, title: fox.translate('效果图') , templet: function (d) {
                    if(!d.effectFileId) return "";
                    return '<img width="50px" height="50px" onclick="window.previewImage(this)"  src="/service-tailoring/sys-file/download?id='+ d.effectFileId+'" />';
                } } ,
                { field: 'valid', sort: true, title: fox.translate('是否有效'), templet: '#cell-tpl-valid' } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                { fixed: 'right', align: 'center', toolbar: '#virtual_library-table-operation', title: fox.translate('操作'), width: 175 }
            ]]
        });
        
        //绑定 Switch 切换事件
        fox.bindSwitchEvent("cell-tpl-valid",moduleURL +'/update',function(r){});
        
       
       //重置搜索框
       function resetSearchFields() {
        	$('#label-search-field').val("");
			$('#label-search-value').val("");
			layui.form.render();
        }
 
        function refreshTableData() {
        	var field = $('#virtual_library-search-field').val();
            var value = $('#virtual_library-search-value').val();
            var ps={searchField: field, searchValue: value};
            table.reload('virtual_library-table', { where : ps });
        }
        
        //添加按钮点击事件
        $('#virtual_library-btn-add').click(function () {
        	//设置新增是初始化数据
        	var data={};
            showEditModel(data);
        });

        // 工具条点击事件
        table.on('tool(virtual_library-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('虚拟试衣')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
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
 
            admin.putTempData('prd-virtual-library-form-data', data);
            var title = (data && data.id) ? (fox.translate('修改')+fox.translate('虚拟试衣')) : (fox.translate('添加')+fox.translate('虚拟试衣'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/virtual_library/virtual_library_form.html',
                finish: function () {
                    refreshTableData();
                }
            });
        };
        
        
        //回车键查询
        $("#virtual_library-search-value").keydown(function(event) {
        	if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#virtual_library-btn-search').click(function () {
           refreshTableData();
        });
        
        
        //批量删除按钮点击事件
        $('#virtual_library-btn-delete').click(function () {
          
            var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('虚拟试衣')+"!");
            	return;
            }
 
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('虚拟试衣')+fox.translate('吗？'), function (i) {
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
			var checkStatus = table.checkStatus('virtual_library-table');
			var data = checkStatus.data;
			if(!field) return data;
			for(var i=0;i<data.length;i++) data[i]=data[i][field];
			return data;
		}
 
        
       

    });