import java.util.List;
import java.util.Random;

public class Pair extends Human{

    // スーパークラスのフィールドを初期化
    public Pair(Decision decision) {
        super(decision);
    }

    // ペアのカードリストを見るメソッド
    public void show(){
        System.out.println("pairのカードリスト");
        for(int i = 0 ; i < getMyCardList().size(); i++){
            System.out.print((i + 1) + "枚目:" );
            System.out.println(getMyCardList().get(i).getNum() + " : " + getMyCardList().get(i).getSuit());
        }
    }
    // ペアの最初のカードが山札から配られる
    public void firstDraw(List<Card> deckCardList , List<Card> myCardList){
        myCardList.add(deckCardList.get(0));
        deckCardList.remove(0);
        for(int i = deckCardList.size() - 1 ; i >= 0; i-- ){
            decision.decision(deckCardList.get(i) , myCardList);
            deckCardList.remove(i);
        }
    }

    // ペアのドローはプレイヤーからランダムでドローする
    public void draw(List<Card> myCardList , List<Card> pairCardList){
        System.out.println("相手のターン");
        Random rand = new Random();
        int number = rand.nextInt(pairCardList.size());
        decision.decision(pairCardList.get(number),myCardList);
        pairCardList.remove(number);
    }
}