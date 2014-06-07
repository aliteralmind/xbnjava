/*license*\
   XBN-Java Library

   Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.list;
   import  com.github.xbn.analyze.validate.ValueFilter;
   import  com.github.xbn.lang.Null;
   import  com.github.xbn.lang.BadDuplicateException;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.util.ArrayList;
   import  java.util.Collections;
   import  java.util.Iterator;
   import  java.util.List;
   import  java.util.Map;
   import  static com.github.xbn.lang.XbnConstants.*;
/**
   <P>Make the list values in a map immutable and/or sorted, and pretty-printing.</P>

   <H4>Iterating through a map via its entry-set</H4>

<BLOCKQUOTE><PRE>for (Map.Entry<KeyType,ValueType> entry : map.entrySet())  {
   KeyType k = entry.getKey();
   ValueType v = entry.getValue();
   ...
}</PRE></BLOCKQUOTE>

   <P><I>From <CODE><A HREF="http://stackoverflow.com/questions/46898/how-do-i-iterate-over-each-entry-in-a-map/46908#46908">http://stackoverflow.com/questions/46898/how-do-i-iterate-over-each-entry-in-a-map/46908#46908</A></CODE> (downloaded 5/28/2014)</I></P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <CODE><A HREF="http://xbnjava.jeffyepstein.com">http://xbnjava.jeffyepstein.com</A></CODE>, <CODE><A HREF="https://github.com/aliteralmind/xbnjava">https://github.com/aliteralmind/xbnjava</A></CODE>
 **/
