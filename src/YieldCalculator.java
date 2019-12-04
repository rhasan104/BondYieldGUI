import java.text.DecimalFormat;

public class YieldCalculator extends Calculator {

    protected double price;

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double p) {
        this.price = p;
    }

    public String calculate() {
        long startTime = System.currentTimeMillis();
        double c = CalcYield(getCoupon(), getYears(), getFace(), getPrice());

        long duration = System.currentTimeMillis() - startTime;

        DecimalFormat df = new DecimalFormat("#0.0000000");
        return "Yield To Maturity: " + df.format(c) + "\nCalculation Time(ms): " + duration;
    }

    private double CalcYield(double coupon, int years, double face, double price) {

        int MAX_ITERATION = 200;
        double tolerance = 1e-7;
        
        /**
         * initially I had set the lower and upper values to 0 and 1 respectively, because I was being pro-active as any rate less than 0 would not benefit the holder
         * and any rate greater than 100 % is probably not profitable for a company.
         */
        
        double rate_l = Integer.MIN_VALUE;
        double rate_u = Integer.MAX_VALUE;
        double prev_mid_rate = 0;
        double mid_rate = 0;
        double current_price = 0;
        double rel_error = 0;

        for (int i = 0; i < MAX_ITERATION; i++) {
            mid_rate = (rate_l + rate_u) / 2;
            current_price = CalcPrice(coupon, years, face, mid_rate);
            if (current_price < price) rate_u = mid_rate;
            else if(current_price > price) rate_l = mid_rate;
            else if(current_price == price) return mid_rate;

            prev_mid_rate = mid_rate;
            //find new root
            mid_rate = (rate_l + rate_u) / 2;

            rel_error = Math.abs((mid_rate - prev_mid_rate) / mid_rate);

            if(i + 1 == MAX_ITERATION) {
                System.out.println("We could not find any answer.");
                return 0;
            }
            if (rel_error > tolerance) continue;
            else return round(prev_mid_rate);
        }
        return 0;
    }
}
