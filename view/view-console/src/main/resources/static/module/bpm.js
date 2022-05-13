layui.define(['settings', 'layer', 'admin', 'util','element'],function (exports) {

    var admin = layui.admin;
    const  api_save="/service-bpm/bpm-process-instance/temporary-save";
    const  api_start="/service-bpm/bpm-process-instance/start";
    const  api_process_task="/service-bpm/bpm-task/process-task";
    var bpm = {

        /**
         * 表单暂存
         * */
        save : function (data,callback,lockEls) {
            admin.post(api_save, data, function (result) {
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

        processTask : function (params,callback,lockEls) {
            admin.post(api_process_task, params, function (result) {
                callback && callback(result);
            },{delayLoading:1000,elms:lockEls});
        }

    };

    exports('bpm', bpm);
});
