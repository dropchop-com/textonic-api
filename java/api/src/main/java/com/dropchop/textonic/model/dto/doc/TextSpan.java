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
@Schema(
  anyOf = {TextSpanSimple.class, TextSpanList.class}
)
public class TextSpan<V> extends TextPosition {

  @JsonProperty("i")
  @Schema(
    description = "Context dependent id."
  )
  private Integer id;

  @JsonProperty("s")
  @Schema(
    description = "Context dependent starting index."
  )
  private Integer startIndex;

  @JsonProperty("e")
  @Schema(
    description = "Context dependent end index. If omitted it is identical to the starting index."
  )
  private Integer endIndex;

  @JsonProperty("v")
  private V value;
}
