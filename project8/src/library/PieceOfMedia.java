package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class PieceOfMedia implements Item {
	private int maxCheckOutTime;
	 /**
	   * Title of this item.
	   */
	  private String title;
	  
	  /**
	   * Due date for this item.  This value is null when not checked out.
	   */
	  private Date dueDate;
	  
	  /**
	   * Patron to whom this item is checked out.  This value is null when not checked out.
	   */
	  private Patron checkedOutTo;
	
	public PieceOfMedia(String givenTitle) {
		title = givenTitle;
	    dueDate = null;
	    checkedOutTo = null;
	}
	  
	public void setCheckOutTime(int days) {
		maxCheckOutTime = days;
	}
	
	public int getCheckOutTime() {
		return maxCheckOutTime;
	}
	  
	
	 @Override
	  public void checkOut(Patron p, Date now)
	  {
	    if (!isCheckedOut())
	    {
	      int checkOutDays = maxCheckOutTime;
	      
	      // use a GregorianCalendar to figure out the Date corresponding to
	      // midnight, 14 days from now
	      GregorianCalendar cal = new GregorianCalendar();
	      cal.setTime(now);
	      cal.add(Calendar.DAY_OF_YEAR, checkOutDays);
	      
	      // always set to 11:59:59 pm on the day it's due
	      cal.set(Calendar.HOUR_OF_DAY, 23);
	      cal.set(Calendar.MINUTE, 59);
	      cal.set(Calendar.SECOND, 59);     
	      
	      // convert back to Date object
	      dueDate = cal.getTime();
	      
	      checkedOutTo = p;      
	    }
	  }
	 
	  @Override
	  public boolean isOverdue(Date now)
	  {
	    if (!isCheckedOut())
	    {
	      return false;
	    }
	    return now.after(dueDate);
	  }

	  @Override
	  public int compareTo(Item other)
	  {
	    return title.compareTo(other.getTitle());
	  }

	  @Override
	  public String getTitle()
	  {
	   return title;
	  }

	  @Override
	  public boolean isCheckedOut()
	  {
	    return dueDate != null;
	  }

	  @Override
	  public Date getDueDate()
	  {
	    return dueDate;
	  }

	  @Override
	  public Patron getPatron()
	  {
	    return checkedOutTo;
	  }
}
