package com.scientific.tailoring.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.github.foxnic.dao.data.PagedList;

public class FormSeletOption {
	
	private String name;
	private Object value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	public static <T> List<FormSeletOption> collect(PagedList<T> list,Function<? super T, String> name,Function<? super T, Object> value) {
		return collect(list.getList(),name,value);
	}
 
	public static <T> List<FormSeletOption> collect(List<T> list,Function<? super T, String> name,Function<? super T, Object> value) {
		List<FormSeletOption> opts=new ArrayList<>();
		list.forEach(e->{
			
			FormSeletOption opt=new FormSeletOption();
			opt.setName(name.apply(e));
			opt.setValue(value.apply(e));
			opts.add(opt);
			
		});
		return opts;
	}
	
	
	
}
