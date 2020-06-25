package com.codeisgood.simplehashing;

public class HashingTest {

  public static void main(String[] args) {
    Employee emp1 = new Employee(1, "David", "Gilmour");
    Employee emp2 = new Employee(2, "Mike", "Shinoda");
    Employee emp3 = new Employee(3, "Joe", "Hahn");
    Employee emp4 = new Employee(4, "John", "Doe");
    Employee emp5 = new Employee(5, "Bill", "Williams");

    //CREATE
    SimpleHashing simpleHashing = new SimpleHashing();
    simpleHashing.put("Gilmour", emp1);
    simpleHashing.put("Shinoda", emp2);
    simpleHashing.put("Hahn", emp3);
    simpleHashing.put("Doe", emp4);
    simpleHashing.put("Williams", emp5);

    //READ
    simpleHashing.printHashTable();
    System.out.println("Get for Gilmour: " + simpleHashing.get("Gilmour"));
  }
}
