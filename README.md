<h1>Java Project to apply OOP concepts</h1> 

<h3>Structure</h3>

This project is organized into three files:

- Main.java: The main class that manages the menu and user interaction.
- Convert.java: The class that defines the base for data converters.
- ConvertBytes: A concrete class that implements logic for byte conversion.


## Main

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


## Convert

Defines the base class for all converters in the system.

  ```java
  private BigInteger value;
  ```

- The ```value``` attribute is encapsulated and can only be accessed or modified using the ```getValue()```and ```setValue()``` methods.

  ```java
  public abstract class Convert
  ```

- An abstract method that must be implemented by subclasses, allowing different behaviors depending on the converter type.


## ConvertBytes

A concrete class that extends ```Convert```and implements the conversion logic specifically for bytes.

  ```java
  private static final String[] UNITS = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
  ```

- An array of strings defining the measurement units used in the conversion.

  ```java
  private static final BigInteger ONE_KB = new BigInteger("1024");
  ```

- A ```BigInteger``` object representing the value ```1024```, used for calculations in the conversion process.

  ```java
  public ConvertBytes(BigInteger value)
  ```

- A constructor that calls the superclass constructor to initialize the ```value``` attribute.

  ```java
  public String converter()
  ```

- This metod implements the conversion logic.
