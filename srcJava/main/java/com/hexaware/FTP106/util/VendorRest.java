package com.hexaware.FTP106.util;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hexaware.FTP106.model.OrderStatus;
import com.hexaware.FTP106.model.Orders;
import com.hexaware.FTP106.model.Vendor;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PUT;

import com.hexaware.FTP106.factory.OrdersFactory;
import com.hexaware.FTP106.factory.VendorFactory;
/**
 * rest service for customer login.
 */
@Path("/vendor")
public class VendorRest {
    /**
     * get for clogin.
     *@param vUsername vUsername.
     *@param vPassword vpassword.
     *@return customer object.
     */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
    public final Vendor showVenLoginByRest(@QueryParam("vUserName") final String vUsername, @QueryParam("vPassword") final String vPassword) {
    System.out.println(vUsername + " " + vPassword);
    Vendor ven = VendorFactory.showVendorLogin(vUsername, vPassword);
    if (ven == null) {
      throw new NotFoundException("No such Customer." + vUsername + " Please enter valid details");
    }
    return ven;
  }
  /**
   * @param vId vid.
   * @return return.
   */
  @GET
  @Path("/{V_ID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] showVendor(@PathParam("V_ID") final int vId) {
    final Vendor[] vendor = VendorFactory.showVendor(vId);
    if (vendor == null) {
      throw new NotFoundException("no such vendor id:" + vId);
    }
    return vendor;
  }
  /**
   * @param oid oid.
   * @param argOrd argOrd.
   * @return modify
   */
  @PUT
  @Path("/modify/{oid}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final Status updateStatus(@PathParam("oid") final int oid, final Orders argOrd) {
    Status st = new Status();
    if (argOrd != null) {
      if (oid == argOrd.getOrderId()) {
        String oReason = argOrd.getOReason();
        OrdersFactory.status(argOrd.getOStatus().name(), oid, oReason);
        if (OrderStatus.CANCELLED == argOrd.getOStatus()) {
          int i1 = OrdersFactory.revert(oid);
          if (i1 == 1) {
            st.setMsg("Order Cancelled");
          }
        } else if (OrderStatus.DELIVERED == argOrd.getOStatus()) {
          st.setMsg("Order placed successfully");
        }  else {
          st.setMsg("order unsuccessful");
        }
      } else {
        st.setMsg("Enter valid oid");
      }
    } else {
      st.setMsg("Invalid input");
    }
    return st;
  }
  /**
   * @param vId vid.
   * @return return.
   */
  @GET
  @Path("placedorder/{V_ID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] showPlacedOrders(@PathParam("V_ID") final int vId) {
    String ostatus = "PLACE_ORDER";
    final Orders[] order = OrdersFactory.updateOrderStatus(vId, ostatus);
    if (order == null) {
      throw new NotFoundException("no order found");
    }
    return order;
  }
}
