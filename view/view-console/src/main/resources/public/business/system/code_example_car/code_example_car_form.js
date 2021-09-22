/**
 * 代码生成拥有的车辆 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-22 16:34:40
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
	     	fox.fillDialogButtons();
	     	renderFormFields();

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

		// 请选择岗位对话框
		$("#positionId-button").click(function(){
			var positionIdDialogOptions={
				field:"positionId",
				formData:getFormData(),
				inputEl:$("#positionId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"pos",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(positionIdDialogOptions);
		});
		// 请选择组织节点对话框
		$("#orgId-button").click(function(){
			var orgIdDialogOptions={
				field:"orgId",
				formData:getFormData(),
				inputEl:$("#orgId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(orgIdDialogOptions);
		});
		// 请选择人员对话框
		$("#empId-button").click(function(){
				var empIdDialogOptions={
				field:"empId",
				formData:getFormData(),
				inputEl:$("#empId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseEmployee(empIdDialogOptions);
		});
		// 请选择岗位对话框
		$("#positionIds-button").click(function(){
			var positionIdsDialogOptions={
				field:"positionIds",
				formData:getFormData(),
				inputEl:$("#positionIds"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"pos",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(positionIdsDialogOptions);
		});
		// 请选择组织节点对话框
		$("#orgIds-button").click(function(){
			var orgIdsDialogOptions={
				field:"orgIds",
				formData:getFormData(),
				inputEl:$("#orgIds"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(orgIdsDialogOptions);
		});
		// 请选择人员对话框
		$("#empIds-button").click(function(){
				var empIdsDialogOptions={
				field:"empIds",
				formData:getFormData(),
				inputEl:$("#empIds"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseEmployee(empIdsDialogOptions);
		});
		// 请选择公司对话框
		$("#comId-button").click(function(){
			var comIdDialogOptions={
				field:"comId",
				formData:getFormData(),
				inputEl:$("#comId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(comIdDialogOptions);
		});
		// 请选择部门对话框
		$("#deptIds-button").click(function(){
			var deptIdsDialogOptions={
				field:"deptIds",
				formData:getFormData(),
				inputEl:$("#deptIds"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"dept",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(deptIdsDialogOptions);
		});
		// 请选择组织节点对话框
		$("#subOrgId-button").click(function(){
			var subOrgIdDialogOptions={
				field:"subOrgId",
				formData:getFormData(),
				inputEl:$("#subOrgId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "shanghai",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(subOrgIdDialogOptions);
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