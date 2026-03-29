package org.example.DBops;

import org.example.databaseConnectivity.DBConnection;
import org.example.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public static void addMember(Member member){

        try{
            Connection conn = DBConnection.getConnection();
            String addQuery = "INSERT INTO members(f_name, l_name, phone_number) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(addQuery);
            ps.setString(1, member.getF_name());
            ps.setString(2, member.getL_name());
            ps.setLong(3, member.getContact_num());

            ps.executeUpdate();
            System.out.println("Member added successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void viewMember(){

        try{
            Connection conn = DBConnection.getConnection();

            String showQuery = "SELECT * FROM members";
            PreparedStatement ps = conn.prepareStatement(showQuery);
            ResultSet rs =ps.executeQuery();

            while(rs.next()){
                System.out.println(
                        rs.getInt("library_id") + " | " +
                                rs.getString("f_name") + " | " +
                                rs.getString("l_name") + " | " +
                                rs.getLong("phone_number")
                );
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
