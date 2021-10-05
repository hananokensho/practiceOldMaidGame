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

    // 同じ数字のカードがあるか判定
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
        // 同じ数字のカードが有るか判定後にallicationFlagがfalseのままだったらカードリストに追加
        if (allocationFlag == false) {
            myCardList.add(deckCard);
        }
    }

    // ペアから引いたカードを受け取り同じ数字のカードがあれば消去
    public void decisionShow(Card selectCard, List<Card> myCardList) {
        // プレイヤーのカードリストに引いたカードを追加
        myCardList.add(selectCard);
        Loop:
        for (int i = 0; i < myCardList.size(); i++) {
            /*for文で同じ数字のカードがないかの判定を行っているが、判定を行うカードがそのカード自身の時の判定(i=0の場合)
            の場合に同じ数字のカードとして成り立ってしまうためif(同じ数字&&違うマーク)で判定を行っています
            */
            if (myCardList.get(myCardList.size() - 1).getNum() == myCardList.get(i).getNum()
            && !(myCardList.get(myCardList.size() - 1).getSuit().equals(myCardList.get(i).getSuit()))) {
                player.show(myCardList);
                // 重複したカードの数字を表示しながら排除処理
                System.out.println("同じ数字のカード(" + myCardList.get(i).getNum() + ")を排除します。");
                myCardList.remove(i);
                myCardList.remove((myCardList.size()-1));
                try {
                    System.out.println("排除中...");
                    Thread.sleep(2000);
                    // 排除後のプレイヤーのカードリストを表示
                    player.show(myCardList);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break Loop;
            }
        }
    }

    // ペアのどのカードを引くかのメソッド
    public void selectCard(List<Card> myCardList, List<Card> pairCardList) {
        int select = 0;
        // プレイヤーのカードを表示
        player.show(myCardList);
        System.out.println("");
        System.out.println("プレイヤーのターン");
        System.out.println("相手のどのカードを引きますか？");
        System.out.println("数字を入力してください");
        // ペアのカードリストの枚数を表示
        for (int i = 0; i < pairCardList.size(); i++) {
            if (i == pairCardList.size() - 1) {
                System.out.print("[" + (i + 1) + "] >");
            } else {
                System.out.print("[" + (i + 1) + "] ");
            }
        }
        // 規格外の入力があった場合の処理
        try {
            select = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("------正しい値を入力してください------");
            // 同じ処理を初めからやり直し
            selectCard(myCardList, pairCardList);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("------正しい値を入力してください------");
            // 同じ処理を初めからやり直し
            selectCard(myCardList, pairCardList);
        }
        if (select > pairCardList.size()) {
            System.out.println("------正しい値を入力してください------");
            // 同じ処理を初めからやり直し
            selectCard(myCardList, pairCardList);
        }
        // 引いたカードをプレイヤーのカードリストに入れて判定へ渡す
        decisionShow(pairCardList.get(select - 1), myCardList);
        // プレイヤーに引かれたペアのカードを消去
        pairCardList.remove(select - 1);
    }
    // プレイヤーorペアのどちらかが0枚になった時の勝ち負け判定
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