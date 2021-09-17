/**
 * 代码生成拥有的车辆 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-17 14:54:48
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-system/sys-code-example-car";

	var disableCreateNew=false;
	var disableModify=false;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		//如果没有修改和保存权限，
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(admin.getTempData('sys-code-example-car-form-data-form-action')=="view") {
			disableModify=true;
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit();
		}

		//渲染表单组件
		renderFormFields();

		//填充表单数据
		fillFormData();

		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();
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
			if(area==null) return;
			admin.putTempData('sys-code-example-car-form-area', area);
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

	}

	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('sys-code-example-car-form-data');
		}

		window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);

		var hasData=true;
		//如果是新建
		if(!formData || !formData.id) {
			adjustPopup();
			hasData=false;
		}
		var fm=$('#data-form');
		if (hasData) {
			fm[0].reset();
			form.val('data-form', formData);






			//处理fillBy

			//
	     	fm.attr('method', 'POST');

	     	renderFormFields();

			fox.fillDialogButtons();

			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

		}

		//渐显效果
		fm.css("opacity","0.0");
        fm.css("display","");
        setTimeout(function (){
            fm.animate({
                opacity:'1.0'
            },100);
        },1);

        //禁用编辑
		if((hasData && disableModify) || (!hasData &&disableCreateNew)) {
			fox.lockForm($("#data-form"),true);
			$("#submit-button").hide();
			$("#cancel-button").css("margin-right","15px")
		} else {
			$("#submit-button").show();
			$("#cancel-button").css("margin-right","0px")
		}

		//调用 iframe 加载过程
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(window.pageExt.form){
				jsFn=window.pageExt.form[jsFn];
				jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,formData);
			}
		}

	}

	function getFormData() {
		var data=form.val("data-form");




		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param) {
		var api=moduleURL+"/"+(param.id?"update":"insert");
		var task=setTimeout(function(){layer.load(2);},1000);
		admin.request(api, param, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if (data.success) {
				layer.msg(data.message, {icon: 1, time: 500});
				var index=admin.getTempData('sys-code-example-car-form-data-popup-index');
				admin.finishPopupCenter(index);
			} else {
				layer.msg(data.message, {icon: 2, time: 1000});
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, "POST");
	}

	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {

	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			data.field = getFormData();

			if(window.pageExt.form.beforeSubmit) {
				var doNext=window.pageExt.form.beforeSubmit(data.field);
				if(!doNext) return ;
			}
			//校验表单
			if(!verifyForm(data.field)) return;

			saveForm(data.field);
	        return false;
	    });

		// 请选择职位对话框
		$("#positionId-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#positionId"),$(this),{
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"pos",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});
		// 请选择组织节点对话框
		$("#orgId-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#orgId"),$(this),{
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});
		// 请选择职位对话框
		$("#positionIds-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#positionIds"),$(this),{
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"pos",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});
		// 请选择组织节点对话框
		$("#orgIds-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#orgIds"),$(this),{
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});
		// 请选择公司对话框
		$("#comId-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#comId"),$(this),{
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});
		// 请选择部门对话框
		$("#deptIds-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#deptIds"),$(this),{
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"dept",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});
		// 请选择组织节点对话框
		$("#subOrgId-button").click(function(){
			fox.chooseOrgNode && fox.chooseOrgNode(getFormData(),$("#subOrgId"),$(this),{
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "shanghai",
				targetType:"org",
				callback:function(ids,nodes,fromData,inputEl,buttonEl){}
			});
		});

	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});

    }

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		fillFormData: fillFormData,
		adjustPopup: adjustPopup
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});