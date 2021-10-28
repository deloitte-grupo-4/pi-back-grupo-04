package br.com.piback.ecommerce.Domain.Enums;

public enum ProductSize {

    P(1),
    M(2),
    G(3),
    GG(4);

    private int code;

    private ProductSize(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProductSize valueOf(int code) {
        for (ProductSize value : ProductSize.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Product Size code");
    }
}
