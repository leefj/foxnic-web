package com.scientific.tailoring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scientific.tailoring.framework.starter.CloudApplication;

@SpringBootApplication
public class TailoringApp {
	public static void main(String[] args) {
		CloudApplication.run(TailoringApp.class, args);
	}
}
