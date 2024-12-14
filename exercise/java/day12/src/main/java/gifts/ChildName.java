package gifts;

public record ChildName(String name) {
    boolean matchesName(String childName) {
        return name().equals(childName);
    }
}
