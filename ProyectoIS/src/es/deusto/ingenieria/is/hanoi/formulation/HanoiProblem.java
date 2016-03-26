package es.deusto.ingenieria.is.hanoi.formulation;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiProblem extends Problem{
	private int numPegs;
	private int numDisks;
	private int targetPeg;

	public HanoiProblem(int numPegs, int numDisks, int targetPeg){
		this.numPegs = numPegs;
		this.numDisks = numDisks;
		this.targetPeg = targetPeg;
		this.createOperators();
	}

	protected void createOperators(){
		for (int i = 0; i < this.numPegs; i++) {
			for (int j = 0; j < this.numPegs; j++) {
				if(i!=j){
					this.addOperator(new MoveDisk(i, j));
				}
			}
		}
	}	
	
	 @Override
	public boolean isFinalState(State state){
		if(state != null && state instanceof HanoiEnvironment){
			HanoiEnvironment hannoiEnv = (HanoiEnvironment)state;
			if(hannoiEnv.getTargetsNumbDisks() ==  numDisks) return true;	
			else return false;
		}
		return false;
	}
	 
	@Override
	public State gatherInitialPercepts() {
		return new HanoiEnvironment(numPegs, targetPeg, numDisks);
	}
	
	public void solve(SearchMethod searchMethod) {		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.S");
		Date beginDate = GregorianCalendar.getInstance().getTime();
		System.out.println("\n* Start '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(beginDate) + ")");				
		
		Node finalNode = searchMethod.search(this, this.gatherInitialPercepts());
		
		Date endDate = GregorianCalendar.getInstance().getTime();		
		System.out.println("* End   '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(endDate) + ")");
		
		long miliseconds = (int) Math.abs(beginDate.getTime() - endDate.getTime());
		long seconds = miliseconds / 1000;
		miliseconds %= 1000;		
		long minutes = seconds / 60;
		seconds %= 60;
		long hours = minutes / 60;
		minutes %= 60;
		
		String time = "* Serach lasts: ";
		time += (hours > 0) ? hours + " h " : " ";
		time += (minutes > 0) ? minutes + " m " : " ";
		time += (seconds > 0) ? seconds + "s " : " ";
		time += (miliseconds > 0) ? miliseconds + "ms " : " ";
		
		System.out.println(time);
		
		if (finalNode != null) {
			System.out.println("\n- Solution found!     :)");
			List<String> operators = new ArrayList<String>();
			searchMethod.solutionPath(finalNode, operators);
			searchMethod.createSolutionLog(operators);			
			System.out.println("- Final state:" + finalNode.getState());
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
	}
	
}
