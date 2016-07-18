package Government;
import java.applet.*;import java.awt.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class TimeKeeper implements Runnable {
	
	Communicator Class_Communicator;
	
	boolean threadSuspended;
	Thread t = null;
	int i = 0;
	int curX, curY; 
	Color CursorColor = Color.yellow;
	int rect1xco,rect1yco,rect1width,rect1height; 
	boolean rect1Clicked; 
	boolean mouseEntered; 
	
	public TimeKeeper(Communicator Class_CommunicatorT) {
		//System.out.println("TimeKeeper created");
		Class_Communicator = Class_CommunicatorT;
	}
	
	public void Startup() {
		//System.out.println("TimeKeeper started");
		
		start();
	}

	   public void init() {
		   
	   }

	   public void destroy() {
	   }

	   public void start() {
	      if ( t == null ) {
	         t = new Thread( this );
	         threadSuspended = false;
	         t.start();
	      } else {
	         if ( threadSuspended ) {
	            threadSuspended = false;
	            synchronized( this ) {
	               notify();
	            }
	         }
	      }
	   }

	   public void stop() {
	      threadSuspended = true;
	   }

	   public void run() {
		   
	      try {
	         while (true) {
	            ++i;
	            if ( i == 10 ) {
	               i = 0;
	            }
	            if ( threadSuspended ) {
	               synchronized( this ) {
	                  while ( threadSuspended ) {
	                     wait();
	                  }
	               }
	            }
	            Class_Communicator.HourTick();
	            t.sleep( 100 );  // interval given in milliseconds
	         }
	      } catch (InterruptedException e) { 
	    	  
	      }
	   }

	   public void paint( Graphics g ) {

	   }
}
