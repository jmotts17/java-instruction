
public enum CustomerType {
	RETAIL, TRADE, COLLEGE;

	@Override
	public String toString() {

		if (this.ordinal() == 0) {
			return "Retail Customer";
		} else if (this.ordinal() == 1) {
			return "Trade Customer";
		} else if (this.ordinal() == 2) {
			return "College Customer";
		} else {
			return "";
		}
	}
}