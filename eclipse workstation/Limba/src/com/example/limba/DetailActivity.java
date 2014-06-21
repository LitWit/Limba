package com.example.limba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.vokabeldetail);

		Intent intent = getIntent();

		int position = InternData.liste.size()
				- (int) intent.getIntExtra("position", 0) - 1;

		Vokabel vokabel = new Vokabel();
		vokabel.setNext(InternData.liste.getBegin());
		for (int i = 0; i < position; i++) {
			vokabel.setNext(vokabel.getNext().getNext());
		}

		((TextView) (findViewById(R.id.textView))).setText("Es wurde "
				+ vokabel.getNext().getDeutscheVokabel() + " gewählt!");
	}
}
