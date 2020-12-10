package models;

public class GameDataModel {
    private final String price;
    private final String discount;
    private final String finalPrice;
    private final String name;

    public GameDataModel(String price, String discount, String finalPrice, String name) {
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        GameDataModel game = (GameDataModel) obj;
        return price.equals(game.price) && discount.equals(game.discount)
                && finalPrice.equals(game.finalPrice) && name.equals(game.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((discount == null) ? 0 : discount.hashCode());
        result = prime * result + ((finalPrice == null) ? 0 : finalPrice.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}
