package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegiUI extends JFrame {
	private JTextField nameField, idField;
	private JPasswordField passwordField, confirmPasswordField;
	private JButton registerButton;

	public RegiUI() {
		setTitle("회원가입");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);

		JLabel nameLabel = new JLabel("이름:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(nameLabel, gbc);

		nameField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(nameField, gbc);

		JLabel idLabel = new JLabel("아이디:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(idLabel, gbc);

		idField = new JTextField(15);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(idField, gbc);

		JLabel passwordLabel = new JLabel("비밀번호:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(passwordLabel, gbc);

		passwordField = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(passwordField, gbc);

		JLabel confirmPasswordLabel = new JLabel("비밀번호 확인:");
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(confirmPasswordLabel, gbc);

		confirmPasswordField = new JPasswordField(15);
		gbc.gridx = 1;
		gbc.gridy = 3;
		panel.add(confirmPasswordField, gbc);

		registerButton = new JButton("회원가입");
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		panel.add(registerButton, gbc);

		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleRegistration();
			}
		});

		add(panel);
	}

	private void handleRegistration() {
		String name = nameField.getText();
		String id = idField.getText();
		String password = new String(passwordField.getPassword());
		String confirmPassword = new String(confirmPasswordField.getPassword());

		if (name.isEmpty() || id.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
			JOptionPane.showMessageDialog(this, "모든 필드를 입력하세요.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (!password.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
		
		//회원가입 완료 후 로그인창 열기
		new LoginUI().setVisible(true);
		
		this.dispose();
	}
}
