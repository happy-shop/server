package com.hs.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by admin on 2019/3/6.
 */
public class JasonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJsonFromObject(Object object) {
        if (object == null) {
            throw new NullPointerException("object is null");
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObjectFromJson(String json, Class<T> classz) {
        if (json == null || classz == null) {
            throw new NullPointerException("json body is null or classz type is null");
        }
        try {
            return mapper.readValue(json, classz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObjectFromJson(String json, TypeReference typeReference) {
        if (json == null || typeReference == null) {
            throw new NullPointerException("json body is null or classz type is null");
        }
        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toCollectionsFromJson(String json, Class<?> collectionClass, Class<?>... elementClasses) {
        if (null == json || "".equals(json) || collectionClass == null) {
            throw new NullPointerException("json body is null or classz type is null");
        }
        try {
            return mapper.readValue(json, getCollectionType(collectionClass, elementClasses));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
