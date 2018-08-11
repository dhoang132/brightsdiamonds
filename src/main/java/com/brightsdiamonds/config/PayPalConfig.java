package com.brightsdiamonds.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PayPalConfig {
	
	// Replace with your application client ID and secret
	String clientId = "";
	String clientSecret = "";

	APIContext context = new APIContext(clientId, clientSecret, "live");
}
