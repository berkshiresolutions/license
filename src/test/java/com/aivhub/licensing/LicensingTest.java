package com.aivhub.licensing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.passage.lic.api.LicensedProduct;
import org.eclipse.passage.lic.base.io.LicensingFolder;
import org.eclipse.passage.lic.base.io.PathFromLicensedProduct;
import org.eclipse.passage.lic.base.io.UserHomePath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.aivhub.Dashboard;
import com.aivhub.Documents;
import com.aivhub.Master;

public class LicensingTest {

	@BeforeAll
	public static void copyLicenseToHome() throws IOException {
		String licen = "b244d30f-76f2-479f-878f-b8301e84a702.licen";
		LicensedProduct product = new AivhubProduct().get();
		Path from = Paths.get(System.getProperty("user.dir"), "licensing", "issued", product.identifier(),
				product.version(), licen);
		Path to = new PathFromLicensedProduct(//
				new LicensingFolder(new UserHomePath()), //
				product).get().resolve(licen);
		Files.deleteIfExists(to);
		Files.createDirectories(to.getParent());
		Files.copy(from, to);
	}

	@Test
	public void testDocuments() {
		System.out.print("Check that type report is allowed by evaluation license ... ");
		assertEquals(3, new Documents().hello().size());
		System.out.println("success!");
	}

	@Test
	public void testDashboard() {
		System.out.print("Check that type dash is not allowed by evaluation license ... ");
		assertEquals(0, new Dashboard().hello().size());
		System.out.println("success!");
	}

	@Test
	public void testMasterNoLicense() {
		System.out.print("Check that type ds is not restricted by configuration ... ");
		assertEquals(3, new Master().hello().size());
		System.out.println("success!");
	}
}
