package com.namNguyen03.resourceServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/*
create by: 	 Nguyen Duc Nam
email: 		 nam03031999@gmail.com
link github: https://github.com/NamNguyen03
create date: 01/08/2020 (mm/dd/yyyy) 
*/

@SpringBootApplication
@EnableTransactionManagement
public class ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceServerApplication.class, args);
	}

}
