

public class Master {
	
	/**
	 * �������Ʒ���
	 * @param pet
	 */
	public void cure(Pet pet){
		if(pet.getHealth()<50){
			pet.toHospital();
			pet.setHealth(60);
			if(pet instanceof Bird){
				Bird bird=(Bird)pet;
				bird.run();
			}else if(pet instanceof Dog){
				Dog dog=(Dog)pet;
				dog.run();
			}
		}
	}

}
