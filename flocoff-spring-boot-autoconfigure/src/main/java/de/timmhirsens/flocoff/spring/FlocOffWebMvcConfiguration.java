package de.timmhirsens.flocoff.spring;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

import java.util.Collections;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import de.timmhirsens.flocoff.FlocOffFilter;

@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = SERVLET)
class FlocOffWebMvcConfiguration {

	@Bean
	FilterRegistrationBean<FlocOffFilter> flocOffFilterRegistration() {
		FilterRegistrationBean<FlocOffFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new FlocOffFilter());
		filterRegistrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
		filterRegistrationBean.setName("flocoff-filter");
		filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
		return filterRegistrationBean;
	}

}
