package dao;


	import java.sql.*;

import dto.UserDTO;

	public class UserDAO {
	    private Connection conn;

	    // DB 연결 설정
	    public UserDAO() {
	        try {
	            // Oracle DB 연결
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // 로그인
	    public boolean login(String username, String password) {
	        String sql = "SELECT * FROM Kusers WHERE username = ? AND password = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, username);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next(); // 사용자 존재 여부 확인
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    // 회원가입
	    public boolean register(UserDTO user) {
	        String sql = "INSERT INTO Kusers (username, password, email, phone) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, user.getUsername());
	            stmt.setString(2, user.getPassword());
	            stmt.setString(3, user.getEmail());
	            stmt.setString(4, user.getPhone());
	            return stmt.executeUpdate() > 0; // 데이터 삽입 성공 여부 확인
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	}
