package Order;

public enum SizeProduct {
    XS("XS"), S("S"), M("M"), L("L"), XL("XL"), XXL("XXL");

    private String name;

    private SizeProduct(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
