package es.deusto.ingenieria.is.hanoi.formulation;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class MoveDisk extends Operator{

	private int peg1;
	private int peg2;

	public MoveDisk(int peg1, int peg2){
		this.peg1 = peg1;
		this.peg2 = peg2;
		this.setName("Moving the disk from "+ peg1 + " to "+ peg2);
	}
	
	@Override
	protected State effect(State state) {
		HanoiEnvironment newEnv = ((HanoiEnvironment) state).clone();
		newEnv.moveDisk(peg1, peg2);
		return newEnv;
	}


	@Override
	protected boolean isApplicable(State state) {
		HanoiEnvironment env = (HanoiEnvironment) state;
		
		if(env.getPegs().get(peg1).getDisks().size() != 0) {

			return (env.getPegs().get(peg2).getFirstDisk().isBigger(env.getPegs().get(peg1).getFirstDisk()) || 
					env.getPegs().get(peg2).getFirstDisk().getSize() == 0);
			
		}
		if(env.getPegs().get(peg1).getDisks().size() == 0) {
			return false;
		}
		else {
			return false;
		}
	}
		
		
		//CODE ANTERIOR CON PEGS EN VEZ DE DISKS
//		if(peg1.getDisks().size()!= 0 && peg2.getDisks().size()!=0){
//			return !(peg1.getFirstDisk().isBigger(peg2.getFirstDisk()));
//		}
//		if(peg1.getDisks().size() == 0){
//			return false;
//		}
//		if(peg2.getDisks().size() == 0) {
//			return true;
//		}
//		else{
//			return false;
//		}
//		
//	}
//
}
