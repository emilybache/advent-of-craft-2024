package gifts;

import java.util.*;
import java.util.stream.Collectors;

public class Santa {

    private final List<Child> childrenRepository;
    public Santa() {
        this.childrenRepository = new ArrayList<>();
    }

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
        var found = childrenRepository
                .stream()
                .filter(c -> c.getName().equals(childName))
                .findFirst();

        return found.orElseThrow(NoSuchElementException::new);
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
