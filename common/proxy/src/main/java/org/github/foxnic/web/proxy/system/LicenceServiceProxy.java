package org.github.foxnic.web.proxy.system;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.domain.system.Lang;
import org.github.foxnic.web.domain.system.LangVO;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.MicroServiceNames;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 许可证表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-17 11:58:03
 * @version
*/

@FeignClient(value = MicroServiceNames.SYSTEM, contextId = LicenceServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface LicenceServiceProxy {

	/**
	 * 基础路径 , service-system
	*/
	public static final String API_BASIC_PATH = "service-system";

	/**
	 * API 上下文路径 , sys-lang
	*/
	public static final String API_CONTEXT_PATH = "sys-licence";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 导入许可证
	 */
	public static final String IMPORT = API_PREFIX + "import";

	/**
	 * 获得许可证信息
	 */
	public static final String GET = API_PREFIX + "get";

	/**
	 * 获取语言条目
	 */
	@RequestMapping(LicenceServiceProxy.GET)
	Result<JSONObject> get();

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="org.github.foxnic.web.system.controller.LicenceController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static LicenceServiceProxy api() {
		return APIProxy.get(LicenceServiceProxy.class,CONTROLLER_CLASS_NAME);
	}



}
