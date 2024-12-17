package com.dropchop.textonic.model.dto.ml;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 26. 08. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(NON_NULL)
public class Parameter implements Dto {

  public static final String TYPE_STR = "str";
  public static final String TYPE_BOOL = "bool";
  public static final String TYPE_INT = "int";
  public static final String TYPE_FLOAT = "float";

  private String name;
  private String description;
  private String type;
  private String max;
  private String min;
  private String defaultValue;

  @JsonInclude(NON_EMPTY)
  private List<StepCode> steps;
}
