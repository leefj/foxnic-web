/**
 * 账户 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-25 13:42:04
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
            // console.log('beforeQuery',conditions);
            // var v=QueryString.get("v");
            // alert(v);
            return true;
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
            // debugger
            if(menu.id=="owner-relation") {
                this.openTenantOwner(data);
            }
            if(menu.id=="passwd-reset") {
                this.openPasswdResetView(data);
            }

        },
        openPasswdResetView:function (data){
            admin.putTempData("userId",data.id,true);
            var index = admin.popupCenter({
                title: "重置密码 : "+data.realName,
                resize: false,
                id: 'passwdResetView',
                area: ["400px", "290px"],
                type: 2,
                content: "/business/oauth/user/user_passwd_form.html"
            });
        },
        openTenantOwner:function (data){
            admin.putTempData("userId",data.id,true);
            var index = admin.popupCenter({
                title: "所属租户 : "+data.realName,
                resize: false,
                id: 'userTenantWindow',
                area: ["900px", "600px"],
                type: 2,
                content: "/business/system/user_tenant/user_tenant_list.html"
            });
        },
        other:function() {

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

        onUploadEvent: function(e) {
            console.log("onUploadEvent."+e.event,e);
        },

        other:function(){

        }
    }
    //
    window.pageExt={form:form,list:list};
});
