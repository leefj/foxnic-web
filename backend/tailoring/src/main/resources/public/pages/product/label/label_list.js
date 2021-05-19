/**
 * 产品标签 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-02 04:36:26
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
 
        // 树形结构记录当前上级节点ID
        var parentId = 0;
        var navStack=[[0,fox.translate("根节点")]];
        
        //模块基础路径
        var moduleURL="/service-tailoring/prd-label/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#label-table',
            url: moduleURL +'/query-paged-list',
            //树形结构需要传递相关参数
            where: { parentId : parentId } ,
            //height: 'full-90',
			cols: [[
			 	{type:'checkbox'},
                {type: 'numbers'},
                { field: 'label', sort: true, title: fox.translate('标签') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime).substring(0,16);; } } ,
                {fixed: 'right', align: 'center', toolbar: '#label-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        //导航刷新函数
        function refreshNav() {
        	$("#tree-nav").empty();
			for (var i=0;i<navStack.length;i++) {
				var last=i==navStack.length-1;
	            $("#tree-nav").append("<a href='javascript:' class='nav-node' index='"+i+"'>"+navStack[i][1]+"</a>")
	            if(!last) {
	            	$("#tree-nav").append('<span lay-separator="">/</span>');
	            }
			}
			//点击事件
			$(".nav-node").click(function(it){
				it=$(this);
				//倒换
				var z=it.attr('index');
				var tmp=[];
				for (var i=0;i<=z;i++) {
					//debugger;
					tmp.push(navStack[i]);
				}
				navStack=tmp;
				parentId=navStack[navStack.length-1][0];
				resetSearchFields();
				//
				refreshTableData();
				refreshNav();
			});
        }
        
        //初始化导航
        refreshNav();
       
       //重置搜索框
       function resetSearchFields() {
        	$('#label-search-field').val("");
			$('#label-search-value').val("");
			layui.form.render();
        }
 
        function refreshTableData() {
        	var field = $('#label-search-field').val();
            var value = $('#label-search-value').val();
            var ps={searchField: field, searchValue: value};
            // 树形结构锁定上级ID
            ps.parentId=parentId;
            table.reload('label-table', { where : ps });
        }
        
        //添加按钮点击事件
        $('#label-btn-add').click(function () {
        	//设置新增是初始化数据
        	var data={};
        	data.parentId=parentId;
            showEditModel(data);
        });

        // 工具条点击事件
        table.on('tool(label-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('产品标签')+fox.translate('吗？'), function (i) {
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
            }  else if (layEvent === 'drill') {
            	parentId = data.id;
            	navStack.push([data.id,data.label]);
            	resetSearchFields();
            	refreshTableData();
            	refreshNav();
            } 
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 			//debugger
            admin.putTempData('prd-label-form-data', data);
            var title =(data && data.id) ? (fox.translate('修改')+fox.translate('产品标签')) : (fox.translate('添加')+fox.translate('产品标签'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/label/label_form.html',
                finish: function () {
                    refreshTableData();
                }
            });
        };
        
        
        //回车键查询
        $("#label-search-value").keydown(function(event) {
        	if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#label-btn-search').click(function () {
           refreshTableData();
        });
        
        
        //批量删除按钮点击事件
        $('#label-btn-delete').click(function () {
          
            var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('产品标签')+"!");
            	return;
            }
 
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('产品标签')+fox.translate('吗？'), function (i) {
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
			var checkStatus = table.checkStatus('label-table');
			var data = checkStatus.data;
			if(!field) return data;
			for(var i=0;i<data.length;i++) data[i]=data[i][field];
			return data;
		}

    });