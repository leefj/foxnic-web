package com.scientific.tailoring.domain.order.meta;

import com.scientific.tailoring.domain.order.MeasureData;
import java.util.Date;
import java.math.BigDecimal;



/**
 * @author 李方捷
 * @since 2021-05-17 01:24:39
 * @sign D30E522BC5ED8CC0B20E09EA17724260
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeasureDataMeta {
	
	/**
	 * ID
	*/
	public static final String ID="id";
	
	/**
	 * 测量ID
	*/
	public static final String MEASURE_ID="measureId";
	
	/**
	 * 创建人ID
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建时间
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 修改人ID
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改时间
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 是否已删除
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 删除人ID
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除时间
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 数据版本号
	*/
	public static final String VERSION="version";
	
	/**
	 * 测量类型 , 净体 body , 着装 outfit
	*/
	public static final String RESULT_TYPE="resultType";
	
	/**
	 * 领围
	*/
	public static final String LING_WEI="lingWei";
	
	/**
	 * 胸围
	*/
	public static final String XIONG_WEI="xiongWei";
	
	/**
	 * 腰围
	*/
	public static final String YAO_WEI="yaoWei";
	
	/**
	 * 腹围
	*/
	public static final String FU_WEI="fuWei";
	
	/**
	 * 右上臂围
	*/
	public static final String YOU_SHANG_BI_WEI="youShangBiWei";
	
	/**
	 * 右下臂围
	*/
	public static final String YOU_XIA_BI_WEI="youXiaBiWei";
	
	/**
	 * 左上臂围
	*/
	public static final String ZUO_SHANG_BI_WEI="zuoShangBiWei";
	
	/**
	 * 左下臂围
	*/
	public static final String ZUO_XIA_BI_WEI="zuoXiaBiWei";
	
	/**
	 * 右上腿围
	*/
	public static final String YOU_SHANG_TUI_WEI="youShangTuiWei";
	
	/**
	 * 右下腿围
	*/
	public static final String YOU_XIA_TUI_WEI="youXiaTuiWei";
	
	/**
	 * 左上腿围
	*/
	public static final String ZUO_SHANG_TUI_WEI="zuoShangTuiWei";
	
	/**
	 * 左下腿围
	*/
	public static final String ZUO_XIA_TUI_WEI="zuoXiaTuiWei";
	
	/**
	 * 身高
	*/
	public static final String SHEN_GAO="shenGao";
	
	/**
	 * 肩宽
	*/
	public static final String JIAN_KUAN="jianKuan";
	
	/**
	 * 背长
	*/
	public static final String BEI_CHANG="beiChang";
	
	/**
	 * 颈椎点高
	*/
	public static final String JING_ZHUI_DIAN_GAO="jingZhuiDianGao";
	
	/**
	 * 腰围高
	*/
	public static final String YAO_WEI_GAO="yaoWeiGao";
	
	/**
	 * 臀高
	*/
	public static final String TUN_GAO="tunGao";
	
	/**
	 * 臀围
	*/
	public static final String TUN_WEI="tunWei";
	
	/**
	 * 裤长
	*/
	public static final String KU_CHANG="kuChang";
	
	/**
	 * 左臂长
	*/
	public static final String ZUO_BI_CHANG="zuoBiChang";
	
	/**
	 * 右臂长
	*/
	public static final String YOU_BI_CHANG="youBiChang";
	
	/**
	 * 右上臂长
	*/
	public static final String YOU_SHANG_BI_CHANG="youShangBiChang";
	
	/**
	 * 右下臂长
	*/
	public static final String YOU_XIA_BI_CHANG="youXiaBiChang";
	
	/**
	 * 左上臂长
	*/
	public static final String ZUO_SHANG_BI_CHANG="zuoShangBiChang";
	
	/**
	 * 左下臂长
	*/
	public static final String ZUO_XIA_BI_CHANG="zuoXiaBiChang";
	
	/**
	 * 右腿长
	*/
	public static final String YOU_TUI_CHANG="youTuiChang";
	
	/**
	 * 左腿长
	*/
	public static final String ZUO_TUI_CHANG="zuoTuiChang";
	
	/**
	 * 右上腿长
	*/
	public static final String YOU_SHANG_TUI_CHANG="youShangTuiChang";
	
	/**
	 * 右下腿长
	*/
	public static final String YOU_XIA_TUI_CHANG="youXiaTuiChang";
	
	/**
	 * 左上腿长
	*/
	public static final String ZUO_SHANG_TUI_CHANG="zuoShangTuiChang";
	
	/**
	 * 左下腿长
	*/
	public static final String ZUO_XIA_TUI_CHANG="zuoXiaTuiChang";
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MEASURE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , RESULT_TYPE , LING_WEI , XIONG_WEI , YAO_WEI , FU_WEI , YOU_SHANG_BI_WEI , YOU_XIA_BI_WEI , ZUO_SHANG_BI_WEI , ZUO_XIA_BI_WEI , YOU_SHANG_TUI_WEI , YOU_XIA_TUI_WEI , ZUO_SHANG_TUI_WEI , ZUO_XIA_TUI_WEI , SHEN_GAO , JIAN_KUAN , BEI_CHANG , JING_ZHUI_DIAN_GAO , YAO_WEI_GAO , TUN_GAO , TUN_WEI , KU_CHANG , ZUO_BI_CHANG , YOU_BI_CHANG , YOU_SHANG_BI_CHANG , YOU_XIA_BI_CHANG , ZUO_SHANG_BI_CHANG , ZUO_XIA_BI_CHANG , YOU_TUI_CHANG , ZUO_TUI_CHANG , YOU_SHANG_TUI_CHANG , YOU_XIA_TUI_CHANG , ZUO_SHANG_TUI_CHANG , ZUO_XIA_TUI_CHANG };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.scientific.tailoring.domain.order.MeasureData {
		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public MeasureData setId(Long id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 测量ID
		 * @param measureId 测量ID
		 * @return 当前对象
		*/
		public MeasureData setMeasureId(Long measureId) {
			super.change(MEASURE_ID,super.getMeasureId(),measureId);
			super.setMeasureId(measureId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MeasureData setCreateBy(Long createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MeasureData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MeasureData setUpdateBy(Long updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MeasureData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MeasureData setDeleted(Boolean deleted) {
			super.change(DELETED,super.isDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MeasureData setDeleteBy(Long deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MeasureData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public MeasureData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 测量类型
		 * @param resultType 测量类型
		 * @return 当前对象
		*/
		public MeasureData setResultType(String resultType) {
			super.change(RESULT_TYPE,super.getResultType(),resultType);
			super.setResultType(resultType);
			return this;
		}
		
		/**
		 * 设置 领围
		 * @param lingWei 领围
		 * @return 当前对象
		*/
		public MeasureData setLingWei(BigDecimal lingWei) {
			super.change(LING_WEI,super.getLingWei(),lingWei);
			super.setLingWei(lingWei);
			return this;
		}
		
		/**
		 * 设置 胸围
		 * @param xiongWei 胸围
		 * @return 当前对象
		*/
		public MeasureData setXiongWei(BigDecimal xiongWei) {
			super.change(XIONG_WEI,super.getXiongWei(),xiongWei);
			super.setXiongWei(xiongWei);
			return this;
		}
		
		/**
		 * 设置 腰围
		 * @param yaoWei 腰围
		 * @return 当前对象
		*/
		public MeasureData setYaoWei(BigDecimal yaoWei) {
			super.change(YAO_WEI,super.getYaoWei(),yaoWei);
			super.setYaoWei(yaoWei);
			return this;
		}
		
		/**
		 * 设置 腹围
		 * @param fuWei 腹围
		 * @return 当前对象
		*/
		public MeasureData setFuWei(BigDecimal fuWei) {
			super.change(FU_WEI,super.getFuWei(),fuWei);
			super.setFuWei(fuWei);
			return this;
		}
		
		/**
		 * 设置 右上臂围
		 * @param youShangBiWei 右上臂围
		 * @return 当前对象
		*/
		public MeasureData setYouShangBiWei(BigDecimal youShangBiWei) {
			super.change(YOU_SHANG_BI_WEI,super.getYouShangBiWei(),youShangBiWei);
			super.setYouShangBiWei(youShangBiWei);
			return this;
		}
		
		/**
		 * 设置 右下臂围
		 * @param youXiaBiWei 右下臂围
		 * @return 当前对象
		*/
		public MeasureData setYouXiaBiWei(BigDecimal youXiaBiWei) {
			super.change(YOU_XIA_BI_WEI,super.getYouXiaBiWei(),youXiaBiWei);
			super.setYouXiaBiWei(youXiaBiWei);
			return this;
		}
		
		/**
		 * 设置 左上臂围
		 * @param zuoShangBiWei 左上臂围
		 * @return 当前对象
		*/
		public MeasureData setZuoShangBiWei(BigDecimal zuoShangBiWei) {
			super.change(ZUO_SHANG_BI_WEI,super.getZuoShangBiWei(),zuoShangBiWei);
			super.setZuoShangBiWei(zuoShangBiWei);
			return this;
		}
		
		/**
		 * 设置 左下臂围
		 * @param zuoXiaBiWei 左下臂围
		 * @return 当前对象
		*/
		public MeasureData setZuoXiaBiWei(BigDecimal zuoXiaBiWei) {
			super.change(ZUO_XIA_BI_WEI,super.getZuoXiaBiWei(),zuoXiaBiWei);
			super.setZuoXiaBiWei(zuoXiaBiWei);
			return this;
		}
		
		/**
		 * 设置 右上腿围
		 * @param youShangTuiWei 右上腿围
		 * @return 当前对象
		*/
		public MeasureData setYouShangTuiWei(BigDecimal youShangTuiWei) {
			super.change(YOU_SHANG_TUI_WEI,super.getYouShangTuiWei(),youShangTuiWei);
			super.setYouShangTuiWei(youShangTuiWei);
			return this;
		}
		
		/**
		 * 设置 右下腿围
		 * @param youXiaTuiWei 右下腿围
		 * @return 当前对象
		*/
		public MeasureData setYouXiaTuiWei(BigDecimal youXiaTuiWei) {
			super.change(YOU_XIA_TUI_WEI,super.getYouXiaTuiWei(),youXiaTuiWei);
			super.setYouXiaTuiWei(youXiaTuiWei);
			return this;
		}
		
		/**
		 * 设置 左上腿围
		 * @param zuoShangTuiWei 左上腿围
		 * @return 当前对象
		*/
		public MeasureData setZuoShangTuiWei(BigDecimal zuoShangTuiWei) {
			super.change(ZUO_SHANG_TUI_WEI,super.getZuoShangTuiWei(),zuoShangTuiWei);
			super.setZuoShangTuiWei(zuoShangTuiWei);
			return this;
		}
		
		/**
		 * 设置 左下腿围
		 * @param zuoXiaTuiWei 左下腿围
		 * @return 当前对象
		*/
		public MeasureData setZuoXiaTuiWei(BigDecimal zuoXiaTuiWei) {
			super.change(ZUO_XIA_TUI_WEI,super.getZuoXiaTuiWei(),zuoXiaTuiWei);
			super.setZuoXiaTuiWei(zuoXiaTuiWei);
			return this;
		}
		
		/**
		 * 设置 身高
		 * @param shenGao 身高
		 * @return 当前对象
		*/
		public MeasureData setShenGao(BigDecimal shenGao) {
			super.change(SHEN_GAO,super.getShenGao(),shenGao);
			super.setShenGao(shenGao);
			return this;
		}
		
		/**
		 * 设置 肩宽
		 * @param jianKuan 肩宽
		 * @return 当前对象
		*/
		public MeasureData setJianKuan(BigDecimal jianKuan) {
			super.change(JIAN_KUAN,super.getJianKuan(),jianKuan);
			super.setJianKuan(jianKuan);
			return this;
		}
		
		/**
		 * 设置 背长
		 * @param beiChang 背长
		 * @return 当前对象
		*/
		public MeasureData setBeiChang(BigDecimal beiChang) {
			super.change(BEI_CHANG,super.getBeiChang(),beiChang);
			super.setBeiChang(beiChang);
			return this;
		}
		
		/**
		 * 设置 颈椎点高
		 * @param jingZhuiDianGao 颈椎点高
		 * @return 当前对象
		*/
		public MeasureData setJingZhuiDianGao(BigDecimal jingZhuiDianGao) {
			super.change(JING_ZHUI_DIAN_GAO,super.getJingZhuiDianGao(),jingZhuiDianGao);
			super.setJingZhuiDianGao(jingZhuiDianGao);
			return this;
		}
		
		/**
		 * 设置 腰围高
		 * @param yaoWeiGao 腰围高
		 * @return 当前对象
		*/
		public MeasureData setYaoWeiGao(BigDecimal yaoWeiGao) {
			super.change(YAO_WEI_GAO,super.getYaoWeiGao(),yaoWeiGao);
			super.setYaoWeiGao(yaoWeiGao);
			return this;
		}
		
		/**
		 * 设置 臀高
		 * @param tunGao 臀高
		 * @return 当前对象
		*/
		public MeasureData setTunGao(BigDecimal tunGao) {
			super.change(TUN_GAO,super.getTunGao(),tunGao);
			super.setTunGao(tunGao);
			return this;
		}
		
		/**
		 * 设置 臀围
		 * @param tunWei 臀围
		 * @return 当前对象
		*/
		public MeasureData setTunWei(BigDecimal tunWei) {
			super.change(TUN_WEI,super.getTunWei(),tunWei);
			super.setTunWei(tunWei);
			return this;
		}
		
		/**
		 * 设置 裤长
		 * @param kuChang 裤长
		 * @return 当前对象
		*/
		public MeasureData setKuChang(BigDecimal kuChang) {
			super.change(KU_CHANG,super.getKuChang(),kuChang);
			super.setKuChang(kuChang);
			return this;
		}
		
		/**
		 * 设置 左臂长
		 * @param zuoBiChang 左臂长
		 * @return 当前对象
		*/
		public MeasureData setZuoBiChang(BigDecimal zuoBiChang) {
			super.change(ZUO_BI_CHANG,super.getZuoBiChang(),zuoBiChang);
			super.setZuoBiChang(zuoBiChang);
			return this;
		}
		
		/**
		 * 设置 右臂长
		 * @param youBiChang 右臂长
		 * @return 当前对象
		*/
		public MeasureData setYouBiChang(BigDecimal youBiChang) {
			super.change(YOU_BI_CHANG,super.getYouBiChang(),youBiChang);
			super.setYouBiChang(youBiChang);
			return this;
		}
		
		/**
		 * 设置 右上臂长
		 * @param youShangBiChang 右上臂长
		 * @return 当前对象
		*/
		public MeasureData setYouShangBiChang(BigDecimal youShangBiChang) {
			super.change(YOU_SHANG_BI_CHANG,super.getYouShangBiChang(),youShangBiChang);
			super.setYouShangBiChang(youShangBiChang);
			return this;
		}
		
		/**
		 * 设置 右下臂长
		 * @param youXiaBiChang 右下臂长
		 * @return 当前对象
		*/
		public MeasureData setYouXiaBiChang(BigDecimal youXiaBiChang) {
			super.change(YOU_XIA_BI_CHANG,super.getYouXiaBiChang(),youXiaBiChang);
			super.setYouXiaBiChang(youXiaBiChang);
			return this;
		}
		
		/**
		 * 设置 左上臂长
		 * @param zuoShangBiChang 左上臂长
		 * @return 当前对象
		*/
		public MeasureData setZuoShangBiChang(BigDecimal zuoShangBiChang) {
			super.change(ZUO_SHANG_BI_CHANG,super.getZuoShangBiChang(),zuoShangBiChang);
			super.setZuoShangBiChang(zuoShangBiChang);
			return this;
		}
		
		/**
		 * 设置 左下臂长
		 * @param zuoXiaBiChang 左下臂长
		 * @return 当前对象
		*/
		public MeasureData setZuoXiaBiChang(BigDecimal zuoXiaBiChang) {
			super.change(ZUO_XIA_BI_CHANG,super.getZuoXiaBiChang(),zuoXiaBiChang);
			super.setZuoXiaBiChang(zuoXiaBiChang);
			return this;
		}
		
		/**
		 * 设置 右腿长
		 * @param youTuiChang 右腿长
		 * @return 当前对象
		*/
		public MeasureData setYouTuiChang(BigDecimal youTuiChang) {
			super.change(YOU_TUI_CHANG,super.getYouTuiChang(),youTuiChang);
			super.setYouTuiChang(youTuiChang);
			return this;
		}
		
		/**
		 * 设置 左腿长
		 * @param zuoTuiChang 左腿长
		 * @return 当前对象
		*/
		public MeasureData setZuoTuiChang(BigDecimal zuoTuiChang) {
			super.change(ZUO_TUI_CHANG,super.getZuoTuiChang(),zuoTuiChang);
			super.setZuoTuiChang(zuoTuiChang);
			return this;
		}
		
		/**
		 * 设置 右上腿长
		 * @param youShangTuiChang 右上腿长
		 * @return 当前对象
		*/
		public MeasureData setYouShangTuiChang(BigDecimal youShangTuiChang) {
			super.change(YOU_SHANG_TUI_CHANG,super.getYouShangTuiChang(),youShangTuiChang);
			super.setYouShangTuiChang(youShangTuiChang);
			return this;
		}
		
		/**
		 * 设置 右下腿长
		 * @param youXiaTuiChang 右下腿长
		 * @return 当前对象
		*/
		public MeasureData setYouXiaTuiChang(BigDecimal youXiaTuiChang) {
			super.change(YOU_XIA_TUI_CHANG,super.getYouXiaTuiChang(),youXiaTuiChang);
			super.setYouXiaTuiChang(youXiaTuiChang);
			return this;
		}
		
		/**
		 * 设置 左上腿长
		 * @param zuoShangTuiChang 左上腿长
		 * @return 当前对象
		*/
		public MeasureData setZuoShangTuiChang(BigDecimal zuoShangTuiChang) {
			super.change(ZUO_SHANG_TUI_CHANG,super.getZuoShangTuiChang(),zuoShangTuiChang);
			super.setZuoShangTuiChang(zuoShangTuiChang);
			return this;
		}
		
		/**
		 * 设置 左下腿长
		 * @param zuoXiaTuiChang 左下腿长
		 * @return 当前对象
		*/
		public MeasureData setZuoXiaTuiChang(BigDecimal zuoXiaTuiChang) {
			super.change(ZUO_XIA_TUI_CHANG,super.getZuoXiaTuiChang(),zuoXiaTuiChang);
			super.setZuoXiaTuiChang(zuoXiaTuiChang);
			return this;
		}
}
}