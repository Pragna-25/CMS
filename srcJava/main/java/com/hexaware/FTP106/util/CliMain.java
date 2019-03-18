package com.hexaware.FTP106.util;

import java.util.Scanner;
import com.hexaware.FTP106.factory.CustomerFactory;
import com.hexaware.FTP106.factory.MenuFactory;
import com.hexaware.FTP106.factory.OrdersFactory;
import com.hexaware.FTP106.factory.VendorFactory;
import com.hexaware.FTP106.model.Menu;
import com.hexaware.FTP106.model.Orders;
import com.hexaware.FTP106.model.Vendor;
import com.hexaware.FTP106.model.Customer;

/**
 * CliMain used as Client interface for java coading.
 *
 * @author hexware
 */
class CliMain {
  /**
   * @param cusId cusid.
   * @param venId venid.
   */
  private int cusId;
  private int venId;

  /**
   * @return the cusId
   */
  public final int getCusId() {
    return cusId;
  }

  /**
   * @param argsCusId the cusId to set
   */
  public final void setCusId(final int argsCusId) {
    this.cusId = argsCusId;
  }

  /**
   * @return the venId
   */
  public final int getVenId() {
    return venId;
  }

  /**
   * @param argsVenId the venId to set
   */
  public final void setVenId(final int argsVenId) {
    this.venId = argsVenId;
  }

  private Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Food Menu");
    System.out.println("2. Customer Dashboard");
    System.out.println("3. Vendor Dashboard");
    System.out.println("4. Exit");
    mainMenuDetails();
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      option.nextLine();

      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          intoCustomer();
          break;
        case 3:
          intoVendor();
          break;
        case 4:
          Runtime.getRuntime().halt(0);
          break;
        default:
          System.out.println("Choose between 1 to 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }

  /**
   * showFullMenu method display the menu item stored in database.
   */
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println("FOOD_ID" + "  " + "FOOD_NAME" + "               " + "FOOD_DESCRIPTION"
        + "                          " + "FOOD_CATEGORY" + "    " + "FOOD_PRICE");
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");
    for (Menu m : menu) {
      System.out.println(m.getFoodId() + "    " + m.getFoodName() + "      " + m.getFoodCategory() + "      "
          + m.getFoodDescription() + " " + m.getFoodPrice());
    }
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------------------------");
  }

  private void intoCustomer() {
    Customer c = customerLogin();
    if (c == null) {
      return;
    }
    int cId = c.getCId();
    setCusId(cId);
    boolean flag = true;
    while (flag) {
      System.out.println("1.Place order");
      System.out.println("2.Customer Order history");
      System.out.println("3.Show customer wallet");
      System.out.println("4.Customer details");
      System.out.println("5.Return to main menu");
      System.out.println("Enter your choice: ");
      int ch = option.nextInt();
      switch (ch) {
        case 1:
          placeOrders();
          break;
        case 2:
          customerHistory();
          break;
        case 3:
          showWallet();
          break;
        case 4:
          showCustomer();
          break;
        case 5:
          flag = false;
          mainMenu();
          break;
        default:
          System.out.println("Choose between 1-5");
      }
    }
  }

  // Customer Login
  private Customer customerLogin() {
    System.out.println("Customer Login");
    System.out.println("Enter UserName: ");
    String cUser = option.next();
    System.out.println("Enter Password: ");
    String cPassword = option.next();
    Customer c = CustomerFactory.showCustomerLogin(cUser, cPassword);
    if (null != c) {
      String cName = c.getCName();
      System.out.println("Welcome " + cName);
    } else {
      System.out.println("Invalid user.");
    }
    return c;
  }

  private void placeOrders() {
    showFullMenu();
    int cId = getCusId();
    System.out.println("Enter the food Id");
    Integer foodId = option.nextInt();
    Menu ob = MenuFactory.getFood(foodId);
    if (ob != null) {
      System.out.println(ob);
      System.out.println("Enter the Quantity");
      int qty = option.nextInt();
      if (qty >= 1 && qty <= 100) {
        boolean b = CustomerFactory.placeOrder(cId, qty, ob);
        if (b) {
          System.out.println("order placed");
        } else {
          System.out.println("order failed");
        }
      } else {
        System.out.println("enter in the range 1 and 100");
      }
    } else {
      System.out.println("Invalid food id.\nEnter a valid food Id.");
      placeOrders();
    }
  }

  private void customerHistory() {
    int cId = getCusId();
    Orders[] orders = OrdersFactory.customerHistory(cId);
    System.out.println("Customer Order history");
    System.out.println("ORDER ID" + "  " + "FOOD ID" + "  " + "VENDOR ID" + "  " + "CUSTOMR ID" + "  " + "QUANTITY"
        + "  " + "STATUS" + "  " + "TOTAL PRICE" + "  " + "ESTIMATED TIME" + "  " + "ORDERED TIME" + "  " + "REASON"
        + "  " + "ORDERED DATE");
    for (Orders o : orders) {
      System.out.println(o);
    }
  }

  private void showWallet() {
    int cId = getCusId();
    Customer cus = CustomerFactory.wallet(cId);
    System.out.println("Available money: $" + cus.getCWallet());
  }

