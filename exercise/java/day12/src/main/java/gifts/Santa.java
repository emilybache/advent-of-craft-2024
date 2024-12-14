package gifts;

import java.util.List;

public class Santa {

    private final ChildrenRepository childrenRepository = new ChildrenRepository();

    public Toy chooseToyForChild(String childName) {
        Child child = findChild(childName);

        List<Toy> wishlist = child.getWishlist();
        int giftIndex = -1;
        if ("naughty".equals(child.getBehavior())) {
            giftIndex = wishlist.size() - 1;
        }

        if ("nice".equals(child.getBehavior())) {
            giftIndex = 1;
        }

        if ("very nice".equals(child.getBehavior())) {
            giftIndex = 0;
        }

        if (giftIndex == -1)
            return null;
        else
            return wishlist.get(giftIndex);

    }

    private Child findChild(String childName) {
        return childrenRepository.findChild(childName);
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
