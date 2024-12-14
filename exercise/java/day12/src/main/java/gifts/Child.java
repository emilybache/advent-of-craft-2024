package gifts;

import java.util.List;

public class Child {

    private final ChildName childName;
    private final ChildBehaviour childBehaviour;
    private final WishList childWishList;
    private List<Toy> wishlist;

    private Child(String name, String behavior) {
        this.childName = new ChildName(name);
        this.childBehaviour = ChildBehaviour.valueOf(behavior.toUpperCase().replace(" ", "_"));
        this.childWishList = new WishList();
    }

    public static Child createChild(String name, String behavior) {
        return new Child(name, behavior);
    }

    Toy chooseToyFor() {
        switch (childBehaviour) {
            case NAUGHTY -> {
                int giftIndex = this.wishlist.size() - 1;
                return this.wishlist.get(giftIndex);
            }
            case NICE -> {
                int giftIndex = 1;
                return this.wishlist.get(giftIndex);
            }
            case VERY_NICE -> {
                int giftIndex = 0;
                return this.wishlist.get(giftIndex);
            }
            case null, default -> {
                return null;
            }
        }
    }

    boolean matches(String childName) {
        return this.childName.matchesName(childName);
    }

    public void setWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        this.wishlist = List.of(firstChoice, secondChoice, thirdChoice);
        childWishList.fill(firstChoice, secondChoice, thirdChoice);
    }
}
