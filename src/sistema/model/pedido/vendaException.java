package sistema.model.pedido;

public class vendaException extends Exception
{
    String mensagem;
    vendaException(String mensagem)
    {
        super(mensagem);
        this.mensagem=mensagem;
    }
}
