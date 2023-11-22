/*******************************************************************************
 * Copyright (c) 2010 actifsource GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     actifsource GmbH - initial API and implementation
 ******************************************************************************/
package ch.actifsource.example.modvis.target;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.CheckForNull;

import ch.actifsource.solution.modvis.server.core.util.JsonAnimationHelper;
import ch.actifsource.solution.modvis.server.core.util.JsonAnimationTags;
import ch.actifsource.solution.modvis.server.core.util.JsonUtil;
import ch.actifsource.solution.modvis.server.core.util.JsonUtil.JsonArrayObject;
import ch.actifsource.solution.modvis.server.core.util.JsonUtil.JsonObject;

/**
 * This implementation is just an example of how the implementation can be done on the target.
 */
public class TestTargetServer {

	public static final int PORT = 11111;
	
	/**
	 * Run the target animation target.
	 */
	public static void main(String[] args) {
		TestTargetServer server = new TestTargetServer();
		try {
			System.out.println("Start target server (localhost port: "+PORT+")");
			server.runServerTest();
			System.out.println("Stop target server");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/***********************************************************************************
	 * TestTargetServer
	 ***********************************************************************************/
	
	public List<ModulContext> fBindedModulContexts = new ArrayList<>();
	public final StringBuffer fStringBufferCache = new StringBuffer();
	@CheckForNull
	private java.net.Socket fClient;
	@CheckForNull
	private java.net.ServerSocket fServerSocket;
	private boolean fServerStop = false;
	
	/**
	 * Run the server and open the socket
	 */
	private void runServerTest() throws IOException {
		fServerSocket = new java.net.ServerSocket(PORT);
		fClient = waitForBrowserConnection(fServerSocket);
		
		while (!fServerStop) {
			
			JsonObject jsonMessage = readMessage(fClient, fStringBufferCache);
			if (jsonMessage != null) {
				bindModulRequest(jsonMessage);
				unbindModulRequest(jsonMessage);
				errorRequest(jsonMessage);
			}
			
			for (ModulContext modulContext : fBindedModulContexts) {
				updateNextStateModul(fClient, modulContext);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Update next state 
	 */
	private void updateNextStateModul(java.net.Socket client, ModulContext modulContext) throws IOException {
		if (!modulContext.isInitComplte()) {
			/* snapshot */
			writeMessage(client, "{\"elmStartType\":{\"id\":[],\"type\":\"snapshot\"}}");
			/* history */
			writeMessage(client, "{\"elmStartType\":{\"id\":[],\"type\":\"history\"}}");

			modulContext.setInitSequenceNumber(1);
			modulContext.setInitComplete();
			
			/* updates */
			writeMessage(client, "{\"elmStartType\":{\"id\":[],\"type\":\"update\"}}");
			return;
		}
		
		int seq = modulContext.getNewSequenceNumber();
		int nextActiveState = modulContext.getNextActiveState();
		if (nextActiveState == 1) {
			writeMessage(client, "{\"elm\":[{\"id\":[1, 1],\"st\":1,\"seq\":"+seq+"}]}"); // StateA
			writeMessage(client, "{\"elm\":[{\"id\":[1, 6],\"st\":1,\"seq\":"+seq+"}]}"); // StateC -> StateA
		}
		if (nextActiveState == 2) {
			writeMessage(client, "{\"elm\":[{\"id\":[1, 2],\"st\":1,\"seq\":"+seq+"}]}"); // StateB
			writeMessage(client, "{\"elm\":[{\"id\":[1, 4],\"st\":1,\"seq\":"+seq+"}]}"); // StateA -> StateB
		}
		if (nextActiveState == 3) {
			writeMessage(client, "{\"elm\":[{\"id\":[1, 3],\"st\":1,\"seq\":"+seq+"}]}"); // StateB
			writeMessage(client, "{\"elm\":[{\"id\":[1, 5],\"st\":1,\"seq\":"+seq+"}]}"); // StateB -> StateC
		}
	}
	
	
	/***************************************************************************
	 * Request
	 **************************************************************************/
	
	/**
	 * Send error request (Target -> Browser)
	 */
	private void errorRequest(JsonObject jsonMessage) {
		JsonArrayObject errorRequest = jsonMessage.getJsonArrayOrNull(JsonAnimationTags.JSON_ERROR);
		if (errorRequest == null) return;
		
		fBindedModulContexts.clear();
	}
	
	/**
	 * Send bind modul request (Browser > Target)
	 */
	private void bindModulRequest(JsonObject jsonMessage) {
		JsonArrayObject bindRequest = jsonMessage.getJsonArrayOrNull(JsonAnimationTags.JSON_BIND_REQUEST);
		if (bindRequest == null) return;
		for (int index = 0; index < bindRequest.length(); index++) {
			JsonObject binding = bindRequest.getJsonObject(index);
			JsonArrayObject id = binding.getJsonArray(JsonAnimationTags.JSON_ID);
			JsonAnimationHelper.JsonId modulId = new JsonAnimationHelper.JsonId(id);	
			System.err.println("Test Server bindModulRequest "+ modulId.toString());
			fBindedModulContexts.add(new ModulContext(modulId));
		}
	}
	
	/**
	 * Send unbind modul request (Browser > Target)
	 */
	private void unbindModulRequest(JsonObject jsonMessage) {
		JsonArrayObject unbindRequest = jsonMessage.getJsonArrayOrNull(JsonAnimationTags.JSON_UNBIND_REQUEST);
		if (unbindRequest == null) return;
		for (int index = 0; index < unbindRequest.length(); index++) {
			JsonObject unbinding = unbindRequest.getJsonObject(index);
			JsonArrayObject id = unbinding.getJsonArray(JsonAnimationTags.JSON_ID);
			JsonAnimationHelper.JsonId modulId = new JsonAnimationHelper.JsonId(id);	
			ModulContext modulContext = findModulContextByModulId(modulId);
			if (modulContext == null) continue;
			System.err.println("Test Server unbindModulRequest "+ modulId.toString());
			fBindedModulContexts.remove(modulContext);
		}
	}
	
	/**
	 * Find modul context by modul id
	 */
	@CheckForNull
	private ModulContext findModulContextByModulId(JsonAnimationHelper.JsonId modulId) {
		for (ModulContext modulContext : fBindedModulContexts) {
			if (!modulId.equals(modulContext.getModulId())) continue;
			return modulContext;
		}
		return null;
	}
	
	/*******************************************
	 * Socket
	 ******************************************/
	
	/**
	 * Blocking wait for browser connection.
	 */
	private java.net.Socket waitForBrowserConnection(java.net.ServerSocket serverSocket) throws IOException {
		java.net.Socket socket = serverSocket.accept();
		return socket;
	}

	/**
	 * Read json message from socket.
	 */
	@CheckForNull
	private JsonObject readMessage(java.net.Socket socket, StringBuffer stringBufferCache) throws IOException {
		String jsonString = getJsonObjectFromBuffer(stringBufferCache);
		if (jsonString != null) {
			return JsonUtil.parseToJsonObject(jsonString);
		}
		readNewMessageFromSocket(socket, stringBufferCache);
		return null;
	}
	
	/**
	 * Read json message from buffer.
	 */
	@CheckForNull
	private String getJsonObjectFromBuffer(StringBuffer stringBufferCache) {
		if (stringBufferCache.length() == 0) return null;
		if(!stringBufferCache.toString().startsWith("{")) {
			throw new RuntimeException("Json telegram don't start with {");
		}
		int jsonEndIndex = 0;
		for (int index = 0; index < stringBufferCache.length(); index++) {
			
			if (stringBufferCache.charAt(index) != '}') continue;
					
			if (index + 1 < stringBufferCache.length()) {
				if (stringBufferCache.charAt(index + 1) == '{') {
					jsonEndIndex = index + 1;
					break;
				}
			} 
			if (index + 1 == stringBufferCache.length()) {
				jsonEndIndex = index + 1;
				break;
			}
		}
		if (jsonEndIndex == 0) {
			throw new RuntimeException("Json telegram don't end with }");
		}
		
		String jsonString =  stringBufferCache.substring(0, jsonEndIndex);
		stringBufferCache.delete(0, jsonEndIndex);
		return jsonString;
	}
	
	/**
	 * Read message from socket.
	 */
	private void readNewMessageFromSocket(java.net.Socket socket, StringBuffer stringBufferCache) throws IOException{
		org.eclipse.core.runtime.Assert.isNotNull(socket);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		if (!bufferedReader.ready()) return;
		char[] buffer = new char[5000];
		int bufferSize = bufferedReader.read(buffer, 0, 5000);
		stringBufferCache.append(buffer, 0, bufferSize);
	}
	
	/**
	 *  Write message to socket.
	 */
	private void writeMessage(java.net.Socket socket, String nachricht) throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		printWriter.print(nachricht);
		printWriter.flush();
	}

}
