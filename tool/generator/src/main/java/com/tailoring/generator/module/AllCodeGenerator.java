package com.tailoring.generator.module;

public class AllCodeGenerator {

	public static void main(String[] args) throws Exception {
		SysCodeGenerator.main(args);
		CrmCodeGenerator.main(args);
		PrdCodeGenerator.main(args);
		OdrCodeGenerator.main(args);
	}
	
}
