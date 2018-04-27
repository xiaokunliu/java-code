package com.crazysales.httprest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.crazysal.ebay.listing.SynceBayItems;

/**
 *
 * @author laudin
 *
 */
@Path("/syncitem")
@Component
public class SyncItemApi {
	
	@GET
	@Path("/all")
	@Produces(ApiConstant.APPLICATION_JSON_UTF8)
	public Response runAll() {
		//EbayResponse response = SynceBayItems.run(new String[]{});
		SynceBayItems.main(new String[]{});
		return Response.ok().entity("OK").build();
	}
	
	@GET
	@Path("/{d}/{pid}")
	@Produces(ApiConstant.APPLICATION_JSON_UTF8)
	public Response runDPid(@PathParam("d") String d, @PathParam("pid") String pid) {
		//EbayResponse response = SynceBayItems.run(new String[]{d, pid});
		SynceBayItems.main(new String[]{d, pid});
		return Response.ok().entity("OK").build();
	}
	
	@GET
	@Path("/{pid}/{p}")
	@Produces(ApiConstant.APPLICATION_JSON_UTF8)
	public Response runPidP(@PathParam("pid") String pid, @PathParam("p") String p) {
		//EbayResponse response = SynceBayItems.run(new String[]{pid, p});
		SynceBayItems.main(new String[]{pid, p});
		return Response.ok().entity("OK").build();
	}
	
	@GET
	@Path("/{d}/{pid}/{p}")
	@Produces(ApiConstant.APPLICATION_JSON_UTF8)
	public Response runDPidP(@PathParam("d") String d, @PathParam("pid") String pid, @PathParam("p") String p) {
		//EbayResponse response = SynceBayItems.run(new String[]{d, pid, p});
		SynceBayItems.main(new String[]{d, pid, p});
		return Response.ok().entity("OK").build();
	}
	
	@GET
	@Path("/{pid}")
	@Produces(ApiConstant.APPLICATION_JSON_UTF8)
	public Response runPid(@PathParam("pid") String pid) {
		//EbayResponse response = SyncItemBoostrap.run(new String[]{pid});
		SynceBayItems.main(new String[]{pid});
		return Response.ok().entity("OK").build();
	}

}
