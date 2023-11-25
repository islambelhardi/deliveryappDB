import java.util.Date;

public class Order {
    enum status {
        draft,
        confirmed,
        delivered
    }

    String review;
    Date createdAt, updatedAt, confirmedAt;

    int evaluation;

    public Order(String review, Date createdAt, Date updatedAt, Date confirmedAt, int evaluation) {
        this.review = review;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.confirmedAt = confirmedAt;
        this.evaluation = evaluation;
    }
}
