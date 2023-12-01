import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class MyException1 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public MyException1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
class MyException2 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public MyException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class exceptionlogger {
    static void throwExc1() throws MyException1, MyException2 {
        throw new MyException1();
    }
    static void throwExc2() throws MyException2 {
        throw new MyException2();
    }
    public static void main(String[] args) {
        try {
            throwExc1();
        } catch(Exception e1) {}
        try {
            throwExc2();
        } catch(Exception e2) {}
    }
}

