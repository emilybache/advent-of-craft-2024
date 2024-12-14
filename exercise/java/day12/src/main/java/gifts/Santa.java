package gifts;

import java.util.List;

public class Santa {

    private final ChildrenRepository childrenRepository = new ChildrenRepository();

    public Toy chooseToyForChild(String childName){
        Child child = findChild(childName);

        List<Toy> wishlist = child.getWishlist();
        switch (child.getBehavior()) {
            case "naughty" -> {
                int giftIndex = wishlist.size() - 1;
                return wishlist.get(giftIndex);
            }
            case "nice" -> {
                int giftIndex = 1;
                return wishlist.get(giftIndex);
            }
            case "very nice" -> {
                int giftIndex = 0;
                return wishlist.get(giftIndex);
            }
            case null, default -> {
                return null;
            }
        }

    }

    private Child findChild(String childName) {
        return childrenRepository.findChild(childName);
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
