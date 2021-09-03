package de.timmhirsens.flocoff.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ FlocOffWebMvcConfiguration.class, FlocOffWebfluxConfiguration.class })
public class FlocOffAutoConfiguration {
}
