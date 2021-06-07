/**
 * 语言条目 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:24
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
        var moduleURL="/service-tailoring/sys-lang/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#lang-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'code', sort: true, title: fox.translate('编码键') } ,
                { field: 'defaults', sort: true, title: fox.translate('默认') } ,
                { field: 'zhCh', sort: true, title: fox.translate('简体中文(大陆)') } ,
                { field: 'zhTw', sort: true, title: fox.translate('繁体中文(台湾)') } ,
                { field: 'enUs', sort: true, title: fox.translate('英文美国') } ,
                { field: 'enUk', sort: true, title: fox.translate('英文英国') } ,
                { field: 'confuse', sort: true, title: fox.translate('混淆专用') } ,
                { field: 'valid', sort: true, title: fox.translate('是否有效') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#lang-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#lang-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(lang-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if (layEvent === 'edit') { // 修改
            	admin.req(moduleURL+"/get-by-id", { code : data.code }, function (data) {
            		if(data.success) {
            			 showEditModel(data.data);
            		} else {
            			 layer.msg(data.message, {icon: 1, time: 500});
            		}
            	});
            	
            } else if (layEvent === 'del') { // 删除
                layer.confirm(fox.translate('确定删除此')+fox.translate('语言条目')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { code : data.code }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('lang-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('sys-lang-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('语言条目')) : (fox.translate('添加')+fox.translate('语言条目'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/lang/lang_form.html',
                finish: function () {
                    table.reload('lang-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#lang-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#lang-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#lang-btn-search').click(function () {
            var field = $('#lang-search-field').val();
            var value = $('#lang-search-value').val();
            table.reload('lang-table', {where: {searchField: field, searchValue: value}});
        });
 
    });