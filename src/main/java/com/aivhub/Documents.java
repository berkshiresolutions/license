package com.aivhub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aivhub.licensing.AivhubFeatures;
import com.aivhub.licensing.AivhubLicensing;

@Path("/documents")
public class Documents {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String, Object>> hello() {
		// TODO: AF: use "Passage#acquireLicense(String)" to see the diagnostic
		if (!new AivhubLicensing().get().canUse(new AivhubFeatures().typeReport().identifier())) {
			return Collections.emptyList();
		}
		List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
		Map<String, Object> m = new HashMap<String, Object>();

		m.put("name", "Documents 1");
		m.put("type", "report");
		m.put("owner", "Admin");

		lm.add(m);

		m = new HashMap<String, Object>();

		m.put("name", "Documents 2");
		m.put("type", "report");
		m.put("owner", "Admin");

		lm.add(m);

		m = new HashMap<String, Object>();

		m.put("name", "Documents 3");
		m.put("type", "report");
		m.put("owner", "Admin");

		lm.add(m);

		return lm;
	}
}