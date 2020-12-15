package models;

import io.cucumber.messages.internal.com.google.protobuf.DoubleValue;
import lombok.Getter;

@Getter
public class Game {
    public Game(String price, String discount, String finalPrice, String name) {
        this.discount = Double.parseDouble(discount.replace("%", "").replace("-", ""));
        this.finalPrice = Double.parseDouble(finalPrice.replace("$", ""));
        this.name = name;
        this.price = Double.parseDouble(price.replace("$", ""));
    }

    private double price;
    private double discount;
    private double finalPrice;
    private String name;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Game game = (Game) obj;
        return price == game.price && discount == game.discount
                && finalPrice == game.finalPrice && name.equals(game.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((price == 0) ? 0 : DoubleValue.of(price).hashCode());
        result = prime * result + ((discount == 0) ? 0 : DoubleValue.of(discount).hashCode());
        result = prime * result + ((finalPrice == 0) ? 0 : DoubleValue.of(finalPrice).hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
