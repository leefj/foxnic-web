layui.define(['settings', 'layer', 'admin', 'util','element'],function (exports) {

    var admin = layui.admin;
    const  api_save="/service-bpm/bpm-process-instance/temporary-save";
    const  api_get="/service-bpm/bpm-process-instance/get-by-id";
    const  api_start="/service-bpm/bpm-process-instance/start";
    const  api_process_task="/service-bpm/bpm-task/process-task";
    const  api_process_abandon="/service-bpm/bpm-process-instance/delete";
    const  api_process_batch_abandon="/service-bpm/bpm-process-instance/delete-by-ids";
    var bpm = {

        /**
         * 表单暂存
         * */
        save : function (data,callback,lockEls) {
            // debugger
            admin.post(api_save, data, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        /**
         * 获得流程实例信息
         * */
        getProcessInstance : function (processInstanceId,callback,lockEls) {
            admin.post(api_get,{id:processInstanceId}, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        /**
         * 流程启动
         * code 流程定义代码
         * callback 回调函数
         * */
        start : function (params,callback,lockEls) {
            admin.post(api_start, params, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        /**
         * 处理流程任务
         * */
        processTask : function (params,callback,lockEls) {
            admin.post(api_process_task, params, function (result) {
                callback && callback(result);
            },{delayLoading:1000,elms:lockEls});
        },


        /**
         * 废弃流程实例
         * */
        abandon : function (params,callback,lockEls) {
            admin.post(api_process_abandon, params, function (result) {
                callback && callback(result);
            },{delayLoading:1000,elms:lockEls});
        },

        /**
         * 批量废弃流程实例
         * */
        abandonBatch : function (params,callback,lockEls) {
            admin.post(api_process_batch_abandon, params, function (result) {
                callback && callback(result);
            },{delayLoading:1000,elms:lockEls});
        },

        /**
         * 打开流程界面
         * */
        openProcessView : function ( processInstanceId , taskId ,newPage) {
            // if(!processInstanceId) {
            //     top.layer.msg('流程未指定，打开失败！', {icon: 2, time: 1500});
            //     return;
            // }
            var me=this;
            var action = processInstanceId?"edit":"create";
            admin.putTempData('bpm-process-instance-form-data-form-action',action);
            var queryString="";
            var queryStrings=[];
            if(processInstanceId) {
                queryStrings.push('id=' + processInstanceId);
            }
            if(taskId) {
                queryStrings.push('taskId=' + taskId);
            }
            queryString=queryStrings.join("&");
            var area=admin.getTempData('bpm-process-instance-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('流程实例');
            if(action=="create") title=fox.translate('流程发起');
            else if(action=="edit") title=fox.translate("流程审批");
            else if(action=="view") title=fox.translate('流程详情');

            admin.popupCenter({
                title: title,
                resize: false,
                offset: [top,null],
                area: ["90%",height+"px"],
                type: 2,
                id:"bpm-process-instance-form-data-win",
                content: '/business/bpm/process_instance/process_instance_form.html' + (queryString?("?"+queryString):""),
                finish: function (ctx) {
                    if(action=="create") {
                        window.module.refreshTableData();
                    }
                    if(action=="edit") {
                        // 如果没有 ctx 说明是来自保存按钮
                        if(!ctx) {
                            me.getProcessInstance(processInstanceId,function (r){
                               if(r.success) {
                                   window.module.refreshRowData(r.data,false);
                               } else {
                                   fox.showMessage(r);
                               }
                            });
                        }
                    }
                }
            });



        },
        /**
         * 选择审批人
         * */
        chooseAssignee:function (param){
            if(param.prepose){
                param=param.prepose(param);
                if(!param) return;
            }
            var title=param.title;
            if(!title) {
                title="请选处理人";
            }
            // debugger;
            var value = param.value;
            if(!value && param.inputEl) {
                value = param.inputEl.val();
            }
            param.chooseAssigneeCallbackEvent=function(ids,nodes) {
                // debugger;
                if(param.inputEl) {
                    param.inputEl.val(ids.join(","));
                }
                console.log("ids="+ids.join(","))
                var names=[];
                var ns=[];
                for (var i = 0; i < nodes.length; i++) {
                    // debugger
                    names.push(nodes[i].targetName);
                    ns.push({targetId:nodes[i].targetId,targetType:nodes[i].targetType,targetName:nodes[i].targetName});
                }
                if (names.length>0) {
                    if(param.buttonEl) {
                        param.buttonEl.find("span").text(names.join(","));
                    }
                } else {
                    if(param.buttonEl) {
                        param.buttonEl.find("span").text(param.buttonEl.find("span").attr("default-label"));
                    }
                }
                if(param.callback) {
                    param.callback(param,{field:param.field,selectedIds:ids,selected:ns,fromData:param.fromData,inputEl:param.inputEl,buttonEl:param.buttonEl});
                }
            }
            // debugger
            admin.putTempData("assignee-dialog-value",value,true);
            admin.putTempData("assignee-dialog-options",param,true);

            admin.post("/service-hrm/hrm-favourite-group-item/remove-all",{temporary:1},function (r){
                var dialogIndex=admin.popupCenter({
                    type:2,
                    id:"assigneeDialog",
                    title: title,
                    content: '/camunda/dialog/assignee_dialog.html',
                    offset: 'auto',
                    area:["1150px","90%"]
                });
                admin.putTempData("assignee-dialog-index",dialogIndex,true);
            });

        }

    };

    exports('bpm', bpm);
});
