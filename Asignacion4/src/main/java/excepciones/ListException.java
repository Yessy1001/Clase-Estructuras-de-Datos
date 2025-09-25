package excepciones;

public class ListException extends RuntimeException {
    public ListException() {
        super();
    }
    public ListException(String msj) {
        super(msj);
    }
}
