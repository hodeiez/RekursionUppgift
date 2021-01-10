import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


/**
 * Created by Hodei Eceiza
 * Date: 1/8/2021
 * Time: 22:52
 * Project: kotlinTest
 * Copyright: MIT
 */
public class inlämningsUppgift2 {
    List<Arbetare> workers;
    List<String> tempList = new ArrayList<>();

    inlämningsUppgift2() {
        workers = new ArrayList<>();
        workers.add(new Arbetare("Tomten", Arrays.asList("Glader", "Butter")));
        workers.add(new Arbetare("Glader", Arrays.asList("Tröger", "Trötter", "Blyger")));
        workers.add(new Arbetare("Butter", Arrays.asList("Rådjuret", "Nyckelpigan", "Haren", "Räven")));
        workers.add(new Arbetare("Trötter", Arrays.asList("Skumtomten")));
        workers.add(new Arbetare("Skumtomten", Arrays.asList("Dammråttan")));
        workers.add(new Arbetare("Räven", Arrays.asList("Gråsuggan", "Myran")));
        workers.add(new Arbetare("Myran", Arrays.asList("Bladlusen")));


    }

    public List<String> getSuperiors(String searchName) {

        List<String> returnList;
        var name = workers.stream().filter(e -> e.getChild().contains(searchName)).findAny()
                .map(Arbetare::getName).map(Object::toString).orElse(null);
        if (name != null) {
            tempList.add(name);
            getSuperiors(name);

        }
        returnList = tempList.stream().distinct().collect(Collectors.toList());

        return returnList;
    }

    public List<String> getWorkers(String searchName) {

        var name = workers.stream().filter(e -> e.getName().equals(searchName)).findFirst()
                .map(Arbetare::getChild).map(Object::toString).orElse(null);
        if (name != null) {
            tempList.add(name);
            getSuperiors(name);
        }
        return tempList;
    }


    public static void main(String[] args) {
        inlämningsUppgift2 test = new inlämningsUppgift2();
        test.getSuperiors("Skumtomten").forEach(e -> System.out.println(e));
        System.out.println("--------------------------");
        test.getSuperiors("Skumtomten").forEach(e -> System.out.println(e));
        System.out.println("--------------------------");
        test.getSuperiors("Räven").forEach(e -> System.out.println(e));

        // test.getWorkers("Skumtomten").forEach(e-> System.out.println(e));
        //   System.out.println(test.getSuperiors("Skumtomten"));

    }
}
