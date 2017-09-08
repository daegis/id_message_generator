package com.aegisa.exec;

import com.aegisa.beans.Location;
import com.aegisa.dao.CommonDao;

import java.sql.SQLException;

public class LocationExec {
    public static void main(String[] args) throws SQLException {
        CommonDao dao = new CommonDao();
        Location location = dao.getLocationById(200);
        System.out.println(location);
    }
}
