package com.scientific.tailoring.system.service;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.system.User;
import com.scientific.tailoring.domain.system.UserEditModel;
import com.scientific.tailoring.domain.system.UserVO;
import com.scientific.tailoring.domain.system.meta.UserMeta;
/**
 * <p>
 * 用户表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-03-28 05:57:35
*/


public interface IUserService extends ISuperService<User> {
 
	/**
	 * 按主键删除用户
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , User对象
	 */
	boolean deleteByIdPhysical(Long id);

	/**
	 * 按主键删除用户
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , User对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取用户
	 *
	 * @param id ID
	 * @return 查询结果 , User对象
	 */
	User getById(Long id);

	/**
	 * 按主键获取用户
	 *
	 * @param id ID
	 * @param keepPaswd 是否保留密码
	 * @return 查询结果 , User对象
	 */
	User getById(Long id,boolean keepPaswd);
	
	UserEditModel getUserEditModel(Long id);
	
	/**
	 * 用户是否已经存在
	 * @param exceptSelf  是否排除当前对象，以主键判定
	 * */
	Result<User> isUserExists(User user);
	
	boolean updateEntity(UserVO entity);

	void resetPasswd(Long id);

	boolean insertEntityAndRole(UserVO userVO);
	
	 

}