/**
 * 测量数据发聩 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:44:17
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
        var moduleURL="/service-tailoring/odr-measure-data/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#measure_data-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'measureId', sort: true, title: fox.translate('测量ID') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                { field: 'resultType', sort: true, title: fox.translate('测量类型') } ,
                { field: 'lingWei', sort: true, title: fox.translate('领围') } ,
                { field: 'xiongWei', sort: true, title: fox.translate('胸围') } ,
                { field: 'yaoWei', sort: true, title: fox.translate('腰围') } ,
                { field: 'fuWei', sort: true, title: fox.translate('腹围') } ,
                { field: 'youShangBiWei', sort: true, title: fox.translate('右上臂围') } ,
                { field: 'youXiaBiWei', sort: true, title: fox.translate('右下臂围') } ,
                { field: 'zuoShangBiWei', sort: true, title: fox.translate('左上臂围') } ,
                { field: 'zuoXiaBiWei', sort: true, title: fox.translate('左下臂围') } ,
                { field: 'youShangTuiWei', sort: true, title: fox.translate('右上腿围') } ,
                { field: 'youXiaTuiWei', sort: true, title: fox.translate('右下腿围') } ,
                { field: 'zuoShangTuiWei', sort: true, title: fox.translate('左上腿围') } ,
                { field: 'zuoXiaTuiWei', sort: true, title: fox.translate('左下腿围') } ,
                { field: 'shenGao', sort: true, title: fox.translate('身高') } ,
                { field: 'jianKuan', sort: true, title: fox.translate('肩宽') } ,
                { field: 'beiChang', sort: true, title: fox.translate('背长') } ,
                { field: 'jingZhuiDianGao', sort: true, title: fox.translate('颈椎点高') } ,
                { field: 'yaoWeiGao', sort: true, title: fox.translate('腰围高') } ,
                { field: 'tunGao', sort: true, title: fox.translate('臀高') } ,
                { field: 'tunWei', sort: true, title: fox.translate('臀围') } ,
                { field: 'kuChang', sort: true, title: fox.translate('裤长') } ,
                { field: 'zuoBiChang', sort: true, title: fox.translate('左臂长') } ,
                { field: 'youBiChang', sort: true, title: fox.translate('右臂长') } ,
                { field: 'youShangBiChang', sort: true, title: fox.translate('右上臂长') } ,
                { field: 'youXiaBiChang', sort: true, title: fox.translate('右下臂长') } ,
                { field: 'zuoShangBiChang', sort: true, title: fox.translate('左上臂长') } ,
                { field: 'zuoXiaBiChang', sort: true, title: fox.translate('左下臂长') } ,
                { field: 'youTuiChang', sort: true, title: fox.translate('右腿长') } ,
                { field: 'zuoTuiChang', sort: true, title: fox.translate('左腿长') } ,
                { field: 'youShangTuiChang', sort: true, title: fox.translate('右上腿长') } ,
                { field: 'youXiaTuiChang', sort: true, title: fox.translate('右下腿长') } ,
                { field: 'zuoShangTuiChang', sort: true, title: fox.translate('左上腿长') } ,
                { field: 'zuoXiaTuiChang', sort: true, title: fox.translate('左下腿长') } ,
                {fixed: 'right', align: 'center', toolbar: '#measure_data-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#measure_data-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(measure_data-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('测量数据发聩')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('measure_data-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('odr-measure-data-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('测量数据发聩')) : (fox.translate('添加')+fox.translate('测量数据发聩'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/measure_data/measure_data_form.html',
                finish: function () {
                    table.reload('measure_data-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#measure_data-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#measure_data-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#measure_data-btn-search').click(function () {
            var field = $('#measure_data-search-field').val();
            var value = $('#measure_data-search-value').val();
            table.reload('measure_data-table', {where: {searchField: field, searchValue: value}});
        });
 
    });