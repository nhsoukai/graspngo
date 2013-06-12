package yumyum;



import java.util.List;

import com.example.test.R;

import food.Food;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/*
 * Author: N.H Soukaina
 */

public class MyAdapter extends ArrayAdapter<Food> {

	private List<Food> list;
	private LayoutInflater inflator;

	public MyAdapter(Activity context, List<Food> list) {
		super(context, R.layout.row, list);
		this.list = list;
		inflator = context.getLayoutInflater();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflator.inflate(R.layout.row, null);
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.price = (TextView) convertView.findViewById(R.id.price);
			holder.chk = (CheckBox) convertView.findViewById(R.id.checkBox1);
			holder.chk
					.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton view,
								boolean isChecked) {
							int getPosition = (Integer) view.getTag();
							list.get(getPosition).setSelected(view.isChecked());

						}
					});
			convertView.setTag(holder);
			convertView.setTag(R.id.name, holder.name);
			convertView.setTag(R.id.price, holder.price);
			convertView.setTag(R.id.checkBox1, holder.chk);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.chk.setTag(position);
		holder.price.setText(list.get(position).getPrice());
		holder.name.setText(list.get(position).getName());
		holder.chk.setChecked(list.get(position).isSelected());

		return convertView;
	}

	static class ViewHolder {
		public TextView price;
		protected TextView name;
		protected CheckBox chk;
	}
}