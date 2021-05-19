package com.scientific.tailoring.framework.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class SentinelExceptionUtil {
	
	public static final String HANDLER="exceptionHandler";
	
	/**
	    * @Description: 普通阻塞错误
	    * @param:
	    * @return:
	    * @author: fanjc
	    * @Date: 2019/5/10
	    */
	    public static   String exceptionHandler(BlockException ex) {
	        System.err.println("错误发生: " + ex.getClass().getCanonicalName());
	        return "error";
	    }

}
