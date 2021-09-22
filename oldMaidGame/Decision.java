import java.util.*;

public class Decision {

    private Player player;
    private Pair pair;
    Scanner sc = new Scanner(System.in);

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

    // カードリストに一旦引いたカードをいれてリストの後ろからfor文で回して判定する
    // ここから！！！！！！！！！！！！！！！！！！！！！！
    // 引いたカードを見せるために新しいdecisionを作った
    public void decisionShow(Card selectCard, List<Card> myCardList) {
        myCardList.add(selectCard);
        Loop:
        for (int i = 0; i < myCardList.size(); i++) {
            if (myCardList.get(myCardList.size() - 1).getNum() == myCardList.get(i).getNum()
            && !(myCardList.get(myCardList.size() - 1).getSimbol().equals(myCardList.get(i).getSimbol()))) {
                player.show(myCardList);
                System.out.println("同じ数字のカード(" + myCardList.get(i).getNum() + ")を排除します。");
                myCardList.remove(i);
                myCardList.remove((myCardList.size()-1));
                try {
                    System.out.println("排除中...");
                    Thread.sleep(2000);
                    player.show(myCardList);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break Loop;
            }
        }
    }

    public void selectCard(List<Card> myCardList, List<Card> pairCardList) {
        int select = 0;
        player.show(myCardList);
//        System.out.println("自分のカードリスト");
//        for (int i = 0; i < myCardList.size(); i++) {
//            System.out.print("[" + myCardList.get(i).getNum() + ":" + myCardList.get(i).getSimbol() + "] ");
//        }
        System.out.println("");
        System.out.println("プレイヤーのターン");
        System.out.println("相手のどのカードを引きますか？");
        System.out.println("数字を入力してください");
        for (int i = 0; i < pairCardList.size(); i++) {
            if (i == pairCardList.size() - 1) {
                System.out.print("[" + (i + 1) + "] >");
            } else {
                System.out.print("[" + (i + 1) + "] ");
            }
        }
        try {
            select = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("------正しい値を入力してください------");
            selectCard(myCardList, pairCardList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("------正しい値を入力してください------");
            selectCard(myCardList, pairCardList);
        }
        if (select > pairCardList.size()) {
            System.out.println("------正しい値を入力してください------");
            selectCard(myCardList, pairCardList);
        }
        decisionShow(pairCardList.get(select - 1), myCardList);
        pairCardList.remove(select - 1);
    }

    public void winOrLossDecision() {
        while (true) {
            selectCard(player.getMyCardList(), pair.getMyCardList());
            if (player.getMyCardList().size() == 0) {
                System.out.println("おめでとうございます！");
                System.out.println("あなたの勝ちです！！！");
                break;
            } else if (pair.getMyCardList().size() == 0) {
                System.out.println("相手の勝ちです");
                break;
            }
            pair.draw(pair.getMyCardList(), player.getMyCardList());
            if (player.getMyCardList().size() == 0) {
                System.out.println("おめでとうございます！");
                System.out.println("プレイヤーの勝ちです");
                break;
            } else if (pair.getMyCardList().size() == 0) {
                System.out.println("相手の勝ちです！");
                break;
            }
        }
    }
}