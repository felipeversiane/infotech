package sistema.controller;
import sistema.model.funcionarioModel;
import sistema.model.pedido.vendaException;
import sistema.view.funcionarioView;

public class funcionarioController {
    funcionarioModel model;
    funcionarioView view;
    public funcionarioController(funcionarioModel model, funcionarioView view) {
        this.model=model;
        this.view=view;
    }

    public String dataAtual()
    {
        return this.model.dataAtual();
    }
    public void mudarCor() {
        model.mudarCor();
    }
    public String precoTotal(Integer idproduto,String quantidade)
    {
        return this.model.precTot(idproduto,quantidade);
    }
    public void CadClienteSalvarBtt()
    {
        this.model.CadClienteSalvarBtt();
    }
    public void CadClienteClearBtt()
    {
        this.model.CadClienteClearBtt();
    }
    public void VendasSalvarBtt() throws vendaException {
        this.model.VendaSalvarBtt();
    }
    public void VendasClearBtt()
    {
        this.model.VendasClearBtt();
    }
    public void addVenda()
    {
        this.model.addVenda();
    }
    public void fillTableCliente()
    {
        this.model.fillTableCliente();
    }
    public void fillTableProduto()
    {
        this.model.fillTableProduto();
    }

}
