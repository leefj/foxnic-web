layui.define(function (exports) {
    /**
     * 用于动态切换环境地址
     */
    //默认地址
    var defUrl = 'http://127.0.0.1:9900/';
    //当前环境的api地址
    var apiUrl;
    try{
        if (apiServerUrl.length > 0) {
            apiUrl = apiServerUrl;
        } else {
            apiUrl = defUrl;
        }
    } catch(e) {
        apiUrl = defUrl;
    }
    var settings = {
        base_server: apiUrl,
        tableName: 'foxnic-web',  // 存储表名
        clientId: 'web-console', // 应用id
        isolationVersion: '', // 隔离版本
        clientSecret: 'web-console', // 应用秘钥
        autoRender: false,  // 窗口大小改变后是否自动重新渲染表格，解决layui数据表格非响应式的问题，目前实现的还不是很好，暂时关闭该功能
        pageTabs: true,   // 是否开启多标签
        language:null,
        getLang:function() {
        	if(this.language==null) {
        		this.language=localStorage.getItem("lang");
        	}
        	return this.language;
        },
        setLang:function(lang) {
        	localStorage.setItem("lang",lang);
        },
        // 获取缓存的token
        getToken: function () {
            var t = layui.data(settings.tableName).token;
            if (t) {
                return JSON.parse(t);
            }
        },
        // 清除user
        removeToken: function () {
            layui.data(settings.tableName, {
                key: 'token',
                remove: true
            });
        },
        // 缓存token
        putToken: function (token) {
            layui.data(settings.tableName, {
                key: 'token',
                value: JSON.stringify(token)
            });
        },
        // 当前登录的用户
        getUser: function () {
            var u = layui.data(settings.tableName).login_user;
            if (u) {
                return JSON.parse(u);
            }
        },
        // 缓存user
        putUser: function (user) {
            layui.data(settings.tableName, {
                key: 'login_user',
                value: JSON.stringify(user)
            });
        }
    };
    exports('settings', settings);
});
