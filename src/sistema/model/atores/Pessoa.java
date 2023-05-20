package sistema.model.atores;

public class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	private String dataCadastro;
	public Pessoa() {}
	public Pessoa(String nome, String telefone, String endereco, String dataCadastro) throws atoresException {
		super();
		setNome(nome);
		setTelefone(telefone);
		setEndereco(endereco);
		setDataCadastro(dataCadastro);
	}
	public String getDataCadastro() { return dataCadastro;}
	public String getNome() {return nome;}
	public String getTelefone() {return telefone;}
	public String getEndereco() {return endereco;}
	public void setDataCadastro(String dataCadastro) throws atoresException
	{
		if(!dataCadastro.isEmpty())
			this.dataCadastro=dataCadastro;
		else{
			throw new atoresException("DATA CADASTRO NULO \n INVALIDO");
		}
	}
	public void setNome(String nome) throws atoresException
	{
		if(!nome.isEmpty())
			this.nome=nome;
		else{
			throw new atoresException("NOME NULO \n INVALIDO");
		}
	}
	public void setTelefone(String telefone) throws atoresException
	{
		if(!telefone.isEmpty())
			this.telefone=telefone;
		else{
			throw new atoresException("TELEFONE NULO \n INVALIDO");
		}
	}
	public void setEndereco(String endereco) throws atoresException
	{
		if(!endereco.isEmpty())
			this.endereco=endereco;
		else{
			throw new atoresException("ENDERECO NULO \n INVALIDO");
		}

	}
}