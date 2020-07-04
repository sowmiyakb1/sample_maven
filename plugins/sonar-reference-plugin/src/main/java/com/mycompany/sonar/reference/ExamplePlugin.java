package com.mycompany.sonar.reference;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;

import com.mycompany.sonar.reference.batch.ExampleSensor;
import com.mycompany.sonar.reference.batch.IssueSensor;
import com.mycompany.sonar.reference.batch.ListAllIssuesPostJob;
import com.mycompany.sonar.reference.batch.RandomDecorator;
import com.mycompany.sonar.reference.ui.ExampleFooter;
import com.mycompany.sonar.reference.ui.ExampleRubyWidget;

/**
 * This class is the entry point for all extensions
 */
@Properties({
  @Property(
    key = ExamplePlugin.MY_PROPERTY,
    name = "Plugin Property",
    description = "A property for the plugin",
    defaultValue = "Hello World!")})
public final class ExamplePlugin extends SonarPlugin {

  public static final String MY_PROPERTY = "sonar.example.myproperty";

  // This is where you're going to declare all your SonarQube extensions
  @Override
  public List getExtensions() {
    return Arrays.asList(
      // Definitions
      ExampleMetrics.class, ExampleRulesDefinition.class,

      // Batch
      ExampleSensor.class, RandomDecorator.class, IssueSensor.class, ListAllIssuesPostJob.class,

      // UI
      ExampleFooter.class, ExampleRubyWidget.class);
  }
}
