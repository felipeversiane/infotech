package sistema.view;

import sistema.model.DAO.DAOFunctions;
import sistema.controller.loginController;
import sistema.model.loginModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Heitor & Felipe
 */

public class loginView extends JFrame{


    loginModel model = new loginModel(this);
    loginController controller = new loginController(this,model);
    public loginView() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        db.createTables(conn);
        initComponents();
    }


    private void showPassMouseClicked(MouseEvent e) {
        try{
            controller.mostrarSenha();
        }catch (Exception exception){}
    }

    private void saveBttMouseClicked(MouseEvent e) {
        try{
            controller.Login();
        }catch(Exception exception) {
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }
    }

    private void closeBttMouseClicked(MouseEvent e) {
        controller.exit();
    }

    public JTextField LoginGetUserField() {
        return userField;
    }

    public void setUserField(JTextField userField) {
        this.userField = userField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public void setSenhaField(JPasswordField senhaField) {
        this.senhaField = senhaField;
    }

    public JCheckBox getShowPass() {
        return showPass;
    }

    public void setShowPass(JCheckBox showPass) {
        this.showPass = showPass;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Felipe Fernandes Versiane
        mainPanel = new JPanel();
        label1 = new JLabel();
        logo = new JLabel();
        label61 = new JLabel();
        label62 = new JLabel();
        senhaField = new JPasswordField();
        showPass = new JCheckBox();
        saveBtt = new JButton();
        closeBtt = new JButton();
        separator1 = new JSeparator();
        separator2 = new JSeparator();
        userField = new JTextField();

        //======== mainPanel ========
        {
            mainPanel.setBackground(new Color(0x21252f));
            mainPanel.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,mainPanel. getBorder () ) ); mainPanel. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/icons/imglateral.png")));

            //---- logo ----
            logo.setIcon(new ImageIcon(getClass().getResource("/icons/logo.png")));
            logo.setBackground(new Color(0x21252f));

            //---- label61 ----
            label61.setText("Usu\u00e1rio");
            label61.setForeground(Color.white);
            label61.setFont(new Font("Verdana", Font.PLAIN, 12));

            //---- label62 ----
            label62.setText("Senha");
            label62.setForeground(Color.white);
            label62.setFont(new Font("Verdana", Font.PLAIN, 12));

            //---- senhaField ----
            senhaField.setForeground(Color.white);
            senhaField.setBackground(new Color(0x21252f));
            senhaField.setBorder(null);
            senhaField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            //---- showPass ----
            showPass.setText("Mostrar senha");
            showPass.setForeground(Color.white);
            showPass.setBackground(new Color(0x21252f));
            showPass.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showPassMouseClicked(e);
                }
            });

            //---- saveBtt ----
            saveBtt.setText("Entrar");
            saveBtt.setForeground(Color.white);
            saveBtt.setBackground(new Color(0x21252f));
            saveBtt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    saveBttMouseClicked(e);
                }
            });

            //---- closeBtt ----
            closeBtt.setText("Sair");
            closeBtt.setForeground(Color.white);
            closeBtt.setBackground(new Color(0x21252f));
            closeBtt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    closeBttMouseClicked(e);
                }
            });

            //---- separator1 ----
            separator1.setForeground(new Color(0xcccccc));

            //---- separator2 ----
            separator2.setForeground(new Color(0xcccccc));

            //---- userField ----
            userField.setBackground(new Color(0x21252f));
            userField.setForeground(Color.white);
            userField.setBorder(null);
            userField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

            GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
            mainPanel.setLayout(mainPanelLayout);
            mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup()
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addGroup(mainPanelLayout.createParallelGroup()
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup()
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(logo, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(mainPanelLayout.createParallelGroup()
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(saveBtt, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(closeBtt, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                            .addComponent(showPass)
                                            .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(senhaField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                                .addComponent(separator2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                                            .addComponent(label62, GroupLayout.PREFERRED_SIZE, 624, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(userField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                                .addComponent(separator1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label61)
                                .addContainerGap(210, Short.MAX_VALUE))))
            );
            mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup()
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label61)
                        .addGap(3, 3, 3)
                        .addComponent(userField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label62)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senhaField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showPass)
                        .addGap(37, 37, 37)
                        .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(saveBtt)
                            .addComponent(closeBtt))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Felipe Fernandes Versiane
    public JPanel mainPanel;
    private JLabel label1;
    private JLabel logo;
    private JLabel label61;
    private JLabel label62;
    private JPasswordField senhaField;
    private JCheckBox showPass;
    private JButton saveBtt;
    private JButton closeBtt;
    private JSeparator separator1;
    private JSeparator separator2;
    public JTextField userField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
