package es.deusto.ingenieria.is.hanoi.formulation.heuristics;

import es.deusto.ingenieria.is.hanoi.formulation.HanoiEnvironment;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;

public class HanoiBE2 extends EvaluationFunction {
	
	public double calculateH(Node node) {
		HanoiEnvironment environment = (HanoiEnvironment) node.getState();	
		
		return (environment.getDisks(environment.getPegs().get(0)).size()+environment.getDisks(environment.getPegs().get(1)).size());
	
	}

	@Override
	public double calculateG(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
