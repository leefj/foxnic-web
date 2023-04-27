layui.define(['settings', 'layer','admin','form', 'table', 'util','upload',"element"],
    function (exports) {

    var upload=layui.upload;
    var element=layui.element;

    var FILE_TYPES={
        ape:"ape",ai:"ai",avi:"avi",cdr:"cdr",doc:"doc",docx:"doc",html:"html",htm:"html",ini:"ini",
        mov:"mov",mp3:"mp3",mp4:"mp4",new:"new",pdf:"pdf",ppt:"ppt",pptx:"ppt",psd:"psd",ttf:"ttf",
        txt:"txt",zip:"zip","7z":"7z",bin:"bin",cmd:"cmd",db:"db",dot:"dot",exe:"exe",java:"java",jar:"jar",
        note:"note",p12:"p12",pfx:"pfx",psd:"psd",rar:"rar",sh:"sh",wav:"wav",xls:"xls",xlsx:"xls",zip:"zip",bpm:"ini",bpmn:"ini"
    };
    var template=[
        '<div class="layui-upload-unit" id="{{el}}-file-unit-{{index}}" style="{{el-height}}">',
        '<div id="{{el}}-file-unit-content-{{index}}">',
        '	<img class="layui-upload-img" onclick="window.previewImage(this)" can-preview="{{canPreview}}" id="{{el}}-image-{{index}}" style="" src="/assets/images/no-image-92@2x.png">',
        '	<div id="{{el}}-text-{{index}}" class="layui-upload-file-name"></div>',
        '	<div class="layui-upload-button-div" style="display:none" id="{{el}}-button-div-{{index}}">',
        ' 	<button type="button" class="layui-btn layui-btn-xs layui-btn-danger layui-upload-button foxup-delete-button" id="{{el}}-delete-button-{{index}}" style="margin-left:0px"><i class="fa fa-remove"></i>&nbsp;删除</button>',
        ' 	<button type="button" class="layui-btn layui-btn-xs layui-upload-button" id="{{el}}-download-button-{{index}}" style="margin-left:0px"><i class="fa fa-download"></i>&nbsp;下载</button>',
        //' 	<button type="button" class="layui-btn layui-btn-xs layui-upload-button" id="{{el}}-view-button-{{index}}" style="margin-left:0px"><i class="fa fa-remove"></i>&nbsp;查看</button>',
        '	</div>',
        '	<div class="layui-upload-progress" id="{{el}}-progress-container-{{index}}">',
        '		<div class="layui-progress" lay-showpercent="true" lay-filter="{{el}}-progress-{{index}}">',
        '			<div class="layui-progress-bar" lay-percent="10%"></div>',
        '		<div>',
        '	<div>',
        '</div>',
        '<div>'
    ];
    var UPLOADS={};

    function addPreview(elId,index,fileName,fileType,result,fileId,exists) {
        // 按扩展名识别文件类型
        if(fileName.toLowerCase().endsWith(".bpm") || fileName.toLowerCase().endsWith(".bpmn")) fileType="workflow/bpm";
        //
        var inst=UPLOADS[elId];
        var displayFileName=inst.config.displayFileName;
        var fileList=$("#"+elId+"-file-list");
        var html=template.join("\n");
        html=html.replace(/{{el}}/g,elId);
        if(displayFileName) {
            html = html.replace(/{{el-height}}/g, "height:110px");
        }
        html=html.replace(/{{index}}/g,index);
        if(fileType=="png") {
            html = html.replace(/{{canPreview}}/g, "yes");
        } else {
            html = html.replace(/{{canPreview}}/g, "no");
        }
        var preview=fileList.append(html);
        //debugger;

        if(inst.config.maxFileCount==1) {
            $("#"+elId+"-file-unit-"+index).css("margin-bottom","0px");
            preview.css("margin","0px");
        }
        if(displayFileName===false) {
            preview.find("#"+elId+"-text-"+index).hide();
        }
        //
        var img=preview.find("#"+elId+"-image-"+index);
        img.attr('fileType',fileType);
        img.attr('fileName',fileName);
        var afterImageLoad=inst.config.afterImageLoad;
        img.css("opacity","0.0");
        img.on("load",function (){
            img.animate({opacity:"1.0"},250);
            afterImageLoad && afterImageLoad(elId,index,fileId,inst);
        })
        if(!fileType) {
            fileType="image/png";
        }
        //设置预览图
        if(fileType.startWith("image/")) {
            // debugger;
            if(result!=null) {
                img.attr('src', result); //base64 图片
            } else {
                if(exists) {
                    img.attr('src', apiurls.storage.image + "?id=" + fileId); //base64 图片
                } else {
                    var src=getSnapshotPath(fileName,false);
                    img.attr('src', src);
                }
            }
        } else {
            var src=getSnapshotPath(fileName,exists);
            img.attr('src', src);
        }

        $("#"+elId+"-text-"+index).text(fileName);

        //
        if(fileId) {
            $("#"+elId+"-progress-container-"+index).hide();
        }

        //
        bindImageAction(elId,index,preview);

        // // setTimeout(function () {
        //     if(window.adjustPopup) {
        //         window.adjustPopup();
        //     }
        // },500);
        inst.config.afterPreview && inst.config.afterPreview(elId,index,fileId,inst,fileName,fileType);


        return preview;
    }

    function getFileIds(elId) {
        //读取JSON属性
        var fileIds=$("#"+elId).attr("fileIds");
        try {
            fileIds=JSON.parse(fileIds);
        } catch (e) {
            fileIds=[];
        };
        return fileIds;
    }

    function bindData(act,elId,index,fileId) {

        //读取JSON属性
        var fileIds=getFileIds(elId);

        if(act=="add") {
            fileIds.push(fileId);
        }
        if(act=="remove") {
            var newIds=[];
            for (var i = 0; i < fileIds.length; i++) {
                if(fileIds[i]==fileId) continue;
                newIds.push(fileIds[i]);
            }
            fileIds=newIds;
        }
        //设置JSON属性
        $("#"+elId).attr("fileIds",JSON.stringify(fileIds));
        //设置表单域值
        $("#"+elId).val(fileIds.join(","));

        //处理删除按钮
        if(act=="add") {

            $("#"+elId+"-file-list").attr("fileId",fileId);
            $("#"+elId+"-file-list").attr("index",index);

            $("#"+elId+"-delete-button-"+index).attr("fileId",fileId);
            $("#"+elId+"-delete-button-"+index).attr("index",index);

            $("#"+elId+"-download-button-"+index).attr("fileId",fileId);
            $("#"+elId+"-download-button-"+index).attr("index",index);

        }

    }


    function bindImageAction(elId,index,preview){
        var actionTaskId;
        var img=preview.find("#"+elId+"-image-"+index);
        var buttonDiv=$("#"+elId+"-button-div-"+index);
        var contentDiv=$("#"+elId+"-file-unit-content-"+index);
        contentDiv.on("mouseenter",function (){
            // 当鼠标进入图片
            var cfg=UPLOADS[elId].config;
            //if(cfg.disabled) return;
            clearTimeout(actionTaskId);
            $("#"+elId+"-button-div-"+index).stop();
            $("#"+elId+"-button-div-"+index).fadeTo("fast", 1.0, function(){});
            // 无论是否被 disable 下载始终是被允许的
            $("#"+elId+"-download-button-"+index).removeAttr("disabled");
            $("#"+elId+"-download-button-"+index).removeClass("layui-btn-disabled");
        }).on("mouseleave",function (){
            var cfg=UPLOADS[elId].config;
            //if(cfg.disabled) return;
            $("#"+elId+"-button-div-"+index).stop();
            actionTaskId=setTimeout(function (){
                $("#"+elId+"-button-div-"+index).fadeTo("fast", 0.0, function(){
                    $("#"+elId+"-button-div-"+index).css("display","none");
                });
            },100);
        });

        // buttonDiv.on("mouseenter",function (){
        //     //$("#"+elId+"-button-div-"+index).stop(true,true);
        //     clearTimeout(actionTaskId);
        // });

        $("#"+elId+"-download-button-"+index).click(function() {
            //debugger
            downloadFile($(this));
        });
        $("#"+elId+"-delete-button-"+index).click(function() {
            var fileId=$(this).attr("fileId");
            var index=$(this).attr("index");
            removePreview(elId,fileId,index,false);
        });
    }

    function downloadFile(button) {
        var fileId = button.attr("fileId");
        window.open(apiurls.storage.download+"?id="+fileId+"&inline=0");
    }

    function removePreview(elId,fileId,index,sclince) {
        var beforeRemove=UPLOADS[elId].config.beforeRemove;
        var afterRemove=UPLOADS[elId].config.afterRemove;
        if(!sclince) {
            beforeRemove=beforeRemove && beforeRemove(elId,fileId,index,UPLOADS[elId]);
            if(beforeRemove===false) return;
        }
        //debugger;
        //var fileId=removeButton.attr("fileId");
        //var index=removeButton.attr("index");
        var task=setTimeout(function(){layer.load(2);},1000);
        admin.request(apiurls.storage.remove, {id:fileId}, function (data) {
            clearTimeout(task);
            layer.closeAll('loading');
            if (data.success) {
                if(!sclince) {
                    layer.msg("已删除", {icon: 1, time: 500});
                }
                $("#"+elId+"-file-unit-"+index).remove();

                bindData("remove",elId,index,fileId);

            } else {
                if(!sclince) {
                    layer.msg(data.message, {icon: 2, time: 500});
                }
            }
            afterRemove && afterRemove(elId,fileId,index,UPLOADS[elId]);
        }, 'POST');
    }

    function getSnapshotPath(fileName,exists) {
        // debugger
        if(!exists) {
            return "/module/upload/filetype/error.png";
        }
        var ext=fileName.split(".");
        if(ext.length>1) {
            ext = ext[ext.length - 1];
        } else {
            ext=null;
        }
        if(ext) {
            ext = FILE_TYPES[ext];
        }
        if(ext){
            ext="/module/upload/filetype/"+ext+".png";
        } else {
            ext="/module/upload/filetype/error.png";
        }
        return ext;
    }


    var foxnicUpload = {
        config:null,
        render:function (cfg) {
            var me=this;
            this.config=cfg;
            var elId=this.config.el;
            if(UPLOADS[elId]) return;
            if(!this.config.count) count=1;
            if(!this.config.url) this.config.url =apiurls.storage.upload;
            this.config.elem = "#"+elId+"-button",
            //
            this.config.accept="file";
            this.config.multiple=true;
            //
            var before=this.config.before;

            if(this.config.disable) {
                $(this.config.elem).remove();
            }

            this.config.before=function (obj){

                obj.preview(function(index, file, result) {
                    // debugger
                    var cfg=UPLOADS[elId].config;
                    //如果只有一个，就替换
                    var fs=$("#"+elId+"-file-list").children();
                    // debugger;
                    if(cfg.maxFileCount==1) {
                        var idx=$("#"+elId+"-file-list").attr("index");
                        var fid=$("#"+elId+"-file-list").attr("fileId");
                        removePreview(elId,fid,idx,true);
                        addPreview(elId,index,file.name,file.type,result,null,true);
                    } else if(cfg.maxFileCount>1 && fs.length>=cfg.maxFileCount) {
                        // var idx=$("#"+elId+"-file-list").attr("index");
                        // var fid=$("#"+elId+"-file-list").attr("fileId");
                        // removePreview(elId,fid,idx,true);
                        layer.msg("抱歉，最多上传 "+cfg.maxFileCount+" 个文件");
                    }
                    else {
                        addPreview(elId,index,file.name,file.type,result,null,true);
                    }
                });
                //
                before && before(obj);
            };
            //
            var progress=this.config.progress;
            this.config.progress = function(n, elem, res, index) {
                element.progress(elId+'-progress-'+ index, n + '%' ); //进度条
                progress && progress(n, elem, res, index);
            };
            //
            var afterUpload=this.config.afterUpload;
            this.config.done = function(res,index, upload){
                //如果上传失败
                // debugger


                setTimeout(function () {

                    $("#"+elId+"-progress-container-"+index).fadeTo("slow", 0.01, function(){
                        //$("#"+elId+"-progress-container-"+index).css("display","none");
                    });

                },500);

                if(!res.success) {
                    return layer.msg('上传失败');
                }

                bindData("add",elId,index,res.data[0].fileId);

                afterUpload && afterUpload(elId,res,index,upload);
            };
            //
            var error=this.config.error;
            this.config.error = function(r) {
                top.layer.msg('附件上传失败');
                error && error(r);
            }
            //
            var inst = upload.render(this.config);
            UPLOADS[elId]=inst;

            if(this.config.disable) {
               this.disable(elId);
            }

        },
        disable:function (elId){
            var cfg=UPLOADS[elId].config;
            cfg.disabled=true;
            // debugger
            $("#"+elId+"-button").remove();
            var fileList=$("#"+elId+"-file-list");
            fileList.css("margin","0px");
            var deleteButtons=fileList.find(".foxup-delete-button");
            deleteButtons.remove();
            var buttonDivs=fileList.find(".layui-upload-button-div");
            buttonDivs.css("margin-top","-58px");
        },
        fill:function (elId,fileIds) {
            //debugger;
            fileIds=fileIds.split(",");
            // $("#"+elId).attr("fileIds",JSON.stringify(fileIds));
            // $("#"+elId).val(fileIds.join(","));
            admin.request(apiurls.storage.getByIds, {ids:fileIds}, function (data) {
                if (data.success) {
                    data=data.data;
                    fillPreviews(elId,fileIds,data);
                } else {
                    //TODO 待实现
                }

            }, 'POST',false);
        }
    };

    function fillPreviews(elId,fileIds,fileInfos) {
        var infoMap={};
        for (var i = 0; i < fileInfos.length; i++) {
            infoMap[fileInfos[i].id]=fileInfos[i];
        }

        for (var i = 0; i < fileIds.length; i++) {
            var info=infoMap[fileIds[i]];
            //debugger;
            if(info!=null) {
                addPreview(elId,i,info.fileName,info.mediaType,null,fileIds[i],info.exists);
            } else {
                addPreview(elId,i,"文件不存在","error",null,null,false);
            }
            bindData("add",elId,i,fileIds[i]);
        }

    }

    exports('foxnicUpload', foxnicUpload);
});
