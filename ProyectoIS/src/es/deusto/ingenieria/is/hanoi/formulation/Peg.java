package es.deusto.ingenieria.is.hanoi.formulation;
import java.util.ArrayList;
import java.util.List;

public class Peg {

	private int position;
	private List<Disk> disks;

	public Peg(int position){
		this.disks = new ArrayList<Disk>();
		this.position = position;
	}

	public int getPosition() {
		return position;
	}
	
	public List<Disk> getDisks(){
		return disks;
	}

	public void setDisks(List<Disk> disks){
		this.disks=disks;
	}
	
	public int getNumberOfDisks(){
		return disks.size();
	}
	
	
	public Disk getFirstDisk(){
		if(disks.size() == 0) {
			return new Disk(0);
		}
		else {
			return disks.get(disks.size() - 1);
			
		}
	}
		
	public void removeFirstDisk(){
		if(disks.size() == 0) {
		}
		else {
			disks.remove(disks.size() - 1);
			
		}
	}
	
	public void addDisk(Disk r){
		disks.add(r);
	}



	public void setPosition(int position) {
		this.position = position;
	}

	


	public String toString(){
		return "Number " +position+" peg";

	}
	
	@Override
	public boolean equals(Object obj){
		if(obj != null && obj instanceof Peg){
			Peg pegAux = (Peg) obj;
			if(this.position == pegAux.position || pegAux.getDisks().equals(this.getDisks())){
					return true;
				}
			else{
				return false;
			}
		}
		return false;
	}
	
	
	@Override
	public Peg clone() {
		Peg newPeg = new Peg(this.position);
		for (Disk disk : disks) {
			newPeg.addDisk(disk.clone());;
		}
		
		return newPeg;
	}
}
