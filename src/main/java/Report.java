import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Report {
    private static String PATH = "src\\main\\resources\\report.txt";

    public static void printReport(List<Human> humanList) {
        try (FileWriter writer = new FileWriter(PATH, false)) {
            writer.write("Король:\n");
            List<String> dictionary = new LinkedList<>();
            for (Human human : humanList) {
                if (!dictionary.contains(human.getName())) {
                    dictionary.add(human.getName());
                    String str = "  ";
                    writer.write(str);
                    writer.append(human.getName() + "\n");
                    if (human.getServants() != null) {
                        List<Human> servants = human.getServants();
                        printLevelServant(servants, writer, str, humanList, dictionary);
                    }
                }
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printLevelServant(List<Human> servants, FileWriter writer, String str, List<Human> humanList, List<String> dictionary) throws IOException {
        str += "  ";
        for (Human servant : servants) {
            if (!dictionary.contains(servant.getName())) {
                dictionary.add(servant.getName());
                writer.write(str);
                writer.append(servant.getName() + "\n");
                int a = humanList.indexOf(servant);
                if (a > 0) {
                    Human servantNewLevel = humanList.get(a);
                    if (servantNewLevel.getServants() != null) {
                        List<Human> servantsNewLevel = servantNewLevel.getServants();
                        printLevelServant(servantsNewLevel, writer, str, humanList, dictionary);
                    }
                }
            }
        }
    }
}

