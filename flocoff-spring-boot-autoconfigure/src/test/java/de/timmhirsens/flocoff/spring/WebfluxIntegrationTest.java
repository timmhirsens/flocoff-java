package de.timmhirsens.flocoff.spring;

import static de.timmhirsens.flocoff.FlocOffFilter.INTEREST_COHORT_VALUE;
import static de.timmhirsens.flocoff.FlocOffFilter.PERMISSIONS_POLICY_HEADER;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;

@WebFluxTest
@ImportAutoConfiguration({ ThymeleafAutoConfiguration.class, FlocOffAutoConfiguration.class })
class WebfluxIntegrationTest {
	@Autowired
	private WebTestClient webTestClient;

	@Test
	@DisplayName("Header is present in Webflux environment")
	void testHeaderIsPresent() {
		webTestClient.get().uri("/").exchange().expectHeader().valueEquals(PERMISSIONS_POLICY_HEADER, INTEREST_COHORT_VALUE);
	}

	@Configuration(proxyBeanMethods = false)
	static class TestConfiguration {
		@Bean
		RouterFunction<?> router() {
			return route(GET("/"), request -> ok().render("index"));
		}
	}

}
