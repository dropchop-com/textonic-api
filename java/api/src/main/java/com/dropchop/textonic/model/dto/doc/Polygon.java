package com.dropchop.textonic.model.dto.doc;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class Polygon extends Geometry {

  @Singular("x")
  @Schema(
    description = "Ordinate planar polygon components."
  )
  private List<Double> x;

  @Singular("y")
  @Schema(
    description = "Abscissa planar polygon components."
  )
  private List<Double> y;


  @Override
  public String toString() {
    return super.toString() + ":x=" + x +
      ", y=" + y;
  }
}
