package com.hexaware.FTP106.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import java.util.Objects;
import java.sql.Date;
import java.sql.Time;

import javax.management.RuntimeErrorException;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "FTP106");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}
class Menu {
  private int foodId;
  private String foodName;
  private int vId;
  private String foodCategory;
  private int foodPrice;
  private String foodDescription;

  /**
   * @return foodId
   */
  public final int getFoodId() {
    return foodId;
  }

  /**
   * @param argFoodId is intiatialized
   */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }

  /**
   * @return foodName
   */
  public final String getFoodName() {
    return foodName;
  }

  /**
   * @param argFoodName for initialization
   */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }

  /**
   * @return VId
   */
  public final int getVId() {
    return vId;
  }

  /**
   * @param argVId for initialization
   */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }

  /**
   * @return FoodCategory
   */
  public final String getFoodCategory() {
    return foodCategory;
  }

  /**
   * @param argFoodCategory for initialization
   */
  public final void setFoodCategory(final String argFoodCategory) {
    this.foodCategory = argFoodCategory;
  }

  /**
   * @return FoodPrice
   */
  public final int getFoodPrice() {
    return foodPrice;
  }

  /**
   * @param argFoodPrice for initialization
   */
  public final void setFoodPrice(final int argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }

  /**
   * @return FoodDescription
   */
  public final String getFoodDescription() {
    return foodDescription;
  }

  /**
   * @param argFoodDescription for initialization
   */
  public final void setFoodDescription(final String argFoodDescription) {
    this.foodDescription = argFoodDescription;
  }

  /**
   * Default Constructor.
   */
  public Menu() {
  }

  /**
   * @param argFoodName        to initialize food name.
   * @param argFoodId          to initialize food id.
   * @param argFoodDescription to initialize food description.
   * @param argFoodCategory    to initialize food category.
   * @param argFoodPrice       to initialize food price.
   * @param argVId             to initialize VId.
   */
  public Menu(final int argFoodId, final String argFoodName, final int argVId, final int argFoodPrice,
      final String argFoodDescription, final String argFoodCategory) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.vId = argVId;
    this.foodPrice = argFoodPrice;
    this.foodDescription = argFoodDescription;
    this.foodCategory = argFoodCategory;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId) && Objects.equals(foodName, menu.foodName) && Objects.equals(vId, menu.vId)
        && Objects.equals(foodCategory, menu.foodCategory) && Objects.equals(foodDescription, menu.foodDescription)
        && Objects.equals(foodPrice, menu.foodPrice)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(foodId, foodName, vId, foodCategory, foodDescription, foodPrice);
  }

  /**
   * @return tostring
   */
  @Override
  public final String toString() {
    return foodId + "  " + foodName + "  " + vId + "  " + foodCategory + "  " + foodDescription + "  " + foodPrice;
  }
}
class Customer {
  private int cId;
  private String cName;
  private String cUserName;
  private String cPhone;
  private String cEmail;
  private float cWallet;
  private String cPassword;
/**
 * Default Constructor.
 */
  public Customer() {
  }
/**
 * @param argCId to initialise argCId.
 * @param argCName to initialise argCName.
 *  * @param argCUserName to initialise argCName.
 * @param argCPhone to initialise argCPhone.
 * @param argCEmail to initialise argCEmail.
 * @param argCWallet to initialise argCWallet.
 * @param argCPassword to initialise argCPassword.
 */
  public Customer(final int argCId, final String argCName, final String argCUserName,
      final String argCPhone, final String argCEmail,
      final float argCWallet, final String argCPassword) {
    this.cId = argCId;
    this.cName = argCName;
    this.cUserName = argCUserName;
    this.cPhone = argCPhone;
    this.cEmail = argCEmail;
    this.cWallet = argCWallet;
    this.cPassword = argCPassword;
  }
/**
* @param argFoodId to initialize food id.
* used to get details through constructor.
*/
  @Override
   public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customer customer = (Customer) obj;
    if (Objects.equals(cId, customer.cId) && Objects.equals(cName, customer.cName) && Objects.equals(cUserName, customer.cUserName) && Objects.equals(cPhone, customer.cPhone)
        && Objects.equals(cEmail, customer.cEmail) && Objects.equals(cWallet, customer.cWallet)
        && Objects.equals(cPassword, customer.cPassword)) {
      return true;
    }
    return false;
  }
  @Override
     public final int hashCode() {
    return Objects.hash(cId, cName, cUserName, cPhone, cEmail, cWallet, cPassword);
  }
  /**
   @return tostring
   */
  @Override
  public final String toString() {
    return cId + "  " + cName + "  " + cUserName + "  " + cPhone + "  " + cEmail + "  " + cWallet + "  " + cPassword;
  }

 /**
 * @param argCId to set.
 */
  public final void setCId(final int argCId) {
    this.cId = argCId;
  }
/**
* @return cId.
*/
  public final int getCId() {
    return cId;
  }
/**
* @param argCName the cName to set.
*/
  public final void setCName(final String argCName) {
    this.cName = argCName;
  }
/**
* @return cName.
*/
  public final String getCName() {
    return cName;
  }
