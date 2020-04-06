package br.com.microservice.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.microservice.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	//aqui define o atributo MEDIA
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	//depois que implemntou a class YMAL
	public void extendMessegeConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	
	//@Override //error
	public void configureContentNegociation(ContentNegotiationConfigurer configure) {

		// Via EXTENCION. http://localhost:8080/api/person/v1.xml
//		configure.favorParameter(false)
//		.ignoreAcceptHeader(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//		.mediaType("json", MediaType.APPLICATION_JSON)
//		.mediaType("xml", MediaType.APPLICATION_XML);
//		
		
		
		// Via EXTENCION. http://localhost:8080/api/person/v1?mediaType=json
//		configure.favorPathExtension(false)
//		.favorParameter(true)
//		.parameterName("mediaType")
//		.ignoreAcceptHeader(true)
//		.useRegisteredExtensionsOnly(false)
//		.defaultContentType(MediaType.APPLICATION_JSON)
//		.mediaType("json", MediaType.APPLICATION_JSON)
//		.mediaType("xml", MediaType.APPLICATION_XML);
//		
		
		
		configure.favorPathExtension(false)
		.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIA_TYPE_YML );
		
		
		
		
		
	}

}
