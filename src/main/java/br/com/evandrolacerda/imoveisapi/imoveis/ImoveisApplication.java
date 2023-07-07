package br.com.evandrolacerda.imoveisapi.imoveis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("br.com.evandrolacerda.imoveisapi")
@EnableJpaRepositories("br.com.evandrolacerda.imoveisapi.repositories")
@SpringBootApplication
public class ImoveisApplication {


	public static void main(String[] args) {
		SpringApplication.run(ImoveisApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ImoveisApplication.class);
	}

}
