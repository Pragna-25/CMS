package com.hexaware.FTP106.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.FTP106.model.OrderStatus;
import com.hexaware.FTP106.model.Orders;
import com.hexaware.FTP106.persistence.OrdersDAO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class OrdersFactoryTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {
  }
  /**
   * constructor.
   */
  @Test
  public final void testMapper() {
    Orders[]  od  = OrdersFactory.showOrders();
    assertNotNull(od);
  }
  /**
   * constructor.
   */
  @Test
  public final void testDao() {
    OrdersDAO of  = OrdersFactory.dao();
    assertNotNull(of);
  }
  /**
   * test for dao connection.
   */
  @Test
  public final void testConstructor() {
    OrdersFactory of = new OrdersFactory();
    assertNotNull(of);
  }
  /**
   * @param dao dao
   */
  @Test
  public final void testOrderQuery(@Mocked final OrdersDAO dao) {
    final OrderStatus os = OrderStatus.valueOf("PLACE_ORDER");
    final String value = " ";
    final int expected = 0;
    final LocalDateTime date = LocalDateTime.now();
    new Expectations() {
      {
        DateTimeFormatter tf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String ot1 = date.format(tf1);
        DateTimeFormatter tf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ot2 = date.format(tf2);

        System.out.println("Mocked insertorders query");
        dao.insertQuery(4000, 2000, 3000, 10, os.name(), 500, ot1, ot1, value, ot2);
        result = expected;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked insert orders dao");
        return dao;
      }
    };
    int stArr = OrdersFactory.orderQuery(4000, 2000, 3000, 10, 500);
    assertEquals(expected, stArr);
  }
  /**
   * @param cdao cdao
   * @param dao dao
   */
  @Test
  public final void testRevert(@Mocked final CustomerFactory cdao, @Mocked final OrdersDAO dao) {
    final OrderStatus os = OrderStatus.valueOf("PLACE_ORDER");
    final String value = " ";
    final Date od = new java.sql.Date(new java.util.Date().getTime());
    final Time t = new Time(od.getTime());
    final Orders order = new Orders(5000, 4000, 2000, 3000, 100, os, 500, t, t, value, od);
    final int rm = 0;
    final int expected = 0;
    new Expectations() {
      {
        System.out.println("Mocked show revert");
        dao.showRevert(5000);
        result = order;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked revert");
        return dao;
      }
    };
    new MockUp<CustomerFactory>() {
      @Mock
      CustomerFactory cdao() {
        System.out.println("Mocked revertMoney");
        return cdao;
      }
    };
    int stArr = OrdersFactory.revert(5000);
    assertEquals(expected, stArr);
    int st = CustomerFactory.revertMoney(3000, 1500.0f);
    assertEquals(rm, st);
  }
  /**
   * @param dao dao
   */
  @Test
  public final void testStaus(@Mocked final OrdersDAO dao) {
    final String value = " ";
    String os1 = "PLACE_ORDER";
    int oid1 = 1;
    new Expectations() {
      {
        String os = "PLACE_ORDER";
        int oid = 1;
        System.out.println("Mocked show Status");
        dao.showStatus(os, oid, value);
        result = 1;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked Status");
        return dao;
      }
    };
    int stArr = OrdersFactory.status(os1, oid1, value);
    assertEquals(1, stArr);
  }

  /**
   * @param dao dao
   */
  @Test
   public final void testUpdateOrderStatus(@Mocked final OrdersDAO dao) {
    final OrderStatus os = OrderStatus.valueOf("PLACE_ORDER");
    final String value = " ";
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    String os1 = "PLACE_ORDER";
    final List<Orders> ord = new ArrayList<Orders>();
    final Orders o = new Orders(5000, 4000, 2000, 3000, 100, os, 500, t, t, value, od);
    ord.add(o);
    new Expectations() {
      {
        String os1 = "PLACE_ORDER";
        System.out.println("Mocked show UpdateOrderStatus");
        dao.showUpdateOrderStatus(4000, os1);
        result = ord;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked updateOrderStatus");
        return dao;
      }
    };
    Orders[] stArr = OrdersFactory.updateOrderStatus(4000, os1);
    List<Orders> ord1 = new ArrayList<Orders>();
    for (Orders ord2 : stArr) {
      ord1.add(ord2);
    }
    assertEquals(ord, ord1);
  }

  /**
   * @param dao DAO
   */
  @Test
   public final void testShowOrders(@Mocked final OrdersDAO dao) {
    final OrderStatus os = OrderStatus.valueOf("PLACE_ORDER");
    final String value = " ";
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final List<Orders> ord = new ArrayList<Orders>();
    final Orders o = new Orders(5000, 4000, 2000, 3000, 100, os, 500, t, t, value, od);
    ord.add(o);
    new Expectations() {
      {
        System.out.println("Mocked show orders");
        dao.showFullOrdersList();
        result = ord;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked orders");
        return dao;
      }
    };
    Orders[] stArr = OrdersFactory.showOrders();
    List<Orders> ord1 = new ArrayList<Orders>();
    for (Orders ord2 : stArr) {
      ord1.add(ord2);
    }
    assertEquals(ord, ord1);
  }
  /**
   * @param dao dao
   * @throws ParseException for exception
   */
  @Test
  public final void testVendorHistory(@Mocked final OrdersDAO dao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final OrderStatus os = OrderStatus.valueOf("PLACE_ORDER");
    final String value = " ";
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(5000, 4000, 2000, 3000, 100, os, 500, t, t, value, od);
    ord.add(o);
    new Expectations() {
      {
        System.out.println("Mocked vendor history");
        dao.showVendorHistory(2000);
        result = ord;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked VendorDAO");
        return dao;
      }
    };
    Orders[] stArr = OrdersFactory.vendorHistory(2000);
    assertEquals(expectedSize, stArr.length);
    assertEquals(o, stArr[0]);
  }
/**
   * @param dao dao
   * @throws ParseException for exception
   */
  @Test
  public final void testCustomeHistory(@Mocked final OrdersDAO dao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ord = new ArrayList<Orders>();
    final OrderStatus os = OrderStatus.valueOf("PLACE_ORDER");
    final String value = " ";
    Date od = new java.sql.Date(new java.util.Date().getTime());
    Time t = new Time(od.getTime());
    final Orders o = new Orders(5000, 4000, 2000, 3000, 100, os, 500, t, t, value, od);
    ord.add(o);
    new Expectations() {
      {
        System.out.println("Mocked customer history");
        dao.showCustomerHistory(3000);
        result = ord;
      }
    };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("Mocked CustomerDAO");
        return dao;
      }
    };
    Orders[] stArr = OrdersFactory.customerHistory(3000);
    assertEquals(expectedSize, stArr.length);
    assertEquals(o, stArr[0]);
  }

}
