package org.serenitybdd.demo.extra.ignored;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;

@Narrative(text = { "User Story narrative."})
@RunWith(SerenityRunner.class)
public class IgnoredTestIT {

	@Test
	@Ignore
	public void testing_ignored_test() {
		then(true).isFalse();
	}
}
