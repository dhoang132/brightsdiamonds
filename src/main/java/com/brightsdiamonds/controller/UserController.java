package com.brightsdiamonds.controller;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.brightsdiamonds.domain.LoginAttempt;
import com.brightsdiamonds.domain.User;
import com.brightsdiamonds.service.StaticImageService;
import com.brightsdiamonds.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private StaticImageService staticImageService;
	
	@RequestMapping(value = "/newUser")
	public String newUser(Model model) throws UnsupportedEncodingException {
		model.addAttribute("anUser", new User());
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		return "newUser";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute(value="anUserLogin") User user, BindingResult result, Model model, HttpSession session) throws UnsupportedEncodingException {
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(3).getImageData());
		String homeImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("homeImage", homeImage);
		
		encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(4).getImageData());
		String homeImage2 = new String (encodeBase64, "UTF-8");
		model.addAttribute("homeImage2", homeImage2);

		if(result.hasErrors()) {
			model.addAttribute("formserror", result.getAllErrors());
			model.addAttribute("anUser", user);
			
			return "newUser";
		}
		
		else {
		userService.createUser(user);
		session.setAttribute("user", user);
		return "home";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws UnsupportedEncodingException {
		
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);
		
		model.addAttribute("anUser", new User());
		return "login";
	}
	
//    public BooleanResponse login(HttpSession session,HttpServletRequest request){
//        //HttpServletRequest used to take data to the controller
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//       //Here you set your values to the session
//       session.setAttribute("username", username);
//       session.setAttribute("email", email);
//
//      //your code goes here
//}
	
	@RequestMapping(value="/userLogin", method=RequestMethod.POST)
	public String userLogin(@Valid @ModelAttribute(value="anUser") LoginAttempt loginAttempt, BindingResult result,
			HttpSession session, Model model) throws UnsupportedEncodingException {
		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
		String logoImage = new String (encodeBase64, "UTF-8");
		model.addAttribute("logo", logoImage);

		if(result.hasErrors()) {
			model.addAttribute("formserror", result.getAllErrors());
			return "login";
		}else {
			
			
		User user = userService.getUser(loginAttempt.getEmail());
		if (user==null) {
			
			model.addAttribute("invalid", "invalid email/password");
			return "login";
			
		}else {
		
		String hashPass = userService.getUserPassword(loginAttempt.getEmail());
		if (loginAttempt.checkPass(loginAttempt.getPassword(), hashPass)) {
			
			encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(3).getImageData());
			String homeImage = new String (encodeBase64, "UTF-8");
			model.addAttribute("homeImage", homeImage);
			
			encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(4).getImageData());
			String homeImage2 = new String (encodeBase64, "UTF-8");
			model.addAttribute("homeImage2", homeImage2);
			
//			User user = userService.getUser(loginAttempt.getEmail());
			session.setAttribute("user", user);
			return "home";
		}
		
		else {
			model.addAttribute("invalid", "invalid email/password");
			return "login";
		
				}
			}
		}

	}
	
//	@RequestMapping(value="/createUser", method=RequestMethod.POST)
//	public String createUser(@Valid @ModelAttribute(value="anUserLogin") User user, BindingResult result, Model model) throws UnsupportedEncodingException {
//		
//		byte[] encodeBase64 = Base64.encodeBase64(staticImageService.getStaticImage(1).getImageData());
//		String logoImage = new String (encodeBase64, "UTF-8");
//		model.addAttribute("logo", logoImage);
//
//		if(result.hasErrors()) {
//			model.addAttribute("formserror", result.getAllErrors());
//			model.addAttribute("anUser", user);
//			
//			return "newUser";
//		}
//		
//		else {
//		userService.createUser(user);
//		
//		return "home";
//		}
//	}

}
