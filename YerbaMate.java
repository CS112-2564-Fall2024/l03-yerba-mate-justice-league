public class YerbaMate extends Tea {
    protected int numPasses;

    public YerbaMate() {
        super();
    }

    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);
        this.numPasses = numPasses;
    }

    public YerbaMate(YerbaMate otherYerbaMate) {
        super((Tea) otherYerbaMate);
        this.numPasses = otherYerbaMate.numPasses;
    }

    public int passMate() {
        return numPasses++;
    }

    public int refill(int ounces) {
        this.setOunces(getOunces() + ounces);
        return getOunces();
    }

    public boolean equals(Object other) 
    {
        if (other instanceof YerbaMate) {
            if (super.equals(other)) {
                YerbaMate otherYerbaMate = (YerbaMate) other;
                if (numPasses == otherYerbaMate.numPasses) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String formatString = "Yerba Mate: %s, ounces: %d, brewed @ %d°C, $%.2f, %d passes so far";
        return String.format(formatString, getName(), getOunces(), brewTemp, getPrice(), numPasses);
    }
}