  private void showCustomer() {
    int cId = getCusId();
    Customer[] customer = CustomerFactory.showCustomer(cId);
    System.out.println("Cid   CName    CUsername   CPhone    CMail     CWallet   CPassword");
    for (Customer c : customer) {
      System.out.println(c);
    }
  }

  private void intoVendor() {
    Vendor v = vendorLogin();
    if (v == null) {
      return;
    }
    int id = v.getVId();
    setVenId(id);
    boolean flag = true;
    while (flag) {
      System.out.println("1.Vendor Order history");
      System.out.println("2.Accept/Reject");
      System.out.println("3.Show vendor");
      System.out.println("4.Return to main menu");
      System.out.print("Enter your choice: ");
      int ch = option.nextInt();
      switch (ch) {
        case 1:
          vendorHistory();
          break;
        case 2:
          updateOrderStatus();
          break;
        case 3:
          showVendor();
          break;
        case 4:
          flag = false;
          mainMenu();
          break;
        default:
          System.out.println("choose between 1-4");
      }
    }
    option.nextLine();
  }

  // Vendor Login
  private Vendor vendorLogin() {
    System.out.println("Vendor Login");
    System.out.println("UserName: ");
    String vUser = option.next();
    System.out.println("Password: ");
    String vPassword = option.next();
    Vendor v = VendorFactory.showVendorLogin(vUser, vPassword);
    if (v != null) {
      String vName = v.getVUsername();
      System.out.println("Welcome " + vName);
    } else {
      System.out.println("Invalid");
    }
    return v;
  }

  private void vendorHistory() {
    int vId = getVenId();
    Orders[] orders = OrdersFactory.vendorHistory(vId);
    System.out.println("Vendor Order history");
    System.out.println("ORDER ID" + " " + "FOOD ID" + " " + "VENDOR ID" + " " + "CUSTOMER ID" + " " + "QUANTITY" + "  "
        + "STATUS" + "     " + "TOTAL PRICE" + "  " + "ESTIMATED TIME" + "  " + "ORDERED TIME" + "  " + "REASON" + "  "
        + "ORDERED DATE");
    for (Orders o : orders) {
      System.out.println(o);
    }
  }

  /**
   * update orderstatus.
   */
  public void updateOrderStatus() {
    int vId = getVenId();
    String oReason = "";
    System.out.println("Order status");
    String ostatus = "PLACE_ORDER";
    Orders[] orders = OrdersFactory.updateOrderStatus(vId, ostatus);
    for (Orders o : orders) {
      System.out.println("OrderID   FoodId    CustomerID   VendorID   Quantity    Price     Date    OrderTime");
      System.out.println(o.getOrderId() + "  " + o.getFoodId() + "  " + o.getCId() + "  " + o.getVId() + "  "
          + o.getQty() + "   " + o.getTPrice() + "     " + o.getODate() + "    " + o.getOTime());
    }
    System.out.println("Enter Order id:");
    int oid = option.nextInt();
    int ooid = -1;
    for (Orders oo : orders) {
      if (oid == oo.getOrderId()) {
        ooid = oid;
        break;
      }
    }
    if (ooid == -1) {
      System.out.println("invalid order id");
      return;
    }
    String ordstatus = " ";
    System.out.println("ACCEPT/DENY");
    String st = option.next();
    if (st.equals("ACCEPT")) {
      ordstatus = "DELIVERED";
      oReason = "Thank You for Visting";
      OrdersFactory.status(ordstatus, oid, oReason);
    } else if (st.equals("DENY")) {
      ordstatus = "CANCELLED";
      System.out.println("Reason for Cancelling the Order \n 1.No Sufficient food  2.No Sufficient Staff");
      System.out.println("Enter option");
      int op = option.nextInt();
      switch (op) {
        case 1:
          System.out.println("Sorry! No sufficient food");
          oReason = "Sorry! No sufficient food";
          OrdersFactory.status(ordstatus, oid, oReason);
          int i1 = OrdersFactory.revert(oid);
          if (i1 == 1) {
            System.out.println("revert successfull");
          }
          break;
        case 2:
          System.out.println("Sorry! No Sufficient Staff");
          oReason = "Sorry! No Sufficient Staff";
          OrdersFactory.status(ordstatus, oid, oReason);
          int i2 = OrdersFactory.revert(oid);
          if (i2 == 1) {
            System.out.println("revert successfull");
          }
          break;
        default:
          System.out.println("Sorry for the cancellation,amount reverted.");
          oReason = "Sorry for the cancellation";
          OrdersFactory.status(ordstatus, oid, oReason);
          OrdersFactory.revert(oid);
      }
    } else {
      System.out.println("Invalid input.");
    }
  }

  private void showVendor() {
    int vId = getVenId();
    Vendor[] vendor = VendorFactory.showVendor(vId);
    System.out.println("Vendor details.");
    System.out
        .println("Vid  VendorName  VendorUsername    VendorPassword    VendorEmail    VendorPhone    VendorAddress");
    for (Vendor v : vendor) {
      System.out.println(v);
    }
  }

  /**
   * @param args args.
   */
  public static void main(final String[] args) {
    final CliMain obj = new CliMain();
    obj.mainMenu();
  }
}
