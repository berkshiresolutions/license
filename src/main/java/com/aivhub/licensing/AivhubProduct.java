package com.aivhub.licensing;

import java.util.function.Supplier;

import org.eclipse.passage.lic.api.LicensedProduct;
import org.eclipse.passage.lic.base.BaseLicensedProduct;

public final class AivhubProduct implements Supplier<LicensedProduct> {

	@Override
	public LicensedProduct get() {
		// FIXME: AF: read from manifest?
		String product = "com.aivhub.license";
		String version = "1.0.0";
		return new BaseLicensedProduct(product, version);
	}

}
