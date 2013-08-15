package com.rest.get;

import java.io.InputStream;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import com.rest.model.Hosts;

@Path("/rest")
public class GetAllHosts {

	@GET()
	@Path("/GetAllHosts")
	@Produces("text/xml")
	public Response getAllHosts() {
		Hosts cmil402 = new Hosts();

		try {

			ObjectMapper mapper = new ObjectMapper();
			 
			InputStream is = GetAllHosts.class.getClassLoader().getResourceAsStream("hosts.json");
			
			cmil402 = mapper.readValue(is, Hosts.class);

			/*
			 * JSONParser jp = new JSONParser();
			 * 
			 * File f = new
			 * File(GetAllHosts.class.getClassLoader().getResource("hosts.json"
			 * ).getPath());
			 * 
			 * System.out.println(f.getAbsolutePath()); FileReader fr = new
			 * FileReader(f); JSONArray jarr = (JSONArray)jp.parse(fr);
			 * 
			 * for (Object object : jarr) { JSONObject jobj =
			 * (JSONObject)object;
			 * 
			 * cmil402.setName(jobj.get("name").toString());
			 * cmil402.setUser(jobj.get("user").toString());
			 * cmil402.setPassword(jobj.get("password").toString()); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).type(MediaType.TEXT_XML).entity(cmil402)
				.build();
	}

	@GET()
	@Path("/GetAllHostsJSON")
	@Produces("application/json")
	public Response getAllHostsAsJSON() {
		Hosts cmil402 = new Hosts();

		try {

			ObjectMapper mapper = new ObjectMapper();
			InputStream is = GetAllHosts.class.getClassLoader()
					.getResourceAsStream("hosts.json");

			cmil402 = mapper.readValue(is, Hosts.class);

			/*
			 * JSONParser jp = new JSONParser();
			 * 
			 * File f = new
			 * File(GetAllHosts.class.getClassLoader().getResource("hosts.json"
			 * ).getPath());
			 * 
			 * System.out.println(f.getAbsolutePath()); FileReader fr = new
			 * FileReader(f); JSONArray jarr = (JSONArray)jp.parse(fr);
			 * 
			 * for (Object object : jarr) { JSONObject jobj =
			 * (JSONObject)object;
			 * 
			 * cmil402.setName(jobj.get("name").toString());
			 * cmil402.setUser(jobj.get("user").toString());
			 * cmil402.setPassword(jobj.get("password").toString()); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(cmil402).build();
	}
}