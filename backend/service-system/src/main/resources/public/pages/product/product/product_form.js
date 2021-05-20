/**
 * 商品 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-09 04:05:29
 */
layui.use(['layer', 'admin', 'form', 'formSelects','upload','foxnic'], function () {
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
     
	//模块基础路径
	var moduleURL="/service-tailoring/prd-product/";
     
    form.render('radio');
 	fox.renderSimpleUpload("#img-0","#fileId-button-0","#fileId-image-0");
 	fox.renderSimpleUpload("#img-1","#fileId-button-1","#fileId-image-1");
 	fox.renderSimpleUpload("#img-2","#fileId-button-2","#fileId-image-2");
    
    
     // 获取所有角色
    layer.load(2);
    admin.req("/service-tailoring/prd-label/get-label-tree", {}, function (data) {
        layer.closeAll('loading');
        if (data.success) {
            // 渲染多选下拉框
            var labelsData =[];
            for (var i = 0; i < data.data.length; i++) {
            	var subLabels= data.data[i].subLabels;
            	if(subLabels && subLabels.length>0) {
            		labelsData.push({name:data.data[i].label,type:"optgroup"});
            		for (var j = 0; j <subLabels.length; j++) {
            		 	labelsData.push({name:subLabels[j].label,value:subLabels[j].id});
            		}
            	}
            }
            formSelects.data('labelIds', 'local', {arr: labelsData});
            
            fillForm();
			//debugger;
            // 回显user数据
            //var user = admin.getTempData('t_user');
            //debugger;
            //console.log(user);
            //$('#user-form').attr('method', 'POST');
            //if (user) {
            //    form.val('user-form', user);
            //    $('#user-form').attr('method', 'POST');
            //    var rds = new Array();
           //     for (var i = 0; i < user.roleIds.length; i++) {
           //         rds.push(user.roleIds[i]);
           //     }
           //     formSelects.value('roleId', rds);
          //  }
        } else {
            layer.msg('获取标签失败', {icon: 2, time: 500});
        }
    }, 'POST');
    
    
    //填充表单
    function fillForm() {
    	//debugger
		var formData = admin.getTempData('prd-product-form-data');
		$('#product-form').attr('method', 'POST');
		if (formData) {
			form.val('product-form', formData);
     		//设置并显示图片
			$('#product-form').attr('method', 'POST');
			
			//填充图片数据
			for (var i = 0;  formData.images && i < formData.images.length; i++) {
				$("#img-"+i).val(formData.images[i].fileId);
				$("#fileId-image-"+i).attr("src","/service-tailoring/sys-file/download?id="+formData.images[i].fileId);
			}
			//设置标签值
			var labels=[]
			for (var i = 0; formData.labels && i < formData.labels.length; i++) {
				labels.push(formData.labels[i].id);
			}
			formSelects.value('labelIds', labels);
			
     	}
    }
    //
    fillForm();
 
    // 表单提交事件
    form.on('submit(product-form-submit)', function (data) {
		//debugger;
    	//处理逻辑值
	    if(!data.field.isOnShelf) data.field.isOnShelf=0;
	    
	    //data.field.labels=data.field.labelIds;
	    //data.field.images=[];
	    var img0=data.field["img-0"];
	    var img1=data.field["img-1"];
	    var img2=data.field["img-2"];
	    if(!img0 || img0=="") {
	    	layer.msg("请选择主图");
	    	return false;
	    }
	    debugger
	    data.field.imageIds=[];
	    if(img0.length>0) {
	    	data.field.imageIds.push(img0);
	    }
	    if(img1.length>0) {
	    	data.field.imageIds.push(img1);
	    }
	    if(img2.length>0) {
	    	data.field.imageIds.push(img2);
	    }
 
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