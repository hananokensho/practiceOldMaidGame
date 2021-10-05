import java.util.List;
import java.util.Random;

public class Player extends Human{

    // スーパークラスのフィールドを初期化
    public Player(Decision decision) {
        super(decision);
    }

    // プレイヤーのカードリストを見るメソッド
    public void show(List<Card> myCardList){
        System.out.println("自分のカードリスト");
        for (int i = 0; i < myCardList.size(); i++) {
            System.out.print("[" + myCardList.get(i).getNum() + ":" + myCardList.get(i).getSuit() + "] ");
        }
        System.out.println("");
    }

    // プレイヤーの最初のカードが山札から配られる
    public void firstDraw(List<Card> deckCardList , List<Card> myCardList) {
        myCardList.add(deckCardList.get(0));
        deckCardList.remove(0);
        for (int i = 0; i < 25; i++) {
            // 同じ数字のカードあるか判定するメソッド
            decision.decision(deckCardList.get(i), myCardList);
            // デッキから引いたカードを消去
            deckCardList.remove(i);
        }
    }
//    public void draw(List<Card> myCardList , List<Card> pairCardList){
//        Random rand = new Random();
//        int number = rand.nextInt(pairCardList.size());
//        decision.decision(pairCardList.get(number),myCardList);
//        pairCardList.remove(number);
//    }
}
