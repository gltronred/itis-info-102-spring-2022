
import java.util.*;
import java.util.stream.*;

// Транзакция
class Transaction {
    // От кого
    String from;
    // Кому
    String to;
    // Сколько
    int amount;
    // В какой валюте
    String currency;

    public Transaction(String from, String to, int amount, String currency) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.currency = currency;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public int getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

public class TestTest {
    // Использовать java.util.stream.* существенным образом
    //
    // 1. Получить сумму всех транзакций в USD
    public static int task1(List<Transaction> txns) {
        return 0;
    }
    // 2. Вернуть всех получателей транзакций
    public static Set<String> task2(List<Transaction> txns) {
        return null;
    }
    // 3. Считая, что вначале баланс у всех равен 0, подсчитать,
    // какой будет баланс после прохождения всех транзакций
    //                аккаунт     валюта   сумма
    //                   |          |        |
    //                   v          v        v
    public static Map<String, Map<String, Integer>> task3(List<Transaction> txns) {
        return null;
    }
    public static void main(String[] args) {
        // Тестовый пример
        List<Transaction> txns = new LinkedList<>();
        txns.add(new Transaction("Alice","Bob",50,"USD"));
        txns.add(new Transaction("Bob","Charlie",50,"RUB"));
        txns.add(new Transaction("Charlie","Alice",20,"USD"));
        txns.add(new Transaction("Bob","Alice",20,"RUB"));
        System.out.println(task1(txns)); // 70
        System.out.println(task2(txns)); // {Alice, Bob, Charlie}
        System.out.println(task3(txns)); // {Alice={USD=-30, RUB=20}, Bob={USD=50, RUB=-70}, Charlie={USD=-20, RUB=50}}
    }
}
