package com.dropchop.textonic.model.dto.ml;

import com.dropchop.recyclone.model.dto.base.DtoCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 26. 08. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(NON_NULL)
public class Licence extends DtoCode {
  private String url;
}
