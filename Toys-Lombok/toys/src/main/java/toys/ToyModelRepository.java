package toys;

import base.Queries;
import base.Repository;
import lombok.NonNull;

import java.io.IOException;
import java.util.*;

public class ToyModelRepository extends Repository<ToyModel> implements Queries<ToyModel, ToyModel.Feature, ToyModel.Category> {


    @Override
    public double getAverageFeatureQuantity(List<ToyModel.Feature> features) {
        long sum = 0;
        for(ToyModel.Feature feature : features){
            sum += feature.getQuantity();
        }
        return sum / (double) features.size();
    }

    @Override
    public List<ToyModel.Feature> getMaxFeatureQuantity(List<ToyModel.Feature> features) {
        int max = features.get(0).getQuantity();
        for(int i = 1; i < features.size(); i++ ){
            if(features.get(i).getQuantity() > max){
                max = features.get(i).getQuantity();
            }
        }
        List<ToyModel.Feature> result = new ArrayList<>();
        for(ToyModel.Feature feature : features){
            if(feature.getQuantity() == max ){
                result.add(feature);
            }
        }
        return result;

    }

    @Override
    public int getMinFeatureQuantity(List<ToyModel.Feature> features) {
        int min = features.get(0).getQuantity();
        for(int i = 1; i < features.size(); i++){
            if(features.get(i).getQuantity() < min){
                min = features.get(i).getQuantity();
            }
        }
        return min;
    }

    @Override
    public long getTotalNameCount(@NonNull ToyModel.Category category, String name) {
        long count = 0;
        for(ToyModel toyModel : getAll()){
            if(toyModel.getCategory() == category && toyModel.getName().equals(name)){
                count++;
            }
        }
        return count;
    }

    @Override
    public List<ToyModel> getAllModels() {
        List<ToyModel> all = new ArrayList<>(getAll());
        all.sort(ToyModel.COMPARATOR);
        return all;
    }

    @Override
    public Set<ToyModel> getModelsByCategories(@NonNull Set<ToyModel.Category> categories) {
        Set<ToyModel> models = new HashSet<>();
        for(ToyModel toyModel : getAll()){
            if(categories.add(toyModel.getCategory())){
                models.add(toyModel);
            }
        }
        return models;
    }

    @Override
    public Set<ToyModel.Category> getAllCategories(List<ToyModel> toyModels) {
        Set<ToyModel.Category> all = new HashSet<>();
        for(ToyModel toyModel : getAll()){
            all.add(toyModel.getCategory());
        }
        return all;
    }

    @Override
    public List<ToyModel> getModelsSortedByPriceAsc() {
        List<ToyModel> models = new ArrayList<>(getAll());
        models.sort(new Comparator<ToyModel>() {
            @Override
            public int compare(ToyModel o1, ToyModel o2) {
                return Objects.compare(o1.getPrice(), o2.getPrice(), Comparator.naturalOrder());
            }
        });
        return models;
    }

    public ToyModelRepository() throws IOException {
        super(ToyModel.class);
    }

    public static void main(String[] args) throws IOException{
        ToyModelRepository repository = new ToyModelRepository();
        System.out.println(repository);
        //System.out.println(repository.getAllCategories());
        System.out.println(repository.getAllModels());
        //System.out.println(repository.getAverageFeatureQuantity());
        System.out.println(repository.getMinFeatureQuantity());
        System.out.println(repository.getMaxFeatureQuantity());
        System.out.println(repository.getModelsByCategories());
        System.out.println(repository.getModelsSortedByPriceAsc());
        System.out.println(repository.getTotalNameCount();
    }
}
