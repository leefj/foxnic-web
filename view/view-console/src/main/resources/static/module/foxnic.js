String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substring(this.length-str.length)==str)
	  return true;
	else
	  return false;
	return true;
}

String.prototype.startWith=function(str) {
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substr(0,str.length)==str)
	  return true;
	else
	  return false;
	return true;
}

 
layui.define(['settings', 'layer','admin','form', 'table', 'util','upload',"xmSelect","element"], function (exports) {

    var settings = layui.settings;
    var layer = layui.layer;
    var table = layui.table;
    var admin = layui.admin;
    var upload = layui.upload;
    var form = layui.form;
    var util=layui.util;
	var xmSelect=layui.xmSelect;
	var element=layui.element;
  	var dict={};
 
  	var language=settings.getLang();
  	var codeLangs=null;
  	var defaultsLangs=null;
  	
    var foxnic = {

		renderSelectBox:function (cfg) {

			//不重复渲染
			if(xmSelect.get(cfg.el,true)!=null) return;
			if(!cfg.el.startWith("#")) cfg.el="#"+cfg.el;
			var el=$(cfg.el);
			if(!cfg.searchTips) cfg.searchTips="请输入关键字";
			var data=el.attr("data");
			var url=null;
			try {
				data=JSON.parse(data);

			} catch (e){
				url=data;
				data=null;
			}

			//本地数据渲染
			if(data!=null) {
				var opts=cfg.transform(data);
				cfg.data= opts;
			} else if(url!=null) {
				cfg.remoteSearch=true;
				cfg.filterable=true;
				cfg.remoteMethod=function (val, cb, show, pageIndex) {
					//debugger;
					var ps={searchField:cfg.searchField,searchValue:val};
					if(cfg.extraParam) {
						var ext={};
						if(typeof(cfg.extraParam) == 'function'){
							ext=cfg.extraParam();
						} else {
							ext=cfg.extraParam;
						}
						for(var key in ext) { ps[key]=ext[key];}
					}




					admin.request(url,ps,function(r) {
						var opts=[];
						if(r.success) {
							opts=cfg.transform(r.data);
						} else {
							opts=[{name:r.message,value:"-1"}];
						}
						cb(opts);
					});
				}
			}

			// cfg.on=function (data) {
			// 	debugger;
			// }

			console.log("data",data);
			console.log("opts",opts);

			return xmSelect.render(cfg);
		},
    	/**
    	 * 渲染分页的表格
    	 * */
    	renderTable:function(cfg) {
 			var tableId=cfg.elem.substring(1);
 			//debugger;
 			if(window.LAYUI_TABLE_WIDTH_CONFIG) {
				//debugger;
				var columnWidthConfig = LAYUI_TABLE_WIDTH_CONFIG[tableId];
				if (columnWidthConfig) {
					cfg.url = settings.base_server + cfg.url;
					var cols = cfg.cols[0];
					var prevFlag = 0, prev = null;
					for (var i = 0; cols && i < cols.length; i++) {
						if (cols[i].hide) continue;
						var w = columnWidthConfig[cols[i].field];
						if (w) {
							cols[i].width = w;
							console.log(cols[i].field, w);
						}
						if (cols[i].field == "row-ops") prevFlag = 1;
						if (prevFlag == 0) {
							prev = cols[i];
						}

					}
					if (prev) prev.width = null;
				}
			}

    		
    		var basicConfig={
    			method: 'POST',
	    		headers:{'token':settings.getToken()},
	            request:{
	            	pageName:"pageIndex",
	            	limitName:"pageSize"
	            },
	            parseData: function(res){ //res 即为原始返回的数据
				    //debugger;
    				return {
				      "code": res.code=="00"?0:-1, //解析接口状态
				      "msg": res.message, //解析提示文本
				      "count": res.data.totalRowCount, //解析数据长度
				      "data": res.data.list //解析数据列表
				    };
				},
	            page: true
    		};

    		//覆盖基础配置
    		for(var key in basicConfig) {
				if(cfg[key]!=null) continue;
			    cfg[key]=basicConfig[key];
			}
			
			cfg.autoSort=false;
			
			var userDone=cfg.done;
			
			function done() {
				if(cfg.footer) {
					renderFooter(this,cfg.footer);
				}
				if(userDone) userDone();
			}
			
			function renderFooter(it,footer) {

				var url=it.url;
				url=url.substring(0,url.lastIndexOf('/'));

				var div=$("#layui-table-page"+it.index);
				var buttons=[];

				if(footer.importExcel) {
					var exportExcelTemplateButton = '<button id="layui-table-page' + it.index + '-footer-download-excel-template"  type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i class="fa fa-download"></i> 下载模版</button>';
					buttons.push(exportExcelTemplateButton);
					var importExcelButton = '<button id="layui-table-page' + it.index + '-footer-import-excel"  type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i class="fa fa-cloud-upload"></i> 导入数据</button>&nbsp;&nbsp;';
					buttons.push(importExcelButton);
				}

				if(footer.exportExcel) {
					var exportExcelButton = '<button id="layui-table-page' + it.index + '-footer-download-excel"  type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i class="fa fa-cloud-download"></i>  导出数据</button>';
					buttons.push(exportExcelButton);
				}

            	div.append("<div style='float:right'>"+buttons.join("")+"</div>")


				if(footer.importExcel) {
					$('#layui-table-page' + it.index + '-footer-download-excel-template').click(function () {
						foxnic.submit(url + "/export-excel-template", it.where);
					});
					var ps=footer.importExcel.params;
					if(ps && (typeof ps === "function")) {
						ps=ps();
					}
					var cb=footer.importExcel.callback;
					if(!ps) ps={};
					foxnic.bindImportButton($('#layui-table-page' + it.index + '-footer-import-excel'),url+"/import-excel",ps,function(r) {
						 cb && cb(r);
					});
					// $('#layui-table-page' + it.index + '-footer-import-excel').click(function () {
					// 	//foxnic.submit(url + "/export-excel-template", it.where);
					// 	alert("打开文件")
					// });
				}
				if(footer.exportExcel) {
					$('#layui-table-page' + it.index + '-footer-download-excel').click(function () {
						foxnic.submit(url + "/export-excel", it.where);
					});
				}
 
			}
			
			cfg.done=done;
			if(!table.instance) table.instance=[];
			var inst=table.render(cfg);
			table.instance.push(inst)
    		return inst;
    	},
    	
    	/**
    	 * 字典值转换成标签
    	 * */
    	transDict:function(dictCode,itemCode){
    		var map=dict[dictCode];
    		var label=null;
    		if(map) label=map[itemCode];
    		return label==null?"--":label;
    	},
    	
    	translate:function(defaults,code) {
 			//debugger
    		var item=defaultsLangs[defaults];
    		var text=null;
    		if(!item && code) {
    			item=codeLangs[code];
    		}
    		if(item) {
    			text=item[language];
    			if(text && text!=":ns;"){
    				return text;
    			}
    		}
    		
    		if(!text || text==":ns;") {
    			text=defaults;
    		}
    		
    		//如果条目不存在，则插入
    		if(!item) {
	    		admin.request("/service-system/sys-lang/insert", {code:code,defaults:defaults}, function (data) {
					localStorage.removeItem("language_timestamp");
				});
    		}
    		
    		return text?text:"--";
    	},
    	
    	
    	/**
    	 * 渲染文件导入按钮
    	 * */
    	bindImportButton:function(buttonEl,url,params,callback) {
 			 url=url.replace("//","/");
			 url=url.replace("http:/","http://");
			 url=url.replace("https:/","https://");
			 var task=null;
    		 var uploadInst = upload.render({
			    elem: buttonEl
			    ,url: url //改成您自己的上传接口
			    ,data :params
			    ,accept:"file"
			    ,headers:{token:settings.getToken()}
			    ,before: function(obj) {
			    	task=setTimeout(function(){layer.load(2);},500);
			      //预读本地文件示例，不支持ie8
			      //obj.preview(function(index, file, result){
			      //  $(imageEl).attr('src', result); //图片链接（base64）
			      //  debugger;
			      //});
			    }
			    ,done: function(res){
			    	clearTimeout(task);
					layer.closeAll('loading');
			      //如果上传失败
			      if(!res.success) {
			        return layer.msg(res.message);
			      }
			      //上传成功
			      //$(inputEl).val(res.data[0].fileId);
			      callback && callback(res);
			    }
			    ,error: function(){
					clearTimeout(task);
					layer.closeAll('loading');
			    	layer.msg('上传失败');
			      //演示失败状态，并实现重传
			      //var demoText = $('#demoText');
			      //demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			      //demoText.find('.demo-reload').on('click', function(){
			      //  uploadInst.upload();
			      //});
			    }
			  });
    	
    	},
    	
    	dateFormat(t,f) {
    		if(!t) return "";
    		return util.toDateString(t,f);
    	},

		formUploads:{},

		fillFormUpload:function (el,fileIds) {
			var inst=this.formUploads[el];
			//debugger;
			inst.fill(fileIds);
		},
    	/**
    	 * 渲染单文件上传界面
    	 * */
    	renderFormUpload:function(cfg) {
			var me=this;
			var el=cfg.el;
    		if(this.formUploads[el]) return;
			if(!cfg.count) count=1;

			var template=[
				'<div class="layui-upload-unit" id="{{el}}-file-unit-{{index}}">',
				'	<img class="layui-upload-img" onclick="window.previewImage(this)" id="{{el}}-image-{{index}}" style="" src="/assets/images/no-image-92@2x.png">',
				'	<div id="{{el}}-text-{{index}}" class="layui-upload-file-name"></div>',
				' 	<a class="layui-upload-delete-button" id="{{el}}-delete-button-{{index}}"><i class="fa fa-remove"></i></a>',
				'	<div class="layui-upload-progress" id="{{el}}-progress-container-{{index}}">',
				'		<div class="layui-progress" lay-showpercent="true" lay-filter="{{el}}-progress-{{index}}">',
				'			<div class="layui-progress-bar" lay-percent="10%"></div>',
				'		<div>',
				'	<div>',
				'<div>'
			];

			var fileList=$("#"+el+"-file-list");

			function addPreview(index) {
				var html=template.join("\n");
				html=html.replace(/{{el}}/g,el);
				html=html.replace(/{{index}}/g,index);
				var preview=fileList.append(html);
				return preview;
			}

			function removePreview(removeButton) {
				//debugger;
				var fileId=removeButton.attr("fileId");
				var index=removeButton.attr("index");
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(apiurls.storage.remove, {id:fileId}, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if (data.success) {
						layer.msg("已删除", {icon: 1, time: 500});
						$("#"+el+"-file-unit-"+index).remove();

						var fileIds=$("#"+el).attr("fileIds");
						try {
							fileIds=JSON.parse(fileIds);
						} catch (e) {
							fileIds=[];
						};
						var newIds=[];
						for (var i = 0; i < fileIds.length; i++) {
							if(fileIds[i]==fileId) continue;
							newIds.push(fileIds[i]);
						}
						$("#"+el).attr("fileIds",JSON.stringify(newIds));
						$("#"+el).val(newIds.join(","));

					} else {
						layer.msg(data.message, {icon: 2, time: 500});
					}
					cfg.remove && cfg.remove(fileId,index,upload);
				}, 'POST');
			}

			//var currIndex=0;
			var uploadInst = upload.render({
				elem: "#"+el+"-button",
				url:  apiurls.storage.upload,
				before: function(obj) {
					//预读本地文件示例，不支持ie8
					obj.preview(function(index, file, result) {

						var preview=addPreview(index);
						var img=preview.find("#"+el+"-image-"+index);

						img.attr('src', result); //base64 图片
						$("#"+el+"-text-"+index).text(file.name);

					});
				},
				progress: function(n, elem, res, index) {
					element.progress(el+'-progress-'+ index, n + '%' ); //进度条
				},
				done: function(res,index, upload){
					//如果上传失败
					if(!res.success){
						return layer.msg('上传失败');
					}

					setTimeout(function () {
						$("#"+el+"-progress-container-"+index).fadeTo("slow", 0.01, function(){
							$("#"+el+"-delete-button-"+index).fadeTo("slow", 0.8, function(){});
						});

					},500);

					var fileIds=$("#"+el).attr("fileIds");
					try {
						fileIds=JSON.parse(fileIds);
					} catch (e) {
						fileIds=[];
					};
					fileIds.push(res.data[0].fileId);
					$("#"+el).attr("fileIds",JSON.stringify(fileIds))

					// //上传成功
					$("#"+el).val(fileIds.join(","));
					//处理删除按钮
					$("#"+el+"-delete-button-"+index).attr("fileId",res.data[0].fileId);
					$("#"+el+"-delete-button-"+index).attr("index",index);

					$("#"+el+"-delete-button-"+index).click(function() {
						removePreview($(this));
					});
					cfg.upload && cfg.upload(res,index, upload);
				},
				error: function() {
					layer.msg('上传失败');
				}
			});

			//填充
			uploadInst.fill=function (value) {
				var fileIds=value.split(",");
				$("#"+el).attr("fileIds",JSON.stringify(fileIds));
				//debugger;
				for (var i = 0; i < fileIds.length; i++) {
					var preview=addPreview(i);
					var img=preview.find("#"+el+"-image-"+i);
					img.attr('src', apiurls.storage.download+"?id="+fileIds[i]); //base64 图片
					$("#"+el+"-progress-container-"+i).css("display","none");
					$("#"+el+"-delete-button-"+i).attr("fileId",fileIds[i]);
					$("#"+el+"-delete-button-"+i).attr("index",i);
					$("#"+el+"-delete-button-"+i).fadeTo("slow", 0.8, function(){});
					$("#"+el+"-delete-button-"+i).click(function() {
						removePreview($(this));
					});
				}

			}


    		this.formUploads[el]=uploadInst;
    	
    	},
    	/**
    	 * 绑定Switch开关
    	 * */
    	bindSwitchEvent:function(layFilter,updateApiUrl,idProp,logicProp,callback){
			form.on('switch('+layFilter+')', function (obj) {
	            layer.load(2);
	            var data={};
	            data[idProp]=obj.elem.value;
	            data[logicProp]=obj.elem.checked ? 1 : 0;
	            admin.request(updateApiUrl, data, function (data) {
	                layer.closeAll('loading');
	                if (data.success) {
	                    layer.msg(data.message, {icon: 1, time: 500});
	                } else {
	                    layer.msg(data.message, {icon: 2, time: 500});
	                    $(obj.elem).prop('checked', !obj.elem.checked);
	                    form.render('checkbox');
	                }
	                callback && callback(data);
	            }, 'POST');
	        });
    	},
    	getQueryVariable:function (variable)
		{
		       var query = window.location.search.substring(1);
		       var vars = query.split("&");
		       for (var i=0;i<vars.length;i++) {
		               var pair = vars[i].split("=");
		               if(pair[0] == variable){return pair[1];}
		       }
		       return(false);
		},
		//表单提交
		submit: function (url,params) {

			url=url.replace("//","/");
			url=url.replace("http:/","http://");
			url=url.replace("https:/","https://");

        	var target="t-"+(new Date()).getTime();
        	var $ifr=$("<iframe id='"+target+"' name='"+target+"' style='display:none'></iframe>")
        	$("body").append($ifr);
			// 构造隐藏的form表单
			var $form = $("<form style='display:none' method='post' target='"+target+"' action='"+url+"'></form>");
			$("body").append($form);
			//添加参数
			if(!params) params={};
			for(var p in params) {
				var $input = $("<input name='"+p+"' type='text' value='"+params[p]+"'></input>");
				$form.append($input);
			}
			// 提交表单
			$form.submit();
        	//移除元素
			setTimeout(function(){
				$form.remove();
				$ifr.remove();
			},1000);
        }
    };

	var mouseDownTime;
	$(document).on("mousedown",function (e) {
		mouseDownTime=(new Date()).getTime();
	});
	/**
	 * 监听layui table 的列宽拖动时间
	 * */
	$(document).on("mouseup",function (e) {
		//console.log(1)
		var t=(new Date()).getTime();
		t=t-mouseDownTime;
		//console.log("click",t);
		mouseDownTime=null;
		if(t<500) return;
		//console.log(2)
		setTimeout(function (){

			var tar=$(e.target);
			//debugger
			if(tar.parent().length==0) return;
			if(tar.parent()[0].nodeName!="TH") return;
			var cls=tar.attr("class");
			if(cls==null) return;
			//console.log(cls,t);
			var pars=tar.parents();
			var layFilter=null;
			var tableIndex=-1;
			for (var i = 0; i < pars.length; i++) {
				var p=$(pars[i]);
				layFilter=p.attr("lay-filter");
				if( layFilter && layFilter.startWith("LAY-table-")) {
					tableIndex=layFilter.split("-")[2];
					break;
				}
				//console.log("lay-filter",layFilter);
			}
			if(tableIndex==-1) return;
			//console.log("tableIndex",tableIndex);
			var inst=table.instance[tableIndex-1];
			var tableId=inst.config.elem[0].id;
			//console.log("inst",inst);
			var cols=inst.config.cols[0];
			//debugger
			var ws={};
			if(cls.indexOf("layui-table-cell")==-1 || cls.indexOf("laytable-cell-")==-1) return;
			var ths=$("th .layui-table-cell");
			//console.log(ths.length);
			for (var i = 0; i < ths.length; i++) {
				var th=$(ths[i]);
				if(cols[i] && cols[i].field && !cols[i].hide) {
					ws[cols[i].field] = th[0].clientWidth;
				}
			}

			var loc=location.href;
			loc=loc.substr(loc.indexOf("//")+2);
			loc=loc.substr(loc.indexOf("/"));
			console.log("save table",tableId,ws);

			admin.request("/service-system/sys-db-cache/save", { id: loc+"#"+tableId , value: JSON.stringify(ws),area:loc,catalog:"layui-table-column-width",ownerType:"user" }, function (data) {});


		},100);

	});

	
    // foxnic 提供的事件
    foxnic.events = {
    	
    };
    
  
    //加载数据字典
//    admin.req('/service-tailoring/sys-dict/query-all', {}, function (data) {
//    	dict=data.data;
//    });
    
    var languageTimestamp=localStorage.getItem("language_timestamp");
    
    //加载语言
    
    if(languageTimestamp) {
    	
    	var expire=((new Date()).getTime()-languageTimestamp)/1000;
    	
    	if(expire < 60 * 15)
    	{
		    codeLangs=localStorage.getItem("language_codeLangs");
		    if(codeLangs && codeLangs.length>2) {
		    	codeLangs=JSON.parse(codeLangs);
		    }
		    
		    defaultsLangs=localStorage.getItem("language_defaultsLangs");
		    if(defaultsLangs && defaultsLangs.length>2) {
		    	defaultsLangs=JSON.parse(defaultsLangs);
		    }
    	}
	    
    }
    
    if(defaultsLangs==null || codeLangs==null) {
	    admin.request('/service-system/sys-lang/query-list', {}, function (data) {
	    	data=data.data;
	    	codeLangs={};
	    	defaultsLangs={};
	    	for (var i = 0; i < data.length; i++) {
	    		codeLangs[data[i].code]=data[i];
	    		defaultsLangs[data[i].defaults]=data[i];
	    	}
	    	localStorage.setItem("language_codeLangs",JSON.stringify(codeLangs));
	    	localStorage.setItem("language_defaultsLangs",JSON.stringify(defaultsLangs));
	    	localStorage.setItem("language_timestamp",(new Date()).getTime());
	    });
    }
    
    //图片预览支持
    window.previewImage = function(obj) {
    		if(window!=top) {
    			top.previewImage(obj);
    			return;
			}
       		var src=obj.src;
       		//debugger
       		if(src.endWith("?id=undefined") || src.endWith("?id=null") || src.endWith("?id=")) return;
       		if(src.indexOf("no-image")!=-1) return;
       		var img = new Image();  
	        img.src = obj.src;
			img.onload = function() {
				//debugger

				var fullHeight=$(window).height();
				var fullWidth=$(window).width();
				var ih=img.height+ 50+2
				var iw=img.width;
				if(ih>fullHeight) {
					ih=(fullHeight-50-2)*0.9;
					iw=(img.width/img.height)*ih;
				}
				if(iw>fullWidth) {
					iw=fullWidth*0.9;
					ih=(img.height/img.width)*iw;
				}

				var height = ih + 50+2; //获取图片高度
				var width = iw; //获取图片宽度


				var imgHtml = "<img src='" + obj.src + "' style='width: "+iw+"px;height: "+ih+"px' />";
				//弹出层
				layer.open({
					type: 1,
					shade: 0.8,
					offset: 'auto',
					area: [width + 'px',height+'px'],
					shadeClose:true,//点击外围关闭弹窗
					scrollbar: false,//不现实滚动条
					title: "图片预览", //不显示标题
					content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
					cancel: function () {
						//layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
					}
				});
			}

       }
    
 
    exports('foxnic', foxnic);
});



