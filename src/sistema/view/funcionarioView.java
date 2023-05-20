package sistema.view;

import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
import sistema.model.DAO.DAOFunctions;
import sistema.controller.funcionarioController;
import sistema.model.funcionarioModel;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Heitor
 */

public class funcionarioView {
    funcionarioModel model = new funcionarioModel(this);
    funcionarioController controller = new funcionarioController(model,this);
    public funcionarioView() {

        funcionarioModel model = new funcionarioModel(this);
        funcionarioController controller = new funcionarioController(model,this);
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        db.createTables(conn);
        initComponents();
        corAleatoria();
        homeDateLbl.setText(DataPorExtenso());
    }

    private String DataPorExtenso()
    {
        return controller.dataAtual();
    }

    private void corAleatoria(){
        controller.mudarCor();
    }


    // Mouse clicked
    private void homeBttMouseClicked(MouseEvent e) {
        corAleatoria();
        homePanelF.setVisible(true);
        cadClientePanel.setVisible(false);
        efetuarVendaPanel.setVisible(false);
        listaClientesPanel.setVisible(false);
        listaProdutosPanel.setVisible(false);
    }

    private void efetuarVendaBttMouseClicked(MouseEvent e) {
        homePanelF.setVisible(false);
        cadClientePanel.setVisible(false);
        efetuarVendaPanel.setVisible(true);
        listaClientesPanel.setVisible(false);
        listaProdutosPanel.setVisible(false);
    }

    private void cliBtt1MouseClicked(MouseEvent e) {
        homePanelF.setVisible(false);
        cadClientePanel.setVisible(true);
        efetuarVendaPanel.setVisible(false);
        listaClientesPanel.setVisible(false);
        listaProdutosPanel.setVisible(false);
    }

    private void listaClientesBttMouseClicked(MouseEvent e) {
        homePanelF.setVisible(false);
        cadClientePanel.setVisible(false);
        efetuarVendaPanel.setVisible(false);
        listaClientesPanel.setVisible(true);
        listaProdutosPanel.setVisible(false);
        fillFclienteTable();
    }

    private void listaProdutosBttMouseClicked(MouseEvent e) {
        homePanelF.setVisible(false);
        cadClientePanel.setVisible(false);
        efetuarVendaPanel.setVisible(false);
        listaClientesPanel.setVisible(false);
        listaProdutosPanel.setVisible(true);
        fillFprodutoTable();
    }

    // Mouse entered
    private void homeBttMouseEntered(MouseEvent e) {
        homeBtt.setBackground(new Color(37, 98, 156));
    }
    private void efetuarVendaBttMouseEntered(MouseEvent e) {
        efetuarVendaBtt.setBackground(new Color(56, 118, 29));
    }
    private void cliBtt1MouseEntered(MouseEvent e) {
        cliBtt1.setBackground(new Color(37, 98, 156));
    }

    private void listaClientesBttMouseEntered(MouseEvent e) {
        listaClientesBtt.setBackground(new Color(37, 98, 156));
    }
    private void listaProdutosBttMouseEntered(MouseEvent e) {
        listaProdutosBtt.setBackground(new Color(37, 98, 156));
    }

    // Mouse exited
    private void homeBttMouseExited(MouseEvent e) {
        homeBtt.setBackground(new Color(33, 37, 47));
    }
    private void efetuarVendaBttMouseExited(MouseEvent e) {
        efetuarVendaBtt.setBackground(new Color(33, 37, 47));
    }
    private void cliBtt1MouseExited(MouseEvent e) {
        cliBtt1.setBackground(new Color(33, 37, 47));
    }

    private void listaClientesBttMouseExited(MouseEvent e) {
        listaClientesBtt.setBackground(new Color(33, 37, 47));
    }
    private void listaProdutosBttMouseExited(MouseEvent e) {
        listaProdutosBtt.setBackground(new Color(33, 37, 47));
    }

    // Mouse pressed
    private void homeBttMousePressed(MouseEvent e) {
        homeBtt.setBackground(new Color(50, 129, 244));
    }
    private void efetuarVendaBttMousePressed(MouseEvent e) {
        efetuarVendaBtt.setBackground(new Color(87, 187, 45));
    }
    private void cliBtt1MousePressed(MouseEvent e) {
        cliBtt1.setBackground(new Color(50, 129, 244));
    }

    private void listaClientesBttMousePressed(MouseEvent e) {
        listaClientesBtt.setBackground(new Color(50, 129, 244));
    }
    private void listaProdutosBttMousePressed(MouseEvent e) {
        listaProdutosBtt.setBackground(new Color(50, 129, 244));
    }

    // Mouse released
    private void homeBttMouseReleased(MouseEvent e) {
        homeBtt.setBackground(new Color(37, 98, 156));
    }
    private void efetuarVendaBttMouseReleased(MouseEvent e) {
        efetuarVendaBtt.setBackground(new Color(56, 118, 29));
    }
    private void cliBtt1MouseReleased(MouseEvent e) {
        cliBtt1.setBackground(new Color(37, 98, 156));
    }
    private void listaClientesBttMouseReleased(MouseEvent e) {
        listaClientesBtt.setBackground(new Color(37, 98, 156));
    }
    private void listaProdutosBttMouseReleased(MouseEvent e) {
        listaProdutosBtt.setBackground(new Color(37, 98, 156));
    }




