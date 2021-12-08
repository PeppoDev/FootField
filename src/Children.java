
public class Children implements Runnable {
    private Ball ball;
    private int skill;
    private String name;
    // thread
    private Thread t;

    public Children(String tName, Ball ball) {
        this.ball = ball;
        this.skill = this.generateSkill();
        this.name = tName;

        this.t = new Thread(this, name);
    }

    public void ignite() {
        // set priority
        this.t.setPriority(this.skill);

        this.t.start();

        try {
            this.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // for priority
    public int generateSkill() {
        // in seconds
        double a = Math.floor(Math.random() * (10 - 3 + 1) + 3);
        return (int) a;
    }

    public int getSkillInMili() {
        return this.skill * 1000;
    }

    public void loseBall() {
        this.ball = null;
    }

    @Override
    public void run() {
        System.out.println("Ball belongs to " + this.name + " with priority " + this.skill);
        ball.setPossessor(this);
    }

}
