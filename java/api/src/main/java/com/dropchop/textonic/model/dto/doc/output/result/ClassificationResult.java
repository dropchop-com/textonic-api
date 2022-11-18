package com.dropchop.textonic.model.dto.doc.output.result;

import com.dropchop.textonic.model.api.ml.Engine;
import com.dropchop.textonic.model.api.ml.Model;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 16. 09. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ClassificationResult extends TextResult {

  @JsonProperty("v")
  @Schema(
    description = "Context dependent classification score."
  )
  private Double score;

  public ClassificationResult(Engine<?> engine, Model model, StepCode stepCode, String stepDetail, int size) {
    super(engine, model, stepCode, stepDetail, size);
  }

  public ClassificationResult(Engine<?> engine, Model model, StepCode stepCode, int size) {
    super(engine, model, stepCode, size);
  }

  @Override
  public String getType() {
    return Type.cls;
  }
}
