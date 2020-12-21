package com.n22.springboot.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.n22.springboot.model.User;

/**
 * 仅仅序列化userName属性，且输出的key是user-name
 * @author zjw_guosj
 *
 */
public class UserSerializer extends JsonSerializer<User>{

	@Override
	public void serialize(User value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("user_name", value.getUserName());
		gen.writeEndObject();
	}

}
