
public class RemoveElement {
    public static void main(String[] args) {

        // 1) المصفوفة الأصلية
        int[] arr = {1, 2, 3, 4, 5};
        int elementToRemove = 3;

        // 2) إنشاء مصفوفة جديدة بحجم أقل بعنصر واحد
        int[] newArr = new int[arr.length - 1];

        int index = 0; // مؤشر المصفوفة الجديدة

        // 3) نسخ العناصر عدا العنصر المراد حذفه
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != elementToRemove) {
                newArr[index] = arr[i];
                index++;
            }
        }

        // 4) طباعة المصفوفة الجديدة
        System.out.print("Array after removing " + elementToRemove + ": ");
        for(int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
