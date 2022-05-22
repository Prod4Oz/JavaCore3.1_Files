import javax.imageio.IIOException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();


        try {
            Files.createDirectories(Path.of("D://Games//res//icons"));
            if (Files.isDirectory(Path.of("D://Games//res//icons")))
                sb.append("Директория  icons создана" + '\n');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Files.createDirectories(Path.of("D://Games//res//vectors"));
        if (Files.isDirectory(Path.of("D://Games//res//vectors")))
            sb.append("Директория  vectors создана"+ '\n');

        Files.createDirectories(Path.of("D://Games//res//drawables"));
        if (Files.isDirectory(Path.of("D://Games//res//drawables")))
            sb.append("Директория  drawables создана"+ '\n');

        Files.createDirectories(Path.of("D://Games//src//test"));
        if (Files.isDirectory(Path.of("D://Games//src//test")))
            sb.append("Директория  test создана"+ '\n');

        Files.createDirectories(Path.of("D://Games//src//main"));
        if (Files.isDirectory(Path.of("D://Games//src//main")))
            sb.append("Директория  main создана"+ '\n');

        Files.createDirectories(Path.of("D://Games//savegames"));
        if (Files.isDirectory(Path.of("D://Games//savegames")))
            sb.append("Директория  savegames создана"+ '\n');

        Files.createDirectories(Path.of("D://Games//temp"));
        if (Files.isDirectory(Path.of("D://Games//temp")))
            sb.append("Директория  temp создана"+ '\n');

        Files.createFile(Path.of("D://Games//src//main\\Main.java"));
        if (Files.isRegularFile(Path.of("D://Games//src//main\\Main.java")))
            sb.append("Файл Main.java создан"+ '\n');

        Files.createFile(Path.of("D://Games//src//main\\Utils.java"));
        if (Files.isRegularFile(Path.of("D://Games//src//main\\Utils.java")))
            sb.append("Файл Utils.java создан"+ '\n');

        Files.createFile(Path.of("D://Games//temp\\temp.txt"));
        if (Files.isRegularFile(Path.of("D://Games//temp\\temp.txt")))
            sb.append("Файл temp.txt создан"+ '\n');

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
