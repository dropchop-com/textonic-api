package com.dropchop.textonic.model.dto.doc;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({ @JsonSubTypes.Type(Polygon.class), @JsonSubTypes.Type(Rect.class)})
public abstract class Geometry implements Dto {

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
