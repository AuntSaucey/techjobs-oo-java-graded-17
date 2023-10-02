package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest extends AbstractTest{
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job instanceof Job);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end Developer"), new CoreCompetency("Java"));
        String jobString = job.toString();
        String newline = System.lineSeparator();
        assertEquals(true, jobString.startsWith(newline));
        assertEquals(true, jobString.endsWith(newline));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end Developer"), new CoreCompetency("Java"));
        String jobString= job.toString();

        assertTrue(jobString.contains("ID: "));
        assertTrue(jobString.contains("Name: Web Developer"));
        assertTrue(jobString.contains("Employer: LaunchCode"));
        assertTrue(jobString.contains("Location: StL"));
        assertTrue(jobString.contains("Position Type: Back-end Developer"));
        assertTrue(jobString.contains("Core Competency: Java"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer("Data not available"), new Location("Data not available"), new PositionType("Data not available"), new CoreCompetency("Java"));
        String jobString = job.toString();


        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
}
 }