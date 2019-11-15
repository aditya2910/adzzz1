package com.om.poc.java.equalshashcode;

public class Customer {

  int id;
  String name;

  public Customer(final int id, final String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final Customer customer = (Customer) o;

    if (id != customer.id) {
      return false;
    }
    return name != null ? name.equals(customer.name) : customer.name == null;
  }

//  @Override
//  public int hashCode() {
//    int result = id;
//    result = 31 * result + (name != null ? name.hashCode() : 0);
//    return result;
//  }

  @Override
  public String toString() {
    return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
