package com.hexaware.FTP106.integration.test;

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

public class VendorRestTest {

	@Test
	public void testVendorById() throws AssertionError, URISyntaxException {
	Vendor[] res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/vendor/500"))
				.getBody().as(Vendor[].class);
	assertNotNull(res);
	assertEquals(500, res[0].getVId());
	assertEquals("KFC", res[0].getVName());
	assertEquals("Deepak", res[0].getVUsername());
	assertEquals("password", res[0].getVPassword());
	assertEquals("deepak@kfc.com", res[0].getVEmail());
	assertEquals(123123123, res[0].getVPhone(),0.01);
    assertEquals("#123, 4th street,5th phase BTM, Bangalore, Karnataka", res[0].getVAddress());
	}

    @Test
	public void testVendorrLogin() throws AssertionError, URISyntaxException {
	Vendor res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/vendor?vUserName=Deepak&vPassword=password"))
				.getBody().as(Vendor.class);
	assertNotNull(res);
	assertEquals(500, res.getVId());
	assertEquals("KFC", res.getVName());
	assertEquals("Deepak", res.getVUsername());
	assertEquals("password", res.getVPassword());
	assertEquals("deepak@kfc.com", res.getVEmail());
	assertEquals(123123123, res.getVPhone());
    assertEquals("#123, 4th street,5th phase BTM, Bangalore, Karnataka", res.getVAddress());
	}	
	
}