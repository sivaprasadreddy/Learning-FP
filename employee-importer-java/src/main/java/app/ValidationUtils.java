package app;

class ValidationUtils {
    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isEmail(String value) {
        return value != null && value.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static boolean isPositive(Double value) {
        return value != null && value > 0;
    }
}
