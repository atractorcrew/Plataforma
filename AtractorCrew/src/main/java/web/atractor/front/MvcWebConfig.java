package web.atractor.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("web.atractor.front.controller")
public class MvcWebConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SpringResourceTemplateResolver templateResolver() {

		System.out.println("HOLA MUNDO******************");
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");

		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {

		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);

		return templateEngine;
	}

	@Bean
	public ViewResolver viewResolver() {

		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		ViewResolverRegistry registry = new ViewResolverRegistry(null, applicationContext);

		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);

		return resolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {



		
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/js/ajaxcall/**").addResourceLocations("classpath:/static/js/ajaxcall/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
	//	registry.addResourceHandler("/wsgap/app/imgsrc/**").addResourceLocations(urlPermise);
	//	registry.addResourceHandler("/wsgap/app/imgsrc/**").addResourceLocations("file:/C:/wsgap/app/imgsrc/");
	}

}
