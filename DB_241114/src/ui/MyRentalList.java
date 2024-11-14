package ui;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MyBookDAO;
import dto.RentalDTO;

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
        
        frame.add(new JLabel("내 대여 목록"), BorderLayout.NORTH);
        
        
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


	// 테이블 갱신 메서드
	// 테이블 갱신 메서드
	// 테이블 갱신 메서드
	public void refreshTable() {
	    // DAO 객체 초기화
	    if (dao == null) {
	        dao = new MyBookDAO();
	    }

	    // 이전 데이터 제거
	    rentalBookTableModel.setRowCount(0);

	    // 대여 기록 조회
	    ArrayList<RentalDTO> resultList = dao.getRentalAllBooks();
	    
	    if (resultList.isEmpty()) {
	        System.out.println("No rental records found.");
	    }
	    
	    for (RentalDTO rentalDTO : resultList) {
	        Object[] rowData = {
	            rentalDTO.getRentalId(),
	            rentalDTO.getUserId(),
	            rentalDTO.getBookId(),
	            rentalDTO.getRentalDate(),
	            rentalDTO.getReturnDate()
	        };
	        rentalBookTableModel.addRow(rowData);
	    }
	}



	
	public static void main(String[] args) {
        new MyRentalList();
    }
}
