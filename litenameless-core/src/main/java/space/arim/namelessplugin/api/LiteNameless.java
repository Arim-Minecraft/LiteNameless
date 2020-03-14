/* 
 * LiteNameless-core
 * Copyright © 2020 Anand Beh <https://www.arim.space>
 * 
 * LiteNameless-core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * LiteNameless-core is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with LiteNameless-core. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU General Public License.
 */
package space.arim.namelessplugin.api;

import space.arim.universal.registry.Registry;
import space.arim.universal.util.AutoClosable;

/**
 * General LiteNameless API <br>
 * <br>
 * Detached from BungeeCord, Spigot, or Sponge. <br>
 * {@link SenderWrapper} and {@link PlayerWrapper} are used for command senders and players.
 * 
 * @author A248
 *
 */
public interface LiteNameless extends AutoClosable {
	
	/**
	 * Reloads the plugin
	 * 
	 */
	void reload();
	
	/**
	 * Checks whether the plugin is enabled. <br>
	 * <br>
	 * The plugin is considered enabled if and only if: <br>
	 * * <i>enable{@literal -}plugin</i> is <code>true</code> in the config.yml
	 * * The host and api key specified in config.yml are valid
	 * 
	 * @return true if enabled, false otherwise
	 */
	boolean enabled();
	
	/**
	 * Gets the {@link Registry} associated with LiteNameless
	 * 
	 * @return the registry
	 */
	Registry getRegistry();
	
	/**
	 * Executes a command for a player with given arguments. <br>
	 * May be used to simulate command execution.
	 * 
	 * @param player a wrapped player
	 * @param args array of command arguments
	 * @return true to indicate elementary command success, rarely false
	 */
	boolean executeCommand(SenderWrapper player, String[] args);
	
	/**
	 * Updates a player's group by scanning the group ID's specified in the config.yml
	 * and connecting to the website to set the corresponding account's group.
	 * 
	 * The plugin automatically updates a player's group on login; however, some programmers may require
	 * this method if, for example, a player's group changes while they are online.
	 * 
	 * @param player
	 */
	void updateGroup(PlayerWrapper player);
	
	/**
	 * Detects a player's group and updates it on the Nameless website. <br>
	 * <br>
	 * The plugin automatically updates a player's group on login; however, some programmers may require
	 * this method if a player's group changes while they are online. For example, a shop plugin,
	 * which updates a player's rank ingame, would also want to reload the user's group on the website. <br>
	 * <br>
	 * Process: <br>
	 * 1. The plugin scans the group IDs specified in config.yml. <br>
	 * 2. If the player has the permission corresponding to the group ID, the plugin will use that ID.
	 * If the player has multiple permissions corresponding to different group IDs,
	 * the plugin will use the last group ID in the configuration list.  <br>
	 * 3. The plugin will update the user's group on the Nameless website. <br>
	 * <br>
	 * The procedure is done asynchronously blocking the main thread. <br>
	 * In rare cases, (for example, if calling code is already asynchronous), {@link #updateGroup(PlayerWrapper)} may be used.
	 * 
	 * @param player a wrapped player
	 */
	void updateGroupAsync(PlayerWrapper player);
	
}
