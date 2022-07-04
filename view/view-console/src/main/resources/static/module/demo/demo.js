layui.define(['settings', 'layer', 'admin', 'util','element'],function (exports) {

    const admin = layui.admin;
    const settings = layui.settings;

    var demo = {
        test:function () {
            alert("this is test");
        }
    };

    exports('demo', demo);

})
