import com.maicoin.api.MaiCoin;
import com.maicoin.api.MaiCoinBuilder;
import com.maicoin.api.entity.Checkout;
import com.maicoin.api.entity.CheckoutParamBuilder;
import com.maicoin.api.entity.Order;
import com.maicoin.api.entity.Price;
import com.maicoin.api.entity.Transaction;
import com.maicoin.api.exception.MaiCoinException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by yutelin on 9/25/14.
 */
public class MaiCoinKeySecretExample {

    public static void main(String[] args) {
        String apiKey = "YOUR_API_KEY";
        String apiSecret = "YOUR_API_SECRET";
        String baseUrl = "https://api.maicoin.com/v1/";

        MaiCoin client = null;
        try {
            client = new MaiCoinBuilder().setBaseUrl(new URL(baseUrl)).build();
            System.out.println("Get price");
            System.out.println("client.getPrice() = " + client.getPrice());
            System.out.println("client.getPrice(Price.Currency.USD) = " + client.getPrice(Price.Currency.USD));

            System.out.println("Get currencies");
            System.out.println("client.getCurrencies() = " + client.getCurrencies());

            //Authenticated client
            client = new MaiCoinBuilder().setApiKey(apiKey, apiSecret).setBaseUrl(  new URL(baseUrl)).build();
            System.out.println("Account");
            System.out.println("client.getBalance() = " + client.getBalance());
            System.out.println("client.getUser() = " + client.getUser());
            System.out.println("client.getReceiveAddress() = " + client.getReceiveAddress());
            System.out.println("client.getAddresses() = " + client.getAddresses());
            //System.out.println("client.generateReceiveAddress() = " + client.generateReceiveAddress());
            String pin = "1234";
            //System.out.println("client.createAccountPin(pin) = " + client.createAccountPin(pin));
            String newPin = pin;
            System.out.println("client.updateAccountPin(pin, newPin) = " + client.updateAccountPin(pin, newPin));

            System.out.println("Order");
            System.out.println("client.getOrders() = " + client.getOrders());
            System.out.println("client.getOrders(1, 2) = " + client.getOrders(1, 2));
            Order order = client.getOrders().getOrders().get(0);
            System.out.println("client.getOrder(order.getTxid()) = " + client.getOrder(order.getTxid()));
            //System.out.println("client.buyBtc(0.2) = " + client.buyBtc(0.2));
            //System.out.println("client.sellBtc(0.1) = " + client.sellBtc(0.1));

            System.out.println("Transaction");
            System.out.println("client.getTransactions() = " + client.getTransactions());
            System.out.println("client.getTransactions(1, 2) = " + client.getTransactions(1, 2));
            Transaction txn = client.getTransactions().getTransactions().get(0);
            System.out.println("client.getTransaction(txn.getId()) = " + client.getTransaction(txn.getId()));
            Transaction trans = client.requestTransaction("yute@maicoin.com", 1, "btc", "Test request");
            System.out.println("client.requestTransaction() = " + trans);
            System.out.println("client.cancelRequestTransaction(trans.getId()) = " + client.cancelRequestTransaction(trans.getId()));
            //String txid = "19677a7f25422d72e9e661f83c2d6dacaed007fbf132beea";
            //System.out.println("client.approveRequestTransaction(txid, pin) = " + client.approveRequestTransaction(txid, pin));
            //System.out.println("client.sendTransaction(\"yute@maicoin.com\", 0.01, \"btc\", \"test send\", pin) = " + client.sendTransaction("yute@maicoin.com", 0.01, "btc", "test send", pin));
            //System.out.println("client.sendTransaction(\"1FTv5Ymfq1uT9N9ZrmYRgpKw69U6grnm64\", 0.01, \"btc\", \"test send to address\", pin) = " + client.sendTransaction("1FTv5Ymfq1uT9N9ZrmYRgpKw69U6grnm64", 0.01, "btc", "test send to address", pin));

            System.out.println("Checkout");
            System.out.println("client.getCheckouts(1, 2) = " + client.getCheckouts(1, 2));
            CheckoutParamBuilder builder = new CheckoutParamBuilder();
            builder.setCheckoutData("5", "twd", "http://my.com/return", "http://my.com/cancel",
                    "http://my.com/callback", "ref_id_001", "userid=10, desc=test", "zh-TW");
            builder.setBuyerData("YL", "apt 124", "road 456", "sf", "ca", "94305", "abc@gmail.com", "650444040", "tw");
            builder.addItem("test item1", "1234", "100", "twd", true);
            builder.addItem("test item2", "45", "300", "twd", false);
            Checkout co = client.createCheckout(builder);
            System.out.println("client.createCheckout(builder) = " + co);
            System.out.println("client.getCheckout(co.getUid()) = " + client.getCheckout(co.getUid()));
            System.out.println("Payment URL: "+co.getCheckoutUrl());

        } catch (MaiCoinException e) {
            System.out.println("Exception:"+ e.getMessage());
            System.out.println( e.getCode());
            System.out.println( e.getErrors());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
