layui.config({
    base: 'module/'
}).use(['form','settings','dropdown'], function () {


    //页面唯一标识
    let uuid = Math.uuid();
    let $ = layui.jquery;
    let form = layui.form;
    let config = layui.settings;
    let dropdown=layui.dropdown;

    // debugger
    var localLangProp=config.getLang();
    if(!localLangProp || localLangProp=='undefined') localLangProp="defaults";
    if(localLangProp && localLangProp!=USER_LANGUAGE_PROP) {
        var localLangCode=null;
        for (var i=0;i<LANGUAGES.length;i++) {
            if(LANGUAGES[i].property==localLangProp) {
                localLangCode=LANGUAGES[i].code;
            }
        }
        if(!localLangCode) {
            localLangCode="defaults";
        }
        switchLanguage(localLangCode,localLangProp);
        return;
    }


    config.setLang(USER_LANGUAGE_PROP);

    initLanguageSwitchButton();

    $("input[name='browserId']").val(uuid);

    // 表单提交
    form.on('submit(login-submit)', function (obj) {
        layer.load(2);
        $.ajax({
            url: config.base_server + '/security/login',
            xhrFields: {
                withCredentials: true
            },
            data: obj.field,
            async: true,
            type: 'POST',
            success: function (data) {
                //console.log(JSON.stringify(data))
                //debugger;
                if (data.success) {
                    var user=data.data;
                    // debugger
                    user.user.displayName=user.user.realName;
                    // if(user.user.activatedEmployeeName){
                    //     user.user.displayName=user.user.activatedEmployeeName;
                    // }
                    config.putUser(user);
                    console.log("token",user.token);
                    config.putToken(user.token);
                    initLanguage(function (){
                        layer.msg('登录成功', {icon: 1, time: 500}, function () {
                            location.replace('./index.html');
                        });
                    });
                } else {
                    layer.closeAll('loading');
                    layer.msg(data.message, {icon: 5, time: 1000});
                }
            },
            error: function (xhr) {
                //console.log(xhr)
                layer.closeAll('loading');
                layer.msg(xhr.responseJSON.resp_msg, {icon: 5, time: 500});
            }
        });
        //阻止表单跳转
        return false;
    });

    // 图形验证码
    $('.login-captcha').attr("src", config.base_server + "/security/captcha/image/"+uuid);
    $('.login-captcha').attr("style", "");

    // 图形验证码
    $('.login-captcha').click(function () {
        this.src = this.src + '?t=' + (new Date).getTime();
    });

    var fullHeight=$(window).height();
    var formHeight=$("#login-form").height();
    var formTop=(fullHeight-formHeight)/2;
    $("#login-form").css("padding",formTop+"px 10px 40px 10px");
    $("#login-form").css("opacity","0.0");
    $("#login-form").css("display","");
    setTimeout(function (){
        $("#login-form").animate({
            opacity:'1.0'
        },1000);
    },500)

    //
    function initLanguageSwitchButton() {
        var items=[];
        var userItem=null;
        var defaultsItem=null;
        for (var i=0;i<LANGUAGES.length;i++) {
            // if(LANGUAGES[i].code=="confuse") continue;
            if(LANGUAGES[i].code==USER_LANGUAGE_CODE) {
                userItem=LANGUAGES[i];
                items.push({title:'<span style="color: #f56c6c;">'+LANGUAGES[i].text+'</span>',code:LANGUAGES[i].code,property:LANGUAGES[i].property});
            } else {
                items.push({title:LANGUAGES[i].text,code:LANGUAGES[i].code,property:LANGUAGES[i].property});
            }
            if(LANGUAGES[i].code=="defaults") {
                defaultsItem=LANGUAGES[i];
            }
        }

        if(userItem==null) {
            userItem=defaultsItem;
        }

        $(".layui-card-header").append('<i class="foxnic-lang" style="float:right">'+userItem.text+'</i>');



        versionMenu=dropdown.render({
            elem: '.foxnic-lang'
            ,data: items
            ,click: function(obj){
                $('.foxnic-lang').text(obj.title);
                switchLanguage(obj.code,obj.property);
            }
        });
    }
    //
    function switchLanguage(code,prop) {
        $.ajax({
            async: true,
            type: 'POST',
            async: true,
            data:{code:code},
            url: config.base_server + '/service-system/sys-lang/switch-language',
            success:function (data) {
                if(code!="auto") {
                    config.setLang(prop);
                }
                location.reload();
            }
        });
    }
    //
    function initLanguage(cb) {

        localStorage.removeItem("language_codeLangs");
        localStorage.removeItem("language_defaultsLangs");
        localStorage.removeItem("language_timestamp");
        $.ajax({
            async: true,
            type: 'POST',
            async: true,
            url: config.base_server + '/service-system/sys-lang/query-list',
            success:function (data) {
                // debugger
                data=data.data;
                console.dir(data);
                //debugger;
                var codeLangs={};
                var defaultsLangs={};
                for (var i = 0; i < data.length; i++) {
                    codeLangs[data[i].context+":"+data[i].code]=data[i];
                    defaultsLangs[data[i].context+":"+data[i].defaults]=data[i];
                }
                localStorage.setItem("language_codeLangs",JSON.stringify(codeLangs));
                localStorage.setItem("language_defaultsLangs",JSON.stringify(defaultsLangs));
                localStorage.setItem("language_timestamp",(new Date()).getTime());
                cb();
            }
        });

    }





});
