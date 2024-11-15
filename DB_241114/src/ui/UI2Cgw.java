package ui;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UI2Cgw extends JFrame {
    private JPanel ViewPanel;
    public DefaultTableModel tableModel;
    private String[] columnNames;
    private JComboBox<String> genreComboBox;

    public String getComboBoxString() {
        if (genreComboBox.getSelectedItem() != null) {
            return genreComboBox.getSelectedItem().toString();
        }
        else return "";
    }

    public UI2Cgw() {
        setTitle("전자 도서관");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        columnNames = new String[] { "NO", "제목", "작가", "출판사", "장르", "대출가능여부"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable boardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(boardTable);
        
        String[] genres = {"책이름", "장르", "출판사", "작가"};
        genreComboBox = new JComboBox<>(genres);
        inputPanel.add(new JLabel("검색 옵션:"));
        inputPanel.add(genreComboBox);
        Search serachPanel = new Search(this);

        inputPanel.add(serachPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
        
        JButton allShowButton = new JButton("전체보기");
        JButton topButton = new JButton("TOP10");
        JButton myPageButton = new JButton("마이페이지");


        buttonPanel.add(allShowButton);
        buttonPanel.add(topButton);
        buttonPanel.add(myPageButton);


        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(inputPanel, BorderLayout.NORTH);
        northPanel.add(buttonPanel, BorderLayout.CENTER);

        add(northPanel, BorderLayout.NORTH);


        ViewPanel = new JPanel();
        ViewPanel.setLayout(new BorderLayout());

        ViewPanel.add(new JLabel("목록"), BorderLayout.NORTH);
        ViewPanel.add(scrollPane, BorderLayout.CENTER);

        add(ViewPanel, BorderLayout.CENTER);


        allShowButton.addActionListener(e -> allShow());  // 전체 책 보기
        topButton.addActionListener(e -> top());         // TOP10
        myPageButton.addActionListener(e -> myPage());   // 마이페이지

        setVisible(true);
    }


    private void allShow() { 
    }

    private void top() {
        // TOP10 책 보기 로직 구현
    }

    private void myPage() {
        // 마이페이지 보기 로직 구현
    }

    public static void main(String[] args) {
        new UI2Cgw();  // UI 실행
    }
}

