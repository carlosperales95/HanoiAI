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

	static private final int NUMBER_PEGS = 3;
	static private final int NUMBER_DISKS = 3;
	static private final int TARGET_PEG = 2;

	public static void main(String[] args) {
		
		//Creating the problem with the specified values
		HannoiProblem problem = new HannoiProblem(NUMBER_PEGS, NUMBER_DISKS, TARGET_PEG);
		HannoiEnvironment environment = (HannoiEnvironment) problem.gatherInitialPercepts();
		
		//Adding 3 disks to the left peg
		environment.getPegs().get(0).addDisk(new Disk(3));
		environment.getPegs().get(0).addDisk(new Disk(2));
		environment.getPegs().get(0).addDisk(new Disk(1));

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
		
		MoveDisk movement3 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
		System.out.println(movement3);
		if (movement3.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement3.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}
		

		System.out.println(environment.toString());
		
		MoveDisk movement4 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
		System.out.println(movement4);
		if (movement4.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement4.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}
		

		System.out.println(environment.toString());
		
		MoveDisk movement5 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(1));
		System.out.println(movement5);
		if (movement5.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement5.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement6 = new MoveDisk(environment.getPegs().get(2), environment.getPegs().get(1));
		System.out.println(movement6);
		if (movement6.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement6.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement7 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
		System.out.println(movement7);
		if (movement7.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement7.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement8 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(0));
		System.out.println(movement8);
		if (movement8.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement8.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement9 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
		System.out.println(movement9);
		if (movement9.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement9.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		System.out.println(environment.toString());
		
		MoveDisk movement10 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
		System.out.println(movement10);
		if (movement10.isApplicable(environment)) {
			System.out.println("It is applicable.");
			environment = (HannoiEnvironment) movement10.effect(environment);
		} else {
			System.out.println("It is not applicable.");
		}

		
		if (problem.isFinalState(environment))
			System.out.println("SUCCESS");
		else
			System.out.println("FAILURE");
		
		
		System.out.println(environment.toString());

		// This code is for the 3rd derivable
//		Node finalNode = DepthFS.getInstance().search(problem, environment);
//		System.out.println(finalNode);
//

//		System.out.println(environment.toString());
		

	}
	
	
}
