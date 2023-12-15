package model;
public class OrderLine {
    int quantity;
    String photoFilePath;

    public OrderLine(int quantity, String photoFilePath) {
        this.quantity = quantity;
        this.photoFilePath = photoFilePath;
    }
}