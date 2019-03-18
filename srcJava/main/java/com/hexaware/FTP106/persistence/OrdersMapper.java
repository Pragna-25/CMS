package com.hexaware.FTP106.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP106.model.OrderStatus;
import com.hexaware.FTP106.model.Orders;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * MenuMapper class used to fetch menu data from database.
 *
 * @author hexware.
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
  /**
   * @param idx the index.
   * @param rs  the resultset.
   * @param ctx the context.
   * @throws SQLException for Orders
   * @return Orders object.
   */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Orders(rs.getInt("ORDER_ID"), rs.getInt("FOOD_ID"), rs.getInt("V_ID"), rs.getInt("C_ID"),
        rs.getInt("QTY"), OrderStatus.valueOf(rs.getString("O_STATUS")), rs.getFloat("T_PRICE"), rs.getTime("E_TIME"),
        rs.getTime("ORDER_TIME"), rs.getString("O_REASON"), rs.getDate("O_DATE"));
  }
}
