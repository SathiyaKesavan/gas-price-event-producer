package com.price.gas.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.price.gas.model.GasPrice;
import com.price.gas.model.GasPrices;

@Component
public class GasPriceService {
	
	@Value("${gasprice.url}")
    private String GAS_PRICE_SERVICE_URL;
    
    @Value("${gasprice.apikey}")
    private String GAS_PRICE_API_KEY;
	
	public GasPrices fetchGasPrice() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("api url ::  " + GAS_PRICE_SERVICE_URL);
		System.out.println("api key ::  " + GAS_PRICE_API_KEY);
		
		// constructing the request headers
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("content-type", "application/json");
		headers.add("Authorization", GAS_PRICE_API_KEY);
		headers.add("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");	
		
		//making api call
		ResponseEntity<GasPrices> response =  restTemplate.exchange(GAS_PRICE_SERVICE_URL, HttpMethod.GET, new HttpEntity(headers), GasPrices.class);
		
		System.out.println("Ouptout ::  " + response.getBody().isSuccess() + " size " + response.getBody().getResult().size());
		
		for(GasPrice p : response.getBody().getResult()) {
			System.out.println(p.getName() + " " + p.getGasoline());
		}
		
		return response.getBody();
	}

}
