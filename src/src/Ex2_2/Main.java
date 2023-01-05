package Ex2_2;

public class Main
{
    public static void main(String[] args)
    {
        TaskType tt1 = TaskType.COMPUTATIONAL;
        System.out.println(tt1);

        TaskType tt2 = TaskType.IO;
        System.out.println(tt2);

        TaskType tt3 = TaskType.OTHER;
        System.out.println(tt3);

        System.out.println(tt1.getPriorityValue());
        System.out.println(tt2.getPriorityValue());
        System.out.println(tt3.getPriorityValue());

        tt1.setPriority(9);
        System.out.println(tt1.getPriorityValue());
        System.out.println(tt1);
        System.out.println(tt1.getType());

    }
}
