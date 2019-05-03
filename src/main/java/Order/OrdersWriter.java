package Order;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
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


    public String writerProduct(Product product){
        String prodString = ("{\"code\": \"" + product.getCode() + "\", \"color\": \"" + getColorFor(product) + "\", ");

        if (product.getSize() != Product.SIZE_NOT_APPLICABLE) {
            prodString += ("\"size\": \"" + getSizeFor(product) + "\", ");
        }

        prodString += ("\"price\": " + product.getPrice() + ", \"currency\": \"" + product.getCurrency() + "\"}, ");

        return prodString;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append(writeOrder(order));
        }

        if (orders.getOrdersCount() > 0) {
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
        switch (product.getColor()) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
    }
}