/**
 * 账户租户关系 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-25 14:49:44
 */

layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    //列表页的扩展
    var list={
        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions) {
            console.log('beforeQuery',conditions);
            var userId=admin.getTempData("userId");
            conditions.userId={value:userId};
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            console.log('beforeEdit',data);
            if(data.tenant && data.tenant.companyId) {
                admin.putTempData("companyId", data.tenant.companyId, true);
            }
            return true;
        },
        afterSwitched:function (id,data,ctx) {
            console.log("afterSwitched:"+id,data,ctx);
            if(id=="activated") {
                window.module.refreshTableData();
            }
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            return true;
        },
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        other:function(){

        }
    }

    //表单页的扩展
    var form={

        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {
            //获取参数，并调整下拉框查询用的URL
            // var companyId=admin.getTempData("companyId");
            // if(!companyId) {
            //     companyId=0;
            // }
            // fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
            //如果是编辑则不可修改
            var tenantBox=fox.getSelectBox("ownerTenantId");
            var employeeBox=fox.getSelectBox("employeeId");
            if(data.id) {
                tenantBox.update({disabled: true});
            } else {
                employeeBox.refresh({companyId:"0"})
            }

            tenantBox.update({
                on:function (a,b){
                    if(a && a.arr && a.arr.length>0) {
                        var d = tenantBox.getDataByValue("id", a.arr[0].value);
                        if(d && d.company) {
                            //employeeBox.setUrl( "/service-hrm/hrm-employee/query-paged-list?companyId=" + d.company.id);
                            employeeBox.refresh({companyId:d.company.id});
                            return;
                        }
                    }
                    //employeeBox.setUrl( "/service-hrm/hrm-employee/query-paged-list?companyId=0");
                    employeeBox.refresh({companyId:0});
                }
            });

        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            var userId=admin.getTempData("userId");
            data.userId=userId;
            return true;
        },

        other:function(){

        }
    }
    //
    window.pageExt={form:form,list:list};
});