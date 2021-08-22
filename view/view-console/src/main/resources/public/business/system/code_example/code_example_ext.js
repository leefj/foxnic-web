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
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        testToolButton1:function (selected,it){
            console.log('testToolButton1',selected,it);
        },
        testToolButton2:function (selected,it){
            console.log('testToolButton2',selected,it);
        },
        doTestAction:function (data){
            console.log('doTestAction',data);
        },
        other:function(){

        }
    }

    //表单页的扩展
    var form={
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
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },
        loadTest1Iframe:function (ifr,win,data) {
            // debugger
            console.log("loadTest1Iframe",ifr,data);
            //设置 iframe 高度
            ifr.height("400px");
            ifr.width("98%");
            admin.putTempData("code_example_id",data.id,true);
            //设置地址
            win.location="/business/system/code_example_student/code_example_student_list.html";
        },
        other:function(){

        }
    }
    //
    window.pageExt={form:form,list:list};
});