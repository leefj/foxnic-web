/**
 * 商品面料关系 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-12 02:24:36
 */
 layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','formSelects'], function () {
        var form = layui.form;
        var table = layui.table;
        var settings = layui.settings;
        var formSelects = layui.formSelects;
        var layer = layui.layer;
        var util = layui.util;
        var admin = layui.admin;
        var fox = layui.foxnic;
        //上传
        var upload = layui.upload;
 
        function refreshFabricInput() {
        	formSelects.btns('fabirc-input', ['remove']);
	 		formSelects.data('fabirc-input', 'server', {
		 		url: '/service-tailoring/prd-product-fabric/query-choose-list?productId='+productId
	 		});
        }
        refreshFabricInput();
        
        //模块基础路径
        var moduleURL="/service-tailoring/prd-product-fabric/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#product_fabric-table',
            url: moduleURL +'/query-paged-list?productId='+productId,
			cols: [[
			 	{ type:'checkbox' },
                { type: 'numbers' },
               // { field: 'productId', sort: true, title: fox.translate('商品ID') } ,
                { field: 'fabricName', sort: true, title: fox.translate('面料') } ,
                { field: 'effectId', sort: true, title: fox.translate('商品图') ,
                    templet: function (d) {
                    	if(!d.effectId) return "";
                    	return '<img width="50px" height="50px" onclick="window.previewImage(this)"  src="/service-tailoring/sys-file/download?id='+ d.effectId+'" />'; 
                    }
                } ,
                { field: 'virtualId', sort: true, title: fox.translate('虚拟编码') } ,
                { field: 'effectImageId', sort: true, title: fox.translate('虚拟效果') ,
                    templet: function (d)
                    {
                        if(!d.virtual || !d.virtual.effectFileId) return "";
                        return '<img width="50px" height="50px" onclick="window.previewImage(this)"  src="/service-tailoring/sys-file/download?id='+ d.virtual.effectFileId+'" />';
                    }
                } ,
                // { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                { fixed: 'right', align: 'center', toolbar: '#product_fabric-table-operation', title: fox.translate('操作'), width: 120 }
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
        	var field = $('#product_fabric-search-field').val();
            var value = $('#product_fabric-search-value').val();
            var ps={searchField: field, searchValue: value};
            table.reload('product_fabric-table', { where : ps });
        }
        
        //添加按钮点击事件
        $('#product_fabric-btn-add').click(function () {
        	//设置新增是初始化数据
        	var fabrics=formSelects.value('fabirc-input', 'val');
        	if(!fabrics || fabrics.length==0) {
        		layer.msg(fox.translate('请选择一个面料'));
        		return;
        	}
        	var data={
        		productId:productId,
        		fabricId:fabrics[0]
        	};
			admin.req(moduleURL+"insert", JSON.stringify(data), function (data) {
                layer.closeAll('loading');
                if (data.success) {
                    layer.msg(data.message, {icon: 1, time: 500});
                    //admin.finishPopupCenter();
                    refreshTableData();
                    refreshFabricInput();
                    formSelects.value("fabirc-input",[]);
                } else {
                    layer.msg(data.message, {icon: 2, time: 500});
                }
            }, "POST");
        	
        });

        // 工具条点击事件
        table.on('tool(product_fabric-table)', function (obj) {
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
            	
            } else if (layEvent === 'img') { // 图片
            	showUpload(data.id);
            }
            else if (layEvent === 'del') { // 删除
                layer.confirm(fox.translate('确定删除此')+fox.translate('商品面料关系')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            refreshTableData();
                            refreshFabricInput();
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }  
        });
        
        function showUpload(id){
        //	debugger;
        	layer.open({
				title: "上传",
				area:["160px","280px"],
				type: 2, 
				content: '/pages/product/product_fabric/upload.html',
				btn:["确定"],
				yes: function(index, layero) {
				    layer.close(index);
				    let imgId=localStorage.getItem("product-fabric-image-id");
				    //alert(imgId);
				    if(!imgId) {
				    	layer.msg("图片未上传");
				    	return;
				    }
				    var api=moduleURL+"update";
			        admin.req(api, JSON.stringify({id:id,effectId:imgId}), function (data) {
			            layer.closeAll('loading');
			            if (data.success) {
			                refreshTableData();
			            } else {}
			        }, "POST");
				  }
			}); 
//        	 admin.popupCenter({
//                title: "上传图片",
//                path: '/demo/upload.html',
//                finish: function () {
//                    refreshTableData();
//                }
//            });
        }

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('prd-product-fabric-form-data', data);
            var title = (data && data.id) ? (fox.translate('修改')+fox.translate('商品面料关系')) : (fox.translate('添加')+fox.translate('商品面料关系'));
            admin.popupCenter({
                title: title,
                index:20,
                path: '/pages/product/product_fabric/product_fabric_form.html',
                finish: function () {
                    refreshTableData();
                }
            });
        };
        
        
        //回车键查询
        $("#product_fabric-search-value").keydown(function(event) {
        	if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#product_fabric-btn-search').click(function () {
           refreshTableData();
        });
        
        
        //批量删除按钮点击事件
        $('#product_fabric-btn-delete').click(function () {
          
            var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('商品面料关系')+"!");
            	return;
            }
 
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('商品面料关系')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/batch-delete", JSON.stringify({ id: JSON.stringify(ids) }), function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            refreshTableData();
                            refreshFabricInput();
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
			});
        });
  
        //获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
		function getCheckedList(field) {
			var checkStatus = table.checkStatus('product_fabric-table');
			var data = checkStatus.data;
			if(!field) return data;
			for(var i=0;i<data.length;i++) data[i]=data[i][field];
			return data;
		}
 
        
       

    });