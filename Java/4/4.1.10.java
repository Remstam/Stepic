public static String getCallerClassAndMethodName() {
    StackTraceElement[] elements = new Exception().getStackTrace();
    if (elements.length > 2) {
        StackTraceElement caller = elements[2];
        return caller.getClassName() + "#" + caller.getMethodName();
    }
    
    return null;
}
