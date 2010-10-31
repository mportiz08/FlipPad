package com.marcusortiz.flippad;

import com.marcusortiz.flippad.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class FlipPadActivity extends Activity
{
  public static final String LAST_SYMBOL = "symbol";
  
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
    Intent intent = getIntent();
    String symbol = intent.getStringExtra(LAST_SYMBOL);
    
    if(symbol == null)
    {
      pad = new FlipPad();
    }
    else
    {
      pad = new FlipPad(symbol);  
    }
    
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
      Intent intent = getIntent();
      ImageView padView = (ImageView)v;
      
      if(event.getY() < (padView.getHeight() / 2))
      {
        padView.setImageResource(pad.next());
        intent.putExtra(LAST_SYMBOL, pad.getSymbol());
      }
      else
      {
        padView.setImageResource(pad.prev());
        intent.putExtra(LAST_SYMBOL, pad.getSymbol());
      }
      
      return false;
    }
  }
}