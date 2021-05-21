/**
 * 订单测量信息 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-16 09:44:30
 */
 layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','formSelects','index'], function () {
        var form = layui.form;
        var table = layui.table;
        var settings = layui.settings;
        var layer = layui.layer;
        var util = layui.util;
        var admin = layui.admin;
        var fox = layui.foxnic;
        const index=layui.index;
        //上传
        var upload = layui.upload;
 
        form.render('select');
        //模块基础路径
        var moduleURL="/service-tailoring/odr-measure/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#measure-table',
            url: moduleURL +'/query-paged-list?orderId='+orderId,
			cols: [[
			 	{ type:'checkbox' },
                { type: 'numbers' },
                //{ field: 'orderId', sort: true, title: fox.translate('订单ID') } ,
                { field: 'bodyName', sort: true, title: fox.translate('姓名') , editx:"text",event: 'doEdit_bodyName' } ,
                { field: 'bodyDept', sort: true, title: fox.translate('部门') , editx:"text",event: 'doEdit_bodyDept' } ,
                { field: 'bodySex', sort: true, title: fox.translate('性别') , editx:"text",event: 'doEdit_bodySex' } ,
                { field: 'bodyHeight', sort: true, title: fox.translate('身高(cm)') , editx:"text",event: 'doEdit_bodyHeight' } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                { field: 'status', sort: true, title: fox.translate('状态') ,  templet: function (d) {  return d.statusDictItem?d.statusDictItem.label:"待测量" } } ,
                { fixed: 'right', align: 'center', toolbar: '#measure-table-operation', title: fox.translate('操作'), width: 150 }
            ]]
        });
        
        /**
		* 校验只要是数字（包含正负整数，0以及正负浮点数）就返回true
		**/
		
		function isNumber(val){
		
		    var regPos = /^\d+$/; //非负浮点数
		    if(regPos.test(val)) {
		        return true;
		    }else{
		        return false;
		    }
		
		}
		
		function doCellEdit(obj) {
			  console.log(obj.event);
			  console.log(obj.value); 
			  console.log(obj.field); //当前编辑的字段名
			  console.log(obj.data); //所在行的所有相关数据  
			  var field=obj.event.substring(7);
			  var value=obj.data[field];
			  //debugger;
			  layer.prompt({
		        formType: 0
		        ,title: '修改'
		        ,value: value
		      }, function(value, index){
		      	
		      	  //debugger
				  if(field=="bodyHeight") {
				  	if(!isNumber(value)) {
				  		layer.msg("请填写数字");
				  		return;
				  	}
				  }
		      	
		        layer.close(index);
		        var ps={id:obj.data.bid};
		        ps[field]=value;
		        var api="/service-tailoring/odr-body/update";
		        admin.req(api, JSON.stringify(ps), function (data) {
		              layer.closeAll('loading');
		              if (data.success) {
		                  refreshTableData();
		              	obj.update(ps);
		              } else {
		                  layer.msg(data.message, {icon: 2, time: 500});
		              }
		        }, "POST");
 
		        
		      });
			  
		}
        
        //编辑
        table.on('edit(measure-table)', function(obj){ 
			  console.log(obj.event);
			  console.log(obj.value); 
			  console.log(obj.field); //当前编辑的字段名
			  console.log(obj.data); //所在行的所有相关数据  
			  debugger;
			  if(obj.field=="bodyHeight") {
			  	if(!isNumber(obj.value)) {
//			  		var data={};
//			  		data[obj.field]=99;
//			  		debugger;
//			  		obj.update(data);
			  		layer.msg("请填写数字");
			  		refreshTableData();
			  		return;
			  	}
			  }
			  
			 // debugger;
			  //设置新增是初始化数据
        	  var data={id:obj.data.id};
        	  data[obj.field]=obj.value;
              var api=moduleURL+"update";
	          //layer.load(2);
	          admin.req(api, JSON.stringify(data), function (data) {
	              layer.closeAll('loading');
	              if (data.success) {
	                  //layer.msg(data.message, {icon: 1, time: 500});
	                  //refreshTableData();
	              } else {
	                  layer.msg(data.message, {icon: 2, time: 500});
	              }
	          }, "POST");
			  
		});
        
        //绑定 Switch 切换事件
        
       
       //重置搜索框
       function resetSearchFields() {
        	$('#label-search-field').val("");
			$('#label-search-value').val("");
			layui.form.render();
        }
 
        function refreshTableData() {
        	var field = $('#measure-search-field').val();
            var value = $('#measure-search-value').val();
            var ps={searchField: field, searchValue: value};
            table.reload('measure-table', { where : ps });
        }
        
        //添加按钮点击事件
        $('#measure-btn-add').click(function () {
        	
        	//设置新增是初始化数据
        	var data={orderId:orderId,bodyHeight:170};
            var api="/service-tailoring/odr-body/insert";
	        layer.load(2);
	        admin.req(api, JSON.stringify(data), function (data) {
	            layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
	                refreshTableData();
	            } else {
	                layer.msg(data.message, {icon: 2, time: 500});
	            }
	        }, "POST");
	        
        });

        // 工具条点击事件
        table.on('tool(measure-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            admin.putTempData('odr-measure-form-data', data);
            
            if (layEvent.startsWith('doEdit_')) {
				
            	doCellEdit(obj);
            	return;
            	
            } else if (layEvent === 'body_data') { // 净体效果
            	
            	if(!data.bodyEffectFileId) {
            		layer.msg("数据未就绪");
            		return;
            	}
            	layer.open({
            	  title:fox.translate('净体效果'),
				  type: 2, 
				  offset:["5%","5%"],
				  area:["90%","90%"],
				  content: '/pages/order/measure/data.html?measureType=body&measureId='+data.id+'&effectFileId='+data.bodyEffectFileId
				}); 
            	
            } else if (layEvent === 'outfit_data') { // 着装效果
            	
            	if(!data.outfitEffectFileId) {
            		layer.msg("数据未就绪");
            		return;
            	}
            	layer.open({
            	  title:fox.translate('着装效果'),
				  type: 2, 
				  offset:["5%","5%"],
				  area:["90%","90%"],
				  content: '/pages/order/measure/data.html?measureType=outfit&measureId='+data.id+'&effectFileId='+data.outfitEffectFileId
				}); 
				
            } 
            
            else if (layEvent === 'effect') {  // 修改
            	
            	if(!data.videoId) {
            		layer.msg("视频未就绪");
            		return;
            	}
            	layer.open({
            	  title:fox.translate('效果'),
				  type: 2, 
				  offset:["10%","10%"],
				  area:["80%","80%"],
				  content: '/pages/order/measure/effect.html?videoId='+data.videoId
				}); 
            	
            } else if (layEvent === 'del') { // 删除
                layer.confirm(fox.translate('确定删除此')+fox.translate('订单测量信息')+fox.translate('吗？'), function (i) {
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
// 			debugger;
//            admin.putTempData('odr-measure-form-data', data);
//            var title = (data && data.id) ? (fox.translate('修改')+fox.translate('订单测量信息')) : (fox.translate('添加')+fox.translate('订单测量信息'));
            
//            layer.open({
//              title: title,
//              type: 2,
//			  content: '/pages/order/measure/measure_form.html',
//			  yes: function(index, layero){
//			    //do something
//			  	debugger;
//			    layer.close(index); //如果设定了yes回调，需进行手工关闭
//			  }
//			});  
            
//            index.openNewTab({
//            	url: "/pages/order/measure/measure_form.html",
//            	title: title,
//            	menuId:"xxx"
//            });
            
//            admin.popupCenter({
//                title: title,
//                zIndex: 99,
//                type:2,
//                id:"measure",
//                path: '/pages/order/measure/measure_form.html',
//                url: '/pages/order/measure/measure_form.html',
//                finish: function () {
//                    refreshTableData();
//                }
//            });
        };
        
        
        //回车键查询
        $("#measure-search-value").keydown(function(event) {
        	if(event.keyCode !=13) return;
		  	refreshTableData();
        });

        // 搜索按钮点击事件
        $('#measure-btn-search').click(function () {
           refreshTableData();
        });
        
        
        //批量删除按钮点击事件
        $('#measure-btn-delete').click(function () {
          
            var ids=getCheckedList("bid");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('订单测量信息')+"!");
            	return;
            }

            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('订单测量信息')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req("/service-tailoring/odr-body/batch-delete", JSON.stringify({ ids: JSON.stringify(ids) }), function (data) {
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
 
        
        fox.bindImportButton($('#measure-btn-import'),moduleURL+"/import-excel",{orderId:orderId},function(r){
        	refreshTableData();
        });
        	
        
        $('#measure-btn-export').click(function () {
			fox.submit(moduleURL+"/export-excel",{orderId:orderId});
        });
        
  
        //获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
		function getCheckedList(field) {
			var checkStatus = table.checkStatus('measure-table');
			var data = checkStatus.data;
			if(!field) return data;
			for(var i=0;i<data.length;i++) data[i]=data[i][field];
			return data;
		}
 
        
       

    });