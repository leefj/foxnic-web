//debugger;
var layuiPath="/assets/libs/layui/";
var apiServerUrl=function () {
	var href=location.href;
	var i=href.indexOf("//");
	i=href.indexOf("/",i+2);
	if(i==-1) {
		i=href.length;
	} else {
		i++;
	}
	href =  href.substring(0,i-1);
	return href;
} ();
var apiurls={
	storage: {
		upload: "/service-storage/sys-file/upload",
		download: "/service-storage/sys-file/download",
		image: "/service-storage/sys-file/image",
		remove: "/service-storage/sys-file/delete",
		getById:"/service-storage/sys-file/get-by-id",
		getByIds:"/service-storage/sys-file/get-by-ids"
	}
}



console.log("layuiPath",layuiPath);
console.log("apiServerUrl",apiServerUrl);
