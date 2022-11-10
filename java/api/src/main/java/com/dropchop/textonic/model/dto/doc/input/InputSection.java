package com.dropchop.textonic.model.dto.doc.input;

import com.dropchop.textonic.model.dto.doc.Section;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 11. 08. 22.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
public class InputSection extends Section {
}
