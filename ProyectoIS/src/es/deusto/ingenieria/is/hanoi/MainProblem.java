package es.deusto.ingenieria.is.hanoi;

import es.deusto.ingenieria.is.hanoi.formulation.Disk;
import es.deusto.ingenieria.is.hanoi.formulation.HanoiEnvironment;
import es.deusto.ingenieria.is.hanoi.formulation.HanoiProblem;
import es.deusto.ingenieria.is.hanoi.formulation.MoveDisk;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;

public class MainProblem {

	static private final int NUMBER_PEGS = 3;
	static private final int NUMBER_DISKS = 3;
	static private final int TARGET_PEG = NUMBER_PEGS -1; //The default target is the one on the far right

	public static void main(String[] args) {
		
		//Creating the problem with the specified values
		HanoiProblem problem = new HanoiProblem(NUMBER_PEGS, NUMBER_DISKS, TARGET_PEG);
		HanoiEnvironment environment = (HanoiEnvironment) problem.gatherInitialPercepts();

		//Adding 3 disks to the left peg
//		environment.getPegs().get(0).addDisk(new Disk(3));
//		environment.getPegs().get(0).addDisk(new Disk(2));
//		environment.getPegs().get(0).addDisk(new Disk(1));

		problem.addInitialState(problem.gatherInitialPercepts());
//		System.out.println(problem.gatherInitialPercepts());
		HanoiEnvironment copiedEnvironment = environment.clone();
		
		MoveDisk movementTry = new MoveDisk(copiedEnvironment.getPegs().get(0), copiedEnvironment.getPegs().get(1));
		
		System.out.println("Original Environment \n" + environment);
		
		System.out.println("Copied Environment \n" + copiedEnvironment);
		
		
		movementTry.effect(copiedEnvironment);
		
		System.out.println("Original Environment \n" + environment);
		
		System.out.println("Copied Environment \n" + copiedEnvironment);
		
////		MoveDisk movement1 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
////		System.out.println(movement1);
////		if (movement1.isApplicable(environment)) {
////			System.out.println("Correct Move");
////			environment = (HannoiEnvironment) movement1.effect(environment);
////		} else {
////			System.out.println("Wrong move");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement2 = new MoveDisk( environment.getPegs().get(0),environment.getPegs().get(1));
////		System.out.println(movement2);
////		if (movement2.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement2.effect(environment);
////		} else {
////			System.out.println("Wrong move");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement3 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
////		System.out.println(movement3);
////		if (movement3.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement3.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////		
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement4 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
////		System.out.println(movement4);
////		if (movement4.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement4.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////		
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement5 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(1));
////		System.out.println(movement5);
////		if (movement5.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement5.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement6 = new MoveDisk(environment.getPegs().get(2), environment.getPegs().get(1));
////		System.out.println(movement6);
////		if (movement6.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement6.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement7 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
////		System.out.println(movement7);
////		if (movement7.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement7.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement8 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(0));
////		System.out.println(movement8);
////		if (movement8.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement8.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement9 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
////		System.out.println(movement9);
////		if (movement9.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement9.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
////
////		System.out.println(environment.toString());
////		
////		MoveDisk movement10 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
////		System.out.println(movement10);
////		if (movement10.isApplicable(environment)) {
////			System.out.println("Correct move");
////			environment = (HannoiEnvironment) movement10.effect(environment);
////		} else {
////			System.out.println("Wrong move.");
////		}
//
//		
////		if (problem.isFinalState(environment))
////			System.out.println("SUCCESS");
////		else
////			System.out.println("FAILURE");
		
//		System.out.println(problem.toString());
//		System.out.println(problem.getInitialStates().get(0));

		// This code is for the 3rd derivable

		problem.solve(BreadthFS.getInstance());
//

		

	}
	
	
}
