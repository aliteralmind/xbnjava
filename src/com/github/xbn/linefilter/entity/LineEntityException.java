/*license*\
   Codelet: Copyright (C) 2014, Jeff Epstein (aliteralmind __DASH__ github __AT__ yahoo __DOT__ com)

   This software is dual-licensed under the:
   - Lesser General Public License (LGPL) version 3.0 or, at your option, any later version;
   - Apache Software License (ASL) version 2.0.

   Either license may be applied at your discretion. More information may be found at
   - http://en.wikipedia.org/wiki/Multi-licensing.

   The text of both licenses is available in the root directory of this project, under the names "LICENSE_lgpl-3.0.txt" and "LICENSE_asl-2.0.txt". The latest copies may be downloaded at:
   - LGPL 3.0: https://www.gnu.org/licenses/lgpl-3.0.txt
   - ASL 2.0: http://www.apache.org/licenses/LICENSE-2.0.txt
\*license*/
package  com.github.xbn.linefilter.entity;
	import  com.github.xbn.linefilter.entity.raw.RawEntity;
	import  com.github.xbn.linefilter.FilteredLineException;
	import  com.github.xbn.lang.CrashIfObject;
/**
	<p>Indicates a problem when attempting to filter a particular line.</p>

	@since  0.1.0
	@author  Copyright (C) 2014, Jeff Epstein ({@code aliteralmind __DASH__ github __AT__ yahoo __DOT__ com}), dual-licensed under the LGPL (version 3.0 or later) or the ASL (version 2.0). See source code for details. <a href="http://codelet.aliteralmind.com">{@code http://codelet.aliteralmind.com}</a>, <a href="https://github.com/aliteralmind/codelet">{@code https://github.com/aliteralmind/codelet}</a>

 **/
public class LineEntityException extends FilteredLineException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8648691397047864848L;
	private final RawEntity<?> entity;
	public LineEntityException(int line_num, Object line, RawEntity<?> entity, String message)  {
		super(line_num, line, LineEntityException.getErrorMessage(entity, message));
		this.entity = entity;
	}
	public LineEntityException(int line_num, Object line, RawEntity<?> entity)  {
		super(line_num, line, (entity == null) ? null : entity.toString());
		this.entity = entity;
	}
	public LineEntityException(int line_num, Object line, RawEntity<?> entity, String message, Throwable cause)  {
		super(line_num, line, LineEntityException.getErrorMessage(entity, message), cause);
		this.entity = entity;
	}
	public LineEntityException(int line_num, Object line, RawEntity<?> entity, Throwable cause)  {
		super(line_num, line, (entity == null) ? null : entity.toString(), cause);
		this.entity = entity;
	}
	public RawEntity<?> getEntity()  {
		return  entity;
	}
	public static final String getErrorMessage(RawEntity<?> entity, String message)  {
		try  {
			return  ((entity != null) ? "entity=<" + entity + ">, message: " : "") + message;
		}  catch(RuntimeException rx)  {
			throw  CrashIfObject.nullOrReturnCause(entity, "entity", null, rx);
		}
	}
}
