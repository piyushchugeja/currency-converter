package currencies;
public class USD extends converter {
    public USD () {
        INR=72.8317;
        USD=1.0;
        EUR=0.82102;
        GBP=0.70659;
        KWD=0.30057;
        JPY=108.97;
        KYD=0.83355;
        //String rates="All rates were collected on 23-05-2021 from https://www.exchange-rates.org/";
    }

    public double USDToINR (double dollars) {
        return (dollars*INR);
    }

    public double USDToEUR (double dollars) {
        return (dollars*EUR);
    }

    public double USDToGBP (double dollars) {
        return (dollars*GBP);
    }

    public double USDToJPY (double dollars) {
        return (dollars*JPY);
    }

    public double USDToKWD (double dollars) {
        return (dollars*KWD);
    }

    public double USDToKYD (double dollars) {
        return (dollars*KYD);
    }
}