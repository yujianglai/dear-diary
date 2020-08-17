/**
 * 模拟Linux文件用数字赋权
 * 之前在安防门禁里面我给APP做的操作权限判断算法类似，跟Linux的文件权限的数字规则异曲同工。
 */
public class Test {
    public static void main(String[] args) {
        // 可扩展的文件权限修改方案，暂实现读写可执行（421），支持扩展新增的权限数字
        chmodRight(1);
        chmodRight(2);
        chmodRight(4);
        chmodRight(3);
        chmodRight(5);
        chmodRight(6);
        chmodRight(7);
        chmodRight(8);
        chmodRight(9);
        chmodRight(10);
        chmodRight(11);
        chmodRight(12);
        chmodRight(13);
        chmodRight(14);
        chmodRight(15);
    }

    private static void chmodRight(int i) {
        //读写可执行（421）
        int[] rightArr = new int[]{4,2,1,8};
        System.out.println("right sum: " + i);
        System.out.println("hasReadRight: " + hasRight(i, 4, rightArr));
        System.out.println("hasWriteRight: " + hasRight(i, 2, rightArr));
        System.out.println("hasExecRight: " + hasRight(i, 1, rightArr));
        System.out.println("hasExtRight: " + hasRight(i, 8, rightArr));
        System.out.println("----------------------------------------");
    }

    /**
     * 根据传入的所有权限的数组、要赋权限加和以及要判断的权限数字，判断是否具有该权限
     * @param sum 要赋权限加和
     * @param right 要判断的权限
     * @param rightArr 已知的权限数组
     * @return 是否具有该权限
     */
    private static boolean hasRight(int sum, int right, int[] rightArr) {
        if (ArrayUtils.isEmpty(rightArr) || !ArrayUtils.contains(rightArr, right)) {
            return false;
        }
        if (sum < right) {
            return false;
        }
        int[] tempArr = ArrayUtils.removeElement(rightArr, right);
        sum -= right;
        Arrays.sort(tempArr);
        for (int x = tempArr.length - 1; x >= 0; x--) {
            if (sum >= tempArr[x]) {
                sum -= tempArr[x];
            }
            if (sum == 0){
                return true;
            }
        }
        return false;
    }
}
