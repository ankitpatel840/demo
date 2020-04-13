package springpayroll.exception;

public class ECodeNotFoundException extends  RuntimeException {




    public ECodeNotFoundException(String e_code)
    {

        super(e_code);
    }
}
