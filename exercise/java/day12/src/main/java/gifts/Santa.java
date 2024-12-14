package gifts;

public class Santa {

    private final ChildrenRepository childrenRepository = new ChildrenRepository();

    public Toy chooseToyForChild(String childName){
        Child child = findChild(childName);

        return child.chooseToyFor();

    }

    private Child findChild(String childName) {
        return childrenRepository.findChild(childName);
    }

    public void addChild(Child child) {
        childrenRepository.add(child);
    }
}
