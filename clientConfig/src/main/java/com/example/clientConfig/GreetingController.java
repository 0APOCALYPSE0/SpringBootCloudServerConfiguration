package com.example.clientConfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	@Value("${my.greeting: default value}")
	private String greetingMessage;
	
	@Value("some static message")
	private String staticMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
//	@Value("#{${dbValues}}")
//	private Map<String, String> dbValues;
	
	@Autowired
	private DbSettings dbSetting;
	
	
	@GetMapping("/greeting")
	public String greeting() {
		return greetingMessage +" "+ dbSetting.getConnection();
	}

}
