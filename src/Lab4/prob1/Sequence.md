```mermaid
sequenceDiagram
    actor Person
    Person ->>+ Order: calculatePrice()
    Order ->>+ Orderline: calculatePrice()
    Orderline ->>+ Product: getPrice(quantity: number)
    Product -->>- Orderline: return: price
    Orderline -->>- Order: response
    Order ->>+ Customer: getDiscountedValue(order)
    Customer ->>+ Order: getBaseValue()
    Order -->>- Customer: return: baseValue
    Customer -->>- Order: return: discountedValue
    Order -->>- Person: response
```

![Description](Sequence.png)