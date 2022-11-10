package com.dropchop.textonic.model.dto.doc.output.result;

import com.dropchop.recyclone.model.api.base.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 5. 10. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@JsonInclude(NON_NULL)
public class AnalysisStats implements Dto {
  @JsonProperty("sem")
  @Schema(
    description = "String identifier composed from ModelStep, ML Engine code, ML Model code separated with column."
  )
  @NonNull
  private String semCode;
  private long computeMs;
  private long totalMs;

  public AnalysisStats semCode(String semCode) {
    this.semCode = semCode;
    return this;
  }

  public AnalysisStats computeMs(long computeMs) {
    this.computeMs = computeMs;
    return this;
  }

  public AnalysisStats totalMs(long totalMs) {
    this.totalMs = totalMs;
    return this;
  }
}
