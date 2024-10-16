package com.revature.DAOs;

import com.revature.models.makes;
import com.revature.models.models;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class modelDAO implements modelDAOInterface{
    @Override
    public ArrayList<models> getAllModels() {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM models";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            ArrayList<models> models = new ArrayList<>();
            while(rs.next()) {

                models m = new models(
                        rs.getString("model_make_fk"),
                        rs.getString("model_name"),
                        rs.getShort("model_year")
                );
                models.add(m);

            }
            return models;

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get all models.");
        }
        return null;
    }

    @Override
    public makes getMakeByModels(String model) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM makes INNER JOIN models ON make_name = model_make_fk WHERE model_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, model);
            ResultSet rs = ps.executeQuery();
            rs.next();
            makes m = new makes(
                 rs.getString("make_name"),
                 rs.getString("make_country"),
                 rs.getString("make_CEO")
            );
            return m;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get make by models.");
        }
        return null;
    }

    @Override
    public models insertModel(models m) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO models(model_make_fk, model_name, model_year) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, m.getModel_make_fk());
            ps.setString(2, m.getModel_name());
            ps.setShort(3, m.getModel_year());
            ps.executeUpdate();
            return m;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't insert new model.");
        }
        return null;
    }

    @Override
    public short updateModelYear(String model, short model_year) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "UPDATE models SET model_year = ? WHERE model_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setShort(1, model_year);
            ps.setString(2, model);
            ps.executeUpdate();
            return model_year;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't update model year.");
        }
        return -1; //if update fails
    }

    @Override
    public void deleteModel(String model) {
        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "DELETE FROM models WHERE model_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, model);
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't delete model.");
        }
    }

    @Override
    public ArrayList<models> getAllModelsReverseChronological() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM models ORDER BY model_year DESC";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<models> modelsArray = new ArrayList<>();
            while(rs.next()){
                models model = new models(
                        rs.getString("model_make_fk"),
                        rs.getString("model_name"),
                        rs.getShort("model_year")
                );
                modelsArray.add(model);
            }
            return modelsArray;

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get all models alphabetically.");
        }
        return null;
    }
}
