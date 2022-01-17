/**
 * 定时任务配置 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-07 11:48:29
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

    //模块基础路径
    const moduleURL="/service-job/sys-job";

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
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
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
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {
            return queryString;
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
        invokeImm:function (data){
            console.log('invokeImm',data);
            admin.post(moduleURL+"/invoke", { id : data.id }, function (data) {
                if(data.success) {
                    top.layer.msg(data.message, {icon: 1, time: 1500});
                } else {
                    top.layer.msg(data.message, {icon: 1, time: 1500});
                }
            });
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
         * 表单初始化前调用 , 并传入表单数据
         * */
        beforeInit:function (action,data) {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit");

            var div=$("#cronExpr").parent(".layui-input-block");
            div.css("display","flex")

            div.append('<button id="cronExprSelectButton" type="button" class="layui-btn layui-btn"  style="margin-left: 10px;height: 37px;width: 50px;padding:0px;"><i class="layui-icon layui-icon-down"></i></button>');
            div.append('<button id="cronExprValidateButton" type="button" class="layui-btn layui-btn" style="height: 37px;width: 50px;padding:0px;"><i class="layui-icon layui-icon-ok"></i></button>');

            dropdown.render({
                elem: '#cronExprSelectButton' //可绑定在任意元素中，此处以上述按钮为例
                ,data: [{
                    title: '周期任务'
                    ,id: 102
                    ,type: 'parent'  //菜单类型，支持：normal/group/parent/-
                    ,child: [
                        { title: '<b>0/2 * * * * ?</b>&nbsp;&nbsp;  每2秒执行一次',cron:"0/2 * * * * ?"  },
                        { title: '<b>0 0/2 * * * ?</b>&nbsp;&nbsp;   每2分钟行一次',cron:"0 0/2 * * * ?"  },
                        { title: '<b>0 0 2 1 * ?</b>&nbsp;&nbsp;   在每月的1日的凌晨2点调整任务',cron:"0 0 2 1 * ?"  },
                        { title: '<b>0 15 10 ? * MON-FRI</b>&nbsp;&nbsp;   周一到周五每天上午10:15执行',cron:"0 15 10 ? * MON-FRI"  },
                        { title: '<b>0 15 10 ? * 6L 2022-2026</b>&nbsp;&nbsp;   2022-2026年每月最后一个星期五上午10:15执行',cron:"0 15 10 ? * 6L 2022-2026"  },
                        { title: '<b>0 0 10,14,16 * * ?</b>&nbsp;&nbsp;   每天上午10点，下午2点，4点执行',cron:"0 0 10,14,16 * * ?"  },
                        { title: '<b>0 0/30 9-17 * * ?</b>&nbsp;&nbsp;   朝九晚五工作时间内每半小时行一次 ',cron:"0 0/30 9-17 * * ?"  },
                        { title: '<b>0 0 12 ? * WED</b>&nbsp;&nbsp;   表示每个星期三中午12点 ',cron:"0 0 12 ? * WED"  }
                    ]},{
                    title: '定点任务'
                    ,id: 102
                    ,type: 'parent'  //菜单类型，支持：normal/group/parent/-
                    ,child: [
                        { title: '<b>0 0 12 * * ?</b>&nbsp;&nbsp;   每天中午12点触发',cron:"0 0 12 * * ?"  },
                        { title: '<b>0 15 10 ? * *</b>&nbsp;&nbsp;   每天上午10:15触发 ',cron:"0 15 10 ? * *"  },
                        { title: '<b>0 15 10 * * ?</b>&nbsp;&nbsp;   每天上午10:15触发 ',cron:"0 15 10 * * ?"  },
                        { title: '<b>0 15 10 * * ?</b>&nbsp;&nbsp;   每天上午10:15触发 ',cron:"0 15 10 * * ?"  },
                        { title: '<b>0 15 10 * * ? 2025</b>&nbsp;&nbsp;   2025年每天上午10:15触发 ',cron:"0 15 10 * * ? 2025"  },
                        { title: '<b>0 * 14 * * ?</b>&nbsp;&nbsp;   每天下午2点到2:59期间的每1分钟触发 ',cron:"0 * 14 * * ?"  },
                        { title: '<b>0 0/5 14 * * ?</b>&nbsp;&nbsp;   每天下午2点到2:55期间的每5分钟触发 ',cron:"0 0/5 14 * * ?"  },
                        { title: '<b>0 0/5 14,18 * * ?</b>&nbsp;&nbsp;   每天下午2点到2:55期间和下午6点到6:55期间每5分钟触发 ',cron:"0 0/5 14,18 * * ?"  },
                        { title: '<b>0 0-5 14 * * ?</b>&nbsp;&nbsp;   每天下午2点到2:05期间每1分钟触发 ',cron:"0 0-5 14 * * ?"  }
                    ]},{
                    title: '特殊任务'
                    ,id: 102
                    ,type: 'parent'  //菜单类型，支持：normal/group/parent/-
                    ,child: [
                        { title: '<b>0 10,44 14 ? 3 WED</b>&nbsp;&nbsp;   每年三月的星期三的下午2:10和2:44触发',cron:"0 10,44 14 ? 3 WED"  },
                        { title: '<b>0 15 10 ? * MON-FRI</b>&nbsp;&nbsp;   周一至周五的上午10:15触发 ',cron:"0 15 10 ? * MON-FRI"  },
                        { title: '<b>0 15 10 15 * ?</b>&nbsp;&nbsp;   每月15日上午10:15触发 ',cron:"0 15 10 15 * ?"  },
                        { title: '<b>0 15 10 L * ?</b>&nbsp;&nbsp;   每月最后一日的上午10:15触发 ',cron:"0 15 10 L * ?"  },
                        { title: '<b>0 15 10 ? * 6L</b>&nbsp;&nbsp;   每月的最后一个星期五上午10:15触发',cron:"0 15 10 ? * 6L"  },
                        { title: '<b>0 15 10 ? * 6L 2022-2025</b>&nbsp;&nbsp;   2022-2025年每月最后一个星期五上午10:15触发',cron:"0 15 10 ? * 6L 2022-2025"  },
                        { title: '<b>0 15 10 ? * 6#3</b>&nbsp;&nbsp;   每月的第三个星期五上午10:15触发',cron:"0 15 10 ? * 6#3"  }
                    ]}
                ]
                ,id: 'demo1'
                //菜单被点击的事件
                ,click: function(obj){
                    $("#cronExpr").val(obj.cron);
                }
            });

            $("#cronExprValidateButton").click(function (){

                var api=moduleURL+"/simulate";
                admin.post(api, {cronExpr: $("#cronExpr").val()}, function (data) {
                    if (data.success) {
                        admin.popupCenter({
                            title : "近10次执行时间",
                            area:["220px",null],
                            content:"<div style='padding: 10px;line-height: 24px'>"+data.data.join("<br>")+"</div>"
                        });
                    } else {
                        top.layer.msg("错误："+data.message, {icon: 2, time: 1500});
                    }
                }, {delayLoading:1000});

            });


        },
        /**
         * 窗口调节前
         * */
        beforeAdjustPopup:function () {
            console.log('beforeAdjustPopup');
            return true;
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
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },
        /**
         * 数据提交后窗口关闭前，如果返回 false，停止后续步骤的执行
         * */
        betweenFormSubmitAndClose:function (param,result) {
            console.log("betweenFormSubmitAndClose",result);
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },

        /**
         * 文件上传组件回调
         *  event 类型包括：
         *  afterPreview ：文件选择后，未上传前触发；
         *  afterUpload ：文件上传后触发
         *  beforeRemove ：文件删除前触发
         *  afterRemove ：文件删除后触发
         * */
        onUploadEvent: function(e) {
            console.log("onUploadEvent",e);
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
