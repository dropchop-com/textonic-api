package com.dropchop.textonic.rest.jackson.client;

import com.dropchop.recyclone.model.api.attr.Attribute;
import com.dropchop.recyclone.rest.jackson.client.AttributeCompactSerializer;
import com.dropchop.recyclone.rest.jackson.client.AttributeDeserializer;
import com.dropchop.textonic.model.dto.doc.Geometry;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 15. 11. 22.
 */
public class TextonicObjectMapperFactory {

  public static ObjectMapper createMapper() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    //mapper.disable(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL);

    SimpleModule module = new SimpleModule();
    //module.addDeserializer(Geometry.class, new GeometryDeserializer());
    //module.addDeserializer(AnalyzedResult.class, new AnalyzedResultDeserializer());
    module.addDeserializer(Attribute.class, new AttributeDeserializer());
    module.addSerializer(new AttributeCompactSerializer());

    mapper.registerModule(new Jdk8Module());
    mapper.registerModule(new JavaTimeModule());
    mapper.registerModule(new ParameterNamesModule());
    mapper.registerModule(module);
    return mapper;
  }
}
