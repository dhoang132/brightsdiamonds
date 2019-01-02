package com.brightsdiamonds.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PayPalConfig {
	
	// Replace with your application client ID and secret
	String clientId = "AcstogXtIWZjQ4vECNTO3s001OR8sMaIlrdazFqwR5LpTQzwQ2FsTx8hqELRWYwpPIIlXq2BooTFLFNX";
	String clientSecret = "EKk19gRL3_AX-GFqSuiWR_0EgWWSHAEVcsiCA2cNxbPTrE2FokM2MiWGUBrUT8g6jDqIwqf7Gsc3cp1M";

	APIContext context = new APIContext(clientId, clientSecret, "live");
}
