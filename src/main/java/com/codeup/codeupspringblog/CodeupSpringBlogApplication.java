package com.codeup.codeupspringblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class CodeupSpringBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeupSpringBlogApplication.class, args);
	}
	@Controller
	static
	class HelloController {

		@GetMapping("/hello")
		@ResponseBody
		public String hello() {
			return "Hello from Spring!";
		}
	}

	@GetMapping("/hello/{name}")
	@ResponseBody
	public String sayHello(@PathVariable String name) {
		return "Hello " + name + "!";
	}


}
