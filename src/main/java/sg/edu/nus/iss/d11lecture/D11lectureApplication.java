package sg.edu.nus.iss.d11lecture;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class D11lectureApplication {

	public static void main(String[] args) {
		// SpringApplication.run(D11lectureApplication.class, args);

		SpringApplication app = new SpringApplication(D11lectureApplication.class);
		
		String port = "3000";
		ApplicationArguments argOptions = new DefaultApplicationArguments(args);    //Detect if any arguments are put in

		if(argOptions.containsOption("port")){
			port = argOptions.getOptionValues("port").get(0);  //retrieve the first value associated with "port" (not index)
		} 
		else if (System.getenv("PORT") != null){
			port = System.getenv("PORT");
		}
		
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);

	}

	@Bean
	public CommonsRequestLoggingFilter log() {
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;
	}

}