public class MapUtil  {
   public static final <K,V> String toString(Map<K,V> map, ValueFilter<Map.Entry<K,V>> entryFilter_ifNonNull)  {
      return  appendToString(new StringBuilder(), map, entryFilter_ifNonNull).toString();
   }
   public static final <K,V> String toString(Map<K,V> map, ValueFilter<Map.Entry<K,V>> entryFilter_ifNonNull, String entry_prefix, String value_prefix, String value_postfix, String entry_postfix, String between)  {
      return  appendToString(new StringBuilder(), map, entryFilter_ifNonNull, entry_prefix, value_prefix, value_postfix, entry_postfix, between).toString();
   }
   public static final <K,V> StringBuilder appendToString(StringBuilder to_appendTo, Map<K,V> map, ValueFilter<Map.Entry<K,V>> entryFilter_ifNonNull)  {
      return  appendToString(to_appendTo, map, entryFilter_ifNonNull, " - ", null, null, null, LINE_SEP);
   }
   public static final <K,V> StringBuilder appendToString(StringBuilder to_appendTo, Map<K,V> map, ValueFilter<Map.Entry<K,V>> entryFilter_ifNonNull, String entry_prefix, String value_prefix, String value_postfix, String entry_postfix, String between)  {
      if(value_prefix == null)  {
         value_prefix = "";
      }
      if(value_postfix == null)  {
         value_postfix = "";
      }
      if(between == null)  {
         between = "";
      }
      Iterator<Map.Entry<K,V>> itr = map.entrySet().iterator();
      while(itr.hasNext())  {
         Map.Entry<K,V> entry = itr.next();
         if(entryFilter_ifNonNull != null  &&  !entryFilter_ifNonNull.doAccept(entry))  {
            continue;
         }
         to_appendTo.append(entry.getKey()).append("=").
            append(value_prefix).append(entry.getValue()).append(value_postfix);
         if(itr.hasNext())  {
            to_appendTo.append(between);
         }
      }
      return to_appendTo;
   }
   /**
      <P>YYY</P>

   	@exception  UnsupportedOperationException  If {@code put} is unsupported by {@code map_withMutableListValues}.
    **/
   public static final <M extends Comparable<? super M>,K> Map<K,List<M>> getWithModifiedListValues(Map<K,List<M>> map_withMutableListValues, SortListValues sort, ImmutableValues immutable)  {
      try  {
         if(sort.doNotSort())  {
            if(immutable.isYes())  {
               for (Map.Entry<K,List<M>> entry : map_withMutableListValues.entrySet())  {
                  map_withMutableListValues.put(entry.getKey(), Collections.<M>unmodifiableList(entry.getValue()));
               }
            }
            return  map_withMutableListValues;
         }

         if(sort.doSortOriginal())  {
            if(immutable.isYes())  {
               for (Map.Entry<K,List<M>> entry : map_withMutableListValues.entrySet())  {
                  List<M> list = entry.getValue();
                  Collections.sort(list);
                  map_withMutableListValues.put(entry.getKey(),
                     Collections.<M>unmodifiableList(list));
               }
            }  else  {
               for (Map.Entry<K,List<M>> entry : map_withMutableListValues.entrySet())  {
                  List<M> list = entry.getValue();
                  Collections.sort(list);
                  map_withMutableListValues.put(entry.getKey(), list);
               }
            }
            return  map_withMutableListValues;
         }

         if(sort.doSortDuplicate())  {
            if(immutable.isYes())  {
               for (Map.Entry<K,List<M>> entry : map_withMutableListValues.entrySet())  {
                  List<M> lOrig = entry.getValue();
                  List<M> lNew = null;
                  if(lOrig != null)  {
                     lNew = new ArrayList<M>(lOrig.size());
                     lNew.addAll(lOrig);
                     Collections.sort(lNew);
                     lNew = Collections.<M>unmodifiableList(lNew);
                  }
                  map_withMutableListValues.put(entry.getKey(), lNew);
               }
            }  else  {
               for (Map.Entry<K,List<M>> entry : map_withMutableListValues.entrySet())  {
                  List<M> lOrig = entry.getValue();
                  List<M> lNew = null;
                  if(lOrig != null)  {
                     lNew = new ArrayList<M>(lOrig.size());
                     lNew.addAll(lOrig);
                     Collections.sort(lNew);
                  }
                  map_withMutableListValues.put(entry.getKey(), lNew);
               }
            }
            return  map_withMutableListValues;
         }
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(map_withMutableListValues, "map_withMutableListValues", null);
         CrashIfObject.nnull(sort, "sort", null);
         throw  CrashIfObject.nullOrReturnCause(immutable, "immutable", null, rx);
      }

      throw  new IllegalStateException("Unknown value(s) for SortListValues and/or ImmutableValues: sort=" + sort + ", immutable=" + immutable);
   }
   public static final <T,K> Map<K,List<T>> unmodifiableListValues(Map<K,List<T>> map_withMutableListValues)  {
      try  {
         for (Map.Entry<K,List<T>> entry : map_withMutableListValues.entrySet())  {
            map_withMutableListValues.put(entry.getKey(), Collections.<T>unmodifiableList(entry.getValue()));
         }
         return  map_withMutableListValues;
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(map_withMutableListValues, "map_withMutableListValues", null, rx);
      }
   }
   public static final <K,V> V getValueCrashIfUnknownKey(Map<K,V> map, String map_varName, K key, String key_varName)  {
      V value = null;
      try  {
         value = map.get(key);
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(map, map_varName, null, rx);
      }
      if(value == null)  {
         throw  new IllegalArgumentException(map_varName + ".containsKey(" + key_varName + ") is false. " + key_varName + "=[" + key + "]");
      }
      return  value;
   }
   /**
      <P>YYY</P>

   	@exception  UnsupportedOperationException  If {@code put} is unsupported by {@code to_addTo}.
    **/
   public static final <K,V> void putOrCrashIfContainsKey(Map<K,V> to_addTo, String map_varName, K key, Null null_key, String key_varName, V value, Null null_value, String value_varName)  {
      try  {
         if(to_addTo.containsKey(key))  {
            throw  new BadDuplicateException("Map=" + map_varName + ", " + key_varName + "=[" + key + "]");
         }
      }  catch(RuntimeException rx)  {
         throw  CrashIfObject.nullOrReturnCause(to_addTo, map_varName, null, rx);
      }
      CrashIfObject.nnull(null_key, key, key_varName, null);
      CrashIfObject.nnull(null_value, value, value_varName, null);
      try  {
         to_addTo.put(key, value);
      }  catch(UnsupportedOperationException uox)  {
         throw  new UnsupportedOperationException("map_varName=\"" + map_varName + "\"", uox);
      }
   }
}
