package com.dropchop.textonic.model.dto.doc;

import com.dropchop.recyclone.model.api.base.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
public abstract class Section implements Dto {

  private Outline outline;

  @Schema(
    description = "Raw text, URL or base64 data if outline is image or video"
  )
  private String data;

  public enum Outline {
    headline,
    byline,
    lead,
    body,
    excerpt,
    conclusion,
    image,
    video,
    unknown
  }
}
