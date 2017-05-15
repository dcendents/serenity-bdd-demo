package org.serenitybdd.demo.extra.pending;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Pending;

@Narrative(text = { "User Story narrative."})
@RunWith(SerenityRunner.class)
public class PendingTestIT {

	@Test
	@Pending
	public void testing_pending_test() {
		then(true).isFalse();
	}
}
