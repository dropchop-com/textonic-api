package com.dropchop.textonic.model.dto.doc;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class TextSpanSimple extends TextSpan<String> {

  @JsonProperty("v")
  @Schema(
    description = "Context dependent text data."
  )
  private String value;

  public TextSpanSimple(String value) {
    this.value = value;
  }
}
