package toys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ToyModel implements Comparable<ToyModel>{

    public static final Comparator<ToyModel> COMPARATOR = new ToyModelComparator();

    @EqualsAndHashCode.Include
    private String code;
    private String name;
    private Category category;
    private int price;
    private List<Feature> features;

    @Override
    public int compareTo(ToyModel o) {
        return Objects.compare(this, o, COMPARATOR);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class Feature {
        @EqualsAndHashCode.Include
        private final String id;
        private final String name;
        private final int quantity;
    }

    public enum Category {
        @JsonProperty("STEM")STEM,
        @JsonProperty("Dolls & Accessories")DOLLS_AND_ACCESSORIES,
        @JsonProperty("Educational")EDUCATIONAL,
        @JsonProperty("Arts & Crafts")ARTS_AND_CRAFTS,
        @JsonProperty("Electronics")ELECTRONICS,
        @JsonProperty("Board Games")BOARD_GAMES,
    }

    public static class ToyModelComparator implements Comparator<ToyModel>{

        @Override
        public int compare(ToyModel o1, ToyModel o2) {
            if(o1.price != o2.price){
                return Objects.compare(o1.price, o2.price, Comparator.reverseOrder());
            }
            return Objects.compare(o1.name, o2.getName(), Comparator.naturalOrder());
        }
    }
}
