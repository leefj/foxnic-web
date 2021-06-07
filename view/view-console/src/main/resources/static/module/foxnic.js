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

 
layui.define(['settings', 'layer','admin','form', 'table', 'util','upload'], function (exports) {

    var settings = layui.settings;
    var layer = layui.layer;
    var table = layui.table;
    var admin = layui.admin;
    var upload = layui.upload;
    var form = layui.form;
  	var dict={};
  	
  	var codeLangs=null;
  	var defaultsLangs=null;
  	
    var foxnic = {
    	
    	/**
    	 * 渲染分页的表格
    	 * */
    	renderTable:function(cfg) {
 
    		cfg.url=settings.base_server + cfg.url;
    		
    		var basicConfig={
    			method: 'POST',
	    		headers:{'token':settings.getToken()},
	            request:{
	            	pageName:"pageIndex",
	            	limitName:"pageSize"
	            },
	            parseData: function(res){ //res 即为原始返回的数据
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
			
    		table.render(cfg);
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
//    		var language="confuse";
			var language="defaults";
    		var item=defaultsLangs[defaults];
    		var text=null;
    		if(!item && code) {
    			item=codeLangs[code];
    		}
    		if(item) {
    			text=item[language];
    			if(text){
    				return text;
    			}
    		}
    		
    		if(!text) {
    			text=defaults;
    		}
    		
    		admin.post("/service-system/sys-lang/insert", {code:code,defaults:defaults}, function (data) {});
    		
    		return text?text:"--";
    	},
    	
    	
    	/**
    	 * 渲染文件导入按钮
    	 * */
    	bindImportButton:function(buttonEl,url,params,callback) {
 			 url=url.replace("//","/");
    		 var uploadInst = upload.render({
			    elem: buttonEl
			    ,url: url //改成您自己的上传接口
			    ,data :params
			    ,accept:"file"
			    ,headers:{token:settings.getToken()}
			    ,before: function(obj) {
			      //预读本地文件示例，不支持ie8
			      //obj.preview(function(index, file, result){
			      //  $(imageEl).attr('src', result); //图片链接（base64）
			      //  debugger;
			      //});
			    }
			    ,done: function(res){
			      //如果上传失败
			      if(!res.success) {
			        return layer.msg(res.message);
			      }
			      //上传成功
			      //$(inputEl).val(res.data[0].fileId);
			      callback && callback(res);
			    }
			    ,error: function(){
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
    	
    	/**
    	 * 渲染单文件上传界面
    	 * */
    	renderSimpleUpload:function(inputEl,buttonEl,imageEl,callback) {
 
    		 var uploadInst = upload.render({
			    elem: buttonEl
			    ,url:  '/service-tailoring/sys-file/upload' //改成您自己的上传接口
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			        $(imageEl).attr('src', result); //图片链接（base64）
			        //debugger;
			      });
			    }
			    ,done: function(res){
			      //如果上传失败
			      if(!res.success){
			        return layer.msg('上传失败');
			      }
			      //上传成功
			      $(inputEl).val(res.data[0].fileId);
			      callback && callback(res);
			    }
			    ,error: function(){
			    	
			    	layer.msg('上传失败');
			      //演示失败状态，并实现重传
			      //var demoText = $('#demoText');
			     // demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
			     // demoText.find('.demo-reload').on('click', function(){
			     //   uploadInst.upload();
			     // });
			    }
			  });
    	
    	},
    	/**
    	 * 绑定Switch开关
    	 * */
    	bindSwitchEvent:function(layFilter,updateApiUrl,callback){
			form.on('switch('+layFilter+')', function (obj) {
	            layer.load(2);
	            admin.post(updateApiUrl, {
	                id: obj.elem.value,
	                valid: obj.elem.checked ? 1 : 0
	            }, function (data) {
	                layer.closeAll('loading');
	                if (data.success) {
	                    layer.msg(data.message, {icon: 1, time: 500});
	                    //table.reload('table-user', {});
	                } else {
	                    layer.msg(data.resp_msg, {icon: 2, time: 500});
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
    
    
    


	
    // foxnic 提供的事件
    foxnic.events = {
    	
    };
    
  
    //加载数据字典
//    admin.req('/service-tailoring/sys-dict/query-all', {}, function (data) {
//    	dict=data.data;
//    });
    
    //加载语言
    admin.post('/service-system/sys-lang/query-list', {}, function (data) {
    	data=data.data;
    	codeLangs={};
    	defaultsLangs={};
    	for (var i = 0; i < data.length; i++) {
    		codeLangs[data[i].code]=data[i];
    		defaultsLangs[data[i].defaults]=data[i];
    	}
    });
    
    //图片预览支持
    window.previewImage = function(obj) {
       		var src=obj.src;
       		//debugger
       		if(src.endWith("?id=undefined") || src.endWith("?id=null") || src.endWith("?id=")) return;
       		if(src.indexOf("no-image")!=-1) return;
       		var img = new Image();  
	        img.src = obj.src;
	        var height = img.height + 50; //获取图片高度
	        var width = img.width; //获取图片宽度
	        var imgHtml = "<img src='" + obj.src + "' />";  
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
    
 
    exports('foxnic', foxnic);
});
