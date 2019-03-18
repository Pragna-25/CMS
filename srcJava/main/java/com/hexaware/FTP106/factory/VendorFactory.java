package com.hexaware.FTP106.factory;
import java.util.List;
import com.hexaware.FTP106.model.Vendor;
import com.hexaware.FTP106.persistence.DbConnection;
import com.hexaware.FTP106.persistence.VendorDAO;
//import org.skife.jdbi.v2.tweak.ResultSetMapper;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  public static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * @param vId vid.
   * @return showvendor.
   */
  public static Vendor[] showVendor(final int vId) {
    List<Vendor> vendor = dao().showVendorDetails(vId);
    return vendor.toArray(new Vendor[vendor.size()]);
  }
  /**
   * @param vUser vuser.
   * @param vPassword vpassword.
   * @return message
   */
  public static Vendor showVendorLogin(final String vUser, final String vPassword) {
    Vendor v = dao().vendorLogin(vUser, vPassword);
    if (v != null) {
      String user = v.getVUsername();
      String pass = v.getVPassword();
      //System.out.println("DataBase password Info " + pass + " " + user);
      if (pass.equals(vPassword) && user.equals(vUser)) {
        return v;
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}

