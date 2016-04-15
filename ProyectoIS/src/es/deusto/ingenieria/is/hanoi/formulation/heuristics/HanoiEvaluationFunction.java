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

	@Override
	public double calculateH(Node node) {
		HanoiProblemReduced problem = new HanoiProblemReduced(3, 3, 2);
		HanoiEnvironment environment = (HanoiEnvironment) node.getState();	
		problem.addInitialState(environment);
		return problem.solve(BreadthFS.getInstance());
	}
}
