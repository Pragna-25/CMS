package com.hexaware.FTP106.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP106.model.Orders;

/**
 * OrdersDAO class used to fetch data from data base.
 *
 * @author hexware
 */
public interface OrdersDAO {

  /**
   * @return the all the Orders record.
   */
  @SqlQuery("Select * from Orders")
  @Mapper(OrdersMapper.class)
  List<Orders> showFullOrdersList();

  /**
   * @return all the Orders record
   */
  @SqlQuery("Select * from Orders where O_ID = :oid")
  @Mapper(OrdersMapper.class)
  List<Orders> showOrdersFromOId();

  /**
   * @param cid cid.
   * @return customerhistory.
   */
  @SqlQuery("Select * from Orders where C_ID = :C_ID")
  @Mapper(OrdersMapper.class)
  List<Orders> showCustomerHistory(@Bind("C_ID") int cid);
  /**
   * @return customer.
   */
  @SqlQuery("Select * from Orders where V_ID = :V_ID")
  @Mapper(OrdersMapper.class)
  List<Orders> showOrdersFromVId();

  /**
   * @param vid vid.
   * @param ostatus ostatus.
   * @return update.
   */
  @SqlQuery("Select * from Orders where V_ID =:V_ID and O_STATUS =:O_STATUS")
  @Mapper(OrdersMapper.class)
  List<Orders> showUpdateOrderStatus(@Bind("V_ID") int vid, @Bind("O_STATUS") String ostatus);
 /**
   * @param oid oid.
   * @param status status.
   * @param oReason oReason.
   * @return String message
   */
  @SqlUpdate("update ORDERS set O_STATUS=:O_STATUS, O_REASON=:O_REASON where ORDER_ID =:ORDER_ID ")
  @Mapper(OrdersMapper.class)
  int showStatus(@Bind("O_STATUS") String status, @Bind("ORDER_ID") int oid, @Bind("O_REASON")String oReason);
  /**
   * @param oId oid.
   * @return status.
   */
  @SqlQuery("select * from ORDERS where ORDER_ID =:ORDER_ID")
  @Mapper(OrdersMapper.class)
  Orders showRevert(@Bind("ORDER_ID") int oId);
  /**
   * @param vid vid.
   * @return vendor.
   */
  @SqlQuery("Select * from Orders where V_ID = :V_ID")
  @Mapper(OrdersMapper.class)
  List<Orders> showVendorHistory(@Bind("V_ID") int vid);
   /**
   * @param fId fid.
   * @param vId vid.
   * @param cId cid.
   * @param qty qty.
   * @param o o.
   * @param totalPrice tprice.
   * @param eTime eTime.
   * @param oTime oTime.
   * @param value value.
   * @param oDate oDate.
   * @return String message
   */
  @SqlUpdate(" INSERT INTO ORDERS(FOOD_ID,V_ID,C_ID,QTY,O_STATUS,T_PRICE,E_TIME,ORDER_TIME,O_REASON,O_DATE) VALUES (:FOOD_ID,:V_ID,:C_ID,:QTY,:O_STATUS,:T_PRICE,:E_TIME,:ORDER_TIME,:O_REASON,:O_DATE)")
   @Mapper(OrdersMapper.class)
  int insertQuery(@Bind("FOOD_ID") int fId, @Bind("V_ID") int vId, @Bind("C_ID") int cId, @Bind("QTY") int qty,
       @Bind("O_STATUS") String o, @Bind("T_PRICE") float totalPrice, @Bind("E_TIME") String eTime,
       @Bind("ORDER_TIME") String oTime, @Bind("O_REASON") String value, @Bind("O_DATE") String oDate);
}
