QueryString = {
	data: {},
	Initial: function() {
		var aPairs, aTmp;
		var queryString = new String(window.location.search);
		queryString = queryString.substr(1, queryString.length); //remove   "?"
		aPairs = queryString.split("&");
		for (var i = 0; i < aPairs.length; i++) {
			aTmp = aPairs[i].split("=");
			this.data[aTmp[0]] = aTmp[1];
		}
	},
	GetValue: function(key) {
		if(!this.data[key]) return null;
		return this.data[key];
	}
}
QueryString.Initial();


String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
		return false;
	if(this.substring(this.length-str.length)==str)
		return true;
	else
		return false;
	return true;
}

String.prototype.startWith=function(str) {
	if(str==null||str==""||this.length==0||str.length>this.length)
		return false;
	if(this.substr(0,str.length)==str)
		return true;
	else
		return false;
	return true;
}

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
