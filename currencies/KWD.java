package currencies;
public class KWD extends converter {
    public KWD() {
        INR=242.31;
        USD=3.3270;
        EUR=2.7315;
        GBP=2.3501;
        KWD=1.0;
        JPY=362.53;
        KYD=2.7767;
    }

    public double KWDToINR (double dinar) { return (dinar*INR); }

    public double KWDToEUR (double dinar) { return (dinar*EUR); }

    public double KWDToGBP (double dinar) { return (dinar*GBP); }

    public double KWDToJPY (double dinar) { return (dinar*JPY); }

    public double KWDToUSD (double dinar) { return (dinar*USD); }

    public double KWDToKYD (double dinar) { return (dinar*KYD); }
}
