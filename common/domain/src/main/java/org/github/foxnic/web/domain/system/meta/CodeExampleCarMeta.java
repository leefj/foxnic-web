package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.CodeExampleCar;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-22 08:53:46
 * @sign 9E7731103783872C579AD050FA29D1B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeExampleCarMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final String EXAMPLE_ID="exampleId";
	
	/**
	 * 属主ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> EXAMPLE_ID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,EXAMPLE_ID, java.lang.String.class, "属主ID", "属主ID", java.lang.String.class, null);
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final String PLATE_NUMBER="plateNumber";
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> PLATE_NUMBER_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,PLATE_NUMBER, java.lang.String.class, "车牌号", "车牌号", java.lang.String.class, null);
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final String COLOR="color";
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.String> COLOR_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,COLOR, java.lang.String.class, "颜色", "颜色", java.lang.String.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.CodeExampleCar,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.CodeExampleCar.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , EXAMPLE_ID , PLATE_NUMBER , COLOR , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.CodeExampleCar {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CodeExampleCar setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 属主ID
		 * @param exampleId 属主ID
		 * @return 当前对象
		*/
		public CodeExampleCar setExampleId(String exampleId) {
			super.change(EXAMPLE_ID,super.getExampleId(),exampleId);
			super.setExampleId(exampleId);
			return this;
		}
		
		/**
		 * 设置 车牌号
		 * @param plateNumber 车牌号
		 * @return 当前对象
		*/
		public CodeExampleCar setPlateNumber(String plateNumber) {
			super.change(PLATE_NUMBER,super.getPlateNumber(),plateNumber);
			super.setPlateNumber(plateNumber);
			return this;
		}
		
		/**
		 * 设置 颜色
		 * @param color 颜色
		 * @return 当前对象
		*/
		public CodeExampleCar setColor(String color) {
			super.change(COLOR,super.getColor(),color);
			super.setColor(color);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public CodeExampleCar setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}