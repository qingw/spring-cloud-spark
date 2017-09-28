package org.sselab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sselab.filter.AccessFilter;

@Configuration
public class FilterConfig {
  @Bean
  public AccessFilter accessFilter() {
    return new AccessFilter();
  }
}
