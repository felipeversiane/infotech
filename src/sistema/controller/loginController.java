package sistema.controller;

import sistema.model.loginModel;
import sistema.view.loginView;

public class loginController {
    loginModel model;
    loginView loginView;
    String usuario;


    public loginController(loginView view, loginModel model) {
        this.model=model;
        this.loginView=view;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void Login() {

        this.model.login(loginView.LoginGetUserField().getText(), String.valueOf(loginView.getSenhaField().getPassword()));
    }
    public void mostrarSenha() {
        this.model.mostrarSenha();

    }
    public void exit()
    {
        model.exit();
    }

}
