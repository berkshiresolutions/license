package com.aivhub.licensing;

import java.util.function.Supplier;

import org.eclipse.passage.lic.api.Passage;
import org.eclipse.passage.lic.base.BasePassage;

public final class AivhubLicensing implements Supplier<Passage> {

	@Override
	public Passage get() {
		return new BasePassage(new AivhubFrameworkAware(new AivhubFramework()));
	}

}
