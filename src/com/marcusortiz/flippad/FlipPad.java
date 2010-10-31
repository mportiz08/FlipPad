package com.marcusortiz.flippad;

import java.util.Arrays;
import java.util.HashMap;

public class FlipPad
{
  public final String[] SYMBOLS = {"1", "2", "3", "4", "5", "6"};
  
  private int index;
  private String symbol;
  private HashMap<String, Integer> idMap;
  
  private enum Dir
  {
    NEXT, PREV;
  }
  
  public FlipPad()
  {
    index = -1;
    mapIds();
  }
  
  public FlipPad(String sym)
  {
    index = Arrays.binarySearch(SYMBOLS, sym) - 1;
    mapIds();
  }
  
  public String getSymbol()
  {
    return symbol;
  }
  
  public int next()
  {
    updateIndex(Dir.NEXT);
    symbol = SYMBOLS[index];
    
    return idMap.get(symbol);
  }
  
  public int prev()
  {
    updateIndex(Dir.PREV);
    symbol = SYMBOLS[index];
    
    return idMap.get(symbol);
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
  
  private void updateIndex(Dir dir)
  {
    if(dir == Dir.NEXT)
    {
      index++;
      
    }
    else if(dir == Dir.PREV)
    {
      index--;
    }
    
    if(index >= SYMBOLS.length){
      index = 0;
    }
    else if(index < 0) {
      index = SYMBOLS.length - 1;
    }
  }
}
