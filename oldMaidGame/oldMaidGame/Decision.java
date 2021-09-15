import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Decision {

    public void decision(Card deckCard, List<Card> myCardList) {
        boolean allocationFlag = false;
        Loop_i:
        for (int i = 0; i < myCardList.size(); i++) {
            if (deckCard.getNum() == myCardList.get(i).getNum()) {
                myCardList.remove(i);
                allocationFlag = true;
                break Loop_i;
            }
        }
        if (allocationFlag == false) {
            myCardList.add(deckCard);
        }
    }
}
