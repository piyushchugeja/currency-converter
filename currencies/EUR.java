package currencies;
public class EUR extends converter {
    public EUR () {
        INR=88.7090;
        USD=1.2180;
        EUR=1.0;
        GBP=0.86038;
        KWD=0.36610;
        JPY=132.72;
        KYD=1.0165;
    }
    public double EURToINR (double euros) { return (euros*INR); }

    public double EURToUSD (double euros) { return (euros*USD); }

    public double EURToGBP (double euros) { return (euros*GBP); }

    public double EURToJPY (double euros) { return (euros*JPY); }

    public double EURToKWD (double euros) { return (euros*KWD); }

    public double EURToKYD (double euros) { return (euros*KYD); }
}
