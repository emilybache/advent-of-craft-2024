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
                return getLastChoiceToy(childWishList.toys());
            }
            case NICE -> {
                return getSecondChoiceToy(childWishList.toys());
            }
            case VERY_NICE -> {
                return getFirstChoiceToy(childWishList.toys());
            }
            case null, default -> {
                return null;
            }
        }
    }

    private Toy getFirstChoiceToy(List<Toy> wishlist1) {
        int giftIndex = 0;
        return wishlist1.get(giftIndex);
    }

    private Toy getSecondChoiceToy(List<Toy> wishlist1) {
        int giftIndex = 1;
        return wishlist1.get(giftIndex);
    }

    private Toy getLastChoiceToy(List<Toy> wishlist1) {
        int giftIndex = wishlist1.size() - 1;
        return wishlist1.get(giftIndex);
    }

    boolean matches(String childName) {
        return this.childName.matchesName(childName);
    }

    public void setWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        this.wishlist = List.of(firstChoice, secondChoice, thirdChoice);
        childWishList.fill(firstChoice, secondChoice, thirdChoice);
    }
}
