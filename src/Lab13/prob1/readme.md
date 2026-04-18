a. First fragment:
List<Integer> is NOT a subtype of List<Number>
```
List<Integer> ints = new ArrayList<>();
ints.add(1);
ints.add(2);
List<Number> nums = ints;
nums.add(3.14);
```

b. 
If nums is actually a List<Integer>, adding a Double would break type safety
```
List<Integer> ints = new ArrayList<>();
ints.add(1);
ints.add(2);
List<? extends Number> nums = ints;
nums.add(3.14);
```
