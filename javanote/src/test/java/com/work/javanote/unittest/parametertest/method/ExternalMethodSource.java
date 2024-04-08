package com.work.javanote.unittest.parametertest.method;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class ExternalMethodSource {

	static Stream<String> checkExternalMethodSourceArgs() {
		return Stream.of("a1", "b2");
	}
}
