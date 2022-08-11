layui.define(['settings', 'layer', 'admin', 'util','element'],function (exports) {

    const admin = layui.admin;
    const settings = layui.settings;
    const  api_definition_get="/service-bpm/bpm-process-definition/get-by-id";
    const  api_process_save="/service-bpm/bpm-process-instance/temporary-save";
    const  api_process_get="/service-bpm/bpm-process-instance/get-by-id";
    const  api_process_start="/service-bpm/bpm-process-instance/start";
    const  api_process_task="/service-bpm/bpm-task/process-task";
    const  api_process_abandon="/service-bpm/bpm-process-instance/delete";
    const  api_process_batch_abandon="/service-bpm/bpm-process-instance/delete-by-ids";
    const  api_process_fetch_back="/service-bpm/bpm-process-instance/fetch-back";
    const  api_process_jump="/service-bpm/bpm-process-instance/jump";
    const  api_process_get_by_bill="/service-bpm/bpm-process-instance/get-process-instance-by-bill";
    const  api_process_read_insert="/service-bpm/bpm-task-read/insert";
    const  api_process_read_update="/service-bpm/bpm-task-read/update";

    var bpm = {

        /**
         * 获得流程定义
         * */
        getProcessDefinition:function (id,callback) {
            admin.post(api_definition_get, {id:id}, function (result) {
                callback && callback(result);
            });
        },
        /**
         * 表单暂存
         * */
        save : function (data,callback,lockEls) {
            // debugger
            admin.post(api_process_save, data, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        readProcess:function (id,processId,taskId,comment,callback) {
            var read_api=api_process_read_update;
            if(!id) {
                read_api=api_process_read_insert;
            }
            admin.post(read_api, {id:id,processInstanceId:processId,taskId,taskId,comment}, function (result) {
                callback && callback(result);
            });
        },

        /**
         * 获得流程实例信息
         * */
        getProcessInstance : function (processInstanceId,callback,lockEls) {
            admin.post(api_process_get,{id:processInstanceId}, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        getProcessInstanceByBill : function (formCode,billId,callback,loc) {
            // debugger
            admin.post(api_process_get_by_bill,{billIds:[billId.id],formDefinitionCode:formCode}, function (result) {
                if(result.success) {
                    var plist=result.data;
                    var newPList=[];
                    for (var i = 0; i < plist.length; i++) {
                        if(plist[i].approvalStatus!="abandoned") {
                            newPList.push(plist[i]);
                        }
                    }
                    //
                    plist=newPList;
                    //
                    if(!plist || plist.length==0) {
                        if(loc=="bill") {
                            callback && callback(null);
                        } else {
                            top.layer.msg('当前业务单据尚未关联流程', {icon: 2, time: 1500});
                            return;
                        }
                    } else if(plist.length>=2) {
                        top.layer.msg('当前业务单据关联了'+plist.length+'个流程，尚不支持', {icon: 2, time: 1500});
                        return;
                    } else if(plist.length==1) {
                        callback && callback(plist[0]);
                    }
                } else {
                  fox.showMessage(result);
                }
            });
        },

        /**
         * 流程启动
         * code 流程定义代码
         * callback 回调函数
         * */
        start : function (params,callback,lockEls) {
            admin.post(api_process_start, params, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        /**
         * 流程撤回
         * */
        fetchBack : function (data,callback,lockEls) {
            // debugger
            admin.post(api_process_fetch_back, data, function (result) {
                callback && callback(result);
            }, {delayLoading:1000,elms:lockEls});
        },

        /**
         * 流程跳转
         * */
        jump : function (data,callback,lockEls) {
            // debugger
            admin.post(api_process_jump, data, function (result) {
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
         * processInstanceId 流程ID
         * taskId 任务ID
         * params 其它额外的参数
         * defaultValues 默认值   {"title":"流程标题","priority":"urgency"}  ;  priority 的可选值 urgency，normal
         * */
        openProcessView : function ( processInstanceId , taskId ,newPage,params,refreshTableData,refreshRowData,refreshLocation,defaultValues) {
            // if(!processInstanceId) {
            //     top.layer.msg('流程未指定，打开失败！', {icon: 2, time: 1500});
            //     return;
            // }
            // debugger
            if(!defaultValues) defaultValues={};

            admin.putVar("bpmDefaultValues",defaultValues);

            var refreshOption={
                refreshTableData:refreshTableData,
                refreshRowData:refreshRowData,
                refreshLocation:refreshLocation
            }

            admin.putVar("bpmRefreshOption",refreshOption);

            if(!params) params={};
            if(processInstanceId) {
                params["processInstanceId"]= processInstanceId;
            }
            if(taskId) {
                params["taskId"]= taskId;
            }

            var validateParam=0;
            if (params["processDefinitionId"]) {
                validateParam++;
            }
            if (params["processDefinitionCode"]) {
                validateParam++;
            }
            if (params["formDefinitionCode"]) {
                validateParam++;
            }
            if(validateParam>1) {
                top.layer.msg("processDefinitionId , processDefinitionCode , formDefinitionCode 参数只能指定其中一个", {icon: 2, time: 3000});
                return;
            }

            var queryString="";
            var queryStrings=[];
            for (var key in params) {
                queryStrings.push(key+"="+params[key]);
            }
            queryString=queryStrings.join("&");

            var me=this;
            var action = processInstanceId?"edit":"create";
            admin.putTempData('bpm-process-instance-form-data-form-action',action);

            var fullHeight=$(top).height();
            var fullwidth=$(top).width();
            var title = fox.translate('流程实例');
            if(action=="create") title=fox.translate('发起流程');
            else if(action=="edit") title=fox.translate("流程审批");
            else if(action=="view") title=fox.translate('流程详情');

            var id="bpm-process-instance-form-data-win";

            var index=-1;
            admin.putVar("updateProcessViewTitle",function (title) {
                window.top.layer.title(title, index);
            });

            index = admin.popupCenter({
                title: title,
                resize: false,
                // offset: [null,top],
                area: [(fullwidth-56)+"px",(fullHeight-56)+"px"],
                type: 2,
                id:id,
                content: '/business/bpm/process_instance/process_instance_form.html' + (queryString?("?"+queryString):""),
                finish: function (ctx) {
                    if(ctx=="close") return;
                    if(action=="create") {
                        refreshTableData();
                    }
                    if(action=="edit") {
                        // 如果没有 ctx 说明是来自保存按钮
                        if(!ctx) {
                            me.getProcessInstance(processInstanceId,function (r){
                               if(r.success) {
                                   if(refreshLocation=="process") {
                                       refreshRowData(r.data,false);
                                   } else if(refreshLocation=="task") {
                                       refreshRowData(r.data,false);
                                   } else if(refreshLocation=="bill") {
                                       refreshRowData(r.data,false);
                                   }
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

        },
        /**
         * 获得当前待审节点
         * */
        getTodoNodes: function (processData) {
            var nodes=[];
            for (var i = 0; i < processData.tasks.length; i++) {
                var task = processData.tasks[i];
                // 标记待办(当前审批节点)
                if (task.status == "todo") {
                    nodes.push(task.node);
                }
            }
            return nodes;
        },

        /**
         * 判断是否为当前待审节点
         * */
        isTodoNodes: function (processData,camundaNodeId) {
            if(!processData.tasks) return false;
            for (var i = 0; i < processData.tasks.length; i++) {
                var task = processData.tasks[i];
                // 标记待办(当前审批节点)
                if (task.status == "todo" && task.node.camundaNodeId===camundaNodeId) {
                    return true;
                }
            }
            return false;
        },

        /**
         * 判断是否为当前登录账户的审批节点
         * */
        isCurrentUserTodoNode: function (processData,camundaNodeId) {
            if(!processData.userTasks) return false;
            for (var i = 0; i < processData.userTasks.length; i++) {
                var task = processData.userTasks[i];
                // 标记待办(当前审批节点)
                if (task.status == "todo" && task.node.camundaNodeId===camundaNodeId) {
                    return true;
                }
            }
            return false;
        }

    };

    exports('bpm', bpm);
});
