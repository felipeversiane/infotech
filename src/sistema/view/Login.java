package sistema.view;

import javax.swing.*;

public class Login
{
    public static void main(String[] args) {
        JFrame telaLogin = new JFrame("Tela de Login");
        telaLogin.setContentPane(new loginView().getMainPanel());
        telaLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        telaLogin.pack();
        telaLogin.setResizable(false);
        telaLogin.setVisible(true);
        telaLogin.setSize(400,440);

    }
}
