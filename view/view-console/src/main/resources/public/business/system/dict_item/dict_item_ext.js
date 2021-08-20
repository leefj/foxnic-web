layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    //列表页的扩展
    var list={
        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions) {
            //获得缓存中的字典ID
            var dictIdValue=admin.getTempData("dictId");
            //设置固定的查询条件
            if(!conditions["dictId"]) conditions["dictId"]={};
            conditions["dictId"].value=dictIdValue;
        }
    }

    //表单页的扩展
    var form={
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            var dictIdValue=admin.getTempData("dictId");
            var dictCodeValue=admin.getTempData("dictCode");
            //设置默认值
            data["dictId"]=dictIdValue;
            data["dictCode"]=dictCodeValue;
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {

        }
    }
    //
    window.pageExt={form:form,list:list};
});