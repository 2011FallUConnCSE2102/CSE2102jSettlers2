/**
 * Local (StringConnection) network system.  Version 1.0.5.
 * Copyright (C) 2007-2009 Jeremy D Monin <jeremy@nand.net>.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * The author of this program can be reached at jeremy@nand.net
 **/
package soc.server.genericServer;

import java.io.IOException;
import java.net.SocketException;

/**
 * StringServerSocket allows server applications to communicate with clients,
 * with no difference between local and actual networked traffic.
 * 
 *<PRE>
 *  1.0.0 - 2007-11-18 - initial release
 *  1.0.3 - 2008-08-08 - add change history; no other changes in this file since 1.0.0
 *  1.0.4 - 2008-09-04 - no change in this file
 *  1.0.5 - 2009-05-31 - no change in this file
 *  1.0.5.1- 2009-10-26- remove unused import EOFException
 *</PRE>
 *
 * @author Jeremy D Monin <jeremy@nand.net>
 * @version 1.0.5.1
 */
public interface StringServerSocket
{

    /**
     * For server to call.  Blocks waiting for next inbound connection.
     * 
     * @return The server-side peer to the inbound client connection
     * @throws IOException  if network has a problem accepting
     * @throws SocketException if our setEOF() has been called, thus
     *    new clients won't receive any data from us
     */
    public abstract StringConnection accept() throws SocketException, IOException;

    /**
     * Close down server socket immediately:
     * Do not let inbound data drain.
     * Accept no new inbound connections.
     * Send EOF marker in all current outbound connections.
     * Like java.net.ServerSocket, any thread currently blocked in
     * accept() must throw a SocketException.
     */
    public abstract void close() throws IOException;

}
