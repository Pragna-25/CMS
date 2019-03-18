package com.hexaware.FTP106.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
/**
 * Test class for Vendor.
 */
@RunWith(JMockit.class)
public class VendorTest {
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
  public final void testVendor() {
    Vendor ven = new Vendor();
    Vendor v500 = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    assertNotEquals(v500, null);
    v500.setVId(3000);
    assertEquals(3000, v500.getVId());
    v500.setVName("forum");
    assertEquals("forum", v500.getVName());
    v500.setVUsername("forum");
    assertEquals("forum", v500.getVUsername());
    v500.setVPassword("abcd");
    assertEquals("abcd", v500.getVPassword());
    v500.setVPhone(97901156);
    assertEquals(97901156, v500.getVPhone());
    v500.setVEmail("forummathuria@gmail.com");
    assertEquals("forummathuria@gmail.com", v500.getVEmail());
    v500.setVAddress("abcd");
    assertEquals("abcd", v500.getVAddress());
    assertNotEquals(3001, v500.getVId());
    assertNotEquals("aaaa", v500.getVName());
    assertNotEquals(97564566, v500.getVPhone());
    assertNotEquals("abcd", v500.getVUsername());
    assertEquals(v500.hashCode(), new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd").hashCode());
    Vendor actual = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    Vendor expected = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    assertEquals(actual, expected);
    System.out.println(v500);
    Date d1 = new Date();
    assertEquals(false, v500.equals(d1));
    assertEquals(false, v500.equals(ven));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
 /* @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Vendor>();
      }
    };
    new MockUp<Vendor>() {
      @Mock
      VendorDAO dao() {
        return dao;
      }
    };
    Vendor[] ve = Vendor.showVendor();
    assertEquals(0, ve.length);
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
    };*/
    /*Vendor[] vn1 = Vendor.showVendor();
    assertEquals(2, vn1.length);
    assertEquals(new Vendor(100).getVId(),
        vn1[0].getVId());
    assertEquals(new Vendor(101).getVId(),
        vn1[1].getVId());
  }*/
  /**
   * comparing.
   */
  /*public final void testVednorObjects() {
    Vendor actual = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    Vendor expected = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    assertEquals(actual, expected);
  }*/
}
