import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Hierarchy {
    static List<String> fileProcessing() {
        List<String> list = new LinkedList<>();
        try {
            File file = new File("src\\main\\resources\\population.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static List<Human> createHierarchy(List<String> list) {
        List<Human> listOfHuman = new LinkedList<>();
        for (String str : list) {
            if (str.contains(":")) {
                List<Human> listOfNamesServants = new LinkedList<>();
                String[] names = str.split(":");
                List<Human> servants = new LinkedList<>();
                names[1].trim();
                String[] namesOfServants = names[1].split(",");
                Arrays.sort(namesOfServants);
                for (String namesOfServant : namesOfServants) {
                    Human servant = new Human(namesOfServant.trim());
                    listOfNamesServants.add(servant);
                }
                Human human = new Human(names[0], listOfNamesServants);
                listOfHuman.add(human);
            } else {
                Human human = new Human(str);
                listOfHuman.add(human);
            }
        }
        return listOfHuman;
    }
}
