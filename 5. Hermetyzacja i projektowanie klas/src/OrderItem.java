import java.util.ArrayList;

// Klasa OrderItem (niemutowalna)
class OrderItem {
    private final String productName;
    private final int quantity;
    private final double unitPrice;

    public OrderItem(String productName, int quantity, double unitPrice) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (unitPrice <= 0) {
            throw new IllegalArgumentException("Unit price must be positive");
        }

        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double subtotal() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "OrderItem[product=" + productName +
                ", qty=" + quantity +
                ", price=" + unitPrice + "]";
    }
}


// Klasa Order
class Order {
    private static final String DRAFT = "DRAFT";
    private static final String CONFIRMED = "CONFIRMED";
    private static final String SHIPPED = "SHIPPED";

    private String orderId;
    private ArrayList<OrderItem> items;
    private String status;

    public Order(String orderId) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be empty");
        }
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = DRAFT;
    }

    public void addItem(OrderItem item) {
        if (!status.equals(DRAFT)) {
            throw new IllegalStateException("Cannot modify confirmed order");
        }
        if (items.size() >= 5) {
            throw new IllegalStateException("Order is full");
        }
        items.add(item);
    }

    public void confirm() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot confirm empty order");
        }
        this.status = CONFIRMED;
    }

    public void ship() {
        if (!status.equals(CONFIRMED)) {
            throw new IllegalStateException("Order must be confirmed first");
        }
        this.status = SHIPPED;
    }

    public double calculateTotal() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.subtotal();
        }
        return sum;
    }

    public String getStatus() {
        return status;
    }

    public int getItemCount() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Order[id=" + orderId +
                ", items=" + getItemCount() +
                ", status=" + status +
                ", total=" + String.format("%.2f", calculateTotal()) + "]";
    }
}