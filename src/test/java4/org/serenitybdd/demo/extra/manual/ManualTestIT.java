package org.serenitybdd.demo.extra.manual;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Narrative;

@Narrative(text = { "This is a good place to describe steps for the manual test",
		"1- Open the page...",
		"2- Go to tab ...",
		"3- etc."})
@RunWith(SerenityRunner.class)
public class ManualTestIT {

	@Test
	@Manual
	public void testing_manual_test() {
		then(true).isFalse();
	}
}
