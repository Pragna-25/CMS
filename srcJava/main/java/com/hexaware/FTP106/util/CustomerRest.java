package com.hexaware.FTP106.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP106.model.Customer;
import com.hexaware.FTP106.factory.CustomerFactory;
import javax.ws.rs.NotFoundException;
import com.hexaware.FTP106.factory.MenuFactory;
import com.hexaware.FTP106.model.Menu;
import com.hexaware.FTP106.model.Orders;
/**
 * rest service for customer login.
 */
/**
 * class status.
 */
class Status {
  private String msg;
  /**
   * constructor.
   */
  Status() {
  }
  /**
   * @return getMsg.
   */
  public final String getMsg() {
    return msg;
  }
  /**
   * @param str str.
   */
  public final void setMsg(final String str) {
    msg = str;
  }
}
/**
 * customer path.
 */
@Path("/customer")
public class CustomerRest {
  /**
    * @param cId cId.
    * @return customer
    */
  @GET
  @Path("/{C_ID}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customer[] showCustomer(@PathParam("C_ID") final int cId) {
    final Customer[] customer = CustomerFactory.showCustomer(cId);
    return customer;
  }
  /**
  * get for clogin.
  * @param cUserName cUsername.
  * @param cPassword cpassword.
  * @return customer object.
  */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
    public final Customer showCustLoginByRest(@QueryParam("cUserName") final String cUserName, @QueryParam("cPassword") final String cPassword) {
    System.out.println(cUserName + " " + cPassword);
    Customer cus = CustomerFactory.showCustomerLogin(cUserName, cPassword);
    if (cus == null) {
      throw new NotFoundException("No such Customer." + cUserName + " Please enter valid details");
    }
    return cus;
  }
  /**
   * @param cId cId.
   * @return customer object.
   */
  @GET
  @Path("/wallet/{cId}")
  @Produces(MediaType.APPLICATION_JSON)
    public final float showWalletByRest(@PathParam("cId") final int cId) {
    Customer cus = CustomerFactory.wallet(cId);
    return cus.getCWallet();
  }
  /**
   * @param custId custId.
   * @param ordArr ordArr.
   * @return return
   */
  @Path("/placeorder/{custId}")
  @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
  public final Status placeOrder(@PathParam("custId") final int custId, final Orders[] ordArr) {
    Status st = new Status();
    String retVal = "";

    if (ordArr.length > 0) {
      for (Orders ord : ordArr) {
        Customer[] cust = CustomerFactory.showCustomer(custId);
        if (cust.length > 0 && ord != null) {
          Customer c = cust[0];
          if (c.getCWallet() != 0) {
            Menu m = MenuFactory.getFood(ord.getFoodId());
            if (m != null && ord.getQty() >= 1) {
              boolean ret = CustomerFactory.placeOrder(custId, ord.getQty(), m);
              retVal += " Food Id: " + ord.getFoodId() + "   Food quantity: " + ord.getQty();
              if (ret) {
                retVal += " Order placed\n";
              } else {
                retVal += " insufficient balance\n";
              }
            } else {
              retVal += " invalid quantity\n";
            }
          } else {
            retVal += " insufficient balance\n";
          }
        } else {
          retVal += " invalid customer id\n";
        }
      }
    }
    st.setMsg(retVal);
    return st;
  }
}
