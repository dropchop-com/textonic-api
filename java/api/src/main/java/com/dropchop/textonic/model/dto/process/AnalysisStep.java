package com.dropchop.textonic.model.dto.process;

import com.dropchop.textonic.model.api.ml.StepCode;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 23. 09. 22.
 */
public interface AnalysisStep {
  static String getDescriptor(StepCode step, String engine, String model, String lang) {
    String descr = step.name();
    if (engine != null) {
      descr += ":" + engine;
      if (model != null) {
        descr += ":" + model;
        if (lang != null) {
          descr += ":" + lang;
        }
      }
    }
    return descr;
  }

  StepCode getStep();

  void setStep(StepCode step);

  String getEngineCode();
  String getModelCode();

  @JsonIgnore
  default String getDescriptor(String lang) {
    return getDescriptor(getStep(), getEngineCode(), getModelCode(), lang);
  }

  @JsonIgnore
  default String getDescriptor() {
    return getDescriptor(getStep(), getEngineCode(), getModelCode(), null);
  }
}
