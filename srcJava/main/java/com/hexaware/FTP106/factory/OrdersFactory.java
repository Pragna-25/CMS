package com.hexaware.FTP106.factory;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.hexaware.FTP106.model.Customer;
import com.hexaware.FTP106.model.OrderStatus;
import com.hexaware.FTP106.model.Orders;
import com.hexaware.FTP106.persistence.OrdersDAO;
import com.hexaware.FTP106.persistence.DbConnection;

/**
 * MenuFactory class used to fetch menu data from database.
 *
 * @author hexware
 */
public class OrdersFactory {
  /**
   * Protected constructor.
   */
  protected OrdersFactory() {

  }

  /**
   * Call the data base connection.
   *
   * @return the connection object.
   */
  public static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }

  /**
   * Call the data base connection.
   *
   * @return the array of menu object.
   */
  public static Orders[] showOrders() {
    List<Orders> orders = dao().showFullOrdersList();
    return orders.toArray(new Orders[orders.size()]);

  }
  /**
   * @param vid vid.
   * @param ostatus ostatus.
   * @return orderstatus.
   */
  public static Orders[] updateOrderStatus(final int vid, final String ostatus) {
    List<Orders> orders = dao().showUpdateOrderStatus(vid, ostatus);
    return orders.toArray(new Orders[orders.size()]);
  }
/**
 * @param status status.
 * @param oid oid.
 * @param oReason oReason.
 * @return String message
 */
  public static int status(final String status, final int oid, final String oReason) {
    int s = dao().showStatus(status, oid, oReason);
    return s;
  }
  /**
  * @param oId oid.
  *.@return String message
  */
  public static int revert(final int oId) {
    Orders orders = dao().showRevert(oId);
    int cId = orders.getCId();
    float rMoney = orders.getTPrice();
    Customer c = CustomerFactory.wallet(cId);
    float balance = c.getCWallet();
    balance = rMoney + balance;
    int i = CustomerFactory.revertMoney(cId, balance);
    return i;
  }

  /**
   * @param cid cid.
   * @return customer.
   */
  public static Orders[] customerHistory(final int cid) {
    List<Orders> orders = dao().showCustomerHistory(cid);
    return orders.toArray(new Orders[orders.size()]);
  }

  /**
   * @param vid vid.
   * @return vendor.
   */
  public static Orders[] vendorHistory(final int vid) {
    List<Orders> orders = dao().showVendorHistory(vid);
    return orders.toArray(new Orders[orders.size()]);
  }
  /**
   * @param fId fid.
   * @param vId vid.
   * @param cId cid.
   * @param qty qty.
   * @param totalPrice tprice.
   * @return String message
   */
  public static int orderQuery(final int fId, final int vId, final int cId, final int qty, final float totalPrice) {
    LocalTime locTime1 = LocalTime.now();
    DateTimeFormatter tf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalTime locTime2 = LocalTime.now();
    DateTimeFormatter tf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String value = " ";
    OrderStatus o = OrderStatus.valueOf("PLACE_ORDER");
    String eTime = locTime1.format(tf1);
    String oTime = locTime2.format(tf2);
    String oDate = date.format(df);
    OrdersDAO dao = dao();
    int i = dao.insertQuery(fId, vId, cId, qty, o.name(), totalPrice, eTime, oTime, value, oDate);
    return i;
  }

}
