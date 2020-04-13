package springpayroll.exception;

public class InvalidStateCodeException extends  Exception
{
    public InvalidStateCodeException(String s,Throwable throwable)
    {
        super(s,throwable);
    }

    public InvalidStateCodeException(String s) {
    }
}
