package com.dropchop.textonic.model.dto.process;

import com.dropchop.recyclone.base.api.model.attr.Attribute;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class RequestStep extends AnalysisStepBase implements AnalysisStep {

  @Schema(
    description = "Engine code."
  )
  @EqualsAndHashCode.Include
  private String engine;

  @Schema(
    description = "Model code."
  )
  @EqualsAndHashCode.Include
  private String model;

  @Schema(
    description = "Step attributes."
  )
  @JsonInclude(NON_EMPTY)
  @Singular("attribute")
  private Set<Attribute<?>> attributes;

  @Override
  @JsonIgnore
  public String getEngineCode() {
    return engine;
  }

  @Override
  @JsonIgnore
  public String getModelCode() {
    return model;
  }

  public String toString() {
    return super.toString()
      + ":e=" + getEngine()
      + ":m=" + getModel();
  }
}
