/**
 * 员工 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 17:22:30
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
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown','laytpl'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload,laytpl=layui.laytpl;

    var lockedType, lockedId;

    //列表页的扩展
    var list={

        inTab:"",
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
            this.inTab=QueryString.get("inTab")
        },
        beforeTableRender:function (tableConfig) {
            var cols=tableConfig.cols[0];
            for (var i=0;i<extInfoAttrs.length;i++) {
                var attr=extInfoAttrs[i];
                cols.splice(cols.length-2, 0, {
                    field: 'extInfo_'+attr.field,
                    align:"left",
                    fixed:false,
                    hide:false,
                    sort: false  ,
                    width:100,
                    shortField:attr.field,
                    title: fox.translate(attr.shortName) ,
                    templet: function (d) {
                        return fox.getProperty(d,["extInfo",d.LAY_COL.shortField],0);
                    }
                });

            }
            // debugger
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * */
        beforeQuery:function (conditions,param,location) {
            //debugger
            console.log('beforeQuery',conditions,param);
            if(this.inTab=="yes") {
                if (lockedType == "pos") {
                    param.positionId = lockedId;
                }
                if (lockedType == "com" || lockedType == "dept") {
                    param.orgId = lockedId;
                }
            }
            return true;
        },
        afterQuery:function (){
            if(this.inTab=="yes") {
                if (!lockedType) {
                    fox.disableButton($("#add-button"), true);
                }
                if (lockedType == "dept" || lockedType == "com") {
                    fox.disableButton($("#add-button"), true);
                }

                if (lockedType == "pos") {
                    fox.disableButton($("#add-button"), false);
                }
            }
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
        createUser:function (data){
            admin.request(api, data, function (data) {
                clearTimeout(task);
                layer.closeAll('loading');
                if (data.success) {
                    layer.msg(data.message, {icon: 1, time: 500});
                    var index=admin.getTempData('hrm-employee-form-data-popup-index');
                    admin.finishPopupCenter(index);
                } else {
                    layer.msg(data.message, {icon: 2, time: 1000});
                }
            }, "POST");
        },
        lockRange:function (type,id) {
            //debugger
            lockedType=type;
            lockedId=id;
            admin.putTempData("lockedPositionId",null,true);
            if(lockedType=="pos") {
                admin.putTempData("lockedPositionId",lockedId,true);
            }
            window.module.refreshTableData();
        },
        /**
         * 末尾执行
         */
        ending:function() {
            window.module.lockRange=this.lockRange;
        }
    }


    var fieldHTML=[
        '<div class="layui-form-item" >',
        '	<div class="layui-form-label layui-form-label-c1"><div>{{d.label}}</div></div>',
        '	<div class="layui-input-block layui-input-block-c1">',
        '		<input lay-filter="{{d.name}}" id="{{d.name}}" name="{{d.name}}" placeholder="{{d.placeholder}}" type="text" class="layui-input"  />',
        '	</div>',
        '</div>'
    ];

    //表单页的扩展
    var form={
        action:null,
        /**
         * 表单初始化前调用
         * */
        beforeInit:function (action,data) {
            this.action = action;
            for (var i=0;i<extInfoAttrs.length;i++) {
                var attr=extInfoAttrs[i];
                laytpl(fieldHTML.join("\n")).render({
                    name:"extInfo_"+attr.field,
                    label: fox.translate(attr.shortName),
                    placeholder:fox.translate("请输入"+attr.shortName),
                }, function(result){
                    var els=$(".form-column");
                    //debugger
                    for (var j = 0; j < els.length ; j++) {
                        var el=$(els[j]);
                        if(i%els.length==j) {
                            el.append(result);
                        }
                    }
                });
                // debugger
            }
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);
            var selectedPosition=admin.getVar("selectedPosition");
            if(selectedPosition!=null && this.action=="create") {
                $("#primaryPositionId").val(selectedPosition.id);
                fox.fillDialogButtons();
            }

            var extInfo=data.extInfo;
            for(var name in extInfo) {
                data["extInfo_"+name]=extInfo[name];
            }

        },
        /**
         * 对话框之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="请选择主岗";
            return param;
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
            // debugger
            var extInfo=fox.subJsonObject(data,"extInfo_",true);
            data["extInfo"] = extInfo;
            //debugger
            console.log("beforeSubmit",data);
            // debugger;
            data.positionId= admin.getTempData("lockedPositionId");;
            return true;
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
