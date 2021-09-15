public class Hint {
}

//　ヒント！！！！
//
//import java.util.ArrayList;
//        import java.util.List;
//
//public class DistinctCard {
//
//    enum Suit{
//        SPADE, CLUB, DIA, HEART, JOKER
//    }
//    record Card(int number, Suit suit){}
//
//    public static void main(String[] args){
//        List<Card> cards = new ArrayList<>(List.of(
//                new Card(3, Suit.SPADE),
//                new Card(5, Suit.DIA),
//                new Card(3, Suit.CLUB),
//                new Card(3, Suit.HEART),
//                new Card(3, Suit.DIA)));
//
//        cards.sort((c1, c2) -> c1.number - c2.number);
//
//        for (int i = 0; i < cards.size(); ++i) {
//            if (i + 1 < cards.size() &&
//                    cards.get(i).number == cards.get(i + 1).number) {
//                cards.remove(i);
//                cards.remove(i);
//                --i;
//            }
//        }
//        System.out.println(cards);
//    }
//}
