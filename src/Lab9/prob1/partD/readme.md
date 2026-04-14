### Visiting can't be used for equals and hashcode. 

Because it is change on the function. Because of that equals and hashcode changed
```
removed: result += 31 * result + (visited ? 1 : 0);
removed: emp.visited == visited;
```

