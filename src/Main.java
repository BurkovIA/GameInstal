import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder saveLog = new StringBuilder();

        File gameInstal = new File("C://Game");
        gameInstal.mkdir();

        String[] directoriesInGame = {"src", "res", "savegames", "temp"};
        for (String directoryInGame : directoriesInGame) {
            File directory = new File(gameInstal + "/" + directoryInGame);
            if (!directory.exists()) {
                directory.mkdir();
                saveLog.append("Создан каталог - " + directory + "\n");
            }
        }

        String[] srcDerectories = {"main", "test"};
        for (String srcDerectory : srcDerectories) {
            File srcDirectory = new File(gameInstal + "/src/" + srcDerectory);
            if (!srcDirectory.exists()) {
                srcDirectory.mkdirs();
                saveLog.append("Создан каталог - " + srcDirectory + "\n");
            }
        }

        try {
            String[] mainFiles = {"Main.java", "Utils.java"};
            for (String mainFile : mainFiles) {
                File file = new File(gameInstal + "/src/main/" + mainFile);
                if (!file.exists()) {
                    file.createNewFile();
                    saveLog.append("Создан файл - " + file + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String[] resDerectories = {"drawables", "vectors", "icons"};
        for (String res : resDerectories) {
            File resDerectory = new File(gameInstal + "/res/" + res);
            if(!resDerectory.exists()){
                resDerectory.mkdirs();
                saveLog.append("Создан каталог - " + resDerectory + "\n");
            }
        }

        try {
            File tempFile = new File(gameInstal + "/temp/temp.txt");
            if (!tempFile.exists()) {
                tempFile.createNewFile();
                saveLog.append("Создан файл - " + tempFile + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter writer = new FileWriter(gameInstal + "/temp/temp.txt")) {
            writer.write(saveLog.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}