package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUpPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField emailField;
    private JButton signUpButton;

    public SignUpPage() {
        frame = new JFrame("Sign Up");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 회원가입 폼 구성
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailField = new JTextField(20);
        signUpButton = new JButton("회원가입");

        // 회원가입 버튼 클릭 이벤트
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 회원가입 처리 (DB나 실제 로직과 연동)
                JOptionPane.showMessageDialog(frame, "회원가입 완료!");
                frame.dispose(); // 회원가입 후 로그인 화면으로 돌아가기
                new LoginPage();
            }
        });

        // 회원가입 폼에 추가
        frame.add(new JLabel("아이디:"));
        frame.add(usernameField);
        frame.add(new JLabel("비밀번호:"));
        frame.add(passwordField);
        frame.add(new JLabel("이메일:"));
        frame.add(emailField);
        frame.add(signUpButton);

        // 회원가입 창 설정
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);  // 화면 중앙 배치
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
