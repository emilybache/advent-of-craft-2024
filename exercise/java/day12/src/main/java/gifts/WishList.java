package gifts;

import java.util.ArrayList;
import java.util.List;

public class WishList {
    private List<Toy> gifts = new ArrayList<>();
    public void fill(Toy... choices) {
        gifts.addAll(List.of(choices));
    }

    public List<Toy> toys() {
        return gifts;
    }

    Toy getFirstChoiceToy() {
        int giftIndex = 0;
        return toys().get(giftIndex);
    }

    Toy getSecondChoiceToy() {
        int giftIndex = 1;
        return toys().get(giftIndex);
    }

    Toy getLastChoiceToy() {
        int giftIndex = toys().size() - 1;
        return toys().get(giftIndex);
    }
}
