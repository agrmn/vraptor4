package br.com.caelum.vraptor.validator;

import org.junit.Before;
import org.junit.Test;

public class MessagesTest {

	private Messages messages;
	
	@Before
	public void setUp() {
		messages = new Messages();
	}
	
	@Test(expected=IllegalStateException.class)
	public void shouldThrowExceptionIfMessagesHasUnhandledErrors() {
		messages.add(new SimpleMessage("Test", "Test message"));
		messages.assertAbsenceOfErrors();
	}

	@Test
	public void shouldNotThrowExceptionIfMessagesHasNoUnhandledErrors() {
		messages.add(new SimpleMessage("Test", "Test message"));
		messages.handleErrors();
		messages.assertAbsenceOfErrors();
	}
	
	@Test
	public void shouldNotThrowExceptionIfMessagesHasNoErrorsAndHasOtherSeverityMessages() {
		messages.add(new SimpleMessage("Test", "Test warn message", Severity.WARN));
		messages.add(new SimpleMessage("Test", "Test info message", Severity.INFO));
		messages.add(new SimpleMessage("Test", "Test success message", Severity.SUCCESS));
		messages.assertAbsenceOfErrors();
	}

	@Test
	public void shouldNotThrowExceptionIfMessagesHasNoErrors() {
		messages.assertAbsenceOfErrors();
	}
	
}