package com.hexaware.FTP106.factory;

import com.hexaware.FTP106.model.Vendor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP106.persistence.VendorDAO;
import mockit.Expectations;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Mock;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;
/**
 * Test class for Vendor Fcatory.
 */
@RunWith(JMockit.class)
public class VendorFactoryTest {
/**
* setup method.
*/
  @Before
  public void initInput() {
  }
  /**
   * test.
   * @param vdao vdao.
   */
  @Test
  public final void showVendorConstructor(@Mocked final VendorDAO vdao) {
    VendorFactory vend = new VendorFactory();
    assertNotNull(vend);
  }
  /**
   * test.
   * @param vdao vdao.
   */
  @Test
  public final void showVendorTest(@Mocked final VendorDAO vdao) {
    final List<Vendor> fm = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    fm.add(ve);
    new Expectations() {
      {
        System.out.println("mocked inserted");
        vdao.showVendorDetails(3000);
        result = fm;
      }
    };
    new MockUp<VendorFactory>()
    {
      @Mock
    VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;
      }

    };
    Vendor[] vfArr = VendorFactory.showVendor(3000);
    List<Vendor> rm = new ArrayList<Vendor>();
    for (Vendor ven : vfArr) {
      rm.add(ven);
    }
    assertEquals(rm, fm);
  }
  /**
   * test.
   * @param vdao vdao.
   */
  @Test
public final void showVendorloginTest(@Mocked final VendorDAO vdao) {
    final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    assertNotNull(ve);
    assertNotEquals(ve, null);
    lstexp.add(ve);
    new Expectations() {
        {
          System.out.println("mocked");
          vdao.vendorLogin("forum", "abcd");
          result = ve;
        }
    };
    new MockUp<VendorFactory>() {
      @Mock
    VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;

      }
    };
    Vendor vf = VendorFactory.showVendorLogin("forum", "abcd");
    assertEquals(vf, ve);


  }
  /**
   * test.
   * @param vdao vdao.
   */
  @Test

public final void showVendorloginTest1(@Mocked final VendorDAO vdao) {
    final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    lstexp.add(ve);
    new Expectations() {
        {
          System.out.println("mocked");
          vdao.vendorLogin("sddsd", "avgfbcd");
          result = ve;
        }
    };
    new MockUp<VendorFactory>() {

      @Mock
    VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;
      }
    };
    Vendor vf = VendorFactory.showVendorLogin("sddsd", "avgfbcd");
    assertNotEquals(vf, ve);
  }
/**
 * test.
 * @param vdao vdao.
 */
  @Test
public final void showVendorloginTest3(@Mocked final VendorDAO vdao) {
    final List<Vendor> lstexp = new ArrayList<Vendor>();
    final Vendor ve = new Vendor(3000, "forum", "forum", "abcd", "forummathuria@gmail.com", 97901156, "abcd");
    lstexp.add(ve);
    new Expectations() {
        {
          System.out.println("mocked");
          vdao.vendorLogin(null, null);
          result = null;
        }
    };
    new MockUp<VendorFactory>() {
      @Mock
    VendorDAO dao() {
        System.out.println("mocked data");
        return vdao;

      }
    };
    Vendor vf = VendorFactory.showVendorLogin(null, null);
    assertNull(vf);
  }
  /**
   * test.
   */
  @Test
  public final void testdaoMapper() {
    VendorDAO vf = VendorFactory.dao();
    assertNotNull(vf);
    Vendor[] vn = VendorFactory.showVendor(501);
    assertNotNull(vn);
  }
}



