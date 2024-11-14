package ui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MyBookDAO;
import dto.BookDTO;

public class MyRentalList extends JFrame {
	private JFrame frame;
	
	// 테이블 모델 생성
	private DefaultTableModel rentalBookTableModel;
	private JTable rentalBookTable;

	
	MyBookDAO dao = null;
	
	
	
	public MyRentalList() {
	    // JFrame 설정 
		frame = new JFrame("Books Page");
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // 메인 프레임에 BorderLayout 설정
        
        frame.add(new JLabel("도서목록"), BorderLayout.NORTH);
        
        // 테이블 모델 초기화 (열 이름 정의)
        String[] columnNames = {"대여번호", "책번호", "책이름", "대여시작일", "대여종료일"};
        rentalBookTableModel = new DefaultTableModel(columnNames, 0);
        
        // JTable 생성
        rentalBookTable = new JTable(rentalBookTableModel);
        rentalBookTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

	    // 테스트 데이터를 테이블 모델에 추가
//        addTestData();

	    JScrollPane scrollPane = new JScrollPane(rentalBookTable);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    
	    // JFrame 설정
        frame.setVisible(true); // 모든 설정 후 창 보이기
        
        refreshTable();
        
	}

	// 테스트 데이터를 추가하는 메서드
//	private void addTestData() {
//		rentalTableModel.addRow(new Object[]{1, "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "Fiction", "대여중"});
//		rentalTableModel.addRow(new Object[]{2, "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", "Fiction", "대여중"});
//	    rentalTableModel.addRow(new Object[]{3, "1984", "George Orwell", "Secker & Warburg", "Dystopian", "반납"});
//	    rentalTableModel.addRow(new Object[]{4, "Pride and Prejudice", "Jane Austen", "T. Egerton", "Romance", "대여중"});
//	    rentalTableModel.addRow(new Object[]{5, "Moby-Dick", "Herman Melville", "Harper & Brothers", "Adventure", "반납"});
//	}

	// 테이블 갱신 메서드
	public void refreshTable() {
		rentalBookTableModel.setRowCount(0); // 기존 데이터 제거
		// 새로운 데이터를 추가하는 로직을 여기에 추가할 수 있음
//		addTestData();
		
//		rentalTableModel.clear();
		ArrayList<BookDTO> resultList = dao.selectAllMember();
		for (BookDTO BookDTO : resultList) {
			rentalBookTableModel.addElement(BookDTO.toString());
		}
		
		
		
	}
	
	public static void main(String[] args) {
        new MyRentalList();
    }
}
