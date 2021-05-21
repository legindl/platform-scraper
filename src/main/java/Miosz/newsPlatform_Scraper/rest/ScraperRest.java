package Miosz.newsPlatform_Scraper.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Miosz.newsPlatform_Scraper.BLL.Scraper;
import org.json.JSONObject;

@Path("/scraper")
public class ScraperRest {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void get(){
        System.out.println("Scraper running");
    }

    @GET
    @Path("/{id}/{url}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewsContent(@PathParam("url") String encodedUrl,
                                   @PathParam("id") String id){
        JSONObject json = new JSONObject();
        json.put("id",id);
        System.out.println(encodedUrl);
        String decodedUrl = encodedUrl.replaceAll("#","/");
        System.out.println(decodedUrl);
        System.out.println("Scraping: " + id);
        String newsContent = new Scraper().scrapeNews(decodedUrl);
        json.put("content",newsContent);
        System.out.println(json);
        return Response.ok(json.toString(), MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
    }
}