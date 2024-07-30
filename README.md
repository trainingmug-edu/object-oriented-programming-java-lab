## Object-Oriented Programming Java Lab
### Objectives
1. Understand and create a new class in Java.
2. Creating objects and accessing them in a class.
3. Creating and invoking methods in Java
4. Create constructors.
5. Create instances using argument and no-argument constructors.
6. Create static variables and methods.
7. Invoking static methods.
### Tasks
1. Create a package `com.trainingmug.ecommerce` under `/src/main/java`
2. Create a new Java class named `Employee` in the `com.trainingmug.ecommerce` package with the following properties:
   - id : `long`
   - name : `String`
   - designation : `String`
   - grossSalary : `float`
   - travellingAllowances : `float`
   - federalTax : `float`
   - stateTax : `float`

3. Create a no-argument constructor for Employee class to initialize the instance variables to the following.
   - id: 111
   - name : Andrew Filler
   - designation = Senior Software Engineer;
   - grossSalary = 5208.33;
   - federalTax = 611.86;
   - stateTax = 359.24;
   
  

3. Create an all-argument constructor for Employee class to initialize the
   instance variables.

5. Create a method in `Employee` class to display all the property values as follows:
    ```java
   public void displayProfile() {}
    ```

4. Create a method in Employee class to increase the `grossSalary` by the given percentage as follows:
    ```java
   public void incrementSalary(float percentage) {}
    ```
   

6. Add the following static constant variables in Employee class:
    - companyName : `String`
    - companyContactNo : `String`
    - employeeCount : `long`
   

   
7. Each time the `Employee` object is created, the `employeeCount` should be incremented by 1.

8. Create a static method in `Employee` class to display all the static properties and the method signature as follows:
  
   ```java
   public static void displayCompanyInfo() {}
   ```