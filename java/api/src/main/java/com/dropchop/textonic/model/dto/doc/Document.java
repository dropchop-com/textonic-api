package com.dropchop.textonic.model.dto.doc;

import com.dropchop.recyclone.model.api.base.Dto;
import com.dropchop.recyclone.model.api.marker.HasId;
import com.dropchop.recyclone.model.api.marker.HasLanguageCode;
import com.dropchop.recyclone.model.api.marker.HasTitle;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 14. 06. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
public abstract class Document<S extends Section> implements
  Dto, HasId, HasTitle, HasLanguageCode {

  @NonNull
  @EqualsAndHashCode.Include
  private String id;

  private String sourceUrl;

  private String lang;

  private String title;

  @NonNull
  @Singular
  private List<S> sections;

  private ZonedDateTime created;

  private ZonedDateTime modified;

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ":" + getId();
  }
}
