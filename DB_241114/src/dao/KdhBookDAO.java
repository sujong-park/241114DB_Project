package dao;

import dto.KdhBookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KdhBookDAO {
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String userid = "scott";
    private static final String passwd = "tiger";

    public List<KdhBookDTO> getBooks() {
        List<KdhBookDTO> books = new ArrayList<>();
        String query = """
            SELECT B.BOOKNO, B.BOOKNAME, A.AUTHORNAME AS AUTHOR, P.PUBLISHERNAME AS PUBLISHER
            FROM KBOOKTABLE B
            JOIN KAUTHORTABLE A ON B.AUTHORNO = A.AUTHORNO
            JOIN KPUBLISHERTABLE P ON B.PUBLISHERNO = P.PUBLISHERNO
        """;

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                KdhBookDTO book = new KdhBookDTO(
                    rs.getInt("BOOKNO"),
                    rs.getString("BOOKNAME"),
                    rs.getString("AUTHOR"),
                    rs.getString("PUBLISHER")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    // 대여 메소드
    public void rentBook(int bookNo, int userNo) {
        String rentalSql = "INSERT INTO KRENTALTABLE (BOOKNO, USERNO, RENTALSTARTDATE, RENTALENDDATE) VALUES (?, ?, SYSDATE, SYSDATE + 7)";
        String deleteSql = "DELETE FROM KSHOPPINGCARTTABLE WHERE BOOKNO = ?";

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement rentalStmt = con.prepareStatement(rentalSql);
             PreparedStatement deleteStmt = con.prepareStatement(deleteSql)) {
            
            // 대여 정보 삽입
            rentalStmt.setInt(1, bookNo);
            rentalStmt.setInt(2, userNo);
            rentalStmt.executeUpdate();

            // 장바구니에서 삭제
            deleteStmt.setInt(1, bookNo);
            deleteStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 특정 책 삭제 메소드
    public void deleteBookFromCart(int bookNo, int userNo) {
        String sql = "DELETE FROM KSHOPPINGCARTTABLE WHERE BOOKNO = ? USERNO = ?";
        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, bookNo);
            pstmt.setInt(2, userNo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 전체 삭제 메소드
    public void deleteAllFromCart(int userNo) {
        String sql = "DELETE FROM KSHOPPINGCARTTABLE WHERE USERNO = ?";
        try (Connection con = DriverManager.getConnection(url, userid, passwd);
        		PreparedStatement pstmt = con.prepareStatement(sql)) {
        	pstmt.setInt(1, userNo);
        	pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


