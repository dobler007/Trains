package com.company;
import java.io.*;

public class TrainSetSave {

    public static void save(TrainSet trainSet) throws IOException {
        FileOutputStream fileOut = new FileOutputStream("TrainSet.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(trainSet);
        out.close();
        fileOut.close();
        System.out.println("Serialized data is saved in TrainSet.txt");
    }

    public static TrainSet load() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("TrainSet.txt");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        TrainSet trainSet = (TrainSet) in.readObject();
        in.close();
        fileIn.close();
        return trainSet;
    }
}
