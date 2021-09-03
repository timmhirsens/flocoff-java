package de.timmhirsens.flocoff.spring;

import static de.timmhirsens.flocoff.FlocOffFilter.INTEREST_COHORT_VALUE;
import static de.timmhirsens.flocoff.FlocOffFilter.PERMISSIONS_POLICY_HEADER;
import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.REACTIVE;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = REACTIVE)
class FlocOffWebfluxConfiguration {

	@Bean
	WebFilter flocOffWebFilter() {
		return (exchange, chain) -> {
			exchange.getResponse().getHeaders().add(PERMISSIONS_POLICY_HEADER, INTEREST_COHORT_VALUE);
			return chain.filter(exchange);
		};
	}

}
