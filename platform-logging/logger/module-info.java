module logger {
    requires java.logging;
    provides java.lang.System.LoggerFinder with mylogger.MyLoggerFinder;
}