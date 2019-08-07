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

