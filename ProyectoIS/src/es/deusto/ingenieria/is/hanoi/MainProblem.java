package es.deusto.ingenieria.is.hanoi;

import java.util.List;

import es.deusto.ingenieria.is.hanoi.formulation.Disk;
import es.deusto.ingenieria.is.hanoi.formulation.HanoiEnvironment;
import es.deusto.ingenieria.is.hanoi.formulation.HanoiProblem;
import es.deusto.ingenieria.is.hanoi.formulation.HillClimbingAlgorithm;
import es.deusto.ingenieria.is.hanoi.formulation.MoveDisk;
import es.deusto.ingenieria.is.hanoi.formulation.heuristics.HanoiEvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;

public class MainProblem {

	static private final int NUMBER_PEGS = 3;
	static private final int NUMBER_DISKS = 3;
	static private final int TARGET_PEG = NUMBER_PEGS -1; // The peg at the right is the default target

	public static void main(String[] args) {

		//Creating the problem with the specified values
		HanoiProblem problem = new HanoiProblem(NUMBER_PEGS, NUMBER_DISKS, TARGET_PEG);
		HanoiEnvironment environment = (HanoiEnvironment) problem.gatherInitialPercepts();
		

		//Adding 3 disks to the left peg
		//		environment.getPegs().get(0).addDisk(new Disk(3));
		//		environment.getPegs().get(0).addDisk(new Disk(2));
		//		environment.getPegs().get(0).addDisk(new Disk(1));
		System.out.println("Initial state: "+environment);
		problem.addInitialState(environment);
//		System.out.println("ANTES DEL MOVIMIENTO");
//
//		MoveDisk movementTry = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(1));
//		
//		HanoiEnvironment copiedEnvironment = (HanoiEnvironment) movementTry.effect(environment);
//		
//		System.out.println("Original environment : \n"+ environment);                                                                            
//		
//		System.out.println("Copied Environment \n" + copiedEnvironment);
//
//
//		System.out.println("DESPUES DEL MOVIMIENTO");
//
//		HanoiEnvironment copiedEnvironment2 = environment.clone();
//
//		System.out.println("Original Environment \n" + environment);
//
//		System.out.println("Copied Environment \n" + copiedEnvironment);
//
//		System.out.println("Resultado del effect : \n" + copiedEnvironment2);
//
//		MoveDisk movement1 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
//		System.out.println(movement1);
//		if (movement1.isApplicable(environment)) {
//			System.out.println("Correct Move");
//			copiedEnvironment = (HanoiEnvironment) movement1.effect(environment);
//		} else {
//			System.out.println("Wrong move");
//		}


		//		MoveDisk movement2 = new MoveDisk( environment.getPegs().get(0),environment.getPegs().get(1));
		//		System.out.println(movement2);
		//		if (movement2.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement2.effect(environment);
		//		} else {
		//			System.out.println("Wrong move");
		//		}
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement3 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
		//		System.out.println(movement3);
		//		if (movement3.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement3.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//		
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement4 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
		//		System.out.println(movement4);
		//		if (movement4.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement4.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//		
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement5 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(1));
		//		System.out.println(movement5);
		//		if (movement5.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement5.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement6 = new MoveDisk(environment.getPegs().get(2), environment.getPegs().get(1));
		//		System.out.println(movement6);
		//		if (movement6.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement6.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement7 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
		//		System.out.println(movement7);
		//		if (movement7.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement7.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement8 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(0));
		//		System.out.println(movement8);
		//		if (movement8.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement8.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement9 = new MoveDisk(environment.getPegs().get(1), environment.getPegs().get(2));
		//		System.out.println(movement9);
		//		if (movement9.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement9.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//
		//		System.out.println(environment.toString());
		//		
		//		MoveDisk movement10 = new MoveDisk(environment.getPegs().get(0), environment.getPegs().get(2));
		//		System.out.println(movement10);
		//		if (movement10.isApplicable(environment)) {
		//			System.out.println("Correct move");
		//			environment = (HanoiEnvironment) movement10.effect(environment);
		//		} else {
		//			System.out.println("Wrong move.");
		//		}
		//
		//		
		////		if (problem.isFinalState(environment))
		////			System.out.println("SUCCESS");
		////		else
		////			System.out.println("FAILURE");

		//		System.out.println(problem.toString());
		//		System.out.println(problem.getInitialStates().get(0));

		// This code is for the 3rd derivable

//		problem.solve(new BestFS(new HanoiEvaluationFunction()));
		problem.solve(new HillClimbingAlgorithm(new HanoiEvaluationFunction()));
//		problem.solve(DepthFS.getInstance());
//			lista.remove(lista.size()-1);
//		for (Node node : lista) {
//			System.out.println(node.toString());
//		}
		//



	}


}
