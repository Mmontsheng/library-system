package com.mmontsheng.library.util;

public class Utility {
    
    private Utility() {
       throw new IllegalStateException("Utility class");
    }
    
    public static String doesNotExist(String entity) {
        return entity + " does not exists";
    }

    public static String alreadyExist(String entity) {
        return entity + " already exists";
    }
    public static String statusUpdatedTo(String entitName, Boolean enabled) {
        String status = enabled.booleanValue() ? "enabled" : "disabled";
        return entitName +" status set to" + status;
    }
}
