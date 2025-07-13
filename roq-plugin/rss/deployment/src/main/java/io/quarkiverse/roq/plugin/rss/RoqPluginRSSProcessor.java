package io.quarkiverse.roq.plugin.rss;

import java.util.List;

import org.jboss.logging.Logger;

import io.quarkiverse.roq.frontmatter.deployment.data.RoqFrontMatterTemplateBuildItem;
import io.quarkiverse.roq.frontmatter.runtime.config.RoqSiteConfig;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.annotations.Produce;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.pkg.builditem.ArtifactResultBuildItem;

public class RoqPluginRSSProcessor {

    private static final Logger LOGGER = Logger.getLogger(RoqPluginRSSProcessor.class);

    private static final String FEATURE = "roq-plugin-rss";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @Produce(ArtifactResultBuildItem.class)
    @BuildStep
    public void processTemplates(
            final RoqSiteConfig config,
            final List<RoqFrontMatterTemplateBuildItem> templates) {
        LOGGER.info("Config=" + config);

        for (final var template : templates) {
            LOGGER.info(String.format("Template name=%s", template.raw().id()));
        }

    }

}
