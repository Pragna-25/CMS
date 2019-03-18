package com.hexaware.FTP106.factory;

import com.hexaware.FTP106.model.Menu;
//import com.hexaware.FTP106.persistence.DbConnection;
//import com.hexaware.FTP106.model.Menu;
import com.hexaware.FTP106.persistence.MenuDAO;
//import com.hexaware.FTP106.persistence.MenuMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuFactoryTest {
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
  }
  /**
   * test for menu factory.
   * @param mdao mdao.
   */
  @Test
  public final void showMenuTest(@Mocked final MenuDAO mdao) {
    MenuFactory m = null;
    assertNull(m);
    final List<Menu> lstexp = new ArrayList<Menu>();
    final Menu mn = new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS");
    lstexp.add(mn);
    new Expectations() { {
            System.out.println("mocked getmenuall");
            mdao.show();
            result = lstexp;
        } };
    new MockUp<MenuFactory>() {
        @Mock
        MenuDAO dao() {
            System.out.println("Mocked dao");
            return mdao;
        } };
    Menu[] stArr = MenuFactory.showMenu();
    List<Menu> lst = new ArrayList<Menu>();
    for (Menu m3: stArr) {
      lst.add(m3);
    }
    assertEquals(lstexp, lst);
  }
  /**
   * test for menu by food id.
   * @param m1dao m1dao.
   */
  @Test
  public final void showMenuTestByFoodId(@Mocked final MenuDAO m1dao) {
    MenuFactory m = null;
    assertNull(m);
    final Menu mn = new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS");
    new Expectations() { {
            System.out.println("mocked getmenubyfoodid");
            m1dao.fetchFood(4000);
            result = mn;
        } };
    new MockUp<MenuFactory>() {
        @Mock
        MenuDAO dao() {
            System.out.println("Mocked dao");
            return m1dao;
        } };
    Menu stArr = MenuFactory.getFood(4000);
    Menu stArr1 = MenuFactory.getFood(4001);
    assertEquals(mn, stArr);
    assertNotNull(stArr);
    assertNotEquals(stArr, stArr1);
  }
  /**
   * test for getting details.
   * @param mdao mdao.
   */
  @Test
  public final void getMenuTest(@Mocked final MenuDAO mdao) {
    final List<Menu> lstexp = new ArrayList<Menu>();
    final Menu mnu = new Menu(4000, "DOSA", 3000, 100, "SPICY", "DRINKS");

    lstexp.add(mnu);
    new Expectations() { {
        System.out.println("mocked getstudents");
        mdao.show();
        result = lstexp;
      } };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
          System.out.println("Mocked dao");
          return mdao;
      } };
    Menu[] act = MenuFactory.showMenu();
    List<Menu> lst = new ArrayList<Menu>();
    for (Menu m : act) {
      lst.add(m);
    }
    assertEquals(lstexp, lst);
  }
  /**
   * test for connection.
   * @param m4dao mdao.
   */
  @Test
  public final void testConnection(@Mocked final MenuDAO m4dao) {
    /*
    final DbConnection dc = new DbConnection();
    new Expectations() { {
        System.out.println("mocked getstudents");
        dc.getConnect().onDemand(MenuDAO.class);
        result = dc;
      } };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        DbConnection dd = new DbConnection();
        dd.getConnect().onDemand(MenuDAO.class);
          System.out.println("Mocked dao");
          return m4dao;
      } };
    assertNotNull(dc);
    assertNotEquals(dc, null);
    dc.equals("");
    */
    MenuDAO md = MenuFactory.dao();
    assertNotNull(md);
    Menu[] mn = MenuFactory.showMenu();
    assertNotNull(mn);
  }
  /**
   * test for null.
   * @param m2dao m2dao.
   */
  @Test
  public final void getMenuTestnull(@Mocked final MenuDAO m2dao) {
    final Menu mnu = null;
    new Expectations() { {
        System.out.println("mocked getstudents");
        m2dao.fetchFood(-1);
        result = mnu;
      } };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
          System.out.println("Mocked dao");
          return m2dao;
      } };
    Menu mm = MenuFactory.getFood(-1);
    assertNull(mm);
  }
  /**
   * test for constructor.
   * @param mdao mdao.
   */
  @Test
  public final void testConstructor(@Mocked final MenuDAO mdao) {
    MenuFactory m1 = new MenuFactory();
    assertNotNull("Menu is not null", m1);
    assertNotNull(m1);
  }
}
