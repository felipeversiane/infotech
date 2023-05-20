package sistema.controller;

import sistema.model.gerenteModel;
import sistema.model.pedido.vendaException;
import sistema.view.gerenteView;

public class gerenteController
{
    gerenteView view;
    gerenteModel model;
    public gerenteController(){}
    public gerenteController(gerenteView view, gerenteModel model)
    {
        this.view = view;
        this.model= model;
    }
    public void mudaCor()
    {
        model.corAleatoria();
    }
    public void clear()
    {
        model.clear();
    }
    public String dataPorExtenso()
    {
        return model.dataPorExtenso();
    }
    public void searchCliente()
    {
        model.searchCliente();
    }
    public void saveCliente()
    {
        model.saveCliente();
    }
    public void clearCliente()
    {
        model.clearCliente();
    }
    public void editCliente(){
        model.editCliente();
    }
    public void searchFuncionario()
    {
        model.searchFuncionario();
    }
    public void editFuncionario()
    {
        model.editFuncionario();
    }
    public void editFuncClear()
    {
        model.editFuncClear();
    }
    public void cadFuncClear()
    {
        model.cadFuncClear();
    }
    public void cadFuncSave()
    {
        model.cadFuncSave();
    }
    public void searchProd()
    {
        model.searchProd();
    }
    public void prodSave()
    {
        model.prodSave();
    }
    public void prodClear()
    {
        model.prodClear();
    }
    public void editProdSave()
    {
        model.editProdSave();
    }
    public void ediProdClear()
    {
        model.ediProdClear();
    }
    public void saveVenda() throws vendaException {
        model.saveVenda();
    }
    public void clearVendas()
    {
        model.clearVendas();
    }
    public void addVendas(){
        model.addVendas();
    }
    public void precTot(Integer idproduto,String quantidade)
    {
        model.precTot(idproduto,quantidade);

    }
    public void fillTableUsuario()
    {
        model.fillTableUsuario();
    }
    public void fillTableCliente()
    {
        model.fillTableCliente();
    }
    public void fillTableProduto()
    {
        model.fillTableProduto();
    }
    public void fillTableVendas()
    {
        model.fillTableVendas();
    }
    public void ediClearCliente()
    {
        model.clearEdiCliente();
    }



}
