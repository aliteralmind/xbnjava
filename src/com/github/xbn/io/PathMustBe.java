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
package  com.github.xbn.io;
   import  java.util.Objects;
   import  com.github.xbn.lang.CrashIfObject;
   import  java.nio.file.Path;
   import  java.nio.file.AccessDeniedException;
   import  java.nio.file.Files;
   import  java.nio.file.NoSuchFileException;
   import  java.nio.file.LinkOption;
   import  java.io.IOException;
   import  java.nio.file.Paths;
/**
   <p>If a {@link java.nio.file.Path} is bad, crash. Otherwise, do nothing.</p>

 * @since  0.1.0
 * @author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://xbnjava.aliteralmind.com">{@code http://xbnjava.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/xbnjava">{@code https://github.com/aliteralmind/xbnjava}</a>
 **/
public class PathMustBe  {
   private Existence     existing;
   private Readable      readable ;
   private Writable      writable ;
   private FileDirectory fileDir  ;
   private LinkOption[]  linkOpts ;
   /**
      <p>Create a new instance that has no restrictions.</p>

      <p>This calls<ol>
         <li>{@link #existing(Existence) existing}<code>({@link Existence}.{@link Existence#OPTIONAL OPTIONAL})</code></li>
         <li>{@link #readable(Readable) readable}<code>({@link Readable}.{@link Readable#OPTIONAL OPTIONAL})</code></li>
         <li>{@link #writable(Writable) writable}<code>({@link Writable}.{@link Writable#OPTIONAL OPTIONAL})</code></li>
         <li>{@link #fileOrDirectory(FileDirectory) fileOrDirectory}<code>({@link FileDirectory}.{@link FileDirectory#EITHER EITHER})</code></li>
         <li>{@link #linkOptions(LinkOption...)}(new {@link java.nio.file.LinkOption}[]{});
      </ol></p>
    */
   public PathMustBe()  {
      existing(Existence.OPTIONAL);
      readable(Readable.OPTIONAL);
      writable(Writable.OPTIONAL);
      fileOrDirectory(FileDirectory.EITHER);
      linkOptions(new LinkOption[]{});
   }
   /**
      <p>Is existing required?.</p>

    * @see  #PathMustBe()
    * @see  #existing() existing
    */
   public Existence getExistence()  {
      return  existing;
   }
   /**
      <p>Is readable required?.</p>

    * @see  #PathMustBe()
    * @see  #readable() readable
    */
   public Readable getReadable()  {
      return   readable;
   }
   /**
      <p>Is writablity required?.</p>

    * @see  #PathMustBe() PathMustBe
    * @see  #writable() writable
    */
   public Writable getWritable()  {
      return   writable;
   }
   /**
      <p>Must the path be a regular-file or a directory?.</p>

    * @see  #PathMustBe() PathMustBe
    * @see  #directory() directory
    * @see  #regularFile() regularFile
    */
   public FileDirectory getFileDirectory()  {
      return  fileDir;
   }
   /**
      <p>Should symbolic links be followed?.</p>

    * @return  A <b><i>mutable</i></b> array of all link options.
    * @see  #PathMustBe() PathMustBe
    * @see  #existing() existing
    * @see  #regularFile() regularFile
    * @see  #directory() directory
    */
   public LinkOption[] getLinkOptions()  {
      return  linkOpts;
   }
   /**
      <p>Must exist.</p>

    * @return  <code>{@link #existing(Existence) existing}({@link Existence}.{@link Existence#REQUIRED REQUIRED})</code>
    */
   public PathMustBe existing()  {
      return  existing(Existence.REQUIRED);
   }
   /**
      <p>Declare if existing is required.</p>

    * @param  existing  May not be {@code null}. Get with {@link #getExistence() getExistence}{@code ()}
    * @return  <i>{@code this}</i>
    * @see  #existing()
    * @see  #linkOptions(LinkOption...) linkOptions
    */
   public PathMustBe existing(Existence existing)  {
      Objects.requireNonNull(existing, "existing");
      this.existing = existing;
      return  this;
   }
   /**
      <p>Must be readable.</p>

    * @return  <code>{@link #readable(Readable) readable}({@link Readable}.{@link Readable#REQUIRED REQUIRED})</code>
    */
   public PathMustBe readable()  {
      return  readable(Readable.REQUIRED);
   }
   /**
      <p>Declare if readable is required.</p>

    * @param  readable  May not be {@code null}. Get with {@link #getReadable() getReadable}{@code ()}
    * @return  <i>{@code this}</i>
    * @see  #readable()
    * @see  #linkOptions(LinkOption...) linkOptions
    */
   public PathMustBe readable(Readable readable)  {
      Objects.requireNonNull(readable, "readable");
      this.readable = readable;
      return  this;
   }
   /**
      <p>Must be writable.</p>

    * @return  <code>{@link #writable(Writable) writable}({@link Writable}.{@link Writable#REQUIRED REQUIRED})</code>
    */
   public PathMustBe writable()  {
      return  writable(Writable.REQUIRED);
   }
   /**
      <p>Declare if writable is required.</p>

    * @param  writable  May not be {@code null}. Get with {@link #getWritable() getWritable}{@code ()}.
    * @return  <i>{@code this}</i>
    * @see  #writable()
    * @see  #linkOptions(LinkOption...) linkOptions
    */
   public PathMustBe writable(Writable writable)  {
      Objects.requireNonNull(writable, "writable");
      this.writable = writable;
      return  this;
   }
   /**
      <p>Should symbolic links be followed?. Used when testing for {@linkplain #existing() existing} and is-a-{@linkplain #regularFile() file}-or-{@linkplain #directory() directory}.</p>

    * @param  link_opts  Options indicating how symbolic links are handled. Get with {@link #getLinkOptions() getLinkOptions}{@code ()}
    * @return  <i>{@code this}</i>
    * @see  #noFollowLinks()
    */
   public PathMustBe linkOptions(LinkOption... link_opts)  {
      linkOpts = link_opts;
      return  this;
   }
   /**
      <p>Do not follow symbolic links.</p>

    * @return  <code>{@link #linkOptions(LinkOption...) linkOptions}({@link java.nio.file.LinkOption}.{@link java.nio.file.LinkOption#NOFOLLOW_LINKS NOFOLLOW_LINKS})</code>
    */
   public PathMustBe noFollowLinks()  {
      return  linkOptions(LinkOption.NOFOLLOW_LINKS);
   }
   /**
      <p>Must be a directory.</p>

    * @return  <code>{@link #fileOrDirectory(FileDirectory) fileOrDirectory}({@link FileDirectory}.{@link FileDirectory#DIRECTORY DIRECTORY})</code>
    */
   public PathMustBe directory()  {
      return  fileOrDirectory(FileDirectory.DIRECTORY);
   }
   /**
      <p>Must be a regular file.</p>

    * @return  <code>{@link #fileOrDirectory(FileDirectory) fileOrDirectory}({@link FileDirectory}.{@link FileDirectory#REGULAR_FILE REGULAR_FILE})</code>
    */
   public PathMustBe regularFile()  {
      return  fileOrDirectory(FileDirectory.REGULAR_FILE);
   }
   /**
      <p>Declare if the path must be a regular file or a directory.</p>

    * @param  file_dir  May not be {@code null}. Get with {@link #getFileDirectory() getFileDirectory}{@code ()}.
    * @return  <i>{@code this}</i>
    * @see  #linkOptions(LinkOption...) linkOptions
    * @see  #directory()
    * @see  #regularFile()
    */
   public PathMustBe fileOrDirectory(FileDirectory file_dir)  {
      Objects.requireNonNull(file_dir, "file_dir");
      fileDir = file_dir;
      return  this;
   }

