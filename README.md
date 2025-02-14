<h1>Java Project to apply OOP concepts</h1> 

<h2>Structure</h3>

This project is organized into three files:

- Main.java: The main class that manages the menu and user interaction.
- Convert.java: The class that defines the base for data converters.
- ConvertBytes: A concrete class that implements logic for byte conversion.

<h3>Classes</h3>

<h4>Main</h4>
  
This is the main class, resposible for managing the user interfaces and storing registered byte values.


```java
private static final ArrayList<Convert> values = new ArrayList<>();
```

```values```: An ArrayList that stores objects of type ```Convert```. This allows future expansion by adding new types of converters without modifying the main code.

  ```java
  public static void main(String[] args)
  ```

- Entry point of the program.
- Displays the interactive menu and captures user input.
- Options are handled within a ```do-while``` loop to ensure the menu remains active until the user chooses to exit.

  ```java
  private static void registerBytes (Scanner scanner)
  ```

- Prompts the user to enter a number in bytes and stores it as a ```ConvertBytes``` object in the ```values``` ArrayList.
- Uses _polymorphism_ to store ```ConvertBytes``` as a ```Convert```object.

  ```java
  values.add(new ConvertBytes(valor));
  ```
  
  ```java
  private static void listValues()
  ```

- Displays all stored values in the ```ÀrrayList```.
- If the list is empty, an appropriate message is shown.

  ```java
  if (values.isEmpty()) {
      System.out.println("\nNov value registeres.");
  ```

  ```java
  private static void convertValues()
  ```

- Iterates through objects in the ```values``` ArrayList and calls the ```converter()``` method for each object.
- Display the conversion results.

  ```java
  } else {
      System.out.println("\nConversion Results:");
      for (Convert convert : values) {
          System.out.printf("%s bytes = %s%n", convert.getValue().toString(), convert.converter());
  ```
