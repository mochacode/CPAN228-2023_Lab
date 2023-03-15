package com.cpan228.Assignment2;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cpan228.Assignment2.model.Item;
import com.cpan228.Assignment2.model.Item.Brand;
import com.cpan228.Assignment2.repository.ItemRepository;

/**
 * mvn spring-boot:run does following steps
 * 1. mvn clean
 * 2. mvn compile
 * 3. mvn package
 * 4. java -jar target/tekkenreborn-0.0.1-SNAPSHOT.jar
 * 5. deploys jar to embedded tomcat
 */
@SpringBootApplication
public class Assignment2Application {

	 /**
	 * This is the main method that starts the application
	 * Spring Application Context is created here
	 * You can configure your application properties using @param args
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Assignment2Application.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository) {
		return args -> {
			repository.save(Item.builder()
					.name("Silk Pajama Bottoms")
					.brandFrom(Brand.CHANEL)
					.year(2018)
					.price(new BigDecimal(84.00)).build());

			repository.save(Item.builder()
					.name("Silk Pajama Top")
					.brandFrom(Brand.CHANEL)
					.year(2018)
					.price(new BigDecimal(88.00)).build());

			repository.save(Item.builder()
					.name("Multi-Animal Print Bomber Coat")
					.brandFrom(Brand.DIOR)
					.year(2013)
					.price(new BigDecimal(247.00)).build());

			repository.save(Item.builder()
					.name("Signature Genuine Leather Tote Bag")
					.brandFrom(Brand.HERMES)
					.year(2019)
					.price(new BigDecimal(780.00)).build());

			repository.save(Item.builder()
					.name("Nude Cream Evening Gown")
					.brandFrom(Brand.DIOR)
					.year(2005)
					.price(new BigDecimal(157.00)).build());

			repository.save(Item.builder()
					.name("Woven Felt XL Trench Coat")
					.brandFrom(Brand.PRADA)
					.year(2000)
					.price(new BigDecimal(444.00)).build());

			repository.save(Item.builder()
					.name("Shear Light Knit Sweater")
					.brandFrom(Brand.HERMES)
					.year(2021)
					.price(new BigDecimal(79.00)).build());

			repository.save(Item.builder()
					.name("Mini Quartz Glass Belt Buckle")
					.brandFrom(Brand.LOUIS_VUITTON)
					.year(2002)
					.price(new BigDecimal(101.00)).build());

			repository.save(Item.builder()
					.name("Vivid Graphic Inner Jacket")
					.brandFrom(Brand.PRADA)
					.year(2012)
					.price(new BigDecimal(268.00)).build());

			repository.save(Item.builder()
					.name("Classic 90s Large Tote")
					.brandFrom(Brand.LOUIS_VUITTON)
					.year(2004)
					.price(new BigDecimal(982.00)).build());


			// add ten more
		};
	}

}