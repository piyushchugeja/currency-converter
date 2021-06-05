import currencies.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

public class currencyConverter extends Applet implements ActionListener {
    Choice cFrom, cTo;
    TextField input;
    Label answer, from, to, none, addressInput;
    Button convert, switchCountry;
    Font font, label, buttons;
    Image loading, logo;
    double amount;
    INR i=new INR();
    USD u=new USD();
    EUR e=new EUR();
    KYD k=new KYD();
    KWD d=new KWD();
    JPY j=new JPY();
    GBP g=new GBP();
    Exception NullValueException, InvalidCastException;

    public void setCountriesInFrom()
    {
        cFrom=new Choice();
        cFrom.add("₹ INR");
        cFrom.add("$ USD");
        cFrom.add("€ EUR");
        cFrom.add("¥ JPY");
        cFrom.add("$ KYD");
        cFrom.add("د.ك KWD");
        cFrom.add("£ GBP");
    }

    public void setCountriesInTo()
    {
        cTo=new Choice();
        cTo.add("₹ INR");
        cTo.add("$ USD");
        cTo.add("€ EUR");
        cTo.add("¥ JPY");
        cTo.add("$ KYD");
        cTo.add("د.ك KWD");
        cTo.add("£ GBP");
    }

    public void init() {
        this.setSize(598, 400);
        font = new Font("Arial", Font.PLAIN, 20);
        label = new Font("Arial", Font.PLAIN, 18);
        buttons = new Font("Arial", Font.ITALIC, 14);
        this.setBackground(Color.decode("0xF5F5DC"));
        this.setForeground(Color.decode("0x00080"));

        //Setting up labels
        from = new Label("Select first country");
        from.setBackground(Color.decode("0xF5F5DC"));
        from.setForeground(Color.decode("0x00000"));
        from.setFont(label);
        add(from);

        to = new Label("Select second country");
        to.setBackground(Color.decode("0xF5F5DC"));
        to.setForeground(Color.decode("0x00000"));
        to.setFont(label);
        add(to);

        answer = new Label("Your answer will be displayed here.");
        answer.setBackground(Color.decode("0xF5F5DC"));
        answer.setForeground(Color.decode("0x00000"));
        answer.setFont(label);
        add(answer);

        addressInput = new Label("Enter amount here.");
        addressInput.setBackground(Color.decode("0xF5F5DC"));
        addressInput.setForeground(Color.decode("0x00000"));
        addressInput.setFont(label);
        add(addressInput);

        none = new Label("");
        none.setBackground(Color.decode("0xdda0dd"));
        add(none);

        //Setting up buttons
        convert = new Button("Convert currencies");
        convert.setBackground(Color.decode("0xfff0f5"));
        convert.setForeground(Color.BLACK);
        convert.setFont(buttons);
        convert.addActionListener(this);
        add(convert);

        switchCountry = new Button("Switch selections");
        switchCountry.setBackground(Color.decode("0xfff0f5"));
        switchCountry.setForeground(Color.BLACK);
        switchCountry.setFont(buttons);
        switchCountry.addActionListener(this);
        add(switchCountry);

        //Setting up drop downs
        this.setCountriesInFrom();
        cFrom.setFont(label);
        add(cFrom);

        this.setCountriesInTo();
        cTo.setFont(label);
        add(cTo);

        //Setting up input field
        input = new TextField(15);
        input.setFont(label);
        add(input);

        //Setting up images and gifs
        try {
            logo = ImageIO.read(getClass().getResource("main-icon.png"));
            loading = ImageIO.read(getClass().getResource("loading.gif"));
            // loading = getImage(this.getDocumentBase(), "loading.gif");
        } catch (Exception e) {}

        //Initialising exceptions
        NullValueException = new Exception("Insert a value first");
        InvalidCastException = new Exception("Trying to convert from String to double");
    }

