package com.price.gas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.price.gas.model.GasPrices;
import com.price.gas.service.GasPriceService;


@Component
public class GasProducerScheduler {
	
	@Autowired
	private GasProducer producer;
	
	@Autowired
	private GasPriceService gasPriceService;
	
	@Autowired
	private GasPriceEventProducerController gasPriceEventProducerController;
	
	//CronJob to trigger a producer event every day at 12 am
	@Scheduled(cron = "0 0 0 * * *")
	//@Scheduled(fixedRate = 700000)
	public void cronJobSch() {
	  System.out.println("schedler running ...");
      //Externa API call to fetch Gas Price Results.
	  GasPrices output = gasPriceService.fetchGasPrice();
	  
	  //Producing a Kafka custom message
	  producer.send(output);
	  
	}

	// Heartbeat service to keep the heroku app alive
	//@Scheduled(cron = "0 0 0 * * *")
	 @Scheduled(fixedRate = 600000)
	public void cronHertBeat() {
		 gasPriceEventProducerController.getProducerHeartBeat();
		}


	public GasProducer getProducer() {
		return producer;
	}

	public void setProducer(GasProducer producer) {
		this.producer = producer;
	}

	public GasPriceService getGasPriceService() {
		return gasPriceService;
	}

	public void setGasPriceService(GasPriceService gasPriceService) {
		this.gasPriceService = gasPriceService;
	}

	public GasPriceEventProducerController getGasPriceEventProducerController() {
		return gasPriceEventProducerController;
	}

	public void setGasPriceEventProducerController(GasPriceEventProducerController gasPriceEventProducerController) {
		this.gasPriceEventProducerController = gasPriceEventProducerController;
	}

}
