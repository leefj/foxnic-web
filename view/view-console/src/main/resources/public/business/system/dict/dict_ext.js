/**
 * 数据字典 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:38:48
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
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    var list={
        /**
         * 查询前调用
         * */
        beforeQuery:function (condition) {
            return true;
        },
        /**
         * 打开字典条窗口
         * */
        openDictItemWindow: function (data) {
            admin.putTempData("dictId",data.id,true);
            admin.putTempData("dictCode",data.code,true);
            var index = admin.popupCenter({
                title: data.name+"的字典条目",
                resize: false,
                id: 'dictItemsWindow',
                area: ["800px", "600px"],
                type: 2,
                content: "/business/system/dict_item/dict_item_list.html"
            });
        }
    }
    //
    var form={

        beforeInit:function (data) {
            debugger;
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            //code 不允许编辑
            if(data.id) {
                $("#code").attr("readonly","yes");
            }
        },
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
    }
    //
    window.pageExt={form:form,list:list};
});
