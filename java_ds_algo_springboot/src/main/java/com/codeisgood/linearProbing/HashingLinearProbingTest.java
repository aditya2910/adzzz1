package com.codeisgood.linearProbing;

public class HashingLinearProbingTest {

  public static void main(String[] args) {
    Employee emp1 = new Employee(1, "David", "Gilmour");
    Employee emp2 = new Employee(2, "Mike", "Shinoda");
    Employee emp3 = new Employee(3, "Joe", "Hahn");
    Employee emp4 = new Employee(4, "John", "Garao");
    Employee emp5 = new Employee(5, "Jeff", "Williams");
    Employee emp6 = new Employee(6, "Bill", "Gates");
    Employee emp7 = new Employee(7, "Donald", "Powell");
    Employee emp8 = new Employee(8, "Steve", "Jobs");

    //CREATE
    HashingLinearProbing hashingLinearProbing = new HashingLinearProbing();
    hashingLinearProbing.put("Gilmour", emp1);
    hashingLinearProbing.put("Shinoda", emp2);
    hashingLinearProbing.put("Hahn", emp3);
    hashingLinearProbing.put("Garao", emp4);
    hashingLinearProbing.put("Williams", emp5);
    hashingLinearProbing.put("Gates", emp6);
    hashingLinearProbing.put("Williams", emp7);
    hashingLinearProbing.put("Pomp", emp8);

    //READ
    hashingLinearProbing.printHashTable();
    System.out.println("Get for Powell: " + hashingLinearProbing.get("Powell"));
  }

}
