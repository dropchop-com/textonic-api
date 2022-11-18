package com.dropchop.textonic.model.dto.doc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class TextPosition {

  @JsonProperty("o")
  @Schema(
    description = "Relative text starting offset."
  )
  private Integer offset;


  @JsonProperty("lo")
  @Schema(
    description = "Local relative text starting offset."
  )
  private Integer localOffset;

  @JsonProperty("l")
  @Schema(
    description = "Text length."
  )
  private Integer length;

  @JsonProperty("g")
  @Schema(
    description = "Plane position if available.",
    anyOf = {Rect.class, Polygon.class}
  )
  private Geometry geometry;
}
