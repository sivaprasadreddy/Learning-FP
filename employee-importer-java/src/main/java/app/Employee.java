package app;

record Employee(String name, String email, Double salary, String address) {
    public boolean isValid() {
        return ValidationUtils.isNotBlank(name()) &&
                ValidationUtils.isNotBlank(email()) &&
                ValidationUtils.isEmail(email()) &&
                ValidationUtils.isPositive(salary());
    }
}
