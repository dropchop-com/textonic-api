package com.dropchop.textonic.model.dto.doc;

import com.dropchop.recyclone.model.api.base.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 10. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Geometry implements Dto {

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
