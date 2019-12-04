import java.text.DecimalFormat;

public class PriceCalculator extends Calculator {

    protected double rate;

    public double getRate() {
        return this.rate;
    }

    public void setRate(double r) {
        this.rate = r;
    }

//    @Override
//    public void collectData() {
//
//    }

    public String calculate() {
        long startTime = System.currentTimeMillis();
        double c = CalcPrice(getCoupon(), getYears(), getFace(), getRate());

        long duration = System.currentTimeMillis() - startTime;

        DecimalFormat df = new DecimalFormat("#0.0000000");
        return "Current Price : " + df.format(c) + "\nCalculation Time(ms): " + duration;
    }

}
