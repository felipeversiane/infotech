package sistema.model.estoque;

public class Produto {
	private String idProduto;
	private String produtoNome;
	private String telefoneImportadora;
	private String enderecoImportadora;
	private String precoVenda;
	private String precoCompra;
	private int quantidade;
	private String datacadastro;
	public Produto(String idProduto, String produtoNome, String telefoneImportadora, String enderecoImportadora, int quantidade,
				   String precoCompra, String precoVenda, String datacadastro) throws produtoException {
		super();
		setIdProduto(idProduto);
		setProdutoNome(produtoNome);
		setTelefoneImportadora(telefoneImportadora);
		setEnderecoImportadora(enderecoImportadora);
		setQuantidade(quantidade);
		setPrecoCompra(precoCompra);
		setPrecoVenda(precoVenda);
		setDatacadastro(datacadastro);
	}

    public Produto() {}
	public Produto(String idProduto, String nome) throws produtoException{
		setIdProduto(idProduto);
		setProdutoNome(nome);
	}

	public void setIdProduto(String idProduto)throws produtoException
	{
		if(!idProduto.isEmpty())
			this.idProduto=idProduto;
		else{
			throw new produtoException("ID PRODUTO VAZIO \n OPERACAO INVALIDA !");
		}
	}
	public void setTelefoneImportadora(String telefoneImportadora)throws produtoException
	{
		if(!telefoneImportadora.isEmpty())
			this.telefoneImportadora=telefoneImportadora;
		else{
			throw new produtoException("TELEFONE DA IMPORTADORA VAZIO \n OPERACAO INVALIDA!");
		}
	}
	public void setProdutoNome(String produtoNome) throws produtoException
	{
		if(!produtoNome.isEmpty())
			this.produtoNome = produtoNome;
		else{
			throw new produtoException(" NOME DO PRODUTO VAZIO \n OPERACAO INVALIDA!");
		}
	}
	public void setEnderecoImportadora(String enderecoImportadora) throws produtoException
	{
		if(!enderecoImportadora.isEmpty())
			this.enderecoImportadora = enderecoImportadora;
		else{
			throw new produtoException("ENDERECO DA IMPORTADORA VAZIO \n OPERACAO INVALIDA");
		}
	}
	public void setPrecoVenda(String precoVenda) throws produtoException
	{
		if(!precoVenda.isEmpty())
			this.precoVenda=precoVenda;
		else{
			throw new produtoException("PRECO VENDA VAZIO \n OPERACAO INVALIDA");

		}
	}
	public void setPrecoCompra(String precoCompra) throws produtoException
	{
		if(!precoCompra.isEmpty())
			this.precoCompra=precoCompra;
		else{
			throw new produtoException("PRECO COMPRA VAZIO \n OPERACAO INVALIDA");
		}
	}
	public  void setDatacadastro(String datacadastro) throws produtoException
	{
		if(!datacadastro.isEmpty())
			this.datacadastro = datacadastro;
		else{
			throw new produtoException("DATA CADASTRO VAZIO \n OPERACAO INVALIDA");
		}
	}
	public String getIdProduto() {return idProduto;}
	public String getTelefoneImportadora() { return telefoneImportadora;}
	public String getPrecoVenda() { return precoVenda;}
	public String getPrecoCompra() {return precoCompra;}
	public String getProdutoNome() { return produtoNome;}
	public String getEnderecoImportadora() {
		return enderecoImportadora;
	}
	public String getDatacadastro(){
		return datacadastro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
