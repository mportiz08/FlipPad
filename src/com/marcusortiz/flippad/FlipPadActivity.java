package com.marcusortiz.flippad;

import com.marcusortiz.flippad.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class FlipPadActivity extends Activity
{
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);
    initPad();
  }
  
  private void initPad()
  {
    FlipPad pad = new FlipPad();
    ImageView padView = (ImageView)findViewById(R.id.PadView);
    
    padView.setImageResource(pad.next());
    padView.setOnTouchListener(new TouchListener(pad));
  }
  
  private class TouchListener implements View.OnTouchListener
  {
    private FlipPad pad;
    
    public TouchListener(FlipPad pad)
    {
      this.pad = pad;
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
      ImageView padView = (ImageView)v;
      padView.setImageResource(pad.next());
      
      return false;
    }
  }
}