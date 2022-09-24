/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UserAccount;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Legon
 */
public class DAO {

    Connection con;

    ArrayList<UserAccount> list;

    public Connection getCon() {
        return con;
    }

    public DAO() {
        try {
            con = new DBContext().getConnection();

        } catch (Exception e) {

        }
    }

    public ArrayList<UserAccount> getList() {
        return list;
    }

    public void setList(ArrayList<UserAccount> list) {
        this.list = list;
    }

    public ArrayList<UserAccount> takeinfor() {
        String sql = "select * from user ;";
        String sql2 = "SELECT address, position, company FROM MyDBG3.client;";
        ArrayList<UserAccount> ar = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String temp4 = "";
                String temp8 = "";
                String temp9 = "";
                String temp10 = "";

                if (rs.getString(4) != null) {
                    temp4 = rs.getString(4);
                }

                if (rs.getString(8) != null) {
                    temp8 = rs.getString(8);
                }
                if (rs.getString(9) != null) {
                    temp9 = rs.getString(9);
                }
                if (rs.getString(10) != null) {
                    temp10 = rs.getString(10);
                }
                int status = rs.getInt(7);
                String statuss = "";
                if (status == 0) {
                    statuss = "Deactive";
                }
                if (status == 1) {
                    statuss = "Active";
                }
                if (status == 2) {
                    statuss = "Inactive";
                }

                PreparedStatement ps2 = con.prepareStatement(sql2);
                ResultSet rs2 = ps2.executeQuery();
                String company = "";
                String position = "";
                String address = "";
                while (rs2.next()) {
                    if (rs2.getString(1) != null) {
                        company = rs2.getString(1);
                    }
                    if (rs2.getString(2) != null) {
                        position = rs2.getString(2);
                    }
                    if (rs2.getString(3) != null) {
                        address = rs2.getString(3);
                    }
                }
                ar.add(new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3),
                        temp4, rs.getString(5), rs.getString(6), statuss, temp8, temp9, temp10, company, position, address, rs.getString(11) + ""));
            }
        } catch (Exception e) {
        }

        return ar;
    }

    public void updateCurrent(String mail) throws Exception {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now).toString();

        String code = "";
        final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int N = alphabet.length();

        Random r = new Random();
        String result = "";
        for (int i = 0; i < 10; i++) {
            result += alphabet.charAt(r.nextInt(N));
        }
        code = result;

//        String sql = " update MyDBG3.user set createtime = '" + time + "' ,code='" + code + "' where email='" + mail + "';";
        String sql = " update MyDBG3.user set createtime = ?,code=? where email='" + mail + "';";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, time);
            ps.setString(2, code);
//                 ps.setString(3, mail);
//                 
//                        sql=ps.toString();
            ps.execute();

        } catch (Exception e) {
            //System.out.println("error");
        }
        JavaMailUtil.sendMail(mail, "Your link to change password screen is: http://localhost:9999/WebApplication2/CheckExpire?id=" + code + "");
    }

    public String getRandomChars(int numChars) {
        final String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzaABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int N = alphabet.length();

        Random r = new Random();
        String result = "";
        for (int i = 0; i < numChars; i++) {
            result += alphabet.charAt(r.nextInt(N));
        }
        return result;
    }

    public String register(String fullname, String mail) throws Exception {

        String password = this.getRandomChars(10);
        String sql = "insert into MyDBG3.user(password,email,full_name,avatar_url,status,role)  values('" + password + "','" + mail + "','" + fullname + "','https://www.w3schools.com/html/workplace.jpg',1,6);";

        Connection con2 = con;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
//               ps.setString(1, time);
//                ps.setString(2, code);
//                 ps.setString(3, mail);
//                 
//                        sql=ps.toString();
            ps.execute();
            JavaMailUtil.sendMail(mail, "Your password to login is: " + password);

        } catch (Exception e) {

        }
//        String sql2 = "  INSERT INTO `MyDBG3`.`client` (`user_id`) VALUES ("+id+");";
//PreparedStatement ps2 = con2.prepareStatement(sql2);
//ps2.execute();

        sql = "SELECT user_id FROM MyDBG3.user where email='" + mail + "' ;";
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {

        }
        sql = id + "";

        sql = " INSERT INTO `MyDBG3`.`client` (`user_id`) VALUES (" + id + ");";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();

        } catch (Exception e) {

        }

        return sql;
    }

    public String registerbymail(String mail, String picture) throws Exception {
        String password = this.getRandomChars(8);
        String sql = "insert into MyDBG3.user(password,email,full_name,avatar_url,status,role)  values('" + password + "','" + mail + "','New User','" + picture + "',1,6);";
        Connection con2 = con;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//               ps.setString(1, time);
//                ps.setString(2, code);
//                 ps.setString(3, mail);
//                 
//                        sql=ps.toString();
            JavaMailUtil.sendMail(mail, "Your password to login is: " + password);
            ps.execute();

        } catch (Exception e) { }
        sql = "SELECT user_id FROM MyDBG3.user where email='" + mail + "' ;";
        int id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {}
        
        sql = id + "";
        sql = " INSERT INTO `MyDBG3`.`client` (`user_id`) VALUES (" + id + ");";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) { }

        return sql;
    }

    public void mailchangepass(String id, String pass) {
        String sql = "UPDATE `MyDBG3`.`user` SET `password` = '"+pass+"' WHERE (`user_id` = "+id+");";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
           
//                 ps.setString(3, mail);
//                 
//                        sql=ps.toString();
            ps.execute();

        } catch (Exception e) {

        }

    }

    public String updateprofile(String id, String fullname, String mobie, String avatar_url, String note, String company, String position, String address) {
//          String sql = "UPDATE `MyDBG3`.`user` SET `full_name` = ?, SET `mobile` = ?, SET `avatar_url` = ?, "
//                  + "SET `note` = ?, SET `company` = ?, SET `position` = ?, SET `address` = ?,"
//                  +" WHERE (`user_id` = ?);";
        String sql = "UPDATE `MyDBG3`.`user` SET `full_name` = '" + fullname + "',  `mobile` =  '" + mobie + "',  `avatar_url` =  '" + avatar_url + "', "
                + " `note` =  '" + note + "'"
                + " WHERE (`user_id` = " + id + ");";
        String sql2 = "UPDATE `MyDBG3`.`client` SET  `company` =  '" + company + "',  `position` =  '" + position + "',  `address` =  '" + address + "'"
                + " WHERE (`user_id` = " + id + ");";
        int temp = Integer.parseInt(id);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.execute();
//               ps.setString(1, fullname);
//               ps.setString(2, mobie);
//               ps.setString(3, avatar_url);
//               ps.setString(4, note);
//               ps.setString(5, company);
//               ps.setString(6, position);
//               ps.setString(7, address);
//                ps.setInt(8, temp);
//                 ps.setString(3, mail);
//                 
//                        sql=ps.toString();

        } catch (Exception e) {

        }
        return sql;
    }
}
