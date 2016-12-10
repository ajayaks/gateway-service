package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springcloud.filters.SimplePreFilter;


/**
 * Its a Zuul gateway service
 * @author ajay
 *
 */
@SpringBootApplication
// Making it Zuul enabled and Eureka client (so that it can register itself in eureka)
@EnableZuulProxy 
@EnableEurekaClient 
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
	
	
	// It will call the filter here
	@Bean
	  public SimplePreFilter simpleFilter() {
	    return new SimplePreFilter();
	  }
}
/*If you dont write any filter like pre, post, routing filter 
then it will simply do the routing defined in the config file
*/ 