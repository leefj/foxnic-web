/**
 * 系统资源 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-20 14:50:58
 */


function ListPage() {

    var settings, admin, form, table, layer, util, fox, upload, xmSelect;
    var columnData = null;
    /**
     * 入口函数，初始化
     */
    this.init = function (layui) {

        admin = layui.admin, settings = layui.settings, form = layui.form, upload = layui.upload, laydate = layui.laydate;
        table = layui.table, layer = layui.layer, util = layui.util, fox = layui.foxnic, xmSelect = layui.xmSelect, dropdown = layui.dropdown;

        if (window.pageExt.list.beforeInit) {
            window.pageExt.list.beforeInit();
        }


        var options=admin.getVar("custom-table-options");
        columnData = options.cols[0];
        var tmp = [];
        for (var i = 0; i < columnData.length; i++) {

            if(columnData[i].orderIndex==null) {
                columnData[i].orderIndex=i;
            }

            // 排除第一列和第二列
            if (i==0 && columnData[i].type == "numbers") continue;
            if (i==1 && columnData[i].type == "checkbox") continue;

            tmp.push(columnData[i]);

            if(columnData[i].hide==true) {
                columnData[i].hide=1;
            }
            if(columnData[i].hide==false) {
                columnData[i].hide=0;
            }

        }
        columnData = tmp;


        //渲染表格
        renderTable();

        $("#apply-button").click(function (){
            apply();
        });

        $("#sure-button").click(function (){
            apply();
        });

    }


    function apply() {

        var data=table.getData("data-table");
        var map={};
        for (var i = 0; i < data.length; i++) {
            map[data[i].field]=data[i];
            data[i].fixed=$("input[name='fixed-"+data[i].field+"']:checked").val();
            data[i].myTitle=$("input[name='myTitle-"+data[i].field+"']").val();
            data[i].width=$("input[name='width-"+data[i].field+"']").val();
            data[i].orderIndex=$("input[name='orderIndex-"+data[i].field+"']").val();
        }

        var hideEls=$(".switch-hide");
        //debugger
        for (var i = 0; i < hideEls.length; i++) {
            var el=$(hideEls[i]);
            var field=el.attr("data-id");
            el=el.next();
            var css=el.attr("class");
            var checked=false;
            if(css.indexOf("layui-form-onswitch")!=-1) checked=true;
            map[field].hide=checked;
        }




        console.log(data);
    }


    /**
     * 渲染表格
     */
    function renderTable() {

        //第一个实例
        table.render({
            elem: '#data-table'
            ,height: 500
            , data: columnData
            , page: false //开启分页
            ,done: function (data) {
                  form.render("select");
            }
            , cols: [[
                {type: 'numbers',unresize:true},
                {field: 'hide',title:"可见",width: 100, sort: true,align: "center",templet: '#cell-tpl-hide',unresize:true},
                {field: 'field', title: '字段', width: 180, sort: true, hide: true,unresize:true}
                , {field: 'title', title: '原列名', width: 180,sort: true,unresize:true}
                , {
                    field: 'myTitle', title: '自定义列名', width: 180, sort: true, templet: function (d) {
                        var val = d.myTitle;
                        if (!val) {
                            val = d.title;
                        }
                        return "<input type=\"text\" name='myTitle-"+d.field+"'  autocomplete=\"on\" class=\"layui-input\" style='height: 28px;' value='" + val + "'>";
                    }
                    ,unresize:true
                }
                , {
                    field: 'width', title: '列宽', width: 85, sort: true, align:"right", templet: function (d) {
                        var val = d.width;
                        return "<input type=\"number\" name='width-"+d.field+"'   autocomplete=\"on\" class=\"layui-input\" style='height: 28px;text-align: right;' value='" + val + "'>";
                    }
                    ,unresize:true
                }
                , {field: 'orderIndex', title: '顺序', width: 85, sort: true,align:"right",templet: function (d) {
                        var val = d.orderIndex;
                        return "<input type=\"number\" name='orderIndex-"+d.field+"'  autocomplete=\"on\" class=\"layui-input\" style='height: 28px;text-align: right;' value='" + val + "'>";
                    }
                    ,unresize:true},
                {field: 'orderIndex', title: '锁定', width: 160, sort: true,align:"center", templet: '#cell-tpl-fixed',unresize:true}
            ]]
        });

    };

    window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload', 'foxnic', 'xmSelect', 'laydate', 'dropdown'], function () {
    var task = setInterval(function () {
        if (!window["pageExt"]) return;
        clearInterval(task);
        (new ListPage()).init(layui);
    }, 1);
});
