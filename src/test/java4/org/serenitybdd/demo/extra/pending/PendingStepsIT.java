package org.serenitybdd.demo.extra.pending;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.serenitybdd.demo.extra.pending.steps.EmployeePendingSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;

@Narrative(text = { "User Story narrative."})
@RunWith(SerenityRunner.class)
public class PendingStepsIT {

	@Steps
	public EmployeePendingSteps employee;

	@Test
	public void testing_pending_steps() {
		employee.opens_the_search_page();
		employee.searches_for("Let's Rickroll!");
		employee.dares_to_open_page("Let's Rickroll!");
		employee.should_be_reminded_site_is_blocked("Humor");
	}
}
