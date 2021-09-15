import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    List<Card> deckList = new ArrayList<>();
    final Player player;
    final Pair pair;

    //　コンストラクターでフィールドを初期化
    public Deck(Player player, Pair pair) {
        this.player = player;
        this.pair = pair;
    }

    // 山札を生成
    public void cardGeneration() {
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            if(count == 0){
                for (int j = 1; j <= 13; j++) {
                    deckList.add(new Card("ハート",j));
                }
                count++;
            }if(count == 1){
                for (int j = 1; j <= 13; j++) {
                    deckList.add(new Card("ダイヤ",j));
                }
                count++;
            }if(count == 2){
                for (int j = 1; j <= 13; j++) {
                    deckList.add(new Card("スペード",j));
                }
                count++;
            }if(count == 3){
                for (int j = 1; j <= 13; j++) {
                    deckList.add(new Card("クローバー",j));
                }
                count++;
            }

        }
        Collections.shuffle(deckList);
    }

    // カードを配る
    public void jokerDealCard(){
        // playerもしくはpairにジョーカーを配る
        Random random = new Random();
        if(random.nextInt(2) == 0){
            player.setMyCardList(new Card("ジョーカー" , 0));
        }else {
            pair.setMyCardList(new Card("ジョーカー" , 0));
        }
    }
}
