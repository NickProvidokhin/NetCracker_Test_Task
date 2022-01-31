import java.io.*;
import java.util.*;

public class Hierarchy {
    private static String PATH = "src\\main\\resources\\population.txt";
    public static List<String> fileProcessing() {
        List<String> list = new LinkedList<>();
        try {
            File file = new File(PATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Human> createHierarchy(List<String> list) {
        List<Human> humanList = new LinkedList<>();
        for (String str : list) {
            if (str.contains(":")) {
                List<Human> servantsList = new LinkedList<>();
                String[] names = str.split(":");
                List<Human> servants = new LinkedList<>();
                names[1].trim();
                String[] servantNames = names[1].split(",");
                Arrays.sort(servantNames);
                for (String namesOfServant : servantNames) {
                    Human servant = new Human(namesOfServant.trim());
                    servantsList.add(servant);
                }
                Human human = new Human(names[0], servantsList);
                humanList.add(human);
            } else {
                Human human = new Human(str);
                humanList.add(human);
            }

        }
        return humanList;
    }
}
