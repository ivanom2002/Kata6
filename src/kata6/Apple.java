package kata6;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Apple { 
    
    public String name, family, genus;
    public Nutritions nutritions;
    
    public static class Nutritions {
        public String carbohydrates, protein, fat, calories, sugar;

        @Override
        public String toString() {
            return "Nutritions{" + "carbohydrates=" + carbohydrates + ", "
                    + "protein=" + protein + ", fat=" + fat + ", calories=" + 
                    calories + ", sugar=" + sugar + '}';
        }
    }

    @Override
    public String toString() {
        return "Apple{" + "name=" + name + ", family=" + family + ", genus="
                + genus + ", nutritions=" + nutritions + '}';
    }
}
