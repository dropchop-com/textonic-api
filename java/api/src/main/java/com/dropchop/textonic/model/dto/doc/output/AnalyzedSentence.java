package com.dropchop.textonic.model.dto.doc.output;

import com.dropchop.textonic.model.api.ml.Engine;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.dropchop.textonic.model.dto.doc.Geometry;
import com.dropchop.textonic.model.dto.doc.Polygon;
import com.dropchop.textonic.model.dto.doc.Rect;
import com.dropchop.textonic.model.dto.doc.TextPosition;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.dropchop.textonic.model.dto.doc.output.result.TextSpanResult;
import com.dropchop.textonic.model.api.ml.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.LinkedList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 11. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class AnalyzedSentence extends AnalyzedSegment {

  @JsonProperty("geom")
  @Schema(
    description = "Plane position if available.",
    anyOf = {Rect.class, Polygon.class}
  )
  private Geometry geometry;

  @JsonProperty("pos")
  @Schema(
    description = "Relative position in document section."
  )
  private TextPosition position;

  @Schema(
    description = "Original sentence."
  )
  private String data;

  @Schema(
    description = "Analysis of sentence dependent of selected pipeline steps."
  )
  @JsonInclude(NON_EMPTY)
  private List<AnalyzedResult<?>> result;

  @Schema(
    description = "Analyzed sentence tokens dependent of selected pipeline steps."
  )
  private AnalyzedTokens tokens;

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ":" + getId();
  }

  public void initTokens(Engine<?> engine, Model model, int size) {
    AnalyzedTokens tokens = this.getTokens();
    if (tokens == null) {
      tokens = new AnalyzedTokens();
      this.setTokens(tokens);
      List<AnalyzedResult<?>> results = new LinkedList<>();
      tokens.setResult(results);
      TextSpanResult tokenResult = new TextSpanResult(engine, model, StepCode.tokenize, size);
      tokens.setData(tokenResult);
    }
  }
}
