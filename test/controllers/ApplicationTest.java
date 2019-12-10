package controllers;

import org.junit.Test;

import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

public class ApplicationTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("高海 千歌"));
        assertTrue(contentAsString(result).contains("はじめて"));
        assertTrue(contentAsString(result).contains("はじめて食べたmikann"));
        assertTrue(contentAsString(result).contains("1900/01/01 00:00:00"));
    }
    
    @Test
    public void testCreate() {
    	Http.RequestBuilder c_request = new Http.RequestBuilder()
                .method(GET)
                .uri("/create?id=&name=SAMPLE_name&title=SAMPLE_title&message=SAMPLE_message");
    	
        Result c_result = route(app, c_request);
        System.out.println(c_result.status());
        assertEquals(SEE_OTHER, c_result.status());
         
        Http.RequestBuilder i_request = new Http.RequestBuilder()
                .method(GET)
                .uri("/");
 
        Result i_result = route(app, i_request);
        System.out.println(contentAsString(i_result));
        assertTrue(contentAsString(i_result).contains("SAMPLE_name"));
        assertTrue(contentAsString(i_result).contains("SAMPLE_title"));
        assertTrue(contentAsString(i_result).contains("SAMPLE_message"));
        
        }
}

//System.out.println(contentAsString(result));
