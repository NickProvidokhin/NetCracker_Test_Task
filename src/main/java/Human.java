import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Human {
    private String name;
    private List<Human> servants;

    public Human(String name, List<Human> servants) {
        this.name = name;
        this.servants = servants;
    }

    public Human(String name) {
        this.name = name;
        this.servants = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServants(List<Human> servants) {
        this.servants = servants;
    }

    public String getName() {
        return name;
    }

    public List<Human> getServants() {
        return servants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}