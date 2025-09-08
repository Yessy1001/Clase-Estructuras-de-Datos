package excepciones;

public class BolsaException extends RuntimeException {
    public BolsaException() {
        super();
    }

    public BolsaException(String s) {
        super(s);
    }
}
