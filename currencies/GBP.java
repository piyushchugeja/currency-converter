package currencies;
public class GBP extends converter {
    public GBP () {
        INR=103.10;
        USD=1.4152;
        EUR=1.1623;
        GBP=1.0;
        KWD=0.42551;
        JPY=154.26;
        KYD=1.1815;
    }
    public double GBPToINR (double pounds) { return (pounds*INR); }

    public double GBPToUSD (double pounds) { return (pounds*USD); }

    public double GBPToEUR (double pounds) { return (pounds*EUR); }

    public double GBPToJPY (double pounds) { return (pounds*JPY); }

    public double GBPToKWD (double pounds) { return (pounds*KWD); }

    public double GBPToKYD (double pounds) { return (pounds*KYD); }
}

