//debugger;
var layuiPath="/assets/libs/layui/";
var apiServerUrl=location.href;
var i=apiServerUrl.indexOf("//");
i=apiServerUrl.indexOf("/",i+2);
if(i==-1) {
	i=apiServerUrl.length;
} else {
	i++;
}
apiServerUrl =  apiServerUrl.substring(0,i-1);

console.log("layuiPath",layuiPath);
console.log("apiServerUrl",apiServerUrl);
