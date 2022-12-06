package com.dropchop.textonic.rest.api;

import com.dropchop.recyclone.model.api.rest.Constants;
import com.dropchop.recyclone.model.api.security.annotations.RequiresPermissions;
import com.dropchop.recyclone.model.dto.invoke.CodeParams;
import com.dropchop.recyclone.model.dto.rest.Result;
import com.dropchop.recyclone.rest.jaxrs.api.ClassicRestResource;
import com.dropchop.recyclone.rest.jaxrs.api.DynamicExecContext;
import com.dropchop.recyclone.rest.jaxrs.api.MediaType;
import com.dropchop.textonic.model.api.security.Constants.Domains;
import com.dropchop.textonic.model.dto.ml.Engine;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import java.util.List;

import static com.dropchop.recyclone.model.api.security.Constants.*;
import static com.dropchop.recyclone.model.api.security.Constants.PERM_DELIM;
import static com.dropchop.textonic.model.api.rest.Constants.Paths.Nlp.Query.ENGINE;
import static com.dropchop.textonic.model.api.rest.Constants.Tags.ML;

/**
 * @author Kristijan Sečan <kristijan.secan@dropchop.com> on 19. 08. 22.
 */
@Path(ENGINE)
@DynamicExecContext(CodeParams.class)
@RequiresPermissions(Domains.Ml.ENGINE + PERM_DELIM + Actions.VIEW)
public interface EngineResource extends ClassicRestResource<Engine>  {

  @GET
  @Path("")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Tag(name = Constants.Tags.DYNAMIC_PARAMS + Constants.Tags.DYNAMIC_DELIM + "com.dropchop.recyclone.model.dto.invoke.CodeParams")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  Result<Engine> get();

  @GET
  @Path("")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Tag(name = Constants.Tags.DYNAMIC_PARAMS + Constants.Tags.DYNAMIC_DELIM + "com.dropchop.recyclone.model.dto.invoke.CodeParams")
  @Produces(MediaType.APPLICATION_JSON)
  default List<Engine> getRest() {
    return unwrap(get());
  }

  @GET
  @Path("{code : [a-z]{2}(([\\-\\w])*(%2A)*)*}")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Tag(name = Constants.Tags.DYNAMIC_PARAMS + Constants.Tags.DYNAMIC_DELIM + "com.dropchop.recyclone.model.dto.invoke.CodeParams")
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  Result<Engine> getByCode(@PathParam("code") String code);

  @GET
  @Path("{code : [a-z]{2}(([\\-\\w])*(%2A)*)*}")
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Tag(name = Constants.Tags.DYNAMIC_PARAMS + Constants.Tags.DYNAMIC_DELIM + "com.dropchop.recyclone.model.dto.invoke.CodeParams")
  @Produces(MediaType.APPLICATION_JSON)
  default List<Engine> getByCodeRest(@PathParam("code") String code) {
    return unwrap(getByCode(code));
  }

  @POST
  @Path(Constants.Paths.SEARCH_SEGMENT)
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON_DROPCHOP_RESULT)
  Result<Engine> search(CodeParams parameters);

  @POST
  @Path(Constants.Paths.SEARCH_SEGMENT)
  @Tag(name = ML)
  @Tag(name = Constants.Tags.DynamicContext.PUBLIC)
  @Produces(MediaType.APPLICATION_JSON)
  default List<Engine> searchRest(CodeParams parameters) {
    return unwrap(search(parameters));
  }
}
