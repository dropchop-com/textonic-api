package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.model.api.rest.Constants;
import com.dropchop.recyclone.model.api.security.Constants.Actions;
import com.dropchop.recyclone.model.api.security.annotations.RequiresPermissions;
import com.dropchop.recyclone.rest.jaxrs.api.DynamicExecContext;
import com.dropchop.recyclone.rest.jaxrs.api.MediaType;
import com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument;
import com.dropchop.textonic.model.dto.invoke.ProcessExecContext;
import com.dropchop.textonic.model.dto.invoke.ProcessParams;
import com.dropchop.textonic.model.dto.invoke.ProcessResult;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;

import static com.dropchop.recyclone.model.api.security.Constants.PERM_DELIM;
import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Process.PROCESS;
import static com.dropchop.textonic.model.api.rest.Constants.Tags.ML;
import static com.dropchop.textonic.model.api.security.Constants.*;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Path(PROCESS)
@DynamicExecContext(value = ProcessParams.class, execContextClass = ProcessExecContext.class)
@RequiresPermissions(Domains.Ml.PROCESS + PERM_DELIM + Actions.CREATE)
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
