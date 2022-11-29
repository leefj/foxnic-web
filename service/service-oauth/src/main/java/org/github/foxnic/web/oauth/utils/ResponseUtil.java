package org.github.foxnic.web.oauth.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.foxnic.api.transter.Result;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

	public static void writeOK(HttpServletResponse response, String html) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("utf-8");
		response.setContentType(MediaType.TEXT_HTML_VALUE);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(html);
		printWriter.flush();
		printWriter.close();
	}



}
