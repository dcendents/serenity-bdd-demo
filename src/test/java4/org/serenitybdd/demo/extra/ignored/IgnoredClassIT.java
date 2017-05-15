package org.serenitybdd.demo.extra.ignored;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;

@Narrative(text = { "User Story narrative."})
@RunWith(SerenityRunner.class)
@Ignore
public class IgnoredClassIT {

	@Test
	public void testing_ignored_class_test1() {
		then(true).isFalse();
	}

	@Test
	public void testing_ignored_class_test2() {
		then(true).isFalse();
	}
}
