/**
 * 变更示例订单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-17 11:48:18
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-changes/chs-example-order";
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
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'title', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('标题') , templet: function (d) { return templet('title',d.title,d);}  }
					,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('订单编号') , templet: function (d) { return templet('code',d.code,d);}  }
					,{ field: 'orderTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('下单时间') ,templet: function (d) { return templet('orderTime',fox.dateFormat(d.orderTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'buyerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('买家') , templet: function (d) { return templet('buyerId',fox.getProperty(d,["buyerEmployee","person","name"]),d);} }
					,{ field: 'address', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('收件地址') , templet: function (d) { return templet('address',d.address,d);}  }
					,{ field: 'amount', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('总金额') , templet: function (d) { return templet('amount',d.amount,d);}  }
					,{ field: 'chsType', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('变更类型'), templet:function (d){ return templet('chsType',fox.getEnumText(RADIO_CHSTYPE_DATA,d.chsType),d);}}
					,{ field: 'chsStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('变更状态'), templet:function (d){ return templet('chsStatus',fox.getEnumText(RADIO_CHSSTATUS_DATA,d.chsStatus),d);}}
					,{ field: 'chsVersion', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('版本') , templet: function (d) { return templet('chsVersion',d.chsVersion,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'sourceId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('来源ID') , templet: function (d) { return templet('sourceId',d.sourceId,d);}  }
					,{ field: 'changeInstanceId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('变更ID') , templet: function (d) { return templet('changeInstanceId',d.changeInstanceId,d);}  }
					,{ field: 'summary', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('流程概要') , templet: function (d) { return templet('summary',d.summary,d);}  }
					,{ field: 'latestApproverId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('最后审批人') , templet: function (d) { return templet('latestApproverId',d.latestApproverId,d);}  }
					,{ field: 'latestApproverName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('最后审批人姓名') , templet: function (d) { return templet('latestApproverName',d.latestApproverName,d);}  }
					,{ field: 'nextApproverIds', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('下一节点审批人') , templet: function (d) { return templet('nextApproverIds',d.nextApproverIds,d);}  }
					,{ field: 'nextApproverNames', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('下一审批人') , templet: function (d) { return templet('nextApproverNames',d.nextApproverNames,d);}  }
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
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
		value.title={ inputType:"button",value: $("#title").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.code={ inputType:"button",value: $("#code").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.chsType={ inputType:"radio_box", value: xmSelect.get("#chsType",true).getValue("value"), label:xmSelect.get("#chsType",true).getValue("nameStr") };
		value.chsStatus={ inputType:"radio_box", value: xmSelect.get("#chsStatus",true).getValue("value"), label:xmSelect.get("#chsStatus",true).getValue("nameStr") };
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

		fox.switchSearchRow(1);

		//渲染 chsType 搜索框
		fox.renderSelectBox({
			el: "chsType",
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
		//渲染 chsStatus 搜索框
		fox.renderSelectBox({
			el: "chsStatus",
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
				case 'tool-draft-process':
					window.pageExt.list.draftProcess && window.pageExt.list.draftProcess(selected,obj);
					break;
				case 'tool-submit-process':
					window.pageExt.list.submitProcess && window.pageExt.list.submitProcess(selected,obj);
					break;
				case 'tool-revoke-process':
					window.pageExt.list.revokeProcess && window.pageExt.list.revokeProcess(selected,obj);
					break;
				case 'tool-abandon-process':
					window.pageExt.list.abandonProcess && window.pageExt.list.abandonProcess(selected,obj);
					break;
				case 'tool-agree-node':
					window.pageExt.list.agreeNode && window.pageExt.list.agreeNode(selected,obj);
					break;
				case 'tool-reject-node':
					window.pageExt.list.rejectNode && window.pageExt.list.rejectNode(selected,obj);
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
			admin.putTempData('chs-example-order-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('变更示例订单')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('变更示例订单')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('chs-example-order-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('chs-example-order-form-data-form-action', "edit",true);
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
						admin.putTempData('chs-example-order-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('变更示例订单')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'open-details') { // 明细
				window.pageExt.list.openDetails(data);
			}
			else if(obj.event === 'ops-more'){
				//更多下拉菜单
				dropdown.render({
					elem: this
					,show: true //外部事件触发即显示
					,data: [{"perm":"uuu","id":"明细细","title":"openDetailss"}]
					,click: function(menu, othis){
						if(menu.perm && !admin.checkAuth(menu.perm)) {
							top.layer.msg(fox.translate('缺少操作权限'), {icon: 2, time: 1500});
							return;
						}
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
		var action=admin.getTempData('chs-example-order-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('chs-example-order-form-data', data);
		var area=admin.getTempData('chs-example-order-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('变更示例订单');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["500px",height+"px"],
			type: 2,
			id:"chs-example-order-form-data-win",
			content: '/business/changes/example_order/example_order_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('chs-example-order-form-data-popup-index', index);
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
