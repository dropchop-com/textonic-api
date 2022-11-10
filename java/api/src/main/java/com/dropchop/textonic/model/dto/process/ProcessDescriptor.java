package com.dropchop.textonic.model.dto.process;

import com.dropchop.recyclone.model.api.base.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ProcessDescriptor implements Dto {

  private Analysis analysis;
}
