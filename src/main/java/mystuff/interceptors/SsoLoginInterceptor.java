package mystuff.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.uhn.fhir.interceptor.api.Pointcut;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;

@Interceptor
public class SsoLoginInterceptor
{

   private int myRequestCount;

   public int getRequestCount() {
      return myRequestCount;
   }

   /**
    * Override the incomingRequestPreProcessed method, which is called
    * for each incoming request before any processing is done
    */
   @Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_PROCESSED)
   public boolean incomingRequestPreProcessed(HttpServletRequest theRequest, HttpServletResponse theResponse) {
      myRequestCount++;
		System.out.println("myRequestCount : " + myRequestCount);
		System.out.println("theRequestgetPathInfo : " + theRequest.getPathInfo());
		System.out.println("theRequestgetPathTranslated : " + theRequest.getPathTranslated());
      
      return true;
   }
   
}