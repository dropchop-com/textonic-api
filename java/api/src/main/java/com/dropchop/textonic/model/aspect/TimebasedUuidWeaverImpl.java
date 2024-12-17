package com.dropchop.textonic.model.aspect;

import com.dropchop.recyclone.base.api.model.aspect.TimebasedUuidWeaver;
import com.dropchop.recyclone.base.api.model.utils.Uuid;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 7. 01. 22.
 */
@Slf4j
@Aspect
public class TimebasedUuidWeaverImpl implements TimebasedUuidWeaver {

  @After(value = "set(java.time.ZonedDateTime com.dropchop.textonic.model.dto..*created) " +
    "&& this(com.dropchop.recyclone.model.api.marker.state.HasCreated) && this(com.dropchop.recyclone.model.api.marker.HasUuidV1) " +
    "&& target(oModel) && args(created)",
    argNames = "oModel,created")
  public void changeClassWithCreated(Object oModel, ZonedDateTime created) {
    TimebasedUuidWeaver.super.changeClassWithCreated(oModel, created);
  }

  @After(value = "set(java.util.UUID com.dropchop.textonic.model.dto..*uuid) " +
    "&& this(com.dropchop.recyclone.model.api.marker.state.HasCreated) && this(com.dropchop.recyclone.model.api.marker.HasUuidV1) " +
    "&& target(oModel) && args(uuid)",
    argNames = "oModel,uuid")
  public void changeClassWithUuid(Object oModel, UUID uuid) {
    TimebasedUuidWeaver.super.changeClassWithUuid(oModel, uuid);
  }

  @After(value = "set(java.time.ZonedDateTime com.dropchop.textonic.model.dto..*received) " +
    "&& this(com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument) " +
    "&& target(oModel) && args(received)",
    argNames = "oModel,received")
  public void changeClassWithCreated(com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument oModel, ZonedDateTime received) {
    TimebasedUuidWeaver.super.changeClassWithCreated(oModel, received);
  }

  @After(value = "set(java.util.UUID com.dropchop.textonic.model.dto..*uuid) " +
    "&& this(com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument) && this(com.dropchop.recyclone.model.api.marker.HasUuidV1) " +
    "&& target(oModel) && args(uuid)",
    argNames = "oModel,uuid")
  public void changeClassWithUuid(com.dropchop.textonic.model.dto.doc.output.AnalyzedDocument oModel, UUID uuid) {
    if (uuid == null) {
      log.warn("Uuid for [{}] is null will not set ZonedDateTime received.", oModel);
    } else {
      if (uuid.version() == 1) {
        Instant instant = Uuid.toInstant(uuid);
        ZonedDateTime received = instant.atZone(ZoneId.systemDefault());
        log.trace("Will change received {} with {} based on uuid {}", oModel.getUuid(), received, uuid);
        oModel.setReceived(received);
      }
    }
  }
}
