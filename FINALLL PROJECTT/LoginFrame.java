package a9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginFrame extends JDialog {
    private static LoginFrame instance;
    private JTextField txtUsername = new JTextField(15);
    private JPasswordField txtPassword = new JPasswordField();
    private boolean isLoggedIn = false; // Field to store login status

    public static synchronized LoginFrame getInstance(JFrame parent) {
        if (instance == null) {
            instance = new LoginFrame(parent);
        }
        return instance;
    }

    private LoginFrame(JFrame parent) {
        super(parent, "Login", true); //
        setLayout(new GridLayout(3, 2));
        add(new JLabel("Username:"));
        add(txtUsername);
        add(new JLabel("Password:"));
        add(txtPassword);
        JButton btnLogin = new JButton("Login");
        JButton btnCancel = new JButton("Cancel");
        add(btnLogin);
        add(btnCancel);

        // Handle login attempt
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            if ("healthy".equals(username) && "donuts".equals(password)) {
                isLoggedIn = true; // Set logged in status
                setVisible(false); // 
                dispose(); // 
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                isLoggedIn = false; //
            }
        });

        btnCancel.addActionListener(e -> {
            isLoggedIn = false;
            setVisible(false);
            dispose(); // closed properly!!
        });


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle 
                System.exit(0); // Optionally exit 
            }
        });

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}

