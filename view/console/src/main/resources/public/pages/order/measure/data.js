/**
 * 订单测量信息 表单 JS 脚本
 * @author 李方捷
 * @since 2021-04-16 09:44:30
 */
layui.config({
        base: '/module/'
}).use(['layer', 'admin', 'form','upload','foxnic','table'], function () {
	
    var layer = layui.layer;
    var admin = layui.admin;
    var form = layui.form;
    var formSelects = layui.formSelects;
	var fox = layui.foxnic;
	
	var measureId=fox.getQueryVariable("measureId");
	var measureType=fox.getQueryVariable("measureType");
	var effectFileId=fox.getQueryVariable("effectFileId");

	var data=admin.getTempData('odr-measure-form-data');
	console.log(data);
	
	//debugger;
	
	//设置尺寸
	var d=4;
	var ifr1=$("#ifr1");
	ifr1.css("height",(document.documentElement.clientHeight-d)+"px");
	ifr1.height(document.documentElement.clientHeight-d);

	//var ifr2=$("#ifr2");
	//ifr2.css("height",(document.documentElement.clientHeight-d)+"px");
	//ifr2.height(document.documentElement.clientHeight-d);
 	//debugger

	var url="download?id="+effectFileId;
	var t1=setInterval(function (){
		if(ifr1[0].contentWindow && ifr1[0].contentWindow.render) {
			//调用3D渲染
			ifr1[0].contentWindow.render(url);
			clearInterval(t1);
		}
	},16);


	//url="download?id="+data.bodyEffectFileId;

	//var t2=setInterval(function (){
	//	if(ifr2[0].contentWindow && ifr2[0].contentWindow.render) {
			//调用3D渲染
			//ifr2[0].contentWindow.render(url);
	//		clearInterval(t2);
	//	}
	//},16);
 
	//模块基础路径
	var moduleURL="/service-tailoring/odr-measure/";
 
	 // 渲染表格
    fox.renderTable({
    	elem: '#dim-table',
    	page:false,
        url: moduleURL +'/query-measure-dimensions-and-data?id='+measureId+"&measureType="+measureType,
        parseData: function(res){ //res 即为原始返回的数据
		    return {
		      "code": res.code=="00"?0:-1, //解析接口状态
		      "msg": res.message, //解析提示文本
		      "count": res.data.length, //解析数据长度
		      "data": res.data //解析数据列表
		    };
		},
		height:document.documentElement.clientHeight,
		cols: [[
            { field: 'label',sort: false, title: fox.translate('项目') } ,
            { field: 'value', sort: false,align:"right", title: fox.translate('数据') }
        ]]
    });
	
    
});