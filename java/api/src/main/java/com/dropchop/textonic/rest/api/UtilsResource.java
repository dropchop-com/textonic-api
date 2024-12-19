package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.base.api.model.rest.DynamicExecContext;
import com.dropchop.recyclone.base.api.model.rest.MediaType;
import com.dropchop.recyclone.base.api.model.security.Constants.Actions;
import com.dropchop.recyclone.base.api.model.security.annotations.RequiresPermissions;
import com.dropchop.textonic.model.api.security.Constants.Domains;
import com.dropchop.textonic.model.dto.doc.input.InputDocument;
import com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument;
import com.dropchop.textonic.model.dto.doc.output.result.TextListResult;
import com.dropchop.textonic.model.dto.invoke.ProcessExecContext;
import com.dropchop.textonic.model.dto.invoke.ProcessParams;
import com.dropchop.textonic.model.dto.invoke.ProcessResult;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

import static com.dropchop.recyclone.base.api.model.security.Constants.PERM_DELIM;
import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Process.UTILS;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 12. 08. 22.
 */
@Path(UTILS)
@DynamicExecContext(value = ProcessParams.class, dataClass = InputDocument.class, execContextClass = ProcessExecContext.class)
@RequiresPermissions(Domains.Ml.UTILS + PERM_DELIM + Actions.CREATE)
public interface UtilsResource {

  @POST
  @Path("louvain")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  ProcessResult louvain(ProcessParams params);

  @POST
  @Path("louvain")
  @Produces(MediaType.APPLICATION_JSON)
  TextListResult louvainRest(ProcessParams params);

  @POST
  @Path("lang_detect")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  ProcessResult langDetect(ProcessParams params);

  @POST
  @Path("lang_detect")
  @Produces(MediaType.APPLICATION_JSON)
  List<AnalyzedDocument> langDetectRest(ProcessParams params);
}
