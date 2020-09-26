
public abstract class Animal implements Countable {

	// Field
	private int count;

	// Override methods from Countable
	@Override
	public void incrementCount() {
		count++;
	}

	@Override
	public void resetCount() {
		count = 0;
	}

	@Override
	public int getCount() {
		return this.count;
	}

}
