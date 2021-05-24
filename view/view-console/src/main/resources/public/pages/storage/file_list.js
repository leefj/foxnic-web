/**
 * 系统文件 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-24 05:39:03
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
        var moduleURL="";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#',
            url: moduleURL +'/query-paged-list',
			cols: [[
			 	{ type:'checkbox' },
                { type: 'numbers' },
                { fixed: 'right', align: 'center', toolbar: '#', title: fox.translate('操作'), width: 175 }
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
        	var field = $('#file-search-field').val();
            var value = $('#').val();
            var ps={searchField: field, searchValue: value};
            table.reload('', { where : ps });
        }
        
        //添加按钮点击事件
        $('#').click(function () {
        	//设置新增是初始化数据
        	var data={};
            showEditModel(data);
        });

        // 工具条点击事件
        table.on('tool()', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'edit') { // 修改
            	admin.req(moduleURL+"/get-by-id", {  }, function (data) {
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
                    admin.req(moduleURL+"/delete", {  }, function (data) {
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
 
            admin.putTempData('', data);
            var title = (data && data.) ? (fox.translate('修改')+fox.translate('系统文件')) : (fox.translate('添加')+fox.translate('系统文件'));
            admin.popupCenter({
                title: title,
                path: '',
                finish: function () {
                    refreshTableData();
                }
            });
        };
        
        
        //回车键查询
        $("#").keydown(function(event) {
        	if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#').click(function () {
           refreshTableData();
        });
        
        
  
        //获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
		function getCheckedList(field) {
			var checkStatus = table.checkStatus('');
			var data = checkStatus.data;
			if(!field) return data;
			for(var i=0;i<data.length;i++) data[i]=data[i][field];
			return data;
		}
 
        
       

    });