package com.dropchop.textonic.model.api.ml;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.recyclone.base.api.model.base.ModelWithCode;

import java.util.List;
import java.util.Set;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 23. 09. 22.
 */
public interface Engine<M extends Model> extends Dto, ModelWithCode, Comparable<ModelWithCode> {
  String getUrl();

  String getSourceUrl();

  List<String> getCites();

  List<M> getModels();

  Set<StepCode> getSteps();

  void setUrl(String url);

  void setSourceUrl(String sourceUrl);

  void setCites(List<String> cites);

  void setModels(List<M> models);

  void setSteps(Set<StepCode> steps);
}
