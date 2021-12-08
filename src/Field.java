public class Field {
    public static void play() {
        Ball ball = new Ball();

        Children ch1 = new Children("João", ball);
        Children ch2 = new Children("Pedro", ball);
        Children ch3 = new Children("Lucas", ball);
        Children ch4 = new Children("Geo", ball);
        Children ch5 = new Children("Jonas", ball);
        Children ch6 = new Children("Ruan", ball);
        Children ch7 = new Children("Bruno", ball);
        Children ch8 = new Children("Ramon", ball);
        Children ch9 = new Children("Vicente", ball);
        Children ch10 = new Children("Yvyllys", ball);

        ch1.ignite();
        ch2.ignite();
        ch3.ignite();
        ch4.ignite();
        ch5.ignite();
        ch6.ignite();
        ch7.ignite();
        ch8.ignite();
        ch9.ignite();
        ch10.ignite();
    }
}
