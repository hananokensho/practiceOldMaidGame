public class Card {
    private String suit;
    private int num;


    public Card(String suit , int num){
        this.suit = suit;
        this.num = num;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String simbol) {
        this.suit = simbol;
    }

    public Card(int num){
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
