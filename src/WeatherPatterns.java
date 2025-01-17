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
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        if (temperatures.length == 0){
            return 0;
        }
        int counter[] = new int[temperatures.length];
        counter[0] = 1;
        int longestCount = 1;

        // Count and keep each day with their corresponding count pointing to its day
        for (int i = 1; i < temperatures.length; i++) {
            counter[i] = 1;
            for (int j = 0; j < i; j++) {
                if (temperatures[i] > temperatures[j] && counter[i] < counter[j] + 1) {
                    // If longer one found update count
                    counter[i] = counter[j] + 1;
                 }
            }
            // Update the winning longest count as we go
            longestCount = Math.max(longestCount, counter[i]);
        }
        return longestCount;
    }
}
