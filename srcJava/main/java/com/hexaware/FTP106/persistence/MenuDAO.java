package com.hexaware.FTP106.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
//import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP106.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
/**
 * @return the all the Menu record
 */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu>  show();
/**
 * @param foodId to set.
 * @return the all the Menu with fid.
 */
  @SqlQuery("select * from MENU where FOOD_ID=:FOOD_ID")
    @Mapper(MenuMapper.class)
    Menu fetchFood(@Bind("FOOD_ID") int foodId);
}
