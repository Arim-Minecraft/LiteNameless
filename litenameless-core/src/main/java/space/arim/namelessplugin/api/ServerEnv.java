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
import space.arim.universal.registry.RequireRegistration;
import space.arim.universal.registry.UniversalRegistry;

import space.arim.api.concurrent.AsyncExecution;
import space.arim.api.concurrent.SyncExecution;
import space.arim.api.uuid.UUIDResolver;

public interface ServerEnv {
	
	@RequireRegistration({AsyncExecution.class, SyncExecution.class, UUIDResolver.class})
	default Registry getRegistry() {
		return UniversalRegistry.get();
	}
	
}
