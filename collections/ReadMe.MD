## Collections
### HashMap
__Internal Implementation__ HashMaps are essentially a key-value pair

* Consider following Map.
```java 
HashMap<Employee,Salary> employeeSalaryMap=new HashMap<>();
employeeSalaryMap.put(ram,20000);
employeeSalaryMap.put(ravi,15000);
employeeSalaryMap.put(raju,30000);
```
  * What will happen if i dont override hashcode and equals methods?
  * What will happen if hashcode always returns 1 whereas equals method is overriden correctly.
  * What will happen if hashcode implemented correctly whereas equals method is not overrided?
  * Time complexities of HashMap,List.
  * Can null keys be placed in TreeMap?
  * You have millions of Strings in a collection and need the frequency count  of the strings.


  ### References
  * _https://javahungry.blogspot.com/2013/08/hashing-how-hash-map-works-in-java-or.html_