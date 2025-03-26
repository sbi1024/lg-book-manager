package demo.bookmanager.dao;

import demo.bookmanager.common.DBManager;
import demo.bookmanager.dto.PhoneDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {

    public int insertPhone(PhoneDto phoneDto) {
        int ret = -1;
        String sql = "INSERT INTO MINI_PROJECT.temp_phone (NAME, BRAND, COLOR, CAPACITY, PRICE, STOCK) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, phoneDto.getName());
            pstmt.setString(2, phoneDto.getBrand());
            pstmt.setString(3, phoneDto.getColor());
            pstmt.setString(4, phoneDto.getCapacity());
            pstmt.setInt(5, phoneDto.getPrice());
            pstmt.setInt(6, phoneDto.getStock());

            ret = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public int updatePhone(PhoneDto phoneDto) {
        int ret = -1;
        String sql = "UPDATE MINI_PROJECT.temp_phone SET NAME = ?, BRAND = ?, COLOR = ?, CAPACITY = ?, PRICE = ?, STOCK = ? WHERE PHONE_ID = ?";

        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, phoneDto.getName());
            pstmt.setString(2, phoneDto.getBrand());
            pstmt.setString(3, phoneDto.getColor());
            pstmt.setString(4, phoneDto.getCapacity());
            pstmt.setInt(5, phoneDto.getPrice());
            pstmt.setInt(6, phoneDto.getStock());
            pstmt.setInt(7, phoneDto.getPhoneId());

            ret = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public int deletePhone(int phoneId) {
        int ret = -1;
        String sql = "DELETE FROM MINI_PROJECT.temp_phone WHERE PHONE_ID = ?";

        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, phoneId);
            ret = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public List<PhoneDto> listPhone() {
        List<PhoneDto> list = new ArrayList<>();
        String sql = "SELECT * FROM MINI_PROJECT.temp_phone";

        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PhoneDto phone = new PhoneDto();
                phone.setPhoneId(rs.getInt("PHONE_ID"));
                phone.setName(rs.getString("NAME"));
                phone.setBrand(rs.getString("BRAND"));
                phone.setColor(rs.getString("COLOR"));
                phone.setCapacity(rs.getString("CAPACITY"));
                phone.setPrice(rs.getInt("PRICE"));
                phone.setStock(rs.getInt("STOCK"));
                list.add(phone);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<PhoneDto> searchPhone(String searchWord) {
        List<PhoneDto> list = new ArrayList<>();
        String sql = "SELECT * FROM MINI_PROJECT.temp_phone WHERE NAME LIKE ?";

        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, "%" + searchWord + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PhoneDto phone = new PhoneDto();
                    phone.setPhoneId(rs.getInt("PHONE_ID"));
                    phone.setName(rs.getString("NAME"));
                    phone.setBrand(rs.getString("BRAND"));
                    phone.setColor(rs.getString("COLOR"));
                    phone.setCapacity(rs.getString("CAPACITY"));
                    phone.setPrice(rs.getInt("PRICE"));
                    phone.setStock(rs.getInt("STOCK"));
                    list.add(phone);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public PhoneDto detailPhone(int phoneId) {
        PhoneDto phone = null;
        String sql = "SELECT * FROM MINI_PROJECT.temp_phone WHERE PHONE_ID = ?";

        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, phoneId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    phone = new PhoneDto();
                    phone.setPhoneId(rs.getInt("PHONE_ID"));
                    phone.setName(rs.getString("NAME"));
                    phone.setBrand(rs.getString("BRAND"));
                    phone.setColor(rs.getString("COLOR"));
                    phone.setCapacity(rs.getString("CAPACITY"));
                    phone.setPrice(rs.getInt("PRICE"));
                    phone.setStock(rs.getInt("STOCK"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return phone;
    }
}