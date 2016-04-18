package es.deusto.ingenieria.is.hanoi.formulation.heuristics;

import es.deusto.ingenieria.is.hanoi.formulation.HanoiEnvironment;
import es.deusto.ingenieria.is.hanoi.reduced.HanoiProblemReduced;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;

public class HanoiEvaluationFunction extends EvaluationFunction{

	@Override
	public double calculateG(Node node) {
		return 0;

	}

	public double calculateBH1(Node node) {
		HanoiEnvironment environment = (HanoiEnvironment) node.getState();	
		
		return environment.getDisks(environment.getPegs().get(0)).size();
	
	}
	
	public double calculateBH2(Node node) {
		HanoiEnvironment environment = (HanoiEnvironment) node.getState();	
		
		return (environment.getDisks(environment.getPegs().get(0)).size()+environment.getDisks(environment.getPegs().get(1)).size());
	
	}

	@Override
	public double calculateH(Node node) {
		HanoiEnvironment environment = (HanoiEnvironment) node.getState();	
		HanoiProblemReduced problem = new HanoiProblemReduced(environment.getPegs().size(), environment.getDisks(),
				environment.getTarget().getPosition());
		problem.addInitialState(environment);
		return problem.solve(BreadthFS.getInstance());
	}
}
