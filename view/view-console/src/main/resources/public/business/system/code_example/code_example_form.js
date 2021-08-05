/**
 * 代码生成示例 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-05 17:29:20
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-system/sys-code-example";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定提交事件
		bindButtonEvent();

	}
	
	function adjustPopup() {
		setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var area=admin.changePopupArea(null,bodyHeight);
			admin.putTempData('sys-code-example-form-area', area);
			window.adjustPopup=adjustPopup;
			if(area.tooHeigh) {
				debugger
				var windowHeight=area.iframeHeight;
				var footerHeight=$(".model-form-footer").height();
				var finalHeight=windowHeight-footerHeight-16;
				//console.log("windowHeight="+windowHeight+',bodyHeight='+bodyHeight+",footerHeight="+footerHeight+",finalHeight="+finalHeight);
				$(".form-container").css("display","");
				$(".form-container").css("overflow-y","scroll");
				$(".form-container").css("height",finalHeight+"px");
			}
		},250);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
	    //渲染图片字段
		foxup.render({
			el:"imageId",
			maxFileCount: 1,
			displayFileName: false,
			accept: "image",
			acceptMime:'image/*',
			exts:'png|jpg|bmp|gif|jpeg',
			afterPreview:function(elId,index,fileId,upload){
				adjustPopup();
			},
			afterUpload:function (result,index,upload) {
				console.log("文件上传后回调")
			},
			beforeRemove:function (elId,fileId,index,upload) {
				console.log("文件删除前回调");
				return true;
			},
			afterRemove:function (elId,fileId,index,upload) {
				adjustPopup();
			}
	    });
		//渲染 selectEnum 下拉字段
		fox.renderSelectBox({
			el: "selectEnum",
			radio: true,
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 selectDict 下拉字段
		fox.renderSelectBox({
			el: "selectDict",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 selectApi 下拉字段
		fox.renderSelectBox({
			el: "selectApi",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "url)", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].url,value:data[i].id});
				}
				return opts;
			}
		});
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('sys-code-example-form-data');
		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);

			//设置  图片上传  显示附件
		    if($("#imageId").val()) {
				foxup.fill("imageId",$("#imageId").val());
		    }

			//设置 选择框(枚举) 下拉框选中值
			var selectEnumSelect=xmSelect.get("#selectEnum",true);
			var selectEnumOpionts=[];
			console.error("代码生成时未指定  选择框(枚举)(selectEnum) 的 fillBy 属性 , 无法填充表单数值");
			selectEnumSelect.setValue(selectEnumOpionts);
			//设置 选择框(字典) 下拉框选中值
			var selectDictSelect=xmSelect.get("#selectDict",true);
			var selectDictOpionts=[];
			console.error("代码生成时未指定  选择框(字典)(selectDict) 的 fillBy 属性 , 无法填充表单数值");
			selectDictSelect.setValue(selectDictOpionts);
			//设置 选择框(查询) 下拉框选中值
			var selectApiSelect=xmSelect.get("#selectApi",true);
			var selectApiOpionts=[];
			console.error("代码生成时未指定  选择框(查询)(selectApi) 的 fillBy 属性 , 无法填充表单数值");
			selectApiSelect.setValue(selectApiOpionts);

	     	fm.attr('method', 'POST');
	     	renderFormFields();
		}
		
		//渐显效果
		fm.css("opacity","0.0");
        fm.css("display","");
        setTimeout(function (){
            fm.animate({
                opacity:'1.0'
            },100);
        },1);
        
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
	    	

			//处理 逻辑值 默认值
		    if(!data.field.valid) data.field.valid=0;


			//获取 选择框(枚举) 下拉框的值
			data.field["selectEnum"]=xmSelect.get("#selectEnum",true).getValue("value");
			if(data.field["selectEnum"] && data.field["selectEnum"].length>0) {
				data.field["selectEnum"]=data.field["selectEnum"][0];
			}
			//获取 选择框(字典) 下拉框的值
			data.field["selectDict"]=xmSelect.get("#selectDict",true).getValue("value");
			if(data.field["selectDict"] && data.field["selectDict"].length>0) {
				data.field["selectDict"]=data.field["selectDict"][0];
			}
			//获取 选择框(查询) 下拉框的值
			data.field["selectApi"]=xmSelect.get("#selectApi",true).getValue("value");
			if(data.field["selectApi"] && data.field["selectApi"].length>0) {
				data.field["selectApi"]=data.field["selectApi"][0];
			}

	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
	                admin.finishPopupCenter();
	            } else {
	                layer.msg(data.message, {icon: 2, time: 1000});
	            }
	        }, "POST");
	        
	        return false;
	    });
	    
	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});
	    
    }

}

layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select',
	foxnicUpload: 'upload/foxnic-upload'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload'],function() {
	(new FormPage()).init(layui);
});