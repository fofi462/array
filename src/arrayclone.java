public class arrayclone {


    public static void main(String[] args) {

        // 1) original array
        int[] originalArray = {1, 2, 3, 4, 5};

        // 2) cloned array with same length
        int[] clonedArray = new int[originalArray.length];

        // 3) cloning using loop
        for(int i = 0; i < originalArray.length; i++) {
            clonedArray[i] = originalArray[i];
        }

        // 4) printing arrays
        System.out.println("Original Array:");
        for(int i = 0; i < originalArray.length; i++) {
            System.out.print(originalArray[i] + " ");
        }

        System.out.println("\nCloned Array:");
        for(int i = 0; i < clonedArray.length; i++) {
            System.out.print(clonedArray[i] + " ");
        }
    }

}