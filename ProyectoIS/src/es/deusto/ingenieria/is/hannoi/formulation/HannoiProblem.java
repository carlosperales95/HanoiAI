package es.deusto.ingenieria.is.hannoi.formulation;


import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class HannoiProblem extends Problem{
	private int numPegs;
	private int numDisks;
	private int targetPeg;

	public HannoiProblem(int numPegs, int numDisks, int targetPeg){
		this.numPegs = numPegs;
		this.numDisks = numDisks;
		this.targetPeg = targetPeg;
		this.createOperators();
	}

	protected void createOperators(){
		for (int i = 0; i < this.numPegs; i++) {
			for (int j = 0; j < this.numPegs; j++) {
				if(i!=j){
					this.addOperator(new MoveDisk(new Peg(i), new Peg(j)));
				}
			}
		}
	}	
	
	 @Override
	public boolean isFinalState(State state){
		if(state != null && state instanceof HannoiEnvironment){
			HannoiEnvironment hannoiEnv = (HannoiEnvironment)state;
			if(hannoiEnv.getTargetsNumbDisks()==  numDisks) return true;	
			else return false;
		}
		return false;
	}
	 
	@Override
	public State gatherInitialPercepts() {
		return new HannoiEnvironment(numPegs, targetPeg);
	}
	
}
