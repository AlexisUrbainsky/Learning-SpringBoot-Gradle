package com.alexis.HelloWordSpringBoot;

import java.util.Arrays;
import java.util.HashMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloWordSpringBootApplication {

	public static HashMap<Long, Person> hashPersons;
	
	public static void main(String[] args) {
		hashPersons = new HashMap<Long, Person>();
		
		Person p1 = new Person("Alexis","Urbainsky","M");
		hashPersons.put(p1.getId(), p1);
		
		SpringApplication.run(HelloWordSpringBootApplication.class, args);
		
		Person p2 = new Person("Micaela","Campusano","F");
		hashPersons.put(p2.getId(), p2);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		
		return args ->{
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			
			for(String beanName: beanNames ) {
				System.out.println(beanName);
			}
		};
		
	}
	
	
}
