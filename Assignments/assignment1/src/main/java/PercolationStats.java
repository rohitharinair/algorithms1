/**
 * This class runs Percolation simulation and calculates the statistics.
 */
public class PercolationStats {

    public PercolationStats(int n, int t) {
    }

    public double mean() {
        return 0f;
    }

    public double stddev() {
        return 0f;
    }

    public double confidenceLo() {
        return 0d;
    }

    public double confidenceHi() {
        return 0d;
    }

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(10, 20);
        // print the stats
        StdOut.printf("mean                    = %.15f\n", stats.mean());
        StdOut.printf("stddev                  = %.15f\n", stats.stddev());
        StdOut.printf("95%% confidence interval = %.15f, %.15f\n",
                stats.confidenceLo(), stats.confidenceHi());
    }
}
