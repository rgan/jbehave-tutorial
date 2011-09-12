package com.thoughtworks.calc;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.List;

import static java.util.Arrays.asList;

public class StoryRunner extends JUnitStories {

    private FirefoxDriverProvider firefoxDriverProvider = new FirefoxDriverProvider();
    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
                // where to find the stories
                .useStoryLoader(new LoadFromClasspath(this.getClass().getClassLoader()))
                        // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats()
                        .withFormats(StoryReporterBuilder.Format.CONSOLE, StoryReporterBuilder.Format.TXT));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(),
                new CalculatorSteps(), new GoogleSteps(), new WebSteps(firefoxDriverProvider), new BeforeAndAfterSteps(firefoxDriverProvider)).createCandidateSteps();
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
                asList("**/*.story"), null);
    }

}
