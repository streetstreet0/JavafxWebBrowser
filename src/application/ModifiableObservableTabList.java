package application;

import java.util.ArrayList;

import javafx.collections.ModifiableObservableListBase;

public class ModifiableObservableTabList extends ModifiableObservableListBase<Tab> {
	private final ArrayList<Tab> tabs = new ArrayList<Tab>();
	
	public ModifiableObservableTabList() {
		super();
	}

	@Override
	public int size() {
		return tabs.size();
	}

	@Override
	protected void doAdd(int index, Tab tabName) {
		tabs.add(index, tabName);
	}

	// Don't use this
	@Override
	protected Tab doSet(int index, Tab tabName) {
		return tabs.set(index, tabName);
	}

	// Don't use this
	@Override
	protected Tab doRemove(int index) {
		return tabs.remove(index);
	}

	@Override
	public Tab get(int index) {
		return tabs.get(index);
	}

}
