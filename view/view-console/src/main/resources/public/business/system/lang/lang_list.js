/**
 * 语言条目 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 15:31:14
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-system/sys-lang";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
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
			 	{  fixed: 'left',type:'checkbox' },
                {  fixed: 'left',type: 'numbers' },
                { field: 'code', sort: true, title: fox.translate('编码键'),hide:true } ,
                { field: 'defaults', sort: true, title: fox.translate('默认') } ,
                { field: 'zhCh', sort: true, title: fox.translate('简体中文') } ,
                { field: 'zhTw', sort: true, title: fox.translate('繁体中文') } ,
                { field: 'enUs', sort: true, title: fox.translate('英文美国') } ,
                { field: 'enUk', sort: true, title: fox.translate('英文英国') } ,
                { field: 'confuse', sort: true, title: fox.translate('混淆专用') } ,
                //{ field: 'valid', sort: true, title: fox.translate('是否有效') } ,
                //{ field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return fox.dateFormat(d.createTime); } } ,
                { field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 125 }
            ]]
	 		,footer : {
				exportExcel : true,
				importExcel : {
					params : {} ,
				 	callback : function(r) {
						if(r.success) {
							layer.msg(fox.translate('数据导入成功')+"!");
						} else {
							layer.msg(fox.translate('数据导入失败')+"!");
						}
					}
			 	}
		 	}
        });
        //绑定排序事件
        table.on('sort(data-table)', function(obj){
		  refreshTableData(obj.field,obj.type);
        });
     };
     
	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType) {
		var field = $('#search-field').val();
		var value = $('#search-input').val();
		var ps={searchField: field, searchValue: value,sortField:sortField,sortType:sortType};
		table.reload('data-table', { where : ps });
	}
    
	
	/**
	  * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	  */
	function getCheckedList(field) {
		var checkStatus = table.checkStatus('data-table');
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
            showEditForm(data);
        });
		
        //批量删除按钮点击事件
        $('#delete-button').click(function () {
          
			var ids=getCheckedList("code");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('语言条目')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('语言条目')+fox.translate('吗？'), function (i) {
				layer.close(i);
				layer.load(2);
                admin.request(moduleURL+"/batch-delete", { codes: ids } , function (data) {
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
		table.on('tool(data-table)', function (obj) {
			var data = obj.data;
			var layEvent = obj.event;
	
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { code : data.code }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						 showEditForm(data.data);
					} else {
						 layer.msg(data.message, {icon: 1, time: 500});
					}
				});
				
			} else if (layEvent === 'del') { // 删除
			
				layer.confirm(fox.translate('确定删除此')+fox.translate('语言条目')+fox.translate('吗？'), function (i) {
					layer.close(i);
					layer.load(2);
					admin.request(moduleURL+"/delete", { code : data.code }, function (data) {
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
 
    };
    
    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {
		var queryString="";
		if(data && data.code) queryString="?" + 'code=' + data.code;
		admin.putTempData('sys-lang-form-data', data);
		var area=admin.getTempData('sys-lang-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= ($(window).height()-height)/2;
		var title = (data && data.code) ? (fox.translate('修改')+fox.translate('语言条目')) : (fox.translate('添加')+fox.translate('语言条目'));
		admin.popupCenter({
			title: title,
			resize:true,
			offset:[top,null],
			area:["500px",height+"px"],
			type: 2,
			content: '/business/system/lang/lang_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
	};

};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect'],function() {
	(new ListPage()).init(layui);
});