package gifts;

import java.util.*;
import java.util.stream.Collectors;

public class Santa {

    private final ChildrenRepository childRepo = new ChildrenRepository();

    public Toy chooseToyForChild(String childName){
        Child child = findChild(childName);

        if("naughty".equals(child.getBehavior()))
            return child.getWishlist().get(child.getWishlist().size() - 1);

        if("nice".equals(child.getBehavior()))
            return child.getWishlist().get(1);

        if("very nice".equals(child.getBehavior()))
            return child.getWishlist().get(0);

        return null;
    }

    private Child findChild(String childName) {
        return childRepo.findChild(childName);
    }

    public void addChild(Child child) {
        childRepo.add(child);
    }
}
