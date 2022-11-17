package com.dropchop.textonic.model.dto.doc;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

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
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes(
  {@Type(TextSpanSimple.class), @Type(TextSpanList.class)}
)
public abstract class TextSpan<V> extends TextPosition {

  @JsonProperty("i")
  @Schema(
    description = "Context dependent id or reference list index."
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

  public abstract V getValue();

  public abstract void setValue(V value);
}