/**
* @param argCUserName the cName to set.
*/
  public final void setCUserName(final String argCUserName) {
    this.cUserName = argCUserName;
  }
/**
* @return cUserName.
*/
  public final String getCUserName() {
    return cUserName;
  }
/**
* @param argCPhone the cPhone to set.
*/
  public final void setCPhone(final String argCPhone) {
    this.cPhone = argCPhone;
  }
/**
 * @return the argcPhone.
 */
  public final String getCPhone() {
    return cPhone;
  }
/**
* @param argCEmail the cEmail to set.
*/
  public final void setCEmail(final String argCEmail) {
    this.cEmail = argCEmail;
  }
/**
* @return the argCEmail
*/
  public final String getCEmail() {
    return cEmail;
  }
/**
* @param argCWallet the cWallet to set
*/
  public final void setCWallet(final float argCWallet) {
    this.cWallet = argCWallet;
  }
/**
 * @return the argCWallet.
*/
  public final float getCWallet() {
    return cWallet;
  }
/**
* @param argCPassword the cPassword to set.
*/
  public final void setCPassword(final String argCPassword) {
    this.cPassword = argCPassword;
  }
/**
 * @return the argCPassword.
 */
  public final String getCPassword() {
    return cPassword;
  }
}
class Vendor {
/**
 * vId to store vId.
 */
  private int vId;
  private String vName;
  private String vUsername;
  private String vPassword;
  private String vEmail;
  private int vPhone;
  private String vAddress;
/**
 * Constructor.
 */
  public Vendor() {

  }
/**
 * @param argVId to initialize vendorId.
 * @param argVName to initialize vendorName.
 * @param argVUserName to initialize vendorUsername.
 * @param argVPassword to initialize vendorpassword.
 * @param argVEmail to initialize vendorEmail.
 * @param argVPhone to initialize vendorPhone.
 * @param argVAddress to initialize vendor address.
 */
  public Vendor(final int argVId, final String argVName, final String argVUserName,
      final String argVPassword, final String argVEmail, final int argVPhone, final String argVAddress) {
    this.vId = argVId;
    this.vName = argVName;
    this.vUsername = argVUserName;
    this.vPassword = argVPassword;
    this.vEmail = argVEmail;
    this.vPhone = argVPhone;
    this.vAddress = argVAddress;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(vId, vendor.vId) && Objects.equals(vName, vendor.vName) && Objects.equals(vUsername, vendor.vUsername)
        && Objects.equals(vPassword, vendor.vPassword) && Objects.equals(vEmail, vendor.vEmail) && Objects.equals(vPhone, vendor.vPhone)
        && Objects.equals(vAddress, vendor.vAddress)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(vId, vName, vUsername, vPassword, vEmail, vPhone, vAddress);
  }
/**
 * @return the vId.
 */
  public final int getVId() {
    return vId;
  }
/**
 * @param argVId to store vId.
 */
  public final  void setVId(final int argVId) {
    this.vId = argVId;
  }
/**
 * @return VName.
 */
  public final String getVName() {
    return vName;
  }
  /**
 * @param argVName to store VName.
 */
  public final void setVName(final String argVName) {
    this.vName = argVName;
  }
/**
 * @return VUsername.
 */
  public final String getVUsername() {
    return vUsername;
  }
/**
 * @param argVUserName to store VUserName
 */
  public final void setVUsername(final String argVUserName) {
    this.vUsername = argVUserName;
  }
/**
 * @return VPassword.
 */
  public final String getVPassword() {
    return vPassword;
  }
/**
 * @param argVPassword to store VPassword.
 */
  public final void setVPassword(final String argVPassword) {
    this.vPassword = argVPassword;
  }
/**
 * @return EMail.
 */
  public final String getVEmail() {
    return vEmail;
  }
/**
 * @param argVEmail to store VEmail.
 */
  public final void setVEmail(final String argVEmail) {
    this.vEmail = argVEmail;
  }
/**
 * @return VPhone.
 */
  public final int getVPhone() {
    return vPhone;
  }
/**
 * @param argVPhone to store VPhone.
 */
  public final void setVPhone(final int argVPhone) {
    this.vPhone = argVPhone;
  }
/**
 * @return VAddress.
 */
  public final String getVAddress() {
    return vAddress;
  }
/**
 * @param argVAddress to store VAddress.
 */
  public final void setVAddress(final String argVAddress) {
    this.vAddress = argVAddress;
  }
/**
 * @return toString
 */
  @Override
  public final String toString() {
    return vId + " " + vName + " " + vUsername + " " + vPassword + " " + vEmail + " " + vPhone + " " + vAddress;
  }
}


enum OrderStatus {
    /**
     * Place_order.
     */
    PLACE_ORDER, DELIVERED, CANCELLED
}

class Orders {
  private int orderId;
  private int foodId;
  private int vId;
  private int cId;
  private int qty;
  private OrderStatus oStatus;
  private float tPrice;
  private Time eTime;
  private Time oTime;
  private String oReason;
  private Date oDate;

  /**
   * Default Constructor.
   */
  public Orders() {
  }

