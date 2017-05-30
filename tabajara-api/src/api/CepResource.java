/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package api;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import dto.CidadeDTO;
import service.CepService;

@Path("/ceps")
public class CepResource {
	
	@Inject
	private CepService cepService;

	@GET
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public String getCidadeByCep() {
		return "teste";
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN+";charset=utf-8")
	public String insertCep(String jsonString) {
		/*Gson gson = new Gson();
		CidadeDTO cidadeDTO = gson.fromJson(jsonString, CidadeDTO.class); 
		cepService.addCidadeByCep(cidadeDTO);*/
		return "Inclus�so ok";
	}
}