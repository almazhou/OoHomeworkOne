public class TaxiMeter {

    public static final double PRICE_PER_MIN = 0.25;
    public static final int EXTRA_DISTANCE = 8;
    public static final double PRICE_PER_MILE = 0.8;
    public static final double EXTRA_RATE = 0.5;
    public static final int FLAGEDISTANCE = 2;
    public static final double FLAG_PRICE = 6.0;

    public double calculatePrice(double distance, int stoppingTime) {

        double totalFee = FLAG_PRICE + stoppingTimeFee(stoppingTime);

        if (distance > FLAGEDISTANCE) {

            totalFee += (distance - FLAGEDISTANCE) * PRICE_PER_MILE;
        }
        if (distance > EXTRA_DISTANCE) {

            totalFee += extraFee(distance);
        }
        return round(totalFee);
    }

    private double extraFee(double distance) {

        return (distance - EXTRA_DISTANCE) * PRICE_PER_MILE * EXTRA_RATE;
    }

    private double stoppingTimeFee(int stoppingTime) {

        return stoppingTime * PRICE_PER_MIN;
    }

    public double round(double numberToRound) {
        String numberInString = String.valueOf(numberToRound);

        String[] split = numberInString.split("\\.");

        String decimalStr = "0." + split[1];

        if (Double.parseDouble(decimalStr) > 0.5) {

            return Double.parseDouble(split[0]) + 1;
        }
        return Double.parseDouble(split[0]);
    }
}
