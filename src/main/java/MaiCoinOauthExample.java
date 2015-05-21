import com.maicoin.api.MaiCoin;
import com.maicoin.api.MaiCoinBuilder;
import com.maicoin.api.entity.Order;
import com.maicoin.api.entity.Transaction;
import com.maicoin.api.exception.MaiCoinException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yutelin on 1/8/15.
 */
public class MaiCoinOauthExample {
    public static void main(String[] args) {
        String accessToken = "YOUR_ACCESS_TOKEN";
        String baseUrl = "https://api.maicoin.com/v1/";

        MaiCoin client = null;
        try {
            client = new MaiCoinBuilder().setAccessToken(accessToken).setBaseUrl(new URL(baseUrl)).build();
            System.out.println("Account");
            System.out.println("client.getBalance() = " + client.getBalance());
            System.out.println("client.getUser() = " + client.getUser());
            System.out.println("client.getReceiveAddress() = " + client.getReceiveAddress());
            System.out.println("client.getAddresses() = " + client.getAddresses());
            //System.out.println("client.generateReceiveAddress() = " + client.generateReceiveAddress());
            String pin = "1234";
            //System.out.println("client.createAccountPin(pin) = " + client.createAccountPin(pin));
            String newPin = pin;
            //System.out.println("client.updateAccountPin(pin, newPin) = " + client.updateAccountPin(pin, newPin));

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

        } catch (MaiCoinException e) {
            System.out.println("Exception:" + e.getMessage());
            System.out.println(e.getCode());
            System.out.println(e.getErrors());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
