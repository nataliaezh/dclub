package com.hedgehogs.dclub;

import com.hedgehogs.dclub.model.Product;
import com.hedgehogs.dclub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DclubApplication {
	public static void main(String[] args) {
		SpringApplication.run(DclubApplication.class, args);
	}

}
