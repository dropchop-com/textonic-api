package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.base.api.model.rest.Constants;
import com.dropchop.recyclone.base.api.model.security.annotations.RequiresPermissions;
import com.dropchop.recyclone.base.dto.model.invoke.CodeParams;
import com.dropchop.recyclone.base.dto.model.rest.Result;
import com.dropchop.recyclone.base.api.model.rest.DynamicExecContext;
import com.dropchop.recyclone.base.api.model.rest.MediaType;
import com.dropchop.textonic.model.api.security.Constants.Domains;
import com.dropchop.textonic.model.dto.ml.Engine;

import jakarta.ws.rs.*;
import java.util.List;

import static com.dropchop.recyclone.base.api.model.security.Constants.*;
import static com.dropchop.recyclone.base.api.model.security.Constants.PERM_DELIM;
import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Query.ENGINE;

/**
 * @author Kristijan Sečan <kristijan.secan@dropchop.com> on 19. 08. 22.
 */
@Path(ENGINE)
@DynamicExecContext(CodeParams.class)
@RequiresPermissions(Domains.Ml.ENGINE + PERM_DELIM + Actions.VIEW)
public interface EngineResource {

  @GET
  @Path("")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  Result<Engine> get();

  @GET
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  List<Engine> getRest();

  @GET
  @Path("{code : [a-z]{2}(([\\-\\w])*(%2A)*)*}")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  Result<Engine> getByCode(@PathParam("code") String code);

  @GET
  @Path("{code : [a-z]{2}(([\\-\\w])*(%2A)*)*}")
  @Produces(MediaType.APPLICATION_JSON)
  List<Engine> getByCodeRest(@PathParam("code") String code);

  @POST
  @Path(Constants.Paths.SEARCH_SEGMENT)
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  Result<Engine> search(CodeParams parameters);

  @POST
  @Path(Constants.Paths.SEARCH_SEGMENT)
  @Produces(MediaType.APPLICATION_JSON)
  List<Engine> searchRest(CodeParams parameters);
}
