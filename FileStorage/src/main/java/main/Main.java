package main;

import javax.swing.SwingUtilities;
import service.AuthService;
import view.LoginFrame;

public class Main {

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame(authService).setVisible(true);
            }
        });
    }
}
