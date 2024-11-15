package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;  // 회원가입 버튼 추가

    public LoginPage() {
        // 로그인 프레임 설정
        frame = new JFrame("Login");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 로그인 폼 구성
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("로그인");
        signUpButton = new JButton("회원가입");  // 회원가입 버튼 생성

        // 로그인 버튼 클릭 이벤트 처리
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 처리를 DB나 실제 로직과 연동
                new MainPage();
                frame.dispose(); // 로그인 후 메인페이지 열고 로그인 창 닫기
            }
        });

        // 회원가입 버튼 클릭 이벤트 처리
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 페이지로 이동
                new SignUpPage();
                frame.dispose();  // 회원가입 페이지로 이동 시 로그인 페이지 닫기
            }
        });

        // 로그인 폼에 추가
        frame.add(new JLabel("아이디:"));
        frame.add(usernameField);
        frame.add(new JLabel("비밀번호:"));
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(signUpButton);  // 회원가입 버튼 추가

        // 로그인 창 설정
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);  // 화면 중앙 배치
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
