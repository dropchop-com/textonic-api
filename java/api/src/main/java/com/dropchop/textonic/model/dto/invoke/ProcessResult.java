package com.dropchop.textonic.model.dto.invoke;

import com.dropchop.recyclone.base.dto.model.rest.Result;
import com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument;
import com.dropchop.textonic.model.dto.doc.output.result.AnalysisStats;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
public class ProcessResult extends Result<AnalyzedDocument> {

  @Schema(
    description = "Process result dependent of selected pipeline steps."
  )
  @JsonInclude(NON_EMPTY)
  private List<AnalyzedResult<?>> result;

  @Schema(
    description = "Process runtime statistics."
  )
  @JsonInclude(NON_EMPTY)
  private List<AnalysisStats> stats;
}
