package com.scientific.tailoring.product.service;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.domain.product.VirtualLibrary;
import com.scientific.tailoring.domain.product.VirtualLibraryModel;
import com.scientific.tailoring.domain.product.VirtualLibraryVO;
import com.scientific.tailoring.domain.product.meta.VirtualLibraryMeta;
/**
 * <p>
 * 虚拟试衣表 服务接口
 * </p>
 * @author 李方捷
 * @since 2021-04-08 03:46:44
*/

public interface IVirtualLibraryService extends ISuperService<VirtualLibrary> {
 
	/**
	 * 按主键删除虚拟试衣
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualLibrary对象
	 */
	boolean deleteByIdPhysical(Long id);
	
	/**
	 * 按主键删除虚拟试衣
	 *
	 * @param id ID , 详情 : ID
	 * @return 查询结果 , VirtualLibrary对象
	 */
	boolean deleteByIdLogical(Long id);
	
	/**
	 * 按主键获取虚拟试衣
	 *
	 * @param id ID
	 * @return 查询结果 , VirtualLibrary对象
	 */
	VirtualLibrary getById(Long id);
	
	/**
	 * 检查 虚拟试衣 是否已经存在
	 *
	 * @param virtualLibraryVO 数据对象
	 * @return 判断结果
	 */
	Result<VirtualLibrary> checkExists(VirtualLibraryVO virtualLibraryVO);

	PagedList<VirtualLibraryModel> queryPagedListModel(VirtualLibraryVO sample, Integer pageSize, Integer pageIndex);
 

}