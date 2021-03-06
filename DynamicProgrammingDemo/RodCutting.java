

public class RodCutting {

    public int cutForBestPrice(int[] prices, int length) {
        // Validations
        if (prices == null || prices.length == 0) {
            return 0;
        }

        if (length <=0) {
            return 0;
        }

        // Keep the best price for each part in different sizes (from 0 to 'length').
        int[] tmp = new int[length + 1];
        tmp[0] = 0;

        // Compute the best price for each size of rod
        for (int i=1; i<=length; i++) {
            int best = Integer.MIN_VALUE;

            for (int j=1; j<i; j++) {
                int price = tmp[j] + tmp[i-j];
                best = Math.max(best, price);
            }

            // find the price of length, if we can.
            if (i <= prices.length) {
                best = Math.max(best, prices[i-1]);
            }

            tmp[i] = best;
        }

        return tmp[length];

    }


    public static void main(String[] args) {
        RodCutting test1 = new RodCutting();

        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        
        int length = 4;
        System.out.println("Rod cutting test: " + length + " => " +
                test1.cutForBestPrice(null, length));

        for (int i=0; i<= (prices.length + 15); i++) {
            length = i;
            System.out.println("Rod cutting test" + i + ": " + length + " => " +
                test1.cutForBestPrice(prices, length));

        }

    }
}