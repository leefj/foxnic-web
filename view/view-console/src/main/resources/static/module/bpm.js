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
            debugger
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
        openProcessView : function ( processInstanceId , newPage) {
            var me=this;
            var action = processInstanceId?"edit":"create";
            admin.putTempData('bpm-process-instance-form-data-form-action',action);
            var queryString="";
            if(processInstanceId) queryString='id=' + processInstanceId;
            var area=admin.getTempData('bpm-process-instance-form-area');
            var height= (area && area.height) ? area.height : ($(window).height()*0.6);
            var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
            var title = fox.translate('流程实例');
            if(action=="create") title=fox.translate('发起')+title;
            else if(action=="edit") title=fox.translate('修改')+title;
            else if(action=="view") title=fox.translate('查看')+title;

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



        }

    };

    exports('bpm', bpm);
});
