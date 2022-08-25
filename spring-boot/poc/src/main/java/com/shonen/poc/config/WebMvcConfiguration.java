package com.shonen.poc.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
@Configuration
@EnableWebMvc
@EnableTransactionManagement
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final EntityManagerFactory emf;

    public WebMvcConfiguration(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final var openEntityManagerInViewInterceptor = new OpenEntityManagerInViewInterceptor();
        openEntityManagerInViewInterceptor.setEntityManagerFactory(emf);
        registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (var converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
                final var mapper = mappingJackson2HttpMessageConverter.getObjectMapper();
                mapper.registerModule(datatypeHibernateModule());
            }
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(datatypeHibernateModule());
        return mapper;
    }

    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate5Module();
    }
}