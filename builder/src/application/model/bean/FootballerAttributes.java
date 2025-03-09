package application.model.bean;

public class FootballerAttributes {
	
	private int overallRating;
	private int physicalForm;
	private int mentalClarity;
	private int deployable;

	public FootballerAttributes(int overallRating, int physicalForm, int mentalClarity, int deployable) {
		
		if (overallRating < 0 || overallRating > 100) {
            throw new IllegalArgumentException("Overall rating must be between 0 and 100");
        }
		
        if (physicalForm < 0 || physicalForm > 100) {
            throw new IllegalArgumentException("Physical form must be between 0 and 100");
        }
        
        if (mentalClarity < 0 || mentalClarity > 100) {
            throw new IllegalArgumentException("Mental clarity must be between 0 and 100");
        }
        
        if (deployable != 0 && deployable != 1) {
            throw new IllegalArgumentException("Deployable must be either 0 or 1");
        }
		
		this.overallRating = overallRating;
		this.physicalForm = physicalForm;
		this.mentalClarity = mentalClarity;
		this.deployable = deployable;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	public int getPhysicalForm() {
		return physicalForm;
	}

	public void setPhysicalForm(int physicalForm) {
		this.physicalForm = physicalForm;
	}

	public int getMentalClarity() {
		return mentalClarity;
	}

	public void setMentalClarity(int mentalClarity) {
		this.mentalClarity = mentalClarity;
	}

	public int getDeployable() {
		return deployable;
	}

	public void setDeployable(int deployable) {
		this.deployable = deployable;
	}

	
	
	@Override
	public String toString() {
		return "FootballerAttributes [overallRating=" + overallRating + ", physicalForm=" + physicalForm
				+ ", mentalClarity=" + mentalClarity + ", deployable=" + deployable + "]";
	}
	
	
	
}
