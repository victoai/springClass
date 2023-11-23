package com.aa.bb;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionUserCounter implements HttpSessionListener {
	  //private static Logger logger = LoggerFactory.getLogger(SessionUserCounter.class);
	  
	  //  총 접속자 수
	  public static int count;
	  
	  public static int getCount() {
	    return count;
	  }

	  @Override
	  public void sessionCreated(HttpSessionEvent event) {
	    //  세션이 생성될 때 세션객체를 꺼내옴.
	    HttpSession session = event.getSession();
	    count ++;
	    //logger.error("\n\tSESSION CREATED : {}, TOTAL ACCESSER : {}", session.getId(), count);
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent event) {
	    // 세션이 소멸될 때
	    count--;
	    if( count < 0 ) count = 0;
	    
	    HttpSession session = event.getSession();
	   // logger.error("\n\tSESSION DESTROYED : {}, TOTAL ACCESSER : {}", session.getId(), count);
	  }
	  
	}