import java.util.List;

/**
 * Created by Hodei Eceiza
 * Date: 1/8/2021
 * Time: 22:51
 * Project: kotlinTest
 * Copyright: MIT
 */
public class Arbetare {
    private String name;
    private List<String> child;

    Arbetare(String name,List<String> child){
        this.name=name;
        this.child=child;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getChild() {
        return child;
    }

    public void setChild(List<String> child) {
        this.child = child;
    }
}
