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
    var verEl=null;
    var versionMenu=null;

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            verEl=$("#versionNo").parents(".search-unit");
            verEl.children().remove();
            verEl.append('<button class="layui-btn layui-btn-primary version-no"><span class="version-no-text">版本</span><i class="layui-icon layui-icon-down layui-font-12"></i></button>');
            versionMenu=dropdown.render({
                elem: '.version-no'
                ,data: []
                ,click: function(obj){
                    $(".version-no-text").text(obj.title);
                    versionNo=obj.id;
                    window.module.refreshTableData();
                }
            });
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
                    value=value+"("+r.length+")";
                } else if(r.dataType=="INTEGER") {
                    value= value+"("+r.accuracy+")";
                } else if(r.dataType=="DECIMAL") {
                    value= value+"("+r.accuracy+","+r.scale+")";
                }
            }
            //debugger
            if(r.valid==0) {
                return "<span style='color:#AAA'>"+value+"</span>";
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
        afterQuery : function (data) {
            //debugger
            //如果未指定分类
            if(catalogId=="-1" || versionNo==null) {
                fox.disableButton($('.create-new-button'),true);
                fox.disableButton($('.batch-delete-button'),true);
            }

            //debugger
            //如果当前为编辑版本
            if(versionNo=="editing") {
                fox.disableButton($('.ops-delete-button'),false);
                fox.disableButton($('.ops-edit-button'),false);
                fox.disableButton($('.apply-version-button'),false);
                fox.disableButton($('.create-new-button'),false);
                fox.disableButton($('.batch-delete-button'),false);
                for (var i = 0; i < data.length; i++) {
                    if(data[i].catalogId!=catalogId) {
                        fox.disableButton($('.ops-delete-button').filter("[data-id='"+data[i].id+"']"), true);
                        fox.disableButton($('.ops-edit-button').filter("[data-id='"+data[i].id+"']"), true);
                        $("input.list-checkbox[type=checkbox]").filter("[data-id='"+data[i].id+"']").attr("disabled", "yes");
                        $("input.list-checkbox[type=checkbox]").filter("[data-id='"+data[i].id+"']").siblings("div").css("opacity",0.6);
                    }
                }
            }
            //如果是生效版本
            else {
                $("input.list-checkbox[type=checkbox]").attr("disabled", "yes");
                $("input.list-checkbox[type=checkbox]").siblings("div").css("opacity",0.6);
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
                    top.layer.msg(r.message, {icon: 2, time: 3000});
                    return;
                }
                versionNo="editing";
                list.loadAttributes(catalogId);
            });
        },
        applyVersion:function () {
            if(catalogId=="-1") {
                top.layer.msg("请选择一个分类", {icon: 2, time: 1000});
                return false;
            }
            if(versionNo==null || versionNo!="editing") {
                top.layer.msg("请选择编辑中的版本", {icon: 2, time: 1000});
                return false;
            }
            var index=top.layer.confirm('确定要应用当前版本吗？', {
                btn: ['应用版本','取消'] //按钮
            }, function(){
                top.layer.close(index);
                list.doApplyVersion();
            }, function(){});
        },
        doApplyVersion:function () {
            var task=setTimeout(function(){layer.load(2);},1000);
            fox.disableButton($('.apply-version-button'),true);
            admin.request("/service-pcm/pcm-catalog/apply-version",{id:catalogId},function (r) {
                fox.disableButton($('.apply-version-button'),false);
                clearTimeout(task);
                layer.closeAll('loading');
                if(!r.success) {
                    var details=[];
                    if(r.errors && r.errors.length>0) {
                        for (var i = 0; i < r.errors.length; i++) {
                            details.push("&nbsp;&nbsp;"+(i+1)+"."+r.errors[i].message);
                        }
                    }
                    var msg=r.message;
                    if(details.length>0) {
                        msg+=":<br>"+details.join("<br>");
                    }
                    top.layer.msg(msg, {icon: 2, time: 3000});
                    return;
                }
                versionNo=null;
                list.loadAttributes(catalogId);

                top.layer.msg("版本应用成功", {icon: 1, time: 1000});
            });
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            // if(catalogId=="-1") {
            //     layer.msg("请选择一个分类！", {icon: 2, time: 1000});
            //     return false;
            // }
            // if(data && data.versionNo=="activated") {
            //     layer.msg("不允许编辑！", {icon: 2, time: 1000});
            //     return false;
            // }
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
        afterSingleDelete:function (data){
            this.loadAttributes(catalogId);
            return false;
        },
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        afterBatchDelete:function (selected) {
            this.loadAttributes(catalogId);
            return false;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        loadAttributes:function (id) {
            if(id!=catalogId) {
                versionNo=null;
            }
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

                if(!versionNo) {
                    if (activated != null) {
                        versionNo = activated.value;
                        $(".version-no-text").text(activated.name);

                    } else {
                        if (editing != null) {
                            versionNo = editing.value;
                            $(".version-no-text").text(editing.name);
                        }
                    }
                }
                window.module.refreshTableData();
                versionMenu.reload({data:items});
            })
        },
        /**
         * 末尾执行
         */
        ending:function() {
            window.module.loadAttributes=this.loadAttributes;
        }
    }

    var isCreateNew;

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
        setDefaultIf:function(input,defval) {
            if(!input.val()) {
                input.val(defval)
            }
        },
        switchParam:function (sel) {
            // debugger
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
                this.setDefaultIf(lengthEl.find("input"),64);
            } else if(type=="INTEGER") {
                lengthEl.hide();
                accuracyEl.show();
                scaleEl.hide();
                this.setDefaultIf(accuracyEl.find("input"),11);
            } else if(type=="DECIMAL") {
                lengthEl.hide();
                accuracyEl.show();
                scaleEl.show();

                this.setDefaultIf(accuracyEl.find("input"),11);
                this.setDefaultIf(scaleEl.find("input"),2);

            } else if(type=="DATE_TIME") {
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
        afterDataFill: function (data) {
            var me = this;
            console.log('afterDataFill', data);
            var dataTypeBox = fox.getSelectBox("dataType");
            dataTypeBox.update({
                disabled:data.id,
                on: function (e) {
                    me.switchParam(e.arr);
                }
            });
            var selected
            if(!data.id) {
                selected = SELECT_DATATYPE_DATA[0];
            } else {
                for (let i = 0; i < SELECT_DATATYPE_DATA.length; i++) {
                   if(SELECT_DATATYPE_DATA[i].code==data.dataType) {
                       selected = SELECT_DATATYPE_DATA[i];
                       break;
                   }
                }
            }
            var val = [{value: selected.code, name: selected.text}];
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