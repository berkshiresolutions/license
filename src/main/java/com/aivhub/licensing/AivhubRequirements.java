package com.aivhub.licensing;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.passage.lic.api.ServiceInvocationResult;
import org.eclipse.passage.lic.api.registry.StringServiceId;
import org.eclipse.passage.lic.api.requirements.Requirement;
import org.eclipse.passage.lic.api.requirements.ResolvedRequirements;
import org.eclipse.passage.lic.api.restrictions.RestrictionLevel;
import org.eclipse.passage.lic.base.BaseServiceInvocationResult;
import org.eclipse.passage.lic.base.requirements.BaseRequirement;

final class AivhubRequirements implements ResolvedRequirements {

	@Override
	public StringServiceId id() {
		return new StringServiceId("aivhub");
	}

	@Override
	public ServiceInvocationResult<Collection<Requirement>> all() {
		// FIXME: AF: we can either hard code them here or read from some config
		Collection<Requirement> all = new ArrayList<>();
		all.add(new BaseRequirement(//
				new AivhubFeatures().typeDs(), //
				new RestrictionLevel.Warning(), //
				this));
		all.add(new BaseRequirement(//
				new AivhubFeatures().typeDash(), //
				new RestrictionLevel.Error(), //
				this));
		all.add(new BaseRequirement(//
				new AivhubFeatures().typeReport(), //
				new RestrictionLevel.Error(), //
				this));
		return new BaseServiceInvocationResult<Collection<Requirement>>(all);
	}

}
