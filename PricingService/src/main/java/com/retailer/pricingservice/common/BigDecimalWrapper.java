package com.retailer.pricingservice.common;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class BigDecimalWrapper implements JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonElement elem, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		return elem.getAsBigDecimal();
	}

}
