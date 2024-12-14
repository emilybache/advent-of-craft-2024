package gifts;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ChildrenRepository {
    private final List<Child> childrenRepository = new ArrayList<>();

    public void add(Child child) {
        childrenRepository.add(child);
    }

    public Child findChild(String childName) {
        var found = childrenRepository
                .stream()
                .filter(c -> c.getName().equals(childName))
                .findFirst();

        return found.orElseThrow(NoSuchElementException::new);
    }
}
