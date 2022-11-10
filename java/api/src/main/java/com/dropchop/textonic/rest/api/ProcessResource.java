package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.model.api.rest.Constants;
import com.dropchop.recyclone.rest.jaxrs.api.DynamicExecContext;
import com.dropchop.recyclone.rest.jaxrs.api.MediaType;
import com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument;
import com.dropchop.textonic.model.dto.invoke.ProcessExecContext;
import com.dropchop.textonic.model.dto.invoke.ProcessParams;
import com.dropchop.textonic.model.dto.invoke.ProcessResult;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Process.PROCESS;
import static com.dropchop.textonic.model.api.rest.Constants.Tags.ML;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Path(PROCESS)
@DynamicExecContext(value = ProcessParams.class, execContextClass = ProcessExecContext.class)
public interface ProcessResource {

  @POST
  @Path("")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  ProcessResult process(ProcessParams params);

  @POST
  @Path("")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON)
  default List<AnalyzedDocument> processRest(ProcessParams params) {
    return process(params).getData();
  }
}
