import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = Hierarchy.fileProcessing();

        List<Human> listOfHuman = Hierarchy.createHierarchy(list);

        Report.printReport(listOfHuman);


    }
}
