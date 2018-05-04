package com.dtrees.common.json;


import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class JsonUtility {

	private final static ObjectMapper MAPPER = new ObjectMapper();

	static {
		MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MAPPER.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		MAPPER.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
			@Override
			public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
				jgen.writeString("");
			}
		});
	}

	/**
	 * @param bean
	 * @return
	 */
	public static String beanToString(Object bean) {
		if (null == bean) {
			return null;
		}

		try {
			return MAPPER.writeValueAsString(bean);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> List<T> convertToList(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json))
			return Collections.emptyList();
		try {
			return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> String listToString(List<T> list) {
		try {
			StringWriter sw = new StringWriter();
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
			MAPPER.writeValue(gen, list);
			gen.close();
			return sw.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> String mapToString(Map<Object, Object> map) {
		try {
			StringWriter sw = new StringWriter();
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
			MAPPER.writeValue(gen, map);
			gen.close();
			return sw.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T convertAsType(String json, Class<T> clsType) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}

		try {
			return MAPPER.readValue(json, clsType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
		return MAPPER.convertValue(fromValue, toValueType);
	}
}