    public void paint(Graphics g)
    {
        this.setLayout(new BorderLayout());
        g.setFont(font);
        g.drawImage(logo, 185, 5, this);
        g.drawString("Currency Converter.", 254, 42);
        none.setBounds(0, 72, 599, 22);
        from.setBounds(29, 115, 154, 23);
        to.setBounds(29, 186, 178, 23);
        convert.setBounds(45, 295, 150, 53);
        switchCountry.setBounds(226, 295, 150, 53);
        cFrom.setBounds(226, 115, 105, 35);
        cTo.setBounds(226, 186, 105, 35);
        answer.setBounds(29, 245, 600, 25);
        input.setBounds(424, 186, 100, 30);
        addressInput.setBounds(395, 150, 150, 25);
    }

    public void setAmount()
    {
        try {
            amount = Double.parseDouble(input.getText());
        } catch (Exception ex) {
            answer.setText(InvalidCastException.toString());
        }
    }

    public void load(Graphics g)
    {
        this.setLayout(null);
        try {
            g.drawImage(loading, 400, 250, 128, 128, this);
            Thread.sleep(2500);
            g.setColor(Color.decode("0xf5f5dc"));
            g.fill3DRect(400,240, 500, 300, true);
        }
        catch(InterruptedException e){}
    }

    public void actionPerformed(ActionEvent a) {
        this.setAmount();
        if (a.getSource() == convert) {
            this.load(getGraphics());
            if (cFrom.getSelectedIndex() == cTo.getSelectedIndex()) {
                answer.setText("The value you're looking for lies in the question.");
            }

            else if (amount <= 0) {
                answer.setText(NullValueException.toString());
            }

            else if (cFrom.getSelectedIndex() == 0) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 1:
                        answer.setText(amount + " INR is equal to " + i.INRToUSD(amount) + " USD");
                        break;

                    case 2:
                        answer.setText(amount + " INR is equal to " + i.INRToEUR(amount) + " EUR");
                        break;

                    case 3:
                        answer.setText(amount + " INR is equal to " + i.INRToJPY(amount) + " JPY");
                        break;

                    case 4:
                        answer.setText(amount + " INR is equal to " + i.INRToKYD(amount) + " KYD");
                        break;

                    case 5:
                        answer.setText(amount + " INR is equal to " + i.INRToKWD(amount) + " KWD");
                        break;

                    case 6:
                        answer.setText(amount + " INR is equal to " + i.INRToGBP(amount) + " GBP");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }

            else if (cFrom.getSelectedIndex() == 1) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 0:
                        answer.setText(amount + " USD is equal to " + u.USDToINR(amount) + " INR");
                        break;

                    case 2:
                        answer.setText(amount + " USD is equal to " + u.USDToEUR(amount) + " EUR");
                        break;

                    case 3:
                        answer.setText(amount + " USD is equal to " + u.USDToJPY(amount) + " JPY");
                        break;

                    case 4:
                        answer.setText(amount + " USD is equal to " + u.USDToKYD(amount) + " KYD");
                        break;

                    case 5:
                        answer.setText(amount + " USD is equal to " + u.USDToKWD(amount) + " KWD");
                        break;

                    case 6:
                        answer.setText(amount + " USD is equal to " + u.USDToGBP(amount) + " GBP");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }

            else if (cFrom.getSelectedIndex() == 2) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 0:
                        answer.setText(amount + " EUR is equal to " + e.EURToINR(amount) + " INR");
                        break;

                    case 1:
                        answer.setText(amount + " EUR is equal to " + e.EURToUSD(amount) + " USD");
                        break;

                    case 3:
                        answer.setText(amount + " EUR is equal to " + e.EURToJPY(amount) + " JPY");
                        break;

                    case 4:
                        answer.setText(amount + " EUR is equal to " + e.EURToKYD(amount) + " KYD");
                        break;

                    case 5:
                        answer.setText(amount + " EUR is equal to " + e.EURToKWD(amount) + " KWD");
                        break;

