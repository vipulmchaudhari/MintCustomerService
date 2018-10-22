package com.mint.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mint.model.Customer;
import com.mint.controller.CustomerRestURIConstants;
/**
 * Handles requests for the Customer service.
 */
@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	Map<String, Customer> custData = new HashMap<String, Customer>();
	
	@RequestMapping(value = CustomerRestURIConstants.DUMMY_CUST, method = RequestMethod.GET)
	public @ResponseBody Customer getDummyCustomer() {
		logger.info("Start getDummyCustomer");
		Customer cust = new Customer();
		cust.setFirstname("Tom");
		cust.setLastname("Martin");
		cust.setAddresses("Sydney");
		custData.put(cust.getFirstname(), cust);
		return cust;
	}
	
	@RequestMapping(value = CustomerRestURIConstants.GET_ALL_CUST, method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Customer> getCustomer() {	
		return (HashMap<String, Customer>) custData;
	}
	
	@RequestMapping(value = CustomerRestURIConstants.CREATE_CUST, method = RequestMethod.POST)
	public @ResponseBody Customer createCustomer(@RequestBody Customer cust) {
		logger.info("Start createCustomer.");
		cust.setAddresses("Sydney");;
		custData.put(cust.getFirstname(), cust);
		return cust;
	}
	
	@RequestMapping(value = CustomerRestURIConstants.UPDATE_CUST, method = RequestMethod.PUT)
	public @ResponseBody Customer updateCustomer(@PathVariable("firstname") String firstname) {
		logger.info("Start deleteCustomer.");
		Customer cust = custData.get(firstname);
		custData.put(firstname,cust);
		return cust;
	}	
	
	@RequestMapping(value = CustomerRestURIConstants.DELETE_CUST, method = RequestMethod.PUT)
	public @ResponseBody Customer deleteCustomer(@PathVariable("firstname") int custId) {
		logger.info("Start deleteCustomer.");
		Customer cust = custData.get(custId);
		custData.remove(custId);
		return cust;
	}
}
