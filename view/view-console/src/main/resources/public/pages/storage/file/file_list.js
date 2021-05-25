/**
 * 系统文件 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-05-25 02:58:15
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload;
	//模块基础路径
	const moduleURL="/service-storage/sys-file";
	
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic;
		
     	//渲染表格
     	renderTable();
		//绑定搜索框事件
		bindSearchEvent();
		//绑定按钮事件
		bindButtonEvent();
		//绑定行操作按钮事件
    	bindRowOperationEvent();
     }
     
     
     /**
      * 渲染表格
      */
     function renderTable() {
     
		fox.renderTable({
			elem: '#data-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
			 	{ type:'checkbox' },
                { type: 'numbers' },
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'fileName', sort: true, title: fox.translate('文件名') } ,
                { field: 'location', sort: true, title: fox.translate('存储位置') } ,
                { field: 'size', sort: true, title: fox.translate('文件大小') } ,
                { field: 'fileType', sort: true, title: fox.translate('文件类型') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                { fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 175 }
            ]]
        });
        
     };
     
	/**
      * 刷新表格数据
      */
	function refreshTableData() {
		var field = $('#search-field').val();
		var value = $('#search-input').val();
		var ps={searchField: field, searchValue: value};
		table.reload('data-table', { where : ps });
	}
    
	
	/**
	  * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	  */
	function getCheckedList(field) {
		var checkStatus = table.checkStatus('#data-table');
		var data = checkStatus.data;
		if(!field) return data;
		for(var i=0;i<data.length;i++) data[i]=data[i][field];
		return data;
	}
	
	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {
		$('#search-field').val("");
		$('#search-input').val("");
		layui.form.render();
	}
	
	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {
		//回车键查询
        $("#search-input").keydown(function(event) {
			if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#search-button').click(function () {
           refreshTableData();
        });
	}
	
	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {
	
		//添加按钮点击事件
        $('#add-button').click(function () {
        	//设置新增是初始化数据
        	var data={};
            showEditModel(data);
        });
		
        //批量删除按钮点击事件
        $('#delete-button').click(function () {
          
			var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('系统文件')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('系统文件')+fox.translate('吗？'), function (i) {
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
	}
     
    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {
		// 工具条点击事件
		table.on('tool(#data-table)', function (obj) {
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
			var title = (data && data.id) ? (fox.translate('修改')+fox.translate('系统文件')) : (fox.translate('添加')+fox.translate('系统文件'));
			admin.popupCenter({
				title: title,
				path: '',
				finish: function () {
					refreshTableData();
				}
			});
		};
    }

};


layui.config({
	base: '/module/'
}).extend({
	xmSelect: '/xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic'],function() {
	(new ListPage()).init(layui);
});