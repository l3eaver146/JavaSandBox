package helpers;

import models.GameDataModel;
import org.openqa.selenium.WebElement;
import pages.elements.GameBlock;
import java.util.ArrayList;
import java.util.List;

public class GameListHelper {
    private GameListHelper() {
    }

    private static ArrayList<GameBlock> getGameBlocks(List<WebElement> elements) {
        ArrayList<GameBlock> gameBlocks = new ArrayList<>();
        for (WebElement element :
                elements) {
            gameBlocks.add(new GameBlock(element));
        }
        return gameBlocks;
    }

    private static ArrayList<GameBlock> removeBlocsWithoutDiscounts(ArrayList<GameBlock> gameBlocks) {
        int index = 0;
        ArrayList<GameBlock> updatedGameBlocs = new ArrayList<>();
        for (GameBlock block :
                gameBlocks) {
            if (block.getDiscount() != null)
                updatedGameBlocs.add(block);
            index++;
        }
        return updatedGameBlocs;
    }

    private static GameBlock sortGameBlocs(ArrayList<GameBlock> gameBlocks) {
        ArrayList<GameBlock> array = gameBlocks;
        boolean sorted = false;
        GameBlock temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.size() - 1; i++) {
                if (Integer.parseInt(array.get(i).getDiscount()) > Integer.parseInt(array.get(i + 1).getDiscount())) {
                    temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return array.get(array.size() - 1);
    }

    public static GameDataModel clickGameBlockWithMaximalDiscount(List<WebElement> elements) {
        GameBlock gameWithDiscount = sortGameBlocs(removeBlocsWithoutDiscounts(getGameBlocks(elements)));
        GameDataModel game = new GameDataModel(
                gameWithDiscount.getPrice(),
                gameWithDiscount.getDiscount(),
                gameWithDiscount.getDiscountFinalPrice(),
                gameWithDiscount.getName()
        );
        gameWithDiscount.getCurrent().click();
        return game;
    }
}
