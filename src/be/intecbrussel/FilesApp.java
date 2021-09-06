package be.intecbrussel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FilesApp {
    public static void main(String[] args) {

        try{
            //Define Path
            Path path = Paths.get("../..FromOtiliaToPearl/message.txt");
            Files.createDirectories(path.getParent());
            //Create if not exists
            if(Files.notExists(path)){
                Files.createFile(path);
                System.out.println("File created");
            }else{
                System.out.println("File already exists.");
            }



            //Retrieve attributes of file
            DosFileAttributes attrs = Files.readAttributes(path,DosFileAttributes.class);
            System.out.println(attrs.size());
            System.out.println(attrs.creationTime());
            System.out.println(attrs.lastAccessTime());
            System.out.println(attrs.lastModifiedTime());
            System.out.println(attrs.isArchive());
            System.out.println(attrs.isHidden());
            System.out.println(attrs.isReadOnly());

            //Read lines of text from file
            Files.lines(path).forEach(System.out::println);

            try {
                InputStreamReader buff = new InputStreamReader(System.in);
                //Write lines of text to file
                List<String> lines1 = new ArrayList<>();
                lines1.add("Hoeee oee mooi,kan het leven zijn?");
                lines1.add("Het is maar hoe je kijkt");
                lines1.add("Het is maar wat je droomt.");
                Files.write(path, lines1, StandardCharsets.UTF_8, StandardOpenOption.APPEND);

                BufferedReader theFile = new BufferedReader(buff);


                String s = theFile.readLine();

                theFile.close();;

                buff.close();

                System.out.println("The text is :" + s);
            } catch(IOException e){
            e.printStackTrace();
            }

            byte [] bytes1 = {1,2,3};
            Files.write(path,bytes1);

            byte[] bytes2 = Files.readAllBytes(path);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
