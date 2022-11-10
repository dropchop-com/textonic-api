package com.dropchop.textonic.model.dto.doc.output;

import com.dropchop.recyclone.model.api.base.Dto;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.dropchop.textonic.model.dto.doc.output.result.TextSpanResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 16. 09. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class AnalyzedTokens implements Dto {

  @Schema(
    description = "List of tokens."
  )
  private TextSpanResult data;

  @Schema(
    description = "Analysis resulting token tags dependent on selected pipeline steps."
  )
  private List<AnalyzedResult<?>> result;
}
