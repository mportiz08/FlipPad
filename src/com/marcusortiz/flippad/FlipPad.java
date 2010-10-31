package com.marcusortiz.flippad;

import java.util.HashMap;

public class FlipPad
{
  public final String[] SYMBOLS = {"1", "2", "3", "4", "5", "6"};
  
  private int index;
  private HashMap<String, Integer> idMap;
  
  public FlipPad()
  {
    index = 0;
    mapIds();
  }
  
  public int next()
  {
    int id = idMap.get(SYMBOLS[index % SYMBOLS.length]);
    index++;
    
    return id;
  }
  
  private void mapIds()
  {
    idMap = new HashMap<String, Integer>();
    idMap.put(SYMBOLS[0], R.drawable.flip1);
    idMap.put(SYMBOLS[1], R.drawable.flip2);
    idMap.put(SYMBOLS[2], R.drawable.flip3);
    idMap.put(SYMBOLS[3], R.drawable.flip4);
    idMap.put(SYMBOLS[4], R.drawable.flip5);
    idMap.put(SYMBOLS[5], R.drawable.flip6);
  }
}
