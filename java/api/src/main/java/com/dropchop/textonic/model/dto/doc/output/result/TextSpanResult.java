package com.dropchop.textonic.model.dto.doc.output.result;

import com.dropchop.textonic.model.api.ml.Engine;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.dropchop.textonic.model.dto.doc.TextSpan;
import com.dropchop.textonic.model.api.ml.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 11. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class TextSpanResult extends AnalyzedResult<TextSpan<?>> {

  @JsonProperty("v")
  @Schema(
    description = "Text span values."
  )
  List<TextSpan<?>> values;

  public TextSpanResult(Engine<?> engine, Model model, StepCode stepCode, String stepDetail, int size) {
    super(engine, model, stepCode, stepDetail, size);
  }

  public TextSpanResult(Engine<?> engine, Model model, StepCode stepCode, int size) {
    super(engine, model, stepCode, size);
  }
}
