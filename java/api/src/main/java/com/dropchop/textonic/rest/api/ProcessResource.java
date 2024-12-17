package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.base.api.model.rest.DynamicExecContext;
import com.dropchop.recyclone.base.api.model.rest.MediaType;
import com.dropchop.recyclone.base.api.model.security.Constants.Actions;
import com.dropchop.recyclone.base.api.model.security.annotations.RequiresPermissions;
import com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument;
import com.dropchop.textonic.model.dto.invoke.ProcessExecContext;
import com.dropchop.textonic.model.dto.invoke.ProcessParams;
import com.dropchop.textonic.model.dto.invoke.ProcessResult;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

import static com.dropchop.recyclone.base.api.model.security.Constants.PERM_DELIM;
import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Process.PROCESS;
import static com.dropchop.textonic.model.api.security.Constants.Domains;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Path(PROCESS)
@DynamicExecContext(value = ProcessParams.class, execContextClass = ProcessExecContext.class)
@RequiresPermissions(Domains.Ml.PROCESS + PERM_DELIM + Actions.CREATE)
public interface ProcessResource {

  @POST
  @Path("")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  ProcessResult process(ProcessParams params);

  @POST
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  default List<AnalyzedDocument> processRest(ProcessParams params) {
    return process(params).getData();
  }
}
