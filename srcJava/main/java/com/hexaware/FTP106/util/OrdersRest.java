package com.hexaware.FTP106.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.hexaware.FTP106.factory.OrdersFactory;
import com.hexaware.FTP106.model.Orders;

import javax.ws.rs.NotFoundException;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/order")
public class OrdersRest {
  /**
   * get method.
   * @return vid.
   */
  /**
   * @param vId vId.
   * @throws NotFoundException.
   * @return orders.
   */
  @GET
  @Path("/ven/{V_ID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] showVendorHistory(@PathParam("V_ID") final int vId) {
    final Orders[] orders = OrdersFactory.vendorHistory(vId);
    if (orders == null) {
      throw new NotFoundException("no such vendor id:" + vId);
    }
    return orders;
  }
  /**
   * get method.
   * @return orders.
   */
  /**
   * @param cId cId.
   * @throws NotFoundException.
   * @return orders.
   */
  @GET
  @Path("/cus/{C_ID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] showCustomerHistory(@PathParam("C_ID") final int cId) {
    final Orders[] orders1 = OrdersFactory.customerHistory(cId);
    if (orders1 == null) {
      throw new NotFoundException("no such customer id:" + cId);
    }
    return orders1;
  }
  /**
   * @return orders.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] showOrders() {
    Orders[] orders = OrdersFactory.showOrders();
    return orders;
  }
}
