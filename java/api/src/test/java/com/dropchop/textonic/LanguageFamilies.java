package com.dropchop.textonic;

import com.dropchop.recyclone.model.dto.tagging.LanguageFamily;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author Nikola Ivačič <nikola.ivacic@dropchop.org> on 6. 10. 22.
 */
public class LanguageFamilies {
  private static final Logger log = LoggerFactory.getLogger(LanguageFamilies.class);

  private LanguageFamily
    indoEu, afroasiatic, turkic, uralic,
    baltoSlav, southESlavic, southWSlavic, eastSlavic, westSlavic, southSlavic, slavic, lechitic, czechSlovak,
               baltic, eastBaltic, westBaltic,
    paleoBalkan, albanian,
    germanic,  westGermanic, northGermanic, eastScandinavian, westScandinavian, english, highGerman, lowFrankish,
    celtic,    goidelic,
    greek,
    italic, romance, westernRomance, easternRomance, italoDalmatian, galloRomance, iberianRomance,
    finnoUgric,  ugric, finnoPermic, baltoFinnic,
    semitic;

  @BeforeEach
  void setUp() {
    indoEu = new LanguageFamily("indo_european");
    indoEu.setTags(new ArrayList<>());
    afroasiatic = new LanguageFamily("afroasiatic");
    afroasiatic.setTags(new ArrayList<>());
    turkic = new LanguageFamily("turkic");
    turkic.setTags(new ArrayList<>());
    uralic = new LanguageFamily("uralic");
    uralic.setTags(new ArrayList<>());

    baltoSlav = new LanguageFamily("balto_slavic");
    baltoSlav.addTag(indoEu);

    slavic = new LanguageFamily("slavic");
    slavic.addTag(baltoSlav);

    baltic = new LanguageFamily("baltic");
    baltic.addTag(baltoSlav);

    eastBaltic = new LanguageFamily("east_baltic");
    eastBaltic.addTag(slavic);

    westBaltic = new LanguageFamily("west_baltic");
    westBaltic.addTag(slavic);

    southSlavic = new LanguageFamily("south_slavic");
    southSlavic.addTag(slavic);

    southESlavic = new LanguageFamily("southeast_slavic");
    southESlavic.addTag(southSlavic);

    southWSlavic = new LanguageFamily("southwest_slavic");
    southWSlavic.addTag(southSlavic);

    eastSlavic = new LanguageFamily("east_slavic");
    eastSlavic.addTag(slavic);

    westSlavic = new LanguageFamily("west_slavic");
    westSlavic.addTag(slavic);

    lechitic = new LanguageFamily("lechitic");
    lechitic.addTag(westSlavic);

    czechSlovak = new LanguageFamily("czech_slovak");
    czechSlovak.addTag(westSlavic);

    paleoBalkan = new LanguageFamily("paleo_balkan");
    paleoBalkan.addTag(indoEu);

    albanian = new LanguageFamily("albanian");
    albanian.addTag(paleoBalkan);

    germanic = new LanguageFamily("germanic");
    germanic.addTag(indoEu);

    westGermanic = new LanguageFamily("west_germanic");
    westGermanic.addTag(germanic);

    northGermanic = new LanguageFamily("north_germanic");
    northGermanic.addTag(germanic);

    eastScandinavian = new LanguageFamily("east_scandinavian");
    eastScandinavian.addTag(northGermanic);

    westScandinavian = new LanguageFamily("west_scandinavian");
    westScandinavian.addTag(northGermanic);

    english = new LanguageFamily("english");
    english.addTag(westGermanic);

    highGerman = new LanguageFamily("high_german");
    highGerman.addTag(westGermanic);

    lowFrankish = new LanguageFamily("low_frankish");
    lowFrankish.addTag(westGermanic);

    celtic = new LanguageFamily("celtic");
    celtic.addTag(indoEu);

    goidelic = new LanguageFamily("goidelic");
    goidelic.addTag(celtic);

    greek = new LanguageFamily("greek");
    greek.addTag(indoEu);

    italic = new LanguageFamily("italic");
    italic.addTag(indoEu);

    romance = new LanguageFamily("romance");
    romance.addTag(italic);

    westernRomance = new LanguageFamily("western_romance");
    westernRomance.addTag(romance);

    easternRomance = new LanguageFamily("eastern_romance");
    easternRomance.addTag(romance);

    italoDalmatian = new LanguageFamily("italo_dalmatian");
    italoDalmatian.addTag(romance);

    galloRomance = new LanguageFamily("gallo_romance");
    galloRomance.addTag(westernRomance);

    iberianRomance = new LanguageFamily("iberian_romance");
    iberianRomance.addTag(westernRomance);

    finnoUgric = new LanguageFamily("finno_ugric");
    finnoUgric.addTag(uralic);

    ugric = new LanguageFamily("ugric");
    ugric.addTag(finnoUgric);

    finnoPermic = new LanguageFamily("finno_permic");
    finnoPermic.addTag(finnoUgric);

    baltoFinnic = new LanguageFamily("balto_finnic");
    baltoFinnic.addTag(finnoPermic);

    semitic = new LanguageFamily("semitic");
    semitic.addTag(afroasiatic);
  }

