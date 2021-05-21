/**
 * 订单 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-15 01:58:25
 */
layui.use(['layer', 'admin', 'form', 'formSelects','upload','foxnic','laydate','util'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var form = layui.form;
    var util = layui.util;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/odr-order/";
     
    form.render('radio');
	laydate.render({
	    elem: '#appointmentTime'
	});
    //渲染图片字段
    formSelects.data('companyId', 'server', {
 		url: '/service-tailoring/crm-company/query-list-for-select',
		success: function(id, url, searchVal, result){
        	if(formData) {
        		layui.formSelects.value('companyId', [formData.companyId]);
        	}
        }
	});
	
	//渲染状态字段
    formSelects.data('status', 'server', {
 		url: '/service-tailoring/sys-dict-item/query-dict-items?dictCode=order_status',
		success: function(id, url, searchVal, result){
        	if(formData) {
        		layui.formSelects.value('status', [formData.status]);
        	}
        }
	});
	
	var provinceId,cityId,areaId,townId;
	//渲染图片字段
    formSelects.data('provinceId', 'server', {
 		url: '/service-tailoring/sys-area/query-list-for-select',
 		success: function(id, url, searchVal, result){
        	if(provinceId) {
        		layui.formSelects.value('provinceId', [provinceId]);
        	}
        }
	});
	layui.formSelects.on('provinceId', function(id, vals, val, isAdd, isDisabled){
		if(isAdd) {
    		provinceId=val.val;
		} else {
			provinceId=-1;
		}
    	layui.formSelects.value('cityId', []);
    	layui.formSelects.value('areaId', []);
    	layui.formSelects.value('townId', []);
    	refreshCitySelect(false);
    	refreshAreaSelect(true);
    	refreshTownSelect(true);
    });
    
    
    function refreshCitySelect(clear) {
    	formSelects.data('cityId', 'server', {
 			url: '/service-tailoring/sys-area/query-list-for-select?parentId='+(clear?"-1":provinceId),
 			success: function(id, url, searchVal, result) {
	        	if(cityId) {
	        		layui.formSelects.value('cityId', [cityId]);
	        	}
        	}
		});
    }
    refreshCitySelect(true);
    layui.formSelects.on('cityId', function(id, vals, val, isAdd, isDisabled){
    	if(isAdd) {
    		cityId=val.val;
    	} else {
    		cityId=-1;
    	}
    	layui.formSelects.value('areaId', []);
    	layui.formSelects.value('townId', []);
    	refreshAreaSelect(false);
    	refreshTownSelect(true);
    });
    
    function refreshAreaSelect(clear) {
    	formSelects.data('areaId', 'server', {
 			url: '/service-tailoring/sys-area/query-list-for-select?parentId='+(clear?"-1":cityId),
			success: function(id, url, searchVal, result) {
	        	if(areaId) {
	        		layui.formSelects.value('areaId', [areaId]);
	        	}
        	}
		});
    }
    refreshAreaSelect(true);
    layui.formSelects.on('areaId', function(id, vals, val, isAdd, isDisabled){
    	if(isAdd) {
    		areaId=val.val;
    	} else {
    		cityId=-1;
    	}
    	layui.formSelects.value('townId', []);
    	refreshTownSelect(false);
    });
    
    function refreshTownSelect(clear) {
    	formSelects.data('townId', 'server', {
 			url: '/service-tailoring/sys-area/query-list-for-select?parentId='+(clear?"-1":areaId),
			success: function(id, url, searchVal, result) {
	        	if(townId) {
	        		layui.formSelects.value('townId', [townId]);
	        	}
        	}
		});
    }
    refreshTownSelect(true);
  
	
    var formData = null;
	function fillForm() {
		formData = admin.getTempData('odr-order-form-data');
	 	if(formData.appointmentTime && formData.appointmentTime.length>10) {
	 		formData.appointmentTime=formData.appointmentTime.substring(0,10);
	 	}
	 
		
     	$('#order-form').attr('method', 'POST');
     	if (formData) {
     		form.val('order-form', formData);
     		//设置并显示图片
     		$('#order-form').attr('method', 'POST');
     	}
     	if(!formData || !formData.id) {
     		$("#orderNoField").hide();
     	}
     	
     	layui.formSelects.value('companyId', [formData.companyId]);
     	//debugger;
     	provinceId=formData.provinceId;
     	cityId=formData.cityId;
     	areaId=formData.areaId;
     	townId=formData.townId;
     	//debugger;
     	layui.formSelects.value('provinceId', [provinceId]);
     	refreshCitySelect(false);
     	refreshAreaSelect(false);
     	refreshTownSelect(false);
     	
	}
	fillForm();
	
     
     
 
 
    // 表单提交事件
    form.on('submit(order-form-submit)', function (data) {
    	//debugger;
    	
    	//处理逻辑值
    	
    	var api=moduleURL+(data.field.id?"update":"insert");
        layer.load(2);
        admin.req(api, JSON.stringify(data.field), function (data) {
            layer.closeAll('loading');
            if (data.success) {
                layer.msg(data.message, {icon: 1, time: 500});
                admin.finishPopupCenter();
            } else {
                layer.msg(data.message, {icon: 2, time: 500});
            }
        }, "POST");
        
        return false;
    });
});