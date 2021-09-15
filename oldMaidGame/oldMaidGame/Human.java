import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Human {
    final Decision decision;

    public Human(Decision decision) {
        this.decision = decision;
    }
    private List <Card> myCardList = new ArrayList<>();

    public List<Card> getMyCardList() {
        return myCardList;
    }

    public void setMyCardList(Card myCardList) {
        this.myCardList.add(myCardList);
    }

    public void draw(List<Card> myCardList , List<Card> pairCardList){
        Random rand = new Random();
        decision.decision(pairCardList.get(rand.nextInt(pairCardList.size())),myCardList);
    }

    public abstract void firstDraw(List<Card> deckCardList , List<Card> myCardList);
}

