package sistema.model.pedido;

public class Venda {
	private String idVenda;
	private String precoTotal;
	private String dataVenda;
	private int idCliente;
	private String idUsuario;
	private String qtdItem;
	private String idProduto;



	private String descricao;

	public Venda(String idVenda, String descricao, String precoTotal, String dataVenda, String idCliente, String idUsuario,
				 String qtdItem, String idProduto) throws vendaException {
		super();
		setIdVenda(idVenda);
		setPrecoTotal(precoTotal);
		setDataVenda(dataVenda);
		setIdCliente(idCliente);
		setIdUsuario(idUsuario);
		setQtdItem(qtdItem);
		setIdProduto(idProduto);
		setDescricao(descricao);
	}

    public Venda() throws Exception{

    }
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) throws vendaException
	{
		if(!descricao.isEmpty())
			this.descricao = descricao;
		else{
			throw new vendaException("DESCRICAO VAZIA \n OPERACAO INVALIDA");
		}
	}
	public void setIdVenda(String idVenda) throws vendaException
	{
		if(!idVenda.isEmpty())
			this.idVenda = idVenda;
		else{
			throw new vendaException("ID VENDA VAZIA \n OPERACAO INVALIDA");
		}
	}
	public void setPrecoTotal(String precoTotal) throws  vendaException
	{
		if(!precoTotal.isEmpty())
			this.precoTotal = precoTotal;
		else{
			throw new vendaException("PRECO TOTAL VAZIA \n OPERACAO INVALIDA");
		}
	}

	public void setDataVenda(String dataVenda) throws vendaException
	{
		if(!dataVenda.isEmpty())
			this.dataVenda = dataVenda;
		else{
			throw new vendaException("DATA VENDA VAZIA \n OPERACAO INVALIDA");
		}
	}

	public void setIdCliente(String idCliente) throws vendaException
	{
		if(!idCliente.isEmpty())
			this.idCliente = Integer.parseInt(idCliente);
		else{
			throw new vendaException("ID CLIENTE VAZIA \n OPERACAO INVALIDA");
		}
  }

	public void setIdUsuario(String idUsuario) throws vendaException
	{
		if(!idUsuario.isEmpty())
			this.idUsuario=idUsuario;
		else{
			throw new vendaException("ID USUARIO VAZIO \n OPERACAO INVALIDA");
		}

	}

	public void setQtdItem(String qtdItem) throws vendaException
	{
		if(!qtdItem.isEmpty())
			this.qtdItem = qtdItem;
		else {
			throw new vendaException("QTD ITEM VAZIA \n OPERACAO INVALIDA");
		}

	}
	public void setIdProduto( String idProduto) throws  vendaException
	{
		if(!idProduto.isEmpty())
			this.idProduto=idProduto;
		else{
			throw new vendaException("ID PRODUTO VAZIA \n OPERACAO INVALIDA");
		}
	}
	public String getIdVenda(){ return idVenda;}
	public String getPrecoTotal(){ return precoTotal;}
	public String getDataVenda(){ return dataVenda;}
	public int getIdCliente(){ return idCliente;}
	public String getIdUsuario(){ return idUsuario;}

}
