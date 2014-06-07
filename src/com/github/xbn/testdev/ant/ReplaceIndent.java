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
   import  org.apache.tools.ant.DirectoryScanner;
//-------------------------------------------------------
   import  java.io.File;
   import  java.io.FileInputStream;
   import  java.io.FileWriter;
      import  java.io.FileNotFoundException;
      import  java.io.IOException;

/**
   <P>Replace tab indents of all Java code existing in a directory with a replacement string. This is slow and rudimentary. No files can be excluded, for instance. But it works.</P>

   <P>Copied xbn.util.Utility.appendText.</P>

   @author  Copyright (C) 2014, Jeff Epstein, dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <A HREF="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</A>, <A HREF="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</A>
 **/
public class ReplaceIndent extends Task  {
   private String sSrcDir = null;
   private String sTabRplc = null;

   private static final String LINE_SEP = System.getProperty("line.separator", "\n");


   /**
      <P>Create a new ReplaceIndent. This does nothing.</P>
    **/
   public ReplaceIndent()  {
   }
   /**
      <P>Set the directory to change Java code in.</P>
    **/
   public void setSrcDir(String source_dir)  {
      sSrcDir = source_dir;
   }
   /**
      <P>The 'with' string to replace it (the 'what' string) with.</P>
    **/
   public void setTabRplc(String indent)  {
      sTabRplc = indent;
   }
   /**
      <P>Do it. Uh huh. Oh yeah.</P>
    **/
   public void execute() throws BuildException  {
      //This can't be dependent on any xbn code, because Ant
      //*builds* the xbn code.

      if(sSrcDir == null  ||  sSrcDir.length() == 0  ||
         	!sSrcDir.endsWith(System.getProperty("file.separator")))  {
         throw  new BuildException("Required attribute 'srcdir' ('" + sSrcDir + "') is missing, empty, or does not end with a file.separator ('" + System.getProperty("file.separator") + "').");
      }

      if(sTabRplc == null  ||  sTabRplc.length() == 0)  {
         throw  new BuildException("Required attribute 'tabrplc' missing or empty.");
      }

      DirectoryScanner ds = new DirectoryScanner();
      ds.setIncludes(new String[] {"**\\*.java"});
      ds.setBasedir(new File(sSrcDir));
      ds.setCaseSensitive(true);
      ds.scan();

      String[] asFiles = ds.getIncludedFiles();
      for (int i = 0; i < asFiles.length; i++) {
         //MUST put sSrcDir here, otherwise it'll scan for
         //relative directories existing in the directory *in
         //which ant is run*. Since your build and sandbox
         //directories are similar, this is a Big Deal (TM).
         //
         //1/2
         doFile(sSrcDir, asFiles[i]);
      }
   }
   private void doFile(String dir, String file_name)  {
      System.out.print("'" + file_name + "'\n     ");
      StringBuilder sb = new StringBuilder();

      //Utility.appendText...START
         FileInputStream fis = null;

         BuildException bx = null;

         try  {
            fis = new FileInputStream(dir + file_name);

            String s = null;

            byte[] ab = new byte[1];
            while(fis.read(ab) != -1)  {
               s = new String(ab);
               sb.append(s);
               ab = new byte[1];
            }
         }  catch(FileNotFoundException fnfx)  {
            bx = new BuildException(" " + fnfx.toString());
         }  catch(IOException iox)  {
            bx = new BuildException(" " + iox.toString());

         }  finally  {
            BuildException bx2 = null;
            try  {
               if(fis != null)  {
                  fis.close();
               }
            }  catch(IOException iox)  {
               bx2 = new BuildException(" while attempting to close the FileInputStream:  " + iox.toString());
            }  finally  {
               fis = null;

               if(bx != null  &&  bx2 != null)  {
                  throw  new BuildException(" Original exception:  [" + bx.toString() + "], Latest exception:  [" + bx2.toString() + "]");

               }  else if(bx != null)  {
                  throw bx;

               }  else if(bx2 != null)  {
                  throw bx2;
               }
            }
         }
      //Utility.appendText...END

      String sTr = sTabRplc;
      replaceAll(sb, LINE_SEP + "\t\t\t\t\t\t\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr + sTr + sTr + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t\t\t\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr + sTr + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t\t\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t\t",
                     LINE_SEP + sTr + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t\t",
                     LINE_SEP + sTr + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t\t",
                     LINE_SEP + sTr + sTr);
      replaceAll(sb, LINE_SEP + "\t",
                     LINE_SEP + sTr);

      FileWriter fw = null;
      try {
         String s = sb.toString();

         //MUST put sSrcDir here, otherwise it'll scan for
         //relative directories existing in the directory *in
         //which ant is run*. Since your build and sandbox
         //directories are similar, this is a Big Deal (TM).
         //
         //2/2
          fw = new FileWriter(dir + file_name, false);
          fw.write(s.toString());
      }  catch (IOException iox)  {
          throw  new BuildException(iox);
      }  finally  {
          if (fw != null) {
              try {
                  fw.close();
              } catch (IOException iox) {}
          }
      }
      System.out.println("");
   }
   private void replaceAll(StringBuilder to_appendTo, String find_what, String rplc_with)  {
      int ixOfWhat = 0;
      int iReplacements = 0;
      for(int i = 0; i < to_appendTo.length(); i++)  {
         ixOfWhat = to_appendTo.toString().indexOf(find_what, ixOfWhat);

         if(ixOfWhat == -1)  {
            break;
         }
         //It was found.

         iReplacements++;

         to_appendTo.delete(ixOfWhat, (ixOfWhat + find_what.length()));
         to_appendTo.insert(ixOfWhat, rplc_with);

         ixOfWhat += rplc_with.length();
      }

      System.out.print(iReplacements + " ");
   }
}
