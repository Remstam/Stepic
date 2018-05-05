private static void configureLogging() {
    Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
    Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
    Logger logger = Logger.getLogger("org.stepic.java");
    
    loggerA.setLevel(Level.ALL);
    loggerB.setLevel(Level.WARNING);
    
    Handler handler = new ConsoleHandler();
    Formatter formatter = new XMLFormatter();
    
    handler.setLevel(Level.ALL);
    handler.setFormatter(formatter);
    
    logger.addHandler(handler);
    logger.setUseParentHandlers(false);
}
