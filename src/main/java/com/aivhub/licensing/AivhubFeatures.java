package com.aivhub.licensing;

import org.eclipse.passage.lic.api.requirements.Feature;
import org.eclipse.passage.lic.base.requirements.BaseFeature;

public final class AivhubFeatures {

	public Feature typeDash() {
		return new BaseFeature(//
				"com.aivhub.license.type.dash", //
				"1.0.0", //
				"AIVHUB Dashboards", //
				"AIVHUB LTD"//
		);
	}

	public Feature typeDs() {
		return new BaseFeature(//
				"com.aivhub.license.type.ds", //
				"1.0.0", //
				"AIVHUB DS", //
				"AIVHUB LTD"//
		);
	}

	public Feature typeReport() {
		return new BaseFeature(//
				"com.aivhub.license.type.report", //
				"1.0.0", //
				"AIVHUB Reports", //
				"AIVHUB LTD"//
		);
	}

}
