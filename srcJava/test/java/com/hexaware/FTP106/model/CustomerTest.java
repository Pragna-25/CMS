package com.hexaware.FTP106.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * class customerTest.
 */
public class CustomerTest {
  /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("WELCOME");
  }
  /**
   * show customer info.
   */
  @Test
  public final void testCustomerInfo() {
    Customer c = null;
    assertNull(c);

    Customer c1 = new Customer();
    assertNotNull("Customer is not null", c1);
    assertNotNull(c1);

    Customer c2 = new Customer();
    c2.setCId(2000);
    assertEquals(2000, c2.getCId());

    c2.setCName("sravan");
    assertEquals("sravan", c2.getCName());

    c2.setCUserName("sravan");
    assertEquals("sravan", c2.getCUserName());

    c2.setCPhone("1234455566");
    assertEquals("1234455566", c2.getCPhone());

    c2.setCEmail("sravan@gmail.com");
    assertEquals("sravan@gmail.com", c2.getCEmail());

    c2.setCWallet(7000);
    assertEquals(7000, c2.getCWallet(), 0.001);

    c2.setCPassword("sravan@123");
    assertEquals("sravan@123", c2.getCPassword());

    assertNotEquals("latha", c2.getCName());
    assertNotEquals(2001, c2.getCId());
    assertNotEquals("latha", c2.getCUserName());
    assertNotEquals("3223224567", c2.getCPhone());
    assertNotEquals("latha@gmsil.com", c2.getCEmail());
    assertNotEquals(8000, c2.getCWallet());
    assertNotEquals("latha@123", c2.getCPassword());
  }

  /**
   * show testallargConstructor.
   */
  @Test
    public final void testallargConstructor() {
    Customer c1 = new Customer(2001, "Anu", "Anu", "1234567890", "Anu@gmail.com", 9000, "Anu@123");
    assertNotNull("Customer is not null", c1);
    assertNotNull(c1);
    assertNotEquals(c1, null);
    assertEquals(2001, c1.getCId());
    assertEquals("Anu", c1.getCName());
    assertEquals("Anu", c1.getCUserName());
    assertEquals("1234567890", c1.getCPhone());
    assertEquals("Anu@gmail.com", c1.getCEmail());
    assertEquals(9000, c1.getCWallet(), 0.001);
    assertEquals("Anu@123", c1.getCPassword());
    assertEquals(c1, new Customer(2001, "Anu", "Anu", "1234567890", "Anu@gmail.com", 9000, "Anu@123"));
    assertNotEquals(c1, new Customer(2002, "Anu", "Anu", "1234567890", "Anu@gmail.com", 9000, "Anu@123"));
    assertEquals(c1.hashCode(), new Customer(2001, "Anu", "Anu", "1234567890", "Anu@gmail.com", 9000, "Anu@123").hashCode());
    System.out.println(c1);

    ArrayList a = new ArrayList();
    assertFalse(c1.equals(a));
  }

  /**
   * test for object.
   */
  @Test
    public final void testCustomerObjects() {
    Customer expected = new Customer(2001, "Anu", "Anu", "1234567890", "Anu@gmail.com", 9000, "Anu@123");
    Customer actual = new Customer(2001, "Anu", "Anu", "1234567890", "Anu@gmail.com", 9000, "Anu@123");

    assertEquals(expected, actual);

    Customer act2 = new Customer(100, "lavanya", "lavanya", "2233445566", "lavanya@gmail.com", 5000, "lavanya@123");
    assertNotEquals(expected, act2);
  }
}
