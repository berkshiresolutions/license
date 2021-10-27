package com.aivhub.licensing;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.passage.lic.api.Framework;
import org.eclipse.passage.lic.api.ServiceInvocationResult;
import org.eclipse.passage.lic.base.FrameworkAware;

final class AivhubFrameworkAware implements FrameworkAware {

	private final Framework framework;

	public AivhubFrameworkAware(Framework framework) {
		this.framework = Objects.requireNonNull(framework, "AivhubFrameworkAware::framework");
	}

	@Override
	public <T> ServiceInvocationResult<T> withFrameworkService(Function<Framework, ServiceInvocationResult<T>> invoke) {
		return invoke.apply(framework);
	}

	@Override
	public <T> Optional<T> withFramework(Function<Framework, T> invoke) {
		return Optional.ofNullable(invoke.apply(framework));
	}

}
