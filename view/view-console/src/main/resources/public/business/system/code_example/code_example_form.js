/**
 * 代码生成示例 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-13 21:51:28
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-system/sys-code-example";

	const disableCreateNew=false;
	const disableModify=false;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定提交事件
		bindButtonEvent();

	}

	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup() {
		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			var area=admin.changePopupArea(null,bodyHeight+footerHeight);
			admin.putTempData('sys-code-example-form-area', area);
			window.adjustPopup=adjustPopup;
			if(area.tooHeigh) {
				var windowHeight=area.iframeHeight;
				var finalHeight=windowHeight-footerHeight-16;
				//console.log("windowHeight="+windowHeight+',bodyHeight='+bodyHeight+",footerHeight="+footerHeight+",finalHeight="+finalHeight);
				$(".form-container").css("display","");
				$(".form-container").css("overflow-y","scroll");
				$(".form-container").css("height",finalHeight+"px");
				$(".form-container").attr("scroll","yes");
			}
		},250);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		fox.renderFormInputs(form);
	   
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
	    //渲染图片字段
		foxup.render({
			el:"fileIds",
			maxFileCount: 4,
			displayFileName: true,
			accept: "file",
			exts:'doc|zip|xlsx|rar|docx|txt|svg',
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
			radio: false,
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
		//渲染 resourceId 下拉字段
		fox.renderSelectBox({
			el: "resourceId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "url", //请自行调整用于搜索的字段名称
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
		laydate.render({
			elem: '#birthday',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});
		laydate.render({
			elem: '#workTime',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});
		//渲染 roleIds 下拉字段
		fox.renderSelectBox({
			el: "roleIds",
			radio: false,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].name,value:data[i].id});
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

			//设置 图片上传 显示附件
		    if($("#imageId").val()) {
				foxup.fill("imageId",$("#imageId").val());
		    } else {
				adjustPopup();
			}
			//设置 多文件上传 显示附件
		    if($("#fileIds").val()) {
				foxup.fill("fileIds",$("#fileIds").val());
		    } else {
				adjustPopup();
			}


			//设置 复选框(枚举) 显示复选框勾选
		    if(formData["checkEnum"]) {
				fox.setCheckedValue("checkEnum",formData["checkEnum"]);
		    }
			//设置 复选框(字典) 显示复选框勾选
		    if(formData["checkDict"]) {
				fox.setCheckedValue("checkDict",formData["checkDict"]);
		    }


			//设置  选择框(枚举) 设置下拉框勾选
			fox.setSelectValue4Enum("#selectEnum",formData.selectEnum,SELECT_SELECTENUM_DATA);
			//设置  选择框(字典) 设置下拉框勾选
			fox.setSelectValue4Dict("#selectDict",formData.selectDict,SELECT_SELECTDICT_DATA);
			//设置  选择框(查询) 设置下拉框勾选
			fox.setSelectValue4QueryApi("#resourceId",formData.resourze);
			//设置  角色 设置下拉框勾选
			fox.setSelectValue4QueryApi("#roleIds",formData.roles);




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

        //
		if(disableModify) {
			fox.lockForm($("#data-form"),true);
		}



        
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			data.field = form.val("data-form");


			//处理 逻辑值 默认值
		    if(!data.field.valid) data.field.valid=0;


			//处理 复选框(枚举) 默认值
			data.field["checkEnum"]=fox.getCheckedValue("checkEnum");
			//处理 复选框(字典) 默认值
			data.field["checkDict"]=fox.getCheckedValue("checkDict");



			//获取 选择框(枚举) 下拉框的值
			data.field["selectEnum"]=xmSelect.get("#selectEnum",true).getValue("value");
			if(data.field["selectEnum"] && data.field["selectEnum"].length>0) {
				data.field["selectEnum"]=data.field["selectEnum"][0];
			}
			//获取 选择框(字典) 下拉框的值
			data.field["selectDict"]=xmSelect.get("#selectDict",true).getValue("value");
			//获取 选择框(查询) 下拉框的值
			data.field["resourceId"]=xmSelect.get("#resourceId",true).getValue("value");
			if(data.field["resourceId"] && data.field["resourceId"].length>0) {
				data.field["resourceId"]=data.field["resourceId"][0];
			}
			//获取 角色 下拉框的值
			data.field["roleIds"]=xmSelect.get("#roleIds",true).getValue("value");

			//校验表单
			if(!fox.formVerify("data-form",data,VALIDATE_CONFIG)) return;

	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
					var index=admin.getTempData('sys-code-example-form-data-popup-index');
	                admin.finishPopupCenter(index);
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
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	(new FormPage()).init(layui);
});