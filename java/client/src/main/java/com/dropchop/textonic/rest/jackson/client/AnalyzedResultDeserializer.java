package com.dropchop.textonic.rest.jackson.client;

import com.dropchop.textonic.model.dto.doc.TextSpan;
import com.dropchop.textonic.model.dto.doc.TextSpanList;
import com.dropchop.textonic.model.dto.doc.TextSpanSimple;
import com.dropchop.textonic.model.dto.doc.output.result.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 16. 09. 22.
 */
public class AnalyzedResultDeserializer extends JsonDeserializer<AnalyzedResult<?>> {

  private List<String> fromStringList(JsonNode nodeValue) throws IOException {
    List<String> tmpx = new ArrayList<>(nodeValue.size());
    for (int i = 0; i < nodeValue.size(); i++) {
      JsonNode ith = nodeValue.get(i);
      if (!ith.isTextual()) {
        throw new IOException("Value array should have only string values!");
      }
      tmpx.add(ith.asText());
    }
    return tmpx;
  }

  private AnalyzedResult<?> fromClassificationResult(JsonNode node) throws IOException {
    JsonNode nodeValue = node.get("v");
    JsonNode nodeScore = node.get("s");
    if (!nodeValue.isArray()) {
      throw new IOException("Value should be array!");
    }
    List<String> tmpx = fromStringList(nodeValue);
    return ClassificationResult.builder()
      .score(nodeScore.asDouble())
      .values(tmpx)
      .build();
  }

  private TextSpan<?> fromTextSpan(JsonNode node) throws IOException {
    TextSpan<?> span;
    JsonNode tmp = node.get("v");
    if (tmp != null) {
      if (tmp.isTextual()) {
        span = new TextSpanSimple(tmp.textValue());
      } else if (tmp.isArray()) {
        List<String> values = fromStringList(tmp);
        span = new TextSpanList(values);
      } else {
        throw new IOException("TextSpan value can be array of strings or string!");
      }
    } else {
      span = new TextSpanSimple();
    }
    tmp = node.get("o");
    if (tmp != null) {
      span.setOffset(tmp.asInt());
    }
    tmp = node.get("lo");
    if (tmp != null) {
      span.setLocalOffset(tmp.asInt());
    }
    tmp = node.get("l");
    if (tmp != null) {
      span.setLength(tmp.asInt());
    }
    tmp = node.get("s");
    if (tmp != null) {
      span.setStartIndex(tmp.asInt());
    }
    tmp = node.get("e");
    if (tmp != null) {
      span.setEndIndex(tmp.asInt());
    }
    return span;
  }

  private AnalyzedResult<?> fromValueArray(JsonNode node) throws IOException {
    JsonNode nodeValue = node.get("v");
    if (!nodeValue.isArray()) {
      throw new IOException("Value should be array!");
    }
    if (nodeValue.size() <= 0) {
      return new TextSpanResult();
    }

    JsonNode first = nodeValue.get(0);
    if (first.isNumber()) {
      List<Double> tmpx = new ArrayList<>(nodeValue.size());
      for (int i = 0; i < nodeValue.size(); i++) {
        JsonNode ith = nodeValue.get(i);
        tmpx.add(ith.asDouble());
      }
      return TextVecResult.builder().values(tmpx).build();
    } else if (first.isObject()) {
      List<TextSpan<?>> tmpx = new ArrayList<>(nodeValue.size());
      for (int i = 0; i < nodeValue.size(); i++) {
        JsonNode ith = nodeValue.get(i);
        tmpx.add(fromTextSpan(ith));
      }
      return TextSpanResult.builder().values(tmpx).build();
    } else if (first.isTextual()) {
      List<String> tmpx = fromStringList(nodeValue);
      return TextResult.builder().values(tmpx).build();
    } else if (first.isArray()) {
      List<List<String>> tmpx = new ArrayList<>(nodeValue.size());
      for (int i = 0; i < nodeValue.size(); i++) {
        JsonNode ith = nodeValue.get(i);
        tmpx.add(fromStringList(ith));
      }
      return TextListResult.builder().values(tmpx).build();
    }

    throw new IOException("Value array should have only TextSpanSimple object or Double values!");
  }

  @Override
  public AnalyzedResult<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    ObjectCodec oc = jp.getCodec();
    JsonNode node = oc.readTree(jp);

    AnalyzedResult<?> result;
    if (node.has("s") && node.has("v")) {
      result = fromClassificationResult(node);
    } else if (node.has("v")) {
      result = fromValueArray(node);
    } else {
      throw new IOException("Undetectable AnalyzedResult type!");
    }

    if (node.has("sem")) {
      result.setSemCode(node.get("sem").asText());
    }
    if (node.has("e")) {
      result.setEngineCode(node.get("e").asText());
    }
    if (node.has("s")) {
      result.setStepCode(node.get("s").asText());
    }
    if (node.has("m")) {
      result.setModelCode(node.get("m").asText());
    }

    return result;
  }
}
