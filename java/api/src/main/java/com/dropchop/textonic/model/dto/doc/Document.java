package com.dropchop.textonic.model.dto.doc;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.recyclone.base.api.model.marker.HasId;
import com.dropchop.recyclone.base.api.model.marker.HasLanguageCode;
import com.dropchop.recyclone.base.api.model.marker.HasTitle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 14. 06. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
@SuppressWarnings("unused")
public abstract class Document<S extends Section> implements
  Dto, HasId, HasTitle, HasLanguageCode {

  @NonNull
  @EqualsAndHashCode.Include
  private String id;

  private String sourceUrl;

  private String lang;

  private String title;

  @Singular
  @JsonInclude(NON_EMPTY)
  private List<S> sections;

  @JsonProperty("vec")
  @Schema(
    description = "Vector representation."
  )
  List<Double> vector;

  private ZonedDateTime created;

  private ZonedDateTime modified;

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + ":" + getId();
  }
}
