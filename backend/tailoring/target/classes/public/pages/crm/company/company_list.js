/**
 * 客户公司 列表页 JS 脚本
 * @author 李方捷
 * @since 2021-04-01 10:41:25
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
        var moduleURL="/service-tailoring/crm-company/";
 
        // 渲染表格
        fox.renderTable({
        	elem: '#company-table',
            url: moduleURL +'/query-paged-list',
			cols: [[
                {type: 'numbers'},
                { field: 'id', sort: true, title: fox.translate('ID') } ,
                { field: 'name', sort: true, title: fox.translate('公司名称') } ,
                { field: 'unifySocialCode', sort: true, title: fox.translate('统一社会信用代码') } ,
                { field: 'licensePhoto', sort: true, title: fox.translate('营业执照图片地址') } ,
                { field: 'businessRange', sort: true, title: fox.translate('经营范围') } ,
                { field: 'termStartDate', sort: true, title: fox.translate('营业期限开始日期') } ,
                { field: 'termEndDate', sort: true, title: fox.translate('营业期限结束日期') , templet: function (d) { return util.toDateString(d.termEndDate); } } ,
                { field: 'contractStartDate', sort: true, title: fox.translate('合同生效时间') , templet: function (d) { return util.toDateString(d.contractStartDate); } } ,
                { field: 'contractStatus', sort: true, title: fox.translate('合同状态') } ,
                { field: 'type', sort: true, title: fox.translate('公司类型') } ,
                { field: 'createTime', sort: true, title: fox.translate('创建时间') , templet: function (d) { return util.toDateString(d.createTime); } } ,
                {fixed: 'right', align: 'center', toolbar: '#company-table-operation', title: fox.translate('操作'), width: 175}
            ]]
        });
        
        // 添加按钮点击事件
        $('#company-btn-add').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(company-table)', function (obj) {
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
                layer.confirm(fox.translate('确定删除此')+fox.translate('客户公司')+fox.translate('吗？'), function (i) {
                    layer.close(i);
                    layer.load(2);
                    admin.req(moduleURL+"/delete", { id : data.id }, function (data) {
                        layer.closeAll('loading');
                        if (data.success) {
                            layer.msg(data.message, {icon: 1, time: 500});
                            table.reload('company-table', {});
                        } else {
                            layer.msg(data.message, {icon: 2, time: 500});
                        }
                    });
                });
            }
        });

        //显示表单弹窗
        var showEditModel = function (data) {
 
            admin.putTempData('crm-company-form-data', data);
            var title = data ? (fox.translate('修改')+fox.translate('客户公司')) : (fox.translate('添加')+fox.translate('客户公司'));
            admin.popupCenter({
                title: title,
                path: '/pages/product/company/company_form.html',
                finish: function () {
                    table.reload('company-table', {});
                }
            });
        };
        
        
        //回车键查询
        $("#company-search-value").keydown(function(event) {
        	if(event.keyCode ==13){
		  		$("#company-btn-search").trigger("click");
			}
        });

        // 搜索按钮点击事件
        $('#company-btn-search').click(function () {
            var field = $('#company-search-field').val();
            var value = $('#company-search-value').val();
            table.reload('company-table', {where: {searchField: field, searchValue: value}});
        });
 
    });