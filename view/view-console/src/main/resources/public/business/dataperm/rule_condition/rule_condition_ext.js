/**
 * 数据权限规则范围条件 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-28 18:39:09
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

    const moduleURL="/service-dataperm/dp-rule-condition";
    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {

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
            admin.putTempData('dp-rule-condition-form-data', null,true);
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("list:beforeInit");
            var varsButtonHtml="<br/><span id='varsButton' class='layui-badge layui-bg-black' style='cursor: pointer;user-select:none;'>环境</span>";
            var el=$("#conditionExpr").parents(".layui-form-item").find(".layui-form-label").find("div");
            el.append(varsButtonHtml);
            $("#varsButton").click(this.viewVariables);


            var testButtonHtml="<br/><span id='conditionTestButton' class='layui-badge layui-bg-black' style='cursor: pointer;user-select:none;'>测试</span>";
            var el=$("#conditionTestValue").parents(".layui-form-item").find(".layui-form-label").find("div");
            el.append(testButtonHtml);
            $("#conditionTestButton").click(this.testCondition);
        },
        viewVariables:function () {
            var data=window.module.getFormData();
            if(!data.id) {
                top.layer.msg("请选择一个条件节点！",{icon: 2,time:2000});
                return
            }
            admin.putTempData("contextDialogData",data,true);
            var contextDialogIndex=top.layer.open({
                type: 2,
                area:["700px","75%"],
                content: "/business/dataperm/rule_condition/context_dialog.html"
            });
            admin.putTempData("contextDialogIndex",contextDialogIndex,true);
        },
        testCondition:function () {
            var data=window.module.getFormData();
            admin.post("/service-dataperm/dp-rule-condition/test-spring-el",data,function (r){
                //debugger;
                if(r.success) {
                    top.layer.msg(r.message+" , result = "+r.data,{icon: 1,time:1000});
                } else {
                    if(r.extra.exception) {
                        top.layer.open({
                            type: 1,
                            area:["70%","85%"],
                            content: "<div style='padding: 16px'>"+r.extra.exception+"</div>"
                        });
                    } else {
                        top.layer.msg(r.message,{icon: 2,time:2000});
                    }

                }

            })
        },
        beforeAdjustPopup:function () {
            return false;
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);
        },
        chooseProperty:function (data,input,button) {
            if(!data || !data.id) {
                top.layer.msg("请选择一个节点",{time:1000});
                return;
            }
            admin.putTempData("object_browser_api","/service-dataperm/dp-rule/query-field-list?id="+data.ruleId,true);
            admin.putTempData("selectedProperty",input.val(),true);
            var poPropertyDialogIndex=top.layer.open({
                type: 2,
                area:["500px","75%"],
                content: "/business/dataperm/rule_condition/object_dialog.html"
            });
            admin.putTempData("updateButton",function(value) {
                button.text(value);
                input.val(value);
            },true);
            admin.putTempData("poPropertyDialogIndex",poPropertyDialogIndex,true);

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
         * 数据提交后窗口关闭前，如果返回 false，停止后续步骤的执行
         * */
        betweenFormSubmitAndClose:function (param,result) {
            console.log("betweenFormSubmitAndClose",result);
            return false;
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
            parent.changeNodeName(window.module.getFormData());
        },

        loadFormData:function (id) {
            // debugger
            admin.putTempData('dp-rule-condition-form-data', null,true);
            admin.request(moduleURL+"/get-by-id", { id : id }, function (data) {
                if(data.success) {
                    admin.putTempData('dp-rule-condition-form-data', data.data,true);
                    window.module.fillFormData();
                    if(data.data.type=="expr") {
                        $("#queryProperty-button").text(data.data.queryProperty);
                        $("#queryProperty").parents(".layui-form-item").show();
                        $("#exprType").parents(".layui-form-item").show();
                        $("#variables").parents(".layui-form-item").show();
                    } else {
                        $("#queryProperty-button").text("请选择属性");
                        $("#queryProperty").parents(".layui-form-item").hide();
                        $("#exprType").parents(".layui-form-item").hide();
                        $("#variables").parents(".layui-form-item").hide();
                    }
                    // $(".form-container").css("display","");
                } else {
                    layer.msg(data.message, {icon: 1, time: 1500});
                }
            });
        },
        /**
         * 末尾执行
         */
        ending:function() {
            window.loadFormData=this.loadFormData;
        }
    }
    //
    window.pageExt={form:form,list:list};
});
