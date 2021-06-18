package org.github.foxnic.web.oauth.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.github.foxnic.springboot.mvc.Result;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class ResponseUtil {

	public static void writeOK(HttpServletResponse response, Result rest) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("utf-8");
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		String resBody = JSON.toJSONString(rest,SerializerFeature.WriteDateUseDateFormat);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(resBody);
		printWriter.flush();
		printWriter.close();
	}
	
	 

}
