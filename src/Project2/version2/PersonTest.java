package Project2.version2;

import Project2.version1.person.*;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("D:\\Intellij IDEA\\课程设计\\Person.txt");
        file.delete();
        System.out.println("请输入您想要生成的对象的个数:");
        int n = scanner.nextInt();
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i ++) {
            persons[i] = randomPersonGenerator();
        }
        writeToFile(file,persons);
        printMessages(persons);
    }

    public static Person randomPersonGenerator() {
         Random random = new Random();
         switch (random.nextInt(6)) {
             default:
             case 1:return new Person("边帝行","郑州市","1231235687","1231@qq.com");
             case 2:return new Student("张三","北京市","12575887","126346@qq.com");
             case 3:return new Employee("李四","重庆市","123543677","11231231@163.com","B204",1000);
             case 4:return new Faculty("pdd","南阳市","1233535357","1122341@163.com","B302",2000,7,"老板");
             case 5:return new Staff("茄子","白给市","123531451","11232341@outlook.com","B109",3000,"打工人");
             case 6:return new Postgraduate("张三","北京市","12575887","126346@qq.com","软件工程","老师");
        }
    }

    public static void writeToFile(File file,Person[] person) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(person);
        oos.close();
    }

    public static void printMessages(Person[] persons) {
        for (int i = 0; i < persons.length; i ++) {
            System.out.println(persons[i].toString() + "\n");
        }
    }
}
