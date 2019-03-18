package com.hexaware.FTP106.persistence;

import java.util.List;

import com.hexaware.FTP106.model.Vendor;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
//import org.skife.jdbi.v2.tweak.ResultSetMapper;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @param vId vId.
     * @return the all the Vendor record.
     */
  @SqlQuery("Select * from Vendor where V_ID=:V_ID")
    @Mapper(VendorMapper.class)
    List<Vendor> showVendorDetails(@Bind("V_ID")int vId);
    /**
     * @param vUser vuser.
     * @param vPassword vpassword.
     * @return message
     */
  @SqlQuery("Select * from FTP106.Vendor where V_USERNAME=:V_USERNAME AND V_PASSWORD=:V_PASSWORD ")
    @Mapper(VendorMapper.class)
    Vendor vendorLogin(@Bind("V_USERNAME") String vUser, @Bind("V_PASSWORD") String vPassword);
}
