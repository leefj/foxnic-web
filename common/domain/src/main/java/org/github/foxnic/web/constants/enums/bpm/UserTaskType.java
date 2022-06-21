package org.github.foxnic.web.constants.enums.bpm;

import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.reflect.EnumUtil;

public enum UserTaskType implements CodeTextEnum {

	regular("或审",false),countersign_parallel("会审(并行)",true),countersign_sequence("会审(顺序)",true),countersign_loop("循环",false);

	private  boolean  countersign=false;
	private String text;
	private UserTaskType(String text,boolean countersign)  {
		this.text=text;
		this.countersign=countersign;
	}

	/**
	 * 是否会签
	 * */
	public boolean countersign() {
		return countersign;
	}

	public String code() {
		return this.name();
	}

	public String text() {
		return text;
	}

	public static UserTaskType parseByCode(String code) {
		return (UserTaskType) EnumUtil.parseByCode(UserTaskType.values(),code);
	}







}
