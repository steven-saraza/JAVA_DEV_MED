package PracticeArchives;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ExcerciseIONIO {

    public static void exerciseIO(){
        String urlArchive = "F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\IONIO.txt";

        try(BufferedReader reader = new BufferedReader(new FileReader(urlArchive))) {

            String line = null;
            int count = 0;
            System.out.println("**********Aquï inicia el archivo**********\n");
            while ((line = reader.readLine())!=null){
                for (int i = 0; i < line.length(); i++) {
                    if(i==0){
                        if(line.charAt(i)!=' ') {
                            count++;
                        }
                    }else{
                        if (line.charAt(i-1) ==' '){

                            if (line.charAt(i) != ' ') count ++;
                        }
                    }
                }

                System.out.println(line);
            }
            System.out.println("\n*********Numero de palabras en el archivo************");
            System.out.println(count);
            System.out.println("\n*********Aquí finaliza el archivo************");

        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void excerciseNIO(){

        String urlArchiveIn = "F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\IONIO.txt";
        String urlArchiveOut = "F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\IONIOout.txt";

        try (FileChannel channelIn = new FileInputStream(urlArchiveIn).getChannel(); FileChannel channelOut = new FileOutputStream(urlArchiveOut).getChannel()) {

            //Se crea el buffer para leer y cargar el contenido del archivo
            ByteBuffer buff = ByteBuffer.allocate((int) channelIn.size());

            //Se lee el buffer
            channelIn.read(buff);

            //Permite indicar desde que posición hacer el copiado
            buff.position(0);
            channelOut.write(buff);
            System.out.println("\n***Contenido copiado de forma correcta***");


        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void excerciseSerialize(){

        String urlArchive = "F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\IONIOSerialize.txt";

        Person person1 = new Person("Steven", 28, "Calle, carrera");
        Person person2 = new Person("Mateo", 40, "Calle, transversal");

        try (FileOutputStream fosArchive = new FileOutputStream(urlArchive); ObjectOutputStream oosObjetPerson = new ObjectOutputStream(fosArchive)) {
            oosObjetPerson.writeObject(person1);
            oosObjetPerson.writeObject(person2);
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public static void excerciseDerialize(){

        String urlArchive = "F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\IONIOSerialize.txt";



        try (FileInputStream fisArchive = new FileInputStream(urlArchive); ObjectInputStream oisObjetPerson = new ObjectInputStream(fisArchive)) {
            Person personDes1 = (Person) oisObjetPerson.readObject();
            Person personDes2 = (Person) oisObjetPerson.readObject();
            System.out.println("\n***Persona Des***");
            System.out.println(personDes1);
            System.out.println(personDes2);

        }catch (IOException|ClassNotFoundException e){
            System.out.println(e);
        }

    }

    public static void excercisePathsFiles() throws InterruptedException {
        String nameArchiveDir = "tesCreate2";
        Path homePath = Paths.get("F:\\Platzi\\JAVA\\JAVA_DEV_MED\\JAVA_DEV_MED\\JAVA_DEV_MED\\");
        Path pathExist = Paths.get(homePath.toAbsolutePath() + "\\" + nameArchiveDir);

        if(Files.exists(pathExist)){
            System.out.println("El archivo/ruta existe");
        }else {
            System.out.println("El archivo/ruta no existe "+ Files.exists(pathExist));
            Thread.sleep(2*1000);
            System.out.println("Se procederá a crear el archivo/ruta " + nameArchiveDir );
            Thread.sleep(3*1000);
            Path pathNew = Paths.get(homePath.toAbsolutePath().toString()).resolve(nameArchiveDir);

            try {

                if(nameArchiveDir.contains(".txt")){
                    Files.createFile(pathNew);
                    System.out.println("Archivo Creado");
                }else{
                    Files.createDirectory(pathNew);
                    System.out.println("La ruta se a Creado");
                }

            }catch (IOException e){
                System.out.println(e);
            }


        }

    }

    public static void excerciseListWalk() {

        String home = System.getProperty("user.home");
        Path urlArchive = Paths.get(home);
        System.out.println(urlArchive);
        try(Stream<Path> content = Files.list(urlArchive); Stream<Path> contentTxt = Files.list(urlArchive) ){
            System.out.println("Mostrando todos los archivos en la carpeta\n");
            content.filter(a-> !Files.isDirectory(a))
                    .forEach(System.out::println);
            System.out.println("\n**************************");
            System.out.println("\nSolo mostrando los .txt\n");
            contentTxt.filter(a-> a.toString().endsWith(".txt"))
                    .forEach(System.out::println);

        }catch (IOException e){
            System.out.println(e);
        }

        try(Stream<Path> content = Files.walk(urlArchive); Stream<Path> contentTxt = Files.walk(urlArchive) ){
            System.out.println("Mostrando todos los archivos en la carpeta con Walk\n");
            content.filter(a-> !Files.isDirectory(a))
                    .forEach(System.out::println);
            System.out.println("\n**************************");
            System.out.println("\nSolo mostrando los .txt con Walk\n");
            contentTxt.filter(a-> a.toString().endsWith(".txt"))
                    .forEach(System.out::println);

        }catch (IOException | UncheckedIOException e){
            System.out.println(e);
        }
    }
}
