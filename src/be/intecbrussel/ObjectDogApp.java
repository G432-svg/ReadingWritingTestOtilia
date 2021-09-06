package be.intecbrussel;
import java.io.*;

public class ObjectDogApp {
    public static void main(String[] args) {

        Dog dog = new Dog("Spiky",false);
        dog.setName(dog.getName());
        dog.setEdible(dog.isEdible());

        try (ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(new FileOutputStream("\\Users\\syo68\\IdeaProjects\\..FromOtiliaToPearl\\animal.txt"))) {

            objectOutputStream.writeObject(dog);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream objectInputStream =
                new ObjectInputStream((new FileInputStream("\\Users\\syo68\\IdeaProjects\\..FromOtiliaToPearl\\animal.txt")))){
            Dog dog1 = (Dog) objectInputStream.readObject();
            System.out.println(dog1);
            System.out.println(dog1.isEdible());

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