  @Test
  public void print() {
    log.info("\t{}\t{}\t{}", turkic.getId(), turkic.getName(), null);
    log.info("\t{}\t{}\t{}", afroasiatic.getId(), afroasiatic.getName(), null);
    log.info("\t{}\t{}\t{}", semitic.getId(), semitic.getName(), semitic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", uralic.getId(), uralic.getName(), null);
    log.info("\t{}\t{}\t{}", finnoUgric.getId(), finnoUgric.getName(), finnoUgric.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", ugric.getId(), ugric.getName(), ugric.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", finnoPermic.getId(), finnoPermic.getName(), finnoPermic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", baltoFinnic.getId(), baltoFinnic.getName(), baltoFinnic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", baltoSlav.getId(), baltoSlav.getName(), baltoSlav.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", indoEu.getId(), indoEu.getName(), null);
    log.info("\t{}\t{}\t{}", baltoSlav.getId(), baltoSlav.getName(), baltoSlav.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", slavic.getId(), slavic.getName(), slavic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", eastSlavic.getId(), eastSlavic.getName(), eastSlavic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", westSlavic.getId(), westSlavic.getName(), westSlavic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", lechitic.getId(), lechitic.getName(), lechitic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", czechSlovak.getId(), czechSlovak.getName(), czechSlovak.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", southSlavic.getId(), southSlavic.getName(), southSlavic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", southESlavic.getId(), southESlavic.getName(), southESlavic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", southWSlavic.getId(), southWSlavic.getName(), southWSlavic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", baltic.getId(), baltic.getName(), baltic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", eastBaltic.getId(), eastBaltic.getName(), eastBaltic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", westBaltic.getId(), westBaltic.getName(), westBaltic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", paleoBalkan.getId(), paleoBalkan.getName(), paleoBalkan.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", albanian.getId(), albanian.getName(), albanian.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", germanic.getId(), germanic.getName(), germanic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", westGermanic.getId(), westGermanic.getName(), westGermanic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", northGermanic.getId(), northGermanic.getName(), northGermanic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", eastScandinavian.getId(), eastScandinavian.getName(), eastScandinavian.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", westScandinavian.getId(), westScandinavian.getName(), westScandinavian.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", english.getId(), english.getName(), english.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", highGerman.getId(), highGerman.getName(), highGerman.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", lowFrankish.getId(), lowFrankish.getName(), lowFrankish.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", celtic.getId(), celtic.getName(), celtic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", goidelic.getId(), goidelic.getName(), goidelic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", greek.getId(), greek.getName(), greek.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", italic.getId(), italic.getName(), italic.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", romance.getId(), romance.getName(), romance.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", westernRomance.getId(), westernRomance.getName(), westernRomance.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", easternRomance.getId(), easternRomance.getName(), easternRomance.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", italoDalmatian.getId(), italoDalmatian.getName(), italoDalmatian.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", galloRomance.getId(), galloRomance.getName(), galloRomance.getTags().get(0).getUuid());
    log.info("\t{}\t{}\t{}", iberianRomance.getId(), iberianRomance.getName(), iberianRomance.getTags().get(0).getUuid());
  }
}
