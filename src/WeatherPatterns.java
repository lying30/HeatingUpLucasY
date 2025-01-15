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

        int counter[] = new int[temperatures.length];
        counter[0] = 1;
        int longestCount;
        if (temperatures.length == 1){
            return 1;
        }
        // Count and keep each day with their corresponding count pointing to its day
        int j = 1;
        for (int i = 1; i < temperatures.length; i++) {
            int current = temperatures[i];
            if (current > temperatures[j-1]) {
                counter[i] = counter[i-1] + 1;
                // 73 75 74 76 77 79 78
                // 01 02 02 03 04 05 05
                j++;
            }
            else if (current < temperatures[i-1]) {
                counter[i] = counter[i-1];

            }
        }
        longestCount = temperatures.length - 1;
        return counter[longestCount];
    }
}
