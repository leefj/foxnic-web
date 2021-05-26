//debugger;
var my_api_server_url=location.href;
var i=my_api_server_url.indexOf("//");
i=my_api_server_url.indexOf("/",i+2);
if(i==-1) {
	i=my_api_server_url.length;
} else {
	i++;
}
my_api_server_url =  my_api_server_url.substring(0,i-1);
console.log("baseURI",my_api_server_url);