package com.example.projetobank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class ProjetobankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetobankApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Ola";
	}

}
