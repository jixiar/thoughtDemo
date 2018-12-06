package com.dcml.cms.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ContainerNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;


public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();
    private final static ObjectMapper objectMapper2 = new ObjectMapper();
    private static final String ERROR_TXT = "error";

    @Deprecated
    public static String toJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            logger.error("to json string exception", e);
        }
        return null;
    }

    public static String objectToJson(Object object) {
        try {
            return objectMapper2.writeValueAsString(object);
        } catch (Exception e) {
            logger.error("to json exception", e);
            return null;
        }
    }

    public static <T> T jsonToObject(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return objectMapper2.readValue(json, clazz);
        } catch (Exception e) {
            logger.error(JsonUtils.ERROR_TXT + json, e);
            return null;
        }
    }

    //获取指定路径下的Json字符串
    public static String getSubString(String json, String path) {
        if (StringUtils.isBlank(json) || StringUtils.isBlank(path)) {
            return null;
        }
        try {
            JsonNode node = objectMapper2.readTree(json);
            JsonNode targetNode = node.at(JsonPointer.compile(path));
            return (targetNode instanceof ContainerNode) ? targetNode.toString() : targetNode.asText();
        } catch (Exception e) {
            logger.error(JsonUtils.ERROR_TXT + json, e);
            return null;
        }
    }

    public static <T> T jsonToObject(String json, Class<T> clazz, String path) {
        String subString = getSubString(json, path);
        if (StringUtils.isNotBlank(subString)) {
            return jsonToObject(subString, clazz);
        }
        return null;
    }

    public static <T> List<T> jsonToList(String json, Class clazz) {
        if (StringUtils.isEmpty(json)) {
            return Collections.emptyList();
        }
        try {
            JavaType javaType = objectMapper2.getTypeFactory()
                    .constructParametricType(ArrayList.class, clazz);
            return objectMapper2.readValue(json, javaType);
        } catch (IOException e) {
            logger.error(JsonUtils.ERROR_TXT + e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    @Deprecated
    public static <T> T toObject(String json, TypeReference<T> valueTypeRef) {
        try {
            //忽略json字符串中无效的字段
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, valueTypeRef);
        } catch (IOException e) {
            logger.error("to Object exception", e);
        }
        return null;
    }

    @Deprecated
    public static String toStr(Object model) throws IOException {
        return objectMapper.writeValueAsString(model);
    }

    @Deprecated
    public static <T> T fromStr(String content, Class<T> clazz) throws IOException {
        return objectMapper.readValue(content, clazz);
    }

    @Deprecated
    public static Map<String, Object> fromStrToMap(String content) throws IOException {
        return (Map) fromStr(content, Map.class);
    }

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        objectMapper2.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper2.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        objectMapper2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper2.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper2.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper2.setLocale(Locale.CHINA);
    }
}
