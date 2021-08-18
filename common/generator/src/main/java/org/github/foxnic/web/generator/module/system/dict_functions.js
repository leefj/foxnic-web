
//[openDictItemWindow]
/**
 * 打开字典条窗口
 * */
function openDictItemWindow(data) {
    admin.putTempData("dictId",data.id,true);
    var index = admin.popupCenter({
        title: "条目",
        resize: false,
        id: 'dictItemsWindow',
        area: ["800px", "600px"],
        type: 2,
        content: "/business/system/dict_item/dict_item_list.html"
    });
}

//[beforeDictItemDataQuery]
/**
 * 字典条目表查询前调用
 * */
function beforeDictItemDataQuery(conditions) {
    //获得缓存中的字典ID
    var dictIdValue=admin.getTempData("dictId");
    //设置固定的查询条件
    if(!conditions["dictId"]) conditions["dictId"]={};
    conditions["dictId"].value=dictIdValue;
}

//[beforeDictItemDataFill]
/**
 * 字典条目表单填充前调用
 * */
function beforeDictItemDataFill(data) {
    //获得缓存中的字典ID
    var dictIdValue=admin.getTempData("dictId");
    //设置默认值
    data["dictId"]=dictIdValue;
}

//[afterDictItemDataFill]
/**
 * 字典条目表单填充前调用
 * */
function afterDictItemDataFill(data) {
    console.log("afterDictItemDataFill",data);
}