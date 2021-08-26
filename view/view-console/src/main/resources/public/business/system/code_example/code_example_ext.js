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

            //获取实例
            var inst=fox.getSelectBox("roleIds");
            inst.update({
                on:function (data) {
                    //debugger;
                    // console.dir(inst);
                    //获得全部下拉数据
                    console.dir(inst.getAllData());
                }
            });
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },

        loadTest1Iframe:function (ifr,win,data) {
            // return;
            // debugger
            console.log("loadTest1Iframe",ifr,data);
            //设置 iframe 高度
            ifr.height("400px");
            //设置参数
            admin.putTempData("code_example_id",data.id,true);
            //设置地址
            // win.location="/business/system/code_example_student/code_example_student_list.html";
            ifr.height("200px");
            win.location="/business/system/code_example_student/code_example_student_form.html";

            // setInterval(function (){
            //     win.module.refreshTableData();
            // },10000);

        },
        loadStudentIframe:function (ifr,win,data) {
            // debugger
            console.log("loadStudentIframe",ifr,data);
            //设置 iframe 高度
            ifr.parents(".layui-tab").height("460px");
            ifr.height("400px");
            //设置参数
            admin.putTempData("code_example_id",data.id,true);
            //设置地址
            win.location="/business/system/code_example_student/code_example_student_list.html";
        },
        loadCarIframe:function (ifr,win,data) {
            // debugger
            console.log("loadCarIframe",ifr,data);
            //设置 iframe 高度
           ifr.parents(".layui-tab").height("460px");
           ifr.height("400px");
            //设置参数
            admin.putTempData("code_example_id",data.id,true);
            //设置地址
            win.location="/business/system/code_example_car/code_example_car_list.html";
        },
        openTestDialog:function (data,input,button) {
            console.log("openTestDialog",data,input,button);
            top.layer.prompt(function(value, index, elem){
                //设置隐藏域
                input.val(value);
                //设置按钮
                button.text(value);
                top.layer.close(index);
            });
        },
        other:function(){

        }
    }
    //
    window.pageExt={form:form,list:list};
});