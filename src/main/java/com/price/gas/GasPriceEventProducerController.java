package com.price.gas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/gasprice/producer")
public class GasPriceEventProducerController {
	
	@RequestMapping("/heartbeat")
	public String getProducerHeartBeat() {
		System.out.println("Producer Alive");
		return "Producer Alive";
	}

}
