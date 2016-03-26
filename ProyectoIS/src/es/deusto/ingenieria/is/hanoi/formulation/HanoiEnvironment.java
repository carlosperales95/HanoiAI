package es.deusto.ingenieria.is.hanoi.formulation;

import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.is.search.formulation.State;

public class HanoiEnvironment extends State implements Cloneable {

		private List<Peg> pegs;
		private Peg target;
		private int numberDisks;
		static int targetPeg;
		
		public HanoiEnvironment(int numPegs, int target, int numberDisks) {
			this.pegs = new ArrayList<>();
			for (int i = 0; i < numPegs; i++) {
				pegs.add(new Peg(i));
			}
			for (int i = numberDisks; i > 0 ; i--) {
				pegs.get(0).addDisk(new Disk(i));
			}
			targetPeg = target;
			this.numberDisks = numberDisks;
			this.target = getPegs().get(target);
		}

		public HanoiEnvironment() {
			pegs = new ArrayList<>();
			target = null;
			numberDisks = 0;
			targetPeg = 0;
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
			return pegs.get(target.getPosition()).getNumberOfDisks();
		}

		public void moveDisk(int peg,int peg2){
			pegs.get(peg2).addDisk(pegs.get(peg).getFirstDisk());
			pegs.get(peg).removeFirstDisk();
		}
		
		public int getDisks(){
			return numberDisks;
		}

		@Override
		public boolean equals(Object obj) {
			boolean bool = true;
			if (obj != null && obj instanceof HanoiEnvironment) {
				List<Peg> auxHanoi = ((HanoiEnvironment) obj).getPegs();
				for (int i = 0; i < this.pegs.size(); i++) {
					if(!(auxHanoi.get(i).getDisks().equals(this.getPegs().get(i).getDisks()))){
						bool = false;
					}
				}
			}
			return bool;
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
			HanoiEnvironment newEnvironment = new HanoiEnvironment();
			for (Peg peg : pegs) {
				newEnvironment.getPegs().add(peg.clone());
			}
			newEnvironment.target = this.target;
			return newEnvironment;
		
		}
}
