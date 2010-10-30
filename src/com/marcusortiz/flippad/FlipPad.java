package com.marcusortiz.flippad;

import java.util.ArrayList;
import java.util.Arrays;

public class FlipPad
{
  public final String[] SYMBOLS = {"1", "2", "3", "4", "5", "6"};
  
  private ArrayList<String> options;
  private int index;
  
  public FlipPad()
  {
    options = new ArrayList<String>(Arrays.asList(SYMBOLS));
    index = 0;
  }
  
  public FlipPad(String sym)
  {
    options = new ArrayList<String>(Arrays.asList(SYMBOLS));
    index = options.indexOf(sym);
  }
  
  public String next() {   
    String src = "@drawable/flip";
    
    src.concat(options.get(index % options.size()));
    index++;
    
    return src;
  }
}
