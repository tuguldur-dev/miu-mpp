```
Group<?> means unknown type

public static Group<?> copy(Group<?> group) {
    List<?> elements = group.getElements();
    Group<?> grp = new Group<?>(group.getSpecialElement(), elements); 
    return grp;
}



By implementing helper method it can work
public static Group<?> copy(Group<?> group) {
    return copyHelper(group);
}
private static <T> Group<T> copyHelper(Group<T> group) {
    T special = group.getSpecialElement();
    List<T> elements = group.getElements();
    return new Group<>(special, elements);
}
```