package com.flohmarkt.fm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmApplication.class, args);
	}

	@RestController
	public class HalloWeltController{
		@GetMapping("/hallo")
		public String hallo(){
			return "hallo !";
		}
		@GetMapping("/tschüs")
		public String tschüs(){
			return "tschüs";
		}
	}
}
