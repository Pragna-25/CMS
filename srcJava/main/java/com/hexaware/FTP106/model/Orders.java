package com.hexaware.FTP106.model;

/**
 * Objects.
 */
import java.util.Objects;
import java.sql.Date;
import java.sql.Time;

/**
 * Orders class used to display Orders information.
 */
public class Orders {
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
