/*license*\
   XBN-Java: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

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
   import  java.io.File;
   import  org.apache.tools.ant.BuildException;
   import  org.apache.tools.ant.Task;
/**
   <P>How many kilobytes in size is the provided file?. The value is returned in a property, and is rounded up to the nearest kilobyte.</P>

   @since 0.1.0
   @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ATFileKB extends Task  {
   private String sFile = null;
   private String sProperty = null;

   /**
      <P>Create an ATFileKB. This does nothing.</P>
    **/
   public ATFileKB()  {
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
   public void setFile(String file_name)  {
      sFile = file_name;
   }
   /**
      <P>Do it. Uh huh. Oh yeah.</P>
    **/
   public void execute() throws BuildException  {
      long l = (new File(sFile)).length();
      if(l == 0L)  {
         throw  new BuildException("The file does not exist:  '" + sFile + "'.");
      }

      getProject().setProperty(sProperty, (new Long(l/1024)).toString());
   }
}
