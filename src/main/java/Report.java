import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Report {

    public static void printReport(List<Human> listOfHuman) {
        try (FileWriter writer = new FileWriter("src\\main\\resources\\report.txt", false)) {
            String text = "Король:";
            writer.write(text);
            writer.append('\n');
            List<String> dictionary = new LinkedList<>();
            for (int i = 0; i < listOfHuman.size(); i++) {
                Human human = listOfHuman.get(i);
                if (!dictionary.contains(human.getName())) {
                    dictionary.add(human.getName());
                    String str = "  ";
                    writer.write(str);
                    writer.append(human.getName());
                    writer.append('\n');
                    if (human.getServants() != null) {
                        List<Human> servants = human.getServants();
                        printLevelServant(servants, writer, str, listOfHuman, dictionary);
                    }
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printLevelServant(List<Human> servants, FileWriter writer, String str, List<Human> listOfHuman, List<String> dictionary) throws IOException {
        str += "  ";
        for (Human servant : servants) {
            if (!dictionary.contains(servant.getName())) {
                dictionary.add(servant.getName());
                writer.write(str);
                writer.append(servant.getName());
                writer.append('\n');
                int a = listOfHuman.indexOf(servant);
                if (a > 0) {
                    Human servantNewLevel = listOfHuman.get(a);
                    if (servantNewLevel.getServants() != null) {
                        List<Human> servantsNewLevel = servantNewLevel.getServants();
                        printLevelServant(servantsNewLevel, writer, str, listOfHuman, dictionary);
                    }
                }
            }
        }
    }
}

