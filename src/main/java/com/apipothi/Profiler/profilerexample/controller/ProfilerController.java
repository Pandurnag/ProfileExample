package com.apipothi.Profiler.profilerexample.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.apipothi.Profiler.profilerexample.ProfilerConfiguration;

@Controller
public class ProfilerController {
	
	@Value("${spring.profiles.active}")
	private String profile;
	
	@Autowired
	ProfilerConfiguration configuration;
	
	

    @PostConstruct
	public void init() {
    	
    	System.out.println("What is Env-"+profile);
    	
    	System.out.println("****-START init-");
    	if(profile.equals("dev")) {
    		
    		
    	  configuration.devBean();
    	  }else if(profile.equals("qa")) {
          configuration.qaBean();
          }else if(profile.equals("prod")) {
        	  
        	  configuration.prdBean();
          }else {
        	  System.err.print("No Env. Found");
          }
    	
    	configuration.qaBean();
    	


    	System.out.println("****-END init-");
		
	}
	
}
