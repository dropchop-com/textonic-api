package com.dropchop.textonic.model.dto.invoke;

import com.dropchop.recyclone.model.api.invoke.CommonExecContext;
import com.dropchop.recyclone.model.api.invoke.ExecContext;
import com.dropchop.recyclone.model.api.security.annotations.Logical;
import com.dropchop.recyclone.model.dto.invoke.ParamsExecContext;
import com.dropchop.textonic.model.api.ml.StepCode;
import com.dropchop.textonic.model.dto.doc.input.InputDocument;
import com.dropchop.textonic.model.dto.process.Analysis;
import com.dropchop.textonic.model.dto.process.ProcessDescriptor;
import com.dropchop.textonic.model.dto.process.RequestStep;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(NON_NULL)
public class ProcessExecContext extends ParamsExecContext<ExecContext.Listener>
  implements CommonExecContext<InputDocument, ExecContext.Listener> {

  public static final String MDC_DOC_ID = "docId";

  @NonNull
  private List<InputDocument> data;

  private List<String> requiredPermissions;

  private Logical requiredPermissionsOp = Logical.AND;

  private ProcessResult result;


  public List<RequestStep> getDefaultSteps() {
    List<RequestStep> requestSteps = new ArrayList<>();
    requestSteps.add(RequestStep.builder().step(StepCode.lang_id).build());
    return requestSteps;
  }

  public List<RequestStep> initProcessRequest() {
    ProcessParams processParams = (ProcessParams) this.getParams();
    //noinspection ConstantConditions
    if (processParams == null) {
      processParams = new ProcessParams();
      this.setParams(processParams);
    }
    ProcessDescriptor processDescriptor = processParams.getProcess();
    if (processDescriptor == null) {
      processDescriptor = new ProcessDescriptor();
      processParams.setProcess(processDescriptor);
    }
    Analysis analysis = processDescriptor.getAnalysis();
    if (analysis == null) {
      analysis = new Analysis();
      processDescriptor.setAnalysis(analysis);
    }
    List<RequestStep> requestSteps = analysis.getSteps();
    if (requestSteps == null || requestSteps.isEmpty()) {
      requestSteps = getDefaultSteps();
      analysis.setSteps(requestSteps);
    }
    return requestSteps;
  }
}
