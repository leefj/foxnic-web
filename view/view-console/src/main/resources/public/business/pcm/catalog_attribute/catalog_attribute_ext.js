/**
 * 数据存储分配 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-02 10:23:43
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

    var catalogId="-1";
    var versionNo=null;

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {

            var verEl=$("#versionNo").parents(".search-unit");
            verEl.children().remove();
            verEl.append('<button class="layui-btn layui-btn-primary version-no"><span class="version-no-text">版本</span><i class="layui-icon layui-icon-down layui-font-12"></i></button>');
        },
        /**
         * 搜索输入框初始化完毕后调用
         * */
        afterSearchInputReady: function() {
            var versionNoBox=fox.getSelectBox("versionNo");
        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(field=="dataType") {
                if(r.dataType=="STRING") {
                    return value+"("+r.length+")";
                } else if(r.dataType=="INTEGER") {
                    return value+"("+r.accuracy+")";
                } else if(r.dataType=="DECIMAL") {
                    return value+"("+r.accuracy+","+r.scale+")";
                } else {
                    return value;
                }
            } else {
                return value;
            }
        },
        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions,location) {
            conditions.catalogId={value:catalogId};
            conditions.versionNo={value:versionNo};
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function () {

            if(catalogId=="-1" || versionNo==null) {

                fox.disableButton($('.create-new-button'),true);
                fox.disableButton($('.batch-delete-button'),true);
            }

            //debugger
            if(versionNo=="editing") {
                fox.disableButton($('.ops-delete-button'),false);
                fox.disableButton($('.ops-edit-button'),false);
                fox.disableButton($('.apply-version-button'),false);
                fox.disableButton($('.create-new-button'),false);
                fox.disableButton($('.batch-delete-button'),false);
            } else {
                fox.disableButton($('.ops-delete-button'),true);
                fox.disableButton($('.ops-edit-button'),true);
                fox.disableButton($('.apply-version-button'),true);
                fox.disableButton($('.create-new-button'),true);
                fox.disableButton($('.batch-delete-button'),true);
            }

            if(versionNo=="activated") {
                fox.disableButton($('.create-version-button'),false);
            } else {
                fox.disableButton($('.create-version-button'),true);
            }



        },
        createVersion:function () {
            if(catalogId=="-1") {
                layer.msg("请选择一个分类", {icon: 2, time: 1000});
                return false;
            }

            var index=top.layer.confirm('确定要创建一个新版本吗？', {
                btn: ['创建版本','取消'] //按钮
            }, function(){
                top.layer.close(index);
                list.doCreateVersion();
            }, function(){});
        },
        doCreateVersion:function () {
            admin.request("/service-pcm/pcm-catalog/create-version",{id:catalogId},function (r) {
                if(!r.success) {
                    layer.msg(r.message, {icon: 2, time: 3000});
                    return;
                }

            });
        },
        applyVersion:function () {
            if(catalogId=="-1") {
                layer.msg("请选择一个分类", {icon: 2, time: 1000});
                return false;
            }
            if(versionNo==null || versionNo!="editing") {
                layer.msg("请选择编辑中的版本", {icon: 2, time: 1000});
                return false;
            }
            top.layer.confirm('确定要应用当前版本吗？', {
                btn: ['应用版本','取消'] //按钮
            }, function(){
                list.doApplyVersion();
            }, function(){});
        },
        doApplyVersion:function () {
            admin.request("/service-pcm/pcm-catalog/apply-version",{id:catalogId},function (r) {
                if(!r.success) {
                    layer.msg(r.message, {icon: 2, time: 3000});
                    return;
                }

            });
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            if(catalogId=="-1") {
                layer.msg("请选择一个分类！", {icon: 2, time: 1000});
                return false;
            }
            if(data && data.versionNo=="activated") {
                layer.msg("不允许编辑！", {icon: 2, time: 1000});
                return false;
            }
            return true;
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            if(data && data.versionNo=="activated") {
                layer.msg("不允许删除！", {icon: 2, time: 1000});
                return false;
            }
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
        /**
         * 末尾执行
         */
        ending:function() {
            window.module.loadAttributes=function (id) {
                catalogId=id;
                admin.putTempData("catalogId",catalogId,true);
                admin.request("/service-pcm/pcm-catalog/versions",{id:catalogId},function (r){
                    var items=[];
                    var activated=null,editing=null;
                    for (var i = 0; i < r.data.length; i++) {
                        items.push({title:r.data[i].name,id:r.data[i].value});
                        if(r.data[i].value=="activated") {
                            activated=r.data[i];
                            //activated.disabled=true;
                        }
                        else if(r.data[i].value=="editing") {
                            editing=r.data[i];
                            //editing.disabled=true;
                        }
                    }

                    if(activated!=null) {
                        versionNo=activated.value;
                        $(".version-no-text").text(activated.name);

                    } else {
                        if(editing!=null) {
                            versionNo=editing.value;
                            $(".version-no-text").text(editing.name);
                        }
                    }
                    window.module.refreshTableData();

                    dropdown.render({
                        elem: '.version-no'
                        ,data: items
                        ,click: function(obj){
                            debugger;
                            $(".version-no-text").text(obj.title);
                            versionNo=obj.id;
                            window.module.refreshTableData();
                        }
                    });
                })




            }
        }
    }

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {
            catalogId=admin.getTempData("catalogId");
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);

        },
        switchParam:function (sel) {

            var lengthEl=$("#length").parents(".layui-form-item");
            var accuracyEl=$("#accuracy").parents(".layui-form-item");
            var scaleEl=$("#scale").parents(".layui-form-item");
            if(sel==null || sel.length==0) {
                lengthEl.hide();
                accuracyEl.hide();
                scaleEl.hide();
                return;
            }
            var type=sel[0].value;
            if(type=="STRING") {
                lengthEl.show();
                accuracyEl.hide();
                scaleEl.hide();
                lengthEl.find("input").val(64);
            } else if(type=="INTEGER") {
                lengthEl.hide();
                accuracyEl.show();
                scaleEl.hide();
                accuracyEl.find("input").val(11);
            } else if(type=="DECIMAL") {
                lengthEl.hide();
                accuracyEl.show();
                scaleEl.show();
                accuracyEl.find("input").val(11);
                scaleEl.find("input").val(2);
            } else if(type=="DATE") {
                lengthEl.hide();
                accuracyEl.hide();
                scaleEl.hide();
            } else if(type=="LOGIC") {
                lengthEl.hide();
                accuracyEl.hide();
                scaleEl.hide();
            }

            window.module.adjustPopup();

        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            var me=this;
            console.log('afterDataFill',data);
             var dataTypeBox=fox.getSelectBox("dataType");
             dataTypeBox.update({
                 on:function (e) {
                     me.switchParam(e.arr);
                }
             });
             var first=SELECT_DATATYPE_DATA[0];
             var val=[{value:first.code,name:first.text}];
            dataTypeBox.setValue(val);
            me.switchParam(val);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            data.catalogId=catalogId;
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