    // Cadastro cliente
    private void saveBttMouseClicked(MouseEvent e)
    {
        try{
            controller.CadClienteSalvarBtt();
            controller.CadClienteClearBtt();
            JOptionPane.showMessageDialog(this.getMainPanelF(), "Novo cliente cadastrado com sucesso");
        }
        catch(Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMessage());
            controller.CadClienteSalvarBtt();
        }

    }

    private void clearBttMouseClicked(MouseEvent e)
    {
        try {
            controller.CadClienteClearBtt();
        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }
    }

    // Efetuar venda
    private void SaveBttVendasMouseClicked(MouseEvent e)
    {
        try{
            controller.VendasSalvarBtt();
            JOptionPane.showMessageDialog(null, "Venda efetuada");
        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }
    }
    private void ClearBttVendasMouseClicked(MouseEvent e) {
        try {
            controller.VendasClearBtt();
        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }

    }
    private void addBttVendasMouseClicked(MouseEvent e) {
        try {
            controller.addVenda();
        }catch(Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }

    }

    public void fillFclienteTable() {
        try{
            controller.fillTableCliente();
        }catch (Exception exception)
        {
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }
    }

    public void fillFprodutoTable()
    {
        try{
            controller.fillTableProduto();
        }catch (Exception exception){
            JOptionPane.showMessageDialog(null,exception.getMessage());
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Felipe Fernandes Versiane
        mainPanelF = new JPanel();
        sidePanel = new JPanel();
        infoPanel = new JPanel();
        homeBtt = new JPanel();
        label1 = new JLabel();
        efetuarVendaBtt = new JPanel();
        label57 = new JLabel();
        cliBtt1 = new JPanel();
        label4 = new JLabel();
        listaClientesBtt = new JPanel();
        label58 = new JLabel();
        listaProdutosBtt = new JPanel();
        label59 = new JLabel();
        centralPanel = new JPanel();
        homePanelF = new JPanel();
        label14 = new JLabel();
        greetLbl = new JLabel();
        homeDateLbl = new JLabel();
        efetuarVendaPanel = new JPanel();
        panel7 = new JPanel();
        label60 = new JLabel();
        label61 = new JLabel();
        venIdProdutoField = new JTextField();
        separator40 = new JSeparator();
        scrollPane1 = new JScrollPane();
        fichaTextPane = new JTextPane();
        label62 = new JLabel();
        venIdUserField = new JTextField();
        separator42 = new JSeparator();
        label63 = new JLabel();
        venIdClienteField = new JTextField();
        label65 = new JLabel();
        venQtdField = new JTextField();
        separator45 = new JSeparator();
        addBttVendas = new JButton();
        ClearBttVendas = new JButton();
        separator44 = new JSeparator();
        panel14 = new JPanel();
        SaveBttVendas = new JButton();
        label11 = new JLabel();
        label39 = new JLabel();
        venPrecoTotField = new JLabel();
        cadClientePanel = new JPanel();
        sidePanel2 = new JPanel();
        label8 = new JLabel();
        cadClienteNomeField = new JTextField();
        separator1 = new JSeparator();
        label9 = new JLabel();
        cadClienteTelefoneField = new JTextField();
        separator2 = new JSeparator();
        label10 = new JLabel();
        cadClienteEnderecoField = new JTextField();
        label12 = new JLabel();
        cadClienteUserField = new JTextField();
        separator5 = new JSeparator();
        separator6 = new JSeparator();
        saveBtt = new JButton();
        clearBtt = new JButton();
        label13 = new JLabel();
        panel10 = new JPanel();
        listaClientesPanel = new JPanel();
        scrollPane2 = new JScrollPane();
        FclientesTable = new JTable();
        listaProdutosPanel = new JPanel();
        scrollPane3 = new JScrollPane();
        FprodutosTable = new JTable();

        //======== mainPanelF ========
        {
            mainPanelF.setBackground(new Color(0x21252f));
            mainPanelF.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,mainPanelF. getBorder () ) ); mainPanelF. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

            //======== sidePanel ========
            {
                sidePanel.setBackground(new Color(0x21252f));

                //======== infoPanel ========
                {
                    infoPanel.setBackground(new Color(0x21252f));

                    GroupLayout infoPanelLayout = new GroupLayout(infoPanel);
                    infoPanel.setLayout(infoPanelLayout);
                    infoPanelLayout.setHorizontalGroup(
                        infoPanelLayout.createParallelGroup()
                            .addGap(0, 86, Short.MAX_VALUE)
                    );
                    infoPanelLayout.setVerticalGroup(
                        infoPanelLayout.createParallelGroup()
                            .addGap(0, 28, Short.MAX_VALUE)
                    );
                }

                //======== homeBtt ========
                {
                    homeBtt.setBackground(new Color(0x21252f));
                    homeBtt.setBorder(null);
                    homeBtt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            homeBttMouseClicked(e);
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            homeBttMouseEntered(e);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            homeBttMouseExited(e);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            homeBttMousePressed(e);
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            homeBttMouseReleased(e);
                        }
                    });

                    //---- label1 ----
                    label1.setText("Home");
                    label1.setForeground(Color.white);
                    label1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
                    label1.setBackground(new Color(0x21252f));
                    label1.setHorizontalAlignment(SwingConstants.LEFT);

                    GroupLayout homeBttLayout = new GroupLayout(homeBtt);
                    homeBtt.setLayout(homeBttLayout);
                    homeBttLayout.setHorizontalGroup(
                        homeBttLayout.createParallelGroup()
                            .addGroup(homeBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    homeBttLayout.setVerticalGroup(
                        homeBttLayout.createParallelGroup()
                            .addGroup(homeBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                //======== efetuarVendaBtt ========
                {
                    efetuarVendaBtt.setBorder(null);
                    efetuarVendaBtt.setBackground(new Color(0x21252f));
                    efetuarVendaBtt.setForeground(Color.black);
                    efetuarVendaBtt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            efetuarVendaBttMouseClicked(e);
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            efetuarVendaBttMouseEntered(e);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            efetuarVendaBttMouseExited(e);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            efetuarVendaBttMousePressed(e);
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            efetuarVendaBttMouseReleased(e);
                        }
                    });

                    //---- label57 ----
                    label57.setText("Efetuar Venda");
                    label57.setForeground(Color.white);
                    label57.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));

                    GroupLayout efetuarVendaBttLayout = new GroupLayout(efetuarVendaBtt);
                    efetuarVendaBtt.setLayout(efetuarVendaBttLayout);
                    efetuarVendaBttLayout.setHorizontalGroup(
                        efetuarVendaBttLayout.createParallelGroup()
                            .addGroup(efetuarVendaBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label57, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    efetuarVendaBttLayout.setVerticalGroup(
                        efetuarVendaBttLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, efetuarVendaBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label57, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                //======== cliBtt1 ========
                {
                    cliBtt1.setBackground(new Color(0x21252f));
                    cliBtt1.setBorder(null);
                    cliBtt1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            cliBtt1MouseClicked(e);
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            cliBtt1MouseEntered(e);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            cliBtt1MouseExited(e);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            cliBtt1MousePressed(e);
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            cliBtt1MouseReleased(e);
                        }
                    });

                    //---- label4 ----
                    label4.setText("Cadastrar cliente");
                    label4.setForeground(Color.white);
                    label4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
                    label4.setBackground(new Color(0x21252f));
                    label4.setHorizontalAlignment(SwingConstants.LEFT);

                    GroupLayout cliBtt1Layout = new GroupLayout(cliBtt1);
                    cliBtt1.setLayout(cliBtt1Layout);
                    cliBtt1Layout.setHorizontalGroup(
                        cliBtt1Layout.createParallelGroup()
                            .addGroup(cliBtt1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    cliBtt1Layout.setVerticalGroup(
                        cliBtt1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, cliBtt1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                //======== listaClientesBtt ========
                {
                    listaClientesBtt.setBorder(null);
                    listaClientesBtt.setBackground(new Color(0x21252f));
                    listaClientesBtt.setForeground(Color.black);
                    listaClientesBtt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            listaClientesBttMouseClicked(e);
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            listaClientesBttMouseEntered(e);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            listaClientesBttMouseExited(e);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            listaClientesBttMousePressed(e);
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            listaClientesBttMouseReleased(e);
                        }
                    });

                    //---- label58 ----
                    label58.setText("Lista de clientes");
                    label58.setForeground(Color.white);
                    label58.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));

                    GroupLayout listaClientesBttLayout = new GroupLayout(listaClientesBtt);
                    listaClientesBtt.setLayout(listaClientesBttLayout);
                    listaClientesBttLayout.setHorizontalGroup(
                        listaClientesBttLayout.createParallelGroup()
                            .addGroup(listaClientesBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label58)
                                .addContainerGap(123, Short.MAX_VALUE))
                    );
                    listaClientesBttLayout.setVerticalGroup(
                        listaClientesBttLayout.createParallelGroup()
                            .addGroup(listaClientesBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label58, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                //======== listaProdutosBtt ========
                {
                    listaProdutosBtt.setBorder(null);
                    listaProdutosBtt.setBackground(new Color(0x21252f));
                    listaProdutosBtt.setForeground(Color.black);
                    listaProdutosBtt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            listaProdutosBttMouseClicked(e);
                        }
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            listaProdutosBttMouseEntered(e);
                        }
                        @Override
                        public void mouseExited(MouseEvent e) {
                            listaProdutosBttMouseExited(e);
                        }
                        @Override
                        public void mousePressed(MouseEvent e) {
                            listaProdutosBttMousePressed(e);
                        }
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            listaProdutosBttMouseReleased(e);
                        }
                    });

                    //---- label59 ----
                    label59.setText("Lista de Produtos");
                    label59.setForeground(Color.white);
                    label59.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));

                    GroupLayout listaProdutosBttLayout = new GroupLayout(listaProdutosBtt);
                    listaProdutosBtt.setLayout(listaProdutosBttLayout);
                    listaProdutosBttLayout.setHorizontalGroup(
                        listaProdutosBttLayout.createParallelGroup()
                            .addGroup(listaProdutosBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label59)
                                .addContainerGap(111, Short.MAX_VALUE))
                    );
                    listaProdutosBttLayout.setVerticalGroup(
                        listaProdutosBttLayout.createParallelGroup()
                            .addGroup(listaProdutosBttLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label59, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }

                GroupLayout sidePanelLayout = new GroupLayout(sidePanel);
                sidePanel.setLayout(sidePanelLayout);
                sidePanelLayout.setHorizontalGroup(
                    sidePanelLayout.createParallelGroup()
                        .addGroup(sidePanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(sidePanelLayout.createParallelGroup()
                                .addComponent(homeBtt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(efetuarVendaBtt, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cliBtt1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(sidePanelLayout.createSequentialGroup()
                                    .addGroup(sidePanelLayout.createParallelGroup()
                                        .addComponent(infoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(listaClientesBtt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(listaProdutosBtt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                );
                sidePanelLayout.setVerticalGroup(
                    sidePanelLayout.createParallelGroup()
                        .addGroup(sidePanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(infoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(homeBtt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(efetuarVendaBtt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cliBtt1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(listaClientesBtt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(listaProdutosBtt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(506, Short.MAX_VALUE))
                );
            }

            //======== centralPanel ========
            {
                centralPanel.setLayout(new CardLayout());

                //======== homePanelF ========
                {
                    homePanelF.setBackground(new Color(0x21252f));

                    //---- label14 ----
                    label14.setIcon(new ImageIcon(getClass().getResource("/icons/homeLogo.png")));
                    label14.setForeground(new Color(0x21252f));
                    label14.setBackground(new Color(0x21252f));

                    //---- greetLbl ----
                    greetLbl.setText("Bem vindo");
                    greetLbl.setForeground(Color.black);
                    greetLbl.setBackground(new Color(0x21252f));
                    greetLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 26));

                    //---- homeDateLbl ----
                    homeDateLbl.setBackground(new Color(0x21252f));
                    homeDateLbl.setForeground(Color.black);
                    homeDateLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 26));
                    homeDateLbl.setText("Data");

                    GroupLayout homePanelFLayout = new GroupLayout(homePanelF);
                    homePanelF.setLayout(homePanelFLayout);
                    homePanelFLayout.setHorizontalGroup(
                        homePanelFLayout.createParallelGroup()
                            .addGroup(homePanelFLayout.createSequentialGroup()
                                .addGroup(homePanelFLayout.createParallelGroup()
                                    .addGroup(homePanelFLayout.createSequentialGroup()
                                        .addGap(773, 773, 773)
                                        .addGroup(homePanelFLayout.createParallelGroup()
                                            .addComponent(greetLbl, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(homeDateLbl, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(homePanelFLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label14, GroupLayout.PREFERRED_SIZE, 1192, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(2, Short.MAX_VALUE))
                    );
                    homePanelFLayout.setVerticalGroup(
                        homePanelFLayout.createParallelGroup()
                            .addGroup(homePanelFLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label14)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greetLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(homeDateLbl, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(541, Short.MAX_VALUE))
                    );
                }
                centralPanel.add(homePanelF, "card1");

                //======== efetuarVendaPanel ========
                {
                    efetuarVendaPanel.setBackground(new Color(0x21252f));

                    //======== panel7 ========
                    {
                        panel7.setBackground(new Color(0x009933));

                        GroupLayout panel7Layout = new GroupLayout(panel7);
                        panel7.setLayout(panel7Layout);
                        panel7Layout.setHorizontalGroup(
                            panel7Layout.createParallelGroup()
                                .addGap(0, 80, Short.MAX_VALUE)
                        );
                        panel7Layout.setVerticalGroup(
                            panel7Layout.createParallelGroup()
                                .addGap(0, 900, Short.MAX_VALUE)
                        );
                    }

                    //---- label60 ----
                    label60.setText("Efetuar venda");
                    label60.setFont(new Font("Yu Gothic Light", Font.PLAIN, 36));
                    label60.setForeground(Color.white);
                    label60.setBackground(Color.white);

                    //---- label61 ----
                    label61.setText("Identificador do produto");
                    label61.setForeground(Color.white);
                    label61.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- venIdProdutoField ----
                    venIdProdutoField.setBorder(null);
                    venIdProdutoField.setForeground(Color.white);
                    venIdProdutoField.setBackground(new Color(0x21252f));

                    //---- separator40 ----
                    separator40.setBackground(new Color(0x21252f));
                    separator40.setForeground(new Color(0x009933));
                    separator40.setBorder(null);

                    //======== scrollPane1 ========
                    {

                        //---- fichaTextPane ----
                        fichaTextPane.setBorder(new TitledBorder("Ficha"));
                        fichaTextPane.setEditable(false);
                        fichaTextPane.setForeground(Color.black);
                        scrollPane1.setViewportView(fichaTextPane);
                    }

                    //---- label62 ----
                    label62.setText("ID Usu\u00e1rio");
                    label62.setForeground(Color.white);
                    label62.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- venIdUserField ----
                    venIdUserField.setBorder(null);
                    venIdUserField.setForeground(Color.white);
                    venIdUserField.setBackground(new Color(0x21252f));

                    //---- separator42 ----
                    separator42.setBackground(new Color(0x21252f));
                    separator42.setForeground(new Color(0x009933));
                    separator42.setBorder(null);

                    //---- label63 ----
                    label63.setText("ID Cliente");
                    label63.setForeground(Color.white);
                    label63.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- venIdClienteField ----
                    venIdClienteField.setForeground(Color.white);
                    venIdClienteField.setBorder(null);
                    venIdClienteField.setBackground(new Color(0x21252f));

                    //---- label65 ----
                    label65.setText("Quantidade");
                    label65.setFont(new Font("Verdana", Font.PLAIN, 12));
                    label65.setForeground(Color.white);

                    //---- venQtdField ----
                    venQtdField.setBorder(null);
                    venQtdField.setBackground(new Color(0x21252f));
                    venQtdField.setForeground(Color.white);

                    //---- separator45 ----
                    separator45.setBackground(new Color(0x21252f));
                    separator45.setForeground(new Color(0x009933));
                    separator45.setBorder(null);

                    //---- addBttVendas ----
                    addBttVendas.setText("Adicionar");
                    addBttVendas.setBackground(new Color(0x21252f));
                    addBttVendas.setForeground(Color.white);
                    addBttVendas.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            addBttVendasMouseClicked(e);
                        }
                    });

                    //---- ClearBttVendas ----
                    ClearBttVendas.setText("Limpar");
                    ClearBttVendas.setBackground(new Color(0x21252f));
                    ClearBttVendas.setForeground(Color.white);
                    ClearBttVendas.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            ClearBttVendasMouseClicked(e);
                        }
                    });

                    //---- separator44 ----
                    separator44.setBackground(new Color(0x21252f));
                    separator44.setForeground(new Color(0x009933));
                    separator44.setBorder(null);

                    //======== panel14 ========
                    {
                        panel14.setBackground(new Color(0x21252f));

                        GroupLayout panel14Layout = new GroupLayout(panel14);
                        panel14.setLayout(panel14Layout);
                        panel14Layout.setHorizontalGroup(
                            panel14Layout.createParallelGroup()
                                .addGap(0, 380, Short.MAX_VALUE)
                        );
                        panel14Layout.setVerticalGroup(
                            panel14Layout.createParallelGroup()
                                .addGap(0, 136, Short.MAX_VALUE)
                        );
                    }

                    //---- SaveBttVendas ----
                    SaveBttVendas.setText("Salvar");
                    SaveBttVendas.setForeground(Color.white);
                    SaveBttVendas.setBackground(new Color(0x21252f));
                    SaveBttVendas.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            SaveBttVendasMouseClicked(e);
                        }
                    });

                    //---- label11 ----
                    label11.setText("Pre\u00e7o total");
                    label11.setForeground(Color.white);

                    //---- label39 ----
                    label39.setText("R$");
                    label39.setForeground(Color.white);

                    //---- venPrecoTotField ----
                    venPrecoTotField.setText("0.00");
                    venPrecoTotField.setBackground(new Color(0x21252f));
                    venPrecoTotField.setForeground(Color.white);

                    GroupLayout efetuarVendaPanelLayout = new GroupLayout(efetuarVendaPanel);
                    efetuarVendaPanel.setLayout(efetuarVendaPanelLayout);
                    efetuarVendaPanelLayout.setHorizontalGroup(
                        efetuarVendaPanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, efetuarVendaPanelLayout.createSequentialGroup()
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(efetuarVendaPanelLayout.createParallelGroup()
                                    .addComponent(label60, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                        .addComponent(label61)
                                        .addGap(255, 255, 255)
                                        .addComponent(label11))
                                    .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                        .addComponent(venIdProdutoField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label39)
                                        .addGap(6, 6, 6)
                                        .addComponent(venPrecoTotField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(separator40, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label65)
                                    .addComponent(venQtdField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator45, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label62)
                                    .addComponent(venIdUserField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator42, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label63)
                                    .addComponent(venIdClienteField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator44, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                        .addComponent(addBttVendas, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(ClearBttVendas, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                        .addGap(97, 97, 97)
                                        .addComponent(SaveBttVendas, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
                                .addGap(242, 242, 242))
                    );
                    efetuarVendaPanelLayout.setVerticalGroup(
                        efetuarVendaPanelLayout.createParallelGroup()
                            .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                .addGroup(efetuarVendaPanelLayout.createParallelGroup()
                                    .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                        .addComponent(panel14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label60, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addGroup(efetuarVendaPanelLayout.createParallelGroup()
                                            .addComponent(label61)
                                            .addComponent(label11))
                                        .addGap(6, 6, 6)
                                        .addGroup(efetuarVendaPanelLayout.createParallelGroup()
                                            .addComponent(venIdProdutoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(efetuarVendaPanelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(efetuarVendaPanelLayout.createParallelGroup()
                                                    .addComponent(label39)
                                                    .addComponent(venPrecoTotField))))
                                        .addGap(6, 6, 6)
                                        .addComponent(separator40, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label65)
                                        .addGap(6, 6, 6)
                                        .addComponent(venQtdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator45, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label62)
                                        .addGap(6, 6, 6)
                                        .addComponent(venIdUserField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator42, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label63)
                                        .addGap(6, 6, 6)
                                        .addComponent(venIdClienteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator44, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(efetuarVendaPanelLayout.createParallelGroup()
                                            .addComponent(addBttVendas)
                                            .addComponent(ClearBttVendas))
                                        .addGap(6, 6, 6)
                                        .addComponent(SaveBttVendas)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, efetuarVendaPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1)
                                .addContainerGap())
                    );
                }
                centralPanel.add(efetuarVendaPanel, "card2");

                //======== cadClientePanel ========
                {
                    cadClientePanel.setBackground(new Color(0x21252f));

                    //======== sidePanel2 ========
                    {
                        sidePanel2.setBackground(new Color(0x009999));

                        GroupLayout sidePanel2Layout = new GroupLayout(sidePanel2);
                        sidePanel2.setLayout(sidePanel2Layout);
                        sidePanel2Layout.setHorizontalGroup(
                            sidePanel2Layout.createParallelGroup()
                                .addGap(0, 80, Short.MAX_VALUE)
                        );
                        sidePanel2Layout.setVerticalGroup(
                            sidePanel2Layout.createParallelGroup()
                                .addGap(0, 894, Short.MAX_VALUE)
                        );
                    }

                    //---- label8 ----
                    label8.setText("Nome");
                    label8.setForeground(Color.white);
                    label8.setBackground(new Color(0x21252f));
                    label8.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- cadClienteNomeField ----
                    cadClienteNomeField.setBorder(null);
                    cadClienteNomeField.setBackground(new Color(0x21252f));
                    cadClienteNomeField.setForeground(Color.white);

                    //---- separator1 ----
                    separator1.setForeground(new Color(0x009999));
                    separator1.setBackground(new Color(0x21252f));
                    separator1.setOpaque(true);
                    separator1.setBorder(null);

                    //---- label9 ----
                    label9.setText("Telefone");
                    label9.setForeground(Color.white);
                    label9.setBackground(new Color(0x21252f));
                    label9.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- cadClienteTelefoneField ----
                    cadClienteTelefoneField.setBorder(null);
                    cadClienteTelefoneField.setBackground(new Color(0x21252f));
                    cadClienteTelefoneField.setForeground(Color.white);

                    //---- separator2 ----
                    separator2.setForeground(new Color(0x009999));
                    separator2.setBackground(new Color(0x21252f));
                    separator2.setOpaque(true);
                    separator2.setBorder(null);

                    //---- label10 ----
                    label10.setText("Endere\u00e7o");
                    label10.setForeground(Color.white);
                    label10.setBackground(new Color(0x21252f));
                    label10.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- cadClienteEnderecoField ----
                    cadClienteEnderecoField.setBorder(null);
                    cadClienteEnderecoField.setForeground(Color.white);
                    cadClienteEnderecoField.setBackground(new Color(0x21252f));

                    //---- label12 ----
                    label12.setText("ID Usu\u00e1rio");
                    label12.setForeground(Color.white);
                    label12.setBackground(new Color(0x21252f));
                    label12.setFont(new Font("Verdana", Font.PLAIN, 12));

                    //---- cadClienteUserField ----
                    cadClienteUserField.setBorder(null);
                    cadClienteUserField.setForeground(Color.white);
                    cadClienteUserField.setBackground(new Color(0x21252f));

                    //---- separator5 ----
                    separator5.setForeground(new Color(0x009999));
                    separator5.setBackground(new Color(0x21252f));
                    separator5.setOpaque(true);
                    separator5.setBorder(null);

                    //---- separator6 ----
                    separator6.setForeground(new Color(0x009999));
                    separator6.setBackground(new Color(0x21252f));
                    separator6.setOpaque(true);
                    separator6.setBorder(null);

                    //---- saveBtt ----
                    saveBtt.setText("Salvar");
                    saveBtt.setBackground(new Color(0x21252f));
                    saveBtt.setForeground(Color.white);
                    saveBtt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            saveBttMouseClicked(e);
                        }
                    });

                    //---- clearBtt ----
                    clearBtt.setText("Limpar");
                    clearBtt.setBackground(new Color(0x21252f));
                    clearBtt.setForeground(Color.white);
                    clearBtt.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            clearBttMouseClicked(e);
                        }
                    });

                    //---- label13 ----
                    label13.setText("Cadastrar cliente");
                    label13.setFont(new Font("Yu Gothic Light", Font.PLAIN, 36));
                    label13.setForeground(Color.white);
                    label13.setBackground(new Color(0x21252f));

                    //======== panel10 ========
                    {
                        panel10.setBackground(new Color(0x21252f));

                        GroupLayout panel10Layout = new GroupLayout(panel10);
                        panel10.setLayout(panel10Layout);
                        panel10Layout.setHorizontalGroup(
                            panel10Layout.createParallelGroup()
                                .addGap(0, 380, Short.MAX_VALUE)
                        );
                        panel10Layout.setVerticalGroup(
                            panel10Layout.createParallelGroup()
                                .addGap(0, 136, Short.MAX_VALUE)
                        );
                    }

                    GroupLayout cadClientePanelLayout = new GroupLayout(cadClientePanel);
                    cadClientePanel.setLayout(cadClientePanelLayout);
                    cadClientePanelLayout.setHorizontalGroup(
                        cadClientePanelLayout.createParallelGroup()
                            .addGroup(cadClientePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sidePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cadClientePanelLayout.createParallelGroup()
                                    .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label13, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8)
                                    .addComponent(cadClienteNomeField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label9)
                                    .addComponent(cadClienteTelefoneField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator2, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label10)
                                    .addComponent(cadClienteEnderecoField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator6, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label12)
                                    .addComponent(cadClienteUserField, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(separator5, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveBtt, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearBtt, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 803, Short.MAX_VALUE))
                    );
                    cadClientePanelLayout.setVerticalGroup(
                        cadClientePanelLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, cadClientePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(cadClientePanelLayout.createParallelGroup()
                                    .addComponent(sidePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cadClientePanelLayout.createSequentialGroup()
                                        .addComponent(panel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(label13, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(label8)
                                        .addGap(6, 6, 6)
                                        .addComponent(cadClienteNomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label9)
                                        .addGap(6, 6, 6)
                                        .addComponent(cadClienteTelefoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(label10)
                                        .addGap(6, 6, 6)
                                        .addComponent(cadClienteEnderecoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(label12)
                                        .addGap(6, 6, 6)
                                        .addComponent(cadClienteUserField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(separator5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(saveBtt)
                                        .addGap(6, 6, 6)
                                        .addComponent(clearBtt)))
                                .addContainerGap())
                    );
                }
                centralPanel.add(cadClientePanel, "card3");

                //======== listaClientesPanel ========
                {
                    listaClientesPanel.setBackground(new Color(0x21252f));

                    //======== scrollPane2 ========
                    {

                        //---- FclientesTable ----
                        FclientesTable.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, ""},
                            },
                            new String[] {
                                "idCliente", "nomeCliente"
                            }
                        ) {
                            boolean[] columnEditable = new boolean[] {
                                true, false
                            };
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = FclientesTable.getColumnModel();
                            cm.getColumn(1).setResizable(false);
                        }
                        scrollPane2.setViewportView(FclientesTable);
                    }

                    GroupLayout listaClientesPanelLayout = new GroupLayout(listaClientesPanel);
                    listaClientesPanel.setLayout(listaClientesPanelLayout);
                    listaClientesPanelLayout.setHorizontalGroup(
                        listaClientesPanelLayout.createParallelGroup()
                            .addGroup(listaClientesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(817, Short.MAX_VALUE))
                    );
                    listaClientesPanelLayout.setVerticalGroup(
                        listaClientesPanelLayout.createParallelGroup()
                            .addGroup(listaClientesPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                centralPanel.add(listaClientesPanel, "card4");

                //======== listaProdutosPanel ========
                {
                    listaProdutosPanel.setBackground(new Color(0x21252f));

                    //======== scrollPane3 ========
                    {
                        scrollPane3.setBackground(new Color(0x21252f));

                        //---- FprodutosTable ----
                        FprodutosTable.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null},
                            },
                            new String[] {
                                "idProduto", "nomeProduto"
                            }
                        ) {
                            boolean[] columnEditable = new boolean[] {
                                true, false
                            };
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = FprodutosTable.getColumnModel();
                            cm.getColumn(1).setResizable(false);
                        }
                        scrollPane3.setViewportView(FprodutosTable);
                    }

                    GroupLayout listaProdutosPanelLayout = new GroupLayout(listaProdutosPanel);
                    listaProdutosPanel.setLayout(listaProdutosPanelLayout);
                    listaProdutosPanelLayout.setHorizontalGroup(
                        listaProdutosPanelLayout.createParallelGroup()
                            .addGroup(listaProdutosPanelLayout.createSequentialGroup()
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 823, Short.MAX_VALUE))
                    );
                    listaProdutosPanelLayout.setVerticalGroup(
                        listaProdutosPanelLayout.createParallelGroup()
                            .addGroup(listaProdutosPanelLayout.createSequentialGroup()
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                    );
                }
                centralPanel.add(listaProdutosPanel, "card5");
            }

            GroupLayout mainPanelFLayout = new GroupLayout(mainPanelF);
            mainPanelF.setLayout(mainPanelFLayout);
            mainPanelFLayout.setHorizontalGroup(
                mainPanelFLayout.createParallelGroup()
                    .addGroup(mainPanelFLayout.createSequentialGroup()
                        .addComponent(sidePanel, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(centralPanel, GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
                        .addContainerGap())
            );
            mainPanelFLayout.setVerticalGroup(
                mainPanelFLayout.createParallelGroup()
                    .addGroup(mainPanelFLayout.createSequentialGroup()
                        .addGroup(mainPanelFLayout.createParallelGroup()
                            .addComponent(sidePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(centralPanel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public JTextField getVenIdProdutoField() {
        return venIdProdutoField;
    }

    public void setVenIdProdutoField(JTextField venIdProdutoField) {
        this.venIdProdutoField = venIdProdutoField;
    }

    public JTextField getVenIdUserField() {
        return venIdUserField;
    }

    public void setVenIdUserField(JTextField venIdUserField) {
        this.venIdUserField = venIdUserField;
    }

    public JTextField getVenIdClienteField() {
        return venIdClienteField;
    }

    public void setVenIdClienteField(JTextField venIdClienteField) {
        this.venIdClienteField = venIdClienteField;
    }

    public JTextField getVenQtdField() {
        return venQtdField;
    }

    public void setVenQtdField(JTextField venQtdField) {
        this.venQtdField = venQtdField;
    }

    public JPanel getCadClientePanel() {
        return cadClientePanel;
    }

    public void setCadClientePanel(JPanel cadClientePanel) {
        this.cadClientePanel = cadClientePanel;
    }

    public JTextField getCadClienteNomeField() {
        return cadClienteNomeField;
    }

    public void setCadClienteNomeField(JTextField cadClienteNomeField) {
        this.cadClienteNomeField = cadClienteNomeField;
    }

    public JTextField getCadClienteTelefoneField() {
        return cadClienteTelefoneField;
    }

    public void setCadClienteTelefoneField(JTextField cadClienteTelefoneField) {
        this.cadClienteTelefoneField = cadClienteTelefoneField;
    }

    public JTextField getCadClienteEnderecoField() {
        return cadClienteEnderecoField;
    }

    public void setCadClienteEnderecoField(JTextField cadClienteEnderecoField) {
        this.cadClienteEnderecoField = cadClienteEnderecoField;
    }

    public JTextField getCadClienteUserField() {
        return cadClienteUserField;
    }

    public void setCadClienteUserField(JTextField cadClienteUserField) {
        this.cadClienteUserField = cadClienteUserField;
    }

    public JTextPane getFichaTextPane() {
        return fichaTextPane;
    }

    public void setFichaTextPane(JTextPane fichaTextPane) {
        this.fichaTextPane = fichaTextPane;
    }

    public JLabel getVenPrecoTotField() {
        return venPrecoTotField;
    }

    public void setVenPrecoTotField(JLabel venPrecoTotField) {
        this.venPrecoTotField = venPrecoTotField;
    }

    public JPanel getMainPanelF() {
        return mainPanelF;
    }

    public void setMainPanelF(JPanel mainPanelF) {
        this.mainPanelF = mainPanelF;
    }

    public JTable getFclientesTable() {
        return FclientesTable;
    }

    public void setFclientesTable(JTable fclientesTable) {
        FclientesTable = fclientesTable;
    }

    public JTable getFprodutosTable() {
        return FprodutosTable;
    }

    public void setFprodutosTable(JTable fprodutosTable) {
        FprodutosTable = fprodutosTable;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Felipe Fernandes Versiane
    public JPanel mainPanelF;
    public JPanel sidePanel;
    public JPanel infoPanel;
    public JPanel homeBtt;
    private JLabel label1;
    public JPanel efetuarVendaBtt;
    private JLabel label57;
    public JPanel cliBtt1;
    private JLabel label4;
    public JPanel listaClientesBtt;
    private JLabel label58;
    public JPanel listaProdutosBtt;
    private JLabel label59;
    public JPanel centralPanel;
    public JPanel homePanelF;
    private JLabel label14;
    private JLabel greetLbl;
    private JLabel homeDateLbl;
    public JPanel efetuarVendaPanel;
    private JPanel panel7;
    private JLabel label60;
    private JLabel label61;
    private JTextField venIdProdutoField;
    private JSeparator separator40;
    private JScrollPane scrollPane1;
    private JTextPane fichaTextPane;
    private JLabel label62;
    private JTextField venIdUserField;
    private JSeparator separator42;
    private JLabel label63;
    private JTextField venIdClienteField;
    private JLabel label65;
    private JTextField venQtdField;
    private JSeparator separator45;
    private JButton addBttVendas;
    private JButton ClearBttVendas;
    private JSeparator separator44;
    private JPanel panel14;
    private JButton SaveBttVendas;
    private JLabel label11;
    private JLabel label39;
    private JLabel venPrecoTotField;
    public JPanel cadClientePanel;
    private JPanel sidePanel2;
    private JLabel label8;
    private JTextField cadClienteNomeField;
    private JSeparator separator1;
    private JLabel label9;
    private JTextField cadClienteTelefoneField;
    private JSeparator separator2;
    private JLabel label10;
    private JTextField cadClienteEnderecoField;
    private JLabel label12;
    private JTextField cadClienteUserField;
    private JSeparator separator5;
    private JSeparator separator6;
    private JButton saveBtt;
    private JButton clearBtt;
    private JLabel label13;
    private JPanel panel10;
    public JPanel listaClientesPanel;
    private JScrollPane scrollPane2;
    private JTable FclientesTable;
    public JPanel listaProdutosPanel;
    public JScrollPane scrollPane3;
    private JTable FprodutosTable;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon("src/icons/icon.png");
        JFrame dashboardFuncionario = new JFrame();
        dashboardFuncionario.pack();
        dashboardFuncionario.setContentPane(new funcionarioView().mainPanelF);
        dashboardFuncionario.setTitle("Dashboard funcion\u00E1rio");
        dashboardFuncionario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dashboardFuncionario.setSize(1500, 800);
        dashboardFuncionario.setIconImage(imageIcon.getImage());
        dashboardFuncionario.setVisible(true);
    }

}
