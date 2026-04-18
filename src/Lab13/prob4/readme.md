```
public static double sum(Collection<? extends Number> nums {
    double s = 0.0;
    for(Number num : nums) s += num.doubleValue();
    return s;
}

List<Integer> ints = new ArrayList<>();
ints.add(1);
ints.add(2);
List<? extends Number> nums = ints;
double dbl = sum(nums);
nums.add(3.14);

```

a. List<? extends Number> nums = ints; List<Integer> is not a subtype of List<Number>

```
public static double sum(Collection<? extends Number> nums {
    double s = 0.0;
    for(Number num : nums) s += num.doubleValue();
    return s;
}

List<Object> objs = new ArrayList<>();   
objs.add(1);                            
objs.add("two");                       

List<? super Integer> ints = objs;       
ints.add(3);
double dbl = sum(ints);  

```
b. ? super Integer and ? extends Number are incompatible bounds — the compiler cannot guarantee that whatever is inside ints is a Number