package Order;


import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    public StringBuffer toStringBuffer(){
        StringBuffer ordString = new StringBuffer("{\"id\": " + getOrderId() + ", \"products\": [");

        for (int j = 0; j < getProductsCount(); j++) {
            ordString.append(getProduct(j).toStringBuffer());
        }

        if (getProductsCount() > 0) {
            ordString.delete(ordString.length() - 2, ordString.length());
        }

        ordString.append("]}, ");
        return ordString;
    }
}
