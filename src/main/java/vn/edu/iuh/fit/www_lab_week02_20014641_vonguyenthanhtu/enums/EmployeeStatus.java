package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums;

public enum EmployeeStatus {
    IN_ACTIVE(0),
    ACTIVE(1),

    TERMINATED(-1);
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EmployeeStatus fromCode(int code) throws IllegalAccessException {
        for (EmployeeStatus status: EmployeeStatus.values()) {
            if (status.getValue() == code){
                return status;
            }
        }
        throw new IllegalAccessException("Invalid EmployeeStatus code: "+ code);
    }
}
