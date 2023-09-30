package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums;

public enum CustomerStatus {
    IN_ACTIVE(0),
    ACTIVE(1);
    private int value;

    CustomerStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static CustomerStatus fromCode(int code) throws IllegalAccessException {
        for (CustomerStatus grant: CustomerStatus.values()) {
            if (grant.getValue() == code){
                return grant;
            }
        }
        throw new IllegalAccessException("Invalid CustomerStatus code: "+ code);
    }
}
