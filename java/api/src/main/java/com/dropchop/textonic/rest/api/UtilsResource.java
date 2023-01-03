package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.model.api.invoke.ErrorCode;
import com.dropchop.recyclone.model.api.invoke.ServiceException;
import com.dropchop.recyclone.model.api.invoke.StatusMessage;
import com.dropchop.recyclone.model.api.rest.Constants;
import com.dropchop.recyclone.model.api.security.Constants.Actions;
import com.dropchop.recyclone.model.api.security.annotations.RequiresPermissions;
import com.dropchop.recyclone.rest.jaxrs.api.DynamicExecContext;
import com.dropchop.recyclone.rest.jaxrs.api.MediaType;
import com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument;
import com.dropchop.textonic.model.dto.doc.output.result.AnalyzedResult;
import com.dropchop.textonic.model.dto.doc.output.result.TextListResult;
import com.dropchop.textonic.model.dto.invoke.ProcessExecContext;
import com.dropchop.textonic.model.dto.invoke.ProcessParams;
import com.dropchop.textonic.model.dto.invoke.ProcessResult;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static com.dropchop.recyclone.model.api.security.Constants.PERM_DELIM;
import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Process.UTILS;
import static com.dropchop.textonic.model.api.rest.Constants.Tags.ML;
import static com.dropchop.textonic.model.api.security.Constants.Domains;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Path(UTILS)
@DynamicExecContext(value = ProcessParams.class, execContextClass = ProcessExecContext.class)
@RequiresPermissions(Domains.Ml.UTILS + PERM_DELIM + Actions.CREATE)
public interface UtilsResource {

  @POST
  @Path("louvain")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  ProcessResult louvain(ProcessParams params);

  @POST
  @Path("louvain")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON)
  default TextListResult louvainRest(ProcessParams params) {
    List<AnalyzedResult<?>> result = louvain(params).getResult();
    if (result == null || result.isEmpty()) {
      throw new ServiceException(new StatusMessage(ErrorCode.process_error, "Missing result from pipeline!"));
    }
    AnalyzedResult<?> firstResult = result.get(0);
    if (firstResult instanceof TextListResult textListResult) {
      return textListResult;
    }
    throw new ServiceException(new StatusMessage(ErrorCode.process_error, "Invalid result from pipeline!"));
  }

  @POST
  @Path("lang_detect")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  ProcessResult langDetect(ProcessParams params);

  @POST
  @Path("lang_detect")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON)
  default List<AnalyzedDocument> langDetectRest(ProcessParams params) {
    return langDetect(params).getData();
  }
}
