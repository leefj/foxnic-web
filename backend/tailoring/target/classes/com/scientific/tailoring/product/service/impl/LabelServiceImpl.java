package com.scientific.tailoring.product.service.impl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.domain.product.Label;
import com.scientific.tailoring.domain.product.LabelNodeModel;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.product.service.ILabelService;

/**
 * <p>
 * 产品标签表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-18 11:06:19
*/

@Service("PrdLabelServiceImpl")
public class LabelServiceImpl extends SuperService<Label>implements ILabelService {
	
	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 生成主键值
	 * */
	@Override
	public Object generateId(Field field) {
		return null;
	}
	
	/**
	 * 按主键删除产品标签
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Label对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		Label label = new Label();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		label.setId(id);
		return dao.deleteEntity(label);
	}
	
	/**
	 * 按主键删除产品标签
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , Label对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		Label label = new Label();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		label.setId(id);
		label.setDeleted(true);
		return dao.updateEntity(label,SaveMode.NOT_NULL_FIELDS);
	}
 
	/**
	 * 按主键获取产品标签
	 *
	 * @param id id
	 * @return 查询结果 , Label对象
	 */
	public Label getById(Integer id) {
		Label sample = new Label();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<LabelNodeModel> getLabelTree(Long userId) {
		//查询所有节点
		List<Label> all=this.queryList(Label.create());
		List<LabelNodeModel> allm=new ArrayList<>();
		List<LabelNodeModel> roots=new ArrayList<>();
		all.forEach(m->{
			LabelNodeModel n=m.toPojo(LabelNodeModel.class);
			allm.add(n);
			if(m.getParentId()==0) {
				roots.add(n);
			}
		});
		//构架树形结构
		Map<Integer,LabelNodeModel> map= allm.stream().collect(Collectors.toMap(LabelNodeModel::getId, m->m));
		for (Map.Entry<Integer,LabelNodeModel> e : map.entrySet()) {
			LabelNodeModel p=map.get(e.getValue().getParentId());
			if(p!=null) {
				p.addSubLabel(e.getValue());
			}
		}

		return roots;
	}

}