layui.define(['settings', 'layer','admin','form', 'table', 'util','upload',"element"],
    function (exports) {

    var upload=layui.upload;
    var element=layui.element;

    var FILE_TYPES={
        ape:"ape",ai:"ai",avi:"avi",cdr:"cdr",doc:"doc",docx:"doc",html:"html",htm:"html",ini:"ini",
        mov:"mov",mp3:"mp3",mp4:"mp4",new:"new",pdf:"pdf",ppt:"ppt",pptx:"ppt",psd:"psd",ttf:"ttf",
        txt:"txt",zip:"zip","7z":"7z",bin:"bin",cmd:"cmd",db:"db",dot:"dot",exe:"exe",java:"java",jar:"jar",
        note:"note",p12:"p12",pfx:"pfx",psd:"psd",rar:"rar",sh:"sh",wav:"wav",xls:"xls",xlsx:"xls",zip:"zip"
    };
    var template=[
        '<div class="layui-upload-unit" id="{{el}}-file-unit-{{index}}">',
        '	<img class="layui-upload-img" onclick="window.previewImage(this)" id="{{el}}-image-{{index}}" style="" src="/assets/images/no-image-92@2x.png">',
        '	<div id="{{el}}-text-{{index}}" class="layui-upload-file-name"></div>',
        '	<div class="layui-upload-button-div" style="display:none" id="{{el}}-button-div-{{index}}">',
        ' 	<button type="button" class="layui-btn layui-btn-xs layui-btn-danger layui-upload-button" id="{{el}}-delete-button-{{index}}" style="margin-left:0px"><i class="fa fa-remove"></i>&nbsp;删除</button>',
        ' 	<button type="button" class="layui-btn layui-btn-xs layui-upload-button" id="{{el}}-download-button-{{index}}" style="margin-left:0px"><i class="fa fa-remove"></i>&nbsp;下载</button>',
        //' 	<button type="button" class="layui-btn layui-btn-xs layui-upload-button" id="{{el}}-view-button-{{index}}" style="margin-left:0px"><i class="fa fa-remove"></i>&nbsp;查看</button>',
        '	</div>',
        '	<div class="layui-upload-progress" id="{{el}}-progress-container-{{index}}">',
        '		<div class="layui-progress" lay-showpercent="true" lay-filter="{{el}}-progress-{{index}}">',
        '			<div class="layui-progress-bar" lay-percent="10%"></div>',
        '		<div>',
        '	<div>',
        '<div>'
    ];
    var UPLOADS={};

    function addPreview(elId,index,fileName,fileType,result,fileId) {
        var fileList=$("#"+elId+"-file-list");
        var html=template.join("\n");
        html=html.replace(/{{el}}/g,elId);
        html=html.replace(/{{index}}/g,index);
        var preview=fileList.append(html);
        //
        var img=preview.find("#"+elId+"-image-"+index);
        img.attr('fileType',fileType);
        img.attr('fileName',fileName);
        //设置预览图
        if(fileType.startWith("image/")) {
            if(result!=null) {
                img.attr('src', result); //base64 图片
            } else {
                img.attr('src', apiurls.storage.image+"?id="+fileId); //base64 图片
            }
        } else {
            var src=getSnapshotPath(fileName);
            img.attr('src', src);
        }

        $("#"+elId+"-text-"+index).text(fileName);

        //
        if(fileId) {
            $("#"+elId+"-progress-container-"+index).hide();
        }

        //
        bindImageAction(elId,index,preview);
        return preview;
    }

    function bindData(act,elId,index,fileId) {

        //读取JSON属性
        var fileIds=$("#"+elId).attr("fileIds");
        try {
            fileIds=JSON.parse(fileIds);
        } catch (e) {
            fileIds=[];
        };

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

            $("#"+elId+"-delete-button-"+index).attr("fileId",fileId);
            $("#"+elId+"-delete-button-"+index).attr("index",index);

            $("#"+elId+"-download-button-"+index).attr("fileId",fileId);
            $("#"+elId+"-download-button-"+index).attr("index",index);

        }

    }


    function bindImageAction(elId,index,preview){
        var actionTaskId;
        var img=preview.find("#"+elId+"-image-"+index);
        img.on("mouseenter",function (){
            $("#"+elId+"-button-div-"+index).fadeTo("fast", 1.0, function(){});
        }).on("mouseleave",function (){
            actionTaskId=setTimeout(function (){
                $("#"+elId+"-button-div-"+index).fadeTo("fast", 0.0, function(){
                    $("#"+elId+"-button-div-"+index).css("display","none");
                });
            },1000);
        });
        $("#"+elId+"-button-div-"+index).on("mouseenter",function (){
            clearTimeout(actionTaskId);
        });

        $("#"+elId+"-download-button-"+index).click(function() {
            debugger
            downloadFile($(this));
        });
        $("#"+elId+"-delete-button-"+index).click(function() {
            removePreview(elId,$(this));
        });
    }

    function downloadFile(button) {
        var fileId = button.attr("fileId");
        window.open(apiurls.storage.download+"?id="+fileId+"&inline=0");
    }

    function removePreview(elId,removeButton) {
        //debugger;
        var fileId=removeButton.attr("fileId");
        var index=removeButton.attr("index");
        var task=setTimeout(function(){layer.load(2);},1000);
        admin.request(apiurls.storage.remove, {id:fileId}, function (data) {
            clearTimeout(task);
            layer.closeAll('loading');
            if (data.success) {
                layer.msg("已删除", {icon: 1, time: 500});
                $("#"+elId+"-file-unit-"+index).remove();

                bindData("remove",elId,index,fileId);

            } else {
                layer.msg(data.message, {icon: 2, time: 500});
            }
            //cfg.remove && cfg.remove(fileId,index,upload);
        }, 'POST');
    }

    function getSnapshotPath(fileName) {
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
            this.config.before=function (obj){

                obj.preview(function(index, file, result) {
                    addPreview(elId,index,file.name,file.type,result);
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
            var done=this.config.done;
            this.config.done = function(res,index, upload){
                //如果上传失败
                // debugger
                if(!res.success){
                    return layer.msg('上传失败');
                }

                setTimeout(function () {
                    $("#"+elId+"-progress-container-"+index).fadeTo("slow", 0.01, function(){
                        //$("#"+elId+"-progress-container-"+index).css("display","none");
                    });

                },500);

                bindData("add",elId,index,res.data[0].fileId);



                done && done(res,index, upload);
            };
            //
            var error=this.config.error;
            this.config.error = function(r) {
                layer.msg('附件上传失败');
                error && error(r);
            }
            //
            var inst = upload.render(this.config);
            UPLOADS[elId]=inst;
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

                }

            }, 'POST');
        }
    };

    function fillPreviews(elId,fileIds,fileInfos) {
        var infoMap={};
        for (var i = 0; i < fileInfos.length; i++) {
            infoMap[fileInfos[i].id]=fileInfos[i];
        }

        for (var i = 0; i < fileIds.length; i++) {
            var info=infoMap[fileIds[i]];

            if(info!=null) {
                addPreview(elId,i,info.fileName,info.mediaType,null,fileIds[i]);
            } else {
                addPreview(elId,i,"文件不存在","error",null,null);
            }
            bindData("add",elId,i,fileIds[i]);
        }

    }

    exports('foxnicUpload', foxnicUpload);
});