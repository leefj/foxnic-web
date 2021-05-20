package org.github.foxnic.web.system;

import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsoleApplication {
	public static void main(String[] args) {
		CloudApplication.run(ConsoleApplication.class, args);
	}
}
