#### For each lambda expression below, name the parameters and the free variables.
**A: Parameters: None, Free variables: s, t**
```
Runnable r = () → {
    int[][] products = new int[s][t];
    for (int i = 0; i < s; i++) {
        for(int j = i + 1; j < t; j++) {
            products[i][j] = i * j;
        }
    }
}
```


**B: Parameters: s,t, Free variables: ignoreCase**
```
.Comparator<String> comp = (s, t) → {
    if(ignoreCase == true) {
        return s.compareToIgnoreCase(t);
    } else {
        return s.compareTo(t);
    }
}
```

