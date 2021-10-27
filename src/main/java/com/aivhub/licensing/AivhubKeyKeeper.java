package com.aivhub.licensing;

import java.io.InputStream;
import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.passage.lic.api.LicensedProduct;
import org.eclipse.passage.lic.api.LicensingException;
import org.eclipse.passage.lic.api.io.KeyKeeper;
import org.eclipse.passage.lic.base.io.FileNameFromLicensedProduct;
import org.eclipse.passage.lic.base.io.PassageFileExtension;

final class AivhubKeyKeeper implements KeyKeeper {

	private final Supplier<LicensedProduct> product;

	public AivhubKeyKeeper(Supplier<LicensedProduct> product) {
		this.product = Objects.requireNonNull(product, "AivhubKeyKeeper::product");
	}

	@Override
	public LicensedProduct id() {
		return product.get();
	}

	@Override
	public InputStream productPublicKey() throws LicensingException {
		return getClass().getResourceAsStream("/META-INF/licensing/" + keyFile());
	}

	private String keyFile() {
		return new FileNameFromLicensedProduct(product.get(), new PassageFileExtension.PublicKey()).get();
	}

}