   /**
      <p>If a path is invalid, crash (with runtime errors only). Otherwise, do nothing.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #crashIfBadX(Path, String) crashIfBadX}(path, path_varName)</code></p>
    */
   public void crashIfBad(Path path, String path_varName)  {
      try  {
         crashIfBadX(path, path_varName);
      }  catch(IOException iox)  {
         throw  new RTIOException(iox);
      }
   }
   /**
      <p>If a path is valid, get it. Otherwise, crash (with runtime errors only).</p>

    * @return  <code>{@link #getOrCrashIfBadX(String, String) getOrCrashIfBadX}(path, path_varName)</code></p>
    */
   public Path getOrCrashIfBad(String path, String path_varName)  {
      try  {
         return  getOrCrashIfBadX(path, path_varName);
      }  catch(NoSuchFileException nsfx)  {
         throw  new RTNoSuchFileException(nsfx);
      }  catch(AccessDeniedException adx)  {
         throw  new RTAccessDeniedException(adx);
      }
   }
   /**
      <p>If a path is valid, get it. Otherwise, crash.</p>

      <p>This<ol>
         <li>Calls <code>crashIfBadX({@link java.nio.file.Paths}.{@link java.nio.file.Paths#get(String, String...) get}(path), path_varName)</code></li>
         <li>And returns the path.</li>
      </ol></p>
    */
   public Path getOrCrashIfBadX(String path, String path_varName) throws NoSuchFileException, AccessDeniedException  {
      Path ppath = Paths.get(path);
      crashIfBadX(ppath, path_varName);
      return  ppath;
   }
   /**
      <p>If a path is invalid, crash. Otherwise, do nothing.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>{@link #crashIfBadX(Path, String, Existence, Readable, Writable, FileDirectory, LinkOption...) crashIfBadX}(path, path_varName, existing_is, readable_is, writable_is, file_directory, link_opts)</code></p>
    */
   public static final void crashIfBad(Path path, String path_varName, Existence existing_is, Readable readable_is, Writable writable_is, FileDirectory file_directory, LinkOption... link_opts)  {
      try  {
         crashIfBadX(path, path_varName, existing_is, readable_is, writable_is, file_directory, link_opts);
      }  catch(NoSuchFileException nsfx)  {
         throw  new RTNoSuchFileException(nsfx);
      }  catch(AccessDeniedException adx)  {
         throw  new RTAccessDeniedException(adx);
      }
   }
//Originates with crashIfBadX, needed by isGood...START
   /**
      <p>If a path is invalid, crash. Otherwise, do nothing.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>PathMustBe.{@link #crashIfBadX(Path, String, Existence, Readable, Writable, FileDirectory, LinkOption...) crashIfBadX}(path, path_varName, {@link #getExistence() getExistence}(), {@link #getReadable() getReadable}(), {@link #getWritable() getWritable}(), {@link #getFileDirectory() getFileDirectory}(), ({@link java.nio.file.LinkOption}[]){@link #getLinkOptions() getLinkOptions}())</code></p>
    */
   public void crashIfBadX(Path path, String path_varName) throws NoSuchFileException, AccessDeniedException  {
      PathMustBe.crashIfBadX(path, path_varName, getExistence(), getReadable(), getWritable(), getFileDirectory(), (LinkOption[])getLinkOptions());
   }
   /**
      <p>If a path is invalid, crash. Otherwise, do nothing.</p>

    * @param  path  May not be {@code null}.
    * @param  path_varName  Descriptive name for {@code path}. <i>Should</i> not be {@code null} or empty.
    * @param  existing_is  May not be {@code null}.
    * @param  readable_is  May not be {@code null}.
    * @param  writable_is  May not be {@code null}
    * @param  file_directory  May not be {@code null}.
    * @param  link_opts  Options indicating how symbolic links are handled.
    * @see  #isGood(Path, Existence, Readable, Writable, FileDirectory, LinkOption...) isGood
    * @see  #crashIfBad(Path, String) crashIfBad(p,s)
    * @see  #getOrCrashIfBad(String, String) crashIfBad(s,s)
    * @see  #crashIfBadX(Path, String) crashIfBad(p,s)
    * @see  #getOrCrashIfBadX(String, String) crashIfBad(s,s)
    * @see  #crashIfBad(Path, String, Existence, Readable, Writable, FileDirectory, LinkOption...) crashIfBad(Path, String, Existence, ...)
    */
   public static final void crashIfBadX(Path path, String path_varName, Existence existing_is, Readable readable_is, Writable writable_is, FileDirectory file_directory, LinkOption... link_opts) throws NoSuchFileException, AccessDeniedException  {
      try  {
         if(Files.exists(path, link_opts))  {
            if(!Files.isWritable(path)  &&  writable_is.isRequired())  {
               throw  new AccessDeniedException("Exists, but not writable: " + path_varName + "=" + path);
            }
         }  else if(existing_is.isRequired())  {
            throw  new NoSuchFileException(path.toString());
         }  else  {
            Path parent = path.getParent();
            if(parent == null  ||  !Files.isWritable(parent)  &&  writable_is.isRequired())  {
               throw  new AccessDeniedException("Does not exist, and its directory is not writable: " + path_varName + "=" + path);
            }
         }

         if(!Files.isReadable(path)  &&  readable_is.isRequired())  {
            throw  new AccessDeniedException("Not readable: " + path_varName + "=" + path);
         }

         if(file_directory.isDirectory())  {
            if(!Files.isDirectory(path, link_opts))  {
               throw  new IllegalArgumentException("Not a directory: " + path_varName + "=" + path);
            }
         }  else if(file_directory.isRegularFile()  &&  !Files.isRegularFile(path, link_opts))  {
            throw  new IllegalArgumentException("Not a regular file: " + path_varName + "=" + path);
         }
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(path, "path", null);
         CrashIfObject.nnull(existing_is, "existing_is", null);
         CrashIfObject.nnull(writable_is, "writable_is", null);
         CrashIfObject.nnull(readable_is, "readable_is", null);
         throw  CrashIfObject.nullOrReturnCause(file_directory, "file_directory", null, rx);
      }
   }
//Originates with crashIfBadX, needed by isGood...END
//Originates with crashIfBadX, needed by isGood...START
   /**
      <p>Does a path conform to all its restrictions?.</p>

    * <p>Equal to
      <br/> &nbsp; &nbsp; <code>PathMustBe.{@link #isGood(Path, Existence, Readable, Writable, FileDirectory, LinkOption...) isGood}(path, {@link #getExistence() getExistence}(), {@link #getReadable() getReadable}(), {@link #getWritable() getWritable}(), {@link #getFileDirectory() getFileDirectory}(), ({@link java.nio.file.LinkOption}[]){@link #getLinkOptions() getLinkOptions}())</code></p>
    */
   public boolean isGood(Path path)  {
      return  PathMustBe.isGood(path, getExistence(), getReadable(), getWritable(), getFileDirectory(), (LinkOption[])getLinkOptions());
   }
   /**
      <p>Does a path conform to all its restrictions?.</p>

    * @param  path  May not be {@code null}.
    * @param  existing_is  May not be {@code null}.
    * @param  readable_is  May not be {@code null}.
    * @param  writable_is  May not be {@code null}
    * @param  file_directory  May not be {@code null}.
    * @param  link_opts  Options indicating how symbolic links are handled.
    * @see  #isGood(Path)
    * @see  #crashIfBadX(Path, String, Existence, Readable, Writable, FileDirectory, LinkOption...) crashIfBadX
    */
   public static final boolean isGood(Path path, Existence existing_is, Readable readable_is, Writable writable_is, FileDirectory file_directory, LinkOption... link_opts)  {
      try  {
         if(Files.exists(path, link_opts))  {
            if(!Files.isWritable(path)  &&  writable_is.isRequired())  {
               return  false;
            }
         }  else if(existing_is.isRequired())  {
            return  false;
         }  else  {
            Path parent = path.getParent();
            if(parent == null  ||  !Files.isWritable(parent)  &&  writable_is.isRequired())  {
               return  false;
            }
         }

         if(!Files.isReadable(path)  &&  readable_is.isRequired())  {
            return  false;
         }

         if(file_directory.isDirectory())  {
            if(!Files.isDirectory(path, link_opts))  {
               return  false;
            }
         }  else if(file_directory.isRegularFile()  &&  !Files.isRegularFile(path, link_opts))  {
            return  false;
         }

         return  true;
      }  catch(RuntimeException rx)  {
         CrashIfObject.nnull(path, "path", null);
         CrashIfObject.nnull(existing_is, "existing_is", null);
         CrashIfObject.nnull(writable_is, "writable_is", null);
         CrashIfObject.nnull(readable_is, "readable_is", null);
         throw  CrashIfObject.nullOrReturnCause(file_directory, "file_directory", null, rx);
      }
   }
//Originates with crashIfBadX, needed by isGood...END
}
