package com.cds.jdk.learn.cloneTest;

import java.util.ArrayList;

@SuppressWarnings("unchecked") public class ArrayListTest {
    public static void main(String args[]) {

        // deep cloning Collection in Java
        ArrayList<Employee> org = new ArrayList<Employee>();
        org.add(new Employee("Joe", "Manager"));
        org.add(new Employee("Tim", "Developer"));
        org.add(new Employee("Frank", "Developer"));

        // creating copy of Collection using copy constructor
        //        ArrayList<Employee> copy = new ArrayList(org);
        ArrayList<Employee> copy = (ArrayList<Employee>) org.clone();
        System.out.println(org);
        System.out.println(copy);

        for (Employee employee : org) {
            employee.setDesignation("staff");
        }

        System.out.println(org);
        System.out.println(copy);

    }

}

class Employee {
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return String.format("%s: %s", name, designation);
    }
}
