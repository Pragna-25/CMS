package com.hexaware.FTP106.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP106.model.Customer;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Menu
       */
    return new Customer(rs.getInt("C_ID"),
       rs.getString("C_NAME"),
       rs.getString("C_USERNAME"),
       rs.getString("C_PHONE"),
       rs.getString("C_EMAIL"),
       rs.getFloat("C_WALLET"),
       rs.getString("C_PASSWORD"));
  }
}
