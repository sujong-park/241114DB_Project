package dao;

import java.sql.*;
import java.util.*;

import dto.RentalDTO;

public class MyBookDAO {
    private Connection conn;

    public MyBookDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // 전체 책 목록 조회
    public ArrayList<RentalDTO> getRentalAllBooks() {
        ArrayList<RentalDTO> books = new ArrayList<>();
        String sql = "SELECT * FROM KRENTALTABLE";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                RentalDTO book = new RentalDTO();
                book.setRentalId(rs.getInt("RENTALNO"));  // 컬럼 이름을 실제 테이블에 맞게 수정
                book.setBookId(rs.getInt("BOOKNO"));      // 컬럼 이름을 실제 테이블에 맞게 수정
                book.setUserId(rs.getInt("USERNO"));      // 컬럼 이름을 실제 테이블에 맞게 수정
                book.setRentalDate(rs.getString("RENTALSTARTDATE")); // 대여시작일 컬럼 이름 수정
                book.setReturnDate(rs.getString("RENTALENDDATE"));  // 대여종료일 컬럼 이름 수정
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }








}

