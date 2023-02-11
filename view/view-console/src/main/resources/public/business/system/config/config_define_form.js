/**
 * 系统配置 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-02-01 11:37:39
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup,dropdown;

	const moduleURL="/service-system/sys-config";
	// 表单执行操作类型：view，create，edit
	var notExistAction=null;
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

		notExistAction=admin.getTempData('sys-config-form-data-form-notExistAction');
		//如果没有修改和保存权限
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(notExistAction=="view") {
			disableModify=true;
		}

		if(bpmIntegrateMode=="front" && isInProcess==1) {
			$(".model-form-footer").hide();
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit(notExistAction,admin.getTempData('sys-config-form-data'));
		}

		//渲染表单组件
		renderFormFields();

		//填充表单数据
		fillFormData(DATA);

		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();

		//loadFormData();
	}


	function loadFormData() {
		var id=QueryString.get("id");
		admin.request(moduleURL+"/get-by-id",{id:id},function(r) {
			if(r.success) {
				fillFormData(r.data)
			} else {
				admin.toast().error("获取数据失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
			}
		});
	};

	window.loadFormData=loadFormData;





	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup() {
		if(window.pageExt.form.beforeAdjustPopup) {
			var doNext=window.pageExt.form.beforeAdjustPopup();
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
					setTimeout(adjustPopup,1000);
				}
				prevBodyHeight = bodyHeight;
				return;
			}
			var area=admin.changePopupArea(null,bodyHeight+footerHeight,'sys-config-form-data-win');
			if(area==null) return;
			admin.putTempData('sys-config-form-area', area);
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

		//渲染 catalogCode 下拉字段
		fox.renderSelectBox({
			el: "catalogCode",
			radio: true,
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("catalogCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(notExistAction=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		form.on('radio(type)', function(data){
			var checked=[];
			$('input[type=radio][lay-filter=type]:checked').each(function() {
				checked.push($(this).val());
			});
			window.pageExt.form.onRadioBoxChanged && window.pageExt.form.onRadioBoxChanged("type",data,checked);
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
		admin.post(moduleURL+"/get-by-id", { id : id }, function (r) {
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
			formData = admin.getTempData('sys-config-form-data');
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






			//设置  分类代码 设置下拉框勾选
			fox.setSelectValue4Dict("#catalogCode",formData.catalogCode,SELECT_CATALOGCODE_DATA);

			//处理fillBy

			//
	     	fm.attr('method', 'POST');
	     	fox.fillDialogButtons();
	     	renderFormFields();

			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

		}

		//渐显效果
		var currProfileId=admin.getVar("currentConfigProfileId");
		// debugger
		if(formData.profileId==currProfileId  || (formData.profileId!=currProfileId && formData.type!="DIR")) {
			var footer = $(".model-form-footer");
			footer.css("opacity", "0.0");
			footer.css("display", "");
			setTimeout(function () {
				footer.animate({
					opacity: '1.0'
				}, 100, null, function () {
					footer.css("opacity", "1.0");
				});
			}, 1);
		}

		// fm.css("opacity","0.0");
        // fm.css("display","");
        // setTimeout(function (){
        //     fm.animate({
        //         opacity:'1.0'
        //     },100,null,function (){
		// 		fm.css("opacity","1.0");});
        // },1);

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

		dataBeforeEdit=getFormData();

	}

	function getFormData() {
		var data=form.val("data-form");

		//处理 是否生效 默认值
		if(!data.valid) data.valid=0;


		//获取 分类代码 下拉框的值
		data["catalogCode"]=fox.getSelectedValue("catalogCode",false);

		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param,callback) {
		var currProfileId=admin.getVar("currentConfigProfileId");
		if(param.profileId!=currProfileId) {

			top.layer.confirm(fox.translate('本操作将在当前 Profile 生成新的配置项，是否继续操作？'), function (i) {
				top.layer.close(i);
				param.profileId=currProfileId;
				param.id=null;
				debugger
				saveFormInternal(param,callback);
			});


		} else {
			saveFormInternal(param,callback);
		}

	}

	function saveFormInternal(param,callback) {

		if(window.pageExt.form.beforeSubmit) {
			var doNext=window.pageExt.form.beforeSubmit(param);
			if(!doNext) return ;
		}

		param.dirtyFields=fox.compareDirtyFields(dataBeforeEdit,param);
		var notExistAction=param.id?"edit":"create";
		var api=moduleURL+"/"+(param.id?"update":"insert");
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
					doNext = callback(data,notExistAction);
				}


				parent.chaneNodeName(data.data.id,data.data.name,data.data.type,data.data.profileId);
				fox.showMessage(data);
				// if(doNext) {
				// 	admin.finishPopupCenterById('sys-config-form-data-win');
				// }
				// debugger;
				if(dataBeforeEdit.type!=param.type || dataBeforeEdit.typeDesc!=param.typeDesc) {
					location.reload();
					return;
				}

				// 调整状态为编辑
				notExistAction="edit";

				// admin.toast().success("保存成功",{time:1000,position:"top-right"});


			} else {
				fox.showMessage(data);
				if(data.code=="02") {
					fillFormData(DATA);
				}
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
	    $("#cancel-button").click(function(){ admin.finishPopupCenterById('sys-config-form-data-win',this); });

    }

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		verifyAndSaveForm:verifyAndSaveForm,
		fillFormData: fillFormData,
		fillFormDataByIds:fillFormDataByIds,
		processFormData4Bpm:processFormData4Bpm,
		adjustPopup: adjustPopup,
		notExistAction: notExistAction,
		setAction: function (act) {
			notExistAction = act;
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