public class Product {
    private String productId;
    private String orderId;
    private boolean shipped;

    public Product() {
    }

    public Product(String productId, String productOrder) {
        this.productId = productId;
        this.orderId = productOrder;
        this.shipped = false; // By default, a product is not shipped
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
