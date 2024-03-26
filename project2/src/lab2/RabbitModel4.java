package lab2;

import java.util.Random;
/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  private int rabbitPopulation;
  Random rand = new Random();
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
    rabbitPopulation = 500;
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
    rabbitPopulation += rand.nextInt(9);
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    rabbitPopulation = 500;
  }
}
