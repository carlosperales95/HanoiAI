package es.deusto.ingenieria.is.hanoi.formulation.heuristics;

import es.deusto.ingenieria.is.hanoi.formulation.HanoiEnvironment;
import es.deusto.ingenieria.is.hanoi.formulation.Peg;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;

public class HanoiEvaluationFunction extends EvaluationFunction{

	@Override
	public double calculateG(Node node) {
		return 0;
	}

	@Override
	public double calculateH(Node node) {
		HanoiEnvironment environment = (HanoiEnvironment) node.getState();	
		int numeroDiscosNoTarget = 0;
		for (Peg peg : environment.getPegs()) {
			if(!(peg == environment.getTarget()))
			numeroDiscosNoTarget+= peg.getNumberOfDisks();
		}
		return (environment.getTargetsNumbDisks()) ;
	}
}
