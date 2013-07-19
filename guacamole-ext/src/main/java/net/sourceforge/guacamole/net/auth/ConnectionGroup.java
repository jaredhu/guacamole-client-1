
package net.sourceforge.guacamole.net.auth;

/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is guacamole-ext.
 *
 * The Initial Developer of the Original Code is
 * Michael Jumper.
 * Portions created by the Initial Developer are Copyright (C) 2010
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s): James Muehlner
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */

import java.util.Collection;
import net.sourceforge.guacamole.GuacamoleException;
import net.sourceforge.guacamole.net.GuacamoleSocket;
import net.sourceforge.guacamole.protocol.GuacamoleClientInformation;


/**
 * Represents a pairing of a GuacamoleConfiguration with a unique,
 * human-readable identifier, and abstracts the connection process. The
 * backing GuacamoleConfiguration may be intentionally obfuscated or tokenized
 * to protect sensitive configuration information.
 *
 * @author James Muehlner
 */
public interface ConnectionGroup extends ConnectionGroupMember {

    /**
     * Returns the unique identifier assigned to this ConnectionGroup.
     * @return The unique identifier assigned to this ConnectionGroup.
     */
    public String getIdentifier();

    /**
     * Sets the identifier assigned to this Connection group.
     *
     * @param identifier The identifier to assign.
     */
    public void setIdentifier(String identifier);
    
    /**
     * Returns all members of this ConnectionGroup.
     * @return all members of this ConnectionGroup.
     */
    public Collection<ConnectionGroupMember> getMembers();
    
    /**
     * Sets the new members for this ConnectionGroup.
     * 
     * @param members The new members for this grouConnectionGroupp.
     */
    public void setMembers(Collection<ConnectionGroupMember> members);
    
    /**
     * Establishes a connection to guacd using a connection chosen from among
     * the connections in this ConnectionGroup, and returns the resulting, 
     * connected GuacamoleSocket.
     *
     * @param info Information associated with the connecting client.
     * @return A fully-established GuacamoleSocket.
     *
     * @throws GuacamoleException If an error occurs while connecting to guacd,
     *                            or if permission to connect is denied.
     */
    public GuacamoleSocket connect(GuacamoleClientInformation info)
            throws GuacamoleException;

}