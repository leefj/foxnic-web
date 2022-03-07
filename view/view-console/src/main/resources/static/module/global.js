QueryString = {
	data: {},
	initial: function() {
		var aPairs, aTmp;
		var queryString = new String(window.location.search);
		queryString = queryString.substr(1, queryString.length); //remove   "?"
		aPairs = queryString.split("&");
		for (var i = 0; i < aPairs.length; i++) {
			aTmp = aPairs[i].split("=");
			this.data[aTmp[0]] = aTmp[1];
		}
	},
	get: function(key) {
		if(!this.data[key]) return null;
		return this.data[key];
	}
}
QueryString.initial();

TypeUtil={
	isArray:function (data) {
		return Array.isArray(data);
	},
	isNumber:function (data) {
		if (parseFloat(data).toString() == 'NaN') {
			return false;
		} else {
			return true;
		}
	},
	isInteger:function (data) {
		return Number.isInteger(data);
	},
	isObject:function (data){
		return data.constructor === Object;
	}

}


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

Array.prototype.removeAt = function(index) {
	if (isNaN(index) || index >= this.length) {
		return false;
	}
	this.splice(index, 1);
};

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

var Theme={
	index:{
		//顶部菜单文本颜色
		headerMenuTextColor:"#333333",
		//顶部菜单文本选中的颜色
		headerMenuSelectedTextColor:"#009688",
		//顶部菜单文本颜色
		headerMenuDropDownTextColor:"#333333"
	}
};



console.log("layuiPath",layuiPath);
console.log("apiServerUrl",apiServerUrl);
