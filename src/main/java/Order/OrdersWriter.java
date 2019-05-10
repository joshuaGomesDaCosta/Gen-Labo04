package Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersWriter {
    private List<Order> orders = new ArrayList<Order>();

    public OrdersWriter(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public StringBuffer writeOrder(Order order){
        StringBuffer ordString = new StringBuffer("{\"id\": " + order.getOrderId() + ", \"products\": [");

        for (int j = 0; j < order.getProductsCount(); j++) {
            ordString.append(writerProduct(order.getProduct(j)));
        }

        if (order.getProductsCount() > 0) {
            ordString.delete(ordString.length() - 2, ordString.length());
        }

        ordString.append("]}, ");
        return ordString;
    }

    public StringBuffer writerProduct(Product product){
        StringBuffer prodString = new StringBuffer("{\"code\": \"" + product.getCode() + "\", \"color\": \"" + getColorFor(product) + "\", ");

        if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
            prodString.append("\"size\": \"" + getSizeFor(product) + "\", ");
        }

        prodString.append("\"price\": " + product.getPrice() + ", \"currency\": \"" + product.getCurrency() + "\"}, ");

        return prodString;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.size(); i++) {
            sb.append(writeOrder(orders.get(i)));
        }

        if (orders.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private String getSizeFor(Product product) {
        switch (product.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }

    private String getColorFor(Product product) {
        return product.getColor().toString();
    }
}