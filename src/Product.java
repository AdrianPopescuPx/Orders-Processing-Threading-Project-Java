public class Product {
    private String productId;
    private String productOrder;
    private boolean shipped;

    public Product() {
    }

    public Product(String productId, String productOrder) {
        this.productId = productId;
        this.productOrder = productOrder;
        this.shipped = false; // By default, a product is not shipped
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(String productOrder) {
        this.productOrder = productOrder;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
