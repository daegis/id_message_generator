package com.aegisa.exec;

import com.aegisa.beans.Customer;
import com.aegisa.beans.Location;
import com.aegisa.dao.CommonDao;
import com.aegisa.utils.IDNumberUtil;
import com.aegisa.utils.NameUtil;

import javax.naming.Name;
import javax.swing.plaf.ComponentInputMapUIResource;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class LocationExec {
    public static void main(String[] args) throws SQLException {
        CommonDao dao = new CommonDao();
        Random random = new Random();
        for (int i = 0; i < 5000000; i++) {
            Location location = dao.getLocationById(random.nextInt(3151) + 1);
            String address = location.getProvincename() + location.getCityname() + location.getDistrictname();
            Integer districtid = location.getDistrictid();
            String dob = IDNumberUtil.getRandomDOB();
            String id = String.valueOf(districtid) + dob;
            id = IDNumberUtil.getRandomID(id);
//            System.out.println(id);
//            System.out.println(IDNumberUtil.getGender(id));
            Customer customer = new Customer();
            customer.setIdNumber(id);
            customer.setAddress(address);
            customer.setGender(IDNumberUtil.getGender(id));
            customer.setName(NameUtil.getRandomName());
            customer.setFirstAdd(new Date());
            customer.setMobile(NameUtil.getRandomMobile());
            customer.setCnote(String.valueOf(System.nanoTime()));
            customer.setNickname(customer.getName().charAt(0) + "" + dob.substring(0, 4));
//            System.out.println(customer);
            dao.save(customer);
        }
    }
}
