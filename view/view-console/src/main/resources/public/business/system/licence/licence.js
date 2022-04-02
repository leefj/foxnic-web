/**
 * 数据字典 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-10 16:42:16
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	const moduleURL="/service-system/sys-dict";
	// 表单执行操作类型：view，create，edit
	var action=null;
	var disableCreateNew=false;
	var disableModify=false;
	var dataBeforeEdit=null;


	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

		admin = layui.admin, settings = layui.settings, form = layui.form, upload = layui.upload, laydate = layui.laydate;
		table = layui.table, layer = layui.layer, util = layui.util, fox = layui.foxnic, xmSelect = layui.xmSelect, dropdown = layui.dropdown;

		var uploadInst = upload.render({
			elem: '#test1' //绑定元素
			,exts:'lic'
			,url: "/service-system/sys-licence/import"
			,choose: function(obj) {
				obj.preview(function (index, file, result) {
					importLicence(result);
				});
			}
			,done: function(res){
				importLicence(res.data[0].fileId);
			}
			,error: function(){
				top.layer.msg("许可证已提交，稍后请刷新页面", {icon: 1, time: 1500});
			}
		});
	}

	function importLicence(result) {
		if(result==null) {
			top.layer.msg("文件读取失败", {icon: 2, time: 1500});
			return;
		}

		result=result.substr(result.indexOf(",")+1);

		admin.post("/service-system/sys-licence/import", {data:result}, function (data) {
			if (data.success) {
				top.layer.msg("许可证导入成功!", {icon: 1, time: 1500});
				setTimeout(function (){
					location=location;
				},2000);
			} else {
				top.layer.msg(data.message, {icon: 2, time: 1500});
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, {delayLoading:1000,elms:[$("#submit-button")]});

	}



}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});
