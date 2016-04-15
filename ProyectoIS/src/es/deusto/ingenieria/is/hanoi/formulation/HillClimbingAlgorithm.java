package es.deusto.ingenieria.is.hanoi.formulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.heuristic.HeuristicSearchMethod;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HillClimbingAlgorithm extends HeuristicSearchMethod{


	/**
	 * Constructor method.
	 * @param function evaluation function to be used by Best First Search.
	 */
	public HillClimbingAlgorithm(EvaluationFunction function) {
		// TODO Auto-generated constructor stub
		super(function);
	}
	
	public Node search(Problem problem, State initialState) {
		//A list to keep the nodes generated during the search process.
//		List<Node> frontier = new ArrayList<Node>();
		//List of states generated during the search process. This is used to check for repeated states.
		List<State> generatedStates = new ArrayList<State>();
		//List of states expended during the search process. This is used to check for repeated states.
		List<State> expandedStates = new ArrayList<State>();
		//First node in the list of generated nodes.
		Node firstNode = null;
		//successor nodes list.
		List<Node> successorNodes = null;
		//Flag that signals whether a solution has been found.
		boolean solutionFound = false;	

//		Node bestFound = new Node(initialState);
		Node bestSuccessor = new Node(initialState);
		firstNode = new Node(initialState);

		//Loop until the problem is solved or the generated nodes list is empty
		while (!solutionFound) {			
			
			if (problem.isFinalState(bestSuccessor.getState())) {
				//change the flag to signal that the problem is solved
				solutionFound = true;
			//If the first node doesn't contain a problem's final state				
			} else {
				//Expand the first node.
				successorNodes = this.expand(bestSuccessor, problem, generatedStates, expandedStates);
				//If new successor nodes resulted from the expansion
				for (Node node : successorNodes) {
					if (this.getEvaluationFunction().calculateH(bestSuccessor) >= this.getEvaluationFunction().calculateH(node)) {
						bestSuccessor = node;
//						System.out.println("BestSuccessor encontrado: \n"+bestSuccessor.toString());
					}
				}
			}
			if(successorNodes.isEmpty())
				break;
		}
		
		// If the problem is solved
		if (solutionFound) {
			//Return the first node as it contains the problem's final state
			return firstNode;
		//If the problem is not solved
		} else {
			//return null
			return null;
		}
	}

	protected List<Node> expand(Node node, Problem problem, List<State> generatedStates, List<State> expandedStates) {
		List<Node> successorNodes = new ArrayList<Node>();
		Node successorNode = null;
		State currentState = null;
		State successorState = null;
		
		//If the current node and problem aren't null
		if (node != null && problem != null) {
			//Make the current state the state kept in the node.
			currentState = node.getState();
			//Remove current state from the list of generated states.
			generatedStates.remove(currentState);
			//Insert current state to the list of generated states.
			expandedStates.add(currentState);			
			//If current state is not null
			if (currentState != null) {
				//process the list of problem operators
				for (Operator operator : problem.getOperators()) {
					//Apply the operator to the current state
					successorState = operator.apply(currentState);
					//If the operator was applicable, a new successor state was generated
					if (successorState != null) {
						//If the new node hadn't been generated before nor expanded
						if (!generatedStates.contains(successorState) && !expandedStates.contains(successorState)) {
							//make a new node to keep the new successor state
							successorNode = new Node(successorState);
							//Set values for the various node's attributes
							successorNode.setOperator(operator.getName());
							successorNode.setParent(node);
							successorNode.setDepth(node.getDepth() + 1);
							//evaluation function = heuristic function
							successorNode.setH(this.getEvaluationFunction().calculateH(successorNode));
							//Add the new node to the list of successor nodes.
							successorNodes.add(successorNode);
							//Insert current successor State to the list of generated states
							generatedStates.add(successorState);
						}
					}
				}
			}
		}
		
		return successorNodes;
	}
}

