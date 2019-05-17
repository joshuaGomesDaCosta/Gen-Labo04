package Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersWriter {
    private List<Order> orders = new ArrayList<Order>();

    public OrdersWriter(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");

        for (int i = 0; i < orders.size(); i++) {
            sb.append(orders.get(i).toStringBuffer());
        }

        if (orders.size() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }
}