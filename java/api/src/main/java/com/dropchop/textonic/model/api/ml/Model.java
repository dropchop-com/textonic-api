package com.dropchop.textonic.model.api.ml;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.recyclone.base.api.model.base.ModelWithCode;
import com.dropchop.recyclone.base.dto.model.localization.Language;
import com.dropchop.textonic.model.dto.ml.Licence;
import com.dropchop.textonic.model.dto.ml.ModelStep;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 23. 09. 22.
 */
public interface Model extends Dto, ModelWithCode, Comparable<ModelWithCode> {

  static String getDescriptor(String engine, String model, String lang) {
    String descr = engine;
    if (model != null) {
      descr += ":" + model;
      if (lang != null) {
        descr += ":" + lang;
      }
    }

    return descr;
  }
  List<Language> getLanguages();

  void setLanguages(List<Language> lang);

  ZonedDateTime getModified();

  void setModified(ZonedDateTime modified);

  Licence getLicence();

  void setLicence(Licence licence);

  List<ModelStep> getSteps();

  void setSteps(List<ModelStep> steps);

  ZonedDateTime getCreated();
  void setCreated(ZonedDateTime created);

  boolean isForCollection();

  @JsonIgnore
  default boolean isMonolingual() {
    List<Language> languages = getLanguages();
    return languages != null && languages.size() == 1;
  }

  @JsonIgnore
  default boolean isLanguageAgnostic() {
    List<Language> languages = getLanguages();
    return languages == null || languages.isEmpty();
  }

  @JsonIgnore
  default Language getFirstLanguage() {
    if (isLanguageAgnostic()) {
      return null;
    }
    return getLanguages().get(0);
  }

  default ModelStep findStep(StepCode code) {
    if (code == null) {
      return null;
    }
    if (getSteps() == null) {
      return null;
    }
    for (ModelStep modelStep : getSteps()) {
      StepCode currCode = modelStep.getStep();
      if (currCode == null) {
        continue;
      }
      if (currCode.equals(code)) {
        return modelStep;
      }
    }
    return null;
  }
}
