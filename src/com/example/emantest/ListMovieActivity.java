package com.example.emantest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class ListMovieActivity extends FragmentActivity implements OnMovieClickedListener {

	public static ProgressDialog ringProgressDialog;
	private boolean dualPane;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			dualPane = findViewById(R.id.detail) != null;
			ringProgressDialog = ProgressDialog.show(this, "Please wait ...", "Downloading movies ...", true);
			ringProgressDialog.setCancelable(true);
			ringProgressDialog.show();
	}

	@Override
	public void onMovieClickedListener(long id) {
		if (dualPane) {
			DetailFragment fragment = new DetailFragment(id);
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.detail, fragment);
			ft.addToBackStack(null);
			ft.commit();
		} else {
			Intent i = new Intent(this, DetailActivity.class);
			i.putExtra(DetailActivity.EXTRA_ID, id);
			startActivity(i);
		}
	}

}
