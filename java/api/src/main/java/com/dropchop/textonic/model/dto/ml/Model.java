package com.dropchop.textonic.model.dto.ml;

import com.dropchop.recyclone.model.dto.base.DtoCode;
import com.dropchop.recyclone.model.dto.localization.Language;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 23. 06. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class Model extends DtoCode implements com.dropchop.textonic.model.api.ml.Model {

  private List<Language> languages;

  private ZonedDateTime created;

  private ZonedDateTime modified;

  private Licence licence;

  @Singular
  @Schema(
    description = "Supported analysis steps."
  )
  @JsonInclude(NON_EMPTY)
  private List<ModelStep> steps;

  private boolean forCollection;
}
