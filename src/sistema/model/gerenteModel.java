package sistema.model;

import sistema.model.DAO.DAOFunctions;
import sistema.model.pedido.vendaException;
import sistema.view.gerenteView;
import sistema.model.atores.Cliente;
import sistema.model.atores.Usuario;
import sistema.model.estoque.Produto;
import sistema.model.pedido.Venda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.Connection;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class gerenteModel {
    gerenteView view;

    public gerenteModel(gerenteView view)
    {
        this.view = view;
    }
    public void corAleatoria() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 20);
        Color color;
        switch (randomNum) {
            case 0 -> {
                color = new Color(34, 162, 117);
                view.getHomePanel().setBackground(color);

            }
            case 1 -> {
                color = new Color(255, 195, 243);
                view.getHomePanel().setBackground(color);

            }
            case 3 -> {
                color = new Color(39, 127, 187);
                view.getHomePanel().setBackground(color);

            }
            case 4 -> {
                color = new Color(204, 255, 204);
                view.getHomePanel().setBackground(color);

            }
            case 5 -> {
                color = new Color(64, 245, 248);
                view.getHomePanel().setBackground(color);

            }
            case 6 -> {
                color = new Color(153, 153, 255);
                view.getHomePanel().setBackground(color);

            }
            case 7 -> {
                color = new Color(178, 221, 40);
                view.getHomePanel().setBackground(color);

            }
            case 8 -> {
                color = new Color(211, 110, 112);
                view.getHomePanel().setBackground(color);

            }
            case 9 -> {
                color = new Color(230, 214, 144);
                view.getHomePanel().setBackground(color);

            }
            case 10 -> {
                color = new Color(137, 172, 118);
                view.getHomePanel().setBackground(color);
            }
            case 11 -> {
                color = new Color(152, 238, 245);
                view.getHomePanel().setBackground(color);
            }
            case 12 -> {
                color = new Color(102, 185, 181);
                view.getHomePanel().setBackground(color);
            }
            case 13 -> {
                color = new Color(255, 254, 145);
                view.getHomePanel().setBackground(color);
            }
            case 14 -> {
                color = new Color(255, 153, 153);
                view.getHomePanel().setBackground(color);
            }
            case 15 -> {
                color = new Color(245, 110, 97);
                view.getHomePanel().setBackground(color);
            }
            case 16 -> {
                color = new Color(245, 162, 100);
                view.getHomePanel().setBackground(color);
            }
            case 17 -> {
                color = new Color(219, 245, 95);
                view.getHomePanel().setBackground(color);
            }
            case 18 -> {
                color = new Color(140, 245, 93);
                view.getHomePanel().setBackground(color);
            }
            case 19 -> {
                color = new Color(92, 245, 170);
                view.getHomePanel().setBackground(color);
            }
        }
    }
    public void clear(){
        view.getCadClienteNomeField().setText("");
        view.getCadClienteTelefoneField().setText("");
        view.getCadClienteEnderecoField().setText("");

        view.getEdiClienteNomeField().setText("");
        view.getEdiClienteTelefoneField().setText("");
        view.getEdiClienteEnderecoField().setText("");
        view.getEdiClienteUserField().setText("");
        view.getEdiClienteDataField().setText("");

        view.getCadFuncNomeField().setText("");
        view.getCadFuncTelField().setText("");
        view.getCadFuncEndField().setText("");
        view.getCadFuncUserField().setText("");
        view.getCadFuncSenField().setText("");

        view.getEdifuncNomeField().setText("");
        view.getEdifuncTelField().setText("");
        view.getEdifuncEndField().setText("");
        view.getEdifuncUserField().setText("");
        view.getEdifuncSenField().setText("");
        view.getEdifuncDataField().setText("");
        view.getEdifuncQtdField().setText("");
        view.getEdifuncTipoField().setText("");

        view.getCadProdNomeField().setText("");
        view.getCadProdTelefoneField().setText("");
        view.getCadProdEndField().setText("");
        view.getCadQuantidadeField().setText("");
        view.getCadProdPrecoCompra().setText("");
        view.getCadProdPrecoVenda().setText("");

        view.getSearchIdProduto().setText("");
        view.getEdiProdNomeField().setText("");
        view.getEdiProdTelefoneField().setText("");
        view.getEdiProdEndField().setText("");
        view.getEdiProdPrecoCompra().setText("");
        view.getEdiProdPrecoVenda().setText("");
        view.getEdiProdDataField().setText("");
        view.getEdiProdDataField().setText("");

        view.getVenIdProdutoField().setText("");
        view.getVenIdClienteField().setText("");
        view.getVenIdUserField().setText("");
        view.getVenQtdField().setText("");
        view.getFichaTextPane().setText("");
    }
    public String dataPorExtenso() {
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
        return calendar.get(GregorianCalendar.DAY_OF_MONTH)+" de "+strMes+" de "+calendar.get(GregorianCalendar.YEAR);
    }
    public void searchCliente() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

            view.getEdiClienteNomeField().setText(db.getNome_info(conn, "cliente", "idCliente", view.getSearchID().getText()));
            view.getEdiClienteTelefoneField().setText(db.getTelefone_info(conn, "cliente", "idCliente", view.getSearchID().getText()));
            view.getEdiClienteEnderecoField().setText(db.getEndereco_info(conn, "cliente", "idCliente", view.getSearchID().getText()));
            view.getEdiClienteUserField().setText(db.getIdUser_info(conn, view.getSearchID().getText()));
            view.getEdiClienteDataField().setText(db.getDataCadastro_info(conn, "cliente", "idCliente", view.getSearchID().getText()));



    }
    public void saveCliente() {
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
            if(db.verificarUsuario(userUsuario, db.read_idUsuario(conn))) {
                try {
                    Cliente cliente = new Cliente(null, nome, telefone, endereco, dataCadastro, userUsuario);
                                        db.insert_row_cliente(conn, "cliente", cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getDataCadastro(), cliente.getUserUsuario());

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

            }
            else {
                JOptionPane.showMessageDialog(null, "Usu\u00E1rio n\u00E3o encontrado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public void clearCliente() {
        view.getCadClienteUserField().setText("");
        view.getCadClienteNomeField().setText("");
        view.getCadClienteTelefoneField().setText("");
        view.getCadClienteEnderecoField().setText("");
    }
    public void clearEdiCliente() {
        view.getEdiClienteTelefoneField().setText("");
        view.getEdiClienteNomeField().setText("");
        view.getEdiClienteEnderecoField().setText("");
        view.getEdiClienteUserField().setText("");
        view.getEdiClienteDataField().setText("");
        view.getSearchID().setText("");

    }
    public void editCliente() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        if((view.getEdiClienteNomeField().getText().length()>0) && (view.getEdiClienteTelefoneField().getText().length()>0) &&
                (view.getEdiClienteEnderecoField().getText().length()>0) &&
                (view.getEdiClienteUserField().getText().length()>0) &&(view.getEdiClienteDataField().getText().length()>0)) {
                db.update_client(conn, "cliente",
                        view.getSearchID().getText(),
                        view.getEdiClienteNomeField().getText(),
                        view.getEdiClienteTelefoneField().getText(),
                        view.getEdiClienteEnderecoField().getText(),
                        view.getEdiClienteUserField().getText(),
                        view.getEdiClienteDataField().getText());
        }
        else {
            JOptionPane.showMessageDialog(null, "Campo Vazio");
        }
    }
    public void searchFuncionario() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
            view.getEdifuncNomeField().setText(db.getNome_info(conn, "usuario", "usuario",view.getSearchUser().getText()));
            view.getEdifuncTelField().setText(db.getTelefone_info(conn, "usuario", "usuario", view.getSearchUser().getText()));
            view.getEdifuncEndField().setText(db.getEndereco_info(conn, "usuario", "usuario", view.getSearchUser().getText()));
            view.getEdifuncUserField().setText(db.getUser_info(conn, view.getSearchUser().getText()));
            view.getEdifuncSenField().setText(db.getSenha_info(conn, view.getSearchUser().getText()));
            view.getEdifuncQtdField().setText(db.getQtdVendas_info(conn, view.getSearchUser().getText()));
            view.getEdifuncTipoField().setText(db.getUsuarioTipo_info(conn, view.getSearchUser().getText()));
            view.getEdifuncDataField().setText(db.getDataCadastro_info(conn, "usuario", "usuario", view.getSearchUser().getText()));

    }
    public void editFuncionario() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        if((view.getEdifuncNomeField().getText().length()>0) && (view.getEdifuncTelField().getText().length()>0) && (view.getEdifuncEndField().getText().length()>0) &&
                (view.getEdifuncUserField().getText().length()>0) && (String.valueOf(view.getEdifuncSenField().getPassword()).length()>0) && (view.getEdifuncQtdField().getText().length()>0) &&
                (view.getEdifuncTipoField().getText().length()>0) && view.getEdifuncDataField().getText().length()>0) {
                db.update_user(conn, "usuario",
                        view.getSearchUser().getText(),
                        view.getEdifuncNomeField().getText(),
                        view.getEdifuncTelField().getText(),
                        view.getEdifuncEndField().getText(),
                        view.getEdifuncUserField().getText(),
                        String.valueOf(view.getEdifuncSenField().getPassword()),
                        view.getEdifuncQtdField().getText(),
                        view.getEdifuncTipoField().getText(),
                        view.getEdifuncDataField().getText());
        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public void editFuncClear() {
        view.getSearchUser().setText("");
        view.getEdifuncNomeField().setText("");
        view.getEdifuncTelField().setText("");
        view.getEdifuncEndField().setText("");
        view.getEdifuncUserField().setText("");
        view.getEdifuncSenField().setText("");
        view.getEdifuncQtdField().setText("");
        view.getEdifuncTipoField().setText("");
        view.getEdifuncDataField().setText("");
    }
    public void cadFuncClear() {
        view.getCadFuncNomeField().setText("");
        view.getCadFuncTelField().setText("");
        view.getCadFuncEndField().setText("");
        view.getCadFuncUserField().setText("");
        view.getCadFuncSenField().setText("");
    }
    public void cadFuncSave() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        String nome = view.getCadFuncNomeField().getText();
        String telefone = view.getCadFuncTelField().getText();
        String endereco = view.getCadFuncEndField().getText();
        String userUsuario = view.getCadFuncUserField().getText();
        String senha = String.valueOf(view.getCadFuncSenField().getPassword());

        GregorianCalendar calendar = new GregorianCalendar();
        String dataCadastro = calendar.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                calendar.get(GregorianCalendar.MONTH) + "/" +
                calendar.get(GregorianCalendar.YEAR);

        if ((view.getCadFuncNomeField().getText().length() > 0) && (view.getCadFuncTelField().getText().length() > 0) &&
                (view.getCadFuncEndField().getText().length() > 0) && (view.getCadFuncUserField().getText().length() > 0) && (String.valueOf(view.getCadFuncSenField().getPassword()).length() > 0)) {
            try {
                Usuario usuario = new Usuario(userUsuario, nome, telefone, endereco, dataCadastro, senha, 0, "Funcion\u00E1rio");
                db.insert_row_funcionario(conn, "usuario", usuario.getUser(), usuario.getNome(), usuario.getTelefone(), usuario.getEndereco(), usuario.getSenha(), usuario.getUsuarioTipo(), usuario.getDataCadastro());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "");
        }
    }
    public void searchProd() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        if((view.getSearchIdProduto().getText().length()>0)){
                view.getEdiProdNomeField().setText(db.getNome_info(conn, "produto", "idproduto", view.getSearchIdProduto().getText()));
                view.getEdiProdTelefoneField().setText(db.getTelefone_info(conn, "produto", "idproduto", view.getSearchIdProduto().getText()));
                view.getEdiProdEndField().setText(db.getEndereco_info(conn, "produto", "idproduto", view.getSearchIdProduto().getText()));
                view.getEdiProdPrecoCompra().setText(db.getPrecoCompra_info(conn, Integer.valueOf(view.getSearchIdProduto().getText())));
                view.getEdiProdPrecoVenda().setText(db.getPrecoVenda_info(conn, Integer.valueOf(view.getSearchIdProduto().getText())));
                view.getEdiProdDataField().setText(db.getDataCadastro_info(conn, "produto", "idproduto", view.getSearchIdProduto().getText()));
        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public void prodSave() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        String nome = view.getCadProdNomeField().getText();
        String telefoneImportadora = view.getCadProdTelefoneField().getText();
        String enderecoImportadora = view.getCadProdEndField().getText();
        int quantidade = Integer.parseInt(view.getCadQuantidadeField().getText());
        String precoCompra = view.getCadProdPrecoCompra().getText();
        String precoVenda = view.getCadProdPrecoVenda().getText();
        GregorianCalendar calendar = new GregorianCalendar();
        String dataCadastro = calendar.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                calendar.get(GregorianCalendar.MONTH)+1 + "/" +
                calendar.get(GregorianCalendar.YEAR);

        if((view.getCadProdNomeField().getText().length()>0) && (view.getCadProdTelefoneField().getText().length()>0) &&
                (view.getCadProdEndField().getText().length()>0) && (view.getCadProdPrecoCompra().getText().length()>0)   &&
                (view.getCadProdPrecoVenda().getText().length()>0)) {
            try{
                Produto produto = new Produto(null, nome, telefoneImportadora, enderecoImportadora, quantidade, precoCompra, precoVenda, dataCadastro);
                                db.insert_row_produto(conn,
                                        produto.getProdutoNome(),
                                        produto.getTelefoneImportadora(),
                                        produto.getEnderecoImportadora(),
                                        produto.getQuantidade(),
                                        produto.getPrecoCompra(),
                                        produto.getPrecoVenda(),
                                        produto.getDatacadastro());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public void prodClear() {
        view.getCadQuantidadeField().setText("");
        view.getCadProdNomeField().setText("");
        view.getCadProdTelefoneField().setText("");
        view.getCadProdEndField().setText("");
        view.getCadProdPrecoCompra().setText("");
        view.getCadProdPrecoVenda().setText("");
    }
    public void editProdSave() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        if(((view.getEdiProdNomeField().getText().length()>0) && (view.getEdiProdTelefoneField().getText().length()>0) &&
                (view.getEdiProdEndField().getText().length()>0) && (view.getEdiProdPrecoCompra().getText().length()>0) && (view.getEdiProdPrecoVenda().getText().length()>0)&&
                (view.getEdiProdDataField().getText().length()>0))) {

                db.update_produto(conn, "produto",
                        view.getSearchIdProduto().getText(),
                        view.getEdiProdNomeField().getText(),
                        view.getEdiProdTelefoneField().getText(),
                        view.getEdiProdEndField().getText(),
                        String.valueOf(view.getEdiProdPrecoCompra().getText()),
                        String.valueOf(view.getEdiProdPrecoVenda().getText()),
                        view.getEdiProdDataField().getText());


        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public void ediProdClear() {
        view.getSearchIdProduto().setText("");
        view.getEdiProdNomeField().setText("");
        view.getEdiProdTelefoneField().setText("");
        view.getEdiProdPrecoCompra().setText("");
        view.getEdiProdPrecoVenda().setText("");
        view.getEdiProdDataField().setText("");
        view.getEdiProdDataField().setText("");
    }
    public void saveVenda() throws vendaException {
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
                calendar.get(GregorianCalendar.MONTH)+1 + "/" +
                calendar.get(GregorianCalendar.YEAR);

        if((view.getVenIdClienteField().getText().length()>0) && (view.getFichaTextPane().getText().length()>0) &&
                (view.getVenQtdField().getText().length()>0) && (view.getVenIdUserField().getText().length()>0) &&
                (view.getVenIdClienteField().getText().length()>0)) {
                Venda venda = new Venda(null, descricao, precoTotal, datavenda, idCliente, idUsuario, qtdItem, idProduto);
                db.insert_row_venda(conn,  venda.getDescricao(),venda.getIdCliente(), venda.getIdUsuario(), venda.getPrecoTotal(), venda.getDataVenda());
                db.vendaEfetuada(conn, idUsuario, qtdItem);

        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public void clearVendas() {
        view.getVenPrecoTotField().setText("0.00");
        view.getVenIdProdutoField().setText("");
        view.getVenQtdField().setText("");
        view.getVenIdUserField().setText("");
        view.getVenIdClienteField().setText("");
    }
    public void addVendas() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");

        String nomeProduto = db.getNome_info(conn, "produto", "idproduto", view.getVenIdProdutoField().getText());
        String nomeCliente = db.getNome_info(conn, "cliente", "idcliente", view.getVenIdClienteField().getText());
        String nomeUsuario = db.getNome_info(conn, "usuario", "usuario", view.getVenIdUserField().getText());

        // Verificar se os campos são vazios
        if((view.getVenIdProdutoField().getText().length()>0) && (view.getVenQtdField().getText().length()>0) &&
                (view.getVenIdClienteField().getText().length()>0) && (view.getVenIdUserField().getText().length()>0))  {
            // Verificar se o usuario o cliente e o produto estão cadastrados no banco de dados
            if((db.verificarUsuario(view.getVenIdUserField().getText(), db.read_idUsuario(conn))) &&
                    (db.verificarCliente(view.getVenIdClienteField().getText(), db.read_idCliente(conn))) &&
                    ((db.verificarProduto(view.getVenIdProdutoField().getText(), db.read_idProduto(conn))))) {
                // Verificar se a quantidade de itens desejada é menor ou igual a quantidade registrada no banco
                if((Integer.parseInt(db.getQuantidadeItem(conn, view.getVenIdProdutoField().getText())) >= Integer.parseInt(view.getVenQtdField().getText()))) {
                    view.getFichaTextPane().setText(view.getFichaTextPane().getText()+
                                            "ID do produto: "+ view.getVenIdProdutoField().getText()+" \n" +nomeProduto+" \n"+
                                            "Quantidade: "+ view.getVenQtdField().getText()+" \n"+
                                            "ID do Cliente: "+view.getVenIdClienteField().getText()+" \n" + nomeCliente + " \n"+
                                            "ID Usuário: "+ view.getVenIdUserField().getText()+" \n"+nomeUsuario+" \n\n");

                                    Integer idproduto = Integer.valueOf(view.getVenIdProdutoField().getText());
                                    String quantidade = view.getVenQtdField().getText();
                                    view.getVenPrecoTotField().setText(this.precTot(idproduto, quantidade));
                                    db.updateQtdItens(conn, String.valueOf(idproduto), quantidade);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Quantidade inv\u00E1lida");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "idCliente/idUsuario/idproduto n\u00E3o existe");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Campo vazio");
        }
    }
    public String precTot(Integer idproduto , String quantidade) {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        String precoVend = String.valueOf(db.getPrecoVenda_info(conn, idproduto));
        String precAtual = view.getVenPrecoTotField().getText();
        String precTotal = String.valueOf(Double.parseDouble(precoVend)*Double.parseDouble(quantidade));

        return String.valueOf(Double.valueOf(Double.parseDouble(precAtual)+Double.parseDouble(precTotal)));
    }
    public void fillTableUsuario() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        DefaultTableModel model = (DefaultTableModel) view.getUsuariosTable().getModel();
        model.setNumRows(0);

        for(Usuario usuario: db.read_dataUsuarios(conn)){
            model.addRow(new Object[]{
                    usuario.getUser(),
                    usuario.getNome(),
                    usuario.getTelefone(),
                    usuario.getEndereco(),
                    usuario.getSenha(),
                    usuario.getQtdVendas(),
                    usuario.getUsuarioTipo(),
                    usuario.getDataCadastro()
            });
        }
    }
    public void fillTableCliente() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        DefaultTableModel model = (DefaultTableModel) view.getClientesTable().getModel();
        view.getClientesTable().setRowSorter(new TableRowSorter<TableModel>(model));
        model.setNumRows(0);

        for(Cliente cliente: db.read_dataClientes(conn)){
            model.addRow(new Object[]{
                    cliente.getIdCliente(),
                    cliente.getNome(),
                    cliente.getTelefone(),
                    cliente.getEndereco(),
                    cliente.getUserUsuario(),
                    cliente.getDataCadastro()
            });
        }
    }
    public void fillTableProduto() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        DefaultTableModel model = (DefaultTableModel) view.getProdutosTable().getModel();
        view.getProdutosTable().setRowSorter(new TableRowSorter<TableModel>(model));
        model.setNumRows(0);

        for(Produto produto: db.read_dataProdutos(conn)){
            model.addRow(new Object[]{
                    produto.getIdProduto(),
                    produto.getProdutoNome(),
                    produto.getTelefoneImportadora(),
                    produto.getEnderecoImportadora(),
                    produto.getQuantidade(),
                    produto.getPrecoCompra(),
                    produto.getPrecoVenda(),
                    produto.getDatacadastro()
            });
        }
    }
    public void fillTableVendas() {
        DAOFunctions db = new DAOFunctions();
        Connection conn = db.connect_to_db("InfoTech", "postgres", "ffv35481884");
        DefaultTableModel model = (DefaultTableModel) view.getVendasTable().getModel();
        view.getVendasTable().setRowSorter(new TableRowSorter<TableModel>(model));
        model.setNumRows(0);
        for(Venda venda: db.read_dataVendas(conn)){
            model.addRow(new Object[]{
                    venda.getIdVenda(),
                    venda.getDescricao(),
                    venda.getIdCliente(),
                    venda.getIdUsuario(),
                    venda.getPrecoTotal(),
                    venda.getDataVenda()
            });
        }
    }
}
