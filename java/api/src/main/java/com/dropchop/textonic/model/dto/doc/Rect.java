package com.dropchop.textonic.model.dto.doc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(NON_NULL)
public class Rect extends Geometry {

  @JsonProperty("x")
  @Schema(
    description = "Left coordinate."
  )
  private Double left;

  @JsonProperty("y")
  @Schema(
    description = "Top coordinate."
  )
  private Double top;

  @JsonProperty("w")
  @Schema(
    description = "Width."
  )
  private Double width;

  @JsonProperty("h")
  @Schema(
    description = "Height."
  )
  private Double height;

  @Override
  public String toString() {
    return super.toString() + ":x=" + left +
      ", y=" + top +
      ", w=" + width +
      ", h=" + height;
  }
}
