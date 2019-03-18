package com.hexaware.FTP106.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import com.hexaware.FTP106.model.Customer;
import com.hexaware.FTP106.model.Menu;
import com.hexaware.FTP106.persistence.CustomerDAO;
import com.hexaware.FTP106.persistence.DbConnection;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

/**
 * Test class for customerfactory.
 */
@RunWith(JMockit.class)
public class CustomerFactoryTest {
/**
 * @param cdao cdao.
 */
  @Test
  public final void showCustomerLoginTest(@Mocked final CustomerDAO cdao) {
    final List<Customer> lstexp = new ArrayList<Customer>();
    final Customer cus = new Customer(2000, "latha", "latha", "1234567890", "latha@gmail.com", (float) 8000,
        "latha@123");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    lstexp.add(cus);
    new Expectations() {
      {
        System.out.println("mocked showCustomer details");
        cdao.customerLogin("latha", "latha@123");
        result = cus;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked customer login dao");
        return cdao;
      }
    };
    Customer cfA = CustomerFactory.showCustomerLogin("latha", "latha@123");
    assertEquals(cfA, cus);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void showCustomerLoginTest1(@Mocked final CustomerDAO cdao) {
    final List<Customer> lstexp = new ArrayList<Customer>();
    final Customer cus = new Customer(2000, "latha", "latha", "1234567890", "latha@gmail.com", (float) 8000,
        "latha@123");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    lstexp.add(cus);
    new Expectations() {
      {
        System.out.println("mocked showCustomer details");
        cdao.customerLogin("geetha", "geetha@123");
        result = cus;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked customer login1 dao");
        return cdao;
      }
    };
    Customer cfA = CustomerFactory.showCustomerLogin("geetha", "geetha@123");
    assertNotEquals(cfA, cus);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void showCustomerLoginTest2(@Mocked final CustomerDAO cdao) {
    final List<Customer> lstexp = new ArrayList<Customer>();
    final Customer cus = new Customer(2000, "latha", "latha", "1234567890", "latha@gmail.com", (float) 8000,
        "latha@123");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    lstexp.add(cus);
    new Expectations() {
      {
        System.out.println("mocked showCustomer details");
        cdao.customerLogin(null, null);
        result = null;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked show customer login2 dao");
        return cdao;
      }
    };
    Customer cfA = CustomerFactory.showCustomerLogin(null, null);
    assertNull(cfA);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void getCustomerDetailsTest(@Mocked final CustomerDAO cdao) {
    final List<Customer> lstexp = new ArrayList<Customer>();
    final Customer cus = new Customer(2000, "latha", "latha", "1234567890", "latha@gmail.com", 8000.00f,
        "latha@123");
    assertNotNull(cus);
    assertNotEquals(cus, null);
    lstexp.add(cus);
    new Expectations() {
      {
        System.out.println("mocked getStudents");
        cdao.showCustomerDetails(2000);
        result = lstexp;
      }
    };

    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked  getstudent details DAO");
        return cdao;
      }
    };
    Customer[] cfA = CustomerFactory.showCustomer(2000);
    List<Customer> stArr = new ArrayList<Customer>();
    for (Customer c : cfA) {
      stArr.add(c);
    }
    assertEquals(lstexp, stArr);
  }
  /**
   * @param cdao cdao
   */
  @Test
  public final void constructorTest(@Mocked final CustomerDAO cdao) {
    CustomerFactory cf = new CustomerFactory();
    assertNotNull(cf);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void walletTest(@Mocked final CustomerDAO cdao) {
    final List<Customer> wal = new ArrayList<Customer>();
    final Customer cus = new Customer(2000, "latha", "latha", "1234567890", "latha@gmail.com", 8000.00f,
        "latha@123");
    wal.add(cus);
    assertNotNull(cus);
    assertNotEquals(cus, null);
    new Expectations() {
      {
        System.out.println("mocked wallet");
        cdao.getWallet(2000);
        result = wal;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked wallet DAO");
        return cdao;
      }
    };
    Customer cfA = CustomerFactory.wallet(2000);
    assertEquals(cfA, cus);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void revertMoneyTest(@Mocked final CustomerDAO cdao) {
    int expected = 1;
    new Expectations() {
      {
        System.out.println("mocked wallet");
        cdao.revertMoney(2000, 1500.00f);
        result = 1;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked DAO");
        return cdao;
      }
    };
    int cfA = CustomerFactory.revertMoney(2000, 1500.00f);
    assertEquals(cfA, expected);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void testConnection(@Mocked final CustomerDAO cdao) {
    final DbConnection dc = new DbConnection();
    new Expectations() {
      {
        System.out.println("mocked dbconnection");
        dc.getConnect().onDemand(CustomerDAO.class);
        result = dc;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("Mocked dao");
        return cdao;
      }
    };
    assertNotNull(dc);
    assertNotEquals(dc, null);
    assertFalse(dc.equals(""));
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void daoTest(@Mocked final CustomerDAO cdao) {
    CustomerDAO cd = CustomerFactory.dao();
    System.out.println("mocked db connection");
    assertNotNull(cd);
  }
  /**
   * test for mapper.
   */
  @Test
  public final void mapperTest() {
    Customer[] cus = CustomerFactory.showCustomer(1);
    System.out.println("mocked mapper class");
    assertNotNull(cus);
  }
  /**
   * @param cdao cdao.
   * @param odao odao.
   */
  @Test
  public final void placeOrdersTest(@Mocked final CustomerDAO cdao, @Mocked final OrdersFactory odao) {
    final int cId = 2000;
    final Customer cus = new Customer(cId, "latha", "latha", "1234567890", "latha@gmail.com", 500.00f, "latha@123");
    final Menu m = new Menu(4000, "french fries", 3000, 50, "nonveg", "fried potato");
    boolean expected = true;
    new Expectations() {
      {
        System.out.println("mocked place order");
        cdao.getWallet(cId);
        result = cus;
      }
    };

    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked place order1 DAO");
        return cdao;
      }
    };

    new MockUp<OrdersFactory>() {
        @Mock
        OrdersFactory odao() {
        System.out.println("mocked order query");
        return odao;
      }
    };
    boolean actRes = CustomerFactory.placeOrder(cId, 3, m);
    assertEquals(expected, actRes);
    int i = OrdersFactory.orderQuery(4000, 3000, 2000, 100, 500);
    assertEquals(0, i);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void placeOrdersTest1(@Mocked final CustomerDAO cdao) {
    final int cId = 2000;
    final Customer cus = new Customer(cId, "latha", "latha", "1234567890", "latha@gmail.com", 100.00f, "latha@123");
    final Menu m = new Menu(4000, "french fries", 3000, 50, "nonveg", "fried potato");
    boolean expected = false;
    new Expectations() {
      {
        System.out.println("mocked place order");
        cdao.getWallet(cId);
        result = cus;
      }
    };
    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked place order1 DAO");
        return cdao;
        }
    };
    boolean actRes = CustomerFactory.placeOrder(cId, 3, m);
    assertEquals(expected, actRes);
  }
  /**
   * @param cdao cdao.
   */
  @Test
  public final void placeOrdersTest2(@Mocked final CustomerDAO cdao) {
    final int cId = 2000;
    final Customer cus = new Customer(cId, "latha", "latha", "1234567890", "latha@gmail.com", 0.00f, "latha@123");
    final Menu m = new Menu(4000, "french fries", 3000, 50, "nonveg", "fried potato");
    boolean expected = false;

    new Expectations() {
      {
        System.out.println("mocked place order");
        cdao.getWallet(cId);
        result = cus;
      }
    };

    new MockUp<CustomerFactory>() {
        @Mock
        CustomerDAO dao() {
        System.out.println("mocked place order1 DAO");
        return cdao;
      }
    };
    boolean actRes = CustomerFactory.placeOrder(cId, 3, m);
    assertEquals(expected, actRes);
  }
}
