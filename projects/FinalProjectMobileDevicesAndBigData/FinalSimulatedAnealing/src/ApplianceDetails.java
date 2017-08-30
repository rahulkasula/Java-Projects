
public class ApplianceDetails implements Comparable<ApplianceDetails> {
double powerConsumption;
int start,end;
String applianceName;

public ApplianceDetails() {
	// TODO Auto-generated constructor stub
}
public double getPowerConsumption() {
	return powerConsumption;
}
public void setPowerConsumption(double powerConsumption) {
	this.powerConsumption = powerConsumption;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public String getApplianceName() {
	return applianceName;
}
public void setApplianceName(String applianceName) {
	this.applianceName = applianceName;
}
@Override
public int compareTo(ApplianceDetails compareStart) {
	// TODO Auto-generated method stub
	
	int compareQuantity = ((ApplianceDetails) compareStart).getStart(); 
	
	//ascending order
	return this.start - compareQuantity;
}

}
