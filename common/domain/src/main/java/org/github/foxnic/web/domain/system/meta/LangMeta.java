package org.github.foxnic.web.domain.system.meta;

import com.github.foxnic.api.bean.BeanProperty;
import org.github.foxnic.web.domain.system.Lang;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-11-02 16:57:31
 * @sign E85D3CEDBBC451ED453DD8A0A304F635
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LangMeta {
	
	/**
	 * 编码键 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码键 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> CODE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,CODE, java.lang.String.class, "编码键", "编码键", java.lang.String.class, null);
	
	/**
	 * 默认 , 类型: java.lang.String
	*/
	public static final String DEFAULTS="defaults";
	
	/**
	 * 默认 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> DEFAULTS_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,DEFAULTS, java.lang.String.class, "默认", "默认", java.lang.String.class, null);
	
	/**
	 * 简体中文 , 类型: java.lang.String
	*/
	public static final String ZH_CN="zhCn";
	
	/**
	 * 简体中文 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> ZH_CN_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,ZH_CN, java.lang.String.class, "简体中文", "简体中文", java.lang.String.class, null);
	
	/**
	 * 中文(台湾) , 类型: java.lang.String
	*/
	public static final String ZH_TW="zhTw";
	
	/**
	 * 中文(台湾) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> ZH_TW_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,ZH_TW, java.lang.String.class, "中文(台湾)", "中文(台湾)", java.lang.String.class, null);
	
	/**
	 * 英文美国 , 类型: java.lang.String
	*/
	public static final String EN_US="enUs";
	
	/**
	 * 英文美国 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> EN_US_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,EN_US, java.lang.String.class, "英文美国", "英文美国", java.lang.String.class, null);
	
	/**
	 * 英文英国 , 类型: java.lang.String
	*/
	public static final String EN_GB="enGb";
	
	/**
	 * 英文英国 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> EN_GB_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,EN_GB, java.lang.String.class, "英文英国", "英文英国", java.lang.String.class, null);
	
	/**
	 * 混淆专用 , 类型: java.lang.String
	*/
	public static final String CONFUSE="confuse";
	
	/**
	 * 混淆专用 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> CONFUSE_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,CONFUSE, java.lang.String.class, "混淆专用", "混淆专用", java.lang.String.class, null);
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final String VALID="valid";
	
	/**
	 * 是否有效 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.Integer> VALID_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,VALID, java.lang.Integer.class, "是否有效", "是否有效", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> CREATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.util.Date> CREATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> UPDATE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.Integer> DELETED_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> DELETE_BY_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.util.Date> DELETE_TIME_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.Integer> VERSION_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 中文(香港) , 类型: java.lang.String
	*/
	public static final String ZH_HK="zhHk";
	
	/**
	 * 中文(香港) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> ZH_HK_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,ZH_HK, java.lang.String.class, "中文(香港)", "中文(香港)", java.lang.String.class, null);
	
	/**
	 * 中文(澳门) , 类型: java.lang.String
	*/
	public static final String ZH_MO="zhMo";
	
	/**
	 * 中文(澳门) , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> ZH_MO_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,ZH_MO, java.lang.String.class, "中文(澳门)", "中文(澳门)", java.lang.String.class, null);
	
	/**
	 * 韩语 , 类型: java.lang.String
	*/
	public static final String KO_KR="koKr";
	
	/**
	 * 韩语 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> KO_KR_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,KO_KR, java.lang.String.class, "韩语", "韩语", java.lang.String.class, null);
	
	/**
	 * 日语 , 类型: java.lang.String
	*/
	public static final String JA_JP="jaJp";
	
	/**
	 * 日语 , 类型: java.lang.String
	*/
	public static final BeanProperty<org.github.foxnic.web.domain.system.Lang,java.lang.String> JA_JP_PROP = new BeanProperty(org.github.foxnic.web.domain.system.Lang.class ,JA_JP, java.lang.String.class, "日语", "日语", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ CODE , DEFAULTS , ZH_CN , ZH_TW , EN_US , EN_GB , CONFUSE , VALID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ZH_HK , ZH_MO , KO_KR , JA_JP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends org.github.foxnic.web.domain.system.Lang {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 编码键
		 * @param code 编码键
		 * @return 当前对象
		*/
		public Lang setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 默认
		 * @param defaults 默认
		 * @return 当前对象
		*/
		public Lang setDefaults(String defaults) {
			super.change(DEFAULTS,super.getDefaults(),defaults);
			super.setDefaults(defaults);
			return this;
		}
		
		/**
		 * 设置 简体中文
		 * @param zhCn 简体中文
		 * @return 当前对象
		*/
		public Lang setZhCn(String zhCn) {
			super.change(ZH_CN,super.getZhCn(),zhCn);
			super.setZhCn(zhCn);
			return this;
		}
		
		/**
		 * 设置 中文(台湾)
		 * @param zhTw 中文(台湾)
		 * @return 当前对象
		*/
		public Lang setZhTw(String zhTw) {
			super.change(ZH_TW,super.getZhTw(),zhTw);
			super.setZhTw(zhTw);
			return this;
		}
		
		/**
		 * 设置 英文美国
		 * @param enUs 英文美国
		 * @return 当前对象
		*/
		public Lang setEnUs(String enUs) {
			super.change(EN_US,super.getEnUs(),enUs);
			super.setEnUs(enUs);
			return this;
		}
		
		/**
		 * 设置 英文英国
		 * @param enGb 英文英国
		 * @return 当前对象
		*/
		public Lang setEnGb(String enGb) {
			super.change(EN_GB,super.getEnGb(),enGb);
			super.setEnGb(enGb);
			return this;
		}
		
		/**
		 * 设置 混淆专用
		 * @param confuse 混淆专用
		 * @return 当前对象
		*/
		public Lang setConfuse(String confuse) {
			super.change(CONFUSE,super.getConfuse(),confuse);
			super.setConfuse(confuse);
			return this;
		}
		
		/**
		 * 设置 是否有效
		 * @param valid 是否有效
		 * @return 当前对象
		*/
		public Lang setValid(Integer valid) {
			super.change(VALID,super.getValid(),valid);
			super.setValid(valid);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Lang setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Lang setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Lang setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Lang setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Lang setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Lang setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Lang setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Lang setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 中文(香港)
		 * @param zhHk 中文(香港)
		 * @return 当前对象
		*/
		public Lang setZhHk(String zhHk) {
			super.change(ZH_HK,super.getZhHk(),zhHk);
			super.setZhHk(zhHk);
			return this;
		}
		
		/**
		 * 设置 中文(澳门)
		 * @param zhMo 中文(澳门)
		 * @return 当前对象
		*/
		public Lang setZhMo(String zhMo) {
			super.change(ZH_MO,super.getZhMo(),zhMo);
			super.setZhMo(zhMo);
			return this;
		}
		
		/**
		 * 设置 韩语
		 * @param koKr 韩语
		 * @return 当前对象
		*/
		public Lang setKoKr(String koKr) {
			super.change(KO_KR,super.getKoKr(),koKr);
			super.setKoKr(koKr);
			return this;
		}
		
		/**
		 * 设置 日语
		 * @param jaJp 日语
		 * @return 当前对象
		*/
		public Lang setJaJp(String jaJp) {
			super.change(JA_JP,super.getJaJp(),jaJp);
			super.setJaJp(jaJp);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Lang clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Lang duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setZhCn(this.getZhCn());
			inst.setCode(this.getCode());
			inst.setZhTw(this.getZhTw());
			inst.setEnUs(this.getEnUs());
			inst.setZhHk(this.getZhHk());
			inst.setZhMo(this.getZhMo());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setEnGb(this.getEnGb());
			inst.setJaJp(this.getJaJp());
			inst.setVersion(this.getVersion());
			inst.setValid(this.getValid());
			inst.setConfuse(this.getConfuse());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDefaults(this.getDefaults());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setKoKr(this.getKoKr());
			inst.clearModifies();
			return inst;
		}

	}
}