package sistema.model.estoque;

public class produtoException extends Exception
{
    String mensagem;
    produtoException(String mensagem)
    {
        super(mensagem);
        this.mensagem=mensagem;
    }
}
