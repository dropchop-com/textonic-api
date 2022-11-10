package com.dropchop.textonic.model.dto.invoke;

import com.dropchop.recyclone.model.api.attr.Attribute;
import com.dropchop.recyclone.model.api.base.Dto;
import com.dropchop.recyclone.model.api.invoke.Params;
import com.dropchop.textonic.model.dto.doc.input.InputDocument;
import com.dropchop.textonic.model.dto.process.ProcessDescriptor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ProcessParams implements Dto, Params {

  private String requestId;

  private ProcessDescriptor process;

  @Singular
  private List<InputDocument> documents;

  @Singular
  @JsonInclude(NON_EMPTY)
  private Set<Attribute<?>> attributes;
}
