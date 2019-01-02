package com.brightsdiamonds.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.brightsdiamonds.domain.Cart;
import com.brightsdiamonds.domain.CartItem;
import com.brightsdiamonds.domain.Diamond;
import com.brightsdiamonds.domain.PaypalResults;
import com.brightsdiamonds.domain.Product;
import com.brightsdiamonds.domain.User;
import com.brightsdiamonds.domain.UserShippingAddress;
import com.brightsdiamonds.service.DiamondService;
import com.brightsdiamonds.service.PaypalResultsService;
import com.brightsdiamonds.service.StaticImageService;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PayPalController {
	
	@Autowired
	private DiamondService diamondService;
	
	@Autowired
	private PaypalResultsService paypalResultsService;
	
	@Autowired
	private StaticImageService staticImageService;
	
	String clientId = "AcstogXtIWZjQ4vECNTO3s001OR8sMaIlrdazFqwR5LpTQzwQ2FsTx8hqELRWYwpPIIlXq2BooTFLFNX";
	String clientSecret = "EKk19gRL3_AX-GFqSuiWR_0EgWWSHAEVcsiCA2cNxbPTrE2FokM2MiWGUBrUT8g6jDqIwqf7Gsc3cp1M";

	APIContext context = new APIContext(clientId, clientSecret, "live");
	
//	@RequestMapping(value="/createUser", method=RequestMethod.POST)
//	public String createUser(@ModelAttribute(value="anUserLogin") User user) {
//		userService.createUser(user);
//		return "home";
//	}
	
	@RequestMapping(value="/paypalCheckOut", method=RequestMethod.POST)
	public RedirectView payPalCheckOut(HttpSession session, @ModelAttribute(value="anAddress") UserShippingAddress userShippingAddress) {
		
		session.setAttribute("userShippingAddress", userShippingAddress.toString());
		Cart cart = (Cart)session.getAttribute("cartItems");
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cartItems", cart);
		}
		
		for(String key: cart.getCartItems().keySet())
			if(cart.getCartItems().get(key).getProduct().getClass() == Diamond.class) {
				Diamond diamond = (Diamond) (cart.getCartItems().get(key).getProduct());
				if(!diamondService.getDiamond(diamond.getId()).getIsInStock()){
				cart.removeCartItem(key);
				RedirectView redirectView = new RedirectView();
				redirectView.setUrl("https://brightsdiamonds.com/itemNotAval");
				return redirectView;
				}
			}
//		System.out.println("checkItemsStock");
//		if(cart.checkItemsStock(cart)!=null) {
//			cart.removeCartItem(cart.getCartItems().get(cart.checkItemsStock(cart)));
//			RedirectView redirectView = new RedirectView();
//			redirectView.setUrl("http://localhost:8080/brights-diamonds-webapp/viewCart");
//			return redirectView;
//		}
		
		if(cart.getGrandTotal()==0) {
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl("https://brightsdiamonds.com/viewCart");
			return redirectView;
		}
		// Set payer details
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		// Set redirect URLs
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("https://brightsdiamonds.com/cancelPayment");
		redirectUrls.setReturnUrl("https://brightsdiamonds.com/successfulPayment");

		// Set payment details
		Details details = new Details();
		details.setShipping("30");
		details.setSubtotal(String.valueOf(cart.getGrandTotal()));
		details.setTax("0");
		

		List<Item> items = new ArrayList<Item>();
		for (String key: cart.getCartItems().keySet()) {
			Item item = new Item();
			item.setName(cart.getCartItems().get(key).getProduct().getName());
			item.setCurrency("USD");
			item.setQuantity("1");
			item.setPrice(String.valueOf(cart.getCartItems().get(key).getProduct().getUnitPrice()));
			items.add(item);
		}
		
		
		
//		Item item = new Item();
//		item.setName("Princess");
//		item.setCurrency("USD");
//		item.setQuantity("1");
//		item.setPrice("6");
		
//		List<Item> items = new ArrayList<Item>();
//		items.add(item);
		ItemList itemList = new ItemList();
		itemList.setItems(items);

		
		// Payment amount
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal(String.valueOf(cart.getGrandTotal()+30));
		amount.setDetails(details);

		// Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setItemList(itemList);
		transaction.setDescription("Diamonds");
		
		

		// Add transaction to a list
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// Add payment details
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setRedirectUrls(redirectUrls);
		payment.setTransactions(transactions);
	
		try {
			  Payment createdPayment = payment.create(context);

			  Iterator links = createdPayment.getLinks().iterator();
			  while (links.hasNext()) {
			    Links link = (Links) links.next();
			    if (link.getRel().equalsIgnoreCase("approval_url")) { 
			    RedirectView redirectView = new RedirectView();
			    redirectView.setUrl(link.getHref()+"&useraction=commit");
			    return redirectView;
			    }
			  }
			} catch (PayPalRESTException e) {
			    System.err.println(e.getDetails());
			}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("cancelPayment");
		return redirectView;
	}
	
//	  @RequestMapping(value = "/{dateString}", method = RequestMethod.GET)
//	  @ResponseBody
//	  public HttpStatus getSomething(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dateString) {
//	   return OK;
//	  }
	
