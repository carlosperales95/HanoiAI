package es.deusto.ingenieria.is.hanoi.formulation;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiEnvironment extends State {

		private List<Peg> pegs;
		private Peg target;
		static int targetPeg;
		
		public HanoiEnvironment(int numPegs, int target) {
			this.pegs = new ArrayList<>();
			for (int i = 0; i < numPegs; i++) {
				pegs.add(new Peg(i));
			}
			for (int i = 3; i > 0 ; i--) {
				pegs.get(0).addDisk(new Disk(i));
			}
			targetPeg = target;
			this.target = getPegs().get(target);
		}

		public List<Disk> getDisks(Peg peg) {
			return peg.getDisks();
		}
		
		public List<Peg> getPegs() {
			return this.pegs;
		}
		public Peg getTarget(){
			return this.target;
		}
		public void setTarget(int target){
			this.target=getPegs().get(target);
		}
		
		
		public int getTargetsNumbDisks(){
			return target.getNumberOfDisks();
		}

		public void moveDisk(Peg peg, Peg peg2){
			peg2.addDisk(peg.getFirstDisk());
			peg.removeFirstDisk();
		}

		@Override
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof HanoiEnvironment) {
				List<Peg> auxHannoi = ((HanoiEnvironment) obj).getPegs();
				for (Peg peg : auxHannoi)
					for (Peg peg2 : pegs)
						if (!peg2.equals(peg))
							return false;
				return true;
			} else
				return false;
		}

		@Override
		public String toString() {
			String result = "";
			for (Peg peg : pegs) {
				result += "|-";
					for (Disk Disk : peg.getDisks()) {
						result += Disk.getSize(); 	
					}
				result += "\n\n";
			}
			return result;
		}
		
		
		@Override
		public HanoiEnvironment clone() {
			HanoiEnvironment newEnv = new HanoiEnvironment(this.pegs.size(), targetPeg);
			for (int i = 0; i < this.pegs.size(); i++) {
				newEnv.pegs.get(i).setDisks(this.pegs.get(i).getDisks());
			}
			newEnv.target = this.target;
			return newEnv;
		}
}
