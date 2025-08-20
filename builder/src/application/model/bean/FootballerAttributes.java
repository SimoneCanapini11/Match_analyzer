package application.model.bean;

public class FootballerAttributes {
	
	private int overallRating;
	private int physicalForm;
	private int mentalClarity;
	private int deployable;

	public FootballerAttributes(int overallRating, int physicalForm, int mentalClarity, int deployable) {
		  
        validateRating("Overall rating", overallRating);
        validateRating("Physical form", physicalForm);
        validateRating("Mental clarity", mentalClarity);
        validateDeployable(deployable);
		
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
	
	 private void validateRating(String fieldName, int value) {
	        if (value < 0 || value > 100) {
	            throw new IllegalArgumentException(
	                fieldName + " must be between 0 and 100");
	        }
	    }
	    
	    private void validateDeployable(int deployable) {
	        if (deployable != 0 && deployable != 1) {
	            throw new IllegalArgumentException(
	                "Deployable must be either 0 or 1");
	        }
	    }

	
	
	@Override
	public String toString() {
		return "FootballerAttributes [overallRating=" + overallRating + ", physicalForm=" + physicalForm
				+ ", mentalClarity=" + mentalClarity + ", deployable=" + deployable + "]";
	}
	
	
	
}
