/**
 * 系统配置 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-09 19:13:58
 * @version
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

    var profileId;
    var parentId;
    var hierarchy;

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function (action,data) {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
            profileId=admin.getVar("profileId");
            parentId=admin.getVar("parentId");
            hierarchy=admin.getVar("hierarchy");
            //debugger
            if(data && (data.typeDesc==null || data.typeDesc=="")) {
                $("#typeDesc").parents(".layui-form-item").hide();
            }

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
            // $("input[name=type]").attr("disabled", "yes");
            // $("input[name=name]").attr("disabled", "yes");
            // $("input[name=typeDesc]").attr("disabled", "yes");
            // $("input[name=typeDesc]").attr("placeholder", "");
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    //
    window.pageExt={form:form,list: {}};
});
