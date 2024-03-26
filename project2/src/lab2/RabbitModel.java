package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
  private int rabbitPopulation;
  private int lastYearPopulation;
  private int yearBeforePopulation;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    rabbitPopulation = 0;
    lastYearPopulation = 1;
    yearBeforePopulation = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    return rabbitPopulation;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	int yearBefore = rabbitPopulation;
	
	// updating population for new year
    rabbitPopulation = lastYearPopulation + yearBeforePopulation;
    int lastYear = rabbitPopulation;
    
    // setting new values for past 2 years
    lastYearPopulation = lastYear;
    yearBeforePopulation = yearBefore;
    
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  rabbitPopulation = 0;
	  lastYearPopulation = 1;
	  yearBeforePopulation = 0;
  }
}