  /**
   * @param argOrderId   to initialize orderId. used to get details through
   *                     constructor.
   * @param argFoodId    to initialize food id. used to get details through
   *                     constructor.
   * @param argVId       to initialize vId. used to get details through
   *                     constructor.
   * @param argCId       to initialize cId. used to get details through
   *                     constructor.
   * @param argQty       to initialize qty. used to get details through
   *                     constructor.
   * @param argOStatus   to initialize orderStatus. used to get details through
   *                     constructor.
   * @param argTPrice    to initialize tPrice. used to get details through
   *                     constructor.
   * @param argETime     to initialize eTime. used to get details through
   *                     constructor.
   * @param argOrderTime to initialize orderTime. used to get details through
   *                     constructor.
   * @param argOReason   to initialize oReason. used to get details through
   *                     constructor.
   * @param argODate     to initialize oDate. used to get details through
   *                     constructor.
   */
  public Orders(final int argOrderId, final int argFoodId, final int argVId, final int argCId, final int argQty,
      final OrderStatus argOStatus, final float argTPrice, final Time argETime, final Time argOrderTime,
      final String argOReason, final Date argODate) {
    this.orderId = argOrderId;
    this.foodId = argFoodId;
    this.vId = argVId;
    this.cId = argCId;
    this.qty = argQty;
    this.oStatus = argOStatus;
    this.tPrice = argTPrice;
    this.eTime = argETime;
    this.oTime = argOrderTime;
    this.oReason = argOReason;
    this.oDate = new Date(argODate.getTime());
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (Objects.equals(orderId, orders.orderId) && Objects.equals(foodId, orders.foodId)
        && Objects.equals(vId, orders.vId) && Objects.equals(cId, orders.cId) && Objects.equals(qty, orders.qty)
        && Objects.equals(oStatus, orders.oStatus) && Objects.equals(tPrice, orders.tPrice)
        && Objects.equals(eTime, orders.eTime) && Objects.equals(oTime, orders.oTime)
        && Objects.equals(oReason, orders.oReason)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(orderId, foodId, vId, cId, qty, oStatus, tPrice, eTime, oTime, oReason);
  }

  /**
   * @return the orderId.
   */
  public final int getOrderId() {
    return orderId;
  }

  /**
   * @param argOrderId the orderId to set.
   */
  public final void setOrderId(final int argOrderId) {
    orderId = argOrderId;
  }

  /**
   * @return the foodId.
   */
  public final int getFoodId() {
    return foodId;
  }

  /**
   * @param argFoodId the foodId to set.
   */
  public final void setFoodId(final int argFoodId) {
    foodId = argFoodId;
  }

  /**
   * @return the vId.
   */
  public final int getVId() {
    return vId;
  }

  /**
   * @param argVId the vId to set.
   */
  public final void setVId(final int argVId) {
    vId = argVId;
  }

  /**
   * @return the cId.
   */
  public final int getCId() {
    return cId;
  }

  /**
   * @param argCId the cId to set.
   */
  public final void setCId(final int argCId) {
    cId = argCId;
  }

  /**
   * @return the qty
   */
  public final int getQty() {
    return qty;
  }

  /**
   * @param argQty the qty to set.
   */
  public final void setQty(final int argQty) {
    qty = argQty;
  }

  /**
   * @return the oStatus.
   */
  public final OrderStatus getOStatus() {
    return oStatus;
  }

  /**
   * @param argOStatus the oStatus to set.
   */
  public final void setOStatus(final OrderStatus argOStatus) {
    oStatus = argOStatus;
  }

  /**
   * @return the tPrice.
   */
  public final float getTPrice() {
    return tPrice;
  }

  /**
   * @param argTPrice the tPrice to set.
   */
  public final void setTPrice(final float argTPrice) {
    tPrice = argTPrice;
  }

  /**
   * @return the eTime.
   */
  public final Time getETime() {
    return eTime;
  }

  /**
   * @param argETime the eTime to set.
   */
  public final void setETime(final Time argETime) {
    eTime = argETime;
  }

  /**
   * @return the oTime.
   */
  public final Time getOTime() {
    return oTime;
  }

  /**
   * @param argOTime the oTime to set.
   */
  public final void setOTime(final Time argOTime) {
    oTime = argOTime;
  }

  /**
   * @return the oReason.
   */
  public final String getOReason() {
    return oReason;
  }

  /**
   * @param argOReason the oReason to set.
   */
  public final void setOReason(final String argOReason) {
    oReason = argOReason;
  }

  /**
   * @return the oDate.
   */
  public final Date getODate() {
    Date lDate = new Date(oDate.getTime());
    return lDate;
  }

  /**
   * @param argODate the oDate to set.
   */
  public final void setODate(final Date argODate) {
    oDate = new Date(argODate.getTime());
  }

  /**
   * @return toString
   */
  @Override
  public final String toString() {
    return orderId + " " + foodId + " " + vId + " " + cId + " " + qty + " " + oStatus + " " + tPrice + " " + eTime + " "
        + oTime + " " + oReason + " " + oDate;
  }
}


