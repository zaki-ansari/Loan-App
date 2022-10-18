package com.finzly.payload;

public enum PaymentFrequency {
	
	MONTHLY(1),
	QUARTERLY(3),
	HALFYEARLY(6),
	YEARLY(12);
	
	private Integer val;
	
	public Integer getValue() {
		return val;
	}

	PaymentFrequency(int val) {
		
		this.val=val;
	}
	

}
