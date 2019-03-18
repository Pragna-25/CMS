package com.hexaware.FTP106.integration.test;
import com.hexaware.FTP106.integration.test.Orders;
import com.hexaware.FTP106.integration.test.OrderStatus;
import java.util.Arrays;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class OrderRestTest 
{
	@Test
	public void testVendorHistory() throws AssertionError, URISyntaxException
	{
		Time et = new Time(14,39,45);
		Time ot = new Time(14,39,45);
		Orders[] res = given()
			.when()
			.accept(ContentType.JSON)
			.get(CommonUtil.getURI("/api/order/ven/500"))
			.getBody().as(Orders[].class);
		assertNotNull(res);
		assertEquals(1, res[0].getOrderId());
		assertEquals(1000, res[0].getFoodId());
		assertEquals(500, res[0].getVId());
		assertEquals(5, res[0].getCId());
		assertEquals(2, res[0].getQty());
		assertEquals(160.0, res[0].getTPrice(),0.1);
    	assertEquals(et, res[0].getETime());
    	assertEquals(ot, res[0].getOTime());
    	assertEquals(" have a great day", res[0].getOReason());
	}

	@Test
	public void testCustomerHistory() throws AssertionError, URISyntaxException
	{
		Time et = new Time(15,35,32);
		Time ot = new Time(15,35,32);
		Orders[] res = given()
				.when()
				.accept(ContentType.JSON)
				.get(CommonUtil.getURI("/api/order/cus/1"))
				.getBody().as(Orders[].class);
		assertNotNull(res);
		assertEquals(9, res[0].getOrderId());
		assertEquals(1000, res[0].getFoodId());
		assertEquals(500, res[0].getVId());
		assertEquals(1, res[0].getCId());
		assertEquals(1, res[0].getQty());
		assertEquals(80.0, res[0].getTPrice(),0.1);
    	assertEquals(et, res[0].getETime());
    	assertEquals(ot, res[0].getOTime());
    	assertEquals(" ", res[0].getOReason());
	}

	@Test
	public void testPlaceorder() throws AssertionError, URISyntaxException
	{
		Time et = new Time(16,26,53);
		Time ot = new Time(16,26,53);
		String st = "2019-03-12";
		Date od = Date.valueOf(st);
		List expOrder = new ArrayList();
		expOrder.add( new Orders(12, 1000, 502, 2, 1, OrderStatus.PLACE_ORDER,80f, et, ot, " ",od) );
		String str = given()
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(expOrder.toArray()).when()
				.post(CommonUtil.getURI("/api/customer/placeorder/2"))
				.getBody().asString();
		System.out.println(str);
		String estr = "{\"msg\":\"Order placed\n\"}";
		assertNotNull(str);
	}

	@Test
	public void testAcceptDeny() throws AssertionError, URISyntaxException
	{
		Time et = new Time(15,36,06);
		Time ot = new Time(15,36,06);
		String st = "2019-03-11";
		Date od = Date.valueOf(st);
		List expOrder = new ArrayList();
		expOrder.add( new Orders(12, 1000, 502, 2, 1, OrderStatus.PLACE_ORDER,80f, et, ot, " ",od) );
		String str = given()
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(expOrder).when()
				.put(CommonUtil.getURI("/api/vendor/modify/12"))
				.getBody().asString();
		System.out.println(str);
		String estr = "{\"msg\":\"Order placed\n\"}";
		assertNotNull(str);
	}
}
