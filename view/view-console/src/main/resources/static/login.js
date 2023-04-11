layui.config({
    base: 'module/'
}).use(['form','settings','dropdown'], function () {


    //页面唯一标识
    let uuid = Math.uuid();
    let $ = layui.jquery;
    let form = layui.form;
    let config = layui.settings;
    let dropdown=layui.dropdown;
    if(!LANGUAGE_RANGE || LANGUAGE_RANGE.length==0) {
        LANGUAGE_RANGE=["defaults","auto","zh_cn","en_gb","zh_tw"];
    }

    // debugger
    var localLangProp=config.getLang();
    var localLangCode=null;
    if(!localLangProp || localLangProp=='undefined') localLangProp="auto";
    // 初始化
    if(localLangProp && localLangProp!=USER_LANGUAGE_PROP) {
        for (var i=0;i<LANGUAGES.length;i++) {
            if(LANGUAGES[i].property==localLangProp) {
                localLangCode=LANGUAGES[i].code;
            }
        }
        if(!localLangCode) {
            localLangCode="auto";
        }
        switchLanguage(localLangCode,localLangProp);
        return;
    }




    config.setLang(USER_LANGUAGE_PROP);

    $("#login-submit").addClass("layui-btn-disabled").attr("disabled",true);
    initLanguage(function (){
        $("#login-submit").removeClass("layui-btn-disabled").attr("disabled",false);
    });
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
                    location.replace('./index.html');
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
        for (var i=0;i<LANGUAGES.length;i++) {
            // if(LANGUAGES[i].code=="confuse") continue;
            if(LANGUAGE_RANGE!=null && LANGUAGE_RANGE.length>0) {
                if(LANGUAGE_RANGE.indexOf(LANGUAGES[i].code)==-1) continue;
            }
            if(LANGUAGES[i].code==USER_LANGUAGE_CODE) {
                userItem=LANGUAGES[i];
                items.push({title:'<span style="color: #f56c6c;">'+LANGUAGES[i].text+'</span>',code:LANGUAGES[i].code,property:LANGUAGES[i].property});
            } else {
                items.push({title:LANGUAGES[i].text,code:LANGUAGES[i].code,property:LANGUAGES[i].property});
            }
        }

        if(userItem==null) {
            userItem=LANGUAGE_DEFAULTS;
        }

        $(".layui-card-header").append('<i class="foxnic-lang" style="float:right" update-text="1">'+userItem.text+'</i>');



        versionMenu=dropdown.render({
            elem: '.foxnic-lang'
            ,data: items
            ,click: function(obj){
                var updateText=$('.foxnic-lang').attr("update-text");
                if(updateText==1) {
                    $('.foxnic-lang').text(obj.title);
                }
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
            success:function (r) {
                config.setLang(r.data.property);
                location.reload();
            }
        });
    }
    //
    function initLanguage(cb) {

        // 清除多语言数据
        localStorage.removeItem("language_codeLangs");
        localStorage.removeItem("language_defaultsLangs");
        localStorage.removeItem("language_timestamp");
        $.ajax({
            async: true,
            type: 'POST',
            async: true,
            url: config.base_server + '/service-system/sys-lang/query-list?lang='+USER_LANGUAGE_CODE,
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
