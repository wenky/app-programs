## Overloading - Overriding

* Can I override an static class?
* Which of the following methods are valid way of overriding the parent class m1()?
```java
 class Parent{
  int m1() throws Exception{}
}
```

First Header | Second Header
------------ | -------------
Content from cell 1 | Content from cell 2
Content in the first column | Content in the second column

  |  |  | 
---|---|---|---
```java 
**1** int m1(){} |  int m1() throws RunTimeException{} | int m1() throws FileNotFoundException | void m1() throws Exception 
```
