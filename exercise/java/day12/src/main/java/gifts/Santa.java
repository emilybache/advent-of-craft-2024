package gifts;

import java.util.List;

public class Santa {

    private final ChildrenRepository childrenRepository = new ChildrenRepository();

    public Toy chooseToyForChild(String childName){
        Child child = findChild(childName);

        List<Toy> wishlist = child.getWishlist();
        if("naughty".equals(child.getBehavior())) {
            int giftIndex = wishlist.size() - 1;
            return wishlist.get(giftIndex);
        }

        if("nice".equals(child.getBehavior())) {
            int giftIndex = 1;
            return wishlist.get(giftIndex);
        }

        if("very nice".equals(child.getBehavior())) {
            int giftIndex = 0;
            return wishlist.get(giftIndex);
        }

        return null;
    }

    private Child findChild(String childName) {
        return childrenRepository.findChild(childName);
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
