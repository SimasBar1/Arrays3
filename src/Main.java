public class Main {
    public int MaxSpan(int[] nums) {
        if(nums.length < 1) return 0;
        int max = 1;

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    if((j - i + 1) > max) max = j - i + 1;
                }
            }
        }
        return max;
    }
    public int[] fix34(int[] nums){
        int[] four = new int[nums.length];
        int in = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] ==  4){
                four[in] = i;
                in++;
            }
        }
        in = 0;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 3){
                nums[four[in]] = nums[i + 1];
                nums[i + 1] = 4;
                in++;
            }
        }
        return nums;
    }
    public int[] fix45(int[] nums){
        int[] position = new int[nums.length];
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 5 && (i ==0 || nums[i - 1] != 4)){
                position[count++] = i;
            }
        }
        int fiveIndex = 0;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == 4 && nums[i + 1] !=5){
                int temp = nums[i + 1];
                nums[i + 1] = 5;
                nums[position[fiveIndex]] = temp;
                fiveIndex++;
            }
        }
        return nums;
    }
    public boolean canBalance(int[] nums) {
        int Sum = 0;

        for (int num : nums) {
            Sum += num;
        }

        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            if (left * 2 == Sum) {
                return true;
            }
        }

        return false;
    }
    public boolean linearIn(int[] outer, int[] inner) {
        int outerIndex = 0;
        int innerIndex = 0;

        while (outerIndex < outer.length && innerIndex < inner.length) {
            if (outer[outerIndex] < inner[innerIndex]) {
                outerIndex++;
            } else if (outer[outerIndex] == inner[innerIndex]) {
                innerIndex++;
                outerIndex++;
            } else {
                return false;
            }
        }
        return innerIndex == inner.length;
    }
    public int[] squareUp(int n) {
        int[] result = new int[n * n];

        for (int i = 1; i <= n; i++) {
            int index = i * n - 1;

            for (int j = 1; j <= i; j++) {
                result[index--] = j;
            }
        }
        return result;
    }
    public int[] seriesUp(int n) {
        int total = n * (n + 1) / 2;
        int[] result = new int[total];
        int in = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                result[in++] = j;
            }
        }
        return result;
    }
    public int maxMirror(int[] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int length = 0;

                while (i + length < n && j - length >= 0 && nums[i + length] == nums[j - length]) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;
    }
    public int countClumps(int[] nums) {
        int clumps = 0;
        boolean inClump = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (!inClump) {
                    clumps++;
                    inClump = true;
                }
            } else {
                inClump = false;
            }
        }
        return clumps;
    }
}