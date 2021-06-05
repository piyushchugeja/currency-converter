package currencies;
public class KYD extends converter {
    public KYD() {
        INR=87.2658;
        USD=1.1997;
        EUR=0.98373;
        GBP=0.84638;
        KWD=0.36014;
        JPY=130.56;
        KYD=1.0;
    }
    public double KYDToINR (double dollars) { return (dollars*INR); }

    public double KYDToEUR (double dollars) { return (dollars*EUR); }

    public double KYDToGBP (double dollars) { return (dollars*GBP); }

    public double KYDToJPY (double dollars) { return (dollars*JPY); }

    public double KYDToUSD (double dollars) { return (dollars*USD); }

    public double KYDToKWD (double dollars) { return (dollars*KWD); }
}
