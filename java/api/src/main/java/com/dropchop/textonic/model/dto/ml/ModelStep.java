package com.dropchop.textonic.model.dto.ml;

import com.dropchop.textonic.model.api.ml.StepCode;
import com.dropchop.textonic.model.dto.process.AnalysisStepBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(NON_NULL)
public class ModelStep extends AnalysisStepBase {

  private Double score;
  private Double speed;
  private String corpus;

  @Singular
  private List<StepCode> deps;
}
