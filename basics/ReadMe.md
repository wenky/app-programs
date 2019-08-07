## Overloading - Overriding

* Can I override an static class?
* Which of the following Child classes are valid way of overriding the parent class m1()?
```java
 class Parent{
  int m1() throws Exception{}
}
//1
class Child{
  int m1(){}
}

//2
class Child2{
  int m1() throws RunTimeException{}
}

//3
class Child3{
  int m1()throws FileNotFoundException{};
}

//4
class Child4{
  void m1() throws Exception{}
}
```
