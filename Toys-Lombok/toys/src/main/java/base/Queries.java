package base;

import toys.ToyModel; // Replace with the actual package name for your toy model class
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Defines queries for your {@link Repository} implementation.
 *
 * @param <T> the type of your entity (first class)
 * @param <U> the type of your nested class (second class)
 * @param <V> the type of your enum class
 */
public interface Queries<T, U, V extends Enum<V>> {
    /**
     * Returns the average quantity of all features across toy models.
     *
     * @return the average quantity
     */
    double getAverageFeatureQuantity(List<ToyModel.Feature> features);

    /**
     * Returns the maximum quantity of features among all toy models.
     *
     * @return the maximum quantity
     */
    List<ToyModel.Feature> getMaxFeatureQuantity(List<ToyModel.Feature> features);

    /**
     * Returns the minimum quantity of features among all toy models.
     *
     * @return the minimum quantity
     */
    int getMinFeatureQuantity(List<ToyModel.Feature> features);

    /**
     * Returns the total count of features across all toy models.
     *
     * @return the total feature count
     */
    long getTotalNameCount(ToyModel.@NonNull Category category, String name);

    /**
     * Returns a list of all toy models.
     *
     * @return the list of toy models
     */
    List<ToyModel> getAllModels();

    /**
     * Returns a filtered set of toy models based on the specified categories.
     *
     * @param categories the set of categories to filter by
     * @return the filtered set of toy models
     */
    Set<ToyModel> getModelsByCategories(
            @NonNull Set<V> categories);

    // New queries

    /**
     * Returns a set of all unique categories available for toy models.
     *
     * @return the set of unique categories
     */
    Set<V> getAllCategories(List<ToyModel> toyModels);

    /**
     * Returns a list of toy models sorted by price in ascending order.
     *
     * @return the sorted list of toy models
     */
    List<ToyModel> getModelsSortedByPriceAsc();


}

