package com.dropchop.textonic.model.dto.doc.output.result;

import com.dropchop.recyclone.base.api.model.base.Dto;
import com.dropchop.recyclone.base.api.model.base.ModelWithCode;
import com.dropchop.textonic.model.api.ml.Engine;
import com.dropchop.textonic.model.api.ml.Model;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 11. 08. 22.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(NON_NULL)
@Schema(
  anyOf = {TextResult.class, TextListResult.class, TextSpanResult.class, TextVecResult.class, ClassificationResult.class}
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "t")
@JsonSubTypes({
  @Type(value = TextResult.class, name = AnalyzedResult.Type.lt),
  @Type(value = TextListResult.class, name = AnalyzedResult.Type.llt),
  @Type(value = TextSpanResult.class, name = AnalyzedResult.Type.spn),
  @Type(value = TextVecResult.class, name = AnalyzedResult.Type.vec),
  @Type(value = ClassificationResult.class, name = AnalyzedResult.Type.cls)
})
public abstract class AnalyzedResult<V> implements Dto, ModelWithCode {

  public interface Type {
    String lt = "lt";
    String llt = "llt";
    String spn = "spn";
    String vec = "vec";
    String cls = "cls";
  }

  @JsonProperty("c")
  @Schema(
    description = "String code identifier composed from ModelStep, ML Engine code, ML Model code separated with column."
  )
  private String code;


  @JsonProperty("t")
  @Schema(
    description = "Identifier for type of result: discriminator."
  )
  private String type;

  @JsonIgnore
  @Schema(
    hidden = true
  )
  private String engineCode;

  @JsonIgnore
  @Schema(
    hidden = true
  )
  private String modelCode;

  @JsonIgnore
  @Schema(
    hidden = true
  )
  private String stepCode;

  @JsonIgnore
  @Schema(
    hidden = true
  )
  private String stepDetail;

  public String toString() {
    return this.getClass().getSimpleName()
      + ":e=" + getEngineCode()
      + ", m=" + getModelCode()
      + ", s=" + getStepCode()
      + ", d=" + getStepDetail();
  }

  public abstract List<V> getValues();
  public abstract void setValues(List<V> values);

  @JsonIgnore
  public String getEngineCode() {
    return engineCode;
  }

  @JsonIgnore
  public String getModelCode() {
    return modelCode;
  }

  @JsonIgnore
  public String getStepCode() {
    return stepCode;
  }

  @JsonIgnore
  public String getStepDetail() {
    return stepDetail;
  }

  public void setCode(String semCode) {
    if (semCode != null) {
      String[] segments = semCode.split(":", 3);
      this.stepCode = segments.length >= 1 ? segments[0] : null;
      this.engineCode = segments.length >= 2 ? segments[1] : null;
      this.modelCode = segments.length >= 3 ? segments[2] : null;
      if (stepCode != null) {
        int idx = stepCode.lastIndexOf('-');
        if (idx > -1) {
          String tmp = stepCode;
          this.stepCode = tmp.substring(0, idx);
          this.stepDetail = tmp.substring(idx + 1);
        }
      }
    }
  }

  public AnalyzedResult(String engineCode, String modelCode, StepCode stepCode, String stepDetail, int size) {
    this.code = StepCode.buildCustomSemCode(
      engineCode,
      modelCode,
      stepCode == null ? null : List.of(stepCode.name()),
      stepDetail == null ? null : List.of(stepDetail)
    );
    this.setEngineCode(engineCode);
    this.setModelCode(modelCode);
    this.setStepCode(stepCode != null ? stepCode.name() : null);
    this.setStepDetail(stepDetail);
    if (size > 0) {
      List<V> values = new ArrayList<>(size);
      this.setValues(values);
    }
  }

  public AnalyzedResult(Engine<?> engine, Model model, StepCode stepCode, String stepDetail, int size) {
    this(engine.getCode(), model.getCode(), stepCode, stepDetail, size);
  }

  public AnalyzedResult(Engine<?> engine, Model model, StepCode stepCode, int size) {
    this(engine, model, stepCode, null, size);
  }
}
