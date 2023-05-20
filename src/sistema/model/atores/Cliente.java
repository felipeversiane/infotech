package sistema.model.atores;

public class Cliente extends Pessoa {
	private String idCliente;
	private String userUsuario;
	public Cliente() {}

	public Cliente(String idCliente, String nome) throws atoresException{
		setIdCliente(idCliente);
		setNome(nome);
	}

	public Cliente(String idCliente,String nome, String telefone, String endereco, String dataCadastro, String userUsuario) throws atoresException {
		super(nome,telefone,endereco,dataCadastro);
		setIdCliente(idCliente);
		setUserUsuario(userUsuario);
	}
	public void setUserUsuario(String userUsuario) throws atoresException
	{
		if(!userUsuario.isEmpty())
			this.userUsuario=userUsuario;
		else{
			throw new atoresException("USUARIO VAZIO \n OPERACAO INVALIDA");
		}
	}
	public void setIdCliente(String idCliente) throws atoresException
	{
		if(!userUsuario.isEmpty())
			this.idCliente = idCliente;
		else{
			throw new atoresException("ID CLIENTE VAZIO \n OPERACAO INVALIDA");
	}
	}
	public String getIdCliente() {
		return idCliente;
	}
	public String getUserUsuario() {
		return userUsuario;
	}
}