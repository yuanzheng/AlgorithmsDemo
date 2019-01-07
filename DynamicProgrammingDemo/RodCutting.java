

public class RodCutting {

    public int cutForBestPrice(int[] prices, int length) {
        // Validations
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // Cannot find the prices for the piece of whole rod
        if (length <=0 || length >= prices.length) {
            return 0;
        }

        // Keep the best price for each part in different sizes (from 0 to 'length').
        int[] tmp = new int[length + 1];

        tmp[0] = 0;

        // Compute the best price for each size of rod
        for (int i=1; i<=length; i++) {
            int best = Integer.MIN_VALUE;

            for (int j=1; j<=i; j++) {
                int price = prices[j] + tmp[i-j];
                best = Math.max(best, price);
            }

            tmp[i] = best;
        }

        return tmp[length];

    }


    public static void main(String[] args) {
        RodCutting test1 = new RodCutting();

        int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int length = 9;
        System.out.println("Rod cuttingm test1: " + length + " => " +
                test1.cutForBestPrice(prices, length));

        System.out.println("Rod cutting test2: " + length + " => " +
                test1.cutForBestPrice(null, length));

        length = 0;
        System.out.println("Rod cutting test3: " + length + " => " +
                test1.cutForBestPrice(prices, length));

        length = 1;
        System.out.println("Rod cutting test4: " + length + " => " +
                test1.cutForBestPrice(prices, length));

        length = 10;
        System.out.println("Rod cutting test5: " + length + " => " +
                test1.cutForBestPrice(prices, length));

        length = 11;
        System.out.println("Rod cutting test6: " + length + " => " +
                test1.cutForBestPrice(prices, length));

    }
}