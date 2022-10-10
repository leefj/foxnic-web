/**
 * jQuery json-viewer
 * @author: Alexandre Bodelot <alexandre.bodelot@gmail.com>
 * @link: https://github.com/abodelot/jquery.json-viewer
 */
(function($) {

    /**
     * Check if arg is either an array with at least 1 element, or a dict with at least 1 key
     * @return boolean
     */
    function isCollapsable(arg) {
        return arg instanceof Object && Object.keys(arg).length > 0;
    }

    /**
     * Check if a string looks like a URL, based on protocol
     * This doesn't attempt to validate URLs, there's no use and syntax can be too complex
     * @return boolean
     */
    function isUrl(string) {
        var protocols = ['http', 'https', 'ftp', 'ftps'];
        for (var i = 0; i < protocols.length; ++i) {
            if (string.startsWith(protocols[i] + '://')) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the input string html escaped
     * @return string
     */
    function htmlEscape(s) {
        return s.replace(/&/g, '&amp;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;')
            .replace(/'/g, '&apos;')
            .replace(/"/g, '&quot;');
    }

    /**
     * Transform a json object into html representation
     * @return string
     */
    function json2html(json, options , path) {
        var html = '';
        //debugger
        if (typeof json === 'string') {
            // Escape tags and quotes
            json = htmlEscape(json);

            if (options.withLinks && isUrl(json)) {
                html += '<a href="' + json + '" class="json-string" target="_blank">' + json + '</a>';
            } else {
                // Escape double quotes in the rendered non-URL string.
                json = json.replace(/&quot;/g, '\\&quot;');
                html += '<span class="json-string">"' + json + '"</span>';
            }
        } else if (typeof json === 'number' || typeof json === 'bigint') {
            html += '<span class="json-literal">' + json + '</span>';
        } else if (typeof json === 'boolean') {
            html += '<span class="json-literal">' + json + '</span>';
        } else if (json === null) {
            html += '<span class="json-literal">null</span>';
        } else if (json instanceof Array) {
            if (json.length > 0) {
                html += '[<ol class="json-array">';
                for (var i = 0; i < json.length; ++i) {
                    var propPath=path+"-"+i;
                    html += '<li>';
                    // Add toggle button if item is collapsable
                    if (isCollapsable(json[i])) {
                        html += '<a href class="json-toggle"></a>';
                    }
                    html += json2html(json[i], options,propPath);
                    // Add comma if item is not last
                    if (i < json.length - 1) {
                        html += ',';
                    }
                    html += '</li>';
                }
                html += '</ol>]';
            } else {
                html += '[]';
            }
        } else if (typeof json === 'object') {
            // Optional support different libraries for big numbers
            // json.isLosslessNumber: package lossless-json
            // json.toExponential(): packages bignumber.js, big.js, decimal.js, decimal.js-light, others?
            if (options.bigNumbers && (typeof json.toExponential === 'function' || json.isLosslessNumber)) {
                html += '<span class="json-literal">' + json.toString() + '</span>';
            } else {
                var keyCount = Object.keys(json).length;
                if (keyCount > 0) {
                    html += '{<ul class="json-dict">';
                    for (var key in json) {
                        // debugger
                        var propPath=path+"-"+key;
                        var currPath=propPath.substring(5);
                        var m=options.meta[currPath];
                        // debugger
                        var commentHtml="";
                        if(m) {
                            var content=[];
                            if(m.originalRef) {
                                content.push("<span path='" + propPath + "' class='layui-btn comment-data-type'>" + m.originalRef + "</span>");
                            } else {
                                if (m.type) {
                                    content.push("<span path='" + propPath + "' class='layui-btn comment-data-type'>" + m.type + "</span>");
                                }
                            }
                            if(options.type=="request") {
                                if (m.required) {
                                    content.push("<span class='comment-required'>必填</span>");
                                } else {
                                    content.push("<span class='comment-required'>可选</span>");
                                }
                            }
                            if(m.title) {
                                content.push(m.title);
                            }
                            if(m.description && m.description!=m.title) {
                                content.push(m.description);
                            }
                            commentHtml = "<span path='" + propPath + "' class='json-comment comment-" + propPath + "' style='padding-top:3px;padding-bottom:4px;white-space:nowrap;margin-left:18px;margin-right: 18px;font:13px Helvetica Neue,Helvetica,PingFang SC,Tahoma,Arial,sans-serif'>" + content.join(" / ") + "</span>"
                        }
                        if (Object.prototype.hasOwnProperty.call(json, key)) {
                            key = htmlEscape(key);
                            var keyRepr = options.withQuotes ?
                                '<span path="'+propPath+'" class="json-string json-prop prop-'+propPath+'">"' + key + '"</span>' : key;

                            html += '<li>';
                            // Add toggle button if item is collapsable
                            if (isCollapsable(json[key])) {
                                html += '<a href class="json-toggle">' + keyRepr + '</a>';
                            } else {
                                html += keyRepr;
                            }



                            var subHtml=json2html(json[key], options,propPath);



                            // debugger;
                            if(subHtml.startsWith("{")) {
                                subHtml="{"+commentHtml+subHtml.substring(1);
                            } else if(subHtml.startsWith("[")) {
                                subHtml="["+commentHtml+subHtml.substring(1);
                            } else {
                                subHtml=subHtml+commentHtml;
                            }

                            html += ': ' + subHtml;
                            // Add comma if item is not last
                            if (--keyCount > 0) {
                                html += ',';
                            } else {

                            }





                            html += '</li>';
                        }
                    }
                    html += '</ul>}';
                } else {
                    html += '{}';
                }
            }
        }
        return html;
    }

    /**
     * jQuery plugin method
     * @param json: a javascript object
     * @param options: an optional options hash
     */
    $.fn.jsonViewer = function(json, options) {
        // Merge user options with default options
        options = Object.assign({}, {
            collapsed: false,
            rootCollapsable: true,
            withQuotes: false,
            withLinks: true,
            bigNumbers: false,
            meta:null
        }, options);

        // jQuery chaining
        return this.each(function() {

            // Transform to HTML
            var html = json2html(json, options,"root");
            if (options.rootCollapsable && isCollapsable(json)) {
                html = '<a href class="json-toggle"></a>' + html;
            }

            html="<div style='float: right;' class='copy-button'>复制</div>"+html;

            // Insert HTML in target DOM element
            $(this).html(html);
            $(this).addClass('json-document');



            // Bind click on toggle buttons
            $(this).off('click');
            $(this).on('click', 'a.json-toggle', function() {
                var target = $(this).toggleClass('collapsed').siblings('ul.json-dict, ol.json-array');
                target.toggle();
                if (target.is(':visible')) {
                    target.siblings('.json-placeholder').remove();
                } else {
                    var count = target.children('li').length;
                    var placeholder = count + (count > 1 ? ' items' : ' item');
                    target.after('<a href class="json-placeholder">' + placeholder + '</a>');
                }
                return false;
            });

            // Simulate click on toggle button when placeholder is clicked
            $(this).on('click', 'a.json-placeholder', function() {
                $(this).siblings('a.json-toggle').click();
                return false;
            });

            if (options.collapsed == true) {
                // Trigger click to collapse all nodes
                $(this).find('a.json-toggle').click();
            }

            $(".comment-data-type").click(function (it){
                var name=$(it.currentTarget).text();
                //var m=options.meta[path.substring(5)];
                //debugger
                // alert(name);
                if(options.onModelNameClick) {
                    options.onModelNameClick(name);
                }
            });


            $(".copy-button").click(function (it){
                var str=JSON.stringify(json,null,4);
                navigator.clipboard.writeText(str);
                if(options.admin) {
                    options.admin.toast().success("请求参数已经复制",{time:1000,position:"right-bottom"});
                } else {
                    alert("请求参数已经复制");
                }
            });





            var activedColor="#e0e0e0";
            $(".json-comment").hover(function(it){
                //debugger
                var path=$(it.currentTarget).attr("path");
                $(".prop-"+path).css("background-color",activedColor);
                $(it.currentTarget).css("background-color",activedColor);
            },function(it){
                var path=$(it.currentTarget).attr("path");
                $(".prop-"+path).css("background-color","");
                $(it.currentTarget).css("background-color","");
            });

            $(".json-prop").hover(function(it){
                //debugger
                var path=$(it.currentTarget).attr("path");
                $(".comment-"+path).css("background-color",activedColor);
                $(it.currentTarget).css("background-color",activedColor);
            },function(it){
                var path=$(it.currentTarget).attr("path");
                $(".comment-"+path).css("background-color","");
                $(it.currentTarget).css("background-color","");
            });




        });
    };
})(jQuery);
