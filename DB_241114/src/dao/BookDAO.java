package dao;

import java.sql.*;
import java.util.*;

import dto.BookDTO;

public class BookDAO {
    private Connection conn;

    public BookDAO() {
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yourUsername", "yourPassword");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 전체 책 목록 조회
    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = new ArrayList<>();
        String sql = "SELECT * FROM Kbooks";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BookDTO book = new BookDTO();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setGenre(rs.getString("genre"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}

