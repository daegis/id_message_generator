package com.aegisa.dao;

import com.aegisa.beans.Location;
import com.aegisa.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class CommonDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    public Location getLocationById(Integer id) throws SQLException {
        String sql = "select * from idtolocation where id=?";
        Location location = queryRunner.query(sql, new BeanHandler<Location>(Location.class), id);
        return location;
    }
}
