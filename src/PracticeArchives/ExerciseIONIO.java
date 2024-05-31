package PracticeArchives;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExerciseIONIO {

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
}
