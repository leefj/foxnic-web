package org.github.foxnic.web.constants.enums.job;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

/**
 * 任务丢失的执行策略
 * */
public enum MisfirePolicy implements CodeTextEnum {

	/**
	 * 立即执行第一个发生misfire的任务，忽略其他发生misfire的任务，然后按照原计划继续执行。
	 * 例如：在10:15立即执行9:00任务，忽略10:00任务，然后等待下一个任务在11:00执行，后续按照原计划执行。
	 * */
	ONCE_NOW("就绪后，执行最后一个丢失的任务"),
	/**
	 * 立即执行所有发生了misfire的任务，然后按照原计划进行执行。
	 * */
	IGNORE_MISFIRES("就绪后，执行所有丢失的任务"),
	/**
	 * 所有发生misfire的任务都被忽略，只是按照原计划继续执行。
	 * */
	DO_NOTHING("就绪后，不执行已丢失的任务")
	;
	private String text;

	private MisfirePolicy(String text) {
		this.text=text;
	}

	public String code() {
		return this.name().toLowerCase();
	}

	public String text() {
		return this.text;
	}

	public static MisfirePolicy parseByCode(String code) {
		return (MisfirePolicy) EnumUtil.parseByCode(MisfirePolicy.values(),code);
	}
}
