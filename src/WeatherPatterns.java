/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Lucas Ying
 */

public class WeatherPatterns {
    /**
     * Longest Warming Trend
     *
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // Handles edge case when there are no temperatures
        if (temperatures.length == 0) {
            return 0;
        }

        // This array storing longest increasing sequence
        int[] counter = new int[temperatures.length];
        int longestCount = 1;

        // Initialize the computation for each day. The loop starts from each
        // temperature and uses the helper function to calculate and memoize the
        // length of the longest sequence starting from that index.
        for (int i = 0; i < temperatures.length; i++) {
            // Update the winning longest count as we go
            longestCount = Math.max(longestCount, findLongestFrom(i, temperatures, counter));
        }
        // Returns longest sequence
        return longestCount;
    }

    private static int findLongestFrom(int current, int[] temperatures, int[] info) {
        // Return the already computed result if available
        if (info[current] != 0){
            return info[current];
        }

        // Initialize the longest sequence length with 1 as the minimum length
        int maxLength = 1;

        // Recursively check all subsequent elements to see if a longer subsequence can be formed.
        for (int next = current + 1; next < temperatures.length; next++) {
            if (temperatures[next] > temperatures[current]) {
                maxLength = Math.max(maxLength,1 + findLongestFrom(next, temperatures, info));
            }
        }
        info[current] = maxLength;
        return maxLength;
    }
}

