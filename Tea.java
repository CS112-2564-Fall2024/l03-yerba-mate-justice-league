public class Tea extends CaffeinatedBeverage {
    int brewTemp;

    public Tea() {
        super();
        this.brewTemp = 0;
    }

    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);
        this.brewTemp = brewTemp;

    }

    public Tea(Tea otherTea) {
        super((CaffeinatedBeverage) otherTea);
        this.brewTemp = otherTea.brewTemp;
    }

    public boolean equals(Object other) {
        if (other instanceof Tea) {
            if (super.equals(other)) {
                Tea otherTea = (Tea) other;
                if (brewTemp == otherTea.brewTemp) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String formatString = "Tea: %s, ounces: %d, brewed @ %d°C, $%f.2";
        return String.format(formatString, getName(), getOunces(), brewTemp, getPrice());
    }
}
