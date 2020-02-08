package com.funstar.test;

import java.io.*;

/**
 * @author funstar
 * @date 2019/12/6
 */
public class DeepCloneUtils {

    public static <T extends Serializable> T deepClone(T object) {
        T cloneObject = null;
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            cloneObject = (T)objectInputStream.readObject();
            objectInputStream.close();

        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cloneObject;
    }
}
