package com.hexaware.FTP106.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;

import com.hexaware.FTP106.model.Customer;

/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
  /**
   * @param cId cid.
   * @return customer details.
   */
  @SqlQuery("Select * from CUSTOMER where C_ID=:C_ID")
   @Mapper(CustomerMapper.class)
   List<Customer> showCustomerDetails(@Bind("C_ID") int cId);
  /**
   * @param cUser cuser.
   * @param cPassword cpassword.
   * @return message
   */
  @SqlQuery("Select * from FTP106.Customer where C_USERNAME=:C_USERNAME AND C_PASSWORD=:C_PASSWORD ")
  @Mapper(CustomerMapper.class)
  Customer customerLogin(@Bind("C_USERNAME") String cUser, @Bind("C_PASSWORD") String cPassword);
  /**
   * @param cId cid.
   * @return wallet.
   */
  @SqlQuery("Select * from CUSTOMER where C_ID=:C_ID")
  @Mapper(CustomerMapper.class)
  Customer getWallet(@Bind("C_ID") int cId);
  /**
   * @param cId cid.
   * @param balance balance.
   * @return String message
   */
  @SqlUpdate("update CUSTOMER set C_WALLET=:C_WALLET where C_ID=:C_ID")
  @Mapper(CustomerMapper.class)
  int revertMoney(@Bind("C_ID") int cId, @Bind("C_WALLET") float balance);
  /**
   * @param cId cid.
   * @param balance balance.
   * @return String message
   */
  @SqlUpdate("update CUSTOMER set C_WALLET=:C_WALLET where C_ID=:C_ID")
  @Mapper(CustomerMapper.class)
  int updateWallet(@Bind("C_ID")int cId, @Bind("C_WALLET")float balance);
}
