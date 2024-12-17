package com.dropchop.textonic.model.dto.doc.output;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.recyclone.base.api.model.marker.HasId;
import com.dropchop.textonic.model.dto.doc.Geometry;
import com.dropchop.textonic.model.dto.doc.Polygon;
import com.dropchop.textonic.model.dto.doc.Rect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 11. 08. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
@Schema(
  anyOf = {AnalyzedSentence.class}
)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({ @JsonSubTypes.Type(AnalyzedSentence.class)})
public abstract class AnalyzedSegment implements Dto, HasId {

  @NonNull
  @EqualsAndHashCode.Include
  @Schema(
    description = "Synthesized identifier composed of doc uuid, section index and segment index."
  )
  private String id;

  @JsonProperty("g")
  @Schema(
    description = "Plane position if available.",
    anyOf = {Rect.class, Polygon.class}
  )
  private Geometry geometry;

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ":" + getId();
  }
}
