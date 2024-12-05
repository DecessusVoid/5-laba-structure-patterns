 class ExternalLogger {
    public void logMessage(String msg) {
        System.out.println("External log: " + msg);
    }
}
 interface Logger {
    void log(String message);
}
class LoggerAdapter implements Logger {
    private ExternalLogger externalLogger;

    public LoggerAdapter(ExternalLogger externalLogger) {
        this.externalLogger = externalLogger;
    }

    @Override
    public void log(String message) {
        externalLogger.logMessage(message); 
    }
}
public class Adapter {
    public static void main(String[] args) {
        ExternalLogger externalLogger = new ExternalLogger();
        Logger logger = new LoggerAdapter(externalLogger);

        logger.log("This is a test message."); 
    }
}