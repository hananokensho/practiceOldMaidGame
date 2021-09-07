import java.util.ArrayList;
import java.util.List;

public abstract class Human {
    private List <Card> myCardList = new ArrayList<>();

    public List<Card> getMyCardList() {
        return myCardList;
    }

    public void setMyCardList(Card myCardList) {
        this.myCardList.add(myCardList);
    }

    public boolean equals(Object o ){
        if(o == this)return true;
        if(o == null)return false;
        if(!(o instanceof Human))return false;
        Human h = (Human) o;
        if(!this.myCardList.equals(h.myCardList)){
            return false;
        }
        return true;
    }
}

