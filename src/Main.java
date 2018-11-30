import java.util.Random;

public class Main {

    /**
     * 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位：秒
     *
     * @param stack
     * @param opCount
     * @return
     */
    private static double testQueue(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 10000000;

        Stack stack = new ArrayStack();
        double time1 = testQueue(stack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        stack = new LinkedListStack();
        double time2 = testQueue(stack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        //这个时间比较复杂，因为LinkedListStack中包含更多的new操作
    }
}
