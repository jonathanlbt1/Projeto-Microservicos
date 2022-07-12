package com.example.gatewaycloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
@EnableEurekaClient
public class GatewaycloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewaycloudApplication.class, args);
	}

    @Bean
    RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .uri("http://localhost:8080/eureka"))

                .build();
    }


    //Codigo abaixo nao foi necessario.
    
	// end::route-locator[]

	// tag::fallback[]
// 	@RequestMapping("/fallback")
// 	public Mono<String> fallback() {
// 		return Mono.just("fallback");
// 	}
// 	// end::fallback[]
// }

// // tag::uri-configuration[]

// @ConfigurationProperties
// class UriConfiguration {
	
// 	private String httpbin = "http://localhost:8080/eureka";

// 	public String getHttpbin() {
// 		return httpbin;
// 	}

// 	public void setHttpbin(String httpbin) {
// 		this.httpbin = httpbin;
// 	}
}
// end::uri-configuration[]
// end::code[]


