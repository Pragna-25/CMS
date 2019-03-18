package com.hexaware.FTP106.model;

//import com.hexaware.FTP106.model.Vendor;
//import com.hexaware.FTP106.persistence.MenuDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
//import mockit.Expectations;
//import mockit.MockUp;
//import mockit.Mocked;
//import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("WELCOME");
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    Menu m = null;
    assertNull(m);
    Menu m1 = new Menu();
    assertNotNull("Menu is not null", m1);
    assertNotNull(m1);
    Menu m2 = new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS");
    assertNotEquals(m2, null);
    assertNotEquals(m2.getClass(), getClass());
    m2.setFoodId(4000);
    assertEquals(4000, m2.getFoodId());
    m2.setFoodName("DOSA");
    assertEquals("DOSA", m2.getFoodName());
    m2.setVId(3000);
    assertEquals(3000, m2.getVId());
    m2.setFoodPrice(100);
    assertEquals(100, m2.getFoodPrice());
    m2.setFoodCategory("DRINKS");
    assertEquals("DRINKS", m2.getFoodCategory());
    m2.setFoodDescription("SPICY");
    assertEquals("SPICY", m2.getFoodDescription());
    assertNotEquals(4001, m2.getFoodId());
    assertNotEquals("IDLY", m2.getFoodName());
    assertNotEquals(3001, m2.getVId());
    assertNotEquals(200, m2.getFoodPrice());
    assertNotEquals("SWEET", m2.getFoodDescription());
    assertNotEquals("COOLDRINKS", m2.getFoodCategory());
    assertNotEquals(m2, new Menu(4010, "MDOSA", 3010, 300, "COLD", "SOFTDRINKS"));
    assertEquals(m2.hashCode(), new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS").hashCode());
    assertEquals(m2, new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS"));
    System.out.println(m2);

    ArrayList al = new ArrayList();
    assertFalse(m2.equals(al));

  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  /*@Test
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
 /* @Test
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
    */
    /*Menu[] mn1 = Menu.showFullMenu();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());
}*/
/**
   * tests that empty employee list is handled correctly.
   */
  @Test
    public final  void testMenuConstructor() {
    Menu m1 = new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS");
    assertNotNull("Menu is not null", m1);
    assertNotNull(m1);
    assertEquals(4000, m1.getFoodId());
    assertEquals("DOSA", m1.getFoodName());
    assertEquals(3000, m1.getVId());
    assertEquals(100, m1.getFoodPrice());
    assertEquals("DRINKS", m1.getFoodCategory());
    assertEquals("SPICY", m1.getFoodDescription());
  }
  /**
   * tests that empty employee list is handled correctly.
   */
  @Test
    public final void testMenuObjects() {
    Menu expected = new Menu(4000, "DOSA", 3001, 200, "SWEET", "COOLDRINKS");
    Menu actual = new Menu(4000, "DOSA", 3001, 200, "SWEET", "COOLDRINKS");
    assertEquals(expected, actual);
    Menu act2 = new Menu(4010, "MDOSA", 3010, 300, "COLD", "SOFTDRINKS");
    assertNotEquals(expected, act2);
  }
}
