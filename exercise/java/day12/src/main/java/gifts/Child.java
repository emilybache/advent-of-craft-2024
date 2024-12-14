package gifts;

public class Child {

    private final ChildName childName;
    private final ChildBehaviour childBehaviour;
    private final WishList childWishList;

    private Child(String name, String behavior) {
        this.childName = new ChildName(name);
        this.childBehaviour = ChildBehaviour.valueOf(behavior.toUpperCase().replace(" ", "_"));
        this.childWishList = new WishList();
    }

    public static Child createChild(String name, String behavior) {
        return new Child(name, behavior);
    }

    Toy chooseToy() {
        switch (childBehaviour) {
            case NAUGHTY -> {
                return childWishList.getLastChoiceToy();
            }
            case NICE -> {
                return childWishList.getSecondChoiceToy();
            }
            case VERY_NICE -> {
                return childWishList.getFirstChoiceToy();
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
        childWishList.fill(firstChoice, secondChoice, thirdChoice);
    }
}
