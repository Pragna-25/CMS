package com.hexaware.FTP106.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class OrdersTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testOrders() {
    Orders v = new Orders();

    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/DD");
    sd.setLenient(false);
    Date dt = new java.sql.Date(new java.util.Date().getTime());
    Time et = new Time(dt.getTime());
    Orders v3001 = new Orders(5001, 4001, 3001, 2001, 2, OrderStatus.PLACE_ORDER, 200.0f, et, et, "THANK YOU", dt);
    assertNotEquals(v3001, null);
    Orders o = null;
    assertNull(o);
    /**
     * Test the setter and getter method of orders class
     */
    v3001.setOrderId(5001);
    assertEquals(5001, v3001.getOrderId());
    v3001.setFoodId(4001);
    assertEquals(4001, v3001.getFoodId());
    v3001.setVId(3001);
    assertEquals(3001, v3001.getVId());
    v3001.setCId(2001);
    assertEquals(2001, v3001.getCId());
    v3001.setQty(2);
    assertEquals(2, v3001.getQty());
    OrderStatus os = OrderStatus.PLACE_ORDER;
    v3001.setOStatus(OrderStatus.PLACE_ORDER);
    assertEquals(os, v3001.getOStatus());
    v3001.setTPrice(200.0f);
    assertEquals(200, v3001.getTPrice(), 0.01);
    v3001.setETime(et);
    assertEquals(et, v3001.getETime());
    v3001.setOTime(et);
    assertEquals(et, v3001.getOTime());
    v3001.setOReason("THANK YOU");
    assertEquals("THANK YOU", v3001.getOReason());
    v3001.setODate(dt);
   /**
    * Tests the equals/hashcode methods of the  Orders class.
    */
    assertEquals(dt, v3001.getODate());
    assertEquals(5001, v3001.getOrderId());
    assertEquals(4001, v3001.getFoodId());
    assertEquals(3001, v3001.getVId());
    assertEquals(2001, v3001.getCId());
    assertEquals(2, v3001.getQty());
    assertEquals(200, v3001.getTPrice(), 0.01);
    assertEquals(os, v3001.getOStatus());
    assertEquals(et, v3001.getETime());
    assertEquals(et, v3001.getOTime());
    assertEquals("THANK YOU", v3001.getOReason());
    assertEquals(dt, v3001.getODate());
    assertEquals(4001, v3001.getFoodId());
    ArrayList a = new ArrayList();
    assertFalse(v3001.equals(a));

    assertEquals(v3001.hashCode(), new Orders(5001, 4001, 3001, 2001, 2, OrderStatus.PLACE_ORDER, 200.0f, et, et, "THANK YOU", dt).hashCode());
    assertEquals(v3001, new Orders(5001, 4001, 3001, 2001, 2, OrderStatus.PLACE_ORDER, 200.0f, et, et, "THANK YOU", dt));
    Orders actual = new Orders(5001, 4001, 3001, 2001, 2, OrderStatus.DELIVERED, 200.0f, et, et, "THANK YOU", dt);
    Orders expected = new Orders(5001, 4001, 3001, 2001, 2, OrderStatus.DELIVERED, 200.0f, et, et, "THANK YOU", dt);
    Orders exp = new Orders(5001, 4001, 3001, 2001, 3, OrderStatus.DELIVERED, 200.0f, et, et, "THANK YOU", dt);
    assertEquals(expected, actual);
    assertNotEquals(exp, actual);
    /**
     * Test the ToString Method of Orders.java
     */
    System.out.println(v3001);
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  /*
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<Menu>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = Menu.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
 /*
   @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<Menu>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = Menu.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
  }
*/
}
