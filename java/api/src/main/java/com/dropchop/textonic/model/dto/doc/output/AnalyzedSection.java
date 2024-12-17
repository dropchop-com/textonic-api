package com.dropchop.textonic.model.dto.doc.output;

import com.dropchop.recyclone.base.api.model.marker.HasId;
import com.dropchop.textonic.model.dto.doc.*;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class AnalyzedSection extends Section implements HasId {

  @NonNull
  @EqualsAndHashCode.Include
  @Schema(
    description = "Synthesized identifier composed of doc uuid and section index"
  )
  private String id;

  @JsonProperty("geom")
  @Schema(
    description = "Plane position if available.",
    anyOf = {Rect.class, Polygon.class}
  )
  private Geometry geometry;

  @JsonProperty("pos")
  @Schema(
    description = "Relative position in document."
  )
  private TextPosition position;

  @Schema(
    description = "Segments of document section. Usually sentences if section outline is text."
  )
  private List<AnalyzedSegment> segments;

  @Schema(
    hidden = true
  )
  @JsonIgnore
  private int index;


  @Schema(
    description = "Analysis of section, dependent of selected pipeline steps."
  )
  @JsonInclude(NON_EMPTY)
  private List<AnalyzedResult<?>> result;

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ":" + getId();
  }

  public void initSegments(int size) {
    List<AnalyzedSegment> segments = this.getSegments();
    if (segments == null) {
      segments = new ArrayList<>(size);
      this.setSegments(segments);
    }
  }
}
