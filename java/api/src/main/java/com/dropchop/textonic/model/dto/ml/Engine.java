package com.dropchop.textonic.model.dto.ml;

import com.dropchop.recyclone.base.dto.model.base.DtoCode;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 23. 06. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class Engine extends DtoCode implements com.dropchop.textonic.model.api.ml.Engine<Model> {

  private String url;

  private String sourceUrl;

  @Singular
  @JsonInclude(NON_EMPTY)
  private List<String> cites;

  @Singular
  @JsonInclude(NON_EMPTY)
  private List<Model> models;

  @Schema(
    description = "Supported analysis steps."
  )

  @Singular
  @JsonInclude(NON_EMPTY)
  private Set<StepCode> steps = new TreeSet<>();

  @Schema(
    description = "Supported parameters."
  )

  @Singular
  @JsonInclude(NON_EMPTY)
  private Set<Parameter> parameters = new LinkedHashSet<>();
}
