import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        //String separator = File.separator; - для замены // в пути, чтоб работало на всех ОС
        String[] pathDir = {
                "D://Games//res//icons",
                "D://Games//res//vectors",
                "D://Games//res//drawables",
                "D://Games//src//test",
                "D://Games//src//main",
                "D://Games//savegames",
                "D://Games//temp"};
        for (String s : pathDir) {
            try {
                Files.createDirectories(Path.of(s));
                if (Files.isDirectory(Path.of(s)))
                    sb.append(" Directory " + Path.of(s).getFileName() + " created " + '\n');
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        String[] pathFile = {
                "D://Games//src//main\\Main.java",
                "D://Games//src//main\\Utils.java",
                "D://Games//temp\\temp.txt"
        };
        for (String f : pathFile) {
            Files.createFile(Path.of(f));
            if (Files.isRegularFile(Path.of(f)))
                sb.append(" File " + Path.of(f).getFileName() + " created " + '\n');
        }
        try (FileWriter log = new FileWriter("D://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("D://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

