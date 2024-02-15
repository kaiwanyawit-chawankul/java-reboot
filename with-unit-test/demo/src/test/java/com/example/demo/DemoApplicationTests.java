package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.demo.domain.*;
@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Company company = context.getBean("company", Company.class);
		//Company company = new Company(new Address("Hight Street", 1000));
		assertEquals("High Street", company.getAddress().getStreet());
		assertEquals(1000, company.getAddress().getNumber());
	}

}
