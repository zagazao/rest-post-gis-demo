package de.ls7.pg607;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Dies ist die Mainklasse, welche die Springanwendung startet. Die @SpringBootApplication - Annotation ist beinhaltet
 * weitere Annotation, welche für die Autokonfigurierung benötigt werden. Mit dem aktuellem Setup wird nach Beans, wie
 * z.B. unten, und Konfiguration und Modelklassen in allen Paketen von de.ls7.pg609 gesucht.
 *
 * Die ganze Anwendung läuft aktuell in einem eingebettetem Tomcat Container, so dass keine weitere Kofiguration nötig
 * ist.
 * Das ganze kann allerdings auch als .war gepackt werden, um es in einem bereits laufendem Tomcat zu betreiben.
 *
 *  Unter localhost:8080/swagger-ui.html findet man die auto generierte API-Dokumentation.
 *
 */
@SpringBootApplication
@EnableSwagger2
public class RestPostGisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPostGisDemoApplication.class, args);
	}

	@Bean
	public Docket simpleDiffServiceApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("DatabaseDemo")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");

	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("A simple demo.")
				.description("A simple REST service made with Spring Boot in Java")
				.version("1.0")
				.build();
	}
}
