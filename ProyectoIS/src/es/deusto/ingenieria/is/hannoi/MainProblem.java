package es.deusto.ingenieria.is.hannoi;

import es.deusto.ingenieria.is.hannoi.formulation.Disk;
import es.deusto.ingenieria.is.hannoi.formulation.HannoiEnvironment;
import es.deusto.ingenieria.is.hannoi.formulation.HannoiProblem;
import es.deusto.ingenieria.is.hannoi.formulation.MoveDisk;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;

public class MainProblem {

	static private final int NUMBER_PEGS = 4;
	static private final int NUMBER_DISKS = 3;
	static private final int TARGET_PEG = NUMBER_PEGS-1;

	public static void main(String[] args) {
		HannoiProblem problem = new HannoiProblem(NUMBER_PEGS, NUMBER_DISKS, 2);
		HannoiEnvironment environment = (HannoiEnvironment) problem.gatherInitialPercepts();
		environment.getPegs().get(TARGET_PEG);
		environment.getPegs().get(0).addDisk(new Disk(2));
		environment.getPegs().get(0).addDisk(new Disk(1));

		problem.addInitialState(environment);

		MoveDisk movement1 = new MoveDisk(environment.getPegs().get(0), environment.getTarget());
		if (movement1.isApplicable(environment)) {
			environment = (HannoiEnvironment) movement1.effect(environment);
		} else {
			
		}

		MoveDisk movement2 = new MoveDisk( environment.getTarget(),environment.getPegs().get(1));
		if (movement2.isApplicable(environment)) {
			environment = (HannoiEnvironment) movement2.effect(environment);
		} else {
			
		}

		MoveDisk movement3 = new MoveDisk(environment.getPegs().get(1), environment.getTarget());
		if (movement3.isApplicable(environment)) {
			environment = (HannoiEnvironment) movement3.effect(environment);
		} else {
			
		}

		
		if (problem.isFinalState(environment))
			System.out.println("Problem solved");
		else
			System.out.println("Problem failed");

		System.out.println(environment.toString());
		

	}
}
