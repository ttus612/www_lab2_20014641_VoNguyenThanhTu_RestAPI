package vn.edu.iuh.fit.www_lab_week02_20014641_vonguyenthanhtu.enums;

public enum ProductStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductStatus fromCode(int code) throws IllegalAccessException {
        for (ProductStatus productStatus: ProductStatus.values()) {
            if (productStatus.getValue() == code){
                return productStatus;
            }
        }
        throw new IllegalAccessException("Invalid ProductStatus code: "+ code);
    }
}
