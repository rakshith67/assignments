package mutualfunds.returns.models;

import java.util.ArrayList;
import java.util.List;

public class MutualFund {

	private Metadata meta;

	private List<Data> data = new ArrayList<Data>();

	public Metadata getMeta() {
		return meta;
	}

	public void setMeta(Metadata meta) {
		this.meta = meta;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

}
