import java.util.*;

public class Decision {

    private Player player;
    private Pair pair;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Pair getPair() {
        return pair;
    }

    public void setPair(Pair pair) {
        this.pair = pair;
    }

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

    public void winOrLossDecision() {
        while (true) {
            player.draw(player.getMyCardList(), pair.getMyCardList());
            if (pair.getMyCardList().size() == 0) {
                System.out.println("おめでとうございます！");
                System.out.println("あなたの勝ちです！！！");
                break;
            }else if (player.getMyCardList().size() == 0) {
                System.out.println("相手の勝ちです");
                break;
            }
            pair.draw(pair.getMyCardList(), player.getMyCardList());
            if (player.getMyCardList().size() == 0) {
                System.out.println("相手の勝ちです");
                break;
            }else if (pair.getMyCardList().size() == 0) {
                System.out.println("おめでとうございます！");
                System.out.println("あなたの勝ちです！！！");
                break;
            }
        }
    }
}