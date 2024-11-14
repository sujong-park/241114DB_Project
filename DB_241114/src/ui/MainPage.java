package ui;

import javax.swing.*;
import java.awt.*;

public class MainPage {
    private JFrame frame;
    private JButton myPageButton;
    private JButton libraryButton;

    public MainPage() {
        // 메인 프레임 설정
        frame = new JFrame("Main Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // 마이페이지 버튼 설정
        myPageButton = new JButton("마이페이지");
        myPageButton.addActionListener(e -> openMyPage());

        // 도서관 버튼 설정
        libraryButton = new JButton("도서관");
        libraryButton.addActionListener(e -> openLibrary());

        // 버튼들 프레임에 추가
        frame.add(myPageButton);
        frame.add(libraryButton);

        // 프레임 설정
        frame.setSize(1050, 700);

        // 화면 가운데 배치
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    // 마이페이지 버튼 클릭 시 팝업창 열기
    private void openMyPage() {
        JFrame myPageFrame = new JFrame("My Page");
        myPageFrame.setLayout(new FlowLayout());

        // 내 정보 버튼
        JButton infoButton = new JButton("내 정보");
        infoButton.addActionListener(e -> openUserInfo());

        // 대여중 버튼
        JButton rentalsButton = new JButton("대여중");
        rentalsButton.addActionListener(e -> openRentals());

        // 장바구니 버튼
        JButton cartButton = new JButton("장바구니");
        cartButton.addActionListener(e -> openCart());

        // 버튼들 팝업에 추가
        myPageFrame.add(infoButton);
        myPageFrame.add(rentalsButton);
        myPageFrame.add(cartButton);

        // 팝업창 설정
        myPageFrame.setSize(300, 200);

        // 화면 가운데 배치
        myPageFrame.setLocationRelativeTo(null);

        myPageFrame.setVisible(true);
    }

    // 내 정보 팝업창
    private void openUserInfo() {
        JOptionPane.showMessageDialog(frame, "내 정보 팝업창");
    }

    // 대여중인 책 팝업창
    private void openRentals() {
        JOptionPane.showMessageDialog(frame, "대여중인 책 팝업창");
    }

    // 장바구니 팝업창
    private void openCart() {
        JOptionPane.showMessageDialog(frame, "장바구니 팝업창");
    }

    // 도서관 버튼 클릭 시 팝업창 열기
    private void openLibrary() {
        JFrame libraryFrame = new JFrame("도서관");
        libraryFrame.setLayout(new FlowLayout());

        // 전체(책) 버튼
        JButton allBooksButton = new JButton("전체(책)");
        allBooksButton.addActionListener(e -> openAllBooks());

        // 장르 버튼
        JButton genreButton = new JButton("장르");
        genreButton.addActionListener(e -> openGenre());

        // 작가 버튼
        JButton authorButton = new JButton("작가");
        authorButton.addActionListener(e -> openAuthor());

        // 출판사 버튼
        JButton publisherButton = new JButton("출판사");
        publisherButton.addActionListener(e -> openPublisher());

        // Top 10 버튼
        JButton top10Button = new JButton("Top 10");
        top10Button.addActionListener(e -> openTop10());

        // 버튼들 팝업에 추가
        libraryFrame.add(allBooksButton);
        libraryFrame.add(genreButton);
        libraryFrame.add(authorButton);
        libraryFrame.add(publisherButton);
        libraryFrame.add(top10Button);

        // 팝업창 설정
        libraryFrame.setSize(300, 300);

        // 화면 가운데 배치
        libraryFrame.setLocationRelativeTo(null);

        libraryFrame.setVisible(true);
    }

    // 전체 책 팝업창
    private void openAllBooks() {
        JOptionPane.showMessageDialog(frame, "전체 책 팝업창");
    }

    // 장르 팝업창
    private void openGenre() {
        JOptionPane.showMessageDialog(frame, "장르별 책 팝업창");
    }

    // 작가 팝업창
    private void openAuthor() {
        JOptionPane.showMessageDialog(frame, "작가별 책 팝업창");
    }

    // 출판사 팝업창
    private void openPublisher() {
        JOptionPane.showMessageDialog(frame, "출판사별 책 팝업창");
    }

    // Top 10 팝업창
    private void openTop10() {
        JOptionPane.showMessageDialog(frame, "Top 10 책 팝업창");
    }

    public static void main(String[] args) {
        new MainPage();
    }
}
