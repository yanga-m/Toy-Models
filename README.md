# Toy Models

## Overview

The Toy Models project provides a framework for managing and querying toy models. It includes model classes representing various toy models, a repository for storing and retrieving toy models, and a set of queries for obtaining specific information about the toy models.

## Project Structure

The project is organized into the following components:

- **`toys` Package**: Contains the model classes representing toy models.
  - **`ToyModel` Class**: Represents individual toy models.
    - Fields: `code`, `name`, `category`, `price`, `features`.
    - Static Nested Class: `Feature` - Represents additional features of the toy models.
  - Enum Class: `Category` - Represents possible categories of toy models.

- **`base` Package**: Contains the repository and queries interfaces.
  - **`Repository` Class**: An abstract class for storing entities.
  - **`Queries` Interface**: Defines queries for the repository implementation.

- **`ToyRepository` Class**: Implements the repository and queries for Toy Models.

## Usage

To use Toy Models in your application:

1. **Initialize ToyRepository**: Create an instance of `ToyRepository` to manage toy models.

    ```java
    ToyRepository repository = new ToyRepository();
    ```

2. **Retrieve Toy Models**: Use the repository to get information about toy models.

    ```java
    // Get all toy models
    List<ToyModel> allModels = repository.getAllModels();
    ```

3. **Perform Queries**: Utilize the query methods provided by the `ToyRepository`.

    ```java
    // Get the average quantity of features across all toy models
    double averageQuantity = repository.getAverageFeatureQuantity(allModels);

    // Get the minimum and maximum quantity of features
    int minQuantity = repository.getMinFeatureQuantity(allModels);
    int maxQuantity = repository.getMaxFeatureQuantity(allModels);
    ```

4. **Customize Queries**: Extend the `Queries` interface to add custom queries if needed.

## Example

```java
public static void main(String[] args) throws IOException {
    // Initialize ToyRepository
    ToyRepository repository = new ToyRepository();

    // Get all toy models
    List<ToyModel> allModels = repository.getAllModels();

    // Perform queries
    double averageQuantity = repository.getAverageFeatureQuantity(allModels);
    int minQuantity = repository.getMinFeatureQuantity(allModels);
    int maxQuantity = repository.getMaxFeatureQuantity(allModels);

    // Print results
    System.out.println("Average Quantity of Features: " + averageQuantity);
    System.out.println("Minimum Quantity of Features: " + minQuantity);
    System.out.println("Maximum Quantity of Features: " + maxQuantity);
}
```


## License

This project is licensed under the [MIT License](LICENSE).