//	@RequestMapping("/diamondDetails")
//	public String getDiamondByid(@RequestParam("id") int diamondId, Model model) throws UnsupportedEncodingException {
//		Diamond diamond = diamondService.getDiamond(diamondId);
//		byte[] encodeBase64 = Base64.encodeBase64(productImageService.getProductImage(diamond.getId()).getImageData());
//		String base64Encoded = new String (encodeBase64, "UTF-8");
//		
//		model.addAttribute("diamond", diamond);
//		model.addAttribute("productImage", base64Encoded);
//		return "diamondDetails";
//	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/successfulPayment")
	public String successfulPayment(HttpSession session, HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		Payment payment = new Payment();
		payment.setId(req.getParameter("paymentId"));
		Cart cart = (Cart)session.getAttribute("cartItems");

		
		String shipping = (String) session.getAttribute("userShippingAddress");
		PaypalResults paypalResults = new PaypalResults();
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(req.getParameter("PayerID"));
		try {
			
		  Payment createdPayment = payment.execute(context, paymentExecution);
		  
		  String paymentInfo = createdPayment.getPayer().getPayerInfo().getShippingAddress().toString() +
				  "\n total amount=" + (cart.getGrandTotal() + 30) ;
		  
		  String products = new String();
		  
		  for (String key: cart.getCartItems().keySet()) {
			  products += "<br/>" + cart.getCartItems().get(key).getProduct().getStockItem() + " - " + cart.getCartItems().get(key).getProduct().getName() 
					  + ": price - " + cart.getCartItems().get(key).getProduct().getUnitPrice() +"\n <br/>";
		  }		  
		  
			if(cart.getGrandTotal()==0) {
				PaypalResults paypalResults2 = paypalResultsService.getPaypalResutls(createdPayment.getCart().toString());
				model.addAttribute("paypalInformation", paypalResults2);
				return "sucessfulPayment";
			}
			
			User user = (User)session.getAttribute("user");
			if(user == null) {
		  paypalResults.setEmail("guest");
			} else {
				paypalResults.setEmail(user.getEmail());
			}
		  paypalResults.setPaymentInfo(paymentInfo);
		  paypalResults.setUserShippingAddress(shipping);
		  paypalResults.setDate(new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime()).toString());
		  paypalResults.setCartId(createdPayment.getCart());
		  paypalResults.setCartProducts(products);
		  paypalResults.setCartTotal(cart.getGrandTotal() + 30);
		  
		  paypalResultsService.createPaypalResults(paypalResults);
		  
		  
//		  System.out.println(createdPayment.getPayer().getPayerInfo().getShippingAddress());
//		  System.out.println(createdPayment.getTransactions().get(0).getItemList().getItems().get(0).getDescription());
		  
		} catch (PayPalRESTException e) {
		  System.err.println(e.getDetails());
		  
//		  String s = "st,1=4 st,2=15 st,3=24"; 
//	        String regex = "st,\\d=";
//	         
//	        ArrayList<String> list = new ArrayList<String>();
//	        String [] array = s.split(regex);
//	         
//	        for(String string: array){
//	         string = string.trim();
//	         if(!string.equals(""))
//	        list.add(string);
//	             
//	        }
//	        System.out.println(list);
		  
		//  "email": "
		}
		
		
			for(String key: cart.getCartItems().keySet())
				if(cart.getCartItems().get(key).getProduct().getClass() == Diamond.class) {
				cart.getCartItems().get(key).getProduct().setIsInStock(false);
				diamondService.updateIsInStock((Diamond) cart.getCartItems().get(key).getProduct(), cart.getCartItems().get(key).getProduct().getStockItem(), false);
				}
		cart.getCartItems().clear();
		cart.setGrandTotal(0);
		model.addAttribute("paypalInformation", paypalResults);
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		return "sucessfulPayment";
		
	}
	
	@RequestMapping("/cancelPayment")
	public String cancelPayment(Model model) throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		return "cancelPayment";
	}
	
	@RequestMapping("/invoice")
	public String invoice(@RequestParam("id") String cartId, Model model) {
		PaypalResults paypalResults2 = paypalResultsService.getPaypalResutls(cartId);
		model.addAttribute("paypalInformation", paypalResults2);
		return "invoice";
	}
	
	@RequestMapping(value= "/checkOut", method = RequestMethod.GET)
	public String checkOut(HttpSession session, Model model) throws UnsupportedEncodingException {
		model.addAttribute("anAddress", new UserShippingAddress());
		Cart cart = (Cart)session.getAttribute("cartItems");
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String base64Encoded = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", base64Encoded);
		
		
		if(cart==null) {
			cart = new Cart();
			session.setAttribute("cartItems", cart);
		}
		
		
		
		if(cart.getGrandTotal()==0) {
			
			
			return "cartList";
		}
		
		return "checkOut";
	}
	
//	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
//	public String newUser(Model model) {
//		model.addAttribute("anUser", new User());
//		return "newUser";
//	}
	
//	@RequestMapping("/viewCart")
//	public String viewCart(HttpSession session) {
//		Cart cart = (Cart)session.getAttribute("cartItems");
//		
//		if(cart==null) {
//			cart = new Cart();
//			session.setAttribute("cartItems", cart);
//		}		
////		for (String key: cart.getCartItems().keySet()) {
////		    System.out.println("key : " + key);
////		    System.out.println("value : " + cart.getCartItems().get(key).getProduct().getName());
////		}
//		return "cartList";
//		
//	}
	
//	@RequestMapping("/listDiamonds")
//	public String listOrganizations (Model model) {
//		List<Diamond> diamond = diamondService.getDiamondList();
//		model.addAttribute("diamondList", diamond);
//		return "listDiamonds";
//	}
}
