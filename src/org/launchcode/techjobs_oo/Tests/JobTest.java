package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;
    Job test_job5;

    public JobTest() {
        this.test_job1 = test_job1;
        this.test_job2 = test_job2;
    }

    @Before
    public void createJobObject() {
        test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job3 = new Job("Developer", new Employer("Coder Chiefs"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Developer", new Employer("Coder Chiefs"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        test_job5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("") );
    }

    @Test
    public void testSettingJobId(){
//        assertEquals(test_job1.getId(), test_job2.getId(), 1);
        assertFalse(test_job1.equals(test_job2));
        assertTrue(test_job1.getId() != test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
       test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
        assertTrue(test_job3.getEmployer() instanceof Employer);

    }

    @Test
    public void testJobsForEquality() {

        assertFalse(test_job2 == test_job1);
    }

    @Test
    public void testJobOutputBlankAndOwnLines() {
        String string = "\n" + "ID: " + test_job1.getId() + "\nName: " + test_job1.getName() + "\nEmployer: " + test_job1.getEmployer().getValue() + "\nLocation: " + test_job1.getLocation().getValue() + "\nPosition Type: " + test_job1.getPositionType().getValue() + "\nCore Competency: " + test_job1.getCoreCompetency().getValue() + "\n";
        assertEquals(string, test_job1.toString());
    }

    @Test
    public void testJobDataOnOwnLine() {
        String string = "\n" + "ID: " + test_job4.getId() + "\nName: " + test_job4.getName() + "\nEmployer: " + test_job4.getEmployer().getValue() + "\nLocation: " + test_job4.getLocation().getValue() + "\nPosition Type: Data not available" + "\nCore Competency: " + test_job4.getCoreCompetency().getValue() + "\n";
        assertEquals(string, test_job4.toString());
    }

    @Test
    public void testJobHasIdButOtherwiseEmpty() {
        String string = "OOPS! This job does not seem to exist.";
        System.out.println(test_job5.toString());
        assertEquals(string, test_job5.toString());
    }

}
