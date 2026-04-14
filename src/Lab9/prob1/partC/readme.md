### Hashcode doesn't overwritten

When we are using hashmap or hashtable, we must override hashcode().
By using hashcode(), hashtable determine the right table index
```
@Override
public int hashCode() {
    return Objects.hash(name, salary);
}
```

