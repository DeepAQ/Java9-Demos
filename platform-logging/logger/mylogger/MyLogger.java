package mylogger;

import java.util.ResourceBundle;

public class MyLogger implements System.Logger {
    @Override
    public String getName() {
        return "MyLogger";
    }

    @Override
    public boolean isLoggable(Level level) {
        return true;
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
        System.out.println("[MyLogger] " + level + "/" + msg);
    }

    @Override
    public void log(Level level, ResourceBundle bundle, String format, Object... params) {
        System.out.println("[MyLogger] " + level + "/" + String.format(format, params));
    }
}
