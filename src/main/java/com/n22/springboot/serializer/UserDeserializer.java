package com.n22.springboot.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.n22.springboot.model.User;

/**
 * 用户自定义反序列化
 * @author zjw_guosj
 *
 */
public class UserDeserializer extends JsonDeserializer<User> {

	@Override
	public User deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = p.getCodec().readTree(p);
		String userName = node.get("user_name").asText();
		User user = new User();
		user.setUserName(userName);
		return user;
	}

}
