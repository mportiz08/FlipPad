package com.marcusortiz.flippad;

import com.marcusortiz.flippad.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class FlipPadActivity extends Activity
{
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);
  }
}