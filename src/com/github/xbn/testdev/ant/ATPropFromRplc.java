/*license*\
   XBN-Java Library: http://xbnjava.aliteralmind.com
   
   Copyright (c) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.
   
   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.
   
   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.testdev.ant;
   import  org.apache.tools.ant.Task;
   import  org.apache.tools.ant.BuildException;

/**
   <P>Within a string, replace all instances of a 'what' string with a 'with' string, placing the result into a property. This only does a single pass through.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ATPropFromRplc extends Task  {
   private String sString = null;
   private String sWhat = null;
   private String sWith = null;
   private String sProperty = null;

   /**
      <P>Create a ATPropFromRplc. This does nothing.</P>
    **/
   public ATPropFromRplc()  {
   }
   /**
      <P>Set the name of the property to put the result in.</P>
    **/
   public void setProperty(String prop_name)  {
      sProperty = prop_name;
   }
   /**
      <P>The string in which the replacements should occur.</P>
    **/
   public void setString(String to_replace)  {
      sString = to_replace;
   }
   /**
      <P>The 'what' string to search for.</P>
    **/
   public void setWhat(String find_what)  {
      sWhat = find_what;
   }
   /**
      <P>The 'with' string to replace it (the 'what' string) with.</P>
    **/
   public void setWith(String rplc_with)  {
      sWith = rplc_with;
   }
   /**
      <P>Do it. Uh huh. Oh yeah.</P>
    **/
   public void execute() throws BuildException  {
      //This can't be dependent on any xbn code, because Ant
      //*builds* the xbn code.
      if(sProperty == null  ||  sProperty.length() == 0)  {
         throw  new BuildException("Required attribute 'property' missing or empty.");
      }

      if(sString == null  ||  sString.length() == 0)  {
         throw  new BuildException("Required attribute 'string' missing or empty.");
      }

      if(sWhat == null  ||  sWhat.length() == 0)  {
         throw  new BuildException("Required attribute 'what' missing or empty.");
      }

      if(sWith == null  ||  sWith.length() == 0)  {
         throw  new BuildException("Required attribute 'with' missing or empty.");
      }

      StringBuilder sb = new StringBuilder(sString);

      int ixOfWhat = 0;
      int iReplacements = 0;
      for(int i = 0; i < sString.length(); i++)  {
         ixOfWhat = sb.toString().indexOf(sWhat, ixOfWhat);

         if(ixOfWhat == -1)  {
            break;
         }
         //It was found.

         iReplacements++;

         sb.delete(ixOfWhat, (ixOfWhat + sWhat.length()));
         sb.insert(ixOfWhat, sWith);

         ixOfWhat += sWith.length();
      }

      log(iReplacements + " replacements");

      getProject().setProperty(sProperty, sb.toString());
   }
}
