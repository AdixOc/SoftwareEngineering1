import java.util.ArrayList;
import java.util.HashSet;

public class SeqSorter {
    private final String[][] dependencies;

    public SeqSorter(String[][] dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Checks if a given sequence fulfills the depencies
     *
     * @param seq A sequence containing Jobs
     * @return a Boolean whether the given sequence is valid
     */
    public boolean isWellSorted(String[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Sequence can't be empty!");
        }

        HashSet<String> isDone = new HashSet<>(); // Contains every already done job
        for (int i = 0; i < seq.length - 1; i++) {
            String currJob = seq[i]; // Current job in the sequence
            ArrayList<String> dependecies = getDependencies(currJob); // List that contains every job that has to be completed before currJob can be done
            for (String d : dependecies) {
                if (!isDone.contains(d)) { // If a dependency needed for currJob is contained within isDone the return false
                    return false;
                }
            }
            isDone.add(currJob);
        }
        return true;
    }

    /**
     * Searches for every job that needs to be completed for a given job
     *
     * @param job Job to search depencies for
     * @return ArrayList<String> containing the dependent job for the given job
     */
    public ArrayList<String> getDependencies(String job) {
        ArrayList<String> res = new ArrayList<>();
        for (String[] curr : this.dependencies) {
            if (curr[1].equals(job)) {
                res.add(curr[0]);
            }
        }
        return res;
    }
}
