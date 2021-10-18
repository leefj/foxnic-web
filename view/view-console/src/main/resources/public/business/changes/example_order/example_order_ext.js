/**
 * 变更示例订单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-30 10:09:27
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

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            console.log("list:beforeTableRender",cfg);
        },
        /**
         * 表格渲染后调用
         * */
        afterTableRender :function (){

        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * @param location 调用的代码位置
         * */
        beforeQuery:function (conditions,param,location) {
            console.log('beforeQuery',conditions,param,location);
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {
            // debugger
            for (var i = 0; i < data.length; i++) {
                //如果审批中或审批通过的不允许编辑
                if(data[i].chsStatus=="approving" || data[i].chsStatus=="pass" || data[i].chsStatus=="abandoned") {
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                }
            }

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(value==null) return "";
            return value;
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            console.log('beforeEdit',data);
            return true;
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            return true;
        },
        afterSingleDelete:function (data){
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
         * 批量删除后调用，若返回false则不执行后续操作
         * */
        afterBatchDelete:function (data) {
            console.log('afterBatchDelete',data);
            return true;
        },
        /**
         * 工具栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeToolBarButtonEvent:function (selected,obj) {
            console.log('beforeToolBarButtonEvent',selected,obj);
            return true;
        },
        /**
         * 列表操作栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeRowOperationEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        startProcess:function (selected,it) {
            console.log('startChange',selected,it);
            if(selected==null || selected.length==0) {
                top.layer.msg("请勾选待审订单",{time:1000});
                return;
            }
            if(selected.length>1) {
                top.layer.msg("不支持合并审批",{time:1000});
                return;
            }
            var changeInstanceIds=window.module.getCheckedList("changeInstanceId");
            var startFlag=true;
            var changeInstanceIdCount=0;
            for (var i = 0; i < changeInstanceIds.length; i++) {
                if(changeInstanceIds[i]){
                    changeInstanceIdCount++;
                }
            }
            if(changeInstanceIdCount!=0 && changeInstanceIdCount!=changeInstanceIds.length){
                top.layer.msg("您选择的审批单据流程状态不一致，无法提交流程",{time:2000});
                return;
            }

            if(changeInstanceIdCount==changeInstanceIds.length){
                this.submitProcess();
                return;
            }


            admin.post("/service-changes/chs-example-order/start-process",{billIds:selected,opinion:"请领导批准！"},function (r){
                if(r.success) {
                    top.layer.msg("采购订单已提交审批",{time:1000});
                    window.module.refreshTableData();
                } else {
                    var errs=[];
                    for (var i = 0; i < r.errors.length; i++) {
                      if(errs.indexOf(r.errors[i].message)==-1) {
                          errs.push(r.errors[i].message);
                      }
                    }
                    top.layer.msg((selected.length>errs.length?"部分订单提交失败:<br>":"订单提交失败:<br>")+errs.join("<br>"),{time:2000});
                }
            },{delayLoading:500,elms:[$("button")]});

        },
        draftProcess:function (selected,it) {
            debugger
            var changeInstanceIds=window.module.getCheckedList("changeInstanceId");
            if(selected==null || selected.length==0) {
                top.layer.msg("请勾选待审订单",{time:1000});
                return;
            }
            if(selected.length>1) {
                top.layer.msg("不支持合并审批",{time:1000});
                return;
            }
            if(changeInstanceIds[0]) {
                this.approve("draft","修改草稿后再次提交");
            } else {
                this.startProcess(selected,it);
            }
        },
        submitProcess:function (selected,it){
            this.approve("submit","修改草稿后再次提交");
        },
        revokeProcess:function (selected,it){
          this.approve("revoke","我要废弃流程");
        },
        abandonProcess:function (selected,it){
            this.approve("abandon","我要撤回流程");
        },
        rejectNode:function (selected,it){
            this.approve("reject","老子不同意");
        },
        agreeNode:function (selected,it){
            this.approve("agree","同意!");
        },
        approve:function (approveAction,opinion){
            console.log('revokeProcess',selected);
            var selected=window.module.getCheckedList("changeInstanceId");
            if(selected==null || selected.length==0) {
                top.layer.msg("请勾选订单",{time:1000});
                return;
            }
            admin.post("/service-changes/chs-example-order/approve",{instanceIds:selected,action:approveAction,opinion:opinion},function (r){
                if(r.success) {
                    top.layer.msg("已处理",{time:1000});
                    window.module.refreshTableData();
                } else {
                    var errs=[];
                    for (var i = 0; i < r.errors.length; i++) {
                        if(errs.indexOf(r.errors[i].message)==-1) {
                            errs.push(r.errors[i].message);
                        }
                    }
                    top.layer.msg((selected.length>errs.length?"部分订单提交失败:<br>":"订单提交失败:<br>")+errs.join("<br>"),{time:2000});
                }
            },{delayLoading:500,elms:[$("button")]});
        },


        openDetails:function (data){
            admin.putTempData("example-order-id",data.id,true);
            var dialogIndex=admin.popupCenter({
                type:2,
                id:"exampleOrderDetails",
                title: "订单明细",
                offset: 'auto',
                content: '/business/changes/example_order_item/example_order_item_list.html',
                area:["600px","80%"]
            });
            admin.putTempData("example-order-details-dialog-index",dialogIndex,true);
            admin.putTempData("example-order",data,true);
            //把订单表格刷新函数放入缓存
            admin.putTempData("refresh-example-order",window.module.refreshTableData,true);
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
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
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },

        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    //
    window.pageExt={form:form,list:list};
});
