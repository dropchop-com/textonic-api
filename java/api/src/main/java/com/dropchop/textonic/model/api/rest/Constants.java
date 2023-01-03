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
        String PROCESS_SEGMENT = "/process";
        String UTILS_SEGMENT = "/utils";

        String PROCESS = ML_SEGMENT + PROCESS_SEGMENT;
        String UTILS = ML_SEGMENT + UTILS_SEGMENT;
      }
    }
  }
}
