package main.inlineTemp;

public class Price {

    private int _quantity;
    private int _itemPrice;

    double getPrice() {
        return basePrice() * discountFactor();
    }

    private double discountFactor() {
        double discountFactor;
        if (basePrice() > 1000)
            discountFactor = 0.95;
        else
            discountFactor = 0.98;
        return discountFactor;
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }

    double price() {
        final double basePrice = _quantity * _itemPrice;
        final double quantityDiscount = Math.max(0, _quantity - 500) * _itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - quantityDiscount + shipping;
    }

}
