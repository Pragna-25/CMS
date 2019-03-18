package com.hexaware.FTP106.integration.test;
import com.hexaware.FTP106.integration.test.Customer;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class CustomerRestTest 
{

	@Test
	public void testCustomerById() throws AssertionError, URISyntaxException
	{
		Customer[] res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/customer/1"))
				.getBody().as(Customer[].class);
		assertNotNull(res);
		assertEquals(1, res[0].getCId());
		assertEquals("JOHN", res[0].getCName());
		assertEquals("JOHN", res[0].getCUserName());
		assertEquals("7586469254", res[0].getCPhone());
		assertEquals("JOHN@GMAIL.COM", res[0].getCEmail());
		assertEquals(240.0, res[0].getCWallet(),0.01);
    	assertEquals("JOHN@123", res[0].getCPassword());
	}

    @Test
	public void testCustomerLogin() throws AssertionError, URISyntaxException
	{
		Customer res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/customer?cUserName=JOHN&cPassword=JOHN@123"))
				.getBody().as(Customer.class);
		assertNotNull(res);
		assertEquals(1, res.getCId());
		assertEquals("JOHN", res.getCName());
		assertEquals("JOHN", res.getCUserName());
		assertEquals("7586469254", res.getCPhone());
		assertEquals("JOHN@GMAIL.COM", res.getCEmail());
		assertEquals(240.0, res.getCWallet(),0.01);
    	assertEquals("JOHN@123", res.getCPassword());
	}

    @Test
	public void testCustomerWallet() throws AssertionError, URISyntaxException
	{
		Customer c = new Customer();
		Float res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/customer/wallet/1"))
				.getBody().as(Float.class);
		assertNotNull(res);
		c.setCWallet(res);
		assertEquals(240.0, c.getCWallet(),0.01);
	}
}
