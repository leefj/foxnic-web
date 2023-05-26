/**
 * 订单地址 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-05-26 14:57:49
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;
	const languageContext='my-context'; 
	// 接口地址
	const moduleURL="/service-example/example-address";
	const queryURL=moduleURL+"/get-by-id";
	const insertURL=moduleURL+"/insert";
	const updateURL=moduleURL+"/update";

	var rawFormData=null;
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;
	const bpmIntegrateMode="none";
	var isInProcess=QueryString.get("isInProcess");

	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload,dropdown=layui.dropdown;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		action=admin.getTempData('example-address-form-data-form-action');
		//如果没有修改和保存权限
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(action=="view") {
			disableModify=true;
		}

		if(bpmIntegrateMode=="front" && isInProcess==1) {
			$(".model-form-footer").hide();
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit(action,admin.getTempData('example-address-form-data'));
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
	function adjustPopup(arg) {
		if(window.pageExt.form.beforeAdjustPopup) {
			var doNext=window.pageExt.form.beforeAdjustPopup(arg);
			if(!doNext) return;
		}



		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		var prevBodyHeight=-1;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			if(bpmIntegrateMode=="front" && isInProcess==1) {
				var updateFormIframeHeight=admin.getVar("updateFormIframeHeight");
				if(bodyHeight>0 && bodyHeight!=prevBodyHeight) {
					updateFormIframeHeight && updateFormIframeHeight(bodyHeight);
				} else {
					setTimeout(function() {adjustPopup(arg);},1000);
				}
				prevBodyHeight = bodyHeight;
				return;
			}
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'example-address-form-data-win');
			if(area==null) return;
			admin.putTempData('example-address-form-area', area);
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

		laydate.render({
			elem: '#dateDemo1',
			type:"year",
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo1",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo2',
			type:"month",
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo2",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo3',
			type:"date",
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo3",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo4',
			type:"time",
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo4",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo5',
			type:"datetime",
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo5",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo11',
			type:"year",
			format:"yyyy-MM-dd HH:mm:ss",
			range:true,
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo11",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo22',
			type:"month",
			format:"yyyy-MM-dd HH:mm:ss",
			range:true,
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo22",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo33',
			type:"date",
			format:"yyyy-MM-dd HH:mm:ss",
			range:true,
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo33",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo44',
			type:"time",
			format:"yyyy-MM-dd HH:mm:ss",
			range:true,
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo44",value, date, endDate);
			}
		});
		laydate.render({
			elem: '#dateDemo55',
			type:"datetime",
			format:"yyyy-MM-dd HH:mm:ss",
			range:true,
			trigger:"click",
			done: function(value, date, endDate){
				window.pageExt.form.onDatePickerChanged && window.pageExt.form.onDatePickerChanged("dateDemo55",value, date, endDate);
			}
		});
	}

	/**
	 * 根据id填充表单
	 * */
	function fillFormDataByIds(ids) {
		if(!ids) return;
		if(ids.length==0) return;
		var id=ids[0];
		if(!id) return;
		admin.post(queryURL, { id : id }, function (r) {
			if (r.success) {
				fillFormData(r.data)
			} else {
				fox.showMessage(r);
			}
		});
	}

	/**
	 * 在流程提交前处理表单数据
	 * */
	function processFormData4Bpm (processInstanceId,param,cb) {
		window.pageExt.form.processFormData4Bpm && window.pageExt.form.processFormData4Bpm(processInstanceId,param,cb);
	}

	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('example-address-form-data');
		}
		rawFormData=formData;

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




			//设置 年份 显示复选框勾选
			if(formData["dateDemo1"]) {
				$("#dateDemo1").val(fox.dateFormat(formData["dateDemo1"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 月份 显示复选框勾选
			if(formData["dateDemo2"]) {
				$("#dateDemo2").val(fox.dateFormat(formData["dateDemo2"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 日期 显示复选框勾选
			if(formData["dateDemo3"]) {
				$("#dateDemo3").val(fox.dateFormat(formData["dateDemo3"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 时间 显示复选框勾选
			if(formData["dateDemo4"]) {
				$("#dateDemo4").val(fox.dateFormat(formData["dateDemo4"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 日期时间 显示复选框勾选
			if(formData["dateDemo5"]) {
				$("#dateDemo5").val(fox.dateFormat(formData["dateDemo5"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 年份范围 显示复选框勾选
			if(formData["dateDemo11"]) {
				$("#dateDemo11").val(fox.dateFormat(formData["dateDemo11"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 月份范围 显示复选框勾选
			if(formData["dateDemo22"]) {
				$("#dateDemo22").val(fox.dateFormat(formData["dateDemo22"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 日期范围 显示复选框勾选
			if(formData["dateDemo33"]) {
				$("#dateDemo33").val(fox.dateFormat(formData["dateDemo33"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 时间范围 显示复选框勾选
			if(formData["dateDemo44"]) {
				$("#dateDemo44").val(fox.dateFormat(formData["dateDemo44"],"yyyy-MM-dd HH:mm:ss"));
			}
			//设置 日期时间范围 显示复选框勾选
			if(formData["dateDemo55"]) {
				$("#dateDemo55").val(fox.dateFormat(formData["dateDemo55"],"yyyy-MM-dd HH:mm:ss"));
			}



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
			},100,null,function (){
				fm.css("opacity","1.0");});
		},1);


        //禁用编辑
	if((action=="edit" && hasData && disableModify) || (action=="create" && !hasData &&disableCreateNew)) {
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

		dataBeforeEdit=getFormData();

	}

	/**
	 * 获得从服务器请求的原始表单数据
	 * */
	function getRawFormData() {
		if(!rawFormData) {
			rawFormData = admin.getTempData('example-address-form-data');
		}
		return rawFormData;
	}

	function getFormData() {
		var data=form.val("data-form");




		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param,callback) {

		if(window.pageExt.form.beforeSubmit) {
			var doNext=window.pageExt.form.beforeSubmit(param);
			if(!doNext) return ;
		}

		param.dirtyFields=fox.compareDirtyFields(dataBeforeEdit,param);
		var action=param.id?"edit":"create";
		var api=param.id?updateURL:insertURL;
		admin.post(api, param, function (data) {
			if (data.success) {
				var doNext=true;
				var pkValues=data.data;
				if(pkValues) {
					for (var key in pkValues) {
						$("#"+key).val(pkValues[key]);
					}
				}
				if(window.pageExt.form.betweenFormSubmitAndClose) {
					doNext=window.pageExt.form.betweenFormSubmitAndClose(param,data);
				}

				if(callback) {
					doNext = callback(data,action);
				}

				if(doNext) {
					admin.finishPopupCenterById('example-address-form-data-win');
				}

				// 调整状态为编辑
				action="edit";

			} else {
				fox.showMessage(data);
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, {delayLoading:1000,elms:[$("#submit-button")]});
	}

	function verifyAndSaveForm(data) {
		if(!data) data={};
		//debugger;
		data.field = getFormData();
		//校验表单
		if(!verifyForm(data.field)) return;
		saveForm(data.field);
		return false;
	}

	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {

	    form.on('submit(submit-button)', verifyAndSaveForm);


	    //关闭窗口
	    $("#cancel-button").click(function(){ admin.finishPopupCenterById('example-address-form-data-win',this); });

    }

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		getRawFormData:getRawFormData,
		verifyAndSaveForm:verifyAndSaveForm,
		renderFormFields:renderFormFields,
		fillFormData: fillFormData,
		fillFormDataByIds:fillFormDataByIds,
		processFormData4Bpm:processFormData4Bpm,
		adjustPopup: adjustPopup,
		action: action,
		setAction: function (act) {
			action = act;
		}
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});