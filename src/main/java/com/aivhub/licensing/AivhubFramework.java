package com.aivhub.licensing;

import org.eclipse.passage.lic.api.AccessCycleConfiguration;
import org.eclipse.passage.lic.api.Framework;
import org.eclipse.passage.lic.api.LicensedProduct;

final class AivhubFramework implements Framework {

	@Override
	public LicensedProduct product() {
		return new AivhubProduct().get();
	}

	@Override
	public AccessCycleConfiguration accessCycleConfiguration() {
		return new AivhubConfiguration(this::product);
	}

}
