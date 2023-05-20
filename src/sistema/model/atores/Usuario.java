package sistema.model.atores;

public class Usuario extends Pessoa {

	private String user;
	private String senha;
	private Integer qtdVendas;
	private String usuarioTipo;
	public Usuario() {
		super();
	}
	public Usuario(String user ,String nome , String telefone , String endereco ,String dataCadastro, String senha , Integer qtdVendas, String usuarioTipo) throws atoresException {
		super(nome,telefone,endereco,dataCadastro);
		setUser(user);
		setSenha(senha);
		setQtdVendas(qtdVendas);
		setUsuarioTipo(usuarioTipo);
	}

	public String getUser() {return user;}
	public String getSenha() {return senha;}
	public int getQtdVendas() {
		return qtdVendas;
	}
	public String getUsuarioTipo() {return usuarioTipo;}
	public void setUser(String user) throws atoresException
	{
		if(!user.isEmpty())
			this.user = user;
		else{
			throw new atoresException("USER VAZIO \n OPERACAO INVALIDA");
		}
	}
	public void setSenha(String senha)throws atoresException
	{
		if(!senha.isEmpty())
			this.senha = senha;
		else{
			throw new atoresException("SENHA VAZIO \n OPERACAO INVALIDA");
		}

	}
	public void setQtdVendas(Integer qtdVendas )throws atoresException
	{

		if(qtdVendas!= null)
			this.qtdVendas = qtdVendas;
		else{
			throw new atoresException("QUANTIDADE DE VENDAS  VAZIO \n OPERACAO INVALIDA");
		}
	}
	public void setUsuarioTipo(String usuarioTipo) throws atoresException
	{
		if(qtdVendas!= null)
			this.usuarioTipo = usuarioTipo;
		else{
			throw new atoresException("USUARIO TIPO VAZIO \n OPERACAO INVALIDA");
		}
	}
}
