
package com.hexaware.FTP106.util;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP106.model.Menu;
import com.hexaware.FTP106.factory.MenuFactory;

/**
 * class for menurest.
 */
@Path("/menu")
public class MenuRest {
  /**
   * return menu details.
   * @return menu.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listmenu() {
    Menu[] m = MenuFactory.showMenu();
    return m;
  }
}
