package model;

import java.util.*;

public class Order {
    enum status {
        draft,
        confirmed,
        delivered;

    }

    String review;
    Date createdAt, updatedAt, confirmedAt;

    int evaluation, id;

    public Order(int id, String review, Date createdAt, Date updatedAt, Date confirmedAt, int evaluation) {
        this.id = id;
        this.review = review;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.confirmedAt = confirmedAt;
        this.evaluation = evaluation;
        this.orderLines = new HashSet<OrderLine>();
    }

    private DeliveryGuy deliveryGuy;

    public void addDeliveryGuy(DeliveryGuy deliveryGuy) {
        if (!deliveryGuy.getOrders().contains(this)) {
            if (getDeliveryGuy() != null)
                removeDeliveryGuy();
            setDeliveryGuy(deliveryGuy);
            deliveryGuy.addOrder(this);
        }
    }

    public void setDeliveryGuy(DeliveryGuy deliveryGuy) {
        this.deliveryGuy = deliveryGuy;
    }

    public DeliveryGuy getDeliveryGuy() {
        return deliveryGuy;
    }

    public void removeDeliveryGuy() {
        getDeliveryGuy().removeOrder(this);
        setDeliveryGuy(null);
    }

    private Client client;

    public void addClient(Client client) {
        if (!client.getOrders().contains(this)) {
            if (getClient() != null)
                removeClient();
            setClient(client);
            client.addOrder(this);
        }
    }

    public void removeClient() {
        getClient().removeOrder(this);
        setClient(null);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private Adress deliveryAdress;
    private Adress billingAdress;

    public void setDeliveryAdress(Adress deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public Adress getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setBillingAdress(Adress billingAdress) {
        this.billingAdress = billingAdress;
    }

    public Adress getBillingAdress() {
        return billingAdress;
    }

    private Set<OrderLine> orderLines;

    public void addOrderLine(OrderLine orderLine) {
        if (!getOrderLines().contains(orderLine)) {
            getOrderLines().add(orderLine);
        }
    }

    public void removeOrderLine(OrderLine orderLine) {
        if (getOrderLines().contains(orderLine)) {
            getOrderLines().remove(orderLine);
        }
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    // getters
    public int getId() {
        return this.id;
    }
}
