package com.niko.dao;

import com.niko.pojo.ApplyInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplyInfoDaoImpl extends BaseDao implements ApplyInfoDao {

    @Override
    public void addApplyInfo(ApplyInfo applyInfo) throws Exception {
        Connection conn = getConnection();
        String sql = "INSERT INTO apply_info (name, age, class, game) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, applyInfo.getName());
            ps.setInt(2, applyInfo.getAge());
            ps.setString(3, applyInfo.getClassName());
            ps.setString(4, applyInfo.getGame());
            ps.executeUpdate();
            System.out.println("报名成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    @Override
    public List<ApplyInfo> getApplyInfoByGame(String game) throws Exception {
        List<ApplyInfo> list = new ArrayList<>();
        Connection conn = getConnection();
        String sql = "SELECT * FROM apply_info WHERE game = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, game);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ApplyInfo applyInfo = new ApplyInfo();
                applyInfo.setApplyId(rs.getInt("applyId"));
                applyInfo.setName(rs.getString("name"));
                applyInfo.setAge(rs.getInt("age"));
                applyInfo.setClassName(rs.getString("class"));
                applyInfo.setGame(rs.getString("game"));
                list.add(applyInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<ApplyInfo> getApplyInfoByClass(String className) throws Exception {
        List<ApplyInfo> list = new ArrayList<>();
        Connection conn = getConnection();
        String sql = "SELECT * FROM apply_info WHERE class = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, className);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ApplyInfo applyInfo = new ApplyInfo();
                applyInfo.setApplyId(rs.getInt("applyId"));
                applyInfo.setName(rs.getString("name"));
                applyInfo.setAge(rs.getInt("age"));
                applyInfo.setClassName(rs.getString("class"));
                applyInfo.setGame(rs.getString("game"));
                list.add(applyInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
        return list;
    }

    @Override
    public void deleteApplyInfoByName(String name) throws Exception {
        Connection conn = getConnection();
        String sql = "DELETE FROM apply_info WHERE name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("取消报名成功！");
            } else {
                System.out.println("未找到该学生的报名信息！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }
}
