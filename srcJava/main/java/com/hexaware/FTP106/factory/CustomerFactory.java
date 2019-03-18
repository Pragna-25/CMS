package com.hexaware.FTP106.factory;

import java.util.List;
import com.hexaware.FTP106.model.Customer;
import com.hexaware.FTP106.model.Menu;
import com.hexaware.FTP106.persistence.CustomerDAO;
import com.hexaware.FTP106.persistence.DbConnection;

/**
 * MenuFactory class used to fetch menu data from database.
 *
 * @author hexware
 */
public class CustomerFactory {
  /**
   * Protected constructor.
   *
   * @return
   */
  protected CustomerFactory() {

  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static CustomerDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomerDAO.class);
  }

  /**
   * Call the data base connection.
   *
   * @return the array of menu object.
   * @param cId for customer details.
   */
  public static Customer[] showCustomer(final int cId) {
    List<Customer> customer = dao().showCustomerDetails(cId);
    return customer.toArray(new Customer[customer.size()]);
  }

  /**
   * @param cUser     for validating login.
   * @param cPassword for validating login.
   * @return d for return boolean value.
   */
  public static Customer showCustomerLogin(final String cUser, final String cPassword) {
    Customer d = dao().customerLogin(cUser, cPassword);
    if (null != d) {
      String user = d.getCUserName();
      String pass = d.getCPassword();
      if (pass.equals(cPassword) && user.equals(cUser)) {
        return d;
      } else {
        return null;
      }
    } else {
      return null;
    }
  }

  /**
   * @param cId to set.
   * @return customer.
   */
  public static Customer wallet(final int cId) {
    Customer customer = dao().getWallet(cId);
    return customer;
  }

  /**
   * @param cId     cId.
   * @param balance balance.
   * @return String message
   */
  public static int revertMoney(final int cId, final float balance) {
    int i = dao().revertMoney(cId, balance);
    return i;
  }

  /**
   * @param cuId cuId.
   * @param qty  qty.
   * @param m    m.
   * @return message.
   */
  public static boolean placeOrder(final int cuId, final int qty, final Menu m) {
    Customer c = dao().getWallet(cuId);
    float balance = c.getCWallet();
    float price = m.getFoodPrice();
    float totalPrice = price * qty;
    if (balance <= 0) {
      System.out.println("No money.");
      return false;
    } else {
      if (totalPrice > balance) {
        System.out.println("insufficient balance: " + balance);
        return false;
      } else {
        balance = balance - totalPrice;
        int fId = m.getFoodId();
        int vId = m.getVId();
        System.out.println("Total bill: " + totalPrice);
        System.out.println("Remaining balance: " + balance);
        dao().updateWallet(cuId, balance);
        OrdersFactory.orderQuery(fId, vId, cuId, qty, totalPrice);
        return true;
      }
    }
  }
}
