package com.mint;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.mint.controller.CustomerRestURIConstants;
import com.mint.model.Customer;

public class TestMintCustomerRESTService {

	public static final String SERVER_URI = "http://localhost:8080/MintCustomerRESTService";
	
	public static void main(String args[]){
		
		testGetDummyCustomer();
		System.out.println("*****");
		testCreateCustomer();
		System.out.println("*****");
		testGetCustomer();
		System.out.println("*****");
		testGetAllCustomer();
	}

	private static void testGetAllCustomer() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Customer> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+CustomerRestURIConstants.GET_ALL_CUST, List.class);
		System.out.println(emps.size());
		for(LinkedHashMap map : emps){
			System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateCustomer() {
		RestTemplate restTemplate = new RestTemplate();
		Customer cust = new Customer();
		cust.setFirstname("Tom");;cust.setLastname("Martin");
		Customer response = restTemplate.postForObject(SERVER_URI+CustomerRestURIConstants.CREATE_CUST, cust, Customer.class);
		printEmpData(response);
	}

	private static void testGetCustomer() {
		RestTemplate restTemplate = new RestTemplate();
		Customer cust = restTemplate.getForObject(SERVER_URI+"/rest/cust/1", Customer.class);
		printEmpData(cust);
	}

	private static void testGetDummyCustomer() {
		RestTemplate restTemplate = new RestTemplate();
		Customer cust = restTemplate.getForObject(SERVER_URI+CustomerRestURIConstants.DUMMY_CUST, Customer.class);
		printEmpData(cust);
	}
	
	public static void printEmpData(Customer cust){
		System.out.println("firstname ="+cust.getFirstname()+",Name="+cust.getLastname()+",CreatedDate="+cust.getAddresses());
	}
}
