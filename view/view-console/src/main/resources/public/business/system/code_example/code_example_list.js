/**
 * 代码生成示例主 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-25 13:06:39
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-system/sys-code-example";
	var dataTable=null;
	var sort=null;
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

			var ps={searchField: "$composite"};
			var contitions={};

			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			}
			ps.searchValue=JSON.stringify(contitions);

			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			var tableConfig={
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'name', align:"left",fixed:true,  hide:false, sort: true, title: fox.translate('单行文本') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('多行文本') , templet: function (d) { return templet('notes',d.notes,d);}  }
					,{ field: 'area', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('整数输入') , templet: function (d) { return templet('area',d.area,d);}  }
					,{ field: 'weight', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('小数输入') , templet: function (d) { return templet('weight',d.weight,d);}  }
					,{ field: 'birthday', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('日期'), templet: function (d) { return templet('birthday',fox.dateFormat(d.birthday,"yyyy-MM-dd"),d); }}
					,{ field: 'workTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('工作时间'), templet: function (d) { return templet('workTime',fox.dateFormat(d.workTime,"yyyy-MM-dd HH:mm:ss"),d); }}
					,{ field: 'valid', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('逻辑值'), templet: '#cell-tpl-valid'}
					,{ field: 'radioEnum', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('枚举'), templet:function (d){ return templet('radioEnum',fox.getEnumText(RADIO_RADIOENUM_DATA,d.radioEnum),d);}}
					,{ field: 'radioDict', align:"left", fixed:false, hide:false, sort: true, title: fox.translate('性别'), templet:function (d){ return templet('radioDict',fox.getDictText(RADIO_RADIODICT_DATA,d.radioDict),d);}}
					,{ field: 'checkEnum', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('复选框(枚举)'), templet:function (d){ return templet('checkEnum',fox.getEnumText(CHECK_CHECKENUM_DATA,d.checkEnum),d);}}
					,{ field: 'checkDict', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('状态'), templet:function (d){ return templet('checkDict',fox.getDictText(CHECK_CHECKDICT_DATA,d.checkDict),d);}}
					,{ field: 'selectEnum', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('选择框(枚举)'), templet:function (d){ return templet('selectEnum',fox.getEnumText(SELECT_SELECTENUM_DATA,d.selectEnum),d);}}
					,{ field: 'selectDict', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('选择框(字典)'), templet:function (d){ return templet('selectDict',fox.getDictText(SELECT_SELECTDICT_DATA,d.selectDict),d);}}
					,{ field: 'roleIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('角色'), templet: function (d) { return templet('roleIds' ,fox.joinLabel(d.roles,"name"),d);}}
					,{ field: 'resourceId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('选择框(查询)'), templet: function (d) { return templet('resourceId' ,fox.getProperty(d,["resourze","name"]),d);}}
					,{ field: 'roleCountByAfter', align:"right",fixed:false,  hide:false, sort: false, title: fox.translate('角色数(Java)') , templet: function (d) { return templet('roleCountByAfter',d.roleCountByAfter,d);}  }
					,{ field: 'roleCountByJoin', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('角色数(SQL)') , templet: function (d) { return templet('roleCountByJoin',d.roleCountByJoin,d);}  }
					,{ field: 'imageId', align:"left", fixed:false, hide:false, sort: true, title: fox.translate('图片上传'), templet: function (d) { return '<img style="height:100%;" fileType="image/png" onclick="window.previewImage(this)"  src="'+apiurls.storage.image+'?id='+ d.imageId+'" />'; } }
					,{ field: 'fileIds', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('多文件上传') , templet: function (d) { return templet('fileIds',d.fileIds,d);}  }
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'buttonInput', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('对话框') , templet: function (d) { return templet('buttonInput',d.buttonInput,d);}  }
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 280 }
				]],
				done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
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
			};
			window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
			dataTable=fox.renderTable(tableConfig);
			//绑定 Switch 切换事件
			fox.bindSwitchEvent("cell-tpl-valid",moduleURL +'/update','id','valid',function(data,ctx){
				window.pageExt.list.afterSwitched && window.pageExt.list.afterSwitched("valid",data,ctx);
			});
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
			  refreshTableData(obj.field,obj.type);
			});
			window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
		}
		setTimeout(renderTableInternal,1);
    };

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		var value = {};
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.area={ inputType:"number_input", begin: $("#area-begin").val(), end: $("#area-end").val() };
		value.weight={ inputType:"number_input", value: $("#weight").val() };
		value.valid={ inputType:"logic_switch",value: xmSelect.get("#valid",true).getValue("value"), label:xmSelect.get("#valid",true).getValue("nameStr") };
		value.radioEnum={ inputType:"radio_box", value: xmSelect.get("#radioEnum",true).getValue("value"), label:xmSelect.get("#radioEnum",true).getValue("nameStr") };
		value.radioDict={ inputType:"radio_box", value: xmSelect.get("#radioDict",true).getValue("value"), label:xmSelect.get("#radioDict",true).getValue("nameStr") };
		value.checkEnum={ inputType:"check_box", value: xmSelect.get("#checkEnum",true).getValue("value") ,fuzzy: true,valuePrefix:"\"",valueSuffix:"\"", label:xmSelect.get("#checkEnum",true).getValue("nameStr") };
		value.checkDict={ inputType:"check_box", value: xmSelect.get("#checkDict",true).getValue("value") ,fuzzy: true,valuePrefix:"\"",valueSuffix:"\"", label:xmSelect.get("#checkDict",true).getValue("nameStr") };
		value.selectEnum={ inputType:"select_box", value: xmSelect.get("#selectEnum",true).getValue("value"), label:xmSelect.get("#selectEnum",true).getValue("nameStr") ,field:"code"};
		value.selectDict={ inputType:"select_box", value: xmSelect.get("#selectDict",true).getValue("value") ,fuzzy: true,valuePrefix:"\"",valueSuffix:"\"", label:xmSelect.get("#selectDict",true).getValue("nameStr") ,field:"text"};
		value.resourceId={ inputType:"select_box", value: $("#resourceId").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" ,fillBy:["resourze","name"] ,field:"sys_resourze.url"};
		value.birthday={ inputType:"date_input", begin: $("#birthday-begin").val(), end: $("#birthday-end").val() };
		value.roleIds={ inputType:"select_box", value: xmSelect.get("#roleIds",true).getValue("value") ,fillBy:["roles"]  ,field:"sys_code_example_role.role_id", label:xmSelect.get("#roleIds",true).getValue("nameStr") };
		var ps={searchField:"$composite"};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
		}
		ps.searchValue=JSON.stringify(value);
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
			sort={ field : sortField,type : sortType} ;
		} else {
			if(sort) {
				ps.sortField=sort.field;
				ps.sortType=sort.type;
			}
		}
		if(reset) {
			table.reload('data-table', { where : ps , page:{ curr:1 } });
		} else {
			table.reload('data-table', { where : ps });
		}
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

		fox.switchSearchRow(3);

		//渲染 valid 搜索框
		fox.renderSelectBox({
			el: "valid",
			size: "small",
			radio: false
		});
		//渲染 radioEnum 搜索框
		fox.renderSelectBox({
			el: "radioEnum",
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
		//渲染 radioDict 搜索框
		fox.renderSelectBox({
			el: "radioDict",
			size: "small",
			radio: false,
			//toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 checkEnum 搜索框
		fox.renderSelectBox({
			el: "checkEnum",
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
		//渲染 checkDict 搜索框
		fox.renderSelectBox({
			el: "checkDict",
			size: "small",
			radio: false,
			//toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
				transform: function(data) {
					//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
					var opts=[];
					for (var i = 0; i < data.length; i++) {
						if(!data[i]) continue;
						opts.push({name:data[i].text,value:data[i].code});
					}
					return opts;
				}
		});
		//渲染 selectEnum 下拉字段
		fox.renderSelectBox({
			el: "selectEnum",
			radio: false,
			size: "small",
			filterable: false,
			//转换数据
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
		//渲染 selectDict 下拉字段
		fox.renderSelectBox({
			el: "selectDict",
			radio: false,
			size: "small",
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 resourceId 下拉字段
		fox.renderSelectBox({
			el: "resourceId",
			radio: false,
			size: "small",
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "url", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].url,value:data[i].id});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#birthday-begin',
			trigger:"click"
		});
		laydate.render({
			elem: '#birthday-end',
			trigger:"click"
		});
		//渲染 roleIds 下拉字段
		fox.renderSelectBox({
			el: "roleIds",
			radio: false,
			size: "small",
			filterable: true,
			paging: true,
			pageRemote: true,
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
		window.pageExt.list.afterSearchInputReady && window.pageExt.list.afterSearchInputReady();
	}

	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {
		//回车键查询
        $(".search-input").keydown(function(event) {
			if(event.keyCode !=13) return;
		  	refreshTableData(null,null,true);
        });

        // 搜索按钮点击事件
        $('#search-button').click(function () {
			refreshTableData(null,null,true);
        });

		// 搜索按钮点击事件
		$('#search-button-advance').click(function () {
			fox.switchSearchRow(3,function (ex){
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
			if(window.pageExt.list.beforeToolBarButtonEvent) {
				var doNext=window.pageExt.list.beforeToolBarButtonEvent(selected,obj);
				if(!doNext) return;
			}
			switch(obj.event){
				case 'create':
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete(selected);
					break;
				case 'tool-test-tool-button1':
					window.pageExt.list.testToolButton1 && window.pageExt.list.testToolButton1(selected,obj);
					break;
				case 'tool-test-tool-button2':
					window.pageExt.list.testToolButton2 && window.pageExt.list.testToolButton2(selected,obj);
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
			admin.putTempData('sys-code-example-form-data-form-action', "create",true);
            showEditForm(data);
        };

        //批量删除按钮点击事件
        function batchDelete(selected) {

        	if(window.pageExt.list.beforeBatchDelete) {
				var doNext=window.pageExt.list.beforeBatchDelete(selected);
				if(!doNext) return;
			}

			var ids=getCheckedList("id");
            if(ids.length==0) {
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('代码生成示例主')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('代码生成示例主')+fox.translate('吗？'), function (i) {
				top.layer.close(i);
				top.layer.load(2);
                admin.request(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
					top.layer.closeAll('loading');
                    if (data.success) {
						if(window.pageExt.list.afterBatchDelete) {
							var doNext=window.pageExt.list.afterBatchDelete(data);
							if(!doNext) return;
						}
                    	top.layer.msg(data.message, {icon: 1, time: 500});
                        refreshTableData();
                    } else {
						top.layer.msg(data.message, {icon: 2, time: 1500});
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

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('sys-code-example-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('sys-code-example-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('sys-code-example-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('代码生成示例主')+fox.translate('吗？'), function (i) {
					top.layer.close(i);

					top.layer.load(2);
					admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
						top.layer.closeAll('loading');
						if (data.success) {
							if(window.pageExt.list.afterSingleDelete) {
								var doNext=window.pageExt.list.afterSingleDelete(data);
								if(!doNext) return;
							}
							top.layer.msg(data.message, {icon: 1, time: 500});
							refreshTableData();
						} else {
							top.layer.msg(data.message, {icon: 2, time: 1500});
						}
					});
				});

			}
			else if (layEvent === 'do-test-action') { // 测试
				window.pageExt.list.doTestAction(data);
			}
			else if(obj.event === 'ops-more'){
				//更多下拉菜单
				dropdown.render({
					elem: this
					,show: true //外部事件触发即显示
					,data: [{"id":"t1","title":"测试-1"},{"id":"t2","title":"测试-2"}]
					,click: function(menu, othis){
						window.pageExt.list.moreAction && window.pageExt.list.moreAction(menu,data, othis);
					}
					,align: 'right'
					,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);'
				});
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
		var action=admin.getTempData('sys-code-example-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('sys-code-example-form-data', data);
		var area=admin.getTempData('sys-code-example-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('代码生成示例主');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["90%",height+"px"],
			type: 2,
			id:"sys-code-example-form-data-win",
			content: '/business/system/code_example/code_example_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('sys-code-example-form-data-popup-index', index);
	};

	window.module={
		refreshTableData: refreshTableData,
		getCheckedList: getCheckedList
	};

	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});