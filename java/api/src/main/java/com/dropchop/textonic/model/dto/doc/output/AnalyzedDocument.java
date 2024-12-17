package com.dropchop.textonic.model.dto.doc.output;

import com.dropchop.recyclone.base.api.model.marker.HasUuid;
import com.dropchop.recyclone.base.api.model.marker.HasUuidV1;
import com.dropchop.textonic.model.dto.doc.Document;
import com.dropchop.textonic.model.dto.doc.output.result.AnalysisStats;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 14. 06. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
public class AnalyzedDocument extends Document<AnalyzedSection> implements
  HasUuid, HasUuidV1 {

  @EqualsAndHashCode.Include
  private UUID uuid;

  @Schema(
    description = "Document analysis result dependent of selected pipeline steps."
  )
  @JsonInclude(NON_EMPTY)
  private List<AnalyzedResult<?>> result;

  @Schema(
    description = "Document analysis statistics."
  )
  @JsonInclude(NON_EMPTY)
  private List<AnalysisStats> stats;

  private ZonedDateTime received = ZonedDateTime.now();

  private ZonedDateTime analyzed;
}
