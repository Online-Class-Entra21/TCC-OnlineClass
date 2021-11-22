package backend.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import persistencia.jdbc.ConexaoFactory;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {
		
	/**
	 * Configura o servidor para realizar os métodos padrões 
	 * de uma API, além de desbloquear o acesso dela no 
	 * site do sistema web
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods("GET","POST","PUT","DELETE")
					.allowedHeaders("*")
					.allowedOrigins("http://localhost:5500","http://127.0.0.1:5500","*");
			}
		};
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
		try {
			String pathStr = new File(".").getCanonicalPath();
			Path path = Paths.get(pathStr);
			String htmlFront = "file:"+path.getParent().toString()+"\\frontend\\";
	        registry.addResourceHandler("/frontend/**").addResourceLocations(htmlFront);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
        
}
