package de.timmhirsens.flocoff.spring;

import static de.timmhirsens.flocoff.FlocOffFilter.INTEREST_COHORT_VALUE;
import static de.timmhirsens.flocoff.FlocOffFilter.PERMISSIONS_POLICY_HEADER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@WebMvcTest
@ImportAutoConfiguration(FlocOffAutoConfiguration.class)
class WebMvcIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("Header is present in WebMVC environment")
	void testHeaderIsPresent() throws Exception {
		this.mockMvc.perform(get("/"))
				.andExpect(header().stringValues(PERMISSIONS_POLICY_HEADER, INTEREST_COHORT_VALUE));
	}

	@Configuration(proxyBeanMethods = false)
	static class TestConfiguration {

		@Bean
		WebMvcConfigurer webMvcConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addViewControllers(ViewControllerRegistry registry) {
					registry.addViewController("/").setViewName("index");
				}
			};
		}
	}
}
