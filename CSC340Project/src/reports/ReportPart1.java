package reports;

public class ReportPart1 {
	private String programName;
	private boolean julySept, octDec, janMar, aprJun;
	private boolean includeNICU;
	private String majHosp, majHospLvl;
	private String addH1, addH2, nearbyH;
	private int addH1Lvl, addH2Lvl, nearbyHLvl;
	private boolean newsletter, brochure, brochureCDR, brochCDSA, brochNICU, brochSmartStart, brochOther;
	private int numBroch;
	private String activitiesPromote;
	
	
	public ReportPart1(){
	}
	
	public String getFieldInfo(){
		//TODO: figure out what this should do and implement it
		return null;
	}
	
	public Object createPDFReport(){
		//TODO: figure out how to do this and implement it
		return null;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public boolean isJulySept() {
		return julySept;
	}

	public void setJulySept(boolean julySept) {
		this.julySept = julySept;
	}

	public boolean isOctDec() {
		return octDec;
	}

	public void setOctDec(boolean octDec) {
		this.octDec = octDec;
	}

	public boolean isJanMar() {
		return janMar;
	}

	public void setJanMar(boolean janMar) {
		this.janMar = janMar;
	}

	public boolean isAprJun() {
		return aprJun;
	}

	public void setAprJun(boolean aprJun) {
		this.aprJun = aprJun;
	}

	public boolean isIncludeNICU() {
		return includeNICU;
	}

	public void setIncludeNICU(boolean includeNICU) {
		this.includeNICU = includeNICU;
	}

	public String getMajHosp() {
		return majHosp;
	}

	public void setMajHosp(String majHosp) {
		this.majHosp = majHosp;
	}

	public String getMajHospLvl() {
		return majHospLvl;
	}

	public void setMajHospLvl(String majHospLvl) {
		this.majHospLvl = majHospLvl;
	}

	public String getAddH1() {
		return addH1;
	}

	public void setAddH1(String addH1) {
		this.addH1 = addH1;
	}

	public String getAddH2() {
		return addH2;
	}

	public void setAddH2(String addH2) {
		this.addH2 = addH2;
	}

	public String getNearbyH() {
		return nearbyH;
	}

	public void setNearbyH(String nearbyH) {
		this.nearbyH = nearbyH;
	}

	public int getAddH1Lvl() {
		return addH1Lvl;
	}

	public void setAddH1Lvl(int addH1Lvl) {
		this.addH1Lvl = addH1Lvl;
	}

	public int getAddH2Lvl() {
		return addH2Lvl;
	}

	public void setAddH2Lvl(int addH2Lvl) {
		this.addH2Lvl = addH2Lvl;
	}

	public int getNearbyHLvl() {
		return nearbyHLvl;
	}

	public void setNearbyHLvl(int nearbyHLvl) {
		this.nearbyHLvl = nearbyHLvl;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public boolean isBrochure() {
		return brochure;
	}

	public void setBrochure(boolean brochure) {
		this.brochure = brochure;
	}

	public boolean isBrochureCDR() {
		return brochureCDR;
	}

	public void setBrochureCDR(boolean brochureCDR) {
		this.brochureCDR = brochureCDR;
	}

	public boolean isBrochCDSA() {
		return brochCDSA;
	}

	public void setBrochCDSA(boolean brochCDSA) {
		this.brochCDSA = brochCDSA;
	}

	public boolean isBrochNICU() {
		return brochNICU;
	}

	public void setBrochNICU(boolean brochNICU) {
		this.brochNICU = brochNICU;
	}

	public boolean isBrochSmartStart() {
		return brochSmartStart;
	}

	public void setBrochSmartStart(boolean brochSmartStart) {
		this.brochSmartStart = brochSmartStart;
	}

	public boolean isBrochOther() {
		return brochOther;
	}

	public void setBrochOther(boolean brochOther) {
		this.brochOther = brochOther;
	}

	public int getNumBroch() {
		return numBroch;
	}

	public void setNumBroch(int numBroch) {
		this.numBroch = numBroch;
	}

	public String getActivitiesPromote() {
		return activitiesPromote;
	}

	public void setActivitiesPromote(String activitiesPromote) {
		this.activitiesPromote = activitiesPromote;
	}
	
	
}
