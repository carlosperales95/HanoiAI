package es.deusto.ingenieria.is.hannoi;

import es.deusto.ingenieria.is.hannoi.formulation.Disk;
import es.deusto.ingenieria.is.hannoi.formulation.HannoiEnvironment;
import es.deusto.ingenieria.is.hannoi.formulation.HannoiProblem;
import es.deusto.ingenieria.is.hannoi.formulation.MoveDisk;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFSwithLog;

public class MainProblem {

	static private final int NUMBER_PEGS = 4;
	static private final int NUMBER_DISKS = 3;
	static private final int TARGET_PEG = 1;

	public static void main(String[] args) {
		HannoiProblem problem = new HannoiProblem(NUMBER_PEGS, NUMBER_DISKS, TARGET_PEG);
		HannoiEnvironment environment = (HannoiEnvironment) problem.gatherInitialPercepts();
		environment.getTarget().addDisk(new Disk(3));
		environment.getPegs().get(1).addDisk(new Disk(1));
		environment.getPegs().get(0).addDisk(new Disk(2));

		problem.addInitialState(environment);
		System.out.println(environment.toString());

		MoveDisk movement1 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
		System.out.println(movement1);
		if (movement1.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement1.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement2 = new MoveDisk( environment.getPegs().get(0),environment.getPegs().get(1));
		System.out.println(movement2);
		if (movement2.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement2.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement3 = new MoveDisk(environment.getPegs().get(2), environment.getPegs().get(3));
		System.out.println(movement3);
		if (movement3.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement3.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		Node finalNode = DepthFSwithLog.getInstance().search(problem, environment);
		System.out.println(finalNode);

		if (BreadthFS.getInstance().search(problem, environment) != null)
			System.out.println("Problem solved");
		else
			System.out.println("You failed");

//		System.out.println(environment.toString());
		

	}
}
