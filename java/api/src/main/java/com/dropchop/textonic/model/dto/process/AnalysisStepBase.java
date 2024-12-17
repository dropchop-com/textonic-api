package com.dropchop.textonic.model.dto.process;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;
import java.util.ListIterator;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class AnalysisStepBase implements Dto {

  public static <AS extends AnalysisStepBase> boolean hasStep(List<AS> steps, StepCode code) {
    if (code == null) {
      return false;
    }
    if (steps == null || steps.isEmpty()) {
      return false;
    }
    for (AS analysisStep : steps) {
      if (code.equals(analysisStep.getStep())) {
        return true;
      }
    }
    return false;
  }

  public static <AS extends AnalysisStepBase> AS getStep(List<AS> steps, StepCode code) {
    if (code == null) {
      return null;
    }
    if (steps == null || steps.isEmpty()) {
      return null;
    }
    for (AS analysisStep : steps) {
      if (code.equals(analysisStep.getStep())) {
        return analysisStep;
      }
    }
    return null;
  }

  public static <AS extends AnalysisStepBase> AS removeStep(List<AS> steps, StepCode code) {
    if (code == null) {
      return null;
    }
    if (steps == null || steps.isEmpty()) {
      return null;
    }
    for (ListIterator<AS> analysisStepIt = steps.listIterator(); analysisStepIt.hasNext();) {
      AS analysisStep = analysisStepIt.next();
      if (code.equals(analysisStep.getStep())) {
        analysisStepIt.remove();
        return analysisStep;
      }
    }
    return null;
  }

  @Schema(
    description = "ModelStep code."
  )
  private StepCode step;

  public String toString() {
    return this.getClass().getSimpleName()
      + ":s=" + getStep();
  }
}
