package Order;

import Color.Color;

public class Product {
    private String code;
    private Color color;
    private SizeProduct size;
    private double price;
    private String currency;

    public Product(String code, Color color, SizeProduct size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Color getColor() {
        return color;
    }

    public SizeProduct getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public StringBuffer writerProduct(){
        StringBuffer prodString = new StringBuffer("{\"code\": \"" + getCode() + "\", \"color\": \"" + getColor() + "\", ");

        if (getSize() != null) {
            prodString.append("\"size\": \"" + getSize() + "\", ");
        }

        prodString.append("\"price\": " + getPrice() + ", \"currency\": \"" + getCurrency() + "\"}, ");

        return prodString;
    }
}