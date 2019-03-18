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

public class MenuRestTest 
{
	@Test
	public void testMenuList() throws AssertionError, URISyntaxException 
	{
		Menu[] res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/menu"))
				.getBody().as(Menu[].class);
		assertNotNull(res);
		assertEquals(1000, res[0].getFoodId());
		assertEquals("CHICKENWINGS", res[0].getFoodName());
		assertEquals(500, res[0].getVId());
		assertEquals("CRISPY DEEP FRIED CHICKEN", res[0].getFoodCategory());
		assertEquals(80, res[0].getFoodPrice());
		assertEquals("NONVEG", res[0].getFoodDescription());
	}
}
