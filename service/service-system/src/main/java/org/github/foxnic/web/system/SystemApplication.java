package org.github.foxnic.web.system;

import org.github.foxnic.web.framework.starter.CloudApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {
	public static void main(String[] args) {
		CloudApplication.run(SystemApplication.class, args);
	}
}
