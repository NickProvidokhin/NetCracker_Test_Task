import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Report {

    public static void printReport(List<Human> humanList) {
        String path = "src\\main\\resources\\report.txt";
        try (FileWriter writer = new FileWriter(path, false)) {
            String text = "Король:";
            writer.write(text);
            writer.append('\n');
            List<String> dictionary = new LinkedList<>();
            for (int i = 0; i < humanList.size(); i++) {
                Human human = humanList.get(i);
                if (!dictionary.contains(human.getName())) {
                    dictionary.add(human.getName());
                    String str = "  ";
                    writer.write(str);
                    writer.append(human.getName());
                    writer.append('\n');
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
                writer.append(servant.getName());
                writer.append('\n');
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

