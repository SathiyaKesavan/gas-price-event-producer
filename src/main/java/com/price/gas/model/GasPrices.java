package com.price.gas.model;

import java.util.List;

public class GasPrices {
	
	private boolean success;
	private List<GasPrice> result;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<GasPrice> getResult() {
		return result;
	}
	public void setResult(List<GasPrice> result) {
		this.result = result;
	}

}
