package sistema.model;

import java.awt.*;
import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

import sistema.model.DAO.DAOFunctions;
import sistema.model.pedido.vendaException;
import sistema.view.*;
import sistema.model.atores.Cliente;
import sistema.model.estoque.Produto;
import sistema.model.pedido.Venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class funcionarioModel {
    funcionarioView view;

    public funcionarioModel(funcionarioView view) {
        this.view = view;
    }

    public String dataAtual() {
        GregorianCalendar calendar = new GregorianCalendar();
        String strMes = "";
        int mes = calendar.get(GregorianCalendar.MONTH);
        switch (mes) {
            case 0 -> strMes = "Janeiro";
            case 1 -> strMes = "Fevereiro";
            case 2 -> strMes = "Mar\u00E7o";
            case 3 -> strMes = "Abril";
            case 4 -> strMes = "Maio";
            case 5 -> strMes = "Junho";
            case 6 -> strMes = "Julho";
            case 7 -> strMes = "Agosto";
            case 8 -> strMes = "Setembro";
            case 9 -> strMes = "Outubro";
            case 10 -> strMes = "Novembro";
            case 11 -> strMes = "Dezembro";
        }
        return calendar.get(GregorianCalendar.DAY_OF_MONTH) + " de " + strMes + " de " + calendar.get(GregorianCalendar.YEAR);
    }

    public void mudarCor() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 20);
        Color color;
        switch (randomNum) {
            case 0 -> {
                color = new Color(34, 162, 117);
                view.homePanelF.setBackground(color);
            }
            case 1 -> {
                color = new Color(255, 195, 243);
                view.homePanelF.setBackground(color);
            }
            case 3 -> {
                color = new Color(39, 127, 187);
                view.homePanelF.setBackground(color);
            }
            case 4 -> {
                color = new Color(204, 255, 204);
                view.homePanelF.setBackground(color);
            }
            case 5 -> {
                color = new Color(64, 245, 248);
                view.homePanelF.setBackground(color);
            }
            case 6 -> {
                color = new Color(153, 153, 255);
                view.homePanelF.setBackground(color);
            }
            case 7 -> {
                color = new Color(178, 221, 40);
                view.homePanelF.setBackground(color);
            }
            case 8 -> {
                color = new Color(211, 110, 112);
                view.homePanelF.setBackground(color);
            }
            case 9 -> {
                color = new Color(230, 214, 144);
                view.homePanelF.setBackground(color);
            }
            case 10 -> {
                color = new Color(137, 172, 118);
                view.homePanelF.setBackground(color);
            }
            case 11 -> {
                color = new Color(152, 238, 245);
                view.homePanelF.setBackground(color);
            }
            case 12 -> {
                color = new Color(102, 185, 181);
                view.homePanelF.setBackground(color);
            }
            case 13 -> {
                color = new Color(255, 254, 145);
                view.homePanelF.setBackground(color);
            }
            case 14 -> {
                color = new Color(255, 153, 153);
                view.homePanelF.setBackground(color);
            }
            case 15 -> {
                color = new Color(245, 110, 97);
                view.homePanelF.setBackground(color);
            }
            case 16 -> {
                color = new Color(245, 162, 100);
                view.homePanelF.setBackground(color);
            }
            case 17 -> {
                color = new Color(219, 245, 95);
                view.homePanelF.setBackground(color);
            }
            case 18 -> {
                color = new Color(140, 245, 93);
                view.homePanelF.setBackground(color);
            }
            case 19 -> {
                color = new Color(92, 245, 170);
                view.homePanelF.setBackground(color);
            }
        }
    }

    public String precTot(Integer idproduto, String quantidade) {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        String precoVend = String.valueOf(db.getPrecoVenda_info(conn, idproduto));
        String precAtual = view.getVenPrecoTotField().getText();
        String precTotal = String.valueOf(Double.parseDouble(precoVend) * Double.parseDouble(quantidade));

        return String.valueOf(Double.valueOf(Double.parseDouble(precAtual) + Double.parseDouble(precTotal)));
    }

    public void CadClienteSalvarBtt() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        String nome = view.getCadClienteNomeField().getText();
        String telefone = view.getCadClienteTelefoneField().getText();
        String endereco = view.getCadClienteEnderecoField().getText();
        String userUsuario = view.getCadClienteUserField().getText();
        GregorianCalendar calendar = new GregorianCalendar();
        String dataCadastro =
                calendar.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                        calendar.get(GregorianCalendar.MONTH) + 1 + "/" +
                        calendar.get(GregorianCalendar.YEAR);

        if ((view.getCadClienteNomeField().getText().length() > 0) && (view.getCadClienteTelefoneField().getText().length() > 0) &&
                (view.getCadClienteEnderecoField().getText().length() > 0) && (view.getCadClienteUserField().getText().length() > 0)) {
            if (db.verificarUsuario(userUsuario, db.read_idUsuario(conn))) {
                    try {
                        Cliente cliente = new Cliente(null, nome, telefone, endereco, dataCadastro, userUsuario);
                                            db.insert_row_cliente(conn, "cliente", cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getDataCadastro(), cliente.getUserUsuario());

                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }


            } else {
                JOptionPane.showMessageDialog(null, "Usu\u00E1rio n\u00E3o encontrado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo vazio");


        }
    }

    public void CadClienteClearBtt() {
        view.getCadClienteNomeField().setText("");
        view.getCadClienteTelefoneField().setText("");
        view.getCadClienteEnderecoField().setText("");
        view.getCadClienteUserField().setText("");
    }

    public void VendaSalvarBtt() throws vendaException {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        String descricao = view.getFichaTextPane().getText();
        String precoTotal = view.getVenPrecoTotField().getText();
        String idCliente = view.getVenIdClienteField().getText();
        String idUsuario = view.getVenIdUserField().getText();
        String qtdItem = view.getVenQtdField().getText();
        String idProduto = view.getVenIdProdutoField().getText();

        GregorianCalendar calendar = new GregorianCalendar();
        String datavenda = calendar.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                calendar.get(GregorianCalendar.MONTH) + 1 + "/" +
                calendar.get(GregorianCalendar.YEAR);

        if (view.getFichaTextPane().getText().length() > 0) {

                Venda venda = new Venda(null, descricao, precoTotal, datavenda, idCliente, idUsuario, qtdItem, idProduto);
                db.insert_row_venda(conn, venda.getDescricao(), venda.getIdCliente(), venda.getIdUsuario(), venda.getPrecoTotal(), venda.getDataVenda());
                db.vendaEfetuada(conn, idUsuario, qtdItem);

        } else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }

    public void VendasClearBtt() {
        view.getVenIdProdutoField().setText("");
        view.getVenQtdField().setText("");
        view.getVenIdUserField().setText("");
        view.getVenIdClienteField().setText("");
    }

    public void addVenda() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        String nomeProduto = db.getNome_info(conn, "produto", "idproduto", view.getVenIdProdutoField().getText());
        String nomeCliente = db.getNome_info(conn, "cliente", "idcliente", view.getVenIdClienteField().getText());
        String nomeUsuario = db.getNome_info(conn, "usuario", "usuario", view.getVenIdUserField().getText());

        if ((Integer.parseInt(view.getVenQtdField().getText()) > 0   &&
                (Integer.parseInt(view.getVenQtdField().getText()) < Integer.parseInt(db.getQuantidadeItem(conn, view.getVenIdProdutoField().getText()))))) {
            if ((view.getVenIdProdutoField().getText().length() > 0) && (view.getVenQtdField().getText().length() > 0) && (view.getVenIdClienteField().getText().length() > 0) && (view.getVenIdUserField().getText().length() > 0)) {
                if (db.verificarUsuario(view.getVenIdUserField().getText(), db.read_idUsuario(conn)) && db.verificarCliente(view.getVenIdClienteField().getText(), db.read_idCliente(conn)) &&
                        (db.verificarProduto(view.getVenIdProdutoField().getText(), db.read_idProduto(conn)))) {
                    view.getFichaTextPane().setText(view.getFichaTextPane().getText() +
                            "ID do produto: " + view.getVenIdProdutoField().getText() + " \n" + nomeProduto + " \n" +
                            "Quantidade: " + view.getVenQtdField().getText() + " \n" +
                            "ID do Cliente: " + view.getVenIdClienteField().getText() + " \n" + nomeCliente + " \n" +
                            "ID Usuário: " + view.getVenIdUserField().getText() + " \n" + nomeUsuario + " \n\n");

                    Integer idproduto = Integer.valueOf(view.getVenIdProdutoField().getText());
                    String quantidade = view.getVenQtdField().getText();
                    view.getVenPrecoTotField().setText(this.precTot(idproduto, quantidade));
                    db.updateQtdItens(conn, String.valueOf(idproduto), quantidade);
                } else {
                    JOptionPane.showMessageDialog(null, "idCliente/idUsuario/idproduto n\u00E3o existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo vazio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade invalida");
        }

    }
    public void fillTableCliente() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        DefaultTableModel model = (DefaultTableModel) view.getFclientesTable().getModel();
        view.getFclientesTable().setRowSorter(new TableRowSorter<TableModel>(model));
        model.setNumRows(0);
        for(Cliente cliente: db.getNomeIdCliente(conn)) {
            model.addRow(new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNome()
            });
        }
    }
    public void fillTableProduto() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        DefaultTableModel model = (DefaultTableModel) view.getFprodutosTable().getModel();
        view.getFprodutosTable().setRowSorter(new TableRowSorter<TableModel>(model));
        model.setNumRows(0);
        for(Produto produto: db.getNomeIdProduto(conn)) {
            model.addRow(new Object[]{
                    produto.getIdProduto(),
                    produto.getProdutoNome()
            });
        }
    }
}
