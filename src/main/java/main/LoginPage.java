package main;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class LoginPage implements ActionListener{

    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Register");
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JLabel usernameLabel = new JLabel("Username");
    JTextField usernameText = new JTextField("Username");
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordField = new JPasswordField("Password");

    LoginPage(){
        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(usernameLabel);
        frame.add(usernameText);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(resetButton);

        frame.getContentPane().setBackground(Color.darkGray);
        frame.setTitle("Login");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,300);
        frame.setLayout(null);
        frame.setVisible(true);

        usernameLabel.setBounds(0, 20, 100, 20);
        usernameLabel.setFont(new Font(null, Font.PLAIN, 10));
        usernameText.setBounds(48, 20, 100, 20);
        usernameLabel.setForeground(Color.white);

        passwordLabel.setBounds(0, 40, 100, 20);
        passwordLabel.setFont(new Font(null, Font.PLAIN, 10));
        passwordField.setBounds(48, 40, 100, 20);
        passwordLabel.setForeground(Color.white);

        registerButton.setBounds(0, 220, 100, 20);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        loginButton.setBounds(0,240,700,20);
        loginButton.setFont(new Font(null, Font.PLAIN, 10));
        loginButton.addActionListener(onClick -> {
            String user = usernameText.getText();
            String password = String.valueOf(passwordField.getPassword());
            creatUserFile(user, password);

        });
        resetButton.setBounds(0, 200, 100, 20);
        resetButton.setFont(new Font(null, Font.PLAIN, 10));
        resetButton.addActionListener(onClick -> {
            usernameText.setText("");
            passwordField.setText("");
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton) {
            RegisterPage myWindow = new RegisterPage();
        }
    }

    private void creatUserFile(String username, String password) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Auth-Info" + ".json"))) {
            bufferedWriter.write(username + ", " + password);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}