import java.io.Serializable;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String CLIENT_STRING = "C";

    private String id;
    private float balance;

    public Client() {
        this.id = CLIENT_STRING + (ClientIdServer.instance()).getId();
        this. balance = 0;
    }

    public String getId() {
        return id;
    }

    public float getBalance() {
        return balance;
    }

    public void updateBalance(float balance) {
        this.balance += balance;
    }

    @Override
    public String toString() {
        return "id " + id + " balance " + balance;
    }
}
