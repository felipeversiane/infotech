package sistema.model.atores;

public class atoresException extends Exception
{
    String mensagem;
    atoresException(String mensagem)
    {
        super(mensagem);
        this.mensagem=mensagem;
    }
}
