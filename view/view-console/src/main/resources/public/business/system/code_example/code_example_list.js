/**
 * 代码生成示例 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-03 17:43:11
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-system/sys-code-example";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
     	//渲染表格
     	renderTable();
		//初始化搜索输入框组件
		initSearchFields();
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
		$(window).resize(function() {
			adjustSearchElement();
		});
		adjustSearchElement();
		//
		var h=$(".search-bar").height();
		fox.renderTable({
			elem: '#data-table',
            url: moduleURL +'/query-paged-list',
		 	height: 'full-'+(h+38), // 请按工具栏等组件的实际情况调整高度
		 	limit: 50,
			cols: [[
				{  fixed: 'left',type: 'numbers' },
			 	{  fixed: 'left',type:'checkbox' },
                { field: 'id', align:"left", hide:true, sort: true, title: fox.translate('ID')} ,
                { field: 'name', align:"left", hide:false, sort: true, title: fox.translate('单行文本')} ,
                { field: 'notes', align:"left", hide:true, sort: true, title: fox.translate('多行文本')} ,
				{ field: 'imageId', align:"left", hide:true, sort: true, title: fox.translate('图片上传'), templet: function (d) { return '<img style="height:100%;" fileType="image/png" onclick="window.previewImage(this)"  src="'+apiurls.storage.image+'?id='+ d.imageId+'" />'; } } ,
                { field: 'fileIds', align:"left", hide:true, sort: true, title: fox.translate('多文件上传')} ,
                { field: 'area', align:"right", hide:false, sort: true, title: fox.translate('整数输入')} ,
                { field: 'weight', align:"right", hide:false, sort: true, title: fox.translate('小数输入')} ,
                { field: 'valid', align:"right", hide:false, sort: true, title: fox.translate('逻辑值')} ,
                { field: 'radioEnum', align:"left", hide:false, sort: true, title: fox.translate('单选框(枚举)')} ,
                { field: 'radioDict', align:"left", hide:false, sort: true, title: fox.translate('单选框(字典)')} ,
                { field: 'checkEnum', align:"left", hide:false, sort: true, title: fox.translate('复选框(枚举)')} ,
                { field: 'checkDict', align:"left", hide:false, sort: true, title: fox.translate('复选框(字典)')} ,
                { field: 'selectEnum', align:"left", hide:false, sort: true, title: fox.translate('选择框(枚举)')} ,
                { field: 'selectDict', align:"left", hide:false, sort: true, title: fox.translate('选择框(字典)')} ,
                { field: 'selectApi', align:"left", hide:false, sort: true, title: fox.translate('选择框(查询)')} ,
                { field: 'birthday', align:"right", hide:false, sort: true, title: fox.translate('日期')} ,
                { field: 'createTime', align:"right", hide:false, sort: true, title: fox.translate('创建时间')} ,
				{ field: 'row-space', align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true},
				{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 125 }
            ]],
			footer : {
				exportExcel : admin.checkAuth(AUTH_PREFIX+":export"),
				importExcel : admin.checkAuth(AUTH_PREFIX+":import")?{
					params : {} ,
				 	callback : function(r) {
						if(r.success) {
							layer.msg(fox.translate('数据导入成功')+"!");
						} else {
							layer.msg(fox.translate('数据导入失败')+"!");
						}
					}
			 	}:false
		 	}
        });
        //绑定排序事件
        table.on('sort(data-table)', function(obj){
		  refreshTableData(obj.field,obj.type);
        });
    };

	/**
	 * 调整搜索相关的尺寸
	 * */
	function adjustSearchElement() {
		var divs=$(".search-label-div");
		var maxWidth=0;
		for (var i = 0; i < divs.length; i++) {
			var div=$(divs[i]);
			var w=div.width();
			if(maxWidth<w) maxWidth=w;
		}
		divs.width(maxWidth);
		var h=$(".search-bar").height();
		$(".search-buttons").css("margin-top",(h-$(".search-buttons").height()-8)+"px");
		var ks=$(window).width()-$(".search-buttons").width()-16;
		$(".search-buttons").css("left",ks+"px");
		$(".search-input-rows").animate({opacity:'1.0'},0.25);
		$(".search-buttons").animate({opacity:'1.0'},0.25);

	}
     
	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType) {
		var value = {};
		value.name={ value: $("#name").val() };
		value.notes={ value: $("#notes").val() };
		value.area={ value: $("#area").val() };
		value.weight={ value: $("#weight").val() };
		value.valid={ value: $("#valid").val() };
		value.radioEnum={ value: $("#radioEnum").val() };
		value.radioDict={ value: $("#radioDict").val() };
		value.selectEnum={ value: $("#selectEnum").val() };
		value.selectDict={ value: $("#selectDict").val() };
		value.selectApi={ value: $("#selectApi").val() };
		value.birthday={ value: $("#birthday").val() };
		var ps={searchField: "$composite", searchValue: JSON.stringify(value),sortField: sortField,sortType: sortType};
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

	function initSearchFields() {
		fox.limitInput("#area",/[^0-9]/g);
		fox.limitInput("#weight",/[^0-9.]/g);
	}
	
	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {
		//回车键查询
        $(".search-input").keydown(function(event) {
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
          
			var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('代码生成示例')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('代码生成示例')+fox.translate('吗？'), function (i) {
				layer.close(i);
				layer.load(2);
                admin.request(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    layer.closeAll('loading');
                    if (data.success) {
                        layer.msg(data.message, {icon: 1, time: 500});
                        refreshTableData();
                    } else {
                        layer.msg(data.message, {icon: 2, time: 1500});
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
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						 showEditForm(data.data);
					} else {
						 layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
				
			} else if (layEvent === 'del') { // 删除
			
				layer.confirm(fox.translate('确定删除此')+fox.translate('代码生成示例')+fox.translate('吗？'), function (i) {
					layer.close(i);
					layer.load(2);
					admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
						layer.closeAll('loading');
						if (data.success) {
							layer.msg(data.message, {icon: 1, time: 500});
							refreshTableData();
						} else {
							layer.msg(data.message, {icon: 2, time: 1500});
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
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('sys-code-example-form-data', data);
		var area=admin.getTempData('sys-code-example-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('代码生成示例')) : (fox.translate('添加')+fox.translate('代码生成示例'));
		admin.popupCenter({
			title: title,
			resize: true,
			offset: [top,null],
			area: ["500px",height+"px"],
			type: 2,
			content: '/business/system/code_example/code_example_form.html' + queryString,
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
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate'],function() {
	(new ListPage()).init(layui);
});