                    case 6:
                        answer.setText(amount + " EUR is equal to " + e.EURToGBP(amount) + " GBP");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }
        
            else if (cFrom.getSelectedIndex() == 3) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 0:
                        answer.setText(amount + " JPY is equal to " + j.JPYToINR(amount) + " INR");
                        break;

                    case 1:
                        answer.setText(amount + " JPY is equal to " + j.JPYToUSD(amount) + " USD");
                        break;

                    case 2:
                        answer.setText(amount + " JPY is equal to " + j.JPYToEUR(amount) + " EUR");
                        break;

                    case 4:
                        answer.setText(amount + " JPY is equal to " + j.JPYToKYD(amount) + " KYD");
                        break;

                    case 5:
                        answer.setText(amount + " JPY is equal to " + j.JPYToKWD(amount) + " KWD");
                        break;

                    case 6:
                        answer.setText(amount + " JPY is equal to " + j.JPYToGBP(amount) + " GBP");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }

            else if (cFrom.getSelectedIndex() == 4) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 0:
                        answer.setText(amount + " KYD is equal to " + k.KYDToINR(amount) + " INR");
                        break;

                    case 1:
                        answer.setText(amount + " KYD is equal to " + k.KYDToUSD(amount) + " USD");
                        break;

                    case 2:
                        answer.setText(amount + " KYD is equal to " + k.KYDToEUR(amount) + " EUR");
                        break;

                    case 3:
                        answer.setText(amount + " KYD is equal to " + k.KYDToJPY(amount) + " JPY");
                        break;

                    case 5:
                        answer.setText(amount + " KYD is equal to " + k.KYDToKWD(amount) + " KWD");
                        break;

                    case 6:
                        answer.setText(amount + " KYD is equal to " + k.KYDToGBP(amount) + " GBP");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }

            else if (cFrom.getSelectedIndex() == 5) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 0:
                        answer.setText(amount + " KWD is equal to " + d.KWDToINR(amount) + " INR");
                        break;

                    case 1:
                        answer.setText(amount + " KWD is equal to " + d.KWDToUSD(amount) + " USD");
                        break;

                    case 2:
                        answer.setText(amount + " KWD is equal to " + d.KWDToEUR(amount) + " EUR");
                        break;

                    case 3:
                        answer.setText(amount + " KWD is equal to " + d.KWDToJPY(amount) + " JPY");
                        break;

                    case 4:
                        answer.setText(amount + " KWD is equal to " + d.KWDToKYD(amount) + " KYD");
                        break;

                    case 6:
                        answer.setText(amount + " KWD is equal to " + d.KWDToGBP(amount) + " GBP");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }

            else if (cFrom.getSelectedIndex() == 6) {
                int convertTo = cTo.getSelectedIndex();
                switch (convertTo) {
                    case 0:
                        answer.setText(amount + " GBP is equal to " + g.GBPToINR(amount) + " INR");
                        break;

                    case 1:
                        answer.setText(amount + " GBP is equal to " + g.GBPToUSD(amount) + " USD");
                        break;

                    case 2:
                        answer.setText(amount + " GBP is equal to " + g.GBPToEUR(amount) + " EUR");
                        break;

                    case 3:
                        answer.setText(amount + " GBP is equal to " + g.GBPToJPY(amount) + " JPY");
                        break;

                    case 4:
                        answer.setText(amount + " GBP is equal to " + g.GBPToKYD(amount) + " KYD");
                        break;

                    case 5:
                        answer.setText(amount + " GBP is equal to " + g.GBPToKWD(amount) + " KWD");
                        break;

                    default:
                        answer.setText("Internal error has occurred, try again later.");
                }
            }
        }
        else if (a.getSource()==switchCountry) {
            String tempChoice=cFrom.getSelectedItem();
            cFrom.select(cTo.getSelectedItem());
            cTo.select(tempChoice);
        }
    }
}

/*
<html>
<head> </head>
    <body>
        <applet code="currencyConverter.java" height=600 width=400></applet>
    </body>
</html>
*/