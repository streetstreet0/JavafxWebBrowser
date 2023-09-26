package application;

import java.util.ArrayList;

import javafx.collections.ModifiableObservableListBase;

public class ModifiableObservableTabList extends ModifiableObservableListBase<Tab> {
	private final ArrayList<Tab> tabButtons = new ArrayList<Tab>();
	
	public ModifiableObservableTabList() {
		super();
	}

	@Override
	public int size() {
		return tabButtons.size();
	}

	@Override
	protected void doAdd(int index, Tab tabName) {
		tabButtons.add(index, tabName);
	}

	@Override
	protected Tab doSet(int index, Tab tabName) {
		return tabButtons.set(index, tabName);
	}

	@Override
	protected Tab doRemove(int index) {
		return tabButtons.remove(index);
	}

	@Override
	public Tab get(int index) {
		return tabButtons.get(index);
	}

}
