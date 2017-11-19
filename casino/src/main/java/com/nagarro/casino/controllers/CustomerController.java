package com.nagarro.casino.controllers;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.casino.model.Customer;
import com.nagarro.casino.repository.CustomerRepo;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	@RequestMapping("/users")
	@ResponseBody
	public ModelAndView getAllCustomer() {
		ModelAndView userList = new ModelAndView("UserList");
		userList.addObject("list", customerRepo.findAll());
		return userList;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
		Customer customer = new Customer();
		model.addObject("customer", customer);
		model.setViewName("Register");
		return model;
	}

	@RequestMapping(value = "/user/{u_id}", method = RequestMethod.GET)
	@ResponseBody
	@Produces({ MediaType.APPLICATION_JSON })
	public Customer getCustomer(@PathVariable("u_id") String u_id) {
		Customer customer = new Customer();
		customer = customerRepo.findByUniqId(u_id);
		if (null != customer)
			return customer;
		return new Customer();
	}

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@RequestParam("name") String name, @RequestParam("dob") Date dob,
			@RequestParam("contact") long contact, @RequestParam("email") String email) {

		Customer customer = new Customer();
		customer.setUniq_id(UUID.randomUUID().toString());
		customer.setName(name);
		customer.setDob(dob);
		customer.setContact(contact);
		customer.setEmail(email);
		customer.setTotal_bal(500);
		if (customer.getId() == 0) {
			// if id==0 new customer otherwise update old one
		}
		customerRepo.save(customer);
		return new ModelAndView("redirect:/user/register.html?success=true");
	}

	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	public ModelAndView doEdit(@RequestParam("id") int id, @RequestParam("ammount") int amt) {
		Customer customer = customerRepo.findOne(id);
		customer.setTotal_bal(customer.getTotal_bal() + amt);
		customerRepo.save(customer);
		return new ModelAndView("redirect:/users");
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView doEdit(@RequestParam("name") String name, @RequestParam("contact") long contact,
			@RequestParam("email") String email) {
		ModelAndView userList = new ModelAndView("UserList");

		if (name != "")
			userList.addObject("list", customerRepo.findByName(name));
		else if (email != "")
			userList.addObject("list", customerRepo.findByEmail(email));
		else if (contact != 0)
			userList.addObject("list", customerRepo.findByContact(contact));
		else
			userList.addObject("list", customerRepo.findAll());

		return userList;
	}

}
