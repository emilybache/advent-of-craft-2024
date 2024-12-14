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
}
