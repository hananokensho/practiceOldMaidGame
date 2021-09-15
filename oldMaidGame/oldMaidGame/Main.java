import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 判定クラス
        Decision decision = new Decision();
        Player player = new Player(decision);
        Pair pair = new Pair(decision);
        // Deckのフィールドにplayerとpairを初期化
        Deck deck = new Deck(player,pair);
        // 山札生成
        deck.cardGeneration();
        //jokerをどちらかに配る
        deck.jokerDealCard();
        // playerとpairにカードを配る
        player.firstDraw(deck.deckList, player.getMyCardList());
        System.out.println(deck.deckList.size());
        pair.firstDraw(deck.deckList , pair.getMyCardList());
        System.out.println(deck.deckList.size());

        System.out.println(player.getMyCardList());
        System.out.println(pair.getMyCardList());
//      プレイヤーのカードを見る
        player.show();
        pair.show();
        //相手のカードをドロー
//        boolean repeatFlag = false;
//        while(!repeatFlag) {
//            player.draw(player.getMyCardList(), pair.getMyCardList());
//            pair.draw(pair.getMyCardList(), player.getMyCardList());
//            if(player.getMyCardList().size() == 0 || pair.getMyCardList().size() == 0)
//                repeatFlag = true;
//        }
//
//        player.show();
//        pair.show();

    }
}

// 参考
// https://waterlow2013.hatenablog.com/entry/2014/01/20/001138
