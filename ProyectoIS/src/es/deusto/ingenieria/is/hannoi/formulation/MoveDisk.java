package es.deusto.ingenieria.is.hannoi.formulation;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class MoveDisk extends Operator{

	private Peg peg1;
	private Peg peg2;

	public MoveDisk(Peg peg1, Peg peg2){
		this.peg1 = peg1;
		this.peg2 = peg2;
		this.setName("Moving the disk from "+ peg1.toString() + " to "+ peg2.toString());
	}
	
	@Override
	public State effect(State state) {
		HannoiEnvironment newEnv = (HannoiEnvironment) ((HannoiEnvironment)state).clone();
		newEnv.moveDisk(peg1, peg2);
		return newEnv;
	}


	@Override
	public boolean isApplicable(State state) {
		if(peg1.getDisks().size()!= 0 && peg2.getDisks().size()!=0){
			return !(peg1.getFirstDisk().isBigger(peg2.getFirstDisk()));
		}
		if(peg2.getDisks().size() == 0){
			return true;
		}
		if(peg1.getDisks().size() == 0) {
			return false;
		}
		else{
			return false;
		}
		
	}

}
