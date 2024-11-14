package ui;

// 테이블 안에 button 추가한 리스트

// 구매가능 클릭 시 addCart()메서드
// 구매불가능 클기 시 addCartFalse()메서드

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.AbstractCellEditor;

public class BooksPage extends JFrame {
	private JFrame frame;
	private JPanel boardListPanel;
	
	// 테이블 모델 생성
	private DefaultTableModel tableModel;
	private JTable bookTable;

	public BooksPage() {
	    // JFrame 설정 
		frame = new JFrame("Books Page");
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // 메인 프레임에 BorderLayout 설정
        
        frame.add(new JLabel("도서목록"), BorderLayout.NORTH);
        
        // 테이블 모델 초기화 (열 이름 정의)
        String[] columnNames = {"번호", "책 이름", "작가", "출판사", "장르", "상태"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // "상태" 열만 편집 가능
            }
        };
        
        // JTable 생성
        bookTable = new JTable(tableModel);
        bookTable.setRowHeight(30); // 버튼이 잘 보이도록 행 높이를 설정

	    // 테스트 데이터를 테이블 모델에 추가
        addTestData();

	    // "선택" 버튼을 포함하는 상태 열 설정
        bookTable.getColumn("상태").setCellRenderer(new ButtonRenderer());
        bookTable.getColumn("상태").setCellEditor(new ButtonEditor(new JButton("구매가능")));
        
	    JScrollPane scrollPane = new JScrollPane(bookTable);
	    frame.add(scrollPane, BorderLayout.CENTER);
	    
	    // JFrame 설정
        frame.setVisible(true); // 모든 설정 후 창 보이기
	}

	// 테스트 데이터를 추가하는 메서드
	private void addTestData() {
	    tableModel.addRow(new Object[]{1, "The Great Gatsby", "F. Scott Fitzgerald", "Scribner", "Fiction", "구매가능"});
	    tableModel.addRow(new Object[]{2, "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", "Fiction", "구매가능"});
	    tableModel.addRow(new Object[]{3, "1984", "George Orwell", "Secker & Warburg", "Dystopian", "구매불가능"});
	    tableModel.addRow(new Object[]{4, "Pride and Prejudice", "Jane Austen", "T. Egerton", "Romance", "구매가능"});
	    tableModel.addRow(new Object[]{5, "Moby-Dick", "Herman Melville", "Harper & Brothers", "Adventure", "구매불가능"});
	}

	// "구매가능" 상태일 때 호출될 메서드
	private void addCart(String bookName) {
	    System.out.println(bookName + "이(가) 장바구니에 추가되었습니다.");
	}

	// "구매불가능" 상태일 때 호출될 메서드
	private void addCartFalse(String bookName) {
	    System.out.println(bookName + "은(는) 구매 불가능합니다.");
	}

	// 버튼 렌더러 클래스
	class ButtonRenderer extends JButton implements TableCellRenderer {
	    public ButtonRenderer() {
	        setOpaque(true);
	    }
	    
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        setText((value == null) ? "구매가능" : value.toString());
	        return this;
	    }
	}

	// 버튼 편집기 클래스
	class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
	    private JButton button;
	    private String label;
	    private boolean isPushed;
	    private int row;

	    public ButtonEditor(JButton button) {
	        this.button = button;
	        this.button.setOpaque(true);
	        this.button.addActionListener(this);
	    }

	    @Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        label = (value == null) ? "구매가능" : value.toString();
	        button.setText(label);
	        this.row = row;
	        isPushed = true;
	        return button;
	    }

	    @Override
	    public Object getCellEditorValue() {
	        isPushed = false;
	        return label;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (isPushed) {
	            String bookName = tableModel.getValueAt(row, 1).toString();
	            if ("구매가능".equals(label)) {
	                addCart(bookName); // "구매가능"일 때 addCart() 호출
	            } else {
	                addCartFalse(bookName); // "구매불가능"일 때 addCartFalse() 호출
	            }
	        }
	        fireEditingStopped();
	    }
	}

	// 테이블 갱신 메서드
	public void refreshTable() {
		tableModel.setRowCount(0); // 기존 데이터 제거
		// 새로운 데이터를 추가하는 로직을 여기에 추가할 수 있음
		addTestData();
	}
	
	public static void main(String[] args) {
        new BooksPage();
    }
}
