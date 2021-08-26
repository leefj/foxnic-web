/**
 * 账户 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 15:35:43
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-oauth/sys-user";
	var dataTable=null;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

		if(window.pageExt.list.beforeInit) {
			window.pageExt.list.beforeInit();
		}
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
			fox.adjustSearchElement();
		});
		fox.adjustSearchElement();
		//
		function renderTableInternal() {

			var ps={};
			var contitions={};
			window.pageExt.list.beforeQuery && window.pageExt.list.beforeQuery(contitions);
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}

			var h=$(".search-bar").height();
			dataTable=fox.renderTable({
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox' }
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('账户') }
					,{ field: 'portraitId', align:"center", fixed:false, hide:false, sort: true, title: fox.translate('头像'), templet: function (d) { return '<img style="height:100%;" fileType="image/png" onclick="window.previewImage(this)"  src="'+apiurls.storage.image+'?id='+ d.portraitId+'" />'; } }
					,{ field: 'language', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('语言'), templet:function (d){ return fox.getEnumText(RADIO_LANGUAGE_DATA,d.language);}}
					,{ field: 'phone', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('手机') }
					,{ field: 'valid', align:"center",fixed:false,  hide:false, sort: true, title: fox.translate('是否有效'), templet: '#cell-tpl-valid'}
					,{ field: 'roleIds', align:"",fixed:false,  hide:false, sort: true, title: fox.translate('角色'), templet: function (d) { return fox.joinLabel(d.roles,"name");}}
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') }
					,{ field: 'passwd', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('密码') }
					,{ field: 'cacheKey', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('缓存键') }
					,{ field: 'lastLoginTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('最后登录时间'), templet: function (d) { return fox.dateFormat(d.lastLoginTime); }}
					,{ field: 'createTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('创建时间'), templet: function (d) { return fox.dateFormat(d.createTime); }}
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
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
			//绑定 Switch 切换事件
			fox.bindSwitchEvent("cell-tpl-valid",moduleURL +'/update','id','valid',function(r){});
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
			  refreshTableData(obj.field,obj.type);
			});
		}
		setTimeout(renderTableInternal,1);
    };

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType) {
		var value = {};
		value.name={ value: $("#name").val()};
		value.phone={ value: $("#phone").val()};
		value.language={ value: xmSelect.get("#language",true).getValue("value"), label:xmSelect.get("#language",true).getValue("nameStr")};
		value.valid={ value: xmSelect.get("#valid",true).getValue("value"), label:xmSelect.get("#valid",true).getValue("nameStr") };
		value.roleIds={ value: xmSelect.get("#roleIds",true).getValue("value"), fillBy:"roles",field:"id", label:xmSelect.get("#roleIds",true).getValue("nameStr") };
		window.pageExt.list.beforeQuery && window.pageExt.list.beforeQuery(value);
		var ps={searchField: "$composite", searchValue: JSON.stringify(value)};
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
		}
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

		fox.switchSearchRow(1);

		//渲染 language 搜索框
		fox.renderSelectBox({
			el: "language",
			size: "small",
			radio: false,
			//toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 valid 搜索框
		fox.renderSelectBox({
			el: "valid",
			size: "small",
			radio: false
		});
		//渲染 roleIds 下拉字段
		fox.renderSelectBox({
			el: "roleIds",
			radio: false,
			size: "small",
			filterable: true,
			toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
		fox.renderSearchInputs();
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

		// 搜索按钮点击事件
		$('#search-button-advance').click(function () {
			fox.switchSearchRow(1,function (ex){
				if(ex=="1") {
					$('#search-button-advance span').text("关闭");
				} else {
					$('#search-button-advance span').text("更多");
				}
			});
		});
	}
	
	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {

		//头工具栏事件
		table.on('toolbar(data-table)', function(obj){
			var checkStatus = table.checkStatus(obj.config.id);
			var selected=getCheckedList("id");
			switch(obj.event){
				case 'create':
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'refresh-data':
					refreshTableData();
					break;
				case 'other':
					break;
			};
		});


		//添加按钮点击事件
        function openCreateFrom() {
        	//设置新增是初始化数据
        	var data={};
			admin.putTempData('sys-user-form-data-form-action', "create",true);
            showEditForm(data);
        };
		
        //批量删除按钮点击事件
        function batchDelete(selected) {
          
			var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('账户')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('账户')+fox.translate('吗？'), function (i) {
				layer.close(i);
				if(window.pageExt.list.beforeBatchDelete) {
					var doNext=window.pageExt.list.beforeBatchDelete(selected);
					if(!doNext) return;
				}
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
        }
	}
     
    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {
		// 工具条点击事件
		table.on('tool(data-table)', function (obj) {
			var data = obj.data;
			var layEvent = obj.event;
			admin.putTempData('sys-user-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('sys-user-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('sys-user-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除
			
				layer.confirm(fox.translate('确定删除此')+fox.translate('账户')+fox.translate('吗？'), function (i) {
					layer.close(i);

					if(window.pageExt.list.beforeSingleDelete) {
						var doNext=window.pageExt.list.beforeSingleDelete(data);
						if(!doNext) return;
					}

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
			else if (layEvent === 'open-tenant-owner') { // 属主
				window.pageExt.list.openTenantOwner(data);
			}
			
		});
 
    };
    
    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {
		if(window.pageExt.list.beforeEdit) {
			var doNext=window.pageExt.list.beforeEdit(data);
			if(!doNext) return;
		}
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('sys-user-form-data', data);
		var area=admin.getTempData('sys-user-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('账户')) : (fox.translate('添加')+fox.translate('账户'));
		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["500px",height+"px"],
			type: 2,
			id:"sys-user-form-data-win",
			content: '/business/oauth/user/user_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('sys-user-form-data-popup-index', index);
	};

	window.module={
		refreshTableData: refreshTableData,
		getCheckedList: getCheckedList
	};

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});