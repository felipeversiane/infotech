package sistema.model;

import sistema.model.DAO.DAOFunctions;
import sistema.view.funcionarioView;
import sistema.view.gerenteView;
import sistema.view.loginView;

import javax.swing.*;
import java.sql.Connection;

public class loginModel {
    loginView view ;


    public loginModel(loginView view)
    {
        this.view=view;
    }
    public void login(String usuario,String senha) {
            DAOFunctions db = new DAOFunctions();
            Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
            if (db.logar(conn, usuario, senha)) {
                String tipo = db.getUsuarioTipo(conn, usuario);
                if (tipo.equals("Gerente")) {
                    ImageIcon imageIcon = new ImageIcon("src/icons/icon.png");
                    JFrame dashboardGer = new JFrame();
                    dashboardGer.pack();
                    dashboardGer.setContentPane(new gerenteView().mainPanel);
                    dashboardGer.setTitle("Dashboard gerente");
                    dashboardGer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    dashboardGer.setSize(1500, 800);
                    dashboardGer.setIconImage(imageIcon.getImage());
                    dashboardGer.setVisible(true);

                } else if (tipo.equals("Funcionário")) {
                    ImageIcon imageIcon = new ImageIcon("src/icons/icon.png");
                    JFrame dashboardFuncionario = new JFrame();
                    dashboardFuncionario.pack();
                    dashboardFuncionario.setContentPane(new funcionarioView().mainPanelF);
                    dashboardFuncionario.setTitle("Dashboard funcion\u00E1rio");
                    dashboardFuncionario.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    dashboardFuncionario.setSize(1500, 800);
                    dashboardFuncionario.setIconImage(imageIcon.getImage());
                    dashboardFuncionario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "erro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro n\u00E3o encontrado");
            }


    }
    public void mostrarSenha() {
        if(view.getShowPass().isSelected()) {
            view.getSenhaField().setEchoChar((char) 0);
        }else{
            view.getSenhaField().setEchoChar('\u2022');
        }
    }
    public void exit()
    {
        System.exit(0);
    }

}
