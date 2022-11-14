package com.dropchop.textonic.rest.jackson.client;

import com.dropchop.textonic.model.dto.doc.Geometry;
import com.dropchop.textonic.model.dto.doc.Polygon;
import com.dropchop.textonic.model.dto.doc.Rect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
public class GeometryDeserializer extends JsonDeserializer<Geometry> {

  @Override
  public Geometry deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);

    if (node.has("w") && node.has("h") && node.has("x") && node.has("y")) {
      return Rect.builder()
        .left(node.get("x").asDouble())
        .top(node.get("y").asDouble())
        .width(node.get("w").asDouble())
        .height(node.get("h").asDouble()).build();
    } else if (node.has("x") && node.has("y")) {
      JsonNode nodex = node.get("x");
      JsonNode nodey = node.get("y");
      if (!nodex.isArray() || !nodey.isArray()) {
        throw new IOException("Polygon should have two arrays with property names x and y!");
      }
      List<Double> tmpx = new ArrayList<>(nodex.size());
      for (int i = 0; i < nodex.size(); i++) {
        JsonNode ith = nodex.get(i);
        if (!ith.isNumber()) {
          throw new IOException("Polygon x array should have only nuber values!");
        }
        tmpx.add(ith.asDouble());
      }
      List<Double> tmpy = new ArrayList<>(nodey.size());
      for (int i = 0; i < nodex.size(); i++) {
        JsonNode ith = nodex.get(i);
        if (!ith.isNumber()) {
          throw new IOException("Polygon y array should have only nuber values!");
        }
        tmpy.add(ith.asDouble());
      }
      if (tmpx.size() != tmpy.size()) {
        throw new IOException("Polygon should have two arrays of equal size!");
      }
      return Polygon.builder().x(tmpx).y(tmpy).build();
    } else {
      throw new IOException("Invalid Geometry object!");
    }
  }
}
