package be.intecbrussel;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static java.nio.file.Files.exists;
import static java.nio.file.Files.move;

public class MoveFile {

    public static void main(String... args) throws IOException {
        Path fileToRenamePath = Path.of("\\Users\\syo68\\IdeaProjects\\..FromOtiliaToPearl\\message.txt");

        System.out.println("File to rename: " + fileToRenamePath);
        System.out.println("File to rename exits: " + exists(fileToRenamePath));

        Path path = move(fileToRenamePath, fileToRenamePath.getParent().resolve("\\Users\\syo68\\IdeaProjects\\..FromOtiliaToPearl\\animal.txt"),
                StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File renamed to: " + path);
        System.out.println("File renamed exits: " + exists(path));
        System.out.println("File to rename exits: " + exists(fileToRenamePath));
    }


}