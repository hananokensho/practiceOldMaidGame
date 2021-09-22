import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 判定クラス
        Decision decision = new Decision();
        Player player = new Player(decision);
        Pair pair = new Pair(decision);
        decision.setPair(pair);
        decision.setPlayer(player);
        // Deckのフィールドにplayerとpairを初期化
        Deck deck = new Deck(player,pair);
        // 山札生成
        deck.cardGeneration();
        //jokerをどちらかに配る
        deck.jokerDealCard();
        // playerとpairにカードを配る
        player.firstDraw(deck.deckList, player.getMyCardList());
        pair.firstDraw(deck.deckList , pair.getMyCardList());
        // プレイヤーのカードを見る
//        player.show();
//        pair.show();
        //勝敗がつくまで相手のカードをドロー
        decision.winOrLossDecision();
    }
}
