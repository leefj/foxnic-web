package org.github.foxnic.web.oauth.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.springboot.mvc.Result;

/**
 *  <p> 使用response输出JSON </p>
 *
 * @description :
 * @author : zhengqing
 * @date : 2019/10/11 17:27
 */
public class ResponseUtils {

    /**
     * 使用response输出JSON
     *
     * @param response
     * @param result
     */
    public static void out(ServletResponse response, Result result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            Logger.error(e + "输出JSON出错");
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 响应内容
     * @param httpServletResponse
     * @param msg
     * @param status
     */
    public static void getResponse(HttpServletResponse httpServletResponse, String msg, Integer status){
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            Result r=new Result();
            r.message(msg);
            r.code(status+"");
            writer.print(JSONObject.toJSONString(r));
        } catch (IOException e) {
            Logger.error("响应报错", e.getMessage());
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

}
