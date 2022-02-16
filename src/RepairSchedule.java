import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    //(a)  Write the constructor, in which you initialize the instance variables:
    // numberOfMechanics should be set to n and schedule should be set an empty ArrayList.
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        /* to be implemented in part (a) */
        schedule = new ArrayList<>();
        numberOfMechanics = n;

    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        /* to be implemented in part (b) */
        boolean mechFound = false;
        boolean bayFound = false;
        for (CarRepair ap : schedule){
            if (ap.getBayNum() == b){
                bayFound = true;
                return false;
            }
            if (ap.getMechanicNum() == m){
                mechFound = true;
                return false;
            }
        }
        if (!mechFound && !bayFound){
            schedule.add(new CarRepair(m, b));
            return true;
        }

        return false; // STUB VALUE
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        /* to be implemented in part (c) */
        int num = numberOfMechanics;
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i = 1; i <= num; i++) {
            int count = 0;
            for (CarRepair mech: schedule){
                if (mech.getMechanicNum() == i){
                    count++;
                }
            }
            if (count == 0){
                returnList.add(i);
            }

        }

        return returnList; // STUB VALUE
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}