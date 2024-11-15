package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPageUI extends JFrame {
    // 화면에 표시할 패널들을 생성
    private JPanel mainPanel;

    public MyPageUI() {

        setTitle("마이페이지");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 버튼을 담을 패널 (오른쪽 세로 정렬, 고정 크기)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // 세로 정렬
        buttonPanel.setPreferredSize(new Dimension(150, 0)); // 패널의 고정 너비 설정
        // buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // 오른쪽에 20px 여백 추가

        // 오른쪽 여백을 20px로 추가하고, 패널이 오른쪽에 배치되도록 설정
        add(buttonPanel, BorderLayout.EAST); // 버튼 패널을 오른쪽에 배치

        // 각 버튼 생성 및 크기 고정
        Dimension buttonSize = new Dimension(100, 50);
        JButton libraryButton = new JButton("도서관");
        JButton cartButton = new JButton("장바구니");
        JButton infoButton = new JButton("내정보");
        JButton rentedBooksButton = new JButton("대여중인책");
        JButton logoutButton = new JButton("로그아웃");

        // 버튼 고정 크기 설정
        libraryButton.setMaximumSize(buttonSize);
        cartButton.setMaximumSize(buttonSize);
        infoButton.setMaximumSize(buttonSize);
        rentedBooksButton.setMaximumSize(buttonSize);
        logoutButton.setMaximumSize(buttonSize);

        // 버튼들을 패널에 추가하고 고정된 위치에 유지
        // buttonPanel.add(Box.createVerticalGlue()); // 상단 여백을 위한 글루
        buttonPanel.add(Box.createVerticalStrut(30));
        buttonPanel.add(libraryButton);
        buttonPanel.add(Box.createVerticalStrut(10)); 
        buttonPanel.add(cartButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(infoButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(rentedBooksButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(logoutButton);
        buttonPanel.add(Box.createVerticalGlue()); 


        mainPanel = new JPanel();

        // 전체 레이아웃 설정
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.EAST); 
        add(mainPanel, BorderLayout.CENTER);

        // 초기 화면 설정
        // cardLayout.show(mainPanel, "Library");

        libraryButton.addActionListener(e -> library());  			//도서관이동
        cartButton.addActionListener(e -> cart());       			//장바구니
        infoButton.addActionListener(e -> info());					//내정보
        rentedBooksButton.addActionListener(e -> rentedBooks()); 	//대여중인 책
        logoutButton.addActionListener(e -> logout());         		//로그아웃

        setVisible(true);
    }

    private void library() {
        this.dispose();
        new UI2().setVisible(true);
    }

    private void cart() {

    }

    private void info() {

    }

    private void rentedBooks() {
    	
    }

    private void logout() {
        // 로그아웃 처리 로직
        // new LoginFrame().setVisible(true);
    }

    public static void main(String[] args) {
        new MyPageUI();
    }
}
