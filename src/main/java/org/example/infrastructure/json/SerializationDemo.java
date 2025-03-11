package org.example.infrastructure.json;

import org.example.infrastructure.classextend.Animal;
import org.example.infrastructure.classextend.Cat;
import org.example.infrastructure.classextend.Dog;

import java.io.*;
import java.util.ArrayList;

/**
 * @description:
 * @Author BAISHUN
 * @Date 2024/9/3 22:35
 */
public class SerializationDemo {
    public static void main(String[] args) {
        Cat cat = new Cat("huahua", 3);
        Dog dog = new Dog("wangcai", 4);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat);animals.add(dog);
        serializeObj(animals);

//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("string1");
//        serializeObj(strings);
//        Object o = deserializeObj("serialize/arr.ser");

        System.out.println();

    }

    private static void serializeObj(Object obj) {
        try (FileOutputStream fos = new FileOutputStream("serialize/arr.ser");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(obj);
            System.out.println("Serialized data is saved");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    private static Object deserializeObj(String fileName) {
        ArrayList<String> arr;
        try (FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(fis)) {
            arr = (ArrayList<String>) in.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("deserialized success");
        System.out.println(arr.toString());
        return arr;
    }

}
