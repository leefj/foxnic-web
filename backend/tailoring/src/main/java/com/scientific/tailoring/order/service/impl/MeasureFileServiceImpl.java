package com.scientific.tailoring.order.service.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.scientific.tailoring.constants.db.Tailoring.ODR_MEASURE;
import com.scientific.tailoring.constants.enums.dict.MeasureStatus;
import com.scientific.tailoring.domain.order.Body;
import com.scientific.tailoring.domain.order.Measure;
import com.scientific.tailoring.domain.order.MeasureFile;
import com.scientific.tailoring.framework.DBConfigs;
import com.scientific.tailoring.order.service.IBodyService;
import com.scientific.tailoring.order.service.IMeasureFileService;
import com.scientific.tailoring.order.service.IMeasureService;

/**
 * <p>
 * 测量文件采集表 服务实现类
 * </p>
 * @author 李方捷
 * @since 2021-03-25 08:57:39
*/

@Service("OdrMeasureFileServiceImpl")
public class MeasureFileServiceImpl extends SuperService<MeasureFile> implements IMeasureFileService {

	@Autowired
	private IBodyService bodyService;
	@Autowired
	private IMeasureService measureService;

	@Resource(name=DBConfigs.PRIMARY_DAO)
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }
	
	/**
	 * 按主键删除测量文件采集
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureFile对象
	 */
	public boolean deleteByIdPhysical(Integer id) {
		MeasureFile measureFile = new MeasureFile();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		measureFile.setId(id);
		return dao.deleteEntity(measureFile);
	}
	
	/**
	 * 按主键删除测量文件采集
	 *
	 * @param id id , 详情 : id
	 * @return 查询结果 , MeasureFile对象
	 */
	public boolean deleteByIdLogical(Integer id) {
		MeasureFile measureFile = new MeasureFile();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		measureFile.setId(id);
		measureFile.setDeleted(true);
		measureFile.setDeleteBy((Long)dao.getDBTreaty().getLoginUserId());
		measureFile.setDeleteTime(new Date());
		return dao.updateEntity(measureFile,SaveMode.NOT_NULL_FIELDS);
	}
	
	/**
	 * 按主键获取测量文件采集
	 *
	 * @param id id
	 * @return 查询结果 , MeasureFile对象
	 */
	public MeasureFile getById(Integer id) {
		MeasureFile sample = new MeasureFile();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null 。");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public boolean insertFiles(Long bodyId,List<MeasureFile> measureFileVOs) {
 
		//是否存在待测量的
		Long measureId=dao().queryLong("select id from "+ODR_MEASURE.$NAME+" where deleted=0 and "+ODR_MEASURE.BODY_ID+"=? and status in(?,?)",bodyId,MeasureStatus.TODO.code(),MeasureStatus.DONE.code());
		if(measureId==null) {
			Body body=bodyService.getById(bodyId);
			Measure measure=new Measure();
			measure.setOrderId(body.getOrderId());
			measure.setBodyId(body.getId());
			measure.setStatus(MeasureStatus.TODO.code());
			measureService.insert(measure);
			measureId=measure.getId();
		}
		final Long mid=measureId;
		measureFileVOs.forEach(f->{
			f.setMeasureId(mid);
			f.setProcessed(0);
			this.insert(f);
		});
		
		int unprocessdImageCount=dao.queryInteger("select count(1) from "+table() +" where measure_id=? and deleted=0 and type='image' and processed=0",measureId);
		int unprocessedVideoCount=dao.queryInteger("select count(1) from "+table() +" where measure_id=? and deleted=0 and type='video' and processed=0",measureId);
//		int processedImageCount=dao.queryInteger("select count(1) from "+table() +" where measure_id=? and deleted=0 and type='image' and processed=1",measureId);
//		int processedVideoCount=dao.queryInteger("select count(1) from "+table() +" where measure_id=? and deleted=0 and type='video' and processed=1",measureId);

		Measure m=measureService.getById(measureId);
		String status=m.getStatus();
		
		//如果数据已出，上传一个新文件后，改为已上报
		if("report".equals(status)) {
			measureService.updateStatus(measureId,"done");
		}
		//如果当前状态是已上报，则不变
		else if("done".equals(status)) {
			measureService.updateStatus(measureId,"done");
		}
		//如果未上报，待文件上齐后改为已上报
		else if("todo".equals(status)) {
			if(  unprocessdImageCount>=2 && unprocessedVideoCount>=1) {
				measureService.updateStatus(measureId,"done");
			}
		}
 
		return true;
	}

}