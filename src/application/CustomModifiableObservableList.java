package application;

import java.util.ArrayList;

import javafx.collections.ModifiableObservableListBase;

public class CustomModifiableObservableList<Q> extends ModifiableObservableListBase<Q> {
	private final ArrayList<Q> list;
	
	public CustomModifiableObservableList() {
		super();
		list = new ArrayList<Q>();
	}
	
	public CustomModifiableObservableList(ArrayList<Q> list) {
		super();
		this.list = list;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	protected void doAdd(int index, Q tabName) {
		list.add(index, tabName);
	}

	// Don't use this
	@Override
	protected Q doSet(int index, Q tabName) {
		return list.set(index, tabName);
	}

	// Don't use this
	@Override
	protected Q doRemove(int index) {
		return list.remove(index);
	}

	@Override
	public Q get(int index) {
		return list.get(index);
	}

}
