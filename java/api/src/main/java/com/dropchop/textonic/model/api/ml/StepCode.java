package com.dropchop.textonic.model.api.ml;

import com.dropchop.textonic.model.dto.process.AnalysisStep;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 26. 08. 22.
 */
public enum StepCode {
  ocr,
  lang_id,
  tokenize,
  bool_expr,
  pos,
  lemma,
  depparse,
  sentiment,
  constituency,
  ner,
  word_embed, //not implemented
  sent_embed,
  para_embed,
  doc_embed,
  keyword_id,
  summarize,
  classify,
  cluster;

  /**
   * Gets StepCode from its string representation.
   *
   * @param code the string code equal to StepCode.name() value.
   * @return null if string code is invalid StepCode otherwise.
   */
  public static StepCode from(String code) {
    if (code == null || code.isBlank()) {
      return null;
    }
    try {
      return StepCode.valueOf(code);
    } catch (Exception e) {
      return null;
    }
  }

  public static String buildCustomSemCode(String engineCode, String modelCode, List<String> steps, List<String> stepDetails) {
    StringBuilder buffer = new StringBuilder();
    if (steps != null) {
      for (int i = 0; i < steps.size(); i++) {
        if (i > 0) {
          buffer.append(',');
        }
        String code = steps.get(i);
        buffer.append(code);
        if (stepDetails != null && i < stepDetails.size()) {
          String stepDetail = stepDetails.get(i);
          if (stepDetail != null && !stepDetail.isBlank()) {
            buffer.append('-');
            buffer.append(stepDetail);
          }
        }
      }
    }
    buffer.append(":");
    buffer.append(engineCode);
    buffer.append(":");
    buffer.append(modelCode);
    return buffer.toString();
  }


  public static String buildCustomSemCode(Engine<?> engine, Model model, List<String> steps, List<String> stepDetails) {
    return buildCustomSemCode(engine.getCode(), model.getCode(), steps, stepDetails);
  }

  public static String buildSemCode(Engine<?> engine, Model model, List<? extends AnalysisStep> steps, List<String> stepDetails) {
    List<String> stepsCodes = new ArrayList<>();
    for (AnalysisStep step : steps) {
      stepsCodes.add(step.getStep().name());
    }
    return buildCustomSemCode(engine, model, stepsCodes, stepDetails);
  }

  public static String buildSemCode(Engine<?> engine, Model model, AnalysisStep step, String stepDetail) {
    return buildSemCode(engine, model,
      step == null ? null : List.of(step),
      stepDetail == null ? null : List.of(stepDetail)
    );
  }

  public static String buildSemCode(Engine<?> engine, Model model, List<? extends AnalysisStep> steps) {
    return buildSemCode(engine, model, steps, null);
  }

  public static String buildSemCode(Engine<?> engine, Model model, AnalysisStep step) {
    return buildSemCode(engine, model, step, null);
  }
}
