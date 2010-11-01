package com.marcusortiz.flippad;

import com.marcusortiz.flippad.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class FlipPadActivity extends Activity
{
  public static final String LAST_SYMBOL = "LastSymbol";
  public static final String PREFS = "FlipPadPreferences";
  public static final String DEFAULT_SYMBOL = "1";
  
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
    FlipPad pad;
    SharedPreferences settings = getSharedPreferences(PREFS, 0);
    String symbol = settings.getString(LAST_SYMBOL, DEFAULT_SYMBOL);
    
    pad = new FlipPad(symbol);
    
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
      SharedPreferences settings = getSharedPreferences(PREFS, 0);
      SharedPreferences.Editor editor = settings.edit();
      
      if(event.getY() < (padView.getHeight() / 2))
      {
        padView.setImageResource(pad.next());
      }
      else
      {
        padView.setImageResource(pad.prev());
      }
      
      editor.putString(LAST_SYMBOL, pad.getSymbol());
      editor.commit();
      
      return false;
    }
  }
}