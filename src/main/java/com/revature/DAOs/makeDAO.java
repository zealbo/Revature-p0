package com.revature.DAOs;

import com.revature.models.makes;
import com.revature.models.models;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class makeDAO  implements makeDAOInterface{


    @Override
    public ArrayList<makes> getAllMakes() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM makes";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<makes> makes = new ArrayList<>();
            while(rs.next()) {

                makes m = new makes(
                        rs.getString("make_name"),
                        rs.getString("make_country"),
                        rs.getString("make_CEO")
                );
                makes.add(m);

            }
            return makes;

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get all makes.");
        }
        return null;
    }

    @Override
    public ArrayList<models> getModelsByMake(String make) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM models INNER JOIN makes ON model_make_fk = make_name WHERE make_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, make);
            ResultSet rs = ps.executeQuery();
            ArrayList<models> m = new ArrayList<>();
            while(rs.next()){
                models model = new models(
                        rs.getString("model_make_fk"),
                        rs.getString("model_name"),
                        rs.getShort("model_year")
                );
                m.add(model);
            }
            return m;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get models by make.");
        }
        return null;
    }

    @Override
    public makes insertMake(makes m) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO makes(make_name, make_country, make_CEO) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getMake_name());
            ps.setString(2, m.getMake_country());
            ps.setString(3, m.getMake_CEO());
            ps.executeUpdate();
            return m;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't insert new make.");
        }
        return null;
    }

    @Override
    public void updateMakeCEO(String make, String make_CEO) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "UPDATE makes SET make_CEO = ? WHERE make_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, make_CEO);
            ps.setString(2, make);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't update MakeCEO");
        }
    }

    @Override
    public void deleteMake(String make) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "DELETE FROM makes WHERE make_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, make);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't delete make.");
        }
    }

    @Override
    public ArrayList<makes> getAllMakesAlphabetical() {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM makes ORDER BY make_name";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<makes> makesArray = new ArrayList<>();
            while(rs.next()){
                makes make = new makes(
                        rs.getString("make_name"),
                        rs.getString("make_country"),
                        rs.getString("make_CEO")
                );
                makesArray.add(make);
            }
            return makesArray;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get all makes alphabetically.");
        }
        return null;
    }
}
