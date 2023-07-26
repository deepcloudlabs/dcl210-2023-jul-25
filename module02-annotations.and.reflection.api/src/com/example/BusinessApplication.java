package com.example;

import com.example.service.BusinessService;
import com.example.utility.ConfigurationUtilityService;

public class BusinessApplication {

	public static void main(String[] args) {
		var businessService = new BusinessService();
		var configService = new ConfigurationUtilityService();
		configService.loadConfiguration(businessService);
		businessService.fun();

	}

}
