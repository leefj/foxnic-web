/**
 * 系统资源 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-01-20 14:50:58
 */


function ListPage() {

    var settings, admin, form, table, layer, util, fox, upload, xmSelect;
    var columnData = null;
    var options = null;
    /**
     * 入口函数，初始化
     */
    this.init = function (layui) {

        admin = layui.admin, settings = layui.settings, form = layui.form, upload = layui.upload, laydate = layui.laydate;
        table = layui.table, layer = layui.layer, util = layui.util, fox = layui.foxnic, xmSelect = layui.xmSelect, dropdown = layui.dropdown;

        if (window.pageExt.list.beforeInit) {
            window.pageExt.list.beforeInit();
        }


        options = admin.getVar("custom-table-options");
        columnData = options.cols[0];
        var tmp = [];
        for (var i = 0; i < columnData.length; i++) {

            if(columnData[i].orderIndex==null) {
                columnData[i].orderIndex=i;
            }

            // 排除第一列和第二列
            if (i==0 && columnData[i].type == "numbers") continue;
            if (i==1 && columnData[i].type == "checkbox") continue;

            if (columnData[i].title == "") continue;
            if (columnData[i].field == "row-ops" && columnData[i].fixed == "right") continue;

            tmp.push(columnData[i]);

            if(columnData[i].hide==true) {
                columnData[i].hide=1;
            } else {
                columnData[i].hide=0;
            }

        }
        columnData = tmp;

        // debugger

        //渲染表格
        renderTable();

        $("#apply-button").click(function (){
            apply();
        });

        $("#sure-button").click(function (){
            apply();
            setTimeout(function (){
                // debugger;
                admin.finishPopupCenterById("table-custom-dialog");
            },100);
        });

    }


    function apply() {

        var sortEls=$(".sort-drag");
        var sorts={};
        for (var i = 0; i < sortEls.length; i++) {
            sorts[$(sortEls[i]).attr("field")]=i+1;
        }
        // debugger;
        var data=table.getData("data-table");
        var map={};
        for (var i = 0; i < data.length; i++) {
            map[data[i].field]=data[i];
            //data[i].fixed=$("input[name='fixed-"+data[i].field+"']:checked").val();
            data[i].title=$("input[name='title-"+data[i].field+"']").val();
            data[i].width=$("input[name='width-"+data[i].field+"']").val();
            data[i].orderIndex=sorts[data[i].field];
        }

        var hideEls=$(".switch-hide");
        for (var i = 0; i < hideEls.length; i++) {
            var el=$(hideEls[i]);
            var field=el.attr("data-id");
            el=el.next();
            var css=el.attr("class");
            var checked=false;
            if(css.indexOf("layui-form-onswitch")!=-1) checked=true;
            map[field].hide=!checked;
        }

        //
        admin.getVar("custom-table-apply-function")({columns:map});

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
            , limit:1024
            ,done: function (data) {
                  form.render("select");
                  var ct=$(".layui-table tbody");
                    Sortable.create(ct[0],{handle:".sort-drag",onUpdate: function (evt){

                    }});
            }
            , cols: [[
                // {type: 'numbers',unresize:true},
                {field: 'hide',title:"可见",width: 80, sort: false,align: "center",templet: '#cell-tpl-hide',unresize:true},
                {field: 'field', title: '字段', width: 180, sort: false, hide: true,unresize:true}
                , {field: 'programTitle', title: '原列名', width: 180,sort: false,unresize:true}
                , {
                    field: 'title', title: '自定义列名', width: 180, sort: false, templet: function (d) {
                        var val = d.title;
                        if (!val) {
                            val = d.programTitle;
                        }
                        return "<input type=\"text\" name='title-"+d.field+"'  autocomplete=\"on\" class=\"layui-input\" style='height: 28px;' value='" + val + "'>";
                    }
                    ,unresize:true
                }
                , {
                    field: 'width', title: '列宽', width: 85, sort: false, align:"right", templet: function (d) {
                        var val = d.width;
                        return "<input type=\"number\" name='width-"+d.field+"'   autocomplete=\"on\" class=\"layui-input\" style='height: 28px;text-align: right;' value='" + val + "'>";
                    }
                    ,unresize:true
                }
                , {field: 'orderIndex', title: '顺序', width: 85, sort: false,align:"right",templet: function (d) {
                        return "<div class='sort-drag' field='"+d.field+"'>拖拽</div>"
                    }
                    ,unresize:true}
                //,{field: 'orderIndex', title: '锁定', width: 160, sort: false,align:"center", templet: '#cell-tpl-fixed',unresize:true}
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
