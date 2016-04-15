package es.deusto.ingenieria.is.hanoi.reduced;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import es.deusto.ingenieria.is.hanoi.formulation.HanoiEnvironment;
import es.deusto.ingenieria.is.hanoi.formulation.MoveDisk;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiProblemReduced extends Problem{

	private int numPegs;
	private int numDisks;
	private int targetPeg;

	public HanoiProblemReduced(int numPegs, int numDisks, int targetPeg){
		this.numPegs = numPegs;
		this.numDisks = numDisks;
		this.targetPeg = targetPeg;
		this.createOperators();
	}

	protected void createOperators(){
		for (int i = 0; i < this.numPegs; i++) {
			for (int j = 0; j < this.numPegs; j++) {
				if(i!=j){
					this.addOperator(new ReducedMoveDisk(i, j));
				}
			}
		}
	}	

	@Override
	public boolean isFinalState(State state){
		boolean ordenados = true;
		HanoiEnvironment environment = (HanoiEnvironment) state;
		if (environment.getDisks() == environment.getTargetsNumbDisks()){
			for(int i = environment.getDisks() ; i > 0 ; i--){
				if(!(environment.getTarget().getDisks().get(i).getSize() == i )) ordenados = false;
			}
			
		}
		else ordenados = false;
		return ordenados;
	}

	@Override
	public State gatherInitialPercepts() {
		return new HanoiEnvironment(numPegs, targetPeg, numDisks);
	}

	public int solve(SearchMethod searchMethod) {		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.S");
		Date beginDate = GregorianCalendar.getInstance().getTime();
		Node parent = null;
		Node finalNode = searchMethod.search(this, this.gatherInitialPercepts());
		List<Node> listaOperators = new ArrayList<>();
		Date endDate = GregorianCalendar.getInstance().getTime();		

		long miliseconds = (int) Math.abs(beginDate.getTime() - endDate.getTime());
		long seconds = miliseconds / 1000;
		miliseconds %= 1000;		
		long minutes = seconds / 60;
		seconds %= 60;
		long hours = minutes / 60;
		minutes %= 60;

		String time = "* Search lasts: ";
		time += (hours > 0) ? hours + " h " : " ";
		time += (minutes > 0) ? minutes + " m " : " ";
		time += (seconds > 0) ? seconds + "s " : " ";
		time += (miliseconds > 0) ? miliseconds + "ms " : " ";


		if (finalNode != null) {
			List<String> operators = new ArrayList<String>();
			searchMethod.solutionPath(finalNode, operators);
			listaOperators.add(finalNode);
			parent = finalNode;
			while(parent != null) {
				if(parent !=null){
					listaOperators.add(parent.getParent());
					parent = parent.getParent();
				}
			}

			searchMethod.createSolutionLog(operators);			
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
		return listaOperators.size();
	}

}
