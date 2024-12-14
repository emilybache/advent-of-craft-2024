package gifts;

import java.util.List;

public class Child {

    private final ChildName childName;
    private final ChildBehaviour childBehaviour;
    private final String behavior;
    private List<Toy> wishlist;

    private Child(String name, String behavior) {
        this.childName = new ChildName(name);
        this.behavior = behavior;
        this.childBehaviour = ChildBehaviour.valueOf(behavior.toUpperCase().replace(" ", "_"));
    }

    public static Child createChild(String name, String behavior) {
        return new Child(name, behavior);
    }

    boolean matches(String childName) {
        return this.childName.matchesName(childName);
    }

    public String getBehavior() {
        return behavior;
    }

    public List<Toy> getWishlist() {
        return wishlist;
    }

    public void setWishList(Toy firstChoice, Toy secondChoice, Toy thirdChoice) {
        this.wishlist = List.of(firstChoice, secondChoice, thirdChoice);
    }
}
