/**
 * 数据存储 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-30 16:49:46
 * @version
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-pcm/pcm-catalog";

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
		if(admin.getTempData('pcm-catalog-form-data-form-action')=="view") {
			disableModify=true;
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit();
		}

		//渲染表单组件
		renderFormFields();

		//填充表单数据
		//fillFormData();

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
		return;
		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			var area=admin.changePopupArea(null,bodyHeight+footerHeight);
			if(area==null) return;
			admin.putTempData('pcm-catalog-form-area', area);
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

		var tables=[];
		for (let i = 0; i < STORAGE_TABLES.length; i++) {
			var t=STORAGE_TABLES[i].split(",");
			tables.push({name:t[0], value:t[0],rows:t[1]});
		}
		xmSelect.render({
			el: '#dataTable',
			radio:true,
			clickClose:true,
			data: tables,
			template({ item, sels, name, value }){
				return item.name  + '<span style="position: absolute; right: 10px; color: #8799a3">'+item.rows+'行</span>'
			}
		});
	}

	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('pcm-catalog-form-data');

		window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);

		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);

			var inst=xmSelect.get("#dataTable",true);
			if(formData.dataTable) {
				inst.setValue([{name:formData.dataTable,value:formData.dataTable}]);
				inst.update({
					el:"#dataTable",
					disabled: true
				});
			} else {
				inst.setValue([]);
				inst.update({
					el:"#dataTable",
					disabled: false
				});
			}



	     	fm.attr('method', 'POST');


			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

		}

        // 禁用编辑
		if(disableModify) {
			fox.lockForm($("#data-form"),true);
			$("#submit-button").hide();
			$("#cancel-button").css("margin-right","15px")
			$(".model-form-footer").css("display","none");
		} else {
			$("#submit-button").show();
			$("#cancel-button").css("margin-right","0px");
			$(".model-form-footer").css("display","");
		}

	}

	function getFormData() {
		var data=form.val("data-form");
		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(data) {
		var api=moduleURL+"/"+(data.id?"update":"insert");

		data["dataTable"]= data.select;
		var formData=data;
		var task=setTimeout(function(){layer.load(2);},1000);
		admin.request(api, data, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if (data.success) {
				layer.msg(data.message, {icon: 1, time: 500});
				var inst=xmSelect.get("#dataTable",true);
				if(formData.dataTable) {
					inst.update({
						el:"#dataTable",
						disabled: true
					});
				};
				parent.chaneNodeName(formData.id,formData.name);
			} else {
				layer.msg(data.message, {icon: 2, time: 1000});
			}
		}, "POST");
	}

	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {

	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			data.field = getFormData();

			//校验表单
			if(!verifyForm(data.field)) return;

			if(window.pageExt.form.beforeSubmit) {
				var doNext=window.pageExt.form.beforeSubmit(data.field);
				if(!doNext) return ;
			}
			saveForm(data.field);
	        return false;
	    });


	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});

    }

    function loadFormData(id) {
    	admin.request(moduleURL+"/get-by-id",{id:id},function (r){
    		if(r.success) {
				admin.putTempData('pcm-catalog-form-data', r.data);
				fillFormData();
			}
		})

	}

    window.module={
		loadFormData: loadFormData,
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm
	};

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});