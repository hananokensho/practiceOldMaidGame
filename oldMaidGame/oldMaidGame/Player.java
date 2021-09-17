import java.util.List;
import java.util.Random;

public class Player extends Human{

    public void show(){
        System.out.println("playerのカードリスト");
        for(int i = 0 ; i < getMyCardList().size(); i++){
            System.out.print((i + 1) + "枚目:" );
            System.out.println(getMyCardList().get(i).getNum() + " : " + getMyCardList().get(i).getSimbol());
        }
    }

    public Player(Decision decision) {
        super(decision);
    }

    public void firstDraw(List<Card> deckCardList , List<Card> myCardList) {
        myCardList.add(deckCardList.get(0));
        deckCardList.remove(0);
        for (int i = 0; i < 25; i++) {
            decision.decision(deckCardList.get(i), myCardList);
            deckCardList.remove(i);
        }
    }

    public void draw(List<Card> myCardList , List<Card> pairCardList){
        Random rand = new Random();
        int number = rand.nextInt(pairCardList.size());
        decision.decision(pairCardList.get(number),myCardList);
        pairCardList.remove(number);
    }
}
