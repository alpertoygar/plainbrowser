package logging;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@UtilityClass
public class LoggerFactory {

    private static FileHandler loggingFileHandler;

    public static <T> Logger getLogger(Class<T> c) {
        Logger logger = Logger.getLogger(c.getName());
        logger.setLevel(Level.INFO);

        if (loggingFileHandler == null) {
            setFileHandler();
        }
        logger.addHandler(loggingFileHandler);

        return logger;
    }

    private static void setFileHandler(){
        try {
            loggingFileHandler = new FileHandler("log/plainbrowser.log", true);
            SimpleFormatter textFormatter = new SimpleFormatter();
            loggingFileHandler.setFormatter(textFormatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
