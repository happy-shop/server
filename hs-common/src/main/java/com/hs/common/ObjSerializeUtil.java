package com.hs.common;

import java.io.*;

/**
 * Created by admin on 2018/5/30.
 * Object Serialize 的方式序列化
 */
public class ObjSerializeUtil {

    public static String serialize(Object obj) {
        String str = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            str = baos.toString("ISO-8859-1");
            baos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static byte[] serializeToBytes(Object obj) {
        byte[] arr = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            arr = baos.toByteArray();
            baos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public static <T> T deserialize(String serialize, Class<T> clazz) {
        try {
            byte[] bytes = serialize.getBytes("ISO-8859-1");
            return deserialize(bytes, clazz);
        } catch (UnsupportedEncodingException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) {
        T object = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            object = (T) ois.readObject();
            bais.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
