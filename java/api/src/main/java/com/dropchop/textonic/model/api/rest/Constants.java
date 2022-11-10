package com.dropchop.textonic.model.api.rest;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 14. 06. 22.
 */
public interface Constants {

  interface Tags {
    String ML = "ml";
  }


  interface Paths {

    interface Nlp {
      String ML_SEGMENT = "/ml";

      interface Query {
        String ENGINE_SEGMENT = "/engine";
        String ENGINE = ML_SEGMENT + ENGINE_SEGMENT;
      }

      interface Process {
        String LANG_DETECT_SEGMENT = "/lang_detect";
        String PROCESS_SEGMENT = "/process";

        String PROCESS = ML_SEGMENT + PROCESS_SEGMENT;
        String LANG_DETECT = ML_SEGMENT + LANG_DETECT_SEGMENT;
      }
    }
  }
}
