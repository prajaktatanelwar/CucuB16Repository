package com.allfilesinsamefolder2;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) // run
@CucumberOptions( features={"src/test/resources/com/allfilesinsamefolder2/MyFirstFeatureFile1.feature:10"},
glue={"com/allfilesinsamefolder2/"}) 


//features={"src/test/resources/com/allfilesinsamefolder/MyFirstFeatureFile.feature:10"},
//glue={"com/allfilesinsamefolder/"}

// how to run the feature file..IF nothing is mentioned in the bracket it will run all the file in the folder.Cucumber is junitest, so use to run the file
public class RunnerFirstFileTest1 { 

